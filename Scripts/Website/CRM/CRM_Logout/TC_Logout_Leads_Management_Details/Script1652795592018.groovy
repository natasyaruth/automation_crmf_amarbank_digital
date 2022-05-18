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

/* We want to check from menu Leads management*/
WebUI.verifyElementPresent(leadsManagement, 5)

/* We want to click menu to expand the Leads Management Page */
WebUI.click(leadsManagement)

/* We want to verify we are in leads management*/
WebUI.verifyElementText(headerLeadsManagementElement, headerLeadsManagementText)

/* We will verify the leads detail */
WebUI.verifyElementPresent(requestID, 5)

/* We will click the leads detail*/
WebUI.click(requestID)

/* We want to verify we are in leads detail*/
WebUI.verifyElementText(headerLeadsManagementDetailCustomerElement, headerLeadsManagementDetailCustomerText)

/* We will capture leads detail */
WebUI.takeScreenshot()

/* We will check element visible */
WebUI.waitForElementVisible(linkLogout, 10)

/* We will click the button or link logout */
WebUI.click(linkLogout)

/* We will verify the logo Senyumku after logout */
WebUI.verifyElementPresent(logoSenyumku, 30)

/* We want to verify the button login just for makesure to back at login page*/
WebUI.verifyElementPresent(btnLogin, 10)

/* We will capture the login page */
WebUI.takeScreenshot()

/* We want to click button login to login again same as a scenario */
WebUI.click(btnLogin)

/* we want verify we get back to dashboard menu*/
WebUI.verifyElementPresent(dashboardText, 5)

/* We want to verify text dashboard as a evidance we back to login*/
WebUI.verifyTextPresent(dashboard, false)

/* We will capture pending request has been showing after login */
WebUI.takeScreenshot()

/*-----------------------------------------------------------------------*/
/*We want to unblock the process in leads management because it caused the blocked next process*/
/* We want to click menu leads management*/
WebUI.click(leadsManagement)
/* We want to wait until element visible*/
WebUI.waitForElementVisible(popUpConfirmationBox, 5)
/* We want to wait for element visible notification pop up*/
WebUI.waitForElementVisible(headerLeadsManagementNotificationElement, 5)
/* We want to verify the button "batal" from pop up notification*/
WebUI.verifyElementPresent(popUpBtnCancelElement, 5)
/* We want to click button "batal" to unblock the notification*/
WebUI.click(popUpBtnCancelElement)
/*-----------------------------------------------------------------------*/

/* Delete all cookies */
WebUI.deleteAllCookies()

/* Close the browser */
WebUI.closeBrowser()