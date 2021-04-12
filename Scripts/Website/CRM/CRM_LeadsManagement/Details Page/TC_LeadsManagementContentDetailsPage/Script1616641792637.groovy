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

WebUI.verifyTextPresent(GlobalVariable.titleCustomerDetails, false)

for (int i=0;i<listIdLabelSection.size();i++){
	
	String actualLabel = WebUI.getText(findTestObject('Website/CRM/Leads_Management/Detail/'+listIdLabelSection.get(i)))
	
	WebUI.verifyEqual(actualLabel, listLabelSection.get(i))
	
	WebUI.click(findTestObject('Website/CRM/Leads_Management/Detail/'+listButtonSection.get(i)))
	
	if(i == 7){
		WebUI.verifyElementPresent(findTestObject('Website/CRM/Leads_Management/Detail/BtnSendLinkUploadPhotos'), 10)
	} else(
		WebUI.verifyTextPresent(listContentSection.get(i), false)
	)
	
	WebUI.click(findTestObject('Website/CRM/Leads_Management/Detail/'+listButtonSection.get(i)))				
}