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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

/*'Declaration keylog forloggin'*/
KeywordUtil keyLogger = new KeywordUtil()
/*'We want to makesure we can access CSR Management'*/
boolean checkMenuCsr = WebUI.verifyElementVisible(menuCSRManagement, FailureHandling.OPTIONAL)
if (checkMenuCsr == true) {
	WebUI.click(menuCSRManagement)
} else {
	keyLogger.markFailed("Something happen with menu CSR Management")
}
/*'We want to check blocked notification and check for text blocked
 * if alert confirmation pop up enable is true'*/
if (WebUI.waitForElementVisible(blockBylockedUserElement, 5, FailureHandling.OPTIONAL)) {
	boolean checkAlertProcess = WebUI.waitForElementVisible(alertConfirmationPopUpElement, 5)
	if (checkAlertProcess == true) {
		WebUI.verifyElementText(alertConfirmationPopUpElement, alertConfirmationPopUpText)
		WebUI.click(btnCancelPopUpElement)
	} else {
		keyLogger.markFailed("We don't find alert confirmation")
	}
	WebUI.waitForElementVisible(headerCSRManagementElement, 5)
	WebUI.verifyElementText(headerCSRManagementElement, headerCSRManagementText)
}else {
	WebUI.verifyElementText(headerCSRManagementElement, headerCSRManagementText)
}
/*'We want to check element visible filter card status , select "Belum Aktivasi" and
 *  then we want to capture the process'*/
if (WebUI.verifyElementVisible(drpDwnChooseStatusCard ,FailureHandling.OPTIONAL)) {
	/* We want to check all drop down menu Semua, Belum Aktivasi, Sudah Aktivasi, Block Kartu ATM, Permintaan Kartu Baru*/
	WebUI.verifyOptionsPresent(drpDwnChooseStatusCard, ["Semua","Belum Aktivasi","Sudah Aktivasi","Block Kartu ATM","Permintaan Kartu Baru"])
	/*'We want to choose text "Belum Aktivasi"'*/
	WebUI.selectOptionByLabel(drpDwnChooseStatusCard, "Belum Aktivasi", false)
	if (WebUI.verifyElementVisible(firstRowRequestIdElement , FailureHandling.OPTIONAL)) {
		WebUI.takeScreenshot()
		WebUI.click(firstRowRequestIdElement)
		if (WebUI.verifyElementVisible(headerCustDataElement,FailureHandling.OPTIONAL)) {
			WebUI.waitForPageLoad(5)
			/*	'We verify we can access Customer Detail'*/
			TestObject txtAccountNumb = new TestObject().addProperty('text', ConditionType.CONTAINS , headerCustDataText)
			WebUI.verifyElementPresent(txtAccountNumb, 5)
			boolean txtRekening = WebUI.verifyElementVisible(txtAccountNumb)
			if (txtRekening == true) {
				WebUI.waitForElementVisible(reqIdDetailNasabah, 5)
				requestIdText = WebUI.getText(reqIdDetailNasabah)
				WebUI.click(btnDataCardATM)
				WebUI.waitForPageLoad(2)
				/*'We want to check notification "Belum Aktivasi"'*/
				TestObject textNotYetActivation = new TestObject().addProperty('text', ConditionType.CONTAINS , "Belum Aktivasi" )
				if (WebUI.verifyElementPresent(textNotYetActivation, 5)) {
					keyLogger.markPassed("We found it")
					WebUI.takeScreenshot()
				} else {
					keyLogger.markFailed("We Not Found ")
					println(requestIdText)
				}
			} else {
				keyLogger.markFailed("We cannot find the info about ")
			}
			/*'We want to click button back'*/
			WebUI.verifyElementVisible(btnBackBucketList)
			WebUI.click(btnBackBucketList)
			WebUI.waitForElementVisible(headerCSRManagementElement, 5)
			WebUI.verifyElementText(headerCSRManagementElement, headerCSRManagementText)
			WebUI.refresh()
		}
	} else {
		keyLogger.markFailed("We dont find request ID with these condition")
	}
} else {
	keyLogger.markFailed("We dont find the filter")
}
/*'We want to check element visible filter card status , select "Sudah Aktivasi" and
 *  then we want to capture the process'*/
