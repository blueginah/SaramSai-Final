package study.release.saramsai;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

/**
 * Created by Tronze on 2017-07-22.
 */

public class VideoViewActivity extends YouTubeFailureRecoveryActivity implements YouTubePlayer.OnInitializedListener, YouTubePlayer.OnFullscreenListener {

    private String link;
    private boolean fullscreen;
    private YouTubePlayerView videoViewYoutube;
    private YouTubePlayer youTubePlayer;
    private TextView videoViewTitle;
    private TextView videoViewDescription;
    private ImageView videoViewBtnExit;
    private String title;
    private String description;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_view);

        /*
         * This part is for test.
         * Please change this part of code when parsing all information
         */
        InitializeContents();
        /*
         * Test Part Ends Here.
         */

        ConnectXMLwithJAVA();
        InitializeYouTubeView();
        SetupVideoViewExitButton();
        TextSetup();
    }

    @Override
    public void onFullscreen(boolean b) {
        fullscreen = b;
        youTubePlayer.play();
    }

    @Override
    protected YouTubePlayer.Provider getYouTubePlayerProvider() {
        return (YouTubePlayerView) findViewById(R.id.videoViewYoutube);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        this.youTubePlayer = youTubePlayer;
        youTubePlayer.setOnFullscreenListener(this);
        if (!wasRestored) {
            youTubePlayer.cueVideo(link);
        }
    }

    @Override
    public void onBackPressed() {
        if (fullscreen) {
            youTubePlayer.setFullscreen(false);
            fullscreen = !fullscreen;
            youTubePlayer.pause();
            youTubePlayer.play();
        } else super.onBackPressed();
    }

    private void ConnectXMLwithJAVA() {
        videoViewYoutube = (YouTubePlayerView) findViewById(R.id.videoViewYoutube);
        videoViewTitle = (TextView) findViewById(R.id.videoViewTitle);
        videoViewDescription = (TextView) findViewById(R.id.videoViewDescription);
        videoViewBtnExit = (ImageView) findViewById(R.id.videoViewBtnExit);
    }

    private void SetupVideoViewExitButton() {
        videoViewBtnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void InitializeYouTubeView() {
        videoViewYoutube.initialize(DeveloperKey.DEVELOPER_KEY, this);
    }

    private void InitializeContents() {
        title = getIntent().getStringExtra(StaticFinalStringVars.getVideoTitle());
        link = getIntent().getStringExtra(StaticFinalStringVars.getVideoLink());
        description = getIntent().getStringExtra(StaticFinalStringVars.getVideoDescription());
    }

    private void TextSetup() {
        videoViewTitle.setText(title);
        videoViewDescription.setText(description);
    }
}
