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

/* We want to check menu card management is visible*/
WebUI.waitForElementVisible(menuCardManagement, 10)

WebUI.verifyElementVisible(menuCardManagement, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(menuCardManagement, 10)

WebUI.verifyElementPresent(menuCardManagement, 5)

/* We want to click menu to expand the menu card management */
WebUI.click(menuCardManagement)

/* We want to identify the element menu delivery status*/
WebUI.waitForElementVisible(menuDeliveryStatus, 10)

WebUI.verifyElementVisible(menuDeliveryStatus, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(menuDeliveryStatus, 5)

/* We want to click menu delivery status page*/
WebUI.click(menuDeliveryStatus)

/* We wait for bucketlist delivery status is opened */
WebUI.waitForElementVisible(FilterRequestCardType, 10)

WebUI.waitForElementPresent(FilterRequestCardType, 10)

WebUI.verifyTextPresent(DeliveryStatusText, false)

/* We will verify that searchfield in bucketlist page is exist*/
WebUI.verifyElementVisible(TextfieldSearchRefID, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(TextfieldSearchRefID, 5)

/* We will verify that filter start date in bucketlist page is exist*/
WebUI.verifyElementVisible(FilterStartDate, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(FilterStartDate, 5)

/* We will verify that filter end date in bucketlist page is exist*/
WebUI.verifyElementVisible(FilterEndDate, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(FilterEndDate, 5)

/* We will verify that button Show in bucketlist page is exist*/
WebUI.verifyElementVisible(ButtonShow, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(ButtonShow, 5)

/* We will verify that filter delivery status in bucketlist page is exist*/
WebUI.verifyElementVisible(FilterDeliveryStatus, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(FilterDeliveryStatus, 5)

/* We will verify that filter request card type in bucketlist page is exist*/
WebUI.verifyElementVisible(FilterRequestCardType, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(FilterRequestCardType, 5)

/* We will capture delivery status page */
WebUI.takeScreenshot()

/* We will refresh the page*/
WebUI.refresh()

