package devpro.vn.api_test.adpater;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;



import java.util.ArrayList;

import devpro.vn.api_test.Model.ChapterModel;
import devpro.vn.api_test.R;

/*** Created by Admin on 25/5/2018.
 */

public class ChapterAdapter extends RecyclerView.Adapter<ChapterAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<ChapterModel> chapterModels;

    public ChapterAdapter(Context mContext, ArrayList<ChapterModel> chapterModels) {
        this.mContext = mContext;
        this.chapterModels = chapterModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.item_chapter, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    public void addListChapter(ArrayList<ChapterModel> chapterModels) {
        this.chapterModels.clear();
        this.chapterModels.addAll(chapterModels);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        ChapterModel model = chapterModels.get(position);
        Picasso.get().load(model.getImage()).into(viewHolder.imgThump);
        viewHolder.tvTitle.setText(model.getTitle());
        viewHolder.tvDescription.setText(model.getDescriptionSort());
    }

    @Override
    public int getItemCount() {
        return chapterModels.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgThump;
        TextView tvTitle;
        TextView tvDescription;

        public ViewHolder(View itemView) {
            super(itemView);

            imgThump = itemView.findViewById(R.id.imgThump);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
        }
    }
}
