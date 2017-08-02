package study.release.saramsai;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

/**
 * Created by Tronze on 2017-07-22.
 */

public class VideoViewActivity extends YouTubeFailureRecoveryActivity implements YouTubePlayer.OnInitializedListener, YouTubePlayer.OnFullscreenListener {

    private String link;

    boolean fullscreen;

    YouTubePlayerView youTubeView;
    YouTubePlayer youTubePlayer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_view);

        Intent temp = getIntent();

        link = temp.getStringExtra(StaticFinalStringVars.getVideoLink());

        youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);
        youTubeView.initialize(DeveloperKey.DEVELOPER_KEY, this);

    }

    @Override
    public void onFullscreen(boolean b) {
        fullscreen = b;
        youTubePlayer.play();
    }

    @Override
    protected YouTubePlayer.Provider getYouTubePlayerProvider() {
        return (YouTubePlayerView) findViewById(R.id.youtube_view);
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
        if(fullscreen) {
            youTubePlayer.setFullscreen(false);
            fullscreen = !fullscreen;
            youTubePlayer.pause();
            youTubePlayer.play();
        }
        else super.onBackPressed();
    }
}
