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

/* We want to check from element menu KYC management page*/
WebUI.verifyElementPresent(menuKYCManagement, 5)

/* We want to click menu to expand the KYC management page */
WebUI.click(menuKYCManagement)

/* We want to identify the element menu KYC Video*/
WebUI.verifyElementPresent(menuKYCVideo, 5)

/* We want to click menu KYC Video page*/
WebUI.click(menuKYCVideo)

/* We want to click to access the request detail*/
WebUI.verifyElementPresent(idleCallsTab, 10)

/* We want to click the tab idle calls to find the request ID*/
WebUI.click(idleCallsTab)

/* We will back to dashboard if don't get the request ID */
WebUI.verifyElementPresent(requestID, 5)

/* We will click the second request ID*/
WebUI.click(requestID)

/* We want just makesure we are in KYC Video Detail*/
WebUI.verifyElementText(PIIVideoDetailElement, PIIVideoDetailText)

/* We will capture KYC Video */
WebUI.takeScreenshot()

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

/* We want to check element notification pending request*/
WebUI.verifyElementPresent(pendingRequestNotif, 5)

/* We will capture pending request has been showing after login */
WebUI.takeScreenshot()

/*We want to click pending request*/
WebUI.click(pendingRequestNotif)

/* Then I want to click button back at detail request*/
WebUI.click(btnBackKYCDetail)

/* We want to capture the login page*/
WebUI.takeScreenshot()

/* Delete all cookies */
WebUI.deleteAllCookies()

/* Close the browser */
WebUI.closeBrowser()