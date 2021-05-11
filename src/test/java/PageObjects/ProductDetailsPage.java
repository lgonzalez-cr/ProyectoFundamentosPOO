package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends BasePage {

    @FindBy(xpath = "//ul/li/h2")
    WebElement productPrice;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getProductPrice() {
        return productPrice;
    }
}
