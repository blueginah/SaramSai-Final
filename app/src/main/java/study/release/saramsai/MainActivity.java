package study.release.saramsai;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView videoList;
    private VideoListAdapter videoListAdapter;
    private TextView mainBtnDevelopers;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConnectXMLwithJAVA();
        SetupVideoList();
        SetupMainDevelopersButton();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        videoListAdapter.refreshVideoList();
    }

    private void ConnectXMLwithJAVA() {
        videoList = (RecyclerView) findViewById(R.id.videoList);
        mainBtnDevelopers = (TextView) findViewById(R.id.mainBtnDevelopers);
    }

    private void SetupVideoList() {
        videoList.setLayoutManager(new LinearLayoutManager(GetContext()));
        videoListAdapter = new VideoListAdapter(GetContext());
        videoList.setAdapter(videoListAdapter);
    }

    private void SetupMainDevelopersButton() {
        mainBtnDevelopers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(GetContext(), DeveloperIntroducingPage.class);
                startActivity(intent);
            }
        });
    }

    private Context GetContext() {
        return this;
    }
}
