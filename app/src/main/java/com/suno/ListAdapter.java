package com.suno;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.List;

public class ListAdapter extends BaseAdapter {
    List<String> songNames;
    List<String> thumbnails;
    Context context;
    public ListAdapter(Context context, List<String> songNames, List<String> thumbnails) {
        this.context = context;
        this.songNames = songNames;
        this.thumbnails = thumbnails;
    }

    @Override
    public int getCount() {
        return songNames.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @SuppressLint({"InflateParams", "ViewHolder"})
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.songs_list_layout, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.songName.setText(songNames.get(i));
        Picasso.get().load(thumbnails.get(i)).into(viewHolder.thumbnail);
        return view;
    }

    private static class ViewHolder{
       TextView songName;
       ImageView thumbnail;

        ViewHolder(View view){
            songName = view.findViewById(R.id.songName);
            thumbnail = view.findViewById(R.id.songThumbnail);
        }
    }
}
