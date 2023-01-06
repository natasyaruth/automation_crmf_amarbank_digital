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

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/TxtSearchRequestID'), searchRequestID)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/BtnSearch'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/KYCVerificationLink'))

WebUI.waitForPageLoad(10)

WebUI.verifyTextPresent(verificationDetail, false)

WebUI.verifyTextPresent(verifyStep1, false)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnEdit'))

WebUI.waitForElementClickable(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnSave'), 5)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnCancel'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnEdit'))

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/TxtNIK'), NIK)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/TxtNIK'), NIK, 5)

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/TxtName'), name)

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/TxtBirthPlace'), birthPlace)

WebUI.verifyElementText(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/DtpBirthDate'), birthDate)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/DrpGender'), gender, false)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/DrpGender'), gender, 
    5)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/DrpBloodType'), bloodType, 
    false)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/DrpBloodType'), bloodType, 
    5)

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/TxtAddress'), address)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/TxtAddress'), address, 
    5)

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/TxtRT'), neighbourhood)

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/TxtRW'), hamlet)

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/TxtVillage'), village)

WebUI.waitForElementPresent(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/ListVillageResult1'), 5)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/ListVillageResult1'))

WebUI.verifyTextPresent(verifyDistrict, false)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/DrpReligion'), religion, false)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/DrpReligion'), religion, 
    5)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/DrpMaritalStatus'), maritalStatus, 
    false)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/DrpMaritalStatus'), 
    maritalStatus, 5)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/DrpOccupation'), occupation, 
    false)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/DrpOccupation'), occupation, 
    5)

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/TxtCitizenship'), citizenship)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/RbDated'))

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/DtpKTPValidPeriod'), KTPValidPeriod)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/DtpKTPValidPeriod'), 
    KTPValidPeriod, 5)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnSave'))

WebUI.waitForElementNotClickable(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnSave'), 5)

WebUI.verifyTextPresent(verifySuccessSavedKTP, false)

WebUI.verifyTextPresent(verifyEmailhasverified, false)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnAccept1'))

WebUI.waitForElementNotVisible(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnAccept1'), 10)

WebUI.verifyTextPresent(verifyKTPValidation, false)

WebUI.verifyTextPresent(verifyNIK, false)

WebUI.verifyTextPresent(verifyName, false)

WebUI.verifyTextPresent(verifyBirthdate2, false)

WebUI.verifyTextPresent(verifyMotherName, false)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnAccept2'))

WebUI.waitForElementNotVisible(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnAccept2'), 10)

WebUI.verifyTextPresent(verifyVideo, false)

WebUI.verifyTextPresent(verifyNIK, false)

WebUI.verifyTextPresent(verifyName, false)

WebUI.verifyTextPresent(verifyBirthdate2, false)

WebUI.verifyTextPresent(verifyMotherName, false)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnAccept3'))

WebUI.waitForElementPresent(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnBackToBucketlist'), 100)

WebUI.verifyTextPresent(verifySuccessKYCVerification, false)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnBackToBucketlist'))

WebUI.waitForPageLoad(10, FailureHandling.CONTINUE_ON_FAILURE)

