package HomeWork.UrlBuilder;

public class Main {

    public static void main(String[] args) {
        System.out.println(new Url.UrlBuilder("vk.com")
                .withHttps(true)
                .withResource("about.html")
                .withParam("key","value")
                .withParam("key1","value1")
                .withIsQa(true)
                .build().getUrl());
           }
 }
