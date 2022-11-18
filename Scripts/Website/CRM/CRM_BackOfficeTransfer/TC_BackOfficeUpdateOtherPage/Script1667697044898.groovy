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
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable

import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

'Initial loggin in katalon'
KeywordUtil keylogger = new KeywordUtil()

/* Precondition 
 * Agen already login*/
 
/*Step to process
 * 	- Agen click one data
	- Agen move others page
	- Agen click one data in other page

	- Agen click and  chose new status for update
	- Agen click button update


/*Expected Result
	- Agen can click one data in bucketlist
	- Agen can move to others page
	- Agen can click one data in bucketlist others page
	- Agen can click click and  chose new status for update
	- Agen can click button update

New Status updated for selected data
The queue data is still in the same position*/

'I want initial the table data'
WebDriver driverBackOffice = DriverFactory.getWebDriver()
WebElement tableBackOffice
List<WebElement> rowsBackOffice

'We want process the status for update'
TestObject txtDashboard = new TestObject().addProperty('text',ConditionType.CONTAINS,'DashBoard')
if (WebUI.verifyElementPresent(txtDashboard, 5)) {
	keylogger.markPassed('We are in back office')
	if (WebUI.verifyOptionsPresent(drpDwnStatus, listDrpDwnStatus)) {
		WebUI.setText(fieldSearch, 'On Process')
		tableBackOffice = driverBackOffice.findElement(By.xpath('//table/tbody'))
		rowsBackOffice = tableBackOffice.findElements(By.tagName('tr'))
		List<WebElement> colsBackOffice = rowsBackOffice.get(0).findElements(By.tagName('td'))
		if (colsBackOffice.get(12).getText().equalsIgnoreCase("On Process")) {
			seqNumb = colsBackOffice.get(1).getText()
			println(seqNumb)
			colsBackOffice.get(0).findElement(By.xpath('input')).click()
			WebUI.click(btnNextPage)
		} else {keylogger.markError('Text open not found')}
		WebUI.selectOptionByLabel(drpDwnStatus, "Pending", false)
		WebUI.click(btnUpdate)
	} else {keylogger.markError('Drop Down Status Not Shown')}
	'We want to check box'
	numberQueue = seqNumb
	println(numberQueue)
	WebUI.setText(fieldSearch, 'Pending')
	WebUI.selectOptionByLabel(drpDwnShowRow, "50", false)
	'We want to check update data'
	boolean flag = false
	dataCheck:
	while (flag == false) {
		for (int i = 0;i < rowsBackOffice.size(); i ++) {
			println('sequence Number: ' +numberQueue+ ' No. of rows: ' + rowsBackOffice.size()+ ' row number '+i)
			tableBackOffice = driverBackOffice.findElement(By.xpath('//table/tbody'))
			rowsBackOffice = tableBackOffice.findElements(By.tagName('tr'))
			List<WebElement> colsBackOffice = rowsBackOffice.get(i).findElements(By.tagName('td'))
			if (colsBackOffice.get(1).getText().equalsIgnoreCase(numberQueue)) {
				colsBackOffice.get(12).getText().equalsIgnoreCase("Pending")
				break dataCheck
				keylogger.markPassed("We already changes status")
			} else {
				keylogger.logInfo("We not find the sequence number")
				tableBackOffice = driverBackOffice.findElement(By.xpath('//table/tbody'))
				rowsBackOffice = tableBackOffice.findElements(By.tagName('tr'))
			}
			
		}
	}
} else {keylogger.markError('We are not in Dashboard')}