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
/* We want handling block condition*/
if (WebUI.verifyElementVisible(menuCsrManagement,FailureHandling.OPTIONAL)) {
	WebUI.click(menuCsrManagement)
	if (WebUI.verifyElementVisible(notifBlockCsr,FailureHandling.OPTIONAL)) {
		WebUI.click(btnCancelBlock)
		WebUI.waitForPageLoad(5)
		WebUI.delay(3)
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
	2. Edit all field
	3. Click button 'Simpan'
 * 
	And we have the expected result is :
		Display all field data on changes log with detail:
		Tanggal --> date with time when the changes was created
		User/Agent --> agent name
		Field --> Tempat Pengiriman Kartu/Alamat Lengkap/RT/RW/Provinsi/Kabupaten/Kecamatan/Kelurahan
		Data lama --> old all field
		Data baru --> new all field
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
				TestObject csrDetaiPage = new TestObject().addProperty('text',ConditionType.CONTAINS,'Customer Detail')
				if (WebUI.verifyElementPresent(csrDetaiPage, 5,FailureHandling.OPTIONAL)) {
					TestObject reqDetailStatus = new TestObject().addProperty('text',ConditionType.CONTAINS,'Selesai')
					if (WebUI.verifyElementPresent(reqDetailStatus, 5,FailureHandling.OPTIONAL)) {
						WebUI.click(linkDataDeliveryCard)
						int optionListLength = 2
						Random rand = new Random()
						String index = rand.nextInt(optionListLength + 1)
						if (WebUI.verifyElementClickable(btnEditDeliveryAddress,FailureHandling.OPTIONAL)) {
							WebUI.click(btnEditDeliveryAddress)
							WebUI.waitForPageLoad(5)
							WebUI.delay(3)
							/* We want to check address type*/
							boolean loopAddressTypeCondition = false
							loopAddressType:
							while (loopAddressTypeCondition == false) {
								if (index != 0) {
									if (WebUI.verifyOptionsPresent(drpDwnAddressType, listAddressType,FailureHandling.OPTIONAL)) {
										Select selectOldAddressType = new Select(DriverFactory.getWebDriver().findElement(By.xpath("//select[@id='DrpAddressType']")))
										oldDataAddressType = selectOldAddressType.getFirstSelectedOption().getText()
										println(oldDataAddressType)
										WebUI.selectOptionByIndex(drpDwnAddressType, index)
										Select selectNewAddressType = new Select(DriverFactory.getWebDriver().findElement(By.xpath("//select[@id='DrpAddressType']")))
										newDataAddressType = selectNewAddressType.getFirstSelectedOption().getText()
										println(newDataAddressType)
										break loopAddressType
									} else {keylogger.markError('Element not present')}
								} else {keylogger.logInfo('try again to check')}
							}
							/* We want to check input field address*/
							if (WebUI.verifyElementClickable(fieldInputAddress,FailureHandling.OPTIONAL)) {
								WebUI.setText(fieldInputAddress, RandomStringUtils.randomAlphanumeric(150))
								WebUI.waitForPageLoad(5)
								WebUI.delay(3)
							} else {keylogger.markError('Element not click able')}
							/* We want to check neigbourhood*/	
							if (WebUI.verifyElementClickable(fieldNeighbourhood,FailureHandling.OPTIONAL)) {
								WebUI.setText(fieldNeighbourhood, RandomStringUtils.randomNumeric(3))
								WebUI.waitForPageLoad(5)
								WebUI.delay(3)
							} else {keylogger.markError('Element not click able')}	
							/* We want to check hamlet*/
							if (WebUI.verifyElementClickable(fieldHamlet,FailureHandling.OPTIONAL)) {
								WebUI.setText(fieldHamlet, RandomStringUtils.randomNumeric(3))
								WebUI.waitForPageLoad(5)
								WebUI.delay(3)
							} else {keylogger.markError('Element not click able')}
							boolean loopChoosenDeliveryAddress = false
							loopChoosenAddress:
							while (loopChoosenDeliveryAddress == false) {
								if (index != 0) {
									if (WebUI.verifyElementVisible(postalCode,FailureHandling.OPTIONAL)) {
										oldPostalCode = WebUI.getAttribute(postalCode, 'value')
										println(oldPostalCode)
										/* We want to check province*/
										if (WebUI.verifyElementClickable(drpDwnProvince,FailureHandling.OPTIONAL)) {
											WebUI.selectOptionByIndex(drpDwnProvince, index)
											WebUI.waitForPageLoad(5)
											WebUI.delay(3)
										} else {keylogger.markError('Element not click able')}
										/* We want to check district*/
										if (WebUI.verifyElementClickable(drpDwnDistrict,FailureHandling.OPTIONAL)) {
											WebUI.selectOptionByIndex(drpDwnDistrict, index)
											WebUI.waitForPageLoad(5)
											WebUI.delay(3)
										} else {keylogger.markError('Element not click able')}
										/* We want to check sub-district*/
										if (WebUI.verifyElementClickable(drpDwnSubDistrict,FailureHandling.OPTIONAL)) {
											WebUI.selectOptionByIndex(drpDwnSubDistrict, index)
											WebUI.waitForPageLoad(5)
											WebUI.delay(3)
										} else {keylogger.markError('Element not click able')}
										/* We want to check village*/
										if (WebUI.verifyElementClickable(drpDwnVillage,FailureHandling.OPTIONAL)) {
											WebUI.selectOptionByIndex(drpDwnVillage, index)
											WebUI.waitForPageLoad(5)
											WebUI.delay(3)
										} else {keylogger.markError('Element not click able')}
										/* We want to check Postal-Code*/
										newPostalCode = WebUI.getAttribute(postalCode, 'value')
										println(newPostalCode)
										break loopChoosenAddress
									} else {keylogger.markError('Element not click able')}
								} else {keylogger.logInfo('try again to check')}
							}
							oldPostalCode = oldPostalCode // purposed after edit all we check the old postal code
							newPostalCode = newPostalCode // purposed after edit all we check the new postal code
							if (WebUI.verifyElementClickable(btnSimpanUpdateDeliveryAddress,FailureHandling.OPTIONAL)) {
								WebUI.click(btnSimpanUpdateDeliveryAddress)
								if (WebUI.verifyElementClickable(btnDataChangeLog,FailureHandling.OPTIONAL)) {
									WebUI.click(btnDataChangeLog)
									boolean rowZero = true
									if (rowZero == true) {
										WebDriver oldDriverZero = DriverFactory.getWebDriver()
										WebElement oldTblCsrZero = oldDriverZero.findElement(By.xpath('//*[@id="changelog"]//tbody'))
										List<WebElement> oldRowCsrZero = oldTblCsrZero.findElements(By.tagName('tr'))
										List<WebElement> oldColsCsrZero = oldRowCsrZero.get(0).findElements(By.tagName('td'))
										/*We want verify text from current date and date first row*/
										def currentDate = new Date().format('dd/MM/yyyy')
										println(currentDate)
										dateInChangeLog = oldColsCsrZero.get(0).getText()
										println(dateInChangeLog)
										if (dateInChangeLog.contains(currentDate)) {
											keylogger.markPassed('Tanggal --> date with time when the changes was created')
										}
										/*We want verify text from change log
										 * when this script created change log is dynamic if I want to choose first row
										 * if we edit all aspect, hopefully next we can sequence the output printing at changelog*/
										agentInChangeLog = oldColsCsrZero.get(1).getText()
										println(agentInChangeLog)
										WebUI.verifyMatch(agentInChangeLog, agentInChangeLog, false)
										keylogger.markPassed('User/Agent --> agent name')
										/*We want verify text from change log and existing source is CSR Management*/
										sourceInChageLog = oldColsCsrZero.get(2).getText()
										println(sourceInChageLog)
										WebUI.verifyMatch(sourceInChageLog, 'CSR Management', false)
										keylogger.markPassed('source --> CSR Management')
										/*We want verify text from change log and existing field current is random if check the first row*/
										fieldInChangeLog = oldColsCsrZero.get(3).getText()
										println(fieldInChangeLog)
										WebUI.verifyMatch(fieldInChangeLog, fieldInChangeLog, false)
										keylogger.markPassed('Field --> Kode Pos')
										/*We want verify text from change log and verify text from old data*/
										oldDataInChangeLog = oldColsCsrZero.get(4).getText()
										println(oldDataInChangeLog)
										WebUI.verifyMatch(oldDataInChangeLog, oldDataInChangeLog, false)
										keylogger.markPassed('Data lama --> old place')
										/*We want verify text from change log and verify text from new data*/
										newDataInChangeLog = oldColsCsrZero.get(5).getText()
										println(newDataInChangeLog)
										WebUI.verifyMatch(newDataInChangeLog, newDataInChangeLog, false)
										keylogger.markPassed('Data baru --> new place')
										WebUI.takeScreenshot()
										break loopPage
									} else {keylogger.logInfo('Error')}
								} else {keylogger.logInfo("Element Not Click Able")}
							} else {keylogger.markError('Element simpan not click able')}
						} else {keylogger.logInfo("The element contains "+reqDetailStatus+" try again")
							WebUI.click(btnBack)
							WebUI.waitForPageLoad(5)
							WebUI.delay(3)
							tableCsrMgt = driverTblCsrMgt.findElement(By.xpath('//table/tbody'))
							listRows = tableCsrMgt.findElements(By.tagName('tr'))
						}
					} else {keylogger.logInfo("The element contains "+reqDetailStatus+" try again")
						WebUI.click(btnBack)
						WebUI.waitForPageLoad(5)
						WebUI.delay(3)
						tableCsrMgt = driverTblCsrMgt.findElement(By.xpath('//table/tbody'))
						listRows = tableCsrMgt.findElements(By.tagName('tr'))
					}
				} else {keylogger.markError("We are not in customer detail")}
			}
		}
}