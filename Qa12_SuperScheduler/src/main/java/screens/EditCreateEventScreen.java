package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

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
}
