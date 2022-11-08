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
loopSearch:
boolean flagLoop = false
while (flagLoop == false) {
	tblBucketList = driver.findElement(By.xpath('//table/tbody'))
	rowsBucketList = tblBucketList.findElements(By.tagName('tr'))
	for (int i = 0;i < rowsBucketList.size() ; i ++) {
		'First I want makesure data is already "Precondition"'
		if (WebUI.waitForElementVisible(drpDwnCardStatus, 5)) {
			if (WebUI.waitForElementVisible(drpDwnCardStatus,5)) {
				WebUI.selectOptionByLabel(drpDwnCardStatus, 'Belum Aktivasi', false)
			} else {keylogger.logInfo('element not visible')}
			if (WebUI.waitForElementVisible(drpDwnCardStatus,5)) {
				WebUI.selectOptionByLabel(drpDwnCustType, 'Nasabah Senyumku', false)
			} else {keylogger.logInfo('element not visible')}
		} else {keylogger.markError('Menu cannot click able')}
		println(' Total of Data : ' +rowsBucketList.size()+ ' and existing row is : ' +i)
		List<WebElement> colsBucketList = rowsBucketList.get(i).findElements(By.xpath('td'))
		if (i != (rowsBucketList.size() - 1)) {
			if (colsBucketList.get(5).getText().equalsIgnoreCase('Nasabah Senyumku')) {
				colsBucketList.get(6).findElement(By.tagName('button')).click()
				TestObject detailCsrDtl = new TestObject().addProperty('text',ConditionType.CONTAINS,'Detil Nasabah')
				if (WebUI.verifyElementPresent(detailCsrDtl, 5)) {
					WebUI.scrollToElement(btnDataAtmCard, 5)
					WebUI.click(btnDataAtmCard)
					if (WebUI.verifyElementClickable(btnReqNewCard)) {
						WebUI.click(btnReqNewCard)
						WebUI. click(chkMotherName)
						WebUI. click(chkAccountNumber)
						WebUI. click(chkRegistPhoneNumber)
						WebUI.click(rbLostCard)
						if (WebUI.verifyElementClickable(btnSubmitReqNewCard)) {
							WebUI.click(btnSubmitReqNewCard)
							WebUI.click(btnBack)
							break loopSearch
						} else {keylogger.markError('button submit is disable')}
					} else {
						keylogger.logInfo('We must search another Request ID')
						WebUI.click(btnBack)
						tblBucketList = driver.findElement(By.xpath('//table/tbody'))
						rowsBucketList = tblBucketList.findElements(By.tagName('tr'))
					}
				} else {
					keylogger.markError('element not present')
					}
			} else { keylogger.logInfo('Something wrong!!')}
		} else {
			keylogger.logInfo(' We must move to another page because we capture until ' +rowsBucketList.size())
			if (WebUI.verifyElementClickable(btnNextPageBucketList)) {
				WebUI.click(btnNextPageBucketList)
				tblBucketList = driver.findElement(By.xpath('//table/tbody'))
				rowsBucketList = tblBucketList.findElements(By.tagName('tr'))
			}
		}
	}
}

/* We want to makesure we can identify element assign card*/
if (WebUI.waitForElementVisible(menuAssignCardElement, 5)) {
	/* We want to click menu assign card element*/
	WebUI.click(menuAssignCardElement)
} else {
	/* We want to verify menu card management element*/
	WebUI.verifyElementPresent(menuCardManagementElement, 5)
	/* We want to click menu card management to exand sub menu*/
	WebUI.click(menuCardManagementElement)
	/* We want to verify menu assign card element*/
	WebUI.verifyElementPresent(menuAssignCardElement, 5)
	/* We want to click menu assign card element*/
	WebUI.click(menuAssignCardElement)
}

/* We want handling the execption in Assign Card if available when the process is locked*/
if (WebUI.verifyElementPresent(blockBylockedUserElement, 5)) {
	WebUI.verifyElementText(alertConfirmationPopUpElement, alertConfirmationPopUpText)
	WebUI.verifyElementText(btnCancelPopUpElement, btnCancelPopUpText)
	WebUI.click(btnCancelPopUpElement)
}else {
	WebUI.verifyElementText(headerAssignCardElement, headerAssignCardText)
}

/* We want to verify the label "Filter by request new card"*/
WebUI.verifyElementPresent(labelFilterByRequestCard, 5)

/* We want to check element visibility dropdown */
WebUI.verifyElementPresent(cardTypeDropDown, 5)

/* We want to select and choose card type dropdown for "kartu baru"*/
WebUI.selectOptionByLabel(cardTypeDropDown, newCardText, false)

/* We want to verify filter for "Kartu baru"*/
WebUI.verifyElementPresent(newCardElement, 5)

/* We want to verify filter new card*/
WebUI.verifyElementText(newCardElement, newCardText)

/* We want capture new card*/
WebUI.takeScreenshot()

/* We want to check element visibility */
WebUI.verifyElementPresent(cardTypeDropDown, 5)

/* We want to select and choose card type dropdown for "permintaan kartu baru"*/
WebUI.selectOptionByLabel(cardTypeDropDown, requestNewCardText, false)

/* We want to verify filter for "Kartu baru"*/
WebUI.verifyElementPresent(requestNewCardElement, 5)

/* We want to verify filter new card*/
WebUI.verifyElementText(requestNewCardElement, requestNewCardText)

/* We want capture new card*/
WebUI.takeScreenshot()

/* We want to refresh for the next process*/
WebUI.refresh()