package com.esvconnect.qa.pages;

import com.esvconnect.qa.base.TestBase;
import com.esvconnect.qa.base.TestUtil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class BeforeYouStartCOCPage extends TestBase {
    TestUtil testUtil;

    //Page Factory

        @FindBy(xpath="//label[@class='rb_ rb_standard radioLabel' and contains(text(),'Prescribed')]")
        WebElement radioButtonPrescribed;

        @FindBy(xpath="//input[@name='$PpyWorkPage$pCaseData$ppySearchText']")
        WebElement LEWTextField;

        @FindBy(xpath="//div[@class='pz-po-c autocompleteAG lookupPO  popover_ac_']")
        WebElement lookUp;

        @FindBy(xpath="//button[contains(text(),'Submit') and @name='pyCaseActionAreaButtons_pyWorkPage_22']")
        WebElement btnSubmit;

        //Initializing the Page Objects:
        //Constructor

        public BeforeYouStartCOCPage() { PageFactory.initElements(driver, this); }

        //Actions:

        public COCDetailsPage selectCOCType() {

            testUtil = new TestUtil();

            radioButtonPrescribed.click();

            Actions action = new Actions(driver);
            action.sendKeys(LEWTextField,"A20171").perform();
            action.sendKeys(Keys.ARROW_DOWN).click();
            action.moveToElement(lookUp).click().perform();

            driver.getCurrentUrl();
            ArrayList tabs2 = new ArrayList (driver.getWindowHandles());
            driver.switchTo().window(String.valueOf(tabs2.get(0)));
            testUtil.switchToFrame2();

            btnSubmit.click();

            return new COCDetailsPage();
        }
}
