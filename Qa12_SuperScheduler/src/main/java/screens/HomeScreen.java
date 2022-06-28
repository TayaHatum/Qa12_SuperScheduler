package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
