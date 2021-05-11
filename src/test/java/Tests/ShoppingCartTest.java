package Tests;

import DataProviders.ProductsDataProvider;
import DataProviders.UserRegistrationDataProvider;
import PageObjects.HomePage;
import PageObjects.SearchDetailsPage;
import PageObjects.ShoppingCartPage;
import Pojo.ProductData;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ShoppingCartTest extends BaseTest {

    @Test(groups = {"regression"}, dataProvider = "getProductsDataFromJson", dataProviderClass = ProductsDataProvider.class)
    public void addProductToOrderValidation(ProductData product) {
        HomePage homePage = new HomePage(driver);
        SearchDetailsPage searchDetailsPage = new SearchDetailsPage(driver);
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        int actualProductsInCart, expectedAmountOfProducts;

        homePage.searchProduct(product.getName());
        searchDetailsPage.addProductsToCart();
        expectedAmountOfProducts = searchDetailsPage.getProductsFoundName().size();

        homePage.goToCart();
        actualProductsInCart = shoppingCartPage.getProductsNameInCart().size();
        shoppingCartPage.setAllProductsNameAsString();

        Assert.assertEquals(actualProductsInCart, expectedAmountOfProducts, "All products were added to cart");
        for (int i = 0; i < expectedAmountOfProducts; i++) {
            Assert.assertTrue(shoppingCartPage.getAllProductsNameAsString().contains(searchDetailsPage.getProductsFoundName().get(i)));
        }
    }
}
