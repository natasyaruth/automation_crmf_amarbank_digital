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

/* We want to check the conditional if we search by data is exist/found*/
/* We want to get KTP id*/
WebUI.verifyElementVisible(BtnDetail, FailureHandling.OPTIONAL)

WebUI.click(BtnDetail)

WebUI.waitForElementVisible(NavigationDataKTP, 30)

WebUI.verifyElementVisible(NavigationDataKTP)

WebUI.click(NavigationDataKTP)

WebUI.waitForElementVisible(dataKTPNumber, 30)

WebUI.verifyElementVisible(dataKTPNumber, FailureHandling.OPTIONAL)

def KTPid = WebUI.getText(dataKTPNumber)

WebUI.click(BtnBack)

WebUI.waitForElementVisible(fieldKTPid, 15)

/* We want to input KTP id*/
WebUI.verifyElementVisible(fieldKTPid, FailureHandling.OPTIONAL)

WebUI.setText(fieldKTPid, KTPid)

/* We want to get first row Name*/
def Name = WebUI.getText(FirstRowName)

/* We want to input Name*/
WebUI.verifyElementVisible(fieldName, FailureHandling.OPTIONAL)

WebUI.setText(fieldName, Name)

/* We want to get first row Phone Number*/
def PhoneNumber = WebUI.getText(FirstRowPhoneNumber)

/* We want to input phone number*/
WebUI.verifyElementVisible(fieldPhoneNumber, FailureHandling.OPTIONAL)

WebUI.setText(fieldPhoneNumber, PhoneNumber)

/* We want to get first row Bank account number*/
def BankAccountNumber = WebUI.getText(FirstRowBankAccountNumber)

/* We want to input bank account number*/
WebUI.verifyElementVisible(fieldAccountNumber, FailureHandling.OPTIONAL)

WebUI.setText(fieldAccountNumber, BankAccountNumber)

/* We want verify element field start date*/
WebUI.verifyElementPresent(DtpStartFilterDate, 5)

WebUI.verifyElementVisible(DtpStartFilterDate, FailureHandling.OPTIONAL)

/* We want to get first row date element*/
def firstDate = WebUI.getText(firstRowDateElement)

/* We want input start date */
WebUI.setText(DtpStartFilterDate, firstDate)

/* We want verify element field end date*/
WebUI.verifyElementPresent(DtpEndFilterDate, 5)

WebUI.verifyElementVisible(DtpEndFilterDate, FailureHandling.OPTIONAL)

/* We want input end date */
WebUI.setText(DtpEndFilterDate, firstDate)

/*Click button Show*/
WebUI.click(btnShow)

/* We want to select Status card*/
WebUI.verifyElementVisible(drpDwnChooseStatusCard, FailureHandling.OPTIONAL)

WebUI.selectOptionByLabel(drpDwnChooseStatusCard, 'Semua', false)

/* We want to select  Filter Customer type*/
WebUI.verifyElementVisible(FilterCustomerType, FailureHandling.OPTIONAL)

WebUI.selectOptionByLabel(FilterCustomerType, 'Semua', false)

/* Click button Search*/
WebUI.click(btnSearch)

/* Take Screenshot*/
WebUI.takeScreenshot()

/* Verify data is found page*/
WebUI.verifyElementVisible(FirstRowName, FailureHandling.OPTIONAL)

WebUI.verifyElementPresent(FirstRowName, 15)

WebUI.verifyElementVisible(FirstRowPhoneNumber, FailureHandling.OPTIONAL)

WebUI.verifyElementPresent(FirstRowPhoneNumber, 15)

WebUI.verifyElementVisible(FirstRowBankAccountNumber, FailureHandling.OPTIONAL)

WebUI.verifyElementPresent(FirstRowBankAccountNumber, 15)

WebUI.verifyElementVisible(firstRowDateElement, FailureHandling.OPTIONAL)

WebUI.verifyElementPresent(firstRowDateElement, 15)
/* Take Screenshot*/
WebUI.takeScreenshot()

/* Do refresh to the page*/
WebUI.refresh()

