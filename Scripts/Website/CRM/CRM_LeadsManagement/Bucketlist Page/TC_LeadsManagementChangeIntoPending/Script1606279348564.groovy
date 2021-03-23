import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import java.time.LocalDateTime
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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.apache.commons.lang3.StringUtils
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement

def noHandphone = WebUI.getText(findTestObject('Website/CRM/Leads_Management/Bucketlist/TxtNoHandphoneFirstRow')) 

WebUI.click(findTestObject('Website/CRM/Leads_Management/Bucketlist/BtnDetail'))

WebUI.waitForPageLoad(5)

WebUI.verifyTextPresent(headerCustomerDetail, false)

WebUI.click(findTestObject('Website/CRM/Leads_Management/Detail/BtnOpenPendingModal'))

WebUI.waitForElementPresent(findTestObject('Website/CRM/Leads_Management/Detail/HeaderChangeSchedule'), 5)

WebUI.verifyTextPresent(headerAturJadwal, false)

def inputDate = new Date()

def calendar = Calendar.getInstance()

calendar.setTime(inputDate)

calendar.add(Calendar.DATE, 1)

inputDate = calendar.getTime().format('dd/MM/yyyy')+' 0:00'

WebUI.setText(findTestObject('Website/CRM/Leads_Management/Detail/DrpPendingSchedule'), inputDate)

WebUI.sendKeys(findTestObject('Website/CRM/Leads_Management/Detail/DrpPendingSchedule'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Website/CRM/Leads_Management/Detail/ChkOtherNeeds'))

WebUI.click(findTestObject('Website/CRM/Leads_Management/Detail/BtnSubmitPendingConfirmation'))

WebUI.waitForPageLoad(8)

WebUI.verifyElementText(findTestObject('Website/CRM/Leads_Management/Bucketlist/HeaderLeadsManagement'), headerLeadsManagement)

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
				def actualJadwal = listColumn.get(4).getText()
				println actualJadwal
				WebUI.verifyEqual(actualJadwal, inputDate)	
				flagLoop = true
				break Loop			
			}
		}
	}
	if(flagLoop == false){
		def expectedFirst = WebUI.getText(findTestObject('Website/CRM/Leads_Management/Bucketlist/PaginationSpan')),
		    expectedLast = WebUI.getText(findTestObject('Website/CRM/Leads_Management/Bucketlist/TxtLastPage'))
		if(expectedFirst.equals(expectedLast)){
			println("Phonenumber: "+noHandphone+" didn't exists on the table")
			flagLoop = true
		} else{
			WebUI.click(findTestObject('Website/CRM/Leads_Management/Bucketlist/BtnNextPage'))
		    WebUI.waitForPageLoad(3)
		}		
	}
}
