package com.esvconnect.qa.testcases;

import com.esvconnect.qa.base.TestBase;
import com.esvconnect.qa.pages.*;
import utils.Excel.ExcelUtil;
import com.esvconnect.qa.base.TestUtil;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class BeforeYouStartCOCPageTest extends TestBase {
    //test cases should be separated -- independent with each other
    //before each test case -- launch the browser and login
    //@test -- execute test case
    //after each test case -- close the browser

    LoginPage loginPage;
    DashboardPage dashboardPage;
    RegistrationPage registrationPage;
    BeforeYouStartCOCPage beforeYouStartPage;
    COCDetailsPage cocPage;

    TestUtil testUtil;

    Logger log = Logger.getLogger(BeforeYouStartCOCPageTest.class);

    public BeforeYouStartCOCPageTest() { super();}

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

        ArrayList tabs1 = new ArrayList (driver.getWindowHandles());
        driver.switchTo().window(String.valueOf(tabs1.get(0)));
        testUtil.switchToFrame1();

        beforeYouStartPage = new BeforeYouStartCOCPage();
        beforeYouStartPage = registrationPage.initiateCOC();

        ArrayList tabs2 = new ArrayList (driver.getWindowHandles());
        driver.switchTo().window(String.valueOf(tabs2.get(0)));
        testUtil.switchToFrame2();

        cocPage = new COCDetailsPage();
    }


    @Test
    public void selectCOCTypeTest() throws InterruptedException {
        cocPage = beforeYouStartPage.selectCOCType();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        log.info("******************  Browser Closed ****************** ");
         };
}
