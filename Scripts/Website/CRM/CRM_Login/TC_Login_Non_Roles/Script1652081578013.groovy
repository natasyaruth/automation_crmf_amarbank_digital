import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
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

/* We will check availability logo when login page*/
WebUI.waitForElementVisible(logoLoginPage, 100)

/* we will check availability button login in login page */
WebUI.waitForElementVisible(btnLogin, 10)

/* we will verify text in button login */
WebUI.verifyTextPresent(btnLoginText, false)

/* we will click button login */
WebUI.click(btnLogin)

/* we will wait loading page */
WebUI.waitForPageLoad(100)

// Commented, because of localization in CircleCI
// WebUI.verifyTextPresent(verifyFieldEmail, false, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.waitForElementVisible(fieldEmailLogin, 10)

/* We will screen capture the username field */
WebUI.takeScreenshot()

/* we will decode gmail account from encryption on test data*/
WebUI.sendKeys(fieldEmailLogin, CryptoUtil.decode(CryptoUtil.getDefault(gmailAccount)))

/* we will click button next on gmail*/
WebUI.click(btnNext)

WebUI.waitForPageLoad(10)

WebUI.waitForElementVisible(fieldPasswordLogin, 30)

/* We will screen capture the password field */
WebUI.takeScreenshot()

// Commented, because of localization in CircleCI
// WebUI.verifyTextPresent(verifyFieldPassword, false, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.sendKeys(fieldPasswordLogin, CryptoUtil.decode(CryptoUtil.getDefault(gmailPassword)))

/* We will click submit the password */
WebUI.click(btnPasswordNext)

WebUI.waitForElementPresent(gridInfoLogin, 100)

WebUI.waitForPageLoad(10)

/* We will define new test object with spesific condition */
TestObject txtUsername = new TestObject().addProperty('text', ConditionType.CONTAINS, username)

WebUI.verifyElementPresent(txtUsername, 30)

WebUI.takeScreenshot()