package study.release.saramsai;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView videoList;
    private VideoListAdapter videoListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConnectXMLwithJAVA();
        SetupVideoList();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        videoListAdapter.refreshVideoList();
    }

    private void ConnectXMLwithJAVA() {
        videoList = (RecyclerView)findViewById(R.id.videoList);
    }

    private void SetupVideoList() {
        videoList.setLayoutManager(new LinearLayoutManager(GetContext()));
        videoListAdapter = new VideoListAdapter();
        videoList.setAdapter(videoListAdapter);
    }

    private Context GetContext() {
        return this;
    }
}
