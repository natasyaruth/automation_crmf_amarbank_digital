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

'init function logging'
KeywordUtil keylogger = new KeywordUtil()

'Scenario Testing'
/*Precondition
 * 	- Already open CRM
	- Already open KYC Verification
	- Already open the detail one of customer type nasabah baru which email has verified
	- Photo Selfie is not matched with dukcapil data

	Steps
	- Click on button "Cek" on facematch dukcapil
	- Click on "Lakukan Facematch Dukcapil' in pop up confirmation check facematch dukcapil
	
	Expected Result
	- Got response 200 from dukcapil
	- Show status message "Image not match" and value in table section Facematch Dukcapil
	- Button "Cek" Facematch Verihub is enable & FM Dukcapil is disable
	- Value is record on changes log and CSR
 */

'Init access HTML'
WebDriver driverKycVerif = DriverFactory.getWebDriver()
WebElement tblKycVerif
List<WebElement> rowsKycVerif
List<WebElement> colsKycVerif

'We want access to KYC Verification'
if (WebUI.waitForElementVisible(linkMenuKycManagement, 5)) {
	WebUI.click(linkMenuKycManagement)
	if (WebUI.waitForElementVisible(linkMenuKycVerification, 5)) {
		WebUI.click(linkMenuKycVerification)
		tblKycVerif = driverKycVerif.findElement(By.xpath('//table/tbody'))
		rowsKycVerif = tblKycVerif.findElements(By.tagName('tr'))
		colsKycVerif = rowsKycVerif.get(0).findElements(By.tagName('td'))
		if (colsKycVerif.get(7).getText().equalsIgnoreCase('Sedang diproses')) {
			colsKycVerif.get(7).findElement(By.xpath('a')).click()
			TestObject accessInKycVerifDetail = new TestObject().addProperty('text',ConditionType.CONTAINS,'KYC Customer Detail')
			if (WebUI.waitForElementVisible(accessInKycVerifDetail, 5)) {
				WebUI.click(btnBackToKyc)
			}
		}
	}
}