package com.example.recordstoreapp.ui.addalbum;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import com.example.recordstoreapp.model.AlbumStockItem;
import com.example.recordstoreapp.ui.mainactivity.MainActivity;
import com.example.recordstoreapp.ui.mainactivity.MainActivityViewModel;


public class AddAlbumClickHandlers {
    AlbumStockItem albumStockItem;
    Context context;
    MainActivityViewModel mainActivityViewModel;

    public AddAlbumClickHandlers(AlbumStockItem albumStockItem, Context context, MainActivityViewModel mainActivityViewModel) {
        this.albumStockItem = albumStockItem;
        this.context = context;
        this.mainActivityViewModel = mainActivityViewModel;
    }

    public void createAlbumClicked(View view) {
        if (albumStockItem.getAlbumName() == null ||
            albumStockItem.getArtistName() == null ||
            albumStockItem.getGenre() == null ||
            albumStockItem.getPriceInPence() == null ||
            albumStockItem.getReleaseDate() == null) {
            Toast toast = Toast.makeText(context, "Fields can not be empty", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            AlbumStockItem newAlbum = new AlbumStockItem(
                    albumStockItem.getAlbumName(),
                    albumStockItem.getArtistName(),
                    albumStockItem.getGenre(),
                    albumStockItem.getReleaseDate(),
                    albumStockItem.getPriceInPence());

            mainActivityViewModel.addAlbum(newAlbum);

            Intent intent = new Intent(context, MainActivity.class);
            context.startActivity(intent);
        }
    }

    public void backButtonClicked(View view) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }
}
