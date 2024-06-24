package com.example.recordstoreapp.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import com.example.recordstoreapp.BR;
import com.google.gson.annotations.SerializedName;

public class AlbumStockItem extends BaseObservable implements Parcelable {

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

    public AlbumStockItem(String albumName, String artistName, String genre, String releaseDate, String priceInPence) {
        this.albumName = albumName;
        this.artistName = artistName;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.priceInPence = priceInPence;
    }

    public AlbumStockItem() {
    }

    protected AlbumStockItem(Parcel in) {
        albumName = in.readString();
        artistName = in.readString();
        genre = in.readString();
        releaseDate = in.readString();
        priceInPence = in.readString();
    }

    public static final Creator<AlbumStockItem> CREATOR = new Creator<AlbumStockItem>() {
        @Override
        public AlbumStockItem createFromParcel(Parcel in) {
            return new AlbumStockItem(in);
        }

        @Override
        public AlbumStockItem[] newArray(int size) {
            return new AlbumStockItem[size];
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
}
