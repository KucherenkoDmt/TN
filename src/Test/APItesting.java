package Test;

import org.apache.http.HttpResponse;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class APItesting {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://example.com");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.usingProxy();
    }
}
