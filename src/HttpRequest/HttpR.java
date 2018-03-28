package HttpRequest;

import Admin.MyData;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;
import com.mashape.unirest.request.HttpRequestWithBody;


import java.io.IOException;

public class HttpR {
    String autor = "Basic ZG1pdHJpaS5rdWNoZXJlbmtvOlp6OTgxMzE2Mzk2Kg==";

    public HttpR() throws IOException {
    }

    public static void main(String[] args) throws UnirestException {
        GetRequest request = Unirest.get("https://www.flirt.com");


     /*   HttpResponse<JsonNode> response1 = Unirest.get("https://my.platformphoenix.com/").basicAuth("dmitrii.kucherenko", MyData.getPassword()).asJson();
        response1.getStatus();
        System.out.println(response1.getStatus());*/
       // HttpR httpR = new HttpR();
       // httpR.method();
    }

    public void method() throws IOException, UnirestException {


        /* HttpResponse<String> response = Unirest.post("https://my.platformphoenix.com/")
           .header("authorization", "Basic ZG1pdHJpaS5rdWNoZXJlbmtvOlp6OTgxMzE2Mzk2Kg==")
         //   .header("cache-control", "no-cache")
          //  .header("postman-token", "9fd298ea-d3ad-ac5e-3c94-d97e53076d1f")
            .asString();
        System.out.println(response);*/

        HttpResponse<JsonNode> response1 = Unirest.get("https://my.platformphoenix.com/").basicAuth("dmitrii.kucherenko", MyData.getPassword()).asJson();
       response1.getStatus();
        System.out.println(response1.getStatus());


      /*  OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://my.platformphoenix.com/")
                .get()
                .addHeader("authorization", "Basic ZG1pdHJpaS5rdWNoZXJlbmtvOlp6OTgxMzE2Mzk2Kg==")
              //.addHeader("cache-control", "no-cache")
            //  .addHeader("postman-token", "b7c4b65b-591f-7696-7205-dc659668db54")
                .build();

        Response response = client.newCall(request).execute();

        System.out.println(response.toString());*/



        /* URL url = new URL("http://example.com");
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    con.setRequestMethod("GET");*/
    }
}
