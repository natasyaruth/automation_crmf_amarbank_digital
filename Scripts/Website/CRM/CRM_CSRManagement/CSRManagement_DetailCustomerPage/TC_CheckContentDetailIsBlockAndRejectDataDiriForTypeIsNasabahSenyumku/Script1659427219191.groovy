import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.util.concurrent.locks.Condition

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
import com.sun.org.apache.bcel.internal.generic.RETURN

import groovy.transform.ConditionalInterrupt
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys
import org.openqa.selenium.remote.server.handler.RefreshPage
import org.apache.commons.lang.RandomStringUtils

/*Declaration keylog forloggin*/
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
	boolean checkAlertProcess = WebUI.verifyElementVisible(alertConfirmationPopUpElement)
	if (checkAlertProcess == true) {
		WebUI.verifyElementText(alertConfirmationPopUpElement, alertConfirmationPopUpText)
		WebUI.click(btnCancelPopUpElement)
		WebUI.delay(2)
		WebUI.waitForElementVisible(headerCSRManagementElement, 5)
		WebUI.verifyElementText(headerCSRManagementElement, headerCSRManagementText)
	} else {
		keyLogger.markFailed("We don't find alert confirmation")
	}
	WebUI.waitForElementVisible(headerCSRManagementElement, 5)
	WebUI.verifyElementText(headerCSRManagementElement, headerCSRManagementText)
}else {
	WebUI.verifyElementText(headerCSRManagementElement, headerCSRManagementText)
}
/* We want to check status is "Sudah Aktivasi" and customer type is "Nasabah Senyumku"*/
boolean filterChooseCard = WebUI.verifyElementVisible(drpDwnCardStatus)
if (filterChooseCard == true) {
	WebUI.selectOptionByLabel(drpDwnCardStatus, "Sudah Aktivasi", false)
	if (WebUI.verifyElementVisible(drpDwnCustType, FailureHandling.OPTIONAL)) {
		WebUI.selectOptionByLabel(drpDwnCustType, "Nasabah Senyumku", false)
	} else {
		keyLogger.markFailed("We not find the drop down by cust type")
	}
	WebUI.navigateToUrl(postiveConditionData)
} else {
	keyLogger.markFailed("We don't find the drop down Card Status")
}
/* We want to check all field in detail customer page such as:
 * 1. No.Handphone
 * 2. Data KTP
 * 3. Alamat Pengiriman Kartu
 * 4. Data Diri 
 * 5. Data Pekerjaan
 * 6. Foto KTP dan Foto Diri
 * 7. KYC */
