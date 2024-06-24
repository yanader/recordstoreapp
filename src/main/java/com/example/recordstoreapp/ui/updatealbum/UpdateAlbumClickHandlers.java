package com.example.recordstoreapp.ui.updatealbum;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import com.example.recordstoreapp.model.Album;
import com.example.recordstoreapp.model.AlbumStockItem;
import com.example.recordstoreapp.ui.mainactivity.MainActivity;
import com.example.recordstoreapp.ui.mainactivity.MainActivityViewModel;

public class UpdateAlbumClickHandlers {
    AlbumStockItem albumStockItem;
    MainActivityViewModel mainActivityViewModel;
    long albumId;
    Context context;

    public UpdateAlbumClickHandlers(AlbumStockItem albumStockItem, MainActivityViewModel mainActivityViewModel, Context context) {
        this.albumStockItem = albumStockItem;
        this.mainActivityViewModel = mainActivityViewModel;
        this.context = context;
        albumId = 1L;
    }

    public void submitUpdatedAlbum(View view) {
        if (albumStockItem.getAlbumName() == null ||
                albumStockItem.getArtistName() == null ||
                albumStockItem.getGenre() == null ||
                albumStockItem.getPriceInPence() == null ||
                albumStockItem.getReleaseDate() == null) {
            Toast toast = Toast.makeText(context, "Fields can not be empty", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            AlbumStockItem updatedAlbum = new AlbumStockItem(
                    albumStockItem.getAlbumName(),
                    albumStockItem.getArtistName(),
                    albumStockItem.getGenre(),
                    albumStockItem.getReleaseDate(),
                    albumStockItem.getPriceInPence()
            );
            mainActivityViewModel.updateAlbum(updatedAlbum, albumId);

            Intent intent = new Intent(context, MainActivity.class);
            context.startActivity(intent);
        }
    }

    public void submitDeleteAlbum(View view) {
        mainActivityViewModel.deleteAlbum(albumId);
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    public void backButtonClicked(View view) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }


}
