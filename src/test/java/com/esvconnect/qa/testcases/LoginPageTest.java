package com.esvconnect.qa.testcases;
import com.esvconnect.qa.base.TestBase;
import com.esvconnect.qa.pages.LoginPage;
import com.esvconnect.qa.pages.DashboardPage;

import org.apache.log4j.Priority;
import utils.Excel.ExcelUtil;
import org.testng.annotations.*;
import org.apache.log4j.Logger;


public class LoginPageTest extends TestBase {

    //test cases should be separated -- independent with each other
    //before each test case -- launch the browser and login
    //@test -- execute test case
    //after each test case -- close the browser

    LoginPage loginPage;
    DashboardPage dashboardPage;
    Logger log = Logger.getLogger(LoginPageTest.class);

    public LoginPageTest() { super();}

    @BeforeClass
    public void setUp() {
        log.info("****************** Initialize and Setup Loginpage data ****************** ");
        //initialization(String browserName);
        loginPage = new LoginPage();
        ExcelUtil.setExcelFileSheet("Logins");
        log.info("LoginPageTest init Done");
    }

    @Test
    public void loginTest(){
        log.info("******************   Executing LoginPage Test  ****************** ");
        dashboardPage = loginPage.login(ExcelUtil.getRowData(1));
    }


   @AfterClass
   public void tearDown() {
       driver.quit();
       log.info("******************  Browser Closed ****************** ");
    };
}