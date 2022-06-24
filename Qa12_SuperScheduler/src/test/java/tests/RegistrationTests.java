package tests;

import manager.Configuration;
import org.testng.annotations.Test;
import screens.SplashScreen;

public class RegistrationTests extends Configuration {

    @Test
    public void registrationSuccess(){

        new SplashScreen(driver)
                .checkVersion("0.0.3")
                .fillEmail("wick@gmail.com")
                .fillPassword("Ww12345$")
                .clickLoginButton();
    }
}
