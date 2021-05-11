package PageObjects;

import Pojo.UserRegistrationData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{

    @FindBy(id = "input-firstname")
    private WebElement firstNameTxt;

    @FindBy(id = "input-lastname")
    private WebElement lastNameTxt;

    @FindBy(id = "input-email")
    private WebElement emailTxt;

    @FindBy(id = "input-telephone")
    private WebElement telephoneTxt;

    @FindBy(id = "input-password")
    private WebElement passwordTxt;

    @FindBy(id = "input-confirm")
    private WebElement passwordConfirmTxt;

    @FindBy(name = "agree")
    private WebElement privacyPolicyChkTxt;

    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement continueBtnTxt;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void enterPersonalDetails(UserRegistrationData userDetails){
        firstNameTxt.sendKeys(userDetails.getFirstName());
        lastNameTxt.sendKeys(userDetails.getLastName());
        emailTxt.sendKeys(userDetails.getEmail());
        telephoneTxt.sendKeys(userDetails.getTelephone());
    }

    public void enterPassword(UserRegistrationData userDetails){
        passwordTxt.sendKeys(userDetails.getPassword());
        passwordConfirmTxt.sendKeys(userDetails.getConfirmPassword());
    }

    public void acceptPrivacyPolicy(){
        privacyPolicyChkTxt.click();
    }

    public void submitRegistration(){
        continueBtnTxt.click();
    }
}
