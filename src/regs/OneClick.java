package regs;

public class OneClick {
    public String returnDomainFromUrl(String urlText) {
        String[] splitUrl = urlText.split("\\.");
        return splitUrl[1];
    }
}
