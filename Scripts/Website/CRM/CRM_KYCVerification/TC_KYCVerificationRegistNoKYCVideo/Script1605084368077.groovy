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

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/LinkRequestID'))

WebUI.waitForPageLoad(5)

WebUI.verifyTextPresent(Verification_Detail, false)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnEdit'))

WebUI.waitForElementClickable(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnCancel'), 0)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnCancel'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnEdit'))

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/TxtNIK'), NIK)

WebUI.delay(1)

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/TxtName'), Name)

WebUI.delay(1)

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/TxtBirthPlace'), Birthplace)

//WebUI.delay(5)
//WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/DtpBirthDate'), Birthdate)
WebUI.delay(1)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/DrpGender'), Gender, false)

WebUI.delay(1)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/DrpBloodType'), BloodType, 
    false)

WebUI.delay(1)

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/TxtAddress'), Address)

WebUI.delay(1)

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/TxtRT'), Neighbourhood)

WebUI.delay(2)

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/TxtRW'), Hamlet)

WebUI.delay(2)

//WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/TxtVillage'), Village)
//WebUI.waitForElementPresent(findTestObject(null), 6)
//WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/ListVillageResult1'))
//WebUI.delay(5)
//WebUI.verifyTextPresent(VerifyDistrict, false)
//WebUI.delay(2)
WebUI.selectOptionByLabel(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/DrpReligion'), Religion, false)

WebUI.delay(3)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/DrpMaritalStatus'), MaritalStatus, 
    false)

WebUI.delay(3)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/DrpOccupation'), Occupation, 
    false)

WebUI.delay(3)

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/TxtCitizenship'), Citizenship)

WebUI.delay(3)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/RbDated'))

WebUI.delay(3)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/RbLifetime'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnSave'))

WebUI.delay(2)

WebUI.verifyTextPresent(VerifySuccessSavedKTP, false)

WebUI.delay(3)

WebUI.verifyTextPresent(VerifyEmailhasverified, false)

WebUI.delay(2)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnAccept1'))

WebUI.delay(5)

WebUI.verifyTextPresent(Verify_KTPValidation, false)

WebUI.verifyTextPresent(VerifyNIK, false)

WebUI.verifyTextPresent(VerifyName, false)

WebUI.verifyTextPresent(VerifyBirthdate2, false)

WebUI.verifyTextPresent(VerifyMotherName, false)

WebUI.delay(2)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnAccept2'))

WebUI.waitForElementPresent(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnBackToBucketlist'), 10)

WebUI.verifyTextPresent(VerifySuccessKYCVerification, false)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnBackToBucketlist'))

WebUI.waitForPageLoad(10, FailureHandling.STOP_ON_FAILURE)

