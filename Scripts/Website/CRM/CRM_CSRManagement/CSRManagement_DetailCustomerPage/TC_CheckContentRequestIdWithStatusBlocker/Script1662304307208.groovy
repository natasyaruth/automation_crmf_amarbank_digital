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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad as WaitForPageToLoad
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.tunaiku.keyword.SecureUtils as SecureUtils
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testobject.RequestObject
import groovy.json.JsonSlurper
import static org.assertj.core.api.Assertions.*

import org.jsoup.select.Evaluator.ContainsText

import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.testobject.internal.impl.HttpBodyContentReader
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.testobject.ConditionType

/*Declare the keyword util as print to console*/
KeywordUtil keyLogger = new KeywordUtil()

/* We want to handle the access CSR Management
 * then we want to access the menu deliverys status*/
linkCsrManagement = WebUI.getText(menuCsrManagement)
if (linkCsrManagement.contains(wordingCsrMgt)) {
	WebUI.verifyElementVisible(menuCsrManagement)
	WebUI.click(menuCsrManagement)
	if (WebUI.verifyElementVisible(alertConfirmationContProcess,FailureHandling.OPTIONAL)) {
		wordingBlockConfirmation = WebUI.getText(alertConfirmationContProcess)
		if (wordingBlockConfirmation.contains('Konfirmasi')) {
			WebUI.verifyElementVisible(alertConfirmationContProcess)
			WebUI.click(btnCancel)
		} else {'We cannot doing this condition'}
	} else {
		WebUI.verifyElementVisible(headerCsrMgt)
	}
} else {keyLogger.markError('We not found menu Card Management')}

/* So expected result I want to : Show pop up "Permintaan Kartu Baru"
 * With :
 * 1. Choose filter card status
 * 2. Choose filter customer type
 * 3. Choose 1 detail
 * 4. In Detail Check part "Data Kartu ATM
 * 5. Click button "Permintaan Kartu Baru"
 * 6. Then show pop up detail in "Permintaan Kartu Baru
 * 7. If doesn't have, it will back and check in second data"*/
WebDriver driverTblCsrMgt = DriverFactory.getWebDriver()
String expectedStatus = 'Diblokir'
WebElement tableCsrMgt
List<WebElement> listRows
List<WebElement> listCols
boolean flagCondition = flagConditionTest
loopCondition:
while (flagCondition == false) {
	tableCsrMgt = driverTblCsrMgt.findElement(By.xpath('//table/tbody'))
	listRows = tableCsrMgt.findElements(By.tagName('tr'))
	for (int i = 0; i < listRows.size() ; i++) {
		println('No. of rows: ' + listRows.size() + 'and check list rows: ' +i)
		if (i == listRows.size()) {
			WebUI.click(btnNextPage)
			WebUI.waitForPageLoad(5)
			tableCsrMgt = driverTblCsrMgt.findElement(By.xpath('//table/tbody'))
			listRows = tableCsrMgt.findElements(By.tagName('tr'))
		} else {
			WebUI.verifyElementVisible(headerCsrMgt)
		if (WebUI.verifyOptionsPresent(drpDwnFltrSts, drpDwnListFltrCrdSts)) {
			WebUI.selectOptionByLabel(drpDwnFltrSts, 'Semua', false)
			if (WebUI.verifyOptionsPresent(drpDwnFltrCsrTyp, drpDwnListFltrCsrTyp)) {
				WebUI.selectOptionByLabel(drpDwnFltrCsrTyp, 'Nasabah Senyumku', false)
			} else {keyLogger.markError("Element not present")}
		} else {keyLogger.markError("Element not present")}					
					listCols = listRows.get(i).findElements(By.tagName('td'))
					listCols.get(6).findElement(By.tagName('button')).click()
					String headerCustDetail = WebUI.getText(txtCustDetail)
					if (headerCustDetail.equalsIgnoreCase('Detil Nasabah')) {
						TestObject reqDetailStatus = new TestObject().addProperty('text',ConditionType.CONTAINS,expectedStatus)
						if (WebUI.verifyElementPresent(reqDetailStatus, 5,FailureHandling.OPTIONAL)) {
							WebUI.click(linkDataAtmCard)
							if (WebUI.verifyElementNotClickable(btnReqNewCard, FailureHandling.OPTIONAL)) {
								keyLogger.markPassed("We are in Data Kartu ATM")							
						} else {keyLogger.markError("We are not in menu request new card")}
						WebUI.takeScreenshot()
						WebUI.verifyElementVisible(btnBack)
						WebUI.click(btnBack)
						break loopCondition
					} else {
						WebUI.verifyElementVisible(btnBack)
						WebUI.click(btnBack)
						tableCsrMgt = driverTblCsrMgt.findElement(By.xpath('//table/tbody'))
						listRows = tableCsrMgt.findElements(By.tagName('tr'))
					}
				} else {keyLogger.markError("Element not present")}
			}
		}
	}
	

