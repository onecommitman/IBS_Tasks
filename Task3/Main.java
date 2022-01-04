package IBS_Tasks.Task3;

import com.google.gson.internal.bind.util.ISO8601Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String jsonString = getJsonString(args[0]);
        ProcessJson processJson = new ProcessJson(jsonString);
        List<Company> companies = processJson.getCompanies();
        Scanner in = new Scanner(System.in);
        int operationNumber;
        //System.out.println("Вы ввели: " + operationNumber);

        while(true){
            printMenu();
            operationNumber = in.nextInt();

            switch (operationNumber) {
                case  (1):
                    System.out.println("##########################################################");
                    showShortInfo(companies);
                    System.out.println("##########################################################");
                    break;
                case (2):
                    System.out.println("##########################################################");
                    ProcessDates.expiredSecurities(companies);
                    System.out.println("##########################################################");
                    break;
                case (3):
                    System.out.println("Введите дату для проверки (дд/мм/ггг):");
                    Scanner inCase3 = new Scanner(System.in);
                    String case3 = inCase3.nextLine();
                    System.out.println("##########################################################");
                    ProcessDates.checkByUsersDate(companies, case3);
                    System.out.println("##########################################################");
                    break;
                case (4):
                    System.out.println("Введите валюту для проверки (EU/USD/RUB):");
                    Scanner inCase4 = new Scanner(System.in);
                    String case4 = inCase4.nextLine();
                    System.out.println("##########################################################");
                    ProcessCurrencies.processCurrencies(companies, case4);
                    System.out.println("##########################################################");
                    break;
                default:
                    System.out.println("Вы ввели неверный номер операции! Попробуйте ещё раз...");
                    //int operationNumber = in.nextInt();
                    break;
            }
        }

        //showShortInfo(companies);// 1
        //System.out.println("===============================================================");
        //ProcessDates.expiredSecurities(companies); //2
        //ProcessDates.checkByUsersDate(companies, "01/04/2075"); //3
        //ProcessCurrencies.processCurrencies(companies, "EU"); //4

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
    static void printMenu(){
        System.out.println("-------------------------------------------------------------");
        System.out.println("Введите номер желаемой операции: ");
        System.out.println("1 - Краткая информация о компаниях" +
                "\n2 - Информация о просроченных ценных бумагах и их суммарное количество" +
                "\n3 - Компании, основанные после..." +
                "\n4 - Компании и ценные бумаги, использующие заданную валюту" +
                "\n0 - Выход");
        System.out.println("-------------------------------------------------------------");
    }
}
