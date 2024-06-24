package com.example.recordstoreapp.model;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;
import androidx.lifecycle.MutableLiveData;
import com.example.recordstoreapp.service.AlbumApiService;
import com.example.recordstoreapp.service.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class AlbumRepository {
    private MutableLiveData<List<Album>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public AlbumRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Album>> getMutableLiveData() {
        AlbumApiService albumApiService = RetrofitInstance.getService();
        Call<List<Album>> call = albumApiService.getAllAlbums();
        call.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                List<Album> albumList = response.body();
                Log.i("albumListLog", ""+response.code());
                Log.i("albumListLog", albumList.toString());
                Log.i("albumListLog", "ON SUCCESS");
                mutableLiveData.setValue(albumList);
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable throwable) {
                Log.i("albumListLog", "ON FAILURE");
                Log.i("albumListLog", throwable.getMessage());
            }
        });
        return mutableLiveData;
    }

    public void addNewAlbum(AlbumStockItem albumStockItem) {
        AlbumApiService albumApiService = RetrofitInstance.getService();
        Call<AlbumStockItem> albumCall = albumApiService.addNewAlbum(albumStockItem);
        albumCall.enqueue(new Callback<AlbumStockItem>() {

            @Override
            public void onResponse(Call<AlbumStockItem> call, Response<AlbumStockItem> response) {
                Toast toast = Toast.makeText(application.getApplicationContext(), "Album added", Toast.LENGTH_SHORT);
                toast.show();;

            }

            @Override
            public void onFailure(Call<AlbumStockItem> call, Throwable throwable) {
                Toast toast = Toast.makeText(application.getApplicationContext(), "Action Failed", Toast.LENGTH_SHORT);
                toast.show();;
            }
        });
    }

    public void updateAlbum(AlbumStockItem albumStockItem, long id) {
        AlbumApiService albumApiService = RetrofitInstance.getService();
        Call<AlbumStockItem> albumCall = albumApiService.updateAlbum(albumStockItem, id);
        albumCall.enqueue(new Callback<AlbumStockItem>() {
            @Override
            public void onResponse(Call<AlbumStockItem> call, Response<AlbumStockItem> response) {
                Toast.makeText(application.getApplicationContext(), "Album updated", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<AlbumStockItem> call, Throwable throwable) {
                Toast.makeText(application.getApplicationContext(), "Update failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
