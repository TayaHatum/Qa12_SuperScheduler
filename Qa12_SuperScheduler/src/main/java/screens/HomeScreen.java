package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class HomeScreen extends BaseScreen{
    public HomeScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@content-desc='Open']")
    MobileElement burgerMenu;
    @FindBy (xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/nav_fr_logout']")
    MobileElement logout;
    @FindBy (xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/fab_main']")
    MobileElement plusBtn;

    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/fab_add_event']")
    MobileElement fabAddEvent;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/row_root']")
    List<MobileElement> events;

    public EditCreateEventScreen initCreationEvent(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(plusBtn));
        plusBtn.click();
        fabAddEvent.click();

        return new EditCreateEventScreen(driver);
    }



    public EditCreateEventScreen selectFirstEvent(){
        pause(2000);
        MobileElement firstEvent = events.get(0);
        firstEvent.click();

        return new EditCreateEventScreen(driver);
    }

    public boolean isPlusButtonPresent(){
        new WebDriverWait( driver,10)
                .until(ExpectedConditions.visibilityOf(plusBtn));
        return plusBtn.isDisplayed();
    }

    public HomeScreen isPlusButtonPresentAssert(){
        new WebDriverWait( driver,10)
                .until(ExpectedConditions.visibilityOf(plusBtn));
        Assert.assertTrue(plusBtn.isDisplayed());

        return this;
    }

    public HomeScreen openMenu(){
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.visibilityOf(burgerMenu));
        burgerMenu.click();
        return this;
    }
    public LoginScreen logout(){
        logout.click();
        return new LoginScreen(driver);
    }
}
