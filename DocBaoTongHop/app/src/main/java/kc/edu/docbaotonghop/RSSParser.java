package kc.edu.docbaotonghop;


import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RSSParser {
    public interface RSSCallback {
        void onSuccess(ArrayList<NewsObject> list);
        void onError(Exception e);
    }

    public void getNews(String urlString, RSSCallback callback) {
        new Thread(() -> {
            ArrayList<NewsObject> list = new ArrayList<>();
            try {
                URL url = new URL(urlString);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                InputStream stream = conn.getInputStream();

                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                XmlPullParser parser = factory.newPullParser();
                parser.setInput(stream, null);

                int eventType = parser.getEventType();
                String title = "", link = "", pubDate = "", imageUrl = "", description = "", content = "";
                boolean isInsideItem = false;

                while (eventType != XmlPullParser.END_DOCUMENT) {
                    String tagName = parser.getName();
                    if (eventType == XmlPullParser.START_TAG) {
                        if (tagName.equalsIgnoreCase("item")) {
                            isInsideItem = true;
                        } else if (isInsideItem) {
                            if (tagName.equalsIgnoreCase("title")) title = parser.nextText();
                            else if (tagName.equalsIgnoreCase("link")) link = parser.nextText();
                            else if (tagName.equalsIgnoreCase("pubDate")) pubDate = parser.nextText();
                            else if (tagName.equalsIgnoreCase("description")) description = parser.nextText();
                            else if (tagName.equalsIgnoreCase("content:encoded")) content = parser.nextText();
                            else if (tagName.equalsIgnoreCase("image")) imageUrl = parser.nextText();
                            else if (tagName.equalsIgnoreCase("enclosure")) {
                                imageUrl = parser.getAttributeValue(null, "url");
                            }
                        }
                    } else if (eventType == XmlPullParser.END_TAG && tagName.equalsIgnoreCase("item")) {
                        // Nếu chưa tìm được URL từ các tag trên, thử extract từ description hoặc content
                        if (imageUrl.isEmpty() || imageUrl.equals("")) {
                            imageUrl = extractImageUrl(description);
                            if (imageUrl.isEmpty()) {
                                imageUrl = extractImageUrl(content);
                            }
                        }
                        list.add(new NewsObject(title, link, pubDate, imageUrl));
                        isInsideItem = false;
                        // Reset biến cho item tiếp theo
                        title = "";
                        link = "";
                        pubDate = "";
                        imageUrl = "";
                        description = "";
                        content = "";
                    }
                    eventType = parser.next();
                }
                callback.onSuccess(list);
            } catch (Exception e) {
                callback.onError(e);
            }
        }).start();
    }

    // Method để extract image URL từ HTML content
    private String extractImageUrl(String htmlContent) {
        if (htmlContent == null || htmlContent.isEmpty()) {
            return "";
        }
        
        // Pattern để tìm img tag có src attribute
        Pattern pattern = Pattern.compile("<img[^>]*src=\"([^\"]*)\"", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(htmlContent);
        
        if (matcher.find()) {
            String imageUrl = matcher.group(1);
            // Loại bỏ HTML entities nếu có
            return imageUrl.replace("&amp;", "&").replace("&quot;", "\"");
        }
        return "";
    }
}
