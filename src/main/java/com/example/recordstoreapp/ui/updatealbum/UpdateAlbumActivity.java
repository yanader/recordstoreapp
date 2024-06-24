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
import com.example.recordstoreapp.model.GetByIdAlbum;
import com.example.recordstoreapp.model.UpdateAlbumItem;
import com.example.recordstoreapp.ui.mainactivity.MainActivityViewModel;

public class UpdateAlbumActivity extends AppCompatActivity {

    ActivityUpdateAlbumBinding activityUpdateAlbumBinding;
    UpdateAlbumClickHandlers updateAlbumClickHandlers;
    GetByIdAlbum getByIdAlbum;
    Album album;
    UpdateAlbumItem updateAlbumItem;
    long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_album);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            getByIdAlbum = this.getIntent().getParcelableExtra("AlbumStock", GetByIdAlbum.class);
            album = this.getIntent().getParcelableExtra("Album", Album.class);

            id = this.getIntent().getLongExtra("id", -1);


        }

        MainActivityViewModel mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        activityUpdateAlbumBinding = DataBindingUtil.setContentView(this, R.layout.activity_update_album);

        updateAlbumItem = albumConvertor(getByIdAlbum, album);
        activityUpdateAlbumBinding.setUpdateAlbumItem(updateAlbumItem);

        updateAlbumClickHandlers = new UpdateAlbumClickHandlers(updateAlbumItem, mainActivityViewModel, this, id);
        activityUpdateAlbumBinding.setClickHandlers(updateAlbumClickHandlers);

    }

    public UpdateAlbumItem albumConvertor(GetByIdAlbum getByIdAlbum, Album album) {
        Log.i("albumLogging", album.toString());
        Log.i("albumLogging", getByIdAlbum.toString());
        return new UpdateAlbumItem(
                getByIdAlbum.getAlbumName(),
                getByIdAlbum.getArtistName(),
                album.getGenre(),
                album.getReleaseDate(),
                getByIdAlbum.getPriceInPence()
        );
    }
}