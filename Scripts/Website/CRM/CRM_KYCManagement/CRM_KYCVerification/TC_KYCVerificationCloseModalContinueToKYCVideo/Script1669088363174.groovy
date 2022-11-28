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
import org.openqa.selenium.Keys as Keys

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Management/KYCManagementLink'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/KYC_Verification/KYCVerificationLink'))

WebUI.selectOptionByLabel(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/DrpCustomerType'), 'Nasabah Baru', 
    true)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/DrpEmailType'), 'Belum Terverifikasi', 
    true)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/BtnDetailKYCVerification'))

WebUI.scrollToElement(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnProceedKycVideoCall'), 8)

WebUI.verifyElementClickable(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnProceedKycVideoCall'))

WebUI.verifyElementNotClickable(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnAccept1'))

WebUI.verifyElementClickable(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnReject1'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnProceedKycVideoCall'))

WebUI.waitForElementPresent(findTestObject('Website/CRM/KYC_Management/KYC_Verification/RejectionReason/ChkBlurredEKTP'), 
    5)

WebUI.verifyElementText(findTestObject('Website/CRM/KYC_Management/KYC_Verification/RejectionReason/TxtHeaderModalSendToKYCVideo'), 
    'Alasan Lanjutkan KYC')

WebUI.verifyElementNotChecked(findTestObject('Website/CRM/KYC_Management/KYC_Verification/RejectionReason/ChkBlurredEKTP'), 
    2)

WebUI.verifyElementNotChecked(findTestObject('Website/CRM/KYC_Management/KYC_Verification/RejectionReason/ChkChangeEmail'), 
    2)

WebUI.verifyElementNotChecked(findTestObject('Website/CRM/KYC_Management/KYC_Verification/RejectionReason/ChkLowLivenessScore'), 
    2)

WebUI.verifyElementNotChecked(findTestObject('Website/CRM/KYC_Management/KYC_Verification/RejectionReason/ChkSelfieHoldingEKTP'), 
    2)

WebUI.verifyElementNotChecked(findTestObject('Website/CRM/KYC_Management/KYC_Verification/RejectionReason/ChkSelfieLandscape'), 
    2)

WebUI.verifyElementNotChecked(findTestObject('Website/CRM/KYC_Management/KYC_Verification/RejectionReason/ChkOther'), 2)

WebUI.verifyElementNotClickable(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnSendReason'))

WebUI.verifyElementClickable(findTestObject('Website/CRM/KYC_Management/KYC_Verification/RejectionReason/BtnCloseModalSendToKYCVideo'))

WebUI.takeScreenshot()

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/RejectionReason/BtnCloseModalSendToKYCVideo'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnBack'))

