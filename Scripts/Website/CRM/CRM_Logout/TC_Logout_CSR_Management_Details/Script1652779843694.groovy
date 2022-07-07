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

/* We want to check from menu CSR Management*/
WebUI.verifyElementPresent(menuCSRManagement, 5)

/* We want to click menu to CSR Management Page */
WebUI.click(menuCSRManagement)

if (WebUI.waitForElementVisible(headerConfirmationElement, 5, FailureHandling.OPTIONAL)) {
	/* We want to verify header "konfirmasi" Text*/
	WebUI.verifyElementText(headerConfirmationElement, headerConfirmationText)
	/* We want to click button abort or "batal" */
	WebUI.click(btnCancelNotification)
	/* We verify we are in CSR Management page */
	WebUI.verifyElementText(headerCSRManagementElement, headerCSRManagementText)
} else {
	/* We verify we are in CSR Management page */
	WebUI.verifyElementText(headerCSRManagementElement, headerCSRManagementText)
}

/* We will back to dashboard if don't get the request ID */
WebUI.verifyElementPresent(requestID, 5)

/* We will click the second request ID*/
WebUI.click(requestID)

/* We want verify and wait available element header text*/
WebUI.waitForElementVisible(headerDetailNasabahElement, 10)

/* We want makesure we are in customer detail page*/
WebUI.verifyElementText(headerDetailNasabahElement, headerDetailNasabahText)

/* We will capture CSR Management */
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

/* We will capture pending request has been showing after login */
WebUI.takeScreenshot()

/* We want to unblock process on CSR Management Details*/
/* We want to click the menu CSR Management*/
WebUI.click(menuCSRManagement)

if (WebUI.waitForElementVisible(headerConfirmationElement, 5, FailureHandling.OPTIONAL)) {
	/* We want to verify header "konfirmasi" Text*/
	WebUI.verifyElementText(headerConfirmationElement, headerConfirmationText)
	/* We want to click button abort or "batal" */
	WebUI.click(btnCancelNotification)
	/* Delete all cookies */
	WebUI.deleteAllCookies()
	/* Close the browser */
	WebUI.closeBrowser()
} else {
	/* Delete all cookies */
	WebUI.deleteAllCookies()
	/* Close the browser */
	WebUI.closeBrowser()
}