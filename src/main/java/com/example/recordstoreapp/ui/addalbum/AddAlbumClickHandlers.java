package com.example.recordstoreapp.ui.addalbum;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import com.example.recordstoreapp.model.AlbumToAdd;
import com.example.recordstoreapp.ui.mainactivity.MainActivity;
import com.example.recordstoreapp.ui.mainactivity.MainActivityViewModel;


public class AddAlbumClickHandlers {
    AlbumToAdd albumToAdd;
    Context context;
    MainActivityViewModel mainActivityViewModel;

    public AddAlbumClickHandlers(AlbumToAdd albumToAdd, Context context, MainActivityViewModel mainActivityViewModel) {
        this.albumToAdd = albumToAdd;
        this.context = context;
        this.mainActivityViewModel = mainActivityViewModel;
    }

    public void createAlbumClicked(View view) {
        if (albumToAdd.getAlbumName() == null ||
            albumToAdd.getArtistName() == null ||
            albumToAdd.getGenre() == null ||
            albumToAdd.getPriceInPence() == null ||
            albumToAdd.getReleaseDate() == null) {
            Toast toast = Toast.makeText(context, "Fields can not be empty", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            AlbumToAdd newAlbum = new AlbumToAdd(
                    albumToAdd.getAlbumName(),
                    albumToAdd.getArtistName(),
                    albumToAdd.getGenre(),
                    albumToAdd.getReleaseDate(),
                    albumToAdd.getPriceInPence());

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
