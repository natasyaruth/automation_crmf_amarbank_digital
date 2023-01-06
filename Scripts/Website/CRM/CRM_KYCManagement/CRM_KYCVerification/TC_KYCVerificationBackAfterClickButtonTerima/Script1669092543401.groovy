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

WebUI.click(KYCManagementLink)

WebUI.click(KYCVerificationLink)

WebUI.selectOptionByLabel(DrpCustomerType, 'Nasabah Baru', true)

WebUI.selectOptionByLabel(DrpEmailType, 'Terverifikasi', true)

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/TxtSearchRequestID'), InputReqID)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/BtnShow'))

WebUI.click(BtnDetailKYCVerification)

WebUI.click(BtnFaceMatchDukcapil)

WebUI.click(BtnFaceMatchConfirmation)

WebUI.click(BtnLiveness)

WebUI.click(BtnLivenessConfirmation)

WebUI.scrollToElement(BtnCekDataDukcapil, 5)

WebUI.click(BtnCekDataDukcapil)

WebUI.waitForElementPresent(TxtCekDataDukcapilConfirmation, 5)

WebUI.verifyElementClickable(BtnCekDataDukcapilConfirmation)

WebUI.verifyElementClickable(BtnCancelCekDataDukcapil)

WebUI.click(BtnCekDataDukcapilConfirmation)

WebUI.scrollToElement(BtnAccept1, 5)

WebUI.click(BtnAccept1)

WebUI.scrollToElement(BtnAccept2, 5)

WebUI.click(BtnAccept2)

WebUI.verifyElementClickable(BtnCloseModal)

WebUI.click(BtnCloseModal)

