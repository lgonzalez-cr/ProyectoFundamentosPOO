package DataProviders;

import Pojo.CurrencyData;
import Pojo.UserRegistrationData;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class CurrencyDataProvider {
    @DataProvider(name = "getCurrencyDataFromJson")
    public  Object [][] getUsersDataFromJson() throws FileNotFoundException {
        JsonElement jsonData =  JsonParser.parseReader(new FileReader("src/test/resources/DataFiles/CurrencyData.json"));
        JsonElement usersDataSet = jsonData.getAsJsonObject().get("dataset");
        List<CurrencyData> usersData = new Gson().fromJson(usersDataSet, new TypeToken<List<CurrencyData>>(){}.getType());

        Object[][] returnValue = new Object[usersData.size()][1];

        int index = 0;

        for (Object[] each: returnValue){
            each[0] = usersData.get(index++);
        }
        return  returnValue;
    }
}
