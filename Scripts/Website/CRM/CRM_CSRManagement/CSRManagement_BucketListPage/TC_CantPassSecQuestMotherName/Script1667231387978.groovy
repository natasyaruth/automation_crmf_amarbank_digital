import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.github.javafaker.Faker
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
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable

import org.apache.commons.lang.RandomStringUtils
import org.apache.commons.lang.math.RandomUtils
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.Select
import com.kms.katalon.core.util.KeywordUtil
import com.tunaiku.keyword.RandomDate as RandomDate

/*We Declare Keyword Util*/
KeywordUtil keylogger = new KeywordUtil()
/*Setup faker email*/
Faker faker = new Faker()
String fullName = faker.name().fullName()
/* We want handling block condition*/
if (WebUI.waitForElementVisible(menuCsrManagement,5)) {
	WebUI.click(menuCsrManagement)
	if (WebUI.waitForElementVisible(notifBlockCsr,5)) {
		WebUI.click(btnCancelBlock)
		keylogger.logInfo("We cancel the block")
		WebUI.waitForElementVisible(txtHeaderCsrManagement,5)
	} else {
		keylogger.logInfo("We cannot get block")
		WebUI.verifyElementVisible(txtHeaderCsrManagement)
	}
} else {keylogger.markError("We don't see Csr Management Menu")}

/* We want Verify design modal block card with condition already have card number
 * Precondition:
 * 	1. User already input failed security question
	2. System already showing Customer cannot be access pop up
 * 
 * And have steps:
 * 	1. Click "Kembali"
 * 
	And we have the expected result is :
		1. Back to bucketlist
		2.Always refresh the page after click "Kembali"
*/
WebDriver driverTblCsrMgt = DriverFactory.getWebDriver()
WebElement tableCsrMgt
List<WebElement> listRows
boolean loopPageCsr = false
loopPage:
while (loopPageCsr == false) {
	tableCsrMgt = driverTblCsrMgt.findElement(By.xpath('//table/tbody'))
	listRows = tableCsrMgt.findElements(By.tagName('tr'))
		for (int i = 0; i < listRows.size(); i++) {
			println('No. of rows: ' + listRows.size()+ ' row number '+i)
				if (WebUI.waitForElementVisible(drpCustType,5)) {
					WebUI.verifyOptionsPresent(drpCustType, listDrpCustType)
					WebUI.selectOptionByLabel(drpCustType, "Nasabah Senyumku", false)
					if (WebUI.waitForElementVisible(drpCardStatus,5)) {
						WebUI.verifyOptionsPresent(drpCardStatus, listDrpCardStatus)
						WebUI.selectOptionByLabel(drpCardStatus, "Sudah Aktivasi", false)
					} else {keylogger.logInfo("Element Not Found")}
				} else {keylogger.logInfo("Element Not Found")}
				List<WebElement> listCols = listRows.get(i).findElements(By.tagName('td'))
				if (listCols.get(6).getText().equalsIgnoreCase('Detail')) {
					listCols.get(6).findElement(By.tagName('button')).click()
					TestObject csrSecurityQuestion = new TestObject().addProperty('text',ConditionType.CONTAINS,'Nama Ibu Kandung')
					if (WebUI.verifyElementPresent(csrSecurityQuestion, 5,FailureHandling.OPTIONAL)) {
						boolean loopSecQuestion = false
						loopSecQuestion:
						while (loopSecQuestion == false) {
							WebUI.setText(fieldInputMotherSecQuest, fullName)
							WebUI.click(btnSubmitSecQuest)
							TestObject alertCantAccessCust = new TestObject().addProperty('text',ConditionType.CONTAINS,'Nasabah tidak bisa di akses')
							if (WebUI.verifyElementPresent(alertCantAccessCust, 5,FailureHandling.OPTIONAL)) {
								WebUI.verifyElementClickable(btnBackCloseLockModal)
								WebUI.click(btnBackCloseLockModal)
								keylogger.markPassed('Always refresh the page after click "Kembali"')
								WebUI.takeScreenshot()
								break loopSecQuestion
							} else {keylogger.logInfo('Try Again Until Lock')}
							if (WebUI.waitForElementVisible(alertWrongSecQuest,5)) {
								keylogger.markPassed('Pop up alert wrong input')
								WebUI.click(btnBatalSecQuest)
							} else {keylogger.markError('Alert not shown')}
							if (listCols.get(6).getText().equalsIgnoreCase('Detail')) {
								listCols.get(6).findElement(By.tagName('button')).click()
								WebUI.waitForElementVisible(alertWrongSecQuest,5)
								keylogger.markPassed('Count down still running (not reset)')
								} else {keylogger.logInfo('We not found the detail')}
						}
						WebUI.takeScreenshot()
						if (WebUI.verifyElementClickable(btnBatalSecQuest,FailureHandling.OPTIONAL)) {
							WebUI.click(btnBatalSecQuest)
						} else {
							keylogger.logInfo('We are already finished')
							WebUI.takeScreenshot()
							break loopPage
						}
					} else {
						keylogger.logInfo("We are didn't get security question Email")
						if (WebUI.verifyElementClickable(btnBatalSecQuest,FailureHandling.OPTIONAL)) {
							WebUI.click(btnBatalSecQuest)
						} else {
							WebUI.verifyElementClickable(btnBackCloseLockModal)
							WebUI.click(btnBackCloseLockModal)
						}
						tableCsrMgt = driverTblCsrMgt.findElement(By.xpath('//table/tbody'))
						listRows = tableCsrMgt.findElements(By.tagName('tr'))
						}
						if (i == (listRows.size() - 1)) {
							keylogger.logInfo('We move next page')
							WebUI.click(btnNextPage)
							tableCsrMgt = driverTblCsrMgt.findElement(By.xpath('//table/tbody'))
							listRows = tableCsrMgt.findElements(By.tagName('tr'))
							WebUI.takeScreenshot()
						} else {keylogger.logInfo('we continue the process')}
				} else {keylogger.markError("We didn't get the element")}
		}
}