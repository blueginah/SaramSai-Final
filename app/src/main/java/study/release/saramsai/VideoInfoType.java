package study.release.saramsai;

/**
 * Created by Tronze on 2017-08-02.
 */

public class VideoInfoType {

    private String title;
    private String link;

    public VideoInfoType(String title, String link) {
        this.title = title;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
