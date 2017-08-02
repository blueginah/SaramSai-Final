package study.release.saramsai;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Tronze on 2017-07-22.
 */

public class VideoListAdapter extends RecyclerView.Adapter<VideoListViewHolder> {

    private ArrayList<VideoInfoType> videoInfo;

    public VideoListAdapter() {
        InitializeVideoInfoArrayList();
    }

    @Override
    public VideoListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewiholder, parent, false);
        return new VideoListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(VideoListViewHolder holder, int position) {
        holder.setThumb(videoInfo.get(position).getTitle(), videoInfo.get(position).getLink());
    }

    @Override
    public int getItemCount() {
        return videoInfo.size();
    }

    private void InitializeVideoInfoArrayList() {
        videoInfo = new ArrayList<>();
        GetList();
    }

    private void GetList() {

        videoInfo.add(new VideoInfoType("쉬는 시간", "ArwPNahI0sQ"));
        videoInfo.add(new VideoInfoType("꿈의학교1차시 개교식", "hmt6mu3GhBM"));
        videoInfo.add(new VideoInfoType("꿈의학교4차 남자팀연극", "Swu5rT5HIs0"));

    }

    public void refreshVideoList() {
        videoInfo.clear();
        GetList();
        notifyDataSetChanged();
    }
}
