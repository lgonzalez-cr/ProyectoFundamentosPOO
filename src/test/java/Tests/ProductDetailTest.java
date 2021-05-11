package Tests;

import DataProviders.CurrencyDataProvider;
import PageObjects.HomePage;
import PageObjects.ProductDetailsPage;
import PageObjects.SearchDetailsPage;
import Pojo.CurrencyData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductDetailTest extends BaseTest{

    @Test(groups = {"regression"}, dataProvider = "getCurrencyDataFromJson", dataProviderClass = CurrencyDataProvider.class)
    public void validateCurrencies(CurrencyData currencyData) {
        HomePage homePage = new HomePage(driver);
        SearchDetailsPage searchDetailsPage = new SearchDetailsPage(driver);
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);

        homePage.searchProduct("Mac");
        searchDetailsPage.selectFirstElementOfSearchResults();
        homePage.changeCurrency(currencyData.getElementName());
        Assert.assertTrue(productDetailsPage.getProductPrice().getText().contains(currencyData.getCurrencySymbol()), "Price is updated according to currency");
    }
}
