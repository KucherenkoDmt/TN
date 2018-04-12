package Patterns.CSV;

public class CsvCell {
    private String link;
    private String ip_address;
    private String counterOfRegistration = "";
    private String numberOfGenderValue="";
    private String emailOfUser="";

    public CsvCell(String link, String ip_address, String counterOfRegistration, String numberOfGenderValue, String emailOfUser) {
        this.link = link;
        this.ip_address = ip_address;
        this.counterOfRegistration = counterOfRegistration;
        this.numberOfGenderValue = numberOfGenderValue;
        this.emailOfUser = emailOfUser;
    }
    //int id = list.get(0).getLink();

    public String getLink() {
        if(link.contains("https://"))
            return link;
        if(link.contains("http://"))
            return link;
        else return "https://"+link;
    }

    public String getIp_address() {
        return ip_address.trim() ;
    }

    public int getCounterOfRegistration() {
        if(counterOfRegistration.length()>0){
        return Integer.parseInt(counterOfRegistration);
        }
        else {
            return 1;}
    }

    public int getNumberOfGenderValue() {
        if(numberOfGenderValue.length()>0){
            return Integer.parseInt(numberOfGenderValue);
        }
        else {
            return 1;}
    }

    public String getEmailOfUser() {
        return emailOfUser;
    }
}
