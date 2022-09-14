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
import internal.GlobalVariable
import org.openqa.selenium.By
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.util.KeywordUtil
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver

/* Define for web element DOM table assign Card*/
WebDriver driverTblAssignCard = DriverFactory.getWebDriver()
WebElement tblAssignCard
List<WebElement> listRows
List<WebElement> listCols

/* Declare keyword util for log message*/
KeywordUtil keyLogger = new KeywordUtil()
if (WebUI.verifyElementVisible(linkAssignCard,FailureHandling.OPTIONAL)) {
	WebUI.click(linkAssignCard)
} else {keyLogger.logInfo("We cannot find the link")}
if (WebUI.verifyElementVisible(popUpConfirmationBlock,FailureHandling.OPTIONAL)) {
	wrdConfirm = WebUI.getText(txtBlockConf)
	if (wrdConfirm.equalsIgnoreCase("Konfirmasi")) {
		keyLogger.markPassed("We are in confirmation process")
		WebUI.click(btnCancelBtn)
		WebUI.verifyElementVisible(txtHeaderAssignCard)
		} else {keyLogger.logInfo("We are not in confirmation process")}
} else {
	wrdHeader = WebUI.getText(txtHeaderAssignCard)
	if (wrdHeader.equalsIgnoreCase("Assign Card")) {
		keyLogger.logInfo("We are in Assign Card Bucket List")
	} else {keyLogger.logInfo("We are not in Assign Card Bucket List")}
}

boolean setCondition = false
loopCondition:
while (setCondition == false) {
	tblAssignCard = driverTblAssignCard.findElement(By.xpath('//table/tbody'))
	listRows = tblAssignCard.findElements(By.tagName('tr'))
	for (int i = 0;i < listRows.size(); i++) {
		println('No. of rows: ' + listRows.size() + ' and check list rows: ' +i)
		if (i.equals(3)) {
			keyLogger.logInfo("We end of rows = "+i+" end of process")
			break loopCondition
		} else {
			keyLogger.logInfo("We process the assign card")
			if (WebUI.verifyOptionsPresent(fltrReqCardType, listFltrReqCardType,FailureHandling.OPTIONAL)) {
				WebUI.selectOptionByLabel(fltrReqCardType, "Kartu Baru", false)
				if (WebUI.verifyOptionsPresent(fltrCustOrigin, listFltrCustOrigin)) {
					WebUI.selectOptionByLabel(fltrCustOrigin, "Semua", false)
				} else {keyLogger.markError("We Not found the element")}
			} else {keyLogger.markError("We Not found the element")}
			listCols = listRows.get(i).findElements(By.tagName("td"))
			listCols.get(1).findElement(By.tagName("a")).click()
			TestObject wrdngDetilNasabah = new TestObject().addProperty('text',ConditionType.CONTAINS,"Data Nasabah")
			if (WebUI.verifyElementPresent(wrdngDetilNasabah, 5)) {
				keyLogger.logInfo("We are in Detail Assign Card")
				if (WebUI.verifyElementClickable(btnKirim,FailureHandling.OPTIONAL)) {
					WebUI.click(btnKirim)
					successAssignCardProcess = WebUI.getText(txtSuccessAssignCard)
					if (successAssignCardProcess.equalsIgnoreCase("Assign Card telah berhasil")) {
						WebUI.click(btnBackAssignCardBucketList)
						tblAssignCard = driverTblAssignCard.findElement(By.xpath('//table/tbody'))
						listRows = tblAssignCard.findElements(By.tagName('tr'))
					} else {keyLogger.markError("We Not found the element")}
				} else {
					keyLogger.logInfo("button cannot click")
					WebUI.click(btnBackAssignCard)
					tblAssignCard = driverTblAssignCard.findElement(By.xpath('//table/tbody'))
					listRows = tblAssignCard.findElements(By.tagName('tr'))
					}
			} else {keyLogger.markError("We Not found the element")}
		}
	}
}
