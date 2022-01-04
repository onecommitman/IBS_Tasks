package IBS_Tasks.Task3;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.util.List;


public class ProcessJson {
    List<Company> companies;
    public ProcessJson(String jsonString) {
        companies = deserialize(jsonString);
    }

    public List<Company> getCompanies() {
        return companies;
    }

    static class CompaniesModel {
        private List<Company> companies;

        List<Company> getCompanies() {
            return companies;
        }
    }

    //private final Gson gson = new GsonBuilder().create();
    Gson gson = new Gson();

    private List<Company> deserialize(String s) throws JsonSyntaxException {
        CompaniesModel companiesArray = gson.fromJson(s, CompaniesModel.class);
        return companiesArray.getCompanies();
    }

}
