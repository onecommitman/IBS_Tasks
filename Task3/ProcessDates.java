package IBS_Tasks.Task3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProcessDates {
    static final LocalDate currentDate = LocalDate.now();
    static String[] dateFormat = {"dd.MM.yyyy", "dd/MM/yyyy", "dd/MM/yy"};
    static void expiredSecurities(List<Company> companies){
        //List<Company> resultList = new ArrayList<>();
        //Map<List<Security>, List<Company>> securitiesMao =
        companies.stream().flatMap(company -> company.getSecurities().stream()).forEach(secutity -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat[0]);
            LocalDate expiredDate = LocalDate.parse(secutity.getDate(), formatter);
            if(expiredDate.isBefore(currentDate)){
                System.out.println("Код ценной бумаги: " + secutity.getCode() + ", дата истечения: " + secutity.getDate() +", владелец: ");
            }
        });
    }
}
