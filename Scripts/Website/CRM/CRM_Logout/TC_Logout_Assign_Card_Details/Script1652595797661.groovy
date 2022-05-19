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

/* We want to check from Menu Card Management page*/
WebUI.verifyElementPresent(menuCardManagement, 5)

/* We want to click menu to expand the menu card management */
WebUI.click(menuCardManagement)

/* We want to identify the element menu Assign Card*/
WebUI.verifyElementPresent(menuAssignCard, 5)

/* We want to click menu Assign Card page*/
WebUI.click(menuAssignCard)

/* We will verify the element request ID */
WebUI.verifyElementPresent(requestID, 5)

/* We will click the second request ID*/
WebUI.click(requestID)

/* We just add the period time to check the card text element*/
WebUI.verifyElementPresent(addCardTextElement, 10)

/* We will verify we are in assign card*/
WebUI.verifyElementText(addCardTextElement, addCardText)

/* We will capture assign card detail */
WebUI.takeScreenshot()

/* We will check element visible */
WebUI.waitForElementVisible(linkLogout, 10)

/* We will click the button or link logout */
WebUI.click(linkLogout)

/* We will verify the logo Senyumku after logout */
WebUI.verifyElementPresent(logoSenyumku, 30)

/* We want to verify the button login just for makesure to back at login page*/
WebUI.verifyElementPresent(btnLogin, 10)

/* We will capture */
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
/* We just want unblock the process assign card to process next test*/
/* We want to check from Menu Card Management page*/
WebUI.verifyElementPresent(menuCardManagement, 5)
/* We want to click menu to expand the menu card management */
WebUI.click(menuCardManagement)
/* We want to identify the element menu Assign Card*/
WebUI.verifyElementPresent(menuAssignCard, 5)
/* We want to click menu Assign Card page*/
WebUI.click(menuAssignCard)
/* We see the notification continue the process*/
WebUI.waitForElementVisible(popUpNotificationElement, 5)
/* We see text "konfirmasi" process assign card*/
WebUI.verifyElementText(confirmationPopUpNotificationElement, confirmationPopUpNotificationText)
/* We want to click "batal" to process next assign card*/
WebUI.click(btnAbortPopUpNotificationElement)
/*-----------------------------------------------------------------------*/

/* Delete all cookies */
WebUI.deleteAllCookies()

/* Close the browser */
WebUI.closeBrowser()