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
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable

import org.openqa.selenium.Alert
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

WebUI.click(KYCManagementLink)

WebUI.click(KYCVerificationLink)

WebUI.selectOptionByLabel(DrpCustomerType, 'Nasabah Baru', true)

WebUI.selectOptionByLabel(DrpEmailType, 'Terverifikasi', true)

WebUI.click(BtnDetailKYCVerification)

WebUI.click(BtnLiveness)

TestObject txtConfLiveness = new TestObject().addProperty('text',ConditionType.CONTAINS,'Konfirmasi')

WebUI.waitForElementVisible(txtConfLiveness, 5)

WebUI.verifyElementClickable(BtnLivenessConfirmation)

WebUI.verifyElementClickable(BtnCancelLiveness)

WebUI.click(BtnCancelLiveness)

WebUI.verifyElementText(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/TxtKYCCustomerDetail'), 'KYC Customer Detail')

WebUI.scrollToElement(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnBack'), 5)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Details/BtnBack'))