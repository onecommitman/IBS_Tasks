package IBS_Tasks.Task3;

import java.util.List;

public class Company {
    private int id;
    private String name;
    private String address;
    private String phoneNumber;
    private String founded;
    private String inn;
    private List<Security> securities;

    public Company(int id, String name, String address, String phoneNumber, String founded, String inn, List<Security> securities) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.founded = founded;
        this.inn = inn;
        this.securities = securities;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFounded() {
        return founded;
    }

    public void setFounded(String founded) {
        this.founded = founded;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public List<Security> getSecurities() {
        return securities;
    }

    public void setSecuritiesList(List<Security> securities) {
        this.securities = securities;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", founded='" + founded + '\'' +
                ", inn='" + inn + '\'' +
                ", securities=" + securities +
                '}';
    }
}