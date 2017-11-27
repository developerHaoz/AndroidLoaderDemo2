package com.developerhaoz.androidloaderdemo;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity implements AlbumCollection.AlbumCallbacks{

    private static final String TAG = "Main";
    private AlbumCollection mCollection;
    private AlbumAdapter mAdapter;
    private RecyclerView mRvAlbum;
    private Cursor mCursor;
    private List<String> mStringList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: " + "hello world");
//        initRecyclerView();
        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
            mCollection = new AlbumCollection();
            mCollection.onCreate(this, this);
            mCollection.loadAlbums();
        }else{
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        }
    }

//    private void initRecyclerView() {
//        initStrList();
//        mRvAlbum = (RecyclerView) findViewById(R.id.main_rv_album);
//        mRvAlbum.setLayoutManager(new LinearLayoutManager(this));
//        mRvAlbum.setAdapter(new TestAdapter(mStringList));
//    }
//
//    private void initStrList(){
//        mStringList = new ArrayList<>();
//        for (int i = 0; i < 9; i++) {
//            mStringList.add(String.valueOf(i));
//        }
//    }

    @Override
    public void onAlbumLoad(Cursor cursor) {
        mRvAlbum = (RecyclerView) findViewById(R.id.main_rv_album);
        mRvAlbum.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new AlbumAdapter(cursor);
        mRvAlbum.setAdapter(mAdapter);
    }

    @Override
    public void onAlbumReset() {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    mCollection = new AlbumCollection();
                    mCollection.onCreate(this, this);
                    mCollection.loadAlbums();
                }
                break;
            default:break;
        }
    }
}
