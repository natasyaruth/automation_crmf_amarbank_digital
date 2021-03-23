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

WebUI.click(findTestObject('Website/CRM/Card Management/Assign_Card/LinkAssignCard'))

WebUI.verifyTextPresent(verifyBucketlist, false)

WebUI.setText(findTestObject('Website/CRM/Card Management/Assign_Card/TxtReferenceId'), searchRefID)

WebUI.click(findTestObject('Website/CRM/Card Management/Assign_Card/BtnSearch'))

WebUI.click(findTestObject('Website/CRM/Card Management/Assign_Card/LinkRequestID'))

WebUI.verifyTextPresent(verifyDetails, false)

WebUI.setText(findTestObject('Website/CRM/Card Management/Assign_Card/TxtCardNumber'), cardNumber)

WebUI.setText(findTestObject('Website/CRM/Card Management/Assign_Card/TxtCardName'), cardName)

CustomKeywords.'com.tunaiku.keyword.ClickUsing_JS.clickUsingJS'(findTestObject('Website/CRM/Card Management/Assign_Card/BtnSend'), 
    10)

WebUI.click(findTestObject('Website/CRM/Card Management/Assign_Card/BtnCloseModal'))

