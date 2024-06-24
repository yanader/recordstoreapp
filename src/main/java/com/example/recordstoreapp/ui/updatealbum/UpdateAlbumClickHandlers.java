package com.example.recordstoreapp.ui.updatealbum;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import com.example.recordstoreapp.model.AlbumStockItem;
import com.example.recordstoreapp.model.UpdateAlbumItem;
import com.example.recordstoreapp.ui.mainactivity.MainActivity;
import com.example.recordstoreapp.ui.mainactivity.MainActivityViewModel;

public class UpdateAlbumClickHandlers {
    UpdateAlbumItem updateAlbumItem;
    MainActivityViewModel mainActivityViewModel;
    long albumId;
    Context context;

    public UpdateAlbumClickHandlers(UpdateAlbumItem updateAlbumItem, MainActivityViewModel mainActivityViewModel, Context context, long id) {
        this.updateAlbumItem = updateAlbumItem;
        this.mainActivityViewModel = mainActivityViewModel;
        this.context = context;
        albumId = id;
    }

    public void submitUpdatedAlbum(View view) {
        if (updateAlbumItem.getAlbumName() == null ||
                updateAlbumItem.getArtistName() == null ||
                updateAlbumItem.getGenre() == null ||
                updateAlbumItem.getPriceInPence() == null ||
                updateAlbumItem.getReleaseDate() == null) {
            Toast toast = Toast.makeText(context, "Fields can not be empty", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            AlbumStockItem updatedAlbum = new AlbumStockItem(
                    updateAlbumItem.getAlbumName(),
                    updateAlbumItem.getArtistName(),
                    updateAlbumItem.getGenre(),
                    updateAlbumItem.getReleaseDate(),
                    updateAlbumItem.getPriceInPence()
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
