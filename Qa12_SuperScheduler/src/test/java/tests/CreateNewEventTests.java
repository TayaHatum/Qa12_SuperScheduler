package tests;

import manager.Configuration;
import models.Event;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import screens.HomeScreen;
import screens.LoginScreen;

public class CreateNewEventTests extends Configuration {


    @BeforeClass
    public void precondition(){
        //login
        new LoginScreen(driver)
                .complexLogin(User.builder().email("wick@gmail.com").password("Ww12345$").build());
    }

    @Test
    public void addNewEventSuccess(){
        // add new event
        Event event = Event.builder()
                .title("New Event")
                .type("new Type")
                .breaks(2)
                .wage(50).build();


       boolean isPlusPresent = new HomeScreen(driver)
                .initCreationEvent()
                .createNewEvent(event)
                .isPlusButtonPresent();
        Assert.assertTrue(isPlusPresent);
    }

    @Test
    public void addNewSuccessSecond(){


        new HomeScreen(driver)
                .initCreationEvent()
                .createNewEvent(Event.builder()
                        .title("EventSecond")
                        .type("party")
                        .breaks(3)
                        .wage(80)
                        .build())
                .isPlusButtonPresentAssert();
    }


    @Test
    public void addNewEventNextDay(){


        new HomeScreen(driver)
                .initCreationEvent()
                .actionDataNextDay()
                .createNewEvent(Event.builder()
                        .title("Event Next")
                        .type("next day")
                        .breaks(3)
                        .wage(40)
                        .build())
                .isPlusButtonPresentAssert();
    }


    @AfterClass
    public void postcondition(){
        //logout;
        new HomeScreen(driver)
                .openMenu()
                .logout();

    }
}
