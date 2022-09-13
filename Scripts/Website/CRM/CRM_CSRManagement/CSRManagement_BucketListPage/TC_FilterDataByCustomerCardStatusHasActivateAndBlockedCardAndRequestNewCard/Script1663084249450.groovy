import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import java.util.concurrent.locks.Condition as Condition
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.sun.org.apache.bcel.internal.generic.RETURN as RETURN
import groovy.transform.ConditionalInterrupt as ConditionalInterrupt
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.remote.server.handler.RefreshPage as RefreshPage
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils

/*'Declaration keylog forloggin'*/
KeywordUtil keyLogger = new KeywordUtil()

/*'We want to makesure we can access CSR Management'*/
boolean checkMenuCsr = WebUI.verifyElementVisible(menuCSRManagement, FailureHandling.OPTIONAL)

if (checkMenuCsr == true) {
    WebUI.click(menuCSRManagement)
} else {
    keyLogger.markFailed('Something happen with menu CSR Management')
}

/*'We want to check blocked notification and check for text blocked 
 * if alert confirmation pop up enable is true'*/
if (WebUI.waitForElementVisible(blockBylockedUserElement, 15, FailureHandling.OPTIONAL)) {
    boolean checkAlertProcess = WebUI.verifyElementVisible(alertConfirmationPopUpElement)

    if (checkAlertProcess == true) {
        WebUI.verifyElementText(alertConfirmationPopUpElement, alertConfirmationPopUpText)

        WebUI.click(btnCancelPopUpElement)

        WebUI.waitForElementVisible(headerCSRManagementElement, 15)

        WebUI.verifyElementText(headerCSRManagementElement, headerCSRManagementText)
    } else {
        keyLogger.markFailed('We don\'t find alert confirmation')
    }
    
    WebUI.waitForElementVisible(headerCSRManagementElement, 5)

    WebUI.verifyElementText(headerCSRManagementElement, headerCSRManagementText)
} else {
    WebUI.verifyElementText(headerCSRManagementElement, headerCSRManagementText)
}

/* We want to select Status card likes "Belum Aktivasi","Sudah Aktivasi", "Block Kartu ATM", "Permintaan Kartu Baru" */
WebUI.verifyElementVisible(drpDwnChooseStatusCard, FailureHandling.OPTIONAL)

WebUI.selectOptionByLabel(drpDwnChooseStatusCard, HasNotActivated, false)

WebUI.waitForElementVisible(firstRowNoRek, 15)

WebUI.selectOptionByLabel(drpDwnChooseStatusCard, HasActivated, false)

WebUI.waitForElementVisible(firstRowNoRek, 15)

WebUI.selectOptionByLabel(drpDwnChooseStatusCard, BlockedCard, false)

WebUI.waitForElementVisible(firstRowNoRek, 15)

WebUI.selectOptionByLabel(drpDwnChooseStatusCard, RequestNewCard, false)

WebUI.delay(5)

/* Verify data is found page*/
WebUI.waitForElementVisible(FirstRowCustomerType, 5)

WebUI.verifyElementVisible(FirstRowCustomerType, FailureHandling.OPTIONAL)

WebUI.verifyElementPresent(FirstRowCustomerType, 15)

WebUI.verifyTextPresent(SenyumkuCustomerType, false)

WebUI.waitForElementVisible(firstRowNoRek, 15)

/* Take Screenshot*/
WebUI.takeScreenshot()

/*Click button detail for the customer data in row 1*/
WebUI.click(BtnDetail)

WebUI.delay(5)

/*Navigate to Data Kartu ATM*/
WebUI.click(NavigateToCardSection)

/*Verify flag card type status "Block Kartu ATM"*/
WebUI.waitForElementVisible(MaximizeATMDataInfo, 15)

WebUI.verifyElementVisible(MaximizeATMDataInfo, FailureHandling.OPTIONAL)

WebUI.click(MaximizeATMDataInfo)

WebUI.waitForElementVisible(FlagRequestNewCard, 15)

WebUI.verifyElementVisible(FlagRequestNewCard, FailureHandling.OPTIONAL)

WebUI.verifyTextPresent(RequestNewCard, false)

/*Verify flag card type status "Belum Aktivasi"*/
WebUI.waitForElementVisible(FlagHasNotActivated, 15)

WebUI.verifyElementVisible(FlagHasNotActivated, FailureHandling.OPTIONAL)

WebUI.verifyTextPresent(HasNotActivated, false)

WebUI.verifyElementNotClickable(ButtonRequestNewCard)

WebUI.verifyElementNotClickable(ButtonBlockCard)

WebUI.delay(5)

/* Take Screenshot*/
WebUI.takeScreenshot()

/*Back to Bucketlist*/
WebUI.click(BtnBack)

/* Verify bucketlist*/
WebUI.waitForElementVisible(headerCSRManagementElement, 15)

WebUI.verifyElementVisible(headerCSRManagementElement, FailureHandling.OPTIONAL)

/* Do refresh to the page*/
WebUI.refresh()

