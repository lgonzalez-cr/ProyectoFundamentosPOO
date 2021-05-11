package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//span[@class='caret']")
    private WebElement myAccount;

    @FindBy(xpath = "//ul/li/a[contains(text(),'Register')]")
    private WebElement registerAccount;

    @FindBy(xpath = "//ul/li/a[contains(text(),'Logout')]")
    private WebElement logoutAccount;

    @FindBy(xpath = "//h1[contains(text(), 'Your Account Has Been Created!')]")
    private WebElement accountCreationText;

    @FindBy(name = "search")
    private WebElement searchBar;

    @FindBy(xpath = "//div[@id='search']//button")
    private WebElement searchBtn;

    @FindBy(xpath = "//a[@title='Shopping Cart']")
    private WebElement shoppingCart;

    @FindBy(xpath = "//strong[contains(text(),'View Cart')]/..")
    private WebElement viewCart;

    @FindBy(xpath = "//form[@id='form-currency']/div/button")
    private WebElement currencyBtn;

    private WaitsHelperPage waitsHelperPage;

    public HomePage(WebDriver driver) {
        super(driver);
        waitsHelperPage = new WaitsHelperPage(driver);
    }

    public WebElement getAccountCreationText() {
        return accountCreationText;
    }

    public void goToRegisterPage() {
        myAccount.click();
        registerAccount.click();
    }

    public void searchProduct(String productName) {
        waitsHelperPage.waitUntilElementIsClickable(searchBar);
        searchBar.sendKeys(productName);
        waitsHelperPage.waitUntilElementIsClickable(searchBtn);
        searchBtn.click();
    }

    public void goToCart() {
        waitsHelperPage.waitUntilElementIsClickable(shoppingCart);
        clickElementUsingJS(shoppingCart);
    }

    public void changeCurrency(String currencyLocatorName) {
        currencyBtn.click();
        driver.findElement(By.name(currencyLocatorName)).click();
    }
}
