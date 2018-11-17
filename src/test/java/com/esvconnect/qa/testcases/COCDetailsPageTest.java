package com.esvconnect.qa.testcases;

import com.esvconnect.qa.base.TestBase;
import com.esvconnect.qa.pages.*;
import utils.Excel.ExcelUtil;
import com.esvconnect.qa.base.TestUtil;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;


public class COCDetailsPageTest extends TestBase{

    //test cases should be separated -- independent with each other
    //before each test case -- launch the browser and login
    //@test -- execute test case
    //after each test case -- close the browser

    LoginPage loginPage;
    DashboardPage dashboardPage;
    RegistrationPage registrationPage;
    BeforeYouStartCOCPage beforeYouStartPage;
    COCDetailsPage COCDetails;
    TestUtil testUtil;

    Logger log = Logger.getLogger(COCDetailsPageTest.class);

    public COCDetailsPageTest() { super();}

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

        COCDetails = new COCDetailsPage();
        COCDetails = beforeYouStartPage.selectCOCType();

        ArrayList tabs3 = new ArrayList (driver.getWindowHandles());
        driver.switchTo().window(String.valueOf(tabs3.get(0)));
        testUtil.switchToFrame2();

        ExcelUtil.setExcelFileSheet("COCDetails");
    }

    @Test
    public void COCPageTest() {
        COCDetails.fillCOCDetails(ExcelUtil.getRowData(1));
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
        log.info("******************  Browser Closed ****************** ");
    }


}

