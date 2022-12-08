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

'Initial loggin in katalon studio'
KeywordUtil keylogger = new KeywordUtil()

if (WebUI.waitForElementVisible(menuCsrManagement, 5)) {
	WebUI.click(menuCsrManagement)
	if (WebUI.waitForElementVisible(popUpBlockNotif,5)) {
		WebUI.verifyElementText(wrdBlockNotif, "Konfirmasi")
		WebUI.click(btnCancelBlockNotif)
		WebUI.verifyElementVisible(txtheaderCsrManagement)
	} else {keylogger.logInfo('We can continue the process')
		WebUI.verifyElementVisible(txtheaderCsrManagement)
	}
} else {keylogger.markError("We not find text CSR Management")}

'We want to search the data'
WebDriver driver = DriverFactory.getWebDriver()
WebElement tblBucketList
List<WebElement> rowsBucketList
boolean flagLoop = false
LoopSearch:
while (flagLoop == false) {
	tblBucketList = driver.findElement(By.xpath('//table/tbody'))
	rowsBucketList = tblBucketList.findElements(By.tagName('tr'))
	for (int i = 0;i < rowsBucketList.size() ; i ++) {
		'First I want makesure data is already "Precondition"'
		if (WebUI.waitForElementVisible(drpDwnCardStatus, 5)) {
			if (WebUI.waitForElementVisible(drpDwnCardStatus,5)) {
				WebUI.selectOptionByLabel(drpDwnCardStatus, 'Sudah Aktivasi', false)
			} else {keylogger.logInfo('element not visible')}
			if (WebUI.waitForElementVisible(drpDwnCardStatus,5)) {
				WebUI.selectOptionByLabel(drpDwnCustType, 'Nasabah Senyumku', false)
			} else {keylogger.logInfo('element not visible')}
		} else {keylogger.markError('Menu cannot click able')}
		println(' Total of Data : ' +rowsBucketList.size()+ ' and existing row is : ' +i)
		List<WebElement> colsBucketList = rowsBucketList.get(4).findElements(By.xpath('td'))
		if (i != (rowsBucketList.size() - 1)) {
			if (colsBucketList.get(5).getText().equalsIgnoreCase('Nasabah Senyumku')) {
				String custName = colsBucketList.get(1).getText()
				colsBucketList.get(6).findElement(By.xpath('button')).click()
				TestObject detailCsrDtl = new TestObject().addProperty('text',ConditionType.CONTAINS,'Detil Nasabah')
				if (WebUI.verifyElementPresent(detailCsrDtl, 5,FailureHandling.OPTIONAL)) {
					WebUI.scrollToElement(btnDataAtmCard, 5)
					WebUI.click(btnDataAtmCard)
					if (WebUI.verifyElementClickable(btnReqNewCard,FailureHandling.OPTIONAL)) {
						WebUI.click(btnReqNewCard)
						WebUI. click(chkMotherName)
						WebUI. click(chkAccountNumber)
						WebUI. click(chkRegistPhoneNumber)
						WebUI.click(rbLostCard)
						if (WebUI.verifyElementClickable(btnSubmitReqNewCard,FailureHandling.OPTIONAL)) {
							WebUI.click(btnSubmitReqNewCard)
							WebUI.click(btnBack)
						} else {keylogger.markError('button submit is disable')}
					} else {
						keylogger.logInfo('We must search another Request ID')
						WebUI.click(btnBack)
						WebUI.delay(5)
						tblBucketList = driver.findElement(By.xpath('//table/tbody'))
						rowsBucketList = tblBucketList.findElements(By.tagName('tr'))
					}
					WebUI.click(menuCardManagementElement)
					WebUI.click(menuAssignCardElement)
					if (WebUI.waitForElementVisible(cardTypeDropDown, 5)) {
						WebUI.verifyOptionsPresent(cardTypeDropDown, listDrpCardType)
						WebUI.selectOptionByLabel(cardTypeDropDown, 'Permintaan Kartu Baru', false)
						TestObject cekReqNewCard = new TestObject().addProperty('text',ConditionType.CONTAINS,custName)
						if (WebUI.verifyElementPresent(cekReqNewCard, 5, FailureHandling.OPTIONAL)) {
							keylogger.markPassed('We found the customer')
							break LoopSearch
						}
					}
				} else {
					keylogger.markError('element not present')
					}
			} else { keylogger.logInfo('Something wrong!!')}
		} else {
			keylogger.logInfo(' We must move to another page because we capture until ' +rowsBucketList.size())
				WebUI.verifyElementClickable(btnNextPageBucketList)
				WebUI.click(btnNextPageBucketList)
				WebUI.delay(5)
				tblBucketList = driver.findElement(By.xpath('//table/tbody'))
				rowsBucketList = tblBucketList.findElements(By.tagName('tr'))
		}
	}
}

/* We want capture new card*/
WebUI.takeScreenshot()

/* We want to refresh for the next process*/
WebUI.refresh()