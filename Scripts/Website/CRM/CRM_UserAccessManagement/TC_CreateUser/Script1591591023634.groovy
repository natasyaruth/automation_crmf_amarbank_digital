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

WebUI.click(findTestObject('Website/CRM/IAM_Management/UserAccess_Management/CreateUser/LinkCreateUser'))

WebUI.click(findTestObject('Website/CRM/IAM_Management/UserAccess_Management/CreateUser/BtnCancel'))

WebUI.click(findTestObject('Website/CRM/IAM_Management/LinkIAManagement'))

WebUI.click(findTestObject('Website/CRM/IAM_Management/UserAccess_Management/CreateUser/LinkCreateUser'))

WebUI.verifyTextPresent('Account Detail', false)

WebUI.setText(findTestObject('Website/CRM/IAM_Management/UserAccess_Management/CreateUser/TxtUsername'), Username)

WebUI.setText(findTestObject('Website/CRM/IAM_Management/UserAccess_Management/CreateUser/TxtOfficerName'), OfficerName)

WebUI.setText(findTestObject('Website/CRM/IAM_Management/UserAccess_Management/CreateUser/TxtOfficeEmail'), OfficeEmail)

WebUI.delay(2)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/IAM_Management/UserAccess_Management/CreateUser/DrpFunction'), Function, 
    false)

WebUI.setText(findTestObject('Website/CRM/IAM_Management/UserAccess_Management/CreateUser/TxtNewPassword'), NewPassword)

WebUI.setText(findTestObject('Website/CRM/IAM_Management/UserAccess_Management/CreateUser/TxtConfirmPassword'), ConfirmPassword)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/IAM_Management/UserAccess_Management/CreateUser/DrpRole'), RoleAccess, 
    false)

WebUI.click(findTestObject('Website/CRM/IAM_Management/UserAccess_Management/CreateUser/BtnCreateUser'))

WebUI.delay(1)

WebUI.click(findTestObject('Website/CRM/IAM_Management/UserAccess_Management/CreateUser/BtnCloseModal'))

