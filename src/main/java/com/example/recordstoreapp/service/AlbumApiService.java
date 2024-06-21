package com.example.recordstoreapp.service;

import com.example.recordstoreapp.model.Album;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface AlbumApiService {

    @GET("api/v1/recordstore/albums")
    Call<List<Album>> getAllAlbums();
}
