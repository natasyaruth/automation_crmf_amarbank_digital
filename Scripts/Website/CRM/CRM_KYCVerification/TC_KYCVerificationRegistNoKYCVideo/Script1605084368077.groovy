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
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/LinkRequestID'))

WebUI.waitForPageLoad(5)

TestObject textVerificationDetail = new TestObject().addProperty('text', ConditionType.CONTAINS, verificationDetail)

WebUI.waitForElementVisible(textVerificationDetail, 10, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnEdit'))

WebUI.waitForElementClickable(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnCancel'), 5)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnCancel'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnEdit'))

String idNumber = WebUI.executeJavaScript("return document.querySelector('#TxtNIK').value", null)

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/TxtNIK'), idNumber)

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/TxtName'), name)

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/TxtBirthPlace'), birthPlace)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/DrpGender'), gender, false, 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/DrpBloodType'), bloodType, 
    false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/TxtAddress'), address)

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/TxtRT'), neighbourhood)

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/TxtRW'), hamlet)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/DrpReligion'), religion, false, 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/DrpReligion'), 'value', 
    religion, 10, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/DrpMaritalStatus'), maritalStatus, 
    false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/DrpMaritalStatus'), 
    'value', maritalStatus, 10, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/DrpOccupation'), occupation, 
    false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/DrpOccupation'), 
    'value', occupation, 10, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/TxtCitizenship'), citizenship)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/TxtCitizenship'), 
    'value', citizenship, 10, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/RbDated'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/RbLifetime'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnSave'))

WebUI.waitForElementNotClickable(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnSave'), 5)

WebUI.verifyTextPresent(verifySuccessSavedKTP, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnEdit'))

WebUI.verifyTextPresent(verifyEmailhasverified, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnAccept1'))

WebUI.verifyElementNotPresent(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnReject1'), 10, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyTextPresent(verifyKTPValidation, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyTextPresent(idNumber, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyTextPresent(verifyName, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnAccept2'))

TestObject textVerificationModal = new TestObject().addProperty('text', ConditionType.CONTAINS, verifySuccessKYCVerification)

if(WebUI.verifyElementVisible(textVerificationModal, FailureHandling.OPTIONAL)) {    
    WebUI.verifyTextPresent(verifySuccessKYCVerification, false, FailureHandling.CONTINUE_ON_FAILURE)
    
    WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnBackToBucketlist'))
} else {
    String requestUrl = WebUI.getUrl()
    KeywordUtil.markWarning('Verification is not success! Please check the face match for: ' + requestUrl)    
}
WebUI.waitForPageLoad(10)
