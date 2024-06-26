package com.example.recordstoreapp.ui.addalbum;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import com.example.recordstoreapp.R;
import com.example.recordstoreapp.databinding.ActivityAddAlbumBinding;
import com.example.recordstoreapp.model.AlbumStockItem;
import com.example.recordstoreapp.ui.mainactivity.MainActivityViewModel;

public class AddAlbumActivity extends AppCompatActivity {

    private ActivityAddAlbumBinding activityAddAlbumBinding;
    private MainActivityViewModel mainActivityViewModel;
    private AddAlbumClickHandlers addAlbumClickHandlers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_add_album);

        activityAddAlbumBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_album);

        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        AlbumStockItem albumStockItem = new AlbumStockItem();
        activityAddAlbumBinding.setAlbumData(albumStockItem);

        addAlbumClickHandlers = new AddAlbumClickHandlers(albumStockItem, this, mainActivityViewModel);
        activityAddAlbumBinding.setClickHandlers(addAlbumClickHandlers);



    }
}