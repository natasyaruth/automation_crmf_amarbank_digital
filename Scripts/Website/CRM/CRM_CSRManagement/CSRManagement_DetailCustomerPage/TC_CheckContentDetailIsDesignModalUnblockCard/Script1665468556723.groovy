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

/*Declare keyword util*/
KeywordUtil keyLogger = new KeywordUtil()

WebUI.click(CSRManagementLink)

/*'We want to check blocked notification and check for text blocked
 * if alert confirmation pop up enable is true'*/
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

/* We want to check status is "Block Kartu ATM" and customer type is "Nasabah Senyumku"*/
boolean filterChooseCard = WebUI.verifyElementVisible(drpDwnCardStatus)

if (filterChooseCard == true) {
    WebUI.selectOptionByLabel(drpDwnCardStatus, 'Block Kartu ATM', false)

    if (WebUI.verifyElementVisible(drpDwnCustType, FailureHandling.OPTIONAL)) {
        WebUI.selectOptionByLabel(drpDwnCustType, 'Nasabah Senyumku', false)
    } else {
        keyLogger.markFailed('We not find the drop down by cust type')
    }
    
    WebUI.navigateToUrl(postiveConditionData)
} else {
    keyLogger.markFailed('We don\'t find the drop down Card Status')
}

/*
WebUI.setText(CSRManagementBucketListTxtName, InputName)

WebUI.click(CSRManagementBucketListBtnSearch)

WebUI.click(CSRManagementBucketListBtnDetail)
*/
WebUI.click(BtnDataAccountInfo)

WebUI.click(BtnUnblockCard)

WebUI.takeScreenshot(FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotChecked(findTestObject('Website/CRM/CSR_Management/Details/ChkAskMotherName'), 0)

WebUI.verifyElementNotChecked(findTestObject('Website/CRM/CSR_Management/Details/ChkAskAccountNumber'), 0)

WebUI.verifyElementNotChecked(findTestObject('Website/CRM/CSR_Management/Details/ChkAskPhoneNumber'), 0)

WebUI.verifyElementVisible(findTestObject('Website/CRM/CSR_Management/Details/TxtQuestionMotherNam'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Website/CRM/CSR_Management/Details/TxtQuestionAccountNumber'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Website/CRM/CSR_Management/Details/TxtQuestionPhoneNumber'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Website/CRM/CSR_Management/Details/TxtUnblockCardReason'))

WebUI.verifyElementNotClickable(BtnSubmitUnblockCard)

WebUI.verifyElementClickable(findTestObject('Website/CRM/CSR_Management/Details/BtnCancelUnblockCard'))

WebUI.takeScreenshot()

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnCancelUnblockCard'))

WebUI.click(BtnBack)

