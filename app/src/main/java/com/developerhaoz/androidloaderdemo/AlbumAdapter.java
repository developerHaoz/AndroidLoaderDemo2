package com.developerhaoz.androidloaderdemo;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * @author Haoz
 * @date 2017/11/26.
 */

public class AlbumAdapter extends CursorAdapter {

    public AlbumAdapter(Context context, Cursor cursor, boolean autoRequery){
        super(context, cursor, autoRequery);
    }

    private boolean isDataValid(Cursor cursor){
        return cursor != null && !cursor.isClosed() ? true : false;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.item_rv_album, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        String albumCoverPath = cursor.getString(cursor.getColumnIndex("_data"));
        String albumName = cursor.getString(cursor.getColumnIndex("bucket_display_name"));
        String amount = cursor.getString(cursor.getColumnIndex("count"));

        ((TextView) view.findViewById(R.id.album_tv_album_name)).setText(albumName);
        ((TextView) view.findViewById(R.id.album_tv_amount)).setText(amount);
        Glide.with(context)
                .load(albumCoverPath)
                .into((ImageView)view.findViewById(R.id.album_iv_album));
    }

}
