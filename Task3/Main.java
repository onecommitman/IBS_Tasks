package IBS_Tasks.Task3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String jsonString = getJsonString(args[0]);
        ProcessJson processJson = new ProcessJson(jsonString);
        List<Company> companies = processJson.getCompanies();
        showShortInfo(companies);
        System.out.println("===============================================================");
        ProcessDates.expiredSecurities(companies);

    }
    static String getJsonString(String path){
        StringBuilder jsonFile = new StringBuilder();

        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
            char[] buf = new char[1024];
            int numRead = 0;
            while ((numRead = reader.read(buf)) != -1) {
                String readData = String.valueOf(buf, 0, numRead);
                jsonFile.append(readData);
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        return jsonFile.toString();
    }
    static void showShortInfo(List<Company> companies){
        LocalDate date;

        System.out.println("Краткая информация о компаниях:");
        for(Company company:companies){
            DateTimeFormatter toDateFormatter = DateTimeFormatter.ofPattern(ProcessDates.dateFormat[0]);
            DateTimeFormatter dateToStringFormatter = DateTimeFormatter.ofPattern(ProcessDates.dateFormat[1]);
            date = LocalDate.parse(company.getFounded(), toDateFormatter);
            System.out.println(String.format("Компания: \"" + company.getName() + "\", дата основания " + date.format(dateToStringFormatter)));


        }
    }
}
