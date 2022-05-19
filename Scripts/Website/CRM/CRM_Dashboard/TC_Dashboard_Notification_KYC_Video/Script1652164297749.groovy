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
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

/* we want to check availability elemet h1 dashboard */
WebUI.waitForElementVisible(headerDashboardElement, 10)

/* we want check the text as we know is dashboard */
WebUI.verifyTextPresent(headerDashboardText, false)

/* we want to verify element on KYC menu*/
WebUI.verifyElementPresent(menuKYCManagement, 10)

/* we want to click the KYC menu*/
WebUI.click(menuKYCManagement)

/* we want to verify element on KYC video request*/
WebUI.verifyElementPresent(videoKYCRequest, 10)

/* we want to capture KYC Management and KYC Video Request*/
WebUI.takeScreenshot()

/* we want to click the video kyc request*/
WebUI.click(videoKYCRequest)

/* we want to choose the idle calls tab*/
WebUI.verifyElementPresent(idleCallsTab, 10)

/* we want click idle calls tab*/
WebUI.click(idleCallsTab)

/* we want to verify element for request Id*/
WebUI.verifyElementVisible(requestIdElement)

/* we want capture request Id in video request*/
WebUI.takeScreenshot(FailureHandling.OPTIONAL)

/* we want to click the request Id*/
WebUI.click(requestIdElement)

/* We verify we in KYC Video details*/
WebUI.verifyElementText(headerPersonalIdentifierElement, headerPersonalIdentifierText)

/* we want check dashboard menu element*/
WebUI.verifyElementPresent(dashboardMenuElement, 10)

/* we want to click dashboard menu*/
WebUI.click(dashboardMenuElement)

/* we want check notification video pending*/
WebUI.verifyElementPresent(notificationVideoPendingElement, 10)

/* we want capture the pending notification request*/
WebUI.takeScreenshot(FailureHandling.OPTIONAL)

/* we want to click notification video pending*/
WebUI.click(notificationVideoPendingElement)

/* we want to check element present video KYC request */
WebUI.verifyElementPresent(headerKYCVideoRequestElement, 10)

/* we want to check text header KYC video request*/
WebUI.verifyTextPresent(headerKYCVideoRequestText, false)

/* we want to check element present personal identifier*/
WebUI.verifyElementPresent(headerPersonalIdentifierElement, 10)

/* we want verify text personal identifier*/
WebUI.verifyTextPresent(headerPersonalIdentifierText, false)

/* we want to capture details in request ID*/
WebUI.takeScreenshot()

/* we want to verify button back for unlock pending request*/
WebUI.verifyElementPresent(btnBackVideoRequestElement, 10)

/* we want to click button "kembali" to makesure the request id is unlock*/
WebUI.click(btnBackVideoRequestElement)