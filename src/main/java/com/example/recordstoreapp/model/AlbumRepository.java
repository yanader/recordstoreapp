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
    private MutableLiveData<GetByIdAlbum> mutableLiveStockItem = new MutableLiveData<>();
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
                mutableLiveData.setValue(albumList);
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable throwable) {
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
        Call<UpdateAlbumItem> albumCall = albumApiService.updateAlbum(albumStockItem, id);
        albumCall.enqueue(new Callback<UpdateAlbumItem>() {
            @Override
            public void onResponse(Call<UpdateAlbumItem> call, Response<UpdateAlbumItem> response) {
                Toast.makeText(application.getApplicationContext(), "Album updated", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<UpdateAlbumItem> call, Throwable throwable) {
                Toast.makeText(application.getApplicationContext(), "Update failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void deleteAlbum(long id) {
        AlbumApiService albumApiService = RetrofitInstance.getService();
        Call<Album> albumCall = albumApiService.deleteAlbum(id);
        albumCall.enqueue(new Callback<Album>() {
            @Override
            public void onResponse(Call<Album> call, Response<Album> response) {
                Toast.makeText(application.getApplicationContext(), "Album delete", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Album> call, Throwable throwable) {
                Toast.makeText(application.getApplicationContext(), "Delete failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public MutableLiveData<GetByIdAlbum> getAlbumStockById(long id) {
        AlbumApiService albumApiService = RetrofitInstance.getService();
        Call<GetByIdAlbum> albumStockCall = albumApiService.getAlbumById(id);

        albumStockCall.enqueue(new Callback<GetByIdAlbum>() {
            @Override
            public void onResponse(Call<GetByIdAlbum> call, Response<GetByIdAlbum> response) {
                mutableLiveStockItem.setValue(response.body());
            }
            @Override
            public void onFailure(Call<GetByIdAlbum> call, Throwable throwable) {
            }
        });

        return mutableLiveStockItem;
    }
}
