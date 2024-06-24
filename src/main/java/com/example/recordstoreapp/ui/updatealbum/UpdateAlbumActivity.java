package com.example.recordstoreapp.ui.updatealbum;

import android.os.Build;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import com.example.recordstoreapp.R;
import com.example.recordstoreapp.databinding.ActivityMainBinding;
import com.example.recordstoreapp.databinding.ActivityUpdateAlbumBinding;
import com.example.recordstoreapp.model.Album;
import com.example.recordstoreapp.model.AlbumStockItem;
import com.example.recordstoreapp.ui.mainactivity.MainActivityViewModel;

public class UpdateAlbumActivity extends AppCompatActivity {

    ActivityUpdateAlbumBinding activityUpdateAlbumBinding;
    UpdateAlbumClickHandlers updateAlbumClickHandlers;
    AlbumStockItem albumStockItem;
    long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_album);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            albumStockItem = this.getIntent().getParcelableExtra("AlbumStock", AlbumStockItem.class);
            id = this.getIntent().getParcelableExtra("id", Long.class);
        }

        activityUpdateAlbumBinding = DataBindingUtil.setContentView(this, R.layout.activity_update_album);
        MainActivityViewModel mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        activityUpdateAlbumBinding.setAlbumStockData(albumStockItem);

        updateAlbumClickHandlers = new UpdateAlbumClickHandlers(albumStockItem, mainActivityViewModel, this);
        activityUpdateAlbumBinding.setClickHandlers(updateAlbumClickHandlers);

    }
}