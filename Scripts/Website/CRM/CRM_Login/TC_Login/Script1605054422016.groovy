import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.util.CryptoUtil as CryptoUtil
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

'Init menu keylogging in katalon studio'
KeywordUtil keylogger = new KeywordUtil()

/* We want to force to wait the page loaded*/
WebUI.waitForPageLoad(20)
WebUI.delay(5)
/* We want to maximize the window*/
WebUI.maximizeWindow()

/* We will check availability logo when login page*/
WebUI.verifyElementPresent(logoLoginPage, 5)

/* we will check availability button login in login page */
WebUI.waitForElementVisible(btnLogin, 10)

/* we want to check element is present*/
WebUI.verifyElementPresent(btnLogin, 5)

/* we will verify text in button login */
WebUI.verifyTextPresent(btnLoginText, false)

/* we will click button login */
WebUI.click(btnLogin)

/* we will wait loading page */
WebUI.waitForPageLoad(100)

'Update testcase login to display menu and submenu'
WebUI.waitForElementPresent(menuDashboard, 5)
if (WebUI.waitForElementPresent(menuKycManagement, 5)) {
	WebUI.click(menuKycManagement)
	WebUI.waitForElementPresent(menuKYCVideo, 5)
	WebUI.waitForElementPresent(menuKYCVerif, 5)
	WebUI.waitForElementPresent(menuKYCAutomate, 5)
	WebUI.takeScreenshot()
} else {keylogger.markError('Menu KYC management is disable')}
if (WebUI.waitForElementPresent(menuCardManagement, 5)) {
	WebUI.click(menuCardManagement)
	WebUI.waitForElementPresent(menuAssignCard, 5)
	WebUI.waitForElementPresent(menuCardPrinting, 5)
	WebUI.waitForElementPresent(menuDeliveryStatus, 5)
	WebUI.takeScreenshot()
} else {keylogger.markError('Menu Card Management is disable')}
WebUI.waitForElementPresent(menuCSRManagement, 5)
WebUI.waitForElementPresent(menuLeadsManagement, 5)
WebUI.waitForElementPresent(menuUploadPhoto, 5)
WebUI.waitForElementPresent(menuLogout, 5)
WebUI.click(menuDashboard)