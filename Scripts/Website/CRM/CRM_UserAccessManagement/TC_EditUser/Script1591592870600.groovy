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

WebUI.click(findTestObject('Website/CRM/IAM_Management/UserAccess_Management/EditUser/LinkEditUser'))

WebUI.verifyTextPresent('Edit User', false)

WebUI.setText(findTestObject('Website/CRM/IAM_Management/UserAccess_Management/EditUser/TxtSearchStaffName'), SearchUsername)

WebUI.click(findTestObject('Website/CRM/IAM_Management/UserAccess_Management/EditUser/BtnSearch'))

WebUI.click(findTestObject('Website/CRM/IAM_Management/UserAccess_Management/EditUser/LinkUsername'))

WebUI.setText(findTestObject('Website/CRM/IAM_Management/UserAccess_Management/EditUser/TxtOfficeEmail'), OfficeEmail)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/IAM_Management/UserAccess_Management/EditUser/DrpFunction'), Function, 
    false)

WebUI.setText(findTestObject('Website/CRM/IAM_Management/UserAccess_Management/EditUser/TxtNewPassword'), NewPassword)

WebUI.setText(findTestObject('Website/CRM/IAM_Management/UserAccess_Management/EditUser/TxtConfirmPassword'), ConfirmPassword)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/IAM_Management/UserAccess_Management/EditUser/DrpRole'), Role, false)

WebUI.click(findTestObject('Website/CRM/IAM_Management/UserAccess_Management/EditUser/BtnEditUser'))

WebUI.click(findTestObject('Website/CRM/IAM_Management/UserAccess_Management/EditUser/BtnCloseModal'))

