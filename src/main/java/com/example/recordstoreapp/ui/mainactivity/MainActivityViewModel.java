package com.example.recordstoreapp.ui.mainactivity;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.example.recordstoreapp.model.Album;
import com.example.recordstoreapp.model.AlbumRepository;
import com.example.recordstoreapp.model.AlbumStockItem;
import com.example.recordstoreapp.model.GetByIdAlbum;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private AlbumRepository albumRepository;

    public MainActivityViewModel(@NotNull Application application) {
        super(application);
        this.albumRepository = new AlbumRepository(application);
    }

    public MutableLiveData<List<Album>> getData() {

        return albumRepository.getMutableLiveData();
    }

    public void addAlbum(AlbumStockItem albumStockItem) {
        albumRepository.addNewAlbum(albumStockItem);
    }

    public void updateAlbum(AlbumStockItem albumStockItem, long id) {
        albumRepository.updateAlbum(albumStockItem, id);
    }

    public void deleteAlbum(long id) {
        albumRepository.deleteAlbum(id);
    }

    public MutableLiveData<GetByIdAlbum> getStockItemByID(long id) {
        return albumRepository.getAlbumStockById(id);
    }
}
