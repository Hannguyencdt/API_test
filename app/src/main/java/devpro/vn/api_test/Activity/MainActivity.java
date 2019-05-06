package devpro.vn.api_test.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import devpro.vn.api_test.API.RestManager;
import devpro.vn.api_test.Model.ChapterModel;
import devpro.vn.api_test.Model.ListData;
import devpro.vn.api_test.R;
import devpro.vn.api_test.adpater.ChapterAdapter;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ArrayList<ChapterModel> characters;
    private RecyclerView rcChapter;
    private ChapterAdapter chapterAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        characters = new ArrayList<>();

        this.rcChapter = findViewById(R.id.rcChapter);

        this.characters = new ArrayList<>();
        this.chapterAdapter = new ChapterAdapter(MainActivity.this, characters );
        this.rcChapter.setHasFixedSize(true);
        this.rcChapter.setLayoutManager(new LinearLayoutManager(this));
        this.rcChapter.setAdapter(chapterAdapter);



        final Gson gson = new Gson();
        Call<ResponseBody> call = RestManager.getApi().getData();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()){
                    Log.d("HanCDT", "isSuccessful ");
                    try {
                        String data = response.body().string();
                        ListData listData = gson.fromJson(data, ListData.class);
                        characters = listData.getChapterModels();
                        for (ChapterModel model : characters) {
                            Log.d("HanCDT", "title"+model.getTitle());
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    Log.d("HanCDT", "false");

                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("HanCDT", "onFailure");
            }
        });


    }
}
