package tests;

import manager.Configuration;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screens.HomeScreen;
import screens.LoginScreen;

public class DeleteEventTest extends Configuration {

    @BeforeClass
    public void preCondition(){
        new LoginScreen(driver)
                .complexLogin(User.builder().email("wick@gmail.com").password("Ww12345$").build());

    }

    @Test
    public void deleteEvent(){
        boolean isPlusBtnPresent = new HomeScreen(driver)
                .selectFirstEvent()
                .deleteEvent()
                .isPlusButtonPresent();
        Assert.assertTrue(isPlusBtnPresent);
    }

}
