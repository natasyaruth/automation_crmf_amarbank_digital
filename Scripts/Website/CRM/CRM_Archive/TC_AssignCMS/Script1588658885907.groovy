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

WebUI.click(findTestObject('Website/CRM/Card Management/Assign CMS/LinkAssignCMS'))

WebUI.verifyTextPresent(verifyBucketlist, false)

WebUI.setText(findTestObject('Website/CRM/Card Management/Assign CMS/TxtReferenceId'), searchRefID)

WebUI.click(findTestObject('Website/CRM/Card Management/Assign CMS/BtnSearch'))

WebUI.click(findTestObject('Website/CRM/Card Management/Assign CMS/LinkReqId1'))

WebUI.verifyTextPresent(verifyDetails, false)

WebUI.click(findTestObject('Website/CRM/Card Management/Assign CMS/BtnCancel'))

WebUI.setText(findTestObject('Website/CRM/Card Management/Assign CMS/TxtReferenceId'), searchRefID)

WebUI.click(findTestObject('Website/CRM/Card Management/AssignCMS/BtnSearch'))

WebUI.click(findTestObject('Website/CRM/Card Management/AssignCMS/LinkReqId1'))

WebUI.verifyTextPresent(verifyStatusWaiting, false)

WebUI.click(findTestObject('Website/CRM/Card Management/AssignCMS/BtnSend'))

WebUI.click(findTestObject('Website/CRM/Card Management/AssignCMS/BtnCloseModal'))

WebUI.setText(findTestObject('Website/Card Management/AssignCMS/TxtReferenceId'), searchRefID)

WebUI.click(findTestObject('Website/CRM/Card Management/AssignCMS/BtnSearch'))

WebUI.click(findTestObject('Website/CRM/Card Management/AssignCMS/LinkReqId1'))

WebUI.verifyTextPresent(verifyStatusDone, false)

WebUI.click(findTestObject('Website/CRM/Card Management/AssignCMS/BtnBack'))