if (WebUI.verifyElementVisible(drpDwnChooseStatusCard ,FailureHandling.OPTIONAL)) {
	/* We want to check all drop down menu Semua, Belum Aktivasi, Sudah Aktivasi, Block Kartu ATM, Permintaan Kartu Baru*/
	WebUI.verifyOptionsPresent(drpDwnChooseStatusCard, ["Semua","Belum Aktivasi","Sudah Aktivasi","Block Kartu ATM","Permintaan Kartu Baru"])
	/*'We want to choose text "Belum Aktivasi"'*/
	WebUI.selectOptionByLabel(drpDwnChooseStatusCard, "Sudah Aktivasi", false)
	if (WebUI.verifyElementVisible(firstRowRequestIdElement , FailureHandling.OPTIONAL)) {
		WebUI.takeScreenshot()
		WebUI.click(firstRowRequestIdElement)
		if (WebUI.verifyElementVisible(headerCustDataElement,FailureHandling.OPTIONAL)) {
			WebUI.waitForPageLoad(5)
			/*	'We verify we can access Customer Detail'*/
			TestObject txtAccountNumb = new TestObject().addProperty('text', ConditionType.CONTAINS , headerCustDataText)
			WebUI.verifyElementPresent(txtAccountNumb, 5)
			boolean txtRekening = WebUI.verifyElementVisible(txtAccountNumb)
			if (txtRekening == true) {
				WebUI.waitForElementVisible(reqIdDetailNasabah, 5)
				requestIdText = WebUI.getText(reqIdDetailNasabah)
				WebUI.click(btnDataCardATM)
				WebUI.waitForPageLoad(2)
				/*'We want to check notification "Sudah Aktivasi"'*/
				TestObject textHasActivation = new TestObject().addProperty('text', ConditionType.CONTAINS , "Sudah Aktivasi" )
				if (WebUI.verifyElementPresent(textHasActivation, 5)) {
					keyLogger.markPassed("We found it")
					WebUI.takeScreenshot()
				} else {
					keyLogger.markFailed("We Not Found ")
					println(requestIdText)
				}
			} else {
				keyLogger.markFailed("We cannot find the info about ")
			}
			/*'We want to click button back'*/
			WebUI.verifyElementVisible(btnBackBucketList)
			WebUI.click(btnBackBucketList)
			WebUI.waitForElementVisible(headerCSRManagementElement, 5)
			WebUI.verifyElementText(headerCSRManagementElement, headerCSRManagementText)
			WebUI.refresh()
		}
	} else {
		keyLogger.markFailed("We dont find request ID with these condition")
	}
} else {
	keyLogger.markFailed("We dont find the filter")
}
/*'We want to check element visible filter card status , select "Block Kartu ATM" and
 *  then we want to capture the process'*/
if (WebUI.verifyElementVisible(drpDwnChooseStatusCard ,FailureHandling.OPTIONAL)) {
	/* We want to check all drop down menu Semua, Belum Aktivasi, Sudah Aktivasi, Block Kartu ATM, Permintaan Kartu Baru*/
	WebUI.verifyOptionsPresent(drpDwnChooseStatusCard, ["Semua","Belum Aktivasi","Sudah Aktivasi","Block Kartu ATM","Permintaan Kartu Baru"])
	/*'We want to choose text "Belum Aktivasi"'*/
	WebUI.selectOptionByLabel(drpDwnChooseStatusCard, "Block Kartu ATM", false)
	if (WebUI.verifyElementVisible(firstRowRequestIdElement , FailureHandling.OPTIONAL)) {
		WebUI.takeScreenshot()
		WebUI.click(firstRowRequestIdElement)
		if (WebUI.verifyElementVisible(headerCustDataElement,FailureHandling.OPTIONAL)) {
			WebUI.waitForPageLoad(5)
			/*	'We verify we can access Customer Detail'*/
			TestObject txtAccountNumb = new TestObject().addProperty('text', ConditionType.CONTAINS , headerCustDataText)
			WebUI.verifyElementPresent(txtAccountNumb, 5)
			boolean txtRekening = WebUI.verifyElementVisible(txtAccountNumb)
			if (txtRekening == true) {
				WebUI.waitForElementVisible(reqIdDetailNasabah, 5)
				requestIdText = WebUI.getText(reqIdDetailNasabah)
				WebUI.click(btnDataCardATM)
				WebUI.waitForPageLoad(2)
				/*'We want to check notification "Sudah Aktivasi"'*/
				TestObject textBlockAtmCard = new TestObject().addProperty('text', ConditionType.CONTAINS , "Block Kartu ATM")
				if (WebUI.verifyElementPresent(textBlockAtmCard, 5)) {
					TestObject textHasActivation = new TestObject().addProperty('text', ConditionType.CONTAINS , "Sudah Aktivasi")
					if (WebUI.verifyElementPresent(textHasActivation, 5)) {
						keyLogger.markPassed("We found it")
						WebUI.takeScreenshot()
					}
				} else {
					keyLogger.markFailed("We Not Found ")
					println(requestIdText)
				}
			} else {
				keyLogger.markFailed("We cannot find the info about ")
			}
			/*'We want to click button back'*/
			WebUI.verifyElementVisible(btnBackBucketList)
			WebUI.click(btnBackBucketList)
			WebUI.waitForElementVisible(headerCSRManagementElement, 5)
			WebUI.verifyElementText(headerCSRManagementElement, headerCSRManagementText)
			WebUI.refresh()
		}
	} else {
		keyLogger.markFailed("We dont find request ID with these condition")
	}
} else {
	keyLogger.markFailed("We dont find the filter")
}
/*'We want to check element visible filter card status , select "Permintaan Kartu Baru" and
 *  then we want to capture the process'*/
