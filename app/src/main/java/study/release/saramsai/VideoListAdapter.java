package study.release.saramsai;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Tronze on 2017-07-22.
 */

public class VideoListAdapter extends RecyclerView.Adapter<VideoListViewHolder> {

    private ArrayList<VideoInfoType> videoInfo;
    private Context context;

    public VideoListAdapter(Context context) {
        this.context = context;
        InitializeVideoInfoArrayList();
    }

    @Override
    public VideoListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewholder, parent, false);
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

        JsonObjectRequest videoInfoRequest =
                new JsonObjectRequest(StaticFinalStringVars.getVideoLinkUrl(), GenerateRequestKey(), GenerateVideoInfoRequestListener(),GenerateVideoInfoRequestErrorListener());


        //Enable When Server Part is finished
        MySingleton.getInstance(context).addToRequestQueue(videoInfoRequest);

    }

    private Response.Listener<JSONObject> GenerateVideoInfoRequestListener() {
        Response.Listener<JSONObject> jsonObjectListener = new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("response", response.toString());
                JSONArray videoInfoJsonArray = null;
                JSONObject videoInfoJsonObject = null;
                try {
                    videoInfoJsonArray = response.getJSONArray(StaticFinalStringVars.getVideoInfo());
                    Log.d("jsonarray", videoInfoJsonArray.toString());
                    for(int i = 0;i < videoInfoJsonArray.length();i++) {
                        videoInfoJsonObject = videoInfoJsonArray.getJSONObject(i);
                        videoInfo.add(new VideoInfoType(videoInfoJsonObject.getString(StaticFinalStringVars.getVideoTitle()), videoInfoJsonObject.getString(StaticFinalStringVars.getVideoLink())));
                        Log.d("jsonobject", videoInfoJsonObject.toString());
                    }
                    notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        return jsonObjectListener;
    }

    private Response.ErrorListener GenerateVideoInfoRequestErrorListener() {
        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "리스트를 받아오지 못했어요...: " + error.toString(), Toast.LENGTH_SHORT).show();
                Log.e("volley_error", error.toString());
            }
        };
        return errorListener;
    }

    private JSONObject GenerateRequestKey() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put(StaticFinalStringVars.getAppKeyTag(), AppNetworkKey.getAppKey());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public void refreshVideoList() {
        videoInfo.clear();
        GetList();
        notifyDataSetChanged();
    }
}
