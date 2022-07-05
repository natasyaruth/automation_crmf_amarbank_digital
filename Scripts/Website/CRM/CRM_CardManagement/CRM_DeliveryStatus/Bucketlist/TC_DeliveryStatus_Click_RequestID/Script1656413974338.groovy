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

/* We want to check from menu card management*/
WebUI.waitForElementPresent(menuCardManagement, 10)

WebUI.verifyElementPresent(menuCardManagement, 5)

/* We want to click menu to expand the menu card management */
WebUI.click(menuCardManagement)

/* We want to identify the element menu delivery status*/
WebUI.verifyElementPresent(menuDeliveryStatus, 5)

/* We want to click menu delivery status page*/
WebUI.click(menuDeliveryStatus)

WebUI.waitForElementPresent(FilterRequestCardType, 10)

/* We want to verify text in Bucketlist*/
WebUI.verifyElementVisible(DeliveryStatusText, FailureHandling.STOP_ON_FAILURE)

/* We will verify that searchfield in bucketlist page is exist*/
WebUI.verifyElementPresent(TextfieldSearchRefID, 5)

/* We want to wait column Request ID is exist*/
WebUI.waitForElementVisible(ColumnRequestID, 10)

/* We want to verify column Request ID is exist*/
WebUI.verifyElementVisible(ColumnRequestID)

/* We will verify column requestid*/
WebUI.verifyElementPresent(ColumnRequestID, 5)

/* We want to click Request ID to open detail*/
WebUI.click(ButtonRequestID)

/* We want to verify button Back is exist*/
WebUI.waitForElementVisible(ButtonBack, 10)

/* We want to verify button Back is clickable*/
WebUI.verifyElementClickable(ButtonBack)

/* We will capture delivery status detail */
WebUI.takeScreenshot()

/* We want to click Back to bucketlist*/
WebUI.click(ButtonBack)

/* We will capture delivery status page */
WebUI.takeScreenshot()

/* We want to refresh the page */
WebUI.refresh()