if (WebUI.verifyElementVisible(drpDwnChooseStatusCard ,FailureHandling.OPTIONAL)) {
	/* We want to check all drop down menu Semua, Belum Aktivasi, Sudah Aktivasi, Block Kartu ATM, Permintaan Kartu Baru*/
	WebUI.verifyOptionsPresent(drpDwnChooseStatusCard, ["Semua","Belum Aktivasi","Sudah Aktivasi","Block Kartu ATM","Permintaan Kartu Baru"])
	/*'We want to choose text "Belum Aktivasi"'*/
	WebUI.selectOptionByLabel(drpDwnChooseStatusCard, "Permintaan Kartu Baru", false)
	if (WebUI.verifyElementVisible(firstRowRequestIdElement , FailureHandling.OPTIONAL)) {
		WebUI.takeScreenshot()
		WebUI.click(firstRowRequestIdElement)
		if (WebUI.verifyElementVisible(headerCustDataElement,FailureHandling.OPTIONAL)) {
			WebUI.waitForPageLoad(5)
			/*	'We verify we can access Customer Detail'*/
			TestObject txtAccountNumb = new TestObject().addProperty('text', ConditionType.CONTAINS , headerCustDataText)
			WebUI.verifyElementPresent(txtAccountNumb, 5)
			boolean txtRekening = WebUI.verifyElementVisible(txtAccountNumb)
			if (txtRekening == true) {
				WebUI.waitForElementVisible(reqIdDetailNasabah, 5)
				requestIdText = WebUI.getText(reqIdDetailNasabah)
				WebUI.click(btnDataCardATM)
				WebUI.waitForPageLoad(2)
				/*'We want to check notification "Sudah Aktivasi"'*/
				TestObject textRequestNewCard = new TestObject().addProperty('text', ConditionType.CONTAINS , "Permintaan Kartu Baru")
				if (WebUI.verifyElementPresent(textRequestNewCard, 5)) {
					TestObject textNotYetActivation = new TestObject().addProperty('text', ConditionType.CONTAINS , "Belum Aktivasi")
					if (WebUI.verifyElementPresent(textNotYetActivation, 5)) {
						keyLogger.markPassed("We found it")
						WebUI.takeScreenshot()
					}
				} else {
					keyLogger.markFailed("We Not Found ")
					println(requestIdText)
				}
			} else {
				keyLogger.markFailed("We cannot find the info about ")
			}
			/*'We want to click button back'*/
			WebUI.verifyElementVisible(btnBackBucketList)
			WebUI.click(btnBackBucketList)
			WebUI.waitForElementVisible(headerCSRManagementElement, 5)
			WebUI.verifyElementText(headerCSRManagementElement, headerCSRManagementText)
			WebUI.refresh()
		}
	} else {
		keyLogger.markFailed("We dont find request ID with these condition")
	}
} else {
	keyLogger.markFailed("We dont find the filter")
}