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
import org.openqa.selenium.WebDriver as Keys
import org.openqa.selenium.WebElement

'init Keylogger'
KeywordUtil keylogger = new KeywordUtil()

'Scenario Testing'
/* 	PRECONDITION
 * 	User has access to confirmation save pop up
	
	STEPS
	Click "Batal" button in confirmation pop up

	EXPECTED RESULT
	System close the confirmation pop up and display KYC video call active calls customer details
 */

'We want to access KYC Video Request'
WebUI.click(linkMenuKycManagement)
if (WebUI.waitForElementVisible(linkMenuKycVideoReq, 5)) {
	WebUI.click(linkMenuKycVideoReq)
	if (WebUI.waitForElementVisible(alertText, 5)) {
		WebUI.click(btnCancelPending)
	} else {
		keylogger.logInfo('We dont see pending request active call')
	}
	WebUI.click(tabIdleCalls)
	WebUI.waitForPageLoad(5)
	WebUI.delay(3)
	WebDriver driver = DriverFactory.getWebDriver()
	WebElement tableBucketList
	List<WebElement> rowBucketList
	List<WebElement> colsBucketList
	checkReqId = false
	loopCheckData:
	while (checkReqId == false) {
		WebUI.selectOptionByLabel(drpCustType, 'Nasabah Baru', false)
		tableBucketList = driver.findElement(By.xpath('//table/tbody'))
		rowBucketList = tableBucketList.findElements(By.tagName('tr'))
		for (int i=0;i < rowBucketList.size();i++) {
			colsBucketList = rowBucketList.get(i).findElements(By.tagName('td'))
			if (colsBucketList.get(3).getText().equalsIgnoreCase('Registrasi Baru') && colsBucketList.get(7).getText().equalsIgnoreCase('Menunggu')) {
				colsBucketList.get(1).findElement(By.xpath('a')).click()
				WebUI.waitForPageLoad(5)
				TestObject inKycVideoReq = new TestObject().addProperty('text',ConditionType.CONTAINS,'KYC Video Request')
				if (WebUI.waitForElementVisible(inKycVideoReq, 5)) {
					requestIdKycVideo = WebUI.getText(reqId)
				}
			} else {
				keylogger.logInfo('We want try to check another Request ID')
				tableBucketList = driver.findElement(By.xpath('//table/tbody'))
				rowBucketList = tableBucketList.findElements(By.tagName('tr'))
			}
		}
	}
} else {
	keylogger.markError('Link menu KYC Video Request Not Available')
}

'I want store request ID'
reqIKycVideo = requestIdKycVideo