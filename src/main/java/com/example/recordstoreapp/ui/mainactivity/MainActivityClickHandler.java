package com.example.recordstoreapp.ui.mainactivity;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import com.example.recordstoreapp.ui.addalbum.AddAlbumActivity;

public class MainActivityClickHandler {

    Context context;
    MainActivityViewModel mainActivityViewModel;

    public MainActivityClickHandler(Context context, MainActivityViewModel mainActivityViewModel) {
        this.context = context;
        this.mainActivityViewModel = mainActivityViewModel;
    }

    public void goToAddNewAlbum(View view) {
        Intent intent = new Intent(context, AddAlbumActivity.class);
        context.startActivity(intent);

    }
}
