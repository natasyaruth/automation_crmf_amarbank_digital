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
if (WebUI.waitForElementVisible(blockBylockedUserElement, 5, FailureHandling.OPTIONAL)) {
    boolean checkAlertProcess = WebUI.verifyElementVisible(alertConfirmationPopUpElement)

    if (checkAlertProcess == true) {
        WebUI.verifyElementText(alertConfirmationPopUpElement, alertConfirmationPopUpText)

        WebUI.click(btnCancelPopUpElement)

        WebUI.waitForElementVisible(headerCSRManagementElement, 5)

        WebUI.verifyElementText(headerCSRManagementElement, headerCSRManagementText)
    } else {
        keyLogger.markFailed('We don\'t find alert confirmation')
    }
    
    WebUI.waitForElementVisible(headerCSRManagementElement, 5, FailureHandling.OPTIONAL)

    WebUI.verifyElementText(headerCSRManagementElement, headerCSRManagementText)
} else {
    WebUI.verifyElementText(headerCSRManagementElement, headerCSRManagementText)
}

/* We want to verify element start date is visible"*/
/* We want verify element field start date*/
WebUI.verifyElementPresent(DtpStartFilterDate, 5)

WebUI.verifyElementVisible(DtpStartFilterDate, FailureHandling.OPTIONAL)

/* We want to get first row date element*/
def firstDate = WebUI.getText(firstRowDateElement)

/* We want input start date */
WebUI.setText(DtpStartFilterDate, firstDate)

/* We want to verify element end date is visible"*/
/* We want verify element field end date*/
WebUI.verifyElementPresent(DtpEndFilterDate, 5)

WebUI.verifyElementVisible(DtpEndFilterDate, FailureHandling.OPTIONAL)

/* We want input end date */
WebUI.setText(DtpEndFilterDate, SeventhDate)

/* We want verify button "Tampilkan" */
WebUI.waitForElementVisible(ButtonShow, 5)

WebUI.verifyElementPresent(ButtonShow, 5)

WebUI.verifyElementVisible(ButtonShow, FailureHandling.OPTIONAL)

/* We want to screen capture the page*/
WebUI.takeScreenshot()

/* We want click button "Tampilkan"*/
WebUI.click(ButtonShow)

/* We want verify first row date visible*/
WebUI.verifyElementPresent(firstRowDateElement, 5)

/* We want verify element and text for first element*/
WebUI.verifyElementText(firstRowDateElement, firstDate)

/* We want capture the result*/
WebUI.takeScreenshot()

/* We want to refresh for the next process*/
WebUI.refresh()

