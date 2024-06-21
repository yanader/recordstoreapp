package com.example.recordstoreapp.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import com.example.recordstoreapp.BR;
import com.google.gson.annotations.SerializedName;

public class AlbumToAdd extends BaseObservable {

    @SerializedName("albumName")
    String albumName;
    @SerializedName("artistName")
    String artistName;
    @SerializedName("genre")
    String genre;
    @SerializedName("releaseDate")
    String releaseDate;
    @SerializedName("priceInPence")
    int priceInPence;

    public AlbumToAdd(String albumName, String artistName, String genre, String releaseDate, int priceInPence) {
        this.albumName = albumName;
        this.artistName = artistName;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.priceInPence = priceInPence;
    }

    public AlbumToAdd() {
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

    @Bindable
    public int getPriceInPence() {
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

    public void setPriceInPence(int priceInPence) {
        this.priceInPence = priceInPence;
        notifyPropertyChanged(BR.priceInPence);
    }
}
