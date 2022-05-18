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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement

WebUI.verifyTextPresent(GlobalVariable.titleCustomerDetails, false)

WebUI.click(findTestObject('Website/CRM/Leads_Management/Detail/BtnDataPhonenumber'))

noHandphone = WebUI.getAttribute(findTestObject('Website/CRM/Leads_Management/Detail/TxtPhonenumber'), attributeName)

WebUI.click(findTestObject('Website/CRM/Leads_Management/Detail/BtnOpenRejectModal'))

WebUI.waitForElementPresent(findTestObject('Website/CRM/Leads_Management/Detail/TxtReject'), 5)

WebUI.click(findTestObject('Website/CRM/Leads_Management/Detail/ChkOther'))

WebUI.waitForElementPresent(findTestObject('Website/CRM/Leads_Management/Detail/TxtRejectReasonModal'), 5)

WebUI.setText(findTestObject('Website/CRM/Leads_Management/Detail/TxtRejectReasonModal'), inputText)

WebUI.click(findTestObject('Website/CRM/Leads_Management/Detail/BtnSubmitRejectConfirmation'))

WebUI.waitForPageLoad(7)

WebUI.verifyElementText(findTestObject('Website/CRM/Leads_Management/Bucketlist/LeadsManagementBucketListHeaderLeadsManagement'), GlobalVariable.titleLeadsManagement)

WebDriver driver = DriverFactory.getWebDriver()

WebElement table = driver.findElement(By.xpath('//*[@id="root"]//table/tbody'))
 
List<WebElement> listRows = table.findElements(By.tagName('tr'))
 
boolean flagLoop = false
Loop:
while(flagLoop == false){
	for (int rows=0;rows<listRows.size();rows++){
		List<WebElement> listColumn = listRows.get(rows).findElements(By.tagName('td'))
		for(int column=2;column<3;column++){
			if(listColumn.get(column).getText().equals(noHandphone)){
				listColumn.get(5).findElement(By.tagName('a')).click()
				flagLoop = true
				break Loop
			}
		}
	}
	if(flagLoop == false){
		def expectedFirst = WebUI.getText(findTestObject('Website/CRM/Leads_Management/Bucketlist/LeadsManagementBucketListPaginationSpan')),
		    expectedLast = WebUI.getText(findTestObject('Website/CRM/Leads_Management/Bucketlist/LeadsManagementBucketListTxtLastPage'))
		if(expectedFirst.equals(expectedLast)){
			println("Phonenumber: "+noHandphone+" didn't exists on the table")
			flagLoop = true
		} else{
			WebUI.click(findTestObject('Website/CRM/Leads_Management/Bucketlist/LeadsManagementBucketListBtnNextPage'))
		    WebUI.waitForPageLoad(3)
		}		
	}
 }

WebUI.waitForPageLoad(5)

WebUI.verifyElementText(findTestObject('Website/CRM/Leads_Management/Detail/StatRed'), status)

WebUI.verifyElementText(findTestObject('Website/CRM/Leads_Management/Detail/TxtReasonReject'), reasonType)

WebUI.verifyElementText(findTestObject('Website/CRM/Leads_Management/Detail/TxtReasonValueReject'), inputText)