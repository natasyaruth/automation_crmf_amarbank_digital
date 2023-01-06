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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/KYC_Verification/KYCVerificationLink'))

WebUI.waitForElementPresent(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/KYCVerificationLink'), 5)

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/TxtSearchRequestID'), searchRequestID)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/BtnSearch'))

WebUI.waitForElementPresent(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/KYCVerificationLink'), 5)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/KYCVerificationLink'))

WebUI.waitForPageLoad(5)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnAccept1'))

WebUI.waitForElementPresent(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnAccept3'), 3)

CustomKeywords.'com.tunaiku.keyword.ClickUsing_JS.clickUsingJS'(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnAccept3'), 
    2)

WebUI.waitForElementPresent(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnBackToBucketlist'), 5)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BackToBucketlist'))

WebUI.verifyElementPresent(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/KYCVerificationLink'), 5)

