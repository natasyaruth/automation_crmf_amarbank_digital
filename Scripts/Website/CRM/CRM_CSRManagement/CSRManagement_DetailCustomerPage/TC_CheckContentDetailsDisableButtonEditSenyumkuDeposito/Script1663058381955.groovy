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
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.sun.net.httpserver.Authenticator.Failure

import internal.GlobalVariable

import org.apache.commons.lang.RandomStringUtils
import org.apache.commons.lang.math.RandomUtils
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.util.KeywordUtil

/* Declare keyword util as logger*/
KeywordUtil keyLogger = new KeywordUtil()

/* We want to access CSR Detail by menu CSR Management with condition Nasabah Deposito with disable button edit With Step :
 * 1. Agen Click section "Data KTP"*/

linkCsrManagement = WebUI.getText(menuCsrManagement)
if (linkCsrManagement.equalsIgnoreCase('CSR Management')) {
	WebUI.click(menuCsrManagement)
	if (WebUI.verifyElementVisible(popUpBlockNotif,FailureHandling.OPTIONAL)) {
		WebUI.verifyElementText(wrdBlockNotif, "Konfirmasi")
		WebUI.click(btnCancelBlockNotif)
		WebUI.verifyElementVisible(txtheaderCsrManagement)
	} else {keyLogger.logInfo('We can continue the process')
		WebUI.verifyElementVisible(txtheaderCsrManagement)
	}
} else {keyLogger.markError("We not find text CSR Management")}

/* We want to access detail customer with condition
 * And we want expect : Button "Edit" is disable*/

WebDriver driverCsrMgt = DriverFactory.getWebDriver()
WebElement tblCsrMgt
List<WebElement> rowsCsrMgt
LoopCount:
while (flagCount == false) {
	tblCsrMgt = driverCsrMgt.findElement(By.xpath('//table/tbody'))
	rowsCsrMgt = tblCsrMgt.findElements(By.tagName('tr'))
	wrdCsrManagement = WebUI.getText(txtheaderCsrManagement)
	if (wrdCsrManagement.equalsIgnoreCase('CSR Management')) {
		WebUI.verifyOptionsPresent(drpFilterCustType, listDrpFilterCustType)
		WebUI.selectOptionByLabel(drpFilterCustType, custType, false)
	} else {keyLogger.markError("We not find the element")}
	for (int i = 0;i < rowsCsrMgt.size();i++) {
		println(' Total of Data : ' +rowsCsrMgt.size()+ ' and existing row is : ' +i)
		List<WebElement> colsCsrMgt = rowsCsrMgt.get(i).findElements(By.xpath('td'))
		if (rowsCsrMgt.size() != i) {
			if (colsCsrMgt.get(5).getText().equalsIgnoreCase('Senyumku Deposito')) {
				colsCsrMgt.get(6).findElement(By.tagName('button')).click()
				TestObject detailCsrDtl = new TestObject().addProperty('text',ConditionType.CONTAINS,'Detil Nasabah')
				if (WebUI.verifyElementPresent(detailCsrDtl, 5, FailureHandling.OPTIONAL)) {
					WebUI.click(dataKtp)
					if (WebUI.verifyElementNotClickable(btnEditKtp,FailureHandling.OPTIONAL)) {
						keyLogger.markPassed("Button Edit is disable")
						WebUI.takeScreenshot()
					break LoopCount
				} else {
					keyLogger.logInfo("Button edit it can click able")
					WebUI.click(btnBackToCsrBucketList)
					tblCsrMgt = driverCsrMgt.findElement(By.xpath('//table/tbody'))
					rowsCsrMgt = tblCsrMgt.findElements(By.tagName('tr'))
				}
			} 
		} else {
			keyLogger.logInfo("Please search again another row: " +i)
			tblCsrMgt = driverCsrMgt.findElement(By.xpath('//table/tbody'))
			rowsCsrMgt = tblCsrMgt.findElements(By.tagName('tr'))
			}
		} else {
			keyLogger.logInfo("Please search again another page ")
			WebUI.click(btnNextPage)
			tblCsrMgt = driverCsrMgt.findElement(By.xpath('//table/tbody'))
			rowsCsrMgt = tblCsrMgt.findElements(By.tagName('tr'))
		}
	}
}