TestObject nasabahSenyumkuText = new TestObject().addProperty('text', ConditionType.CONTAINS , 'Nasabah Senyumku')
WebUI.verifyElementPresent(nasabahSenyumkuText, 5)
TestObject blockText = new TestObject().addProperty('text', ConditionType.CONTAINS , 'Diblokir')
boolean BlockText = WebUI.verifyElementPresent(blockText, 5)
if (BlockText == true) {
	TestObject reasonRejectionText = new TestObject().addProperty('text',ConditionType.CONTAINS,'Alasan Penolakan')
	WebUI.verifyElementPresent(reasonRejectionText, 5)
	WebUI.takeScreenshot()
	if (WebUI.waitForElementVisible(elementNoHandphone, 5)) {
		boolean phoneNumber = WebUI.verifyElementText(elementNoHandphone, "No. Handphone")
		if (phoneNumber == true) {
			WebUI.click(elementNoHandphone)
			WebUI.waitForElementVisible(NoHandphone, 5)
			noHandphone = WebUI.getText(NoHandphone)
			keyLogger.logInfo("There is phone number customer: " +noHandphone)
		}
		WebUI.takeScreenshot()
	} else {
		keyLogger.markFailed("We don't find element no handphone")
	}
	if (WebUI.waitForElementVisible(elementFotoKtp, 5)) {
		boolean fotoKtp = WebUI.verifyElementText(elementFotoKtp, "Foto eKTP dan Foto Diri")
		if (fotoKtp == true) {
			WebUI.click(elementFotoKtp)
			WebUI.waitForElementVisible(FotoKtpCustomer, 5)
			fotoKtpCustomer = WebUI.getText(FotoKtpCustomer)
			keyLogger.logInfo("There is KTP Customer data : " +fotoKtpCustomer)
		}
		WebUI.takeScreenshot()
	} else {
		keyLogger.markFailed("We don't find element Foto eKTP dan Foto Diri")
	}
	if (WebUI.waitForElementVisible(elementDataKtp, 5)) {
		boolean dataKtp = WebUI.verifyElementText(elementDataKtp, "Data KTP")
		if (dataKtp == true) {
			WebUI.click(elementDataKtp)
			WebUI.waitForElementVisible(NoKtp, 5)
			noKtp = WebUI.getText(NoKtp)
			keyLogger.logInfo("There is Customer Id Number : " +noKtp)
		}
		WebUI.takeScreenshot()
	} else {
		keyLogger.markFailed("We don't find element Data KTP")
	}
	if (WebUI.waitForElementVisible(elementAddressSentCard, 5)) {
		boolean addressSentCard = WebUI.verifyElementText(elementAddressSentCard, "Alamat Pengiriman Kartu")
		if (addressSentCard == true) {
			WebUI.click(elementAddressSentCard)
			WebUI.waitForElementVisible(FullAddressCard, 5)
			fullAddressCard = WebUI.getText(FullAddressCard)
			keyLogger.logInfo("There is full address sent card: " +fullAddressCard)
		}
		WebUI.takeScreenshot()
	} else {
		keyLogger.markFailed("We don't find element Alamat Pengiriman Kartu")
	}
	if (WebUI.waitForElementVisible(elementDataDiri, 5)) {
		boolean dataDiri = WebUI.verifyElementText(elementDataDiri, "Data Diri")
		if (dataDiri == true) {
			WebUI.click(elementDataDiri)
			WebUI.waitForElementVisible(DataCustomer, 5)
			dataCustomer = WebUI.getText(DataCustomer)
			WebUI.verifyElementNotClickable(btnEditDataDiri)
			WebUI.verifyElementNotClickable(btnSaveDataDiri)
			keyLogger.logInfo("There is Data Customer : " +dataCustomer)
		}
		WebUI.takeScreenshot()
	} else {
		keyLogger.markFailed("We don't find element Data Diri")
	}
	if (WebUI.waitForElementVisible(elementEmploymentData, 5)) {
		boolean employmentData = WebUI.verifyElementText(elementEmploymentData, "Data Pekerjaan")
		if (employmentData == true) {
			WebUI.click(elementEmploymentData)
			WebUI.waitForElementVisible(EmploymentCustomer, 5)
			employmentDataCustomer = WebUI.getText(EmploymentCustomer)
			keyLogger.logInfo("There is employment data : " +employmentDataCustomer)
		}
		WebUI.takeScreenshot()
	} else {
		keyLogger.markFailed("We don't find element Data Pekerjaan")
	}
	if (WebUI.waitForElementVisible(elementDataKyc, 5)) {
		boolean dataKyc = WebUI.verifyElementText(elementDataKyc, "KYC")
		if (dataKyc == true) {
			WebUI.click(elementDataKyc)
			WebUI.verifyElementVisible(dataKycCustomer)
			keyLogger.logInfo("There is KYC Customer data : ")
		}
		WebUI.takeScreenshot()
	} else {
		keyLogger.markFailed("We don't find element KYC")
	}
	if (WebUI.waitForElementVisible(elementDataAtmCard, 5)) {
		boolean dataAtmCard = WebUI.verifyElementText(elementDataAtmCard, "Data Kartu ATM")
		if (dataAtmCard == true) {
			WebUI.click(elementDataAtmCard)
			dataAtmCardCustomer = WebUI.getText(DataAtmCardCustomer)
			keyLogger.logInfo("There is ATM Card data : " +dataAtmCardCustomer)
		}
		WebUI.takeScreenshot()
	} else {
		keyLogger.markFailed("We don't find element Data ATM Card Customer")
	}
}

