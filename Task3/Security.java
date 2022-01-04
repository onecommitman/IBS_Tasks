package IBS_Tasks.Task3;

import java.util.Arrays;
import java.util.Objects;

public class Security {
    private String name;
    private String[] currency;
    private String code;
    private String date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Security security = (Security) o;
        return Objects.equals(name, security.name) && Arrays.equals(currency, security.currency) && Objects.equals(code, security.code) && Objects.equals(date, security.date);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, code, date);
        result = 31 * result + Arrays.hashCode(currency);
        return result;
    }

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