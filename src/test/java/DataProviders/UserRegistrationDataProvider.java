package DataProviders;

import Pojo.UserRegistrationData;
import Util.Commons;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;

import java.util.List;

public class UserRegistrationDataProvider {

    @DataProvider(name = "getUserDataFromJson")
    public  Object [][] getUsersDataFromJson() throws FileNotFoundException {
        JsonElement jsonData =  JsonParser.parseReader(new FileReader("src/test/resources/DataFiles/UserDataForRegistration.json"));
        JsonElement usersDataSet = jsonData.getAsJsonObject().get("dataset");
        List<UserRegistrationData> usersData = new Gson().fromJson(usersDataSet, new TypeToken<List<UserRegistrationData>>(){}.getType());


        Object[][] returnValue = new Object[usersData.size()][1];

        int index = 0;

        for (Object[] each: returnValue){
            usersData.get(index).setEmail(generateUniqueEmail(usersData.get(index).getEmail()));
            each[0] = usersData.get(index++);
        }
        return  returnValue;
    }

    public String generateUniqueEmail(String currentEmail){
        String [] emailParts = currentEmail.split("@");
        return  Commons.now() + "@" + emailParts[1];
    }
}
