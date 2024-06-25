package com.example.recordstoreapp.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import com.example.recordstoreapp.BR;
import com.google.gson.annotations.SerializedName;



public class Album extends BaseObservable implements Parcelable {

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

    protected Album(Parcel in) {
        albumId = in.readLong();
        albumName = in.readString();
        artistName = in.readString();
        genre = in.readString();
        releaseDate = in.readString();
    }

    public static final Creator<Album> CREATOR = new Creator<Album>() {
        @Override
        public Album createFromParcel(Parcel in) {
            return new Album(in);
        }

        @Override
        public Album[] newArray(int size) {
            return new Album[size];
        }
    };

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

    public boolean matchesArtistName(String search) {
        return this.artistName.toLowerCase().contains(search);
    }

    public boolean matchesAlbumName(String search) {
        return this.albumName.toLowerCase().contains(search);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeLong(albumId);
        dest.writeString(albumName);
        dest.writeString(artistName);
        dest.writeString(genre);
        dest.writeString(releaseDate);
    }

    @Override
    public String toString() {
        return "Album:\n" +
                this.albumName + " | " + this.artistName + " | " +
                this.genre + " | " + this.releaseDate + " | " + this.getAlbumId();
    }
}
