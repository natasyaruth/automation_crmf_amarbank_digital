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

/*We Declare Keyword Util*/
KeywordUtil keylogger = new KeywordUtil()
/*We want to init faker name*/
Faker faker = new Faker();
String fullName = faker.name().fullName();
String emailFaker = faker.name().firstName() +"@gmail.com"
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
 * 	1. Already on Pop up sequrity question of "Email"
	2. User already input the failed "Email"
 * 
 * And have steps:
 * 	1. Click batal
	2. Click detail
 * 
	And we have the expected result is :
		1. The latest pop up will be showed
		2. Count down still running (not reset)

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
			if (WebUI.verifyElementVisible(drpCustType,FailureHandling.OPTIONAL)) {
				WebUI.verifyOptionsPresent(drpCustType, listDrpCustType)
				WebUI.selectOptionByLabel(drpCustType, "Nasabah Senyumku", false)
				if (WebUI.verifyElementVisible(drpCardStatus,FailureHandling.OPTIONAL)) {
					WebUI.verifyOptionsPresent(drpCardStatus, listDrpCardStatus)
					WebUI.selectOptionByLabel(drpCardStatus, "Sudah Aktivasi", false)
				} else {keylogger.logInfo("Element Not Found")}
			} else {keylogger.logInfo("Element Not Found")}
			List<WebElement> listCols = listRows.get(i).findElements(By.tagName('td'))
			if (listCols.get(6).getText().equalsIgnoreCase('Detail')) {
				listCols.get(6).findElement(By.tagName('button')).click()
				TestObject csrSecurityQuestion = new TestObject().addProperty('text',ConditionType.CONTAINS,'Email')
				if (WebUI.verifyElementPresent(csrSecurityQuestion, 5,FailureHandling.OPTIONAL)) {
					WebUI.setText(fieldInputEmailSecQuest, emailFaker)
					WebUI.click(btnSubmitSecQuest)
					WebUI.takeScreenshot()
					if (WebUI.verifyElementVisible(alertWrongSecQuest,FailureHandling.OPTIONAL)) {
						keylogger.markPassed('Pop up alert wrong input')
						WebUI.click(btnBatalSecQuest)
					} else {keylogger.markError('Alert not shown')}
					if (listCols.get(6).getText().equalsIgnoreCase('Detail')) {
						listCols.get(6).findElement(By.tagName('button')).click()
						WebUI.verifyElementVisible(alertWrongSecQuest)
						WebUI.takeScreenshot()
						keylogger.markPassed('Count down still running (not reset)')
						} else {keylogger.logInfo('We not found the detail')}
					WebUI.verifyElementClickable(btnBatalSecQuest)
					WebUI.takeScreenshot()
					WebUI.click(btnBatalSecQuest)
					break loopPage
				} else {
					keylogger.logInfo("We are didn't get security question mother name")
					WebUI.click(btnBatalSecQuest)
					tableCsrMgt = driverTblCsrMgt.findElement(By.xpath('//table/tbody'))
					listRows = tableCsrMgt.findElements(By.tagName('tr'))
					}
			} else {keylogger.markError("We didn't get the element")}
		}
}