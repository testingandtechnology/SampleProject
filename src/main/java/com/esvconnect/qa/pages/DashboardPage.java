package com.esvconnect.qa.pages;

import com.esvconnect.qa.base.TestBase;
import com.esvconnect.qa.base.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


public class DashboardPage extends TestBase {

    TestUtil testUtil;
    //Page Factory

    @FindBy(xpath="//h3[text() = 'REC' and @class='layout-group-item-title']")
    WebElement RECTab;

    @FindBy(xpath="//h3[text() = 'CPS' and @class='layout-group-item-title']")
    WebElement CPSTab;

    @FindBy(xpath="//h3[text() = 'IC' and @class='layout-group-item-title']")
    WebElement ICTab;

    @FindBy(xpath="//a[contains(text(), 'REC-20175')]")
    WebElement RECRegistrationID;

    @FindBy(xpath="//button[contains(text(),'Certify an Electrical Installation')]")
    WebElement btnCOC;

    //Initializing the Page Objects:
    //Constructor

    public DashboardPage() {
        PageFactory.initElements(driver, this);
    }

    //Actions:
    public RegistrationPage viewRegistration(String tabname)  {

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (tabname.equals("REC")) {
            RECTab.click();
            RECRegistrationID.click();
        } else if (tabname.equals("CPS")) {
            CPSTab.click();
        } else if (tabname.equals("IC")) {
            ICTab.click();
        }

        return new RegistrationPage();
    }

}