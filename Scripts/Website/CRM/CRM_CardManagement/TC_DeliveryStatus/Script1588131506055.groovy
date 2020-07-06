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

WebUI.click(findTestObject('Website/CRM/Card Management/Delivery Status/LinkDeliveryStatus'))

WebUI.setText(findTestObject('Website/CRM/Card Management/Delivery Status/TxtReferenceId'), SearchRefID)

WebUI.click(findTestObject('Website/CRM/Card Management/Assign CMS/BtnSearch'))

WebUI.click(findTestObject('Website/CRM/Card Management/Delivery Status/LinkReqId1'))

WebUI.verifyTextPresent(VerifyRequestID, false)

WebUI.verifyTextPresent(VerifyStatusDeliveryEnRoute, false)

WebUI.verifyTextPresent(VerifyStatusSuccessDelivery, false)

WebUI.click(findTestObject('Website/CRM/Card Management/Delivery Status/BtnBack'))

