package devpro.vn.api_test.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import devpro.vn.api_test.Activity.MainActivity;
import devpro.vn.api_test.adpater.ChapterAdapter;

/**
 * Created by nguye on 5/28/2018.
 */

public class ChapterModel {


    @SerializedName("id")
    @Expose
private int id;
    @SerializedName("chapter")
    @Expose
private String chapter;
    @SerializedName("title")
    @Expose
private String title;
    @SerializedName("descriptionSort")
    @Expose
private String descriptionSort;
    @SerializedName("image")
    @Expose
private String image;

    public ChapterModel(MainActivity mainActivity, ArrayList<ChapterModel> characters) {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptionSort() {
        return descriptionSort;
    }

    public void setDescriptionSort(String descriptionSort) {
        this.descriptionSort = descriptionSort;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
