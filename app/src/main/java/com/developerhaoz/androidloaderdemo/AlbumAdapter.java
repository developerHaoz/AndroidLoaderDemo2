package com.developerhaoz.androidloaderdemo;

import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
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

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {

    private Cursor mCursor;

    private static final String TAG = "AlbumAdapter";

    public AlbumAdapter(Cursor cursor) {
        this.mCursor = cursor;
    }

    @Override
    public AlbumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_album,null);
        return new AlbumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AlbumViewHolder holder, int position) {

//        String albumCoverPath = mCursor.getString(mCursor.getColumnIndex("_data"));

        if(mCursor != null && mCursor.moveToNext()){
            holder.tvAlbumName.setText(mCursor.getString(mCursor.getColumnIndex("bucket_display_name")));
            holder.tvAlbumAmount.setText(mCursor.getString(mCursor.getColumnIndex("count")));
            Glide.with(holder.ivAlbum.getContext())
                    .load(mCursor.getString(mCursor.getColumnIndex("_data")))
                    .into(holder.ivAlbum);
        }
//        String albumName = mCursor.getString(mCursor.getColumnIndex("bucket_display_name"));
//        String amount = mCursor.getString(mCursor.getColumnIndex("count"));

//        holder.tvAlbumName.setText(albumName);
//        holder.tvAlbumAmount.setText(amount);
//        Glide.with(holder.ivAlbum.getContext())
//                .load(albumCoverPath)
//                .into(holder.ivAlbum);
    }

    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }

    private boolean isDataValid(Cursor cursor) {
        return cursor != null && !cursor.isClosed() ? true : false;
    }

    public void swapCursor(Cursor newCursor) {
        if (mCursor == newCursor) {
            return;
        }
        notifyDataSetChanged();
    }

    public static class AlbumViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivAlbum;
        private TextView tvAlbumName;
        private TextView tvAlbumAmount;

        public AlbumViewHolder(View itemView) {
            super(itemView);
            ivAlbum = (ImageView) itemView.findViewById(R.id.album_iv_album);
            tvAlbumName = (TextView) itemView.findViewById(R.id.album_tv_album_name);
            tvAlbumAmount = (TextView) itemView.findViewById(R.id.album_tv_amount);
        }


    }

}
