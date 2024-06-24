package com.example.recordstoreapp.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.gson.annotations.SerializedName;

public class GetByIdAlbum implements Parcelable {

    @SerializedName("albumId")
    String albumId;
    @SerializedName("albumName")
    String albumName;
    @SerializedName("artistName")
    String artistName;
    @SerializedName("quantity")
    String quantity;
    @SerializedName("priceInPounds")
    String priceInPounds;

    public GetByIdAlbum(String albumId, String albumName, String artistName, String quantity, String priceInPounds) {
        this.albumId = albumId;
        this.albumName = albumName;
        this.artistName = artistName;
        this.quantity = quantity;
        this.priceInPounds = priceInPounds;
    }

    public GetByIdAlbum() {
    }

    protected GetByIdAlbum(Parcel in) {
        albumId = in.readString();
        albumName = in.readString();
        artistName = in.readString();
        quantity = in.readString();
        priceInPounds = in.readString();
    }

    public static final Creator<GetByIdAlbum> CREATOR = new Creator<GetByIdAlbum>() {
        @Override
        public GetByIdAlbum createFromParcel(Parcel in) {
            return new GetByIdAlbum(in);
        }

        @Override
        public GetByIdAlbum[] newArray(int size) {
            return new GetByIdAlbum[size];
        }
    };

    public String getPriceInPence() {
        String priceInPenceString = String.valueOf(Double.parseDouble(this.priceInPounds) * 100);
        return priceInPenceString.substring(0, priceInPenceString.length() - 2);
    }

    public String getAlbumId() {
        return albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getPriceInPounds() {
        return priceInPounds;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setPriceInPounds(String priceInPounds) {
        this.priceInPounds = priceInPounds;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(albumId);
        dest.writeString(albumName);
        dest.writeString(artistName);
        dest.writeString(quantity);
        dest.writeString(priceInPounds);
    }

    @Override
    public String toString() {
        return "GetByIdAlbum:\n" +
                this.albumName + " | " + this.artistName + " | " +
                this.priceInPounds + " | " + this.quantity + " | " + this.getAlbumId();
    }
}
