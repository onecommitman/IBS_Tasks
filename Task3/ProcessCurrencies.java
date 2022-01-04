package IBS_Tasks.Task3;

import java.util.Arrays;
import java.util.List;

public class ProcessCurrencies {
    static void processCurrencies(List<Company> companies, String currency){
        for(Company company:companies){
            for(Security security:company.getSecurities()){
                if(Arrays.asList(security.getCurrency()).contains(currency)){
                    System.out.println("ID компании: " + company.getId() + ", код ценной бумаги: " + security.getCode());
                }
            }
        }
    }
}
