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

WebUI.waitForElementPresent(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/LinkVerification'), 3)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/LinkVerification'))

WebUI.waitForPageLoad(10, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent(verifyBucketlist, false)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/BtnNextPage'))

WebUI.waitForElementPresent(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/BtnFirstPage'), 4)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/BtnLastPage'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/BtnPreviousPage'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/BtnFirstPage'))

WebUI.selectOptionByLabel(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/DrpEmailType'), emailType, 
    false)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/DrpEmailType'), 
    emailType, 3)

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/DtpStartFilterDate'), startFilterDate)

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/DtpEndFilterDate'), endFilterDate)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/BtnShow'))

WebUI.waitForElementPresent(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/LinkRequestID'), 3)

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/TxtSearchRequestID'), requestID)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/BtnSearch'))

WebUI.verifyTextPresent(requestIDName, false)

