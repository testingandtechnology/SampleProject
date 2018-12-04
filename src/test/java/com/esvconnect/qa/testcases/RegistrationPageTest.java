package com.esvconnect.qa.testcases;

import com.esvconnect.qa.base.TestBase;
import com.esvconnect.qa.pages.LoginPage;
import com.esvconnect.qa.pages.DashboardPage;
import com.esvconnect.qa.pages.RegistrationPage;
import utils.Excel.ExcelUtil;
import com.esvconnect.qa.base.TestUtil;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;

public class RegistrationPageTest extends TestBase {

    //test cases should be separated -- independent with each other
    //before each test case -- launch the browser and login
    //@test -- execute test case
    //after each test case -- close the browser

    LoginPage loginPage;
    DashboardPage dashboardPage;
    RegistrationPage registrationPage;
    Logger log = Logger.getLogger(RegistrationPageTest.class);

    TestUtil testUtil;

    String regCardDetails[][] = {{"Registration No.","REC-20174"},{"Issue/ Renewal Date","17/07/2018"},{"Expiry Date","16/07/2023"}};

    public RegistrationPageTest() { super();}

    @BeforeClass
    public void setUp() {
        //initialization();
        testUtil = new TestUtil();
        loginPage = new LoginPage();

        dashboardPage = new DashboardPage();
        ExcelUtil.setExcelFileSheet("Logins");
        dashboardPage = loginPage.login(ExcelUtil.getRowData(1));

        testUtil.switchToFrame0();

        registrationPage = new RegistrationPage();
        registrationPage = dashboardPage.viewRegistration("REC");

        ArrayList tabs = new ArrayList (driver.getWindowHandles());
        driver.switchTo().window(String.valueOf(tabs.get(0)));
        testUtil.switchToFrame1();

        log.info("RegistrationPageTest init Done");
    }

    @Test
    public void initiateCOCTest(){
        registrationPage.initiateCOC();
        log.info("In REC view registration page");
    }
    @Test
    public  void checkTitle(){
        Assert.assertEquals("true","false");    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        log.info("******************  Browser Closed ****************** ");
    };

}