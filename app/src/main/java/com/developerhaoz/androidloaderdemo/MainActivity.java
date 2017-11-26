package com.developerhaoz.androidloaderdemo;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements AlbumCollection.AlbumCallbacks{

    private AlbumCollection mCollection;
    private AlbumAdapter mAdapter;
    private RecyclerView mRvAlbum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRvAlbum = (RecyclerView) findViewById(R.id.main_rv_album);
        mAdapter = new AlbumAdapter(this, null, true);
        mRvAlbum.setLayoutManager(new LinearLayoutManager(this));
//        mRvAlbum.setAdapter(mAdapter);

        mCollection = new AlbumCollection();
        mCollection.onCreate(this, this);
        mCollection.loadAlbums();
    }

    @Override
    public void onAlbumLoad(Cursor cursor) {

    }

    @Override
    public void onAlbumReset() {

    }
}
