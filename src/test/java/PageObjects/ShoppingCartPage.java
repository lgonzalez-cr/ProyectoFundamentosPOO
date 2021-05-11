package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingCartPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(),'***')]/preceding-sibling::a")
    List<WebElement> productsNameInCart;
    private String allProductsNameAsString = "";
    private WaitsHelperPage waitsHelperPage;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        waitsHelperPage = new WaitsHelperPage(driver);
    }

    public void setAllProductsNameAsString(){
        for (int i = 0; i < productsNameInCart.size(); i++)
            allProductsNameAsString += productsNameInCart.get(i).getText() + " ";
    }

    public List<WebElement> getProductsNameInCart() {
        waitsHelperPage.waitUntilElementExists(productsNameInCart);
        return productsNameInCart;
    }

    public String getAllProductsNameAsString() {
        return allProductsNameAsString;
    }
}
