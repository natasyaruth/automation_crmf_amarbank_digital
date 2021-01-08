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

<<<<<<< HEAD:Scripts/Website/CRM/CRM_Reporting/TC_Reporting/Script1605077691803.groovy
WebUI.click(findTestObject('Website/CRM/Reporting/LinkReporting'))

WebUI.verifyTextPresent(Subrole, false)
=======
WebUI.click(findTestObject('Website/CRM/Leads_Management/LinkLeadsManagement'))

WebUI.waitForPageLoad(5)

WebUI.verifyTextPresent(headerLeadsManagement, false)
>>>>>>> 1b9eec7791de5d020e96a84c3dda72e2b2d0e4f8:Scripts/Website/CRM/CRM_LeadsManagement/Bucketlist Page/TC_LeadsManagement/Script1588658916868.groovy

