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

WebUI.click(findTestObject('Website/CRM/Leads_Management/Bucketlist/LeadsManagementBucketListBtnDetail'))

WebUI.waitForPageLoad(5)

def getReqID = WebUI.getText(findTestObject('Website/CRM/Leads_Management/Detail/TxtReqID'))

println getReqID

WebUI.click(findTestObject('Website/CRM/Leads_Management/Detail/BtnBack'))

WebUI.waitForPageLoad(8)

WebUI.verifyElementText(findTestObject('Website/CRM/Leads_Management/Bucketlist/LeadsManagementBucketListHeaderLeadsManagement'), GlobalVariable.titleLeadsManagement)

WebUI.navigateToUrl(url+'/'+getReqID)

WebUI.waitForPageLoad(3)

WebUI.verifyTextPresent(getReqID, false)