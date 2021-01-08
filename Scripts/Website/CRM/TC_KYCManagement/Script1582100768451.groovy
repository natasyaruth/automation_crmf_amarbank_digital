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

<<<<<<< HEAD
WebUI.waitForElementClickable(findTestObject('Website/CRM/KYC_Management/KYCManagement/LinkKYCManagement'), 10)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYCManagement/LinkKYCManagement'))

WebUI.waitForElementPresent(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/LinkVerification'), 10)

=======
WebUI.waitForElementPresent('Website/CRM/KYC_Management/KYCManagement/LinkKYCManagement', 3)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYCManagement/LinkKYCManagement'))

WebUI.waitForPageLoad(5)

WebUI.verifyTextPresent(headerKYCVideoRequest, false)
>>>>>>> 1b9eec7791de5d020e96a84c3dda72e2b2d0e4f8
