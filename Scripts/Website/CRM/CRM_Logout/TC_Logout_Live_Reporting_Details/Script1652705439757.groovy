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

/* We want to handle for menu reporting must visible first*/
WebUI.waitForElementVisible(menuReporting, 5)

/* We want to check from menu Reporting*/
WebUI.verifyElementPresent(menuReporting, 5)

/* We want to click menu to expand the menu Reporting */
WebUI.click(menuReporting)

/* We want to identify the element menu KYC Verification*/
WebUI.verifyElementPresent(menuLiveReporting, 5)

/* We want to click menu KYC Video page*/
WebUI.click(menuLiveReporting)

/* We want to switch tab on tab 1 to check the live report*/
WebUI.switchToWindowIndex(1)

/* We want to wait and check the element header just to know we are in the page*/
WebUI.verifyElementPresent(headerLiveReportingFunding, 10)

/* We want check we are on live reporting page*/
WebUI.verifyElementText(headerLiveReportingFunding, headerLiveReportingFundingText)

/* We want to check content KYC Video*/
WebUI.verifyElementText(contentKYCVideo, contentKYCVideoText)

/* We want to check content KYC Verification*/
WebUI.verifyElementText(contentKYCVerification, contentKYCVerificationText)

/* We want to check content Bulk Printing*/
WebUI.verifyElementText(contentBulkPrinting, contentBulkPrintingText)

/* We want to check content Delivery Status*/
WebUI.verifyElementText(contentDeliveryStatus, contentDeliveryStatusText)

/* We will capture Live Reporting */
WebUI.takeScreenshot()

/*We want to back at senyumku page*/
WebUI.switchToWindowIndex(0)

/* We will check element visible */
WebUI.waitForElementVisible(linkLogout, 10)

/* We will click the button or link logout */
WebUI.click(linkLogout)

/* We will verify the logo Senyumku after logout */
WebUI.verifyElementPresent(logoSenyumku, 30)

/* We want to verify the button login just for makesure to back at login page*/
WebUI.verifyElementPresent(btnLogin, 10)

/* We will capture KYC Video */
WebUI.takeScreenshot()

/* We want to click button login to login again same as a scenario */
WebUI.click(btnLogin)

/* we want verify we get back to dashboard menu*/
WebUI.verifyElementPresent(dashboardText, 5)

/* We want to verify text dashboard as a evidance we back to login*/
WebUI.verifyTextPresent(dashboard, false)

/* We will capture pending request has been showing after login */
WebUI.takeScreenshot()

/* Delete all cookies */
WebUI.deleteAllCookies()

/* Close the browser */
WebUI.closeBrowser()