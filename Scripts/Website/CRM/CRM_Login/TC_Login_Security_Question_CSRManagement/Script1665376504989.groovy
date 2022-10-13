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

/* this is testcase we put from TC_Login_Non_Roles */
WebUI.callTestCase(findTestCase('Website/CRM/CRM_Login/TC_Login'), [('btnLoginText') : 'Login by Email Amarbank', ('verifyFieldEmail') : 'Masukkan email Anda'
        , ('gmailAccount') : findTestData('Website/Dataset_CRMLogin/Dataset_Login').getValue(1, 7), ('gmailPassword') : findTestData('Website/Dataset_CRMLogin/Dataset_Login').getValue(2, 7)
        , ('verifyFieldPassword') : 'Masukkan sandi Anda', ('verifyDasboardPage') : 'Welcome to Senyumku CRM', ('username') : findTestData('Website/Dataset_CRMLogin/Dataset_Login').getValue(3, 7)
        , ('logoLoginPage') : findTestObject('Website/CRM/Login/LoginImageSenyumku'), ('btnLogin') : findTestObject('Website/CRM/Login/LoginBtn')
        , ('fieldEmailLogin') : findTestObject('Website/CRM/Login/LoginTxtGmailAccount'), ('btnNext') : findTestObject('Website/CRM/Login/LoginBtnNext')
        , ('fieldPasswordLogin') : findTestObject('Website/CRM/Login/LoginTxtGmailPassword'), ('btnPasswordNext') : findTestObject('Website/CRM/Login/LoginBtnPasswordNext')
        , ('gridInfoLogin') : findTestObject('Website/CRM/Login/LoginGridInfoLogin')], FailureHandling.STOP_ON_FAILURE)

/* We will direct to video verification*/
WebUI.navigateToUrl(siteURL_CSR_Management + '/csr-management')

/* We will capture the page*/
WebUI.takeScreenshot(FailureHandling.OPTIONAL)

