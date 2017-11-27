package com.developerhaoz.androidloaderdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * @author Haoz
 * @date 2017/11/27.
 */

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestViewHolder>{

    private List<String> mStringList;

    public TestAdapter(List<String> stringList){
        this.mStringList = stringList;
    }

    @Override
    public TestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_album, parent, false);
        return new TestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TestViewHolder holder, int position) {
        holder.tvAlbumAmount.setText(mStringList.get(position));
    }

    @Override
    public int getItemCount() {
        return mStringList.size();
    }

    public static class TestViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivAlbum;
        private TextView tvAlbumName;
        private TextView tvAlbumAmount;

        public TestViewHolder(View itemView) {
            super(itemView);
            ivAlbum = (ImageView) itemView.findViewById(R.id.album_iv_album);
            tvAlbumName = (TextView) itemView.findViewById(R.id.album_tv_album_name);
            tvAlbumAmount = (TextView) itemView.findViewById(R.id.album_tv_amount);
        }
    }
}
