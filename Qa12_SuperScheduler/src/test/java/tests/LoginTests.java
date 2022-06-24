package tests;

import manager.Configuration;
import org.testng.annotations.Test;
import screens.LoginScreen;

public class LoginTests extends Configuration {

    @Test
    public void loginSuccess(){

        new LoginScreen(driver)
                .fillEmail("wick@gmail.com")
                .fillPassword("Ww12345$")
                .clickLoginButton()
                .isPlusButtonPresentAssert()
                .openMenu()
                .logout();



    }
    @Test
    public void loginSuccessSecond(){

        new LoginScreen(driver)
                .fillEmail("noa@gmail.com")
                .fillPassword("Nnoa12345$")
                .clickLoginButton()
                .isPlusButtonPresentAssert()
                .openMenu()
                .logout();

    }
}
