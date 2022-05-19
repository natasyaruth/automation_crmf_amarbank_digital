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

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/TxtRequestID'), searchRequestID)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/BtnSearch'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/KYCVerificationLinkRequestID'))

WebUI.verifyTextPresent(headerKYCVerificationDetail, false)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnAccept1'))

WebUI.verifyTextPresent(KTPDataValidation, false)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnProceedKycVideoCall'))

WebUI.verifyElementPresent(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnSendToVideoCall'), 5)

WebUI.verifyElementPresent(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnCloseModal'), 5)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnSendToVideoCall'))

WebUI.verifyTextPresent(KYCVerificationBucketlist, false)

