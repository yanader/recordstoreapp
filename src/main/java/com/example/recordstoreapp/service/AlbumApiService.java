package com.example.recordstoreapp.service;

import com.example.recordstoreapp.model.Album;
import com.example.recordstoreapp.model.AlbumStockItem;
import com.example.recordstoreapp.model.GetByIdAlbum;
import com.example.recordstoreapp.model.UpdateAlbumItem;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface AlbumApiService {

    @GET("albums")
    Call<List<Album>> getAllAlbums();

    @POST("albums/add")
    Call<AlbumStockItem> addNewAlbum(@Body AlbumStockItem album);

    @PUT("albums/{id}")
    Call<UpdateAlbumItem> updateAlbum(@Body AlbumStockItem album, @Path("id") long id);

    @DELETE("albums/{id}")
    Call<Album> deleteAlbum(@Path("id") long id);

    @GET("albums/{id}")
    Call<GetByIdAlbum> getAlbumById(@Path("id") long id);
}
