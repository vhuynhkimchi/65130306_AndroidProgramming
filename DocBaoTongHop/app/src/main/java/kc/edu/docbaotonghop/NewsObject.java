package kc.edu.docbaotonghop;

public class NewsObject {
    private String title;
    private String link;
    private String pubDate;
    private String imageUrl;

    public NewsObject(String title, String link, String pubDate, String imageUrl) {
        this.title = title;
        this.link = link;
        this.pubDate = pubDate;
        this.imageUrl = imageUrl;
    }

    // Getter
    public String getTitle() { return title; }
    public String getLink() { return link; }
    public String getPubDate() { return pubDate; }
    public String getImageUrl() { return imageUrl; }
}
