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
if (WebUI.waitForElementPresent(menuCsrManagement, 5)) {
	WebUI.click(menuCsrManagement)
	if (WebUI.verifyElementVisible(notifBlockCsr,FailureHandling.OPTIONAL)) {
		WebUI.click(btnCancelBlock)
		keylogger.logInfo("We cancel the block")
		WebUI.verifyElementVisible(txtHeaderCsrManagement)
	} else {
		keylogger.logInfo("We dont get block")
		WebUI.verifyElementVisible(txtHeaderCsrManagement)
	}
} else {keylogger.markError("We don't see Csr Management Menu")}

/* We want Verify design modal block card with condition already have card number
 * Precondition:
	- Already on pop up sequrity question "Email"
 
 * And have steps:
	- Input the true "Email"
	- Click on "Lanjutkan"
	
	And we have the expected result is :
	-Direct to CSR detail
	-User name that access detail is recorded and it will be displayed on change log action "Succeed" and field "Security Question"
	-User name that access detail is recorded and it will be displayed on change log action "Viewed"
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
				if (WebUI.waitForElementVisible(drpCustType, 5)) {
					WebUI.verifyOptionsPresent(drpCustType, listDrpCustType)
					WebUI.selectOptionByLabel(drpCustType, "Nasabah Senyumku", false)
					if (WebUI.waitForElementVisible(drpCardStatus, 5)) {
						WebUI.verifyOptionsPresent(drpCardStatus, listDrpCardStatus)
						WebUI.selectOptionByLabel(drpCardStatus, "Sudah Aktivasi", false)
						WebUI.setText(txtAccountNumb, accountNumb)
						WebUI.click(btnSubmitSearch)
					} else {keylogger.logInfo("Element Not Found")}
				} else {keylogger.logInfo("Element Not Found")}
				List<WebElement> listCols = listRows.get(i).findElements(By.tagName('td'))
				if (listCols.get(4).getText().equalsIgnoreCase(accountNumb)) {
					listCols.get(6).findElement(By.tagName('button')).click()
					WebDriver driverTblChangeLog = DriverFactory.getWebDriver()
					WebElement tableChangeLog
					List<WebElement> listRowsTblChgLog
					TestObject csrSecurityQuestion = new TestObject().addProperty('text',ConditionType.CONTAINS,"Email")
					if (WebUI.waitForElementPresent(csrSecurityQuestion, 5)) {
						'Please check the question from CSR detail if you want make it succeed'
						WebUI.setText(fieldInputEmailSecQuest, "senyumku99974321@yopmail.com")
						WebUI.click(btnSubmitSecQuest)
						WebUI.scrollToElement(linkDataChangeLog, 5)
						TestObject csrDetailPage = new TestObject().addProperty('text',ConditionType.CONTAINS,'Customer Detail')
						if (WebUI.waitForElementPresent(csrDetailPage, 5)) {
							WebUI.scrollToElement(linkDataChangeLog, 5)
							WebUI.click(linkDataChangeLog)
							TestObject checkWording = new TestObject().addProperty('text',ConditionType.CONTAINS,'Security Question')
							if (WebUI.verifyElementPresent(checkWording, 5)) {
								TestObject checkSuccessText = new TestObject().addProperty('text',ConditionType.CONTAINS,'Succeed')
								WebUI.verifyElementPresent(checkSuccessText, 5)
								WebUI.click(btnBackDashboard)
								WebUI.waitForPageLoad(5)
								break loopPage
							} else {keylogger.markError('We Not found the wording')}
						} else {keylogger.markError('We are not in customer detail')}						
					} else { keylogger.logInfo('We by pass the security question email')}
						if (WebUI.waitForElementPresent(fieldInputMotherSecQuest, 5)) {
							TestObject csrEmailQuest = new TestObject().addProperty('text',ConditionType.CONTAINS,'Nama Ibu Kandung')
							if (WebUI.verifyElementPresent(csrEmailQuest, 5,FailureHandling.OPTIONAL)) {
								WebUI.setText(fieldInputMotherSecQuest, "NICHOLAS")
								WebUI.click(btnSubmitSecQuest)
							} else {keylogger.logInfo("We define the birthdate security question")}
						} else {keylogger.logInfo('We try with birthdate')}
						if (WebUI.waitForElementPresent(fieldInputBirthdaySecQuest, 5)) {
							TestObject csrBirtDateQuest = new TestObject().addProperty('text',ConditionType.CONTAINS,'Tanggal Lahir')
							if (WebUI.verifyElementPresent(csrBirtDateQuest, 5,FailureHandling.OPTIONAL)) {
								WebUI.setText(fieldInputBirthdaySecQuest, "18/04/1976")
								WebUI.sendKeys(fieldInputBirthdaySecQuest,Keys.chord(Keys.ENTER))
								WebUI.click(btnSubmitSecQuest)
							} else {keylogger.logInfo("We by pass the security question")}
						} else {keylogger.logInfo("We are didn't get security question mother name")}
						if (WebUI.waitForElementVisible(txtHeaderCustDetail, 5)) {
							boolean loopPageChangeLog = false
							loopChangeLog:
							while (loopPageChangeLog == false) {
								TestObject csrDetailPage = new TestObject().addProperty('text',ConditionType.CONTAINS,'Customer Detail')
								if (WebUI.verifyElementPresent(csrDetailPage, 5)) {
									WebUI.scrollToElement(linkDataChangeLog, 5)
									WebUI.click(linkDataChangeLog)
								} else {keylogger.markError('We are not in customer detail')}
								tableChangeLog = driverTblChangeLog.findElement(By.xpath('//*[@id="changelog"]//table/tbody'))
								listRowsTblChgLog = tableChangeLog.findElements(By.tagName('tr'))
								for (int j = 0;j < listRowsTblChgLog.size(); j++) {
									println('No. of rows: ' + listRowsTblChgLog.size()+ ' row number '+j)
									List<WebElement> listColsTblChgLog = listRowsTblChgLog.get(j).findElements(By.tagName('td'))
									if (listColsTblChgLog.get(6).getText().equalsIgnoreCase('Succeed')) {
										listColsTblChgLog.get(3).getText().equalsIgnoreCase('Security Question')
										WebUI.click(btnBackDashboard)
										WebUI.waitForPageLoad(5)
										break loopPage
										break loopChangeLog
									} else {
										keylogger.logInfo('we not found the data')
										tableChangeLog = driverTblChangeLog.findElement(By.xpath('//*[@id="changelog"]//table/tbody'))
										 listRowsTblChgLog = tableChangeLog.findElements(By.tagName('tr'))
									}
								}
							}
						} else {
							keylogger.logInfo('Wording is not shown')}	
						tableCsrMgt = driverTblCsrMgt.findElement(By.xpath('//table/tbody'))
						listRows = tableCsrMgt.findElements(By.tagName('tr'))
				} else {keylogger.logInfo("Please check again")
				}
		}
}