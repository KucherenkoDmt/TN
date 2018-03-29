package Patterns.CSV;

public class CsvCell {
    private String link;
    private String ip_address;
    private int counterOfRegistration;
    private int numberOfGenderValue;

    public CsvCell(String link, String ip_address, int counterOfRegistration, int numberOfGenderValue) {
        this.link = link;
        this.ip_address = ip_address;
        this.counterOfRegistration = counterOfRegistration;
        this.numberOfGenderValue = numberOfGenderValue;
    }
    //int id = list.get(0).getLink();

    public String getLink() {
        return link;
    }

    public String getIp_address() {
        return ip_address;
    }

    public int getCounterOfRegistration() {
        return counterOfRegistration;
    }

    public int getNumberOfGenderValue() {
        return numberOfGenderValue;
    }

}
