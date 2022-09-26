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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.util.KeywordUtil
import org.openqa.selenium.support.ui.Select
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.By

/*We Declare Keyword Util*/
KeywordUtil keylogger = new KeywordUtil()
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
 * 	1. Already Login to CRMF Web
	2. Already open one detail customer with type 'Nasabah Senyumku' on CSR Management
 * 
 * And have steps:
 * 	1. Click section Alamat pengiriman kartu
	2. Edit field Tempat Pengiriman kartu
	3. Click button 'Simpan'
	
	And we have the expected result is :
	Display data on changes log with detail:
		Tanggal --> date with time when the changes was created
		User/Agent --> agent name
		Field --> Tempat pengiriman kartu
		Data lama --> old place
		Data baru --> new place
 * */

/* We want choose request ID with condition is Nasabah Senyumku*/
if (WebUI.verifyElementVisible(drpCustType,FailureHandling.OPTIONAL)) {
	WebUI.verifyOptionsPresent(drpCustType, listDrpCustType)
	WebUI.selectOptionByLabel(drpCustType, "Nasabah Senyumku", false)
	if (WebUI.verifyElementVisible(drpCardStatus,FailureHandling.OPTIONAL)) {
		WebUI.verifyOptionsPresent(drpCardStatus, listDrpCardStatus)
		WebUI.selectOptionByLabel(drpCardStatus, "Sudah Aktivasi", false)
	} else {keylogger.logInfo("Element Not Found")}
		WebUI.navigateToUrl(requestIdAddressDelivery)
		if (WebUI.verifyElementClickable(btnDataDeliveryCard,FailureHandling.OPTIONAL)) {
			WebUI.click(btnDataDeliveryCard)
			int optionListLength = 5
			Random rand = new Random()
			String index = rand.nextInt(optionListLength + 3)
			if (WebUI.verifyElementClickable(btnEditDeliveryAddress,FailureHandling.OPTIONAL)) {
				Select selectOld = new Select(DriverFactory.getWebDriver().findElement(By.xpath("//select[@id='DrpAddressType']")))
				oldData = selectOld.getFirstSelectedOption().getText()
				println(oldData)
				WebUI.click(btnEditDeliveryAddress)
				WebUI.verifyOptionsPresent(drpAddressType, listDataDrpAddressType)
				WebUI.selectOptionByIndex(drpAddressType, index)
				Select selectNew = new Select(DriverFactory.getWebDriver().findElement(By.xpath("//select[@id='DrpAddressType']")))
				newData = selectNew.getFirstSelectedOption().getText()
				println(newData)
				if (WebUI.verifyElementClickable(btnSimpanData,FailureHandling.OPTIONAL)) {
					WebUI.click(btnSimpanData)
				} else {keylogger.markError('Button is not clickable')}
			} else {keylogger.markError('Button is not clickable')}
		} else {keylogger.logInfo("Element Not Click Able")}
		oldDataAddressType = oldData
		println(oldDataAddressType)
		newDataAddressType = newData
		println(newDataAddressType)
		if (WebUI.verifyElementClickable(btnDataChangeLog,FailureHandling.OPTIONAL)) {
			WebUI.click(btnDataChangeLog)
			
			def currentDate = new Date().format('dd/MM/yyyy')
			println(currentDate)
			dateInChangeLog = WebUI.getText(txtDateFirstRow)
			println(dateInChangeLog)
			if (dateInChangeLog.contains(currentDate)) {
				keylogger.markPassed('Tanggal --> date with time when the changes was created')
			}
			
			agentInChangeLog = WebUI.getText(txtFirstUser)
			WebUI.verifyMatch(agentInChangeLog, 'fajar.ardhi@amarbank.co.id', false)
			keylogger.markPassed('User/Agent --> agent name')
			
			sourceInChageLog = WebUI.getText(txtFirstSource)
			WebUI.verifyMatch(sourceInChageLog, 'CSR Management', false)
			keylogger.markPassed('source --> CSR Management')
			
			fieldInChangeLog = WebUI.getText(txtFirstField)
			WebUI.verifyMatch(fieldInChangeLog, 'Tempat pengiriman kartu', false)
			keylogger.markPassed('Field --> Tempat pengiriman kartu')
			
			oldDataInChangeLog = WebUI.getText(txtOldData)
			WebUI.verifyMatch(oldDataInChangeLog, oldDataAddressType, false)
			keylogger.markPassed('Data lama --> old place')
			
			newDataInChangeLog = WebUI.getText(txtNewData)
			WebUI.verifyMatch(newDataInChangeLog, newDataAddressType, false)
			keylogger.markPassed('Data baru --> new place')
		} else {keylogger.logInfo("Element Not Click Able")}
		WebUI.click(btnBack)
} else {keylogger.logInfo("Element Not Found")}