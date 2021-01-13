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
import com.kms.katalon.util.CryptoUtil as CryptoUtil
import internal.GlobalVariable as GlobalVariable

WebUI.verifyTextPresent(Btnlogin, false)

WebUI.click(findTestObject('Website/CRM/Login/BtnLogin'))

WebUI.waitForPageLoad(100)

WebUI.verifyTextPresent(Verify_FieldEmail, false)

WebUI.setText(findTestObject('Website/CRM/Login/TxtGmailAccount'), CryptoUtil.decode(CryptoUtil.getDefault(GmailAccount)))

WebUI.click(findTestObject('Website/CRM/Login/BtnNext'))

WebUI.waitForPageLoad(10, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent(Verify_FieldPassword, false)

WebUI.setText(findTestObject('Website/CRM/Login/TxtGmailPassword'), CryptoUtil.decode(CryptoUtil.getDefault(GmailPassword)))

WebUI.click(findTestObject('Website/CRM/Login/BtnNext'))

WebUI.waitForPageLoad(10)

WebUI.verifyTextPresent(Verify_DasboardPage, false)

WebUI.verifyTextPresent(Username, false)

