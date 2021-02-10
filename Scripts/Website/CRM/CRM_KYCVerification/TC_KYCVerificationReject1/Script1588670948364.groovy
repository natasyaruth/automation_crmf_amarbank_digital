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

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/TxtRequestID'), searchRequestID)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/BtnSearch'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/LinkRequestID'))

WebUI.waitForPageLoad(10)

WebUI.verifyTextPresent(headerKYCDetail, false)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnReject1'))

WebUI.waitForElementPresent(findTestObject('Website/CRM/KYC_Management/KYC_Verification/RejectionReason/ChkNotPassVerification'), 
    5)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/RejectionReason/ChkNotPassVerification'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/RejectionReason/ChkCustomerIDNotEKTP'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/RejectionReason/ChkIDPhotoNotFound'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/RejectionReason/ChkSelfiesNotFound'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/RejectionReason/ChkNameNotMatch'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/RejectionReason/ChkPhotoNotClear'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/RejectionReason/ChkIDPhotoNotClear'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/RejectionReason/ChkOther'))

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Verification/RejectionReason/TxtOther'), other)

WebUI.verifyElementChecked(findTestObject('Website/CRM/KYC_Management/KYC_Verification/RejectionReason/ChkNotPassVerification'), 
    10)

WebUI.verifyElementChecked(findTestObject('Website/CRM/KYC_Management/KYC_Verification/RejectionReason/ChkCustomerIDNotEKTP'), 
    10)

WebUI.verifyElementChecked(findTestObject('Website/CRM/KYC_Management/KYC_Verification/RejectionReason/ChkIDPhotoNotFound'), 
    10)

WebUI.verifyElementChecked(findTestObject('Website/CRM/KYC_Management/KYC_Verification/RejectionReason/ChkSelfiesNotFound'), 
    10)

WebUI.verifyElementChecked(findTestObject('Website/CRM/KYC_Management/KYC_Verification/RejectionReason/ChkNameNotMatch'), 
    10)

WebUI.verifyElementChecked(findTestObject('Website/CRM/KYC_Management/KYC_Verification/RejectionReason/ChkPhotoNotClear'), 
    10)

WebUI.verifyElementChecked(findTestObject('Website/CRM/KYC_Management/KYC_Verification/RejectionReason/ChkIDPhotoNotClear'), 
    10)

WebUI.verifyElementChecked(findTestObject('Website/CRM/KYC_Management/KYC_Verification/RejectionReason/ChkOther'), 10)

WebUI.verifyElementText(findTestObject('Website/CRM/KYC_Management/KYC_Verification/RejectionReason/TxtOther'), other)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/RejectionReason/BtnSend'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/RejectionReason/BtnCloseModal'))

