package DataProviders;

import Pojo.CurrencyData;
import Pojo.ProductData;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class ProductsDataProvider {
    @DataProvider(name = "getProductsDataFromJson")
    public  Object [][] getUsersDataFromJson() throws FileNotFoundException {
        JsonElement jsonData =  JsonParser.parseReader(new FileReader("src/test/resources/DataFiles/Products.json"));
        JsonElement usersDataSet = jsonData.getAsJsonObject().get("dataset");
        List<ProductData> usersData = new Gson().fromJson(usersDataSet, new TypeToken<List<ProductData>>(){}.getType());

        Object[][] returnValue = new Object[usersData.size()][1];

        int index = 0;

        for (Object[] each: returnValue){
            each[0] = usersData.get(index++);
        }
        return  returnValue;
    }
}
