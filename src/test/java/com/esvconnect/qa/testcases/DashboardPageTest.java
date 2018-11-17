package com.esvconnect.qa.testcases;

import com.esvconnect.qa.base.TestBase;
import com.esvconnect.qa.pages.LoginPage;
import com.esvconnect.qa.pages.DashboardPage;
import com.esvconnect.qa.pages.RegistrationPage;
import utils.Excel.ExcelUtil;
import com.esvconnect.qa.base.TestUtil;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DashboardPageTest extends TestBase {

    //test cases should be separated -- independent with each other
    //before each test case -- launch the browser and login
    //@test -- execute test case
    //after each test case -- close the browser

    LoginPage loginPage;
    DashboardPage dashboardPage;
    RegistrationPage registrationPage;

    TestUtil testUtil;
    Logger log = Logger.getLogger(RegistrationPageTest.class);

    public DashboardPageTest() { super();}

    @BeforeClass
    public void setUp() {
        //initialization();
        testUtil = new TestUtil();

        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();

        ExcelUtil.setExcelFileSheet("Logins");
        dashboardPage = loginPage.login(ExcelUtil.getRowData(1));

        registrationPage = new RegistrationPage();
        log.info("DashboardPageTest init Done");
    }

    @Test
    public void viewRegistration() {
        testUtil.switchToFrame0();
        registrationPage = dashboardPage.viewRegistration("REC");
        log.info("COC has been initiated");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        log.info("******************  Browser Closed ****************** ");
    };

}