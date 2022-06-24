package tests;

import manager.Configuration;
import org.testng.annotations.Test;
import screens.LoginScreen;
import screens.SplashScreen;

public class RegistrationTests extends Configuration {

    @Test
    public void registrationSuccess(){

        int i = (int)(System.currentTimeMillis()/1000)%3600;
        new SplashScreen(driver)
                .checkVersion("0.0.3")
                .fillEmail("wick"+i+"@gmail.com")
                .fillPassword("Ww12345$")
                .clickLoginButtonForReg()
                .skipWizard()
                .openMenu()
                .logout();
    }

    @Test
    public void registrationSuccessSecond(){

        int i = (int)(System.currentTimeMillis()/1000)%3600;
//        new SplashScreen(driver)
//                .checkVersion("0.0.3")
        new LoginScreen(driver)
                .fillEmail("wick"+i+"@gmail.com")
                .fillPassword("Ww12345$")
                .clickLoginButtonForReg()
                .skipWizard()
                .openMenu()
                .logout();
    }
}
