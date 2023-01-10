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

'init function'
KeywordUtil keylogger = new KeywordUtil()

'Scenario Testing'
/* 	Preconditions
 * 	- User has access to KYC video call customer details
	- Customer has not verified the email
	- User has click "Edit" button
	
	Steps
	- Input valid email address
	- Click "Save" button
	
	Expected Result
	- System display "Email berhasil disimpan" toast message
	- Email is updated to the new in CSR
 * */

'We want access to KYC Video Request'
if (WebUI.waitForElementVisible(menuKycManagement, 5)) {
	WebUI.click(menuKycManagement)
	if (WebUI.waitForElementVisible(menuKycVideoRequest, 5)) {
		WebUI.click(menuKycVideoRequest)
		'This part if we handle the "Konfirmasi alert"'
		if (WebUI.waitForElementVisible(alertNotif, 5)) {
			WebUI.click(btnAbort)
		} else {keylogger.logInfo("We can continue the process")}
		if (WebUI.waitForElementVisible(alertNotif, 5)) {
			WebUI.click(btnContinue)
			WebUI.scrollToElement(btnCancelVideoRequest, 5)
			WebUI.click(btnCancelVideoRequest)
		} else {keylogger.logInfo("We can continue the process")}
		TestObject accessKycVideoRequest = new TestObject().addProperty('text',ConditionType.CONTAINS,'KYC Video Request')
		if (WebUI.waitForElementVisible(accessKycVideoRequest, 5)) {
			WebUI.click(tabIdleCalls)
			if (WebUI.waitForElementVisible(alertNotif, 5)) {
				WebUI.click(btnAbort)
			} else {keylogger.logInfo("We can continue the process")}
		} else {keylogger.markError("We are not in KYC Video Request")}
	} else {keylogger.markError("Menu KYC video request not visible")}
} else {keylogger.markError("Menu KYC Management not visible")}

'We want to check Web element for table'
WebDriver driverIdleCalls = DriverFactory.getWebDriver()
WebElement tblIdleCalls
List<WebElement> rowsIdleCalls
List<WebElement> colsIdleCalls

