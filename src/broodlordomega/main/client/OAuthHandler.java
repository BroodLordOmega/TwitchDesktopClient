package broodlordomega.main.client;

import java.awt.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class OAuthHandler {
    private static final String version = "v3";
    private static final String mime_type = "application/vnd.twitchtv." + version + "+json";
    private static final String api_url = "https://api.twitch.tv/kraken";
    private static final String redirect_uri = "http://broodlordomega.github.io/TwitchDesktopClient/oauth.html";

    public static void  GetOAuthToken(){
        try {
            openWebpage(
                    new URL("" + api_url +
                            "/oauth2/authorize?response_type=token&client_id=" + ClientID.ClientID +
                            "&redirect_uri=" + redirect_uri + "&scope=user_read+user_follows_edit").toURI() );
        } catch (URISyntaxException | MalformedURLException e) {
            e.printStackTrace();
        }


    }

    public static void openWebpage(URI uri) {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(uri);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void openWebpage(URL url) {
        try {
            openWebpage(url.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
