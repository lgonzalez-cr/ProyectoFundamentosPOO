package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SearchDetailsPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(),'Add to Cart')]/..")
    List<WebElement> productsFoundAddToCart;

    @FindBy(xpath = "//div/h4/a")
    List<WebElement> productsFoundNameElements;

    List<String> productsFoundName;


    public SearchDetailsPage(WebDriver driver) {
        super(driver);
        productsFoundName = new ArrayList<String>();
    }

    public void addProductsToCart(){
        for (int i = 0; i < productsFoundAddToCart.size(); i++) {
            productsFoundAddToCart.get(i);
            productsFoundAddToCart.get(i).click();
            productsFoundName.add(productsFoundNameElements.get(i).getText());
        }
    }

    public List<String> getProductsFoundName() {
        return productsFoundName;
    }

    public void selectFirstElementOfSearchResults(){
        productsFoundNameElements.get(0).click();
    }

}
