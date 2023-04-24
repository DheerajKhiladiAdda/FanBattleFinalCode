package com.khiladiadda.in.network.model.response.hth;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CaptainResultHTH implements Parcelable {
    @SerializedName("points")
    @Expose
    private PointsHTH points;
    @SerializedName("score")
    @Expose
    private ScoreHTH score;
    @SerializedName("playing")
    @Expose
    private Integer playing;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("img")
    @Expose
    private String img;
    @SerializedName("p_id")
    @Expose
    private String pId;
    @SerializedName("role")
    @Expose
    private Integer role;
    @SerializedName("title")
    @Expose
    private String title;

    public PointsHTH getPoints() {
        return points;
    }

    public void setPoints(PointsHTH points) {
        this.points = points;
    }

    public ScoreHTH getScore() {
        return score;
    }

    public void setScore(ScoreHTH score) {
        this.score = score;
    }

    public Integer getPlaying() {
        return playing;
    }

    public void setPlaying(Integer playing) {
        this.playing = playing;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.points, flags);
        dest.writeParcelable(this.score, flags);
        dest.writeValue(this.playing);
        dest.writeString(this.id);
        dest.writeString(this.img);
        dest.writeString(this.pId);
        dest.writeValue(this.role);
        dest.writeString(this.title);
    }

    public void readFromParcel(Parcel source) {
        this.points = source.readParcelable(PointsHTH.class.getClassLoader());
        this.score = source.readParcelable(ScoreHTH.class.getClassLoader());
        this.playing = (Integer) source.readValue(Integer.class.getClassLoader());
        this.id = source.readString();
        this.img = source.readString();
        this.pId = source.readString();
        this.role = (Integer) source.readValue(Integer.class.getClassLoader());
        this.title = source.readString();
    }

    public CaptainResultHTH() {
    }

    protected CaptainResultHTH(Parcel in) {
        this.points = in.readParcelable(PointsHTH.class.getClassLoader());
        this.score = in.readParcelable(ScoreHTH.class.getClassLoader());
        this.playing = (Integer) in.readValue(Integer.class.getClassLoader());
        this.id = in.readString();
        this.img = in.readString();
        this.pId = in.readString();
        this.role = (Integer) in.readValue(Integer.class.getClassLoader());
        this.title = in.readString();
    }

    public static final Parcelable.Creator<CaptainResultHTH> CREATOR = new Parcelable.Creator<CaptainResultHTH>() {
        @Override
        public CaptainResultHTH createFromParcel(Parcel source) {
            return new CaptainResultHTH(source);
        }

        @Override
        public CaptainResultHTH[] newArray(int size) {
            return new CaptainResultHTH[size];
        }
    };

}
