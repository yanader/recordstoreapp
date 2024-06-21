package com.example.recordstoreapp.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import com.example.recordstoreapp.BR;
import com.google.gson.annotations.SerializedName;



public class Album extends BaseObservable {

    @SerializedName("albumId")
    long albumId;
    @SerializedName("albumName")
    String albumName;
    @SerializedName("artistName")
    String artistName;
    @SerializedName("genre")
    String genre;
    @SerializedName("releaseDate")
    String releaseDate;


    public Album(long albumId, String albumName, String artistName, String genre, String releaseDate) {
        this.albumId = albumId;
        this.albumName = albumName;
        this.artistName = artistName;
        this.genre = genre;
        this.releaseDate = releaseDate;
    }

    public Album() {
    }

    @Bindable
    public long getAlbumId() {
        return albumId;
    }

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

    public void setAlbumId(long albumId) {
        this.albumId = albumId;
        notifyPropertyChanged(BR.albumId);
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


}
