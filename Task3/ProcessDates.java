package IBS_Tasks.Task3;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ProcessDates {
    static final LocalDate currentDate = LocalDate.now();
    static String[] dateFormat = {"dd.MM.yyyy", "dd/MM/yyyy", "dd/MM/yy"};

    static LocalDate parseDate(String date){
        LocalDate returnDate = null;
        for(String format:dateFormat){
            DateTimeFormatter pattern = DateTimeFormatter.ofPattern(format);
            try{
                returnDate = LocalDate.parse(date, pattern);
            }
            catch (DateTimeException e){

            }
        }
        return returnDate;
    }
    static boolean checkDate(Security security){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat[0]);
        LocalDate expiredDate = LocalDate.parse(security.getDate(), formatter);
        return expiredDate.isBefore(currentDate);
    }
    static void checkByUsersDate(List<Company> companies, String date){
        LocalDate usersDate = parseDate(date);
        System.out.println("Компании, основанные после " + usersDate);
        System.out.println("===============================================================");
        companies.stream().forEach(company -> {
            if(parseDate(company.getFounded()).isAfter(usersDate)){
                System.out.println("Компания: " + company.getName() + "дата основания: " + company.getFounded());
            } else System.out.println("Компаний, основанных после " + usersDate + ", нет!");
        });
    }
    static void expiredSecurities(List<Company> companies){
        int count = 0;
        Set<Security> setOfExpiredSecurities;

        //Получить просроченные акции
        setOfExpiredSecurities = companies.stream().flatMap(company -> company.getSecurities().stream().distinct().filter(security -> checkDate(security))).collect(Collectors.toSet());

        //Вывести просроченные бумаги и их владельцев
        System.out.println("===============================================================");
        for(Security s:setOfExpiredSecurities){
            System.out.println("Ценная бумага - Код: " + s.getCode() + " Дата истечения: " + s.getDate() + " владеют:");
            for(Company c:companies){
                if(c.getSecurities().contains(s)){
                    System.out.println("Компания: " + c.getName() + ", Адрес: "+ c.getAddress() + ", к/т: " + c.getPhoneNumber() + ", ИНН: " + c.getInn() + ", дата основания: " + c.getFounded());
                }
            }
            System.out.println("\n===============================================================");
            count++;
        }
        System.out.println("\nКоличество просроченных ценных бумаг: " + count);
        //listOfExpiredSecurities.stream().distinct().forEach(security -> companies.strea);

        //Здесь я пытался сделать всё через Streams, но не осилил(((((
        /*companies.stream().flatMap(company -> company.getSecurities().stream()).forEach(secutity -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat[0]);
            LocalDate expiredDate = LocalDate.parse(secutity.getDate(), formatter);
            if(expiredDate.isBefore(currentDate)){
                System.out.println("Код ценной бумаги: " + secutity.getCode() + ", дата истечения: " + secutity.getDate() +", владелец: ");
            }
        });*/
    }
}
