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

WebUI.selectOptionByLabel(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/DrpEmailType'), 'Terverifikasi', 
    true)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/BtnDetailKYCVerification'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnFaceMatchDukcapil'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnFaceMatchConfirmation'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnLiveness'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnLivenessConfirmation'))

WebUI.scrollToElement(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnCekDataDukcapil'), 5)

if (WebUI.verifyElementClickable(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnCekDataDukcapil'))) {
    WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnCekDataDukcapil'))

    WebUI.waitForElementPresent(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/TxtCekDataDukcapilConfirmation'), 
        5)

    WebUI.verifyElementClickable(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnCekDataDukcapilConfirmation'))

    WebUI.verifyElementClickable(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnCancelCekDataDukcapil'))

    WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnCekDataDukcapilConfirmation'))

    WebUI.scrollToElement(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnAccept1'), 5)

    WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnAccept1'))

    WebUI.waitForElementPresent(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnAccept2'), 5)

    WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnAccept2'))

    WebUI.verifyElementClickable(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnCloseModal'))

    WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnCloseModal'))
} else {
    WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnBack'))
}

