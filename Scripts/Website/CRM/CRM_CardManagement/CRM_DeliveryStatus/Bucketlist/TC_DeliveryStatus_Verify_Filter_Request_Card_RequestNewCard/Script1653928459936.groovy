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
WebUI.verifyTextPresent(DeliveryStatusText, false)

/* We will verify that filter request card type is exist*/
WebUI.verifyElementPresent(FilterRequestCardType, 5)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/Card Management/Delivery Status/Bucketlist/DeliveryStatusDrpSortByRequestType'), 
    FilterRequestCardType_RequestNewCard, false)

/* We will select Request Card type value "Kartu Baru"*/
WebUI.verifyOptionSelectedByLabel(findTestObject('Website/CRM/Card Management/Delivery Status/Bucketlist/DeliveryStatusDrpSortByRequestType'), 
    FilterRequestCardType_RequestNewCard, false, 5)

WebUI.takeScreenshot()

