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
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

/* Setup for keylogger*/
KeywordUtil keylogger = new KeywordUtil()
/* We want to makesure to access delivery status */
if (WebUI.waitForElementVisible(menuDeliveryStatusElement, 5, FailureHandling.OPTIONAL)) {
	WebUI.click(menuDeliveryStatusElement)
	WebUI.verifyElementText(headerTextPageElement, "Delivery Status")
	WebUI.verifyElementPresent(firstColoumnRequestIdElement, 5)
	keylogger.logInfo("We found the menu delivery status")
} else {
	WebUI.waitForElementVisible(menuCardManagementElement, 5)
	WebUI.verifyElementText(menuCardManagementElement, "Card Management")
	WebUI.click(menuCardManagementElement)
	WebUI.waitForElementVisible(menuDeliveryStatusElement, 5)
	WebUI.click(menuDeliveryStatusElement)
	WebUI.verifyElementText(headerTextPageElement, "Delivery Status")
	WebUI.verifyElementPresent(firstColoumnRequestIdElement, 5)
	keylogger.logInfo("We must access card management first")
}
/* We want to verify drop down filter delivery status*/
WebUI.waitForElementVisible(drpDwnFilterDeliveryStatusElement, 5)
/* We want to select pickup filter "Pengambilan"*/
WebUI.selectOptionByLabel(drpDwnFilterDeliveryStatusElement, "Terkirim", false)
/* We want to wait for first row data from pickup selection*/
WebUI.waitForElementVisible(firstColoumnRequestIdElement, 5)
/* We want to click the data first row*/
WebUI.click(firstColoumnRequestIdElement)
/* We want to wait for visible detail page*/
/* We want to verify the header text of detail page*/
WebUI.verifyElementText(headerTextDetailElement, "Delivery Detail")
/* We want to capture the page*/
WebUI.takeScreenshot()
/* We want to verify request ID*/
WebUI.verifyElementPresent(valueOfReqId, 5)
/* We want to verify reference ID*/
WebUI.verifyElementPresent(valueOfRefId, 5)
/* We want to verify text page is "Pengambilan"*/
WebUI.verifyElementText(pickupTextElement, "Terkirim")
/* We want to verify customer name*/
WebUI.verifyElementPresent(customerNameElement, 5)
/* We want to verify card type*/
WebUI.verifyElementPresent(valueCardTypeElement, 5)
/* We want to verify receipt number*/
WebUI.verifyElementPresent(valueReceiptNumber, 5)
/* We want to verify name of receive the card*/
WebUI.verifyElementPresent(valueNameReceiveCardElement, 5)
/* We want to verify phone number of receive the card*/
WebUI.verifyElementPresent(valuePhoneNumberReceiveCardElement, 5)
/* We want to verify photo of receive the card*/
WebUI.verifyElementPresent(imageOfReceiveNumber, 5)
/* We want to get text from info in Riwayat History*/
def textShippingHistory = WebUI.getText(headerTextShippingHistoryElement)
/* We want to verify text shipping history*/
WebUI.verifyElementText(headerTextShippingHistoryElement, textShippingHistory)
/* We want to verify shipping history*/
WebUI.verifyElementPresent(messageFirstRowElement, 5)
/* We want to wait until visible button "kembali"*/
WebUI.verifyElementVisible(btnBackDeliveryStatus)
/* We want verify button back from detail page customer*/
WebUI.verifyElementPresent(btnBackDeliveryStatus, 5)
/* We want capture the detail page*/
WebUI.takeScreenshot()
/* We want to click button back*/
WebUI.click(btnBackDeliveryStatus)
/* We want to wait the element until visible*/
WebUI.waitForElementVisible(menuDeliveryStatusElement, 5)
/* We want to verify we are in delivery status bucket list page*/
WebUI.verifyElementText(headerTextPageElement, "Delivery Status")
/* We want to verify first data loaded in bucket list*/
WebUI.verifyElementPresent(firstColoumnRequestIdElement, 5)
/* We want to refresh the page*/
WebUI.refresh()