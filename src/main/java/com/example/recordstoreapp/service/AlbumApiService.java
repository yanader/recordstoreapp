package com.example.recordstoreapp.service;

import com.example.recordstoreapp.model.Album;
import com.example.recordstoreapp.model.AlbumToAdd;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;

public interface AlbumApiService {

    @GET("albums")
    Call<List<Album>> getAllAlbums();

    @POST("albums/add")
    Call<AlbumToAdd> addNewAlbum(@Body AlbumToAdd album);
}
