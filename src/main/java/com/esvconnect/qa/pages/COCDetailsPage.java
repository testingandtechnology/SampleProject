package com.esvconnect.qa.pages;

import com.esvconnect.qa.base.TestBase;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class COCDetailsPage extends TestBase {

    Actions action = new Actions(driver);

    //Page Factory

    // Customer Details

    @FindBy(xpath="//input[@id='CustomerName']")
    WebElement customerName;

    @FindBy(xpath="//input[@id='CustomerPhone']")
    WebElement customerPhone;

    //Details of electrical installation

    //@FindBy(xpath="//input[@id='DateWorkCompleted']") //a[@id='todayLink']

    @FindBy(xpath="//img[@data-ctl='[\"DatePicker\"]']")
    WebElement dateWorkCompleted1;

    @FindBy(xpath="//a[@id='todayLink']")
    WebElement dateWorkCompleted2;

    @FindBy(xpath="//input[@name='$PpyWorkPage$pCaseData$pCoC$pInstallationAddress$ppySearchText']")
    WebElement installationAddress;

    @FindBy(xpath="//button[@name='AddressValidate_pyWorkPage.CaseData.CoC.InstallationAddress_4']")
    WebElement btnSearch;

    @FindBy(xpath="//label[@class='rb_ rb_standard radioLabel' and @for ='PSMAAddressIDGAVIC421625446']")
    WebElement selectAddress;

    @FindBy(xpath="//a[@name='WorkDescriptionPrescribed_pyWorkPage.CaseData.CoC_2']")
    WebElement selectWorkDesc;

    @FindBy(xpath="//input[@name='$PpyWorkPage$pCaseData$pCoC$pWorkDescriptionTemplates$l1$ppyIsSelected' and @type='checkbox']")
    WebElement selectWDTemplate;

    @FindBy(xpath="//button[@id='ModalButtonSubmit']")
    WebElement btnAppend;

    @FindBy(xpath="//input[@name='$PpyWorkPage$pCaseData$pCoC$pMaxAmpsPerPhase']")
    WebElement maxDemand;

    @FindBy(xpath="//input[@name='$PpyWorkPage$pCaseData$pCoC$pMainsCapacityInAmps']")
    WebElement mainsCapacity;

    @FindBy(xpath="//select[@id='PropertyType']")
    WebElement propertyType;

    @FindBy(xpath="//input[@data-target='$PpyWorkPage$pCaseData$pCoC$pInstallationWorkType']")
    WebElement prescribedWork;

    @FindBy(xpath="//i[@class='pi pi-caret-down' and @data-active='false']")
    WebElement downArrow;

    @FindBy(xpath="//span[contains(text(),'1. Consumer Mains')]")
    WebElement lookUp;

    @FindBy(xpath="//label[@for='NPSWorkIncludedNo']")
    WebElement includeNonprescribedWork;

    @FindBy(xpath="//label[@for='HasFailedPreviousInspectionYes']")
    WebElement failedPrevInspection;

    @FindBy(xpath="//input[@id='PreviousFailedInspectionCertNumber']")
    WebElement certNumber;

    //Test Results

    //Attachments

    //Declaration

    @FindBy(xpath="//input[@name='$PpyWorkPage$pIsDeclarationAccepted' and @type = 'checkbox']")
    WebElement declarationCheck;

    //Submit

    @FindBy(xpath="//button[@name='pyCaseActionAreaButtons_pyWorkPage_22']")
    WebElement btnSubmit;

    @FindBy(xpath="//button[@name='pyCaseActionAreaButtons_pyWorkPage_21']")
    WebElement btnSave;


    //Initializing the Page Objects:
    //Constructor

    public COCDetailsPage() { PageFactory.initElements(driver, this); }

    //Actions:

    public void fillCOCDetails(XSSFRow row){

        // Customer Details

        customerName.sendKeys(row.getCell(0).toString());
        customerPhone.sendKeys(row.getCell(1).toString());

        dateWorkCompleted1.click();
        dateWorkCompleted2.click();;

        installationAddress.sendKeys(row.getCell(3).toString());
        btnSearch.click();
        selectAddress.click();

        selectWorkDesc.click();
        selectWDTemplate.click();
        btnAppend.click();

        maxDemand.sendKeys(row.getCell(4).toString());
        mainsCapacity.sendKeys(row.getCell(5).toString());

        Select dropdown1 = new Select(propertyType);
        dropdown1.selectByValue(row.getCell(6).toString());

        prescribedWork.click();
        downArrow.click();
        lookUp.click();

        includeNonprescribedWork.click();
        failedPrevInspection.click();
        certNumber.sendKeys(row.getCell(8).toString());

        //Test Results

        //Attachments

        //Declaration
        declarationCheck.click();

        //Save

        btnSave.click();


    }
}
