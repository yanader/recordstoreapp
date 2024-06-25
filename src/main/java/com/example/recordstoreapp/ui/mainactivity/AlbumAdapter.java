package com.example.recordstoreapp.ui.mainactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.example.recordstoreapp.R;
import com.example.recordstoreapp.databinding.AlbumItemBinding;
import com.example.recordstoreapp.model.Album;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {

    List<Album> albumList;
    Context context;
    RecyclerViewInterface recyclerViewInterface;

    public AlbumAdapter(List<Album> albumList, Context context, RecyclerViewInterface recyclerViewInterface) {
        this.albumList = albumList;
        this.context = context;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @NotNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup viewGroup, int i) {
        AlbumItemBinding albumItemBinding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.album_item, viewGroup, false);
        return new AlbumViewHolder(albumItemBinding, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull AlbumViewHolder albumViewHolder, int i) {
        Album album = albumList.get(i);
        albumViewHolder.albumItemBinding.setAlbumData(album);
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }


    public void setFilteredList(List<Album> filteredList) {
        albumList = filteredList;
    }

    public static class AlbumViewHolder extends RecyclerView.ViewHolder {
        private AlbumItemBinding albumItemBinding;

            public AlbumViewHolder(AlbumItemBinding albumItemBinding, RecyclerViewInterface recyclerViewInterface) {
                super(albumItemBinding.getRoot());
                this.albumItemBinding = albumItemBinding;

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (recyclerViewInterface != null) {
                            int position = getAdapterPosition();
                            if (position != RecyclerView.NO_POSITION) {
                                recyclerViewInterface.onItemClick(position);
                            }
                        }
                    }
                });
            }
    }
}

