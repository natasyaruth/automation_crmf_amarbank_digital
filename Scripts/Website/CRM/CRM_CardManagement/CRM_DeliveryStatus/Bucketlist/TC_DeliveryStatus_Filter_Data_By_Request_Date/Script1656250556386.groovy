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
WebUI.verifyElementPresent(menuCardManagement, 5)

/* We want to click menu to expand the menu card management */
WebUI.click(menuCardManagement)

/* We want to identify the element menu delivery status*/
WebUI.verifyElementPresent(menuDeliveryStatus, 5)

/* We want to click menu delivery status page*/
WebUI.click(menuDeliveryStatus)

WebUI.waitForElementPresent(findTestObject('Website/CRM/Card Management/Delivery Status/Bucketlist/DeliveryStatusBtnReqId1'), 
    10)

/* We want to verify text in Bucketlist*/
WebUI.verifyElementVisible(DeliveryStatusText, FailureHandling.STOP_ON_FAILURE)

/* We will verify that filter start date in bucketlist page is exist*/
WebUI.verifyElementVisible(FilterStartDate, FailureHandling.STOP_ON_FAILURE)

/* We will verify that filter end date in bucketlist page is exist*/
WebUI.verifyElementVisible(FilterEndDate, FailureHandling.STOP_ON_FAILURE)

/* We want to get date on column  Tanggal*/
def getRequestDate1 = WebUI.getText(RequestDate1, FailureHandling.STOP_ON_FAILURE)

/* We want to input start date that want to search by*/
WebUI.setText(FilterStartDate, getRequestDate1)

/* We want to input end date that want to search by*/
WebUI.setText(FilterEndDate, getRequestDate1)

/* We want to click button Show*/
WebUI.click(ButtonShow)

/* We want to waiting for data with selected date show on bucketlist*/
WebUI.waitForElementVisible(findTestObject('Website/CRM/Card Management/Delivery Status/Bucketlist/DeliveryStatusTxtRequestDate1'), 
    10)

/* We want to verify request date*/
WebUI.verifyElementPresent(RequestDate1, 5)

/*We want to take a screenshoot*/
WebUI.takeScreenshot()

