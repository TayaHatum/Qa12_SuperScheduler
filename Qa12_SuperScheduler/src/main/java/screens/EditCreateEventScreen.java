package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import models.Event;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class EditCreateEventScreen extends BaseScreen{
    public EditCreateEventScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/info_title_input']")
    MobileElement title;

    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/info_type_input']")
    MobileElement type;

    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/info_break_plus_btn']")
    MobileElement breakPlusBtn;

    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/info_wage_edit']")
    MobileElement wageEdit;

    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/info_wage_input']")
    MobileElement wageInput;

    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/info_wage_save']")
    MobileElement wageSave;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/info_save_btn']")
    MobileElement saveBtn;
    @FindBy (xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/row_day_number_txt']")
    List<MobileElement> days;

    public  EditCreateEventScreen actionDataNextDay(){
        pause(2000);

        MobileElement element = days.get(2);
        Rectangle rect = element.getRect();
        int height = rect.getHeight();
        int yDay = rect.getY();

        Dimension size = driver.manage().window().getSize();


        int xFrom = rect.getX()+rect.getWidth();
        int xTo = size.getWidth()/2;
        int y=yDay+ height/2;


        TouchAction<?> action = new TouchAction<>(driver);
        action.longPress(PointOption.point(xFrom,y))
                .moveTo(PointOption.point(xTo,y))
                .release()
                .perform();
        return this;
    }
    public HomeScreen createNewEvent(Event event){

        new WebDriverWait(driver,10)
                .until(ExpectedConditions.visibilityOf(title));
        type(title, event.getTitle());
        type(type, event.getType());
        driver.hideKeyboard();

        int breaks = event.getBreaks();
        if(breaks>0 && breaks<5){
            for (int i=0;i<breaks;i++){
                breakPlusBtn.click();
            }
        }
        wageEdit.click();
        type(wageInput,String.valueOf(event.getWage()));
        wageSave.click();
        //driver.hideKeyboard();
        saveBtn.click();


        return new HomeScreen(driver);

    }
}
