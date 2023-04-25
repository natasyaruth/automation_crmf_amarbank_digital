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
	- Agen click check all
	- Agen move others page
	- Agen click check all in other page

	- Agen click and  chose new status for update
	- Agen click button update

/*Expected Result
	- Agen can click check all in bucketlist
	- Agen can move to others page
	- Agen can click check all in bucketlist others page
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
		WebUI.setText(fieldSearch, 'Open')
		if (WebUI.waitForElementVisible(chkAllData, 5)) {
			tableBackOffice = driverBackOffice.findElement(By.xpath('//table/tbody'))
			rowsBackOffice = tableBackOffice.findElements(By.tagName('tr'))
			List<WebElement> colsBackOffice = rowsBackOffice.get(0).findElements(By.tagName('td'))
			if (colsBackOffice.get(12).getText().equalsIgnoreCase("Open")) {
				seqNumb = colsBackOffice.get(1).getText()
				println(seqNumb)
				WebUI.click(chkAllData)
			} else {keylogger.markError('Text open not found')}
		} else {keylogger.markError('We are not find the check all data')}
		WebUI.click(btnNextPage)
		WebUI.selectOptionByLabel(drpDwnStatus, "On Process", false)
		WebUI.click(btnUpdate)
		WebUI.waitForPageLoad(5)
		WebUI.delay(3)
	} else {keylogger.markError('Drop Down Status Not Shown')}
	'We want to check box'
	numberQueue = seqNumb
	println(numberQueue)
	WebUI.setText(fieldSearch, 'On Process')
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
				colsBackOffice.get(12).getText().equalsIgnoreCase("On Process")
				break dataCheck
				keylogger.markPassed("We already changes status")
				WebUI.closeBrowser()
			} else {
				keylogger.logInfo("We not find the sequence number")
				tableBackOffice = driverBackOffice.findElement(By.xpath('//table/tbody'))
				rowsBackOffice = tableBackOffice.findElements(By.tagName('tr'))
			}
			
		}
	}
} else {keylogger.markError('We are not in Dashboard')}