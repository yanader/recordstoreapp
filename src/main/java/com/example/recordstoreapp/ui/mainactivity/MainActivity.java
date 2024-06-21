package com.example.recordstoreapp.ui.mainactivity;

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

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Album> albumList;
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
                // albums refers to the variable name of your List of Album objects
                // albumsFromLiveData is cast to this type

                albumList = (ArrayList<Album>) albumsFromLiveData;
//                Log.d("logOne", "NEW LOG");
                Log.i("during", "we're inside here");
                // This method will be created next
                displayInRecyclerView();
            }
        });
    }

    private void displayInRecyclerView() {
        recyclerView = activityMainBinding.recyclerView;
        albumAdapter = new AlbumAdapter(albumList, this);
        recyclerView.setAdapter(albumAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        albumAdapter.notifyDataSetChanged();
    }
}