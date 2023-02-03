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
boolean wordingCsrMgt = wordingHeaderCsrMgt
WebDriver driverTblCsrMgt = DriverFactory.getWebDriver()
WebElement tableCsrMgt
List<WebElement> listRows
flagDataReqId = false
LoopCsrManagement:
while (flagDataReqId == false) {
	tableCsrMgt = driverTblCsrMgt.findElement(By.xpath('//table/tbody'))
	listRows = tableCsrMgt.findElements(By.tagName('tr'))
	for (int i = 0; i < listRows.size() ; i++) {
	if (wordingCsrMgt == true) {
		boolean idxDataFltrCrdSts = WebUI.verifyOptionsPresent(drpDwnFltrSts, drpDwnListFltrCrdSts)
		if (idxDataFltrCrdSts == true) {
			WebUI.selectOptionByLabel(drpDwnFltrSts, 'Sudah Aktivasi', false)
			boolean idxDataCsrTyp = WebUI.verifyOptionsPresent(drpDwnFltrCsrTyp, drpDwnListFltrCsrTyp)
			if (idxDataCsrTyp == true) {
				WebUI.selectOptionByLabel(drpDwnFltrCsrTyp, 'Nasabah Senyumku', false)
			} else {keyLogger.logInfo('We not found the data')}
		} else {keyLogger.logInfo('We not found the data')}	
	} else {keyLogger.logInfo('We not found the data')}
			println('No. of rows: ' + listRows.size() + 'and number of row is = ' +i)
			List<WebElement> listCols = listRows.get(i).findElements(By.tagName('td'))
				if (listCols.get(6).getText().equalsIgnoreCase('Detail')) {
					listCols.get(6).findElement(By.tagName('button')).click()
					String headerCustDetail = WebUI.getText(txtCustDetail)
					if (headerCustDetail.equalsIgnoreCase('Detil Nasabah')) {
						TestObject reqDetailStatus = new TestObject().addProperty('text',ConditionType.CONTAINS,'Selesai')
						if (WebUI.verifyElementPresent(reqDetailStatus, 5, FailureHandling.OPTIONAL)) {
							WebUI.click(linkDataAtmCard)
							if (WebUI.verifyElementClickable(btnReqNewCard, FailureHandling.OPTIONAL)) {
								WebUI.click(btnReqNewCard)
								TestObject checkPopUp = new TestObject().addProperty('text',ConditionType.CONTAINS,"Permintaan Kartu Baru")
								if (WebUI.verifyElementPresent(checkPopUp, 5)) {
									keyLogger.markPassed("We are in Pop Up Menu Request New Card "+checkPopUp+"")
									WebUI.takeScreenshot()
									String motherName = WebUI.getText(txtMotherName)
									String accountNumber = WebUI.getText(txtAccountNumber)
									String phoneNumber = WebUI.getText(txtPhoneNumber)
									if (motherName.equalsIgnoreCase(wordingAskMotherName)) {
										keyLogger.markPassed("Wording is correct = "+wordingAskMotherName+" next for question")
										WebUI.verifyElementClickable(askMotherNameCheckBox)
										WebUI.click(askMotherNameCheckBox)
										if (accountNumber.equalsIgnoreCase(wordingAccountNumber)) {
											keyLogger.markPassed("Wording is correct = "+wordingAccountNumber+" next for question")
											WebUI.verifyElementClickable(askAccountNumberCheckBox)
											WebUI.click(askAccountNumberCheckBox)
											if (phoneNumber.equalsIgnoreCase(wordingPhoneNumber)) {
												keyLogger.markPassed("Wording is correct = "+wordingPhoneNumber+" next for question")
												WebUI.verifyElementClickable(askPhoneNumberCheckBox)
												WebUI.click(askPhoneNumberCheckBox)
												WebUI.takeScreenshot()
												WebUI.click(btnBatalReqNewCard)
												break LoopCsrManagement
											} else {keyLogger.markError("Wording is not equal = "+wordingPhoneNumber+" please try again")}
										} else {keyLogger.markError("Wording is not equal = "+wordingAccountNumber+" please try again")}
									} else {keyLogger.markError("Wording is not equal = "+wordingAskMotherName+" please try again")}
								} else {keyLogger.markError("Request Menu Pop up not appear")}
							} else {
								keyLogger.logInfo("We cannot click the button")
								WebUI.click(btnBack)
								WebUI.waitForPageLoad(5)
								WebUI.delay(3)
								tableCsrMgt = driverTblCsrMgt.findElement(By.xpath('//table/tbody'))
								listRows = tableCsrMgt.findElements(By.tagName('tr'))
								}
						} else {
							keyLogger.logInfo("The element contains "+reqDetailStatus+" try again")
							WebUI.click(btnBack)
							WebUI.waitForPageLoad(5)
							WebUI.delay(3)
							tableCsrMgt = driverTblCsrMgt.findElement(By.xpath('//table/tbody'))
							listRows = tableCsrMgt.findElements(By.tagName('tr'))
							}
					} else {keyLogger.markError("We are not in customer detail")}
			} else {keyLogger.markError("We cannot get the element")}
		}
	}

