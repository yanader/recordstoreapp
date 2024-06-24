package com.example.recordstoreapp.ui.mainactivity;

import android.content.Intent;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.recordstoreapp.R;
import com.example.recordstoreapp.databinding.ActivityMainBinding;
import com.example.recordstoreapp.model.Album;
import com.example.recordstoreapp.model.AlbumStockItem;
import com.example.recordstoreapp.model.GetByIdAlbum;
import com.example.recordstoreapp.model.UpdateAlbumItem;
import com.example.recordstoreapp.ui.updatealbum.UpdateAlbumActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {

    private RecyclerView recyclerView;
    private ArrayList<Album> albumList;
    private AlbumStockItem albumStockItem;
    private AlbumAdapter albumAdapter;
    private MainActivityViewModel mainActivityViewModel;
    private ActivityMainBinding activityMainBinding;
    private MainActivityClickHandler mainActivityClickHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        mainActivityClickHandler = new MainActivityClickHandler(this, mainActivityViewModel);
        activityMainBinding.setButtonClicker(mainActivityClickHandler);

        getAllAlbums();
    }

    private void getAllAlbums() {
        mainActivityViewModel.getData().observe(this, new Observer<List<Album>>() {
            @Override
            public void onChanged(List<Album> albumsFromLiveData) {

                albumList = (ArrayList<Album>) albumsFromLiveData;

                displayInRecyclerView();
            }
        });
    }

    private void displayInRecyclerView() {
        recyclerView = activityMainBinding.recyclerView;
        albumAdapter = new AlbumAdapter(albumList, this, this);
        recyclerView.setAdapter(albumAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        albumAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(int position) {

        Album album = albumList.get(position);
        long id = album.getAlbumId();

        mainActivityViewModel.getStockItemByID(id).observe(this, new Observer<GetByIdAlbum>() {
            @Override
            public void onChanged(GetByIdAlbum getByIdAlbum) {



                Intent intent = new Intent(MainActivity.this, UpdateAlbumActivity.class);
                intent.putExtra("AlbumStock", getByIdAlbum);
                intent.putExtra("Album", album);
                intent.putExtra("id", id);
                Log.i("positionCheck", "we're here");
                startActivity(intent);
                Log.i("positionCheck", "we're here");
                }
            });


    }
}