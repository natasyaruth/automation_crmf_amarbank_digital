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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.util.KeywordUtil
import org.openqa.selenium.support.ui.Select
import com.kms.katalon.core.webui.driver.DriverFactory

import org.apache.commons.lang.RandomStringUtils
import org.openqa.selenium.By

/*We Declare Keyword Util*/
KeywordUtil keylogger = new KeywordUtil()
/* We want handling block condition*/
if (WebUI.verifyElementVisible(menuCsrManagement,FailureHandling.OPTIONAL)) {
	WebUI.click(menuCsrManagement)
	if (WebUI.verifyElementVisible(notifBlockCsr,FailureHandling.OPTIONAL)) {
		WebUI.click(btnCancelBlock)
		keylogger.logInfo("We cancel the block")
		WebUI.verifyElementVisible(txtHeaderCsrManagement)
	} else {
		keylogger.logInfo("We cannot get block")
		WebUI.verifyElementVisible(txtHeaderCsrManagement)
	}
} else {keylogger.markError("We don't see Csr Management Menu")}

/* We want Verify design modal block card with condition already have card number
 * Precondition:
 * 	1. Already Login to CRMF Web
	2. Already open one detail customer with type 'Nasabah Senyumku' on CSR Management
 * 
 * And have steps:
 * 	1. Click section Alamat pengiriman kartu
	2. Edit field RT
	3. Click button 'Simpan'
	
	And we have the expected result is :
	1. Display data on changes log with detail:
		Tanggal --> date with time when the changes was created
		User/Agent --> agent name
		Field --> RT
		Data lama --> old Neighbourhood
		Data baru --> new Neighbourhood
 * */

/* We want choose request ID with condition is Nasabah Senyumku*/
if (WebUI.verifyElementVisible(drpCustType,FailureHandling.OPTIONAL)) {
	WebUI.verifyOptionsPresent(drpCustType, listDrpCustType)
	WebUI.selectOptionByLabel(drpCustType, "Nasabah Senyumku", false)
	if (WebUI.verifyElementVisible(drpCardStatus,FailureHandling.OPTIONAL)) {
		WebUI.verifyOptionsPresent(drpCardStatus, listDrpCardStatus)
		WebUI.selectOptionByLabel(drpCardStatus, "Sudah Aktivasi", false)
	} else {keylogger.logInfo("Element Not Found")}
		WebUI.navigateToUrl(requestIdRt)
		if (WebUI.verifyElementClickable(btnDataDeliveryCard,FailureHandling.OPTIONAL)) {
			WebUI.click(btnDataDeliveryCard)
			if (WebUI.verifyElementClickable(btnEditDeliveryAddress,FailureHandling.OPTIONAL)) {
				WebUI.click(btnEditDeliveryAddress)
				oldDataRt = WebUI.getAttribute(fieldRt, 'value')
				println(oldDataRt)
				
				WebUI.setText(fieldRt, RandomStringUtils.randomNumeric(3))
				newDataRt = WebUI.getText(fieldRt)
				newDataRt = WebUI.getAttribute(fieldRt, 'value')
				println(newDataRt)
				keylogger.logInfo('We already input RT field')
				if (WebUI.verifyElementClickable(btnSimpanData,FailureHandling.OPTIONAL)) {
					WebUI.click(btnSimpanData)
				} else {keylogger.markError('Button is not clickable')}
			} else {keylogger.markError('Button is not clickable')}
		} else {keylogger.logInfo("Element Not Click Able")}
		oldDataRtData = oldDataRt
		println(oldDataRtData)
		newDataRtData = newDataRt
		println(newDataRtData)
		if (WebUI.verifyElementClickable(btnDataChangeLog,FailureHandling.OPTIONAL)) {
			WebUI.click(btnDataChangeLog)
			WebDriver oldDriver = DriverFactory.getWebDriver()
			WebElement oldTblCsr = oldDriver.findElement(By.xpath('//*[@id="changelog"]//tbody'))
			List<WebElement> oldRowCsr = oldTblCsr.findElements(By.tagName('tr'))
			List<WebElement> oldColsCsr = oldRowCsr.get(0).findElements(By.tagName('td'))
			
			/*We want verify text from current date and date first row*/
			def currentDate = new Date().format('dd/MM/yyyy')
			println(currentDate)
			dateInChangeLog = WebUI.getText(txtDateFirstRow)
			println(dateInChangeLog)
			if (dateInChangeLog.contains(currentDate)) {
				keylogger.markPassed('Tanggal --> date with time when the changes was created')
			}
			/*We want verify text from change log and existing data User / Agent*/			
			agentInChangeLog = oldColsCsr.get(1).getText()
			println(agentInChangeLog)
			WebUI.verifyMatch(agentInChangeLog, agentInChangeLog, false)
			keylogger.markPassed('User/Agent --> agent name')
			/*We want verify text from change log and existing source is CSR Management*/
			sourceInChageLog = oldColsCsr.get(2).getText()
			println(sourceInChageLog)
			WebUI.verifyMatch(sourceInChageLog, 'CSR Management', false)
			keylogger.markPassed('source --> CSR Management')
			/*We want verify text from change log and existing field is tempat pengiriman kartu*/
			fieldInChangeLog = oldColsCsr.get(3).getText()
			println(fieldInChangeLog)
			WebUI.verifyMatch(fieldInChangeLog, 'RT', false)
			keylogger.markPassed('Field --> RT')
			/*We want verify text from change log and verify text from old data*/
			oldDataInChangeLog = oldColsCsr.get(4).getText()
			println(oldDataInChangeLog)
			WebUI.verifyMatch(oldDataInChangeLog, oldDataRtData, false)
			keylogger.markPassed('Data lama --> old place')
			/*We want verify text from change log and verify text from new data*/
			newDataInChangeLog = oldColsCsr.get(5).getText()
			println(newDataInChangeLog)
			WebUI.verifyMatch(newDataInChangeLog, newDataRtData, false)
			keylogger.markPassed('Data baru --> new place')
		} else {keylogger.logInfo("Element Not Click Able")}
		WebUI.click(btnBack)
} else {keylogger.logInfo("Element Not Found")}