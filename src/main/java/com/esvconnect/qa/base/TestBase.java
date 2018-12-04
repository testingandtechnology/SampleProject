package com.esvconnect.qa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import java.util.concurrent.TimeUnit;

public class TestBase {

public static WebDriver driver;
public static Properties prop;

//Global test data excel file
public static final String testDataExcelFileName = System.getProperty("user.dir")+"/src/test/java/testdata/TestData.xlsx";

    //constructor -> getting properties from config file

    public TestBase (){

      try{
          prop = new Properties();
          FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config.properties");
          prop.load(ip);
      }catch(FileNotFoundException e){
          e.printStackTrace();
      } catch (IOException e){
          e.printStackTrace();
      }
    }

    //Method to initiate : Browser

    @BeforeClass
    @Parameters("browser")
    public static void initialization(String browser){

        //String browserName = prop.getProperty("browser");

        if(browser.equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/src/main/resources/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }else if(browser.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+ "/src/main/resources/drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }else if(browser.equalsIgnoreCase("Edge")){
            System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+ "/src/main/resources/drivers/MicrosoftWebDriver.exe");
             driver = new EdgeDriver();
        }

        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

    }

    public static WebDriver getDriver(){
        return driver;

    }


}