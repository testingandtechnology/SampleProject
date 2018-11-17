package com.esvconnect.qa.pages;

import com.esvconnect.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends TestBase {

    //Page Factory

    @FindBy(xpath="//button[contains(text(),'Certify an Electrical Installation')]")
    WebElement btnCOC;

    //Initializing the Page Objects:
    //Constructor

    public RegistrationPage() { PageFactory.initElements(driver, this); }

    //Actions:

    public BeforeYouStartCOCPage initiateCOC(){
        btnCOC.click();
        return new BeforeYouStartCOCPage();
    }
}
