package Tests;

import DataProviders.UserRegistrationDataProvider;
import PageObjects.HomePage;
import PageObjects.RegisterPage;
import Pojo.UserRegistrationData;
import org.testng.Assert;
import org.testng.annotations.Test;


public class RegisterAccountTest extends BaseTest {


    @Test(groups = {"regression"}, dataProvider = "getUserDataFromJson", dataProviderClass = UserRegistrationDataProvider.class)
    public void userRegistrationValidation(UserRegistrationData userRegistrationData) {
        HomePage homePage = new HomePage(driver);
        homePage.goToRegisterPage();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.enterPersonalDetails(userRegistrationData);
        registerPage.enterPassword(userRegistrationData);
        registerPage.acceptPrivacyPolicy();
        registerPage.submitRegistration();

        boolean wasAccountCreated = homePage.getAccountCreationText().isDisplayed();
        Assert.assertEquals(wasAccountCreated, true, "Account created");
    }
}
