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

/* We want to verify and check element on menu reporting*/
WebUI.verifyElementPresent(menuReporting, 5)

/* We want to click then expand the menu reporting*/
WebUI.click(menuReporting)

/*We want to verify and check element on menu agent reporting*/
WebUI.verifyElementPresent(menuAgentReporting, 5)

/* We want to click and open the bucket list agent reporting*/
WebUI.click(menuAgentReporting)

/* We want to makesure we are in bucket list agent reporting*/
WebUI.verifyElementText(spanAgentReportingElement, spanAgentReportingText)

/* We want to check the element one on each agent detail*/
WebUI.verifyElementPresent(agentDetailID, 5)

/* We want to click the details agent*/
WebUI.click(agentDetailID)

/* We want to makesure we are in report agent details*/
WebUI.verifyElementText(titleAgentDetailElement, titleAgentDetailText)

/* We want to capture the agent report detail*/
WebUI.takeScreenshot()

/* We will check element visible logout */
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
WebUI.verifyElementPresent(dashboardTextElement, 5)

/* We want to verify text dashboard as a evidance we back to login*/
WebUI.verifyTextPresent(dashboardText, false)

/* We will capture pending request has been showing after login */
WebUI.takeScreenshot()

/* Delete all cookies */
WebUI.deleteAllCookies()

/* Close the browser */
WebUI.closeBrowser()
