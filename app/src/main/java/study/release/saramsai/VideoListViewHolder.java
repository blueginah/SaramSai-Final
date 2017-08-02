package study.release.saramsai;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

/**
 * Created by Tronze on 2017-07-22.
 */

public class VideoListViewHolder extends RecyclerView.ViewHolder implements YouTubeThumbnailView.OnInitializedListener {

    View itemView;
    YouTubeThumbnailView thumb;
    TextView video_info;
    private String title;
    private String link;

    public VideoListViewHolder(View itemView) {
        super(itemView);

        this.itemView = itemView;
        thumb = (YouTubeThumbnailView) itemView.findViewById(R.id.thumb);
        video_info = (TextView) itemView.findViewById(R.id.video_info);
    }

    public void setThumb(String title, String link) {

        video_info.setText(title);
        this.link = link;
        SetupThumbnail();

    }

    private void SetupThumbnail() {
        thumb.setTag(link);
        thumb.initialize(DeveloperKey.DEVELOPER_KEY, this);
        thumb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToVideoViewActivity();
            }
        });
    }

    @Override
    public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader youTubeThumbnailLoader) {
        youTubeThumbnailLoader.setVideo(youTubeThumbnailView.getTag().toString());
    }

    @Override
    public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {

    }

    private void GoToVideoViewActivity() {
        Intent intent = new Intent(GetContext(), VideoViewActivity.class);
        intent.putExtra(StaticFinalStringVars.getVideoLink(), link);
        GetContext().startActivity(intent);
    }

    private Context GetContext() {
        return itemView.getContext();
    }
}
