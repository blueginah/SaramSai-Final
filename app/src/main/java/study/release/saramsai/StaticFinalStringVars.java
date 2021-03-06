package study.release.saramsai;

/**
 * Created by Tronze on 2017-08-02.
 */

public class StaticFinalStringVars {

    private static final String VIDEO_LINK = "video_link";
    private static final String APP_KEY_TAG = "__APPKEY__";
    private static final String VIDEO_LINK_URL = "http://54.202.215.97/saramsai/PHP/video_list_app.php";
    private static final String VIDEO_INFO = "video_info";
    private static final String VIDEO_TITLE = "video_title";
    private static final String VIDEO_DESCRIPTION = "video_description";


    public static String getVideoLink() {
        return VIDEO_LINK;
    }

    public static String getAppKeyTag() {
        return APP_KEY_TAG;
    }

    public static String getVideoLinkUrl() {
        return VIDEO_LINK_URL;
    }

    public static String getVideoInfo() {
        return VIDEO_INFO;
    }

    public static String getVideoTitle() {
        return VIDEO_TITLE;
    }

    public static String getVideoDescription() {
        return VIDEO_DESCRIPTION;
    }
}
