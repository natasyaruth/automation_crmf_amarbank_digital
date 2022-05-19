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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.apache.commons.lang3.StringUtils
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement

WebUI.verifyTextPresent(GlobalVariable.titleLeadsManagement, false)

WebDriver driver = DriverFactory.getWebDriver()

WebElement table = driver.findElement(By.xpath('//*[@id="root"]//table/tbody'))

List<WebElement> listRows = table.findElements(By.tagName('tr'))

println('No. of rows: ' + listRows.size())

boolean flagLoop = false
Loop:
while(flagLoop == false){
	for (int rows=0;rows<listRows.size();rows++){
		List<WebElement> listColumn = listRows.get(rows).findElements(By.tagName('td'))
		for(int column=3;column<4;column++){
			if(listColumn.get(column).getText().equalsIgnoreCase(Status)){
				listColumn.get(5).findElement(By.tagName('a')).click()
				flagLoop = true
				break Loop
			}
		}
	}
	if(flagLoop == false){
		WebUI.click(findTestObject('Website/CRM/Leads_Management/Bucketlist/LeadsManagementBucketListBtnNextPage'))
		WebUI.waitForPageLoad(3)
	}
}

WebUI.waitForPageLoad(5)

WebUI.verifyTextPresent(GlobalVariable.titleCustomerDetails, false)

def actualStatus = WebUI.getText(findTestObject('Website/CRM/Leads_Management/Detail/StatBlue'))

WebUI.verifyEqual(actualStatus, Status)

