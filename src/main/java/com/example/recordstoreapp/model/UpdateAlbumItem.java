package com.example.recordstoreapp.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import com.example.recordstoreapp.BR;
import com.google.gson.annotations.SerializedName;

public class UpdateAlbumItem extends BaseObservable implements Parcelable {

    @SerializedName("albumName")
    String albumName;
    @SerializedName("artistName")
    String artistName;
    @SerializedName("genre")
    String genre;
    @SerializedName("releaseDate")
    String releaseDate;
    @SerializedName("priceInPence")
    String priceInPence;

    public UpdateAlbumItem(String albumName, String artistName, String genre, String releaseDate, String priceInPence) {
        this.albumName = albumName;
        this.artistName = artistName;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.priceInPence = priceInPence;
    }

    public UpdateAlbumItem() {
    }

    protected UpdateAlbumItem(Parcel in){
        albumName = in.readString();
        artistName = in.readString();
        genre = in.readString();
        releaseDate = in.readString();
        priceInPence = in.readString();
    }


    public static final Creator<UpdateAlbumItem> CREATOR = new Creator<UpdateAlbumItem>() {
        @Override
        public UpdateAlbumItem createFromParcel(Parcel in) {
            return new UpdateAlbumItem(in);
        }

        @Override
        public UpdateAlbumItem[] newArray(int size) {
            return new UpdateAlbumItem[size];
        }
    };

    @Bindable
    public String getAlbumName() {
        return albumName;
    }

    @Bindable
    public String getArtistName() {
        return artistName;
    }

    @Bindable
    public String getGenre() {
        return genre;
    }

    @Bindable
    public String getReleaseDate() {
        return releaseDate;
    }

    @Bindable
    public String getPriceInPence() {
        return priceInPence;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
        notifyPropertyChanged(BR.albumName);
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
        notifyPropertyChanged(BR.artistName);
    }

    public void setGenre(String genre) {
        this.genre = genre;
        notifyPropertyChanged(BR.genre);
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
        notifyPropertyChanged(BR.releaseDate);
    }

    public void setPriceInPence(String priceInPence) {
        this.priceInPence = priceInPence;
        notifyPropertyChanged(BR.priceInPence);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(albumName);
        dest.writeString(artistName);
        dest.writeString(genre);
        dest.writeString(releaseDate);
        dest.writeString(priceInPence);
    }

    @Override
    public String toString() {
        return "UpdateAlbumItem:\n" +
                this.albumName + " | " + this.artistName + " | " +
                this.genre + " | " + this.releaseDate + " | " + this.priceInPence;
    }
}