'We want to check condition is email not verify'
checkLoop = false
emailNotVerify:
while (checkLoop == false) {
	tblIdleCalls = driverIdleCalls.findElement(By.xpath('//table/tbody'))
	rowsIdleCalls = tblIdleCalls.findElements(By.tagName("tr"))
	for (int i ; i < rowsIdleCalls.size() ; i ++) {
		if (rowsIdleCalls.size() != 9) {
			WebUI.verifyOptionsPresent(drpDwnCustType, listDrpDwnCustType)
			WebUI.selectOptionByLabel(drpDwnCustType, "Nasabah Baru", false)
			colsIdleCalls = rowsIdleCalls.get(i).findElements(By.tagName("td"))
			if (colsIdleCalls.get(5).getText().equalsIgnoreCase("Nasabah Baru")) {
				colsIdleCalls.get(3).getText().equalsIgnoreCase("Registrasi Baru")
				colsIdleCalls.get(1).findElement(By.xpath('a')).click()
				TestObject accessToDetail = new TestObject().addProperty('text',ConditionType.CONTAINS,'KYC Video Request')
				WebUI.verifyElementPresent(accessToDetail, 5)
				WebUI.scrollToElement(btnEditEmail, 5)
				TestObject openPii = new TestObject().addProperty('text',ConditionType.CONTAINS,'PII (Personally Identifying Information)')
				if (WebUI.waitForElementClickable(openPii, 5)) {
					WebUI.click(btnEditEmail)
					WebUI.setText(txtEmailDetails, GlobalVariable.randomFirstNameWhitelist)
					if (WebUI.waitForElementVisible(btnSaveEmail, 5)) {
						WebUI.click(btnSaveEmail)
					} else {keylogger.markError('Element not visible')}
					TestObject successToChangeEmail = new TestObject().addProperty('text',ConditionType.CONTAINS,'Email berhasil disimpan')
					WebUI.verifyElementPresent(successToChangeEmail, 5)
					emailChange = WebUI.getAttribute(txtEmailDetails, 'value')
					reqIdChangeEmail = WebUI.getText(reqIdKycVideoRequest)
					WebUI.takeScreenshot()
					WebUI.click(btnBackBucketList)
					break emailNotVerify
				} else {
					keylogger.logInfo('We must check another request Id')
					WebUI.click(btnBackBucketList)
					tblIdleCalls = driverIdleCalls.findElement(By.xpath('//table/tbody'))
					rowsIdleCalls = tblIdleCalls.findElements(By.tagName("tr"))
				}
			} else {keylogger.logInfo("Element Not Found")}
		} else {
			keylogger.logInfo("We have maximum row we want to check next page")
			WebUI.click(btnNextPageKycVideoRequest)
			tblIdleCalls = driverIdleCalls.findElement(By.xpath('//table/tbody'))
			rowsIdleCalls = tblIdleCalls.findElements(By.tagName("tr"))
			for (int j ; j < rowsIdleCalls.size() ; j ++) {
				if (rowsIdleCalls.size() != 9) {
					WebUI.verifyOptionsPresent(drpDwnCustType, listDrpDwnCustType)
					WebUI.selectOptionByLabel(drpDwnCustType, "Nasabah Baru", false)
					colsIdleCalls = rowsIdleCalls.get(i).findElements(By.tagName("td"))
					if (colsIdleCalls.get(5).getText().equalsIgnoreCase("Nasabah Baru")) {
						colsIdleCalls.get(3).getText().equalsIgnoreCase("Registrasi Baru")
						colsIdleCalls.get(1).findElement(By.xpath('a')).click()
					} else {keylogger.markError("Element Not Found")}
				} else {keylogger.markError("We must check again the data")} 
			}
		}
	}
}
emailHasChange = emailChange
println(emailHasChange)
reqIdCheck = reqIdChangeEmail
println(reqIdCheck)

'We want to check Web element for table'
WebDriver driverCsrBucketList = DriverFactory.getWebDriver()
WebElement tblCsrBucketList
List<WebElement> rowsCsrBucketList
List<WebElement> colsCsrBucketList

'We want to check changes email in CSR Management'
if (WebUI.waitForElementVisible(linkMenuCsrManagement, 5)) {
	WebUI.click(linkMenuCsrManagement)
	if (WebUI.waitForElementVisible(alertNotif, 5)) {
			WebUI.click(btnAbort)
		} else {keylogger.logInfo("We can continue the process")}
	TestObject accessCsrBucketList = new TestObject().addProperty('text',ConditionType.CONTAINS,'CSR Management')
	if (WebUI.waitForElementPresent(accessCsrBucketList, 5)) {
		WebUI.setText(txtReqIdCsrBucketList, reqIdCheck)
		WebUI.sendKeys(txtReqIdCsrBucketList, Keys.chord(Keys.ENTER))
		tblCsrBucketList = driverCsrBucketList.findElement(By.xpath('//table/tbody'))
		rowsCsrBucketList = tblCsrBucketList.findElements(By.tagName('tr'))
		colsCsrBucketList = rowsCsrBucketList.get(0).findElements(By.tagName('td'))
		if (colsCsrBucketList.get(5).getText().equalsIgnoreCase('Nasabah Baru')) {
			colsCsrBucketList.get(6).findElement(By.xpath('button')).click()
		} else {keylogger.markError('Text not found')}
		if (WebUI.waitForElementVisible(btnDataEmail, 5)) {
			WebUI.click(btnDataEmail)
			WebUI.verifyEqual(emailHasChange, GlobalVariable.randomFirstNameWhitelist)
			WebUI.takeScreenshot()
		} else {keylogger.markError('Element not visible')}
	} else {keylogger.markError("Element not present")}
}