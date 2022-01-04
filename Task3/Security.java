package IBS_Tasks.Task3;

import java.util.Arrays;

public class Security {
    private String name;
    private String[] currency;
    private String code;
    private String date;

    @Override
    public String toString() {
        return "Security{" +
                "name='" + name + '\'' +
                ", currency=" + Arrays.toString(currency) +
                ", code='" + code + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public Security(String name, String[] currency, String code, String date) {
        this.name = name;
        this.currency = currency;
        this.code = code;
        this.date = date;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getCurrency() {
        return currency;
    }

    public void setCurrency(String[] currency) {
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}