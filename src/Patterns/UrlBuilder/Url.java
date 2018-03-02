package HomeWork.UrlBuilder;

import java.util.ArrayList;

public class Url {

    private String url;
    private String serverName;
    private String http;
    private String resource;
    private ArrayList<String> param = new ArrayList<>();
    private String isQa;

    private Url(UrlBuilder urlBuilder) {
        this.serverName = urlBuilder.serverName;
        this.http = urlBuilder.http;
        this.resource = urlBuilder.resource;
        this.param = urlBuilder.param;
        this.isQa = urlBuilder.isQa;
    }

    public String getUrl() {
        url = http + "://" + serverName + "/" + resource  + params();
        return url;
    }

    private String params() {
        String params ="";
        for (int i = 0; i < param.size(); i++) {
            params+=param.get(i);
        }
        params+="&"+isQa;
        return params.length()==1 ? "" : "?"+params.substring(1);
    }

    public static class UrlBuilder {

        private String serverName;
        private String http = "http";
        private String resource="";
        private ArrayList<String> param = new ArrayList<>();
        private String isQa="";

        public UrlBuilder(String server) {
            this.serverName = server;
        }


        public UrlBuilder withHttps(boolean isHttps) {
            http = isHttps ? "https" : "http";
            return this;
        }

        public UrlBuilder withResource(String resource) {
            this.resource = resource+"/";
            return this;
        }

        public UrlBuilder withParam(String key, String value) {
            this.param.add("&" + key + "=" + value);
            return this;
        }

        public UrlBuilder withIsQa(boolean isQa) {
            this.isQa = "isqa=" + isQa;
            return this;
        }

        public Url build() {
            return new Url(this);
        }

    }
}
