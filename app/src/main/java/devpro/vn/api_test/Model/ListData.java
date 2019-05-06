package devpro.vn.api_test.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by nguye on 5/28/2018.
 */

public class ListData {

    @SerializedName("data")
    @Expose
    private ArrayList<ChapterModel> chapterModels = new ArrayList<>();

    public ArrayList<ChapterModel> getChapterModels() {
        return chapterModels;
    }

    public void setChapterModels(ArrayList<ChapterModel> chapterModels) {
        this.chapterModels = chapterModels;
    }
}
