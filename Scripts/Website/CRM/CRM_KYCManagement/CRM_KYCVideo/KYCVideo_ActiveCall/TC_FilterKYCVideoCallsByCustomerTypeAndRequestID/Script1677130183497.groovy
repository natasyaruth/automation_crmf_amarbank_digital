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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

/*'Declaration keylog forloggin'*/
KeywordUtil keyLogger = new KeywordUtil()

/*'We want to makesure we can access KYC Management'*/
boolean checkMenuKYC = WebUI.verifyElementVisible(menuKYCManagement, FailureHandling.OPTIONAL)

if (checkMenuKYC == true) {
    WebUI.click(menuKYCManagement)

    WebUI.click(menuKYCVideo)
} else {
    keyLogger.markFailed('Something happen with menu KYC Management')
}

/* Open Tab Active Call KYC Video*/
WebUI.waitForElementVisible(TabActiveCall, 5)

WebUI.click(TabActiveCall)

/* Get request id name from the fisrt row*/
def RequestID = WebUI.getText(BtnRequestID)

/* We want to input request ID*/
WebUI.verifyElementVisible(TxtSearchRequestID, FailureHandling.OPTIONAL)

WebUI.setText(TxtSearchRequestID, RequestID)

SearchRequestID = WebUI.getAttribute(TxtSearchRequestID, 'value')

/* Verify Dropdown Filter by Customer Type*/
WebUI.verifyElementVisible(DrpCustomerType, FailureHandling.OPTIONAL)

WebUI.selectOptionByLabel(DrpCustomerType, All, false)

WebUI.delay(1)

WebUI.selectOptionByLabel(DrpCustomerType, NewCustomer, false)

WebUI.delay(1)

WebUI.selectOptionByLabel(DrpCustomerType, SenyumkuCustomer, false)

WebUI.delay(1)

WebUI.selectOptionByLabel(DrpCustomerType, TunaikuLeadgenCustomer, false)

WebUI.delay(1)

WebUI.selectOptionByLabel(DrpCustomerType, SenyumkuDepositoCustomer, false)

WebUI.delay(1)

WebUI.click(BtnSearch)

def SearchRequestID1 = WebUI.getAttribute(TxtSearchRequestID,'value')
def firstRowRequestID = WebUI.getText(BtnRequestID)
WebUI.verifyMatch(firstRowRequestID, SearchRequestID1, false)

WebUI.takeScreenshot()

/* We want to refresh for the next process*/
WebUI.refresh()

