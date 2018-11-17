package com.esvconnect.qa.pages;

import com.esvconnect.qa.base.TestBase;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends TestBase {

    //Page Factory

        @FindBy(name="UserIdentifier")
        WebElement username;

        @FindBy(name="Password")
        WebElement password;

        @FindBy(name="pyActivity=Code-Security.Login")
        WebElement loginBtn;

    //Initializing the Page Objects:
    //Constructor
    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    //Actions:
    public DashboardPage login(XSSFRow row){

        username.sendKeys(row.getCell(0).toString());
        password.sendKeys(row.getCell(1).toString());
        loginBtn.click();

        driver.navigate().refresh();

        return new DashboardPage();
    }

}
