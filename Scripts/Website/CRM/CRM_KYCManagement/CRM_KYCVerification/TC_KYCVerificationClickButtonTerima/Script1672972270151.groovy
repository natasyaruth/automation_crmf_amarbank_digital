import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable

import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

WebUI.click(KYCManagementLink)

WebUI.click(KYCVerificationLink)

//WebDriver driver = DriverFactory.getWebDriver()
//WebElement tblKycVerif = driver.findElement(By.)

WebUI.selectOptionByLabel(DrpCustomerType, 'Nasabah Baru', true)

WebUI.selectOptionByLabel(DrpEmailType, 'Terverifikasi', true)

WebUI.click(BtnDetailKYCVerification)
WebUI.waitForPageLoad(5)
WebUI.delay(3)

String reqIdKyc = WebUI.getText(txtReqIdKycVerif)

WebUI.click(BtnFaceMatchDukcapil)
WebUI.waitForPageLoad(5)
WebUI.delay(3)

WebUI.click(BtnFaceMatchConfirmation)

WebUI.click(BtnLiveness)
WebUI.waitForPageLoad(5)
WebUI.delay(3)

WebUI.click(BtnLivenessConfirmation)

WebUI.scrollToElement(BtnCekDataDukcapil, 5)
WebUI.waitForPageLoad(5)
WebUI.delay(3)

WebUI.click(BtnCekDataDukcapil)

WebUI.waitForElementVisible(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/TxtCekDataDukcapilConfirmation'), 
    10)

WebUI.verifyElementClickable(BtnCekDataDukcapilConfirmation)

WebUI.verifyElementClickable(BtnCancelCekDataDukcapil)

WebUI.click(BtnCekDataDukcapilConfirmation)

WebUI.scrollToElement(BtnAccept1, 10)

WebUI.click(BtnAccept1)

WebUI.scrollToElement(BtnAccept2, 10)

WebUI.click(BtnAccept2)
WebUI.waitForPageLoad(5)
WebUI.delay(5)

WebUI.waitForElementPresent(BtnCloseModal, 20)

WebUI.verifyElementClickable(BtnCloseModal)

WebUI.click(BtnCloseModal)

/*Declare keyword util*/
KeywordUtil keyLogger = new KeywordUtil()

WebUI.click(findTestObject('Website/CRM/CSR_Management/CSRManagement/CSRManagementLink'))

if (WebUI.waitForElementVisible(blockBylockedUserElement, 5, FailureHandling.OPTIONAL)) {
    boolean checkAlertProcess = WebUI.verifyElementVisible(alertConfirmationPopUpElement)

    if (checkAlertProcess == true) {
        WebUI.verifyElementText(alertConfirmationPopUpElement, alertConfirmationPopUpText)

        WebUI.click(btnCancelPopUpElement)

        WebUI.delay(2)

        WebUI.waitForElementVisible(headerCSRManagementElement, 5)

        WebUI.verifyElementText(headerCSRManagementElement, headerCSRManagementText)
    } else {
        keyLogger.markFailed('We don\'t find alert confirmation')
    }
    
    WebUI.waitForElementVisible(headerCSRManagementElement, 5)

    WebUI.verifyElementText(headerCSRManagementElement, headerCSRManagementText)
} else {
    WebUI.verifyElementText(headerCSRManagementElement, headerCSRManagementText)
}

WebUI.setText(CSRManagementBucketListTxtRequestId, reqIdKyc)

WebUI.click(CSRManagementBucketListBtnSearch)

WebUI.click(CSRManagementBucketListBtnDetail)

WebUI.scrollToElement(BtnDataChangeLog, 10)

WebUI.click(BtnDataChangeLog)

WebUI.selectOptionByLabel(fltrChgLog, "KYC Verification", false)

WebUI.verifyElementText(TxtTerimaChangeLog, 'Terima')

WebUI.click(BtnBack)

