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

/* We want to verify text in Bucketlist*/
WebUI.verifyElementVisible(DeliveryStatusText, FailureHandling.STOP_ON_FAILURE)

/* We will verify that searchfield in bucketlist page is exist*/
WebUI.verifyElementPresent(TextfieldSearchRefID, 5)

/* We want to click button next page in bucketlist*/
WebUI.click(findTestObject('Website/CRM/Card Management/Delivery Status/Bucketlist/DeliveryStatusBtnNextPage'))

/* We want to screenshot the 2nd page*/
WebUI.takeScreenshot()

/* We want to click button previous page in bucketlist*/
WebUI.click(findTestObject('Website/CRM/Card Management/Delivery Status/Bucketlist/DeliveryStatusBtnPreviousPage'))

/* We want to screenshot the previous page*/
WebUI.takeScreenshot()

/* We want to click button last page in bucketlist*/
WebUI.click(findTestObject('Website/CRM/Card Management/Delivery Status/Bucketlist/DeliveryStatusBtnLastPage'))

/* We want to screenshot the last page*/
WebUI.takeScreenshot()

/* We want to click button last page in bucketlist*/
WebUI.click(findTestObject('Website/CRM/Card Management/Delivery Status/Bucketlist/DeliveryStatusBtnFirstPage'))

WebUI.takeScreenshot()

