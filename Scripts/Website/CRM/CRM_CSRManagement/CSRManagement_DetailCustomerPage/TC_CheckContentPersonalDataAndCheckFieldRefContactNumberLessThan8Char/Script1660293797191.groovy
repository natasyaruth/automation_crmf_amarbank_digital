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
import com.github.javafaker.Faker

/* We want setup faker for name */
Faker faker = new Faker()
String fullName = faker.name().fullName()
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
		if (WebUI.waitForElementVisible(headerCSRManagementElement, 5, FailureHandling.OPTIONAL)) {
			WebUI.verifyElementText(headerCSRManagementElement, headerCSRManagementText)
		} else (txtCsrManagement == false) { keyLogger.loginfo("We not find the element")}
	} else {
		keyLogger.markFailed("We don't find alert confirmation")
	}
	WebUI.waitForElementVisible(headerCSRManagementElement, 5)
	WebUI.verifyElementText(headerCSRManagementElement, headerCSRManagementText)
}else {
	WebUI.verifyElementText(headerCSRManagementElement, headerCSRManagementText)
}
/* We want to check status is customer type is "Nasabah Senyumku" & "Tidak Melanjutkan"*/
for (int i=0;i<customerType.size();i++) {
boolean filterChooseCard = WebUI.verifyElementVisible(drpDwnCardStatus)
if (filterChooseCard == true) {
	WebUI.selectOptionByLabel(drpDwnCardStatus, "Semua", false)
	if (WebUI.verifyElementVisible(drpDwnCustType, FailureHandling.OPTIONAL)) {
		WebUI.selectOptionByLabel(drpDwnCustType, customerType.get(i), false)
	} else {
		keyLogger.markFailed("We not find the drop down by cust type")
	}
	WebUI.navigateToUrl(GlobalVariable.requestStatusFinishCondition.get(i))
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
TestObject typeCustomerText = new TestObject().addProperty('text', ConditionType.CONTAINS , customerType.get(i))
WebUI.verifyElementPresent(typeCustomerText, 5)
TestObject statusRequestText = new TestObject().addProperty('text', ConditionType.CONTAINS , listStatusText.get(i))
boolean StatusRequestText = WebUI.verifyElementPresent(statusRequestText, 5)
if (StatusRequestText == true) {
	TestObject reasonRejectionText = new TestObject().addProperty('text',ConditionType.CONTAINS,'Alasan Penolakan')
	if (WebUI.verifyElementPresent(reasonRejectionText, 5,FailureHandling.OPTIONAL)) {
		keyLogger.logInfo(" We are in rejection status")
		WebUI.takeScreenshot()
	} else {
		keyLogger.logInfo(" We are in success status")
		WebUI.takeScreenshot()
	}
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
		keyLogger.logInfo("We don't find element no handphone")
	}
	if (WebUI.waitForElementVisible(elementFotoKtp, 5)) {
		boolean fotoKtp = WebUI.verifyElementText(elementFotoKtp, "Foto eKTP dan Foto Diri")
		if (fotoKtp == true) {
			WebUI.click(elementFotoKtp)
			if (WebUI.waitForElementVisible(FotoKtpCustomer, 5 ,FailureHandling.OPTIONAL)) {
				keyLogger.logInfo("There is KTP Customer data")
			} else {
				keyLogger.logInfo("There don't have KTP Customer data")
			}
		}
		WebUI.takeScreenshot()
	} else {
		keyLogger.logInfo("We don't find element Foto eKTP dan Foto Diri")
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
		keyLogger.logInfo("We don't find element Data KTP")
	}
	if (WebUI.waitForElementVisible(elementAddressSentCard, 5)) {
		boolean addressSentCard = WebUI.verifyElementText(elementAddressSentCard, "Alamat Pengiriman Kartu")
		if (addressSentCard == true) {
			WebUI.click(elementAddressSentCard)
			WebUI.waitForPageLoad(3)
			if (WebUI.waitForElementClickable(btnEditAddressDelivery, 5, FailureHandling.OPTIONAL)) {
				WebUI.click(btnEditAddressDelivery)
				boolean indexPresent =WebUI.verifyOptionsPresent(drpAddressDelivery, ["Apartemen","Rumah","Kantor","Kos"])
				if (indexPresent == true) {
					WebUI.waitForElementVisible(drpAddressDelivery, 5)
				} else (indexPresent == false) { keyLogger.logInfo("We don't find the element Address Delivery") }
				WebUI.waitForElementVisible(btnSave, 5)
				WebUI.click(btnSave)
			} else {
				WebUI.takeScreenshot()
				keyLogger.logInfo("There is element is disable for click ")
			}
			keyLogger.logInfo("There is full address sent card")
		}
	} else {
		keyLogger.logInfo("We don't find element Alamat Pengiriman Kartu")
	}
/*We want to check and input field in personal Data
 * 1. We want to check element personal data visible
 * 2. We want to check button edit is visible
 * 3. We want to check and choose Education
 * 4. We want to check and choose religion
 * 5. We want to empty reference name
 * 6. We want to check mother name
 * 7. We want to input less than 8 character reference phone number
 * 8. We want to input tax
 * 9. We want to Check button save*/	
	if (WebUI.waitForElementVisible(elementDataDiri, 5)) {
		boolean dataDiri = WebUI.verifyElementText(elementDataDiri, "Data Diri")
		if (dataDiri == true) {
			WebUI.click(elementDataDiri)
			int optionListLength = 3
			Random rand = new Random()
			String index = rand.nextInt(optionListLength + 1)			
			if (WebUI.waitForElementVisible(DataCustomer, 5, FailureHandling.OPTIONAL)) {
				if (WebUI.verifyElementClickable(btnEditDatCustomer,FailureHandling.OPTIONAL)) {
					WebUI.click(btnEditDatCustomer)
					if (WebUI.verifyElementVisible(drpDownEducation,FailureHandling.OPTIONAL)) {
						WebUI.selectOptionByIndex(drpDownEducation, index)
					} else {keyLogger.logInfo("We Not find the education Data")}
					if (WebUI.verifyElementVisible(drpDownReligion, FailureHandling.OPTIONAL)) {
						WebUI.selectOptionByIndex(drpDownReligion, index)
					} else {keyLogger.logInfo("We Not find the religion Data")}
					if (WebUI.verifyElementVisible(txtRefNumber,FailureHandling.OPTIONAL)) {
						WebUI.setText(txtRefNumber, fullName)
					} else {keyLogger.logInfo("We Not update reference name")}
					if (WebUI.verifyElementVisible(txtMotherName, FailureHandling.OPTIONAL)) {
						WebUI.verifyElementPresent(txtMotherName, 5)
						WebUI.verifyElementNotClickable(txtMotherName)
						WebUI.verifyElementAttributeValue(txtMotherName, "name", "mothername", 5)
					} else {keyLogger.logInfo("We Not Data for Mother Name")}
					if (WebUI.verifyElementVisible(txtRefPhoneNumber,FailureHandling.OPTIONAL)) {
						WebUI.setText(txtRefPhoneNumber, "+681111")
					} else {keyLogger.logInfo("We Not update reference phone number")}
					if (WebUI.verifyElementVisible(txtNpwp,FailureHandling.OPTIONAL)) {
						WebUI.setText(txtNpwp, RandomStringUtils.randomNumeric(15))
					} else {keyLogger.logInfo("We Not update reference name")}
					if (WebUI.verifyElementVisible(btnSavePersonalData,FailureHandling.OPTIONAL)) {
					  WebUI.takeScreenshot()
					  WebUI.click(btnSavePersonalData)
					  if (WebUI.verifyElementVisible(alertReferencePhoneNumberLessThan8Char,FailureHandling.OPTIONAL)) {
						  WebUI.verifyElementText(alertReferencePhoneNumberLessThan8Char, "Pastikan panjang karakter antara 8 dan 14")
						  WebUI.takeScreenshot()
					  } else {keyLogger.markFailed("We not find alert")}
					} else {keyLogger.logInfo("Button save not found")}
				} else {keyLogger.logInfo("We not find button edit personal data")}
			} else {keyLogger.logInfo("We cannot update the data")}
		} else {keyLogger.markFailed("We not found element data diri")}
	} else {
		keyLogger.logInfo("We don't find element Data Diri")
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
		keyLogger.logInfo("We don't find element Data Pekerjaan")
	}
	if (WebUI.waitForElementVisible(elementDataKyc, 5)) {
		boolean dataKyc = WebUI.verifyElementText(elementDataKyc, "KYC")
		if (dataKyc == true) {
			WebUI.click(elementDataKyc)
			if (WebUI.verifyElementVisible(dataKycCustomer,FailureHandling.OPTIONAL)) {
				keyLogger.logInfo("There is have video KYC Customer data")
			} else {
				keyLogger.logInfo("There don't have KYC Customer data")
			}
		}
		WebUI.takeScreenshot()
	} else {
		keyLogger.logInfo("We don't find element KYC")
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
		keyLogger.logInfo("We don't find element Data ATM Card Customer")
	}
	WebUI.waitForElementVisible(btnBackToBucketList, 5)
	WebUI.click(btnBackToBucketList) 
	if (WebUI.waitForElementVisible(headerCSRManagementElement, 5 ,FailureHandling.OPTIONAL)) {
		WebUI.verifyElementText(headerCSRManagementElement, headerCSRManagementText)
	} else { keyLogger.loginfo("We not find the element")}
	WebUI.refresh()
	WebUI.waitForPageLoad(3)
}
}
