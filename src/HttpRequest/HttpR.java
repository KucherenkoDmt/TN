package HttpRequest;

import com.sun.deploy.net.HttpResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;



import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class HttpR {
    String autor = "Basic ZG1pdHJpaS5rdWNoZXJlbmtvOlp6OTgxMzE2Mzk2Kg==";

    public HttpR() throws IOException {
    }

    public static void main(String[] args) throws IOException {
        HttpR httpR = new HttpR();
        httpR.method();
    }

public void method() throws IOException {
  /*  HttpResponse<String> response = Unirest.get("https://my.platformphoenix.com/")
            .header("authorization", "Basic ZG1pdHJpaS5rdWNoZXJlbmtvOlp6OTgxMzE2Mzk2Kg==")
            .header("cache-control", "no-cache")
            .header("postman-token", "9fd298ea-d3ad-ac5e-3c94-d97e53076d1f")
            .asString();
*/

          OkHttpClient client = new OkHttpClient();

    Request request = new Request.Builder()
            .url("https://my.platformphoenix.com/")
            .get()
            .addHeader("authorization", "Basic ZG1pdHJpaS5rdWNoZXJlbmtvOlp6OTgxMzE2Mzk2Kg==")
            .addHeader("cache-control", "no-cache")
            .addHeader("postman-token", "b7c4b65b-591f-7696-7205-dc659668db54")
            .build();

    Response response = client.newCall(request).execute();



        /* URL url = new URL("http://example.com");
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    con.setRequestMethod("GET");*/
}
}
