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

WebUI.waitForPageLoad(100)

WebUI.waitForElementVisible(findTestObject('Website/CRM/Login/BtnLogin'), 10)

WebUI.verifyTextPresent(btnLogin, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Website/CRM/Login/BtnLogin'))

WebUI.waitForPageLoad(100)

// Commented, because of localization in CircleCI
// WebUI.verifyTextPresent(verifyFieldEmail, false, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.waitForElementVisible(findTestObject('Website/CRM/Login/TxtGmailAccount'), 10)

WebUI.sendKeys(findTestObject('Website/CRM/Login/TxtGmailAccount'), CryptoUtil.decode(CryptoUtil.getDefault(gmailAccount)))

WebUI.click(findTestObject('Website/CRM/Login/BtnNext'))

WebUI.waitForPageLoad(10, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Website/CRM/Login/TxtGmailPassword'), 30)

// Commented, because of localization in CircleCI
// WebUI.verifyTextPresent(verifyFieldPassword, false, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.sendKeys(findTestObject('Website/CRM/Login/TxtGmailPassword'), CryptoUtil.decode(CryptoUtil.getDefault(gmailPassword)))

WebUI.click(findTestObject('Website/CRM/Login/BtnPasswordNext'))

WebUI.waitForElementPresent(findTestObject('Website/CRM/Login/GridInfoLogin'), 100)

WebUI.waitForPageLoad(10)

TestObject txtUsername = new TestObject().addProperty('text', ConditionType.CONTAINS, username)

WebUI.verifyElementPresent(txtUsername, 30, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.takeScreenshot()

