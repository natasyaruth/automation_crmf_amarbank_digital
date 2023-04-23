import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.github.javafaker.Faker
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

import org.apache.commons.lang.RandomStringUtils
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import com.tunaiku.keyword.RandomFakerData as fakerData
import com.tunaiku.keyword.Hash256

'Init logging in katalon studio'
KeywordUtil keylogger = new KeywordUtil()

'Init Random'
Random rand = new Random()
String fakeFullAddress = fakerData.set_faker_full_address()

/* Scenario Testing
 * Precondition:
 * 	-User has access to KYC video request active calls
	-Active incoming call for "Reaktivasi Nasabah Senyumku"

	Steps:
	- Click incoming call "Reaktivasi Nasabah Senyumku" request id
	
	Expected Result:
	-System display detail customer "Reaktivasi Nasabah Senyumku" with active KYC video call page
	-System display new data in "Nomor HP Baru" section
	-System display updated data in "Alamat Pengiriman Kartu" section
 * */

'Access to Customer Detail'
if (WebUI.waitForElementPresent(linkMenuCsrManagement, 5)) {
	WebUI.click(linkMenuCsrManagement)
	if (WebUI.waitForElementPresent(txtAlertNotification, 5)) {
		WebUI.click(abortNotification)
	} else {keylogger.logInfo("We are not have active request")}
} else {keylogger.markError("Element not found")}

WebDriver driverCsr = DriverFactory.getWebDriver()
WebElement tblCsr
List<WebElement> rowsCsr
List<WebElement> colsCsr
flagLoop = false
csrManagement:
while (flagLoop == false) {
	WebUI.delay(3)
	tblCsr = driverCsr.findElement(By.xpath('//table/tbody'))
	rowsCsr = tblCsr.findElements(By.tagName('tr'))
	for (i = 0; i < rowsCsr.size(); i ++) {
		TestObject csrManagementHeader = new TestObject().addProperty('text',ConditionType.CONTAINS,'CSR Management')
		if (WebUI.waitForElementPresent(csrManagementHeader, 5)) {
			if (WebUI.waitForElementPresent(drpDwnCustType, 5)) {
				WebUI.verifyOptionsPresent(drpDwnCustType, listDrpDwnCustType)
				WebUI.selectOptionByLabel(drpDwnCustType, "Nasabah Senyumku", false)
			} else {keylogger.markError("Element not present")}
			if (WebUI.waitForElementPresent(drpDwnCardStatus, 5)) {
				WebUI.verifyOptionsPresent(drpDwnCardStatus, listDrpDwnCardStatus)
				WebUI.selectOptionByLabel(drpDwnCardStatus, "Sudah Aktivasi", false)
			} else {keylogger.markError("Element not present")}
	} else {keylogger.markError("We are not in CSR Management")}
	WebUI.waitForPageLoad(10)
		tblCsr = driverCsr.findElement(By.xpath('//table/tbody'))
		rowsCsr = tblCsr.findElements(By.tagName('tr'))
		colsCsr = rowsCsr.get(i).findElements(By.tagName('td'))
		println('No. of rows: ' + rowsCsr.size()+ ' row number '+i)
		WebUI.delay(5)
		if (colsCsr.get(5).getText().equalsIgnoreCase("Nasabah Senyumku")) {
			colsCsr.get(6).findElement(By.xpath('button')).click()
			} else {keylogger.markError("We not found the element")}
			TestObject csrManagementDetail = new TestObject().addProperty('text',ConditionType.CONTAINS,'Customer Detail')
			if (WebUI.waitForElementPresent(csrManagementDetail, 5)) {
				TestObject processStatus = new TestObject().addProperty('text',ConditionType.CONTAINS,'Selesai')
				if (WebUI.waitForElementPresent(processStatus, 5)) {
					WebUI.scrollToPosition(0, 0)
					phoneShown = false
					phoneShownLoop:
					while (phoneShown == false) {
						if (WebUI.waitForElementClickable(dataPhoneNumber, 5)) {
							WebUI.click(dataPhoneNumber)
							phoneNumberUser =  WebUI.getAttribute(phoneNumber, 'value')
							String phoneNumber = phoneNumberUser
							println(phoneNumber)
							GlobalVariable.oldPhoneNumber = phoneNumber
							break phoneShownLoop
						} else {keylogger.logInfo("We not found the data phone number please scroll again")
							WebUI.sendKeys(phoneNumber, Keys.chord(Keys.DOWN))
						}
					}
					idPersonalShown = false
					idPersonalLoop:
					while (idPersonalShown == false) {
						if (WebUI.waitForElementClickable(dataIdPersonal, 5)) {
							WebUI.click(dataIdPersonal)
							accountIdPersonalUser = WebUI.getAttribute(idPersonal, 'value')
							println(accountIdPersonalUser)
							break idPersonalLoop
						} else {keylogger.logInfo('We not found the data id personal please scroll again')
							WebUI.sendKeys(dataIdPersonal, Keys.chord(Keys.DOWN))
						}
					}
					accountNumberShown = false
					accountNumberLoop:
					while (accountNumberShown == false) {
						if (WebUI.waitForElementPresent(dataAccountNumber, 5)) {
							WebUI.click(dataAccountNumber)
							accountNumberUser = WebUI.getAttribute(accountNumber, 'value')
							println(accountNumberUser)
							break accountNumberLoop
						} else {keylogger.logInfo("We not found the data account number")
							WebUI.sendKeys(dataAccountNumber, Keys.chord(Keys.DOWN))
						}
					}
					break csrManagement
				} else {
					keylogger.logInfo("We want to try again")
					WebUI.click(btnBackCsrBucketList)
				}
			} else {keylogger.markError("Element customer detail not present")}
		}	
	}
	
	'This part we use to access the blocking user'
	String currentPage = WebUI.getUrl()
	int currentTab = WebUI.getWindowIndex()
	WebDriver driverBlock = DriverFactory.getWebDriver()
	JavascriptExecutor js = ((driverBlock) as JavascriptExecutor)
	js.executeScript('window.open();')
	WebUI.switchToWindowIndex(currentTab + 1)
	String requestIdProcess = pathSenyumku
	WebUI.navigateToUrl((((('https://' + GlobalVariable.authUsername) + ':') + GlobalVariable.authPassword) + '@') + requestIdProcess.substring(8))
	String dataPhoneNumberText = phoneNumberUser
	String dataAccountId = accountIdPersonalUser
	String dataAccountNumber = accountNumberUser
	WebUI.waitForPageLoad(5)
	
	TestObject blockAccount = new TestObject().addProperty('text',ConditionType.CONTAINS,'Formulir pemblokiran akun')
	if (WebUI.waitForElementVisible(blockAccount, 5)) {
		if (WebUI.waitForElementPresent(txtPhoneNumberSenyumkuPage, 5)) {
			WebUI.setText(txtPhoneNumberSenyumkuPage, dataPhoneNumberText)
		} else {keylogger.markError("Element text field phone number not found")}
		if (WebUI.waitForElementPresent(txtIdPersonalSenyumkuPage, 5)) {
			WebUI.setText(txtIdPersonalSenyumkuPage, dataAccountId)
		} else {keylogger.markError('Element text field KTP not found')}
		if (WebUI.waitForElementPresent(rbAccountNumberSenyumkuPage, 5)) {
			WebUI.click(rbAccountNumberSenyumkuPage)
			if (WebUI.waitForElementPresent(txtAccountNumberSenyumkuPage, 5)) {
				WebUI.setText(txtAccountNumberSenyumkuPage, dataAccountNumber)
			} else {keylogger.markError("We not found the text filed Account Number Senyumku")}
		} else {keylogger.markError('We cannot click the radio button account number senyumku')}
		WebUI.setText(txtReasonBlock, RandomStringUtils.randomAlphabetic(160))
		WebUI.click(btnFormSubmit)
		TestObject notifDecisionBlock = new TestObject().addProperty('text',ConditionType.CONTAINS,'Anda yakin ingin memblokir akun Senyumku?')
		if (WebUI.waitForElementPresent(notifDecisionBlock, 5)) {
			WebUI.click(btnBlockUserSenyumkuPage)
		} else {keylogger.markError("We not found the decision notification")}
	} else {keylogger.markError('We are not in page ')}
	WebUI.switchToWindowIndex(0)
	WebUI.refresh()
	TestObject statusBlock = new TestObject().addProperty('text',ConditionType.CONTAINS,'Diblokir')
	if (WebUI.waitForElementPresent(statusBlock, 5)) {
		keylogger.markPassed('We success change the status request ID')
	} else {keylogger.logInfo('Status not changes')}
	WebUI.switchToWindowIndex(1)
	
	
	'We already to reactivate account'
	if (WebUI.waitForElementPresent(txtLinkReactivation, 5)) {
		WebUI.click(txtLinkReactivation)
		TestObject textHelpCenter = new TestObject().addProperty('text',ConditionType.CONTAINS,'Pusat Bantuan')
		WebUI.verifyElementPresent(textHelpCenter, 5)
	} else {keylogger.markError('We not found the link')}
	if (WebUI.waitForElementPresent(linkFormReactivationAccount, 5)) {
		WebUI.click(linkFormReactivationAccount)
		TestObject pageFormReactivation = new TestObject().addProperty('text',ConditionType.CONTAINS,'Formulir reaktivasi akun')
		if (WebUI.waitForElementPresent(pageFormReactivation, 5)) {
			if (WebUI.waitForElementPresent(txtPhoneNumberSenyumkuPage, 5)) {
			WebUI.setText(txtPhoneNumberSenyumkuPage, dataPhoneNumberText)
			} else {keylogger.markError("Element text field phone number not found")}
			if (WebUI.waitForElementPresent(txtIdPersonalSenyumkuPage, 5)) {
			WebUI.setText(txtIdPersonalSenyumkuPage, dataAccountId)
			} else {keylogger.markError('Element text field KTP not found')}
			if (WebUI.waitForElementPresent(rbAccountNumberSenyumkuPage, 5)) {
			WebUI.click(rbAccountNumberSenyumkuPage)
			if (WebUI.waitForElementPresent(txtAccountNumberSenyumkuPage, 5)) {
				WebUI.setText(txtAccountNumberSenyumkuPage, dataAccountNumber)
			} else {keylogger.markError("We not found the text filed Account Number Senyumku")}
			if (WebUI.waitForElementPresent(btnNextSenyumku, 5)) {
				WebUI.click(btnNextSenyumku)
			} else {keylogger.markError("Element button senyumku not found")}
		} else {keylogger.markError('We cannot click the radio button account number senyumku')}
		}
	} else {keylogger.markError('Element not present')}
	
	'Validation data reactivation'
	TestObject formValidationDataReactivation = new TestObject().addProperty('text',ConditionType.CONTAINS,'Formulir reaktivasi akun')
	if (WebUI.waitForElementPresent(formValidationDataReactivation, 5)) {
		WebUI.click(rbHasNoCardSenyumku)
		if (WebUI.waitForElementVisible(btnChgDeliveryAddress, 5)) {
			WebUI.click(btnChgDeliveryAddress)
			TestObject alreadyToChangeDeliveryAddress = new TestObject().addProperty('text',ConditionType.CONTAINS,'Alamat pengiriman kartu debit')
			WebUI.verifyElementPresent(alreadyToChangeDeliveryAddress, 5)
			WebUI.waitForPageLoad(5)
			loopValidation = false
			validateReactivation:
			while (loopValidation == false) {
				int optionRand = 3
				Random random = new Random()
				int indexElement = random.nextInt(optionRand + 1)
				println(indexElement)
				if (indexElement != 0) {
					if (WebUI.waitForElementVisible(drpAddressReactivation, 5)) {
						WebUI.selectOptionByIndex(drpAddressReactivation, indexElement)
						WebUI.waitForPageLoad(5)
					} else {
						keylogger.markError('We not found the Address Reactivation')
					}
					WebUI.setText(txtFullAddressReactivation, fakeFullAddress)
					WebUI.setText(txtNeighbourReactivation , RandomStringUtils.randomNumeric(3))
					WebUI.setText(txtHamletReactivation, RandomStringUtils.randomNumeric(3))
					WebUI.waitForPageLoad(5)
					if (WebUI.waitForElementVisible(drpProvinceReactivation, 5)) {
						WebUI.selectOptionByIndex(drpProvinceReactivation, indexElement)
						WebUI.waitForPageLoad(5)
						WebUI.delay(3)
					} else {
						keylogger.markError('We not found the province')
					}
					if (WebUI.waitForElementVisible(drpDistrictReactivation, 5)) {
						WebUI.selectOptionByIndex(drpDistrictReactivation,indexElement)
						WebUI.waitForPageLoad(5)
						WebUI.delay(3)
					} else {
						keylogger.markError('We not found the District')
					}
					if (WebUI.waitForElementVisible(drpSubDistrictReactivation, 5)) {
						WebUI.selectOptionByIndex(drpSubDistrictReactivation, indexElement)
						WebUI.waitForPageLoad(5)
						WebUI.delay(3)
					} else {
						keylogger.markError('We not found the Sub-District')
					}
					if (WebUI.waitForElementVisible(drpVillageReactivation, 5)) {
						WebUI.selectOptionByIndex(drpVillageReactivation, indexElement)
						WebUI.waitForPageLoad(5)
						WebUI.delay(3)
					} else {
						keylogger.markError('We not found the Village')
					}
					WebUI.click(btnSaveReactivation)
					WebUI.waitForPageLoad(5)
					TestObject backToValidate = new TestObject().addProperty('text',ConditionType.CONTAINS,'Formulir reaktivasi akun')
					WebUI.verifyElementPresent(backToValidate, 5)
					break validateReactivation
				} else {
					keylogger.logInfo('index element is =' +indexElement)
					keylogger.logInfo('we try again to check another')
				}
			}
		} else {
			keylogger.markError('We not found the element')
		}
		WebUI.click(rbYesChangePhoneNumber)
		TestObject changePhoneNumberReactivation = new TestObject().addProperty('text',ConditionType.CONTAINS,'Nomor handphone baru')
		if (WebUI.waitForElementVisible(changePhoneNumberReactivation, 5)) {
			WebUI.setText(txtNewPhoneNumberReactivation, GlobalVariable.phoneNumberWithAreaCode)
		} else {
			keylogger.markError('Element not find please check again')
		}
		WebUI.click(btnSentFormSenyumku)
		
		'This part i want confirm OTP'
		TestObject otpProcess = new TestObject().addProperty('text',ConditionType.CONTAINS,'Kami telah mengirimkan SMS dengan kode PIN 4 digit')
		if (WebUI.waitForElementVisible(otpProcess, 5)) {
			
			'We call test case for get OTP'
			WebUI.callTestCase(findTestCase('API/CRM/TC_getOTP'), [:], FailureHandling.STOP_ON_FAILURE)
			WebUI.delay(5)
			WebUI.setText(sms1, GlobalVariable.dataOtp1)
			WebUI.setText(sms2, GlobalVariable.dataOtp2)
			WebUI.setText(sms3, GlobalVariable.dataOtp3)
			WebUI.setText(sms4, GlobalVariable.dataOtp4)
			if (WebUI.waitForElementVisible(btnVerification, 5)) {
				WebUI.click(btnVerification)
			} else {
				keylogger.markError('Element not appear')
			}
			
		} else {
			keylogger.markError('We not find the OTP page')
		}
		
		WebUI.switchToWindowIndex(0)
		TestObject getNewReqId = new TestObject().addProperty('text',ConditionType.CONTAINS,'Customer Detail')
		if (WebUI.waitForElementVisible(getNewReqId, 5)) {
			WebUI.refresh()
			WebUI.delay(5)
			WebUI.waitForPageLoad(10)
			reqIdForVideoCall = WebUI.getText(requestIdCsrDetail)
			referenceIdKycVideo = WebUI.getText(refId)
			println(reqIdForVideoCall)
			WebUI.switchToWindowIndex(1)
		} else {keylogger.markError("Element not found please check again")}
		WebUI.delay(5)
	} else {keylogger.markError("Text or page validation account not shown")}
	reqIdVidCall = reqIdForVideoCall
	refIdKycVideo = referenceIdKycVideo
	String hashRefId = Hash256.hash(refIdKycVideo)
	println(hashRefId)
	validateVideoCall = false
	validateVideoCallLoop:
	while (validateVideoCall == false) {
		String callValidation = pathVideoCall +"?reqid=" +reqIdVidCall+ "&customer=" +hashRefId
		WebUI.navigateToUrl((((('https://' + GlobalVariable.authUsername) + ':') + GlobalVariable.authPassword) + '@') + callValidation.substring(8))
		TestObject videoCallValidation = new TestObject().addProperty('text',ConditionType.CONTAINS,'Verifikasi datamu lewat video call!')
		if (WebUI.waitForElementVisible(videoCallValidation, 5)) {
			WebUI.waitForPageLoad(5)
			WebUI.delay(3)
			if (WebUI.verifyElementClickable(btnCallSenyumku)) {
				WebUI.delay(5)
				WebUI.click(btnCallSenyumku)
				TestObject txtVerifConnect = new TestObject().addProperty('text',ConditionType.CONTAINS,'Kamu akan terhubung dengan tim Amar Bank')
				if (WebUI.verifyElementPresent(txtVerifConnect, 5)) {
					WebUI.switchToWindowIndex(0)
					TestObject backToCsrDetail = new TestObject().addProperty('text',ConditionType.CONTAINS,'Customer Detail')
					WebUI.verifyElementPresent(backToCsrDetail, 5)
					WebUI.refresh()
					'We want to check notification'
					WebUI.click(linkDashboard)
					if (WebUI.waitForElementPresent(menuKycManagement, 5)) {
						WebUI.click(menuKycManagement)
						if (WebUI.waitForElementPresent(menuKycVideo, 5)) {
							WebUI.click(menuKycVideo)
							WebUI.waitForPageLoad(5)
							WebUI.delay(3)
							if (WebUI.waitForElementPresent(txtAlertNotification, 5)) {
								WebUI.click(abortNotification)
							} else {keylogger.logInfo("We are not have active request")}
							TestObject kycVideoRequestPage = new TestObject().addProperty('text',ConditionType.CONTAINS,'KYC Video Request')
							WebUI.verifyElementPresent(kycVideoRequestPage, 5)
						} else {keylogger.markError('We not found element kyc video')}
					} else {keylogger.markError('We not found element kyc management')}
					WebDriver driverKycVideo = DriverFactory.getWebDriver()
					WebElement tblKycVideo
					List<WebElement> rowsKycVideo
					List<WebElement> colsKycVideo
					if (WebUI.waitForElementPresent(tabActiveCalls, 5)) {
						WebUI.click(tabActiveCalls)
						WebUI.delay(5)
						WebUI.waitForPageLoad(5)
						WebUI.setText(txtReqIdKycVideo, reqIdVidCall)
						WebUI.click(btnSearchKycVideo)
						tblKycVideo = driverKycVideo.findElement(By.xpath('//table/tbody'))
						rowsKycVideo = tblKycVideo.findElements(By.tagName('tr'))
						colsKycVideo = rowsKycVideo.get(0).findElements(By.tagName('td'))
						println('No. of rows: ' + rowsKycVideo.size())
						if (colsKycVideo.get(5).getText().equalsIgnoreCase("Nasabah Senyumku")) {
							colsKycVideo.get(3).getText().equalsIgnoreCase("Reaktivasi")
							colsKycVideo.get(1).findElement(By.xpath('a')).click()
						} else {keylogger.markError("Element not found")}
					} else {keylogger.markError('We not found the active calls')}
					WebUI.delay(5)
					WebUI.switchToWindowIndex(1)
					WebUI.delay(5)
					WebUI.switchToWindowIndex(0)
					WebUI.scrollToElement(btnSelfie, 5)
					WebUI.delay(10)
					break validateVideoCallLoop
				} else {keylogger.logInfo('Element not present')}
			} else {keylogger.logInfo('button cannot click able')}
		} else {keylogger.logInfo('We are not in verification data')}
	}
	
	'We want to confirmation process'
	TestObject checkConfProcess = new TestObject().addProperty('text',ConditionType.CONTAINS,'Hal-hal yang perlu dikonfirmasi')
	if (WebUI.verifyElementPresent(checkConfProcess, 5)) {
		WebUI.click(chkNamaKtp)
		WebUI.click(chkKtpNumber)
		WebUI.click(chkBirtDate)
		WebUI.click(chkMotherName)
		WebUI.click(chkReasonBlock)
		WebUI.click(chkAskNewPhoneNumber)
		WebUI.click(chkEmail)
		WebUI.click(chkDeliveryAddress)
		WebUI.click(chkCaptureFace)
		WebUI.scrollToElement(btnSelfie, 5)
		if (WebUI.verifyElementClickable(btnSelfie)) {
			WebUI.click(btnSelfie)
			if (WebUI.verifyElementVisible(imgSelfPhoto)) {
				keylogger.markPassed('Photo is enable')
				WebUI.click(btnSaveSelfPhoto)
				TestObject saveConfirmation = new TestObject().addProperty('text',ConditionType.CONTAINS,'Konfirmasi')
				if (WebUI.verifyElementPresent(saveConfirmation, 5)) {
					WebUI.click(btnSaveKyc)
					TestObject saveSelfPhoto = new TestObject().addProperty('text',ConditionType.CONTAINS,'Foto berhasil disimpan')
					WebUI.verifyElementPresent(saveSelfPhoto, 5)
				} else {keylogger.markError('element not present')}
			} else {keylogger.markError('Photo not enable')}
			WebUI.click(btnSelfie)
			if (WebUI.verifyElementVisible(imgKtpPhoto)) {
				keylogger.markPassed('Photo is enable')
				WebUI.click(btnSaveKtpPhoto)
				TestObject saveConfirmation = new TestObject().addProperty('text',ConditionType.CONTAINS,'Konfirmasi')
				if (WebUI.verifyElementPresent(saveConfirmation, 5)) {
					WebUI.click(btnSaveKyc)
					TestObject saveKtpPhoto = new TestObject().addProperty('text',ConditionType.CONTAINS,'Foto berhasil disimpan')
					WebUI.verifyElementPresent(saveKtpPhoto, 5)
				} else {keylogger.markError('element not present')}
			} else {keylogger.markError('Photo not enable')}
		} else {keylogger.markError('Button selfie belum dapat di lakukan')}
	} else {keylogger.markError('Element not present')}
	'We want ended the video call'
	if (WebUI.verifyElementClickable(btnEndVideoCall)) {
		WebUI.click(btnEndVideoCall)
		WebUI.takeScreenshot()
	} else {keylogger.markError('button is disable')}
			WebUI.scrollToElement(btnKycFinished,5)
			if (WebUI.verifyElementVisible(btnKycFinished)) {
				WebUI.click(btnKycFinished)
				WebUI.delay(5)
				'We try to fill the history call'
				TestObject historyCallCheck = new TestObject().addProperty('text',ConditionType.CONTAINS,'Keterangan History Call')
				if (WebUI.verifyElementPresent(historyCallCheck, 5)) {
					WebUI.click(chkCustNotSame)
					WebUI.delay(5)
					if (WebUI.verifyElementClickable(btnSentKycVideo)) {
						WebUI.click(btnSentKycVideo)
						WebUI.delay(5)
						TestObject successSendKyc = new TestObject().addProperty('text',ConditionType.CONTAINS,'KYC Video berhasil dikirim')
						if (WebUI.verifyElementPresent(successSendKyc, 5)) {
							WebUI.takeScreenshot()
							WebUI.click(btnCloseKyc)
							WebUI.delay(5)
							WebUI.click(linkDashboard)
							WebUI.waitForPageLoad(5)
							if (WebUI.waitForElementNotPresent(pendingRequest, 5)) {
								WebUI.takeScreenshot()
								keylogger.markPassed('Notification dissapear')
							} else {keylogger.markError('Pending request still visible')}
						} else {keylogger.markError('Element not present')}
					} else {keylogger.markError('Button send KYC video not click able')}
				} else {keylogger.markError('We cannot in check history')}
			}else {keylogger.markError('button not visible')}
			
			'Init selected web element KYC'
			WebDriver driverKycVerif = DriverFactory.getWebDriver()
			WebElement tblKycVerif
			List<WebElement> rowsKycVerif
			List<WebElement> colsKycVerif
			
			'We want do the 3 Steps button "terima"'
			if (WebUI.verifyElementClickable(menuKycManagement)) {
				WebUI.click(menuKycManagement)
				if (WebUI.verifyElementClickable(menuKycVerification)) {
					WebUI.click(menuKycVerification)
					WebUI.delay(3)
				} else {keylogger.markError('Button KYC video request')}
			}else {keylogger.markError('Button cannot click able')}
			if (WebUI.waitForElementPresent(menuKycVerification, 5)) {
				WebUI.waitForPageLoad(5)
				tblKycVerif = driverKycVerif.findElement(By.xpath('//table/tbody'))
				rowsKycVerif = tblKycVerif.findElements(By.tagName('tr'))
				colsKycVerif = rowsKycVerif.get(0).findElements(By.tagName('td'))
				if (colsKycVerif.get(7).getText().equalsIgnoreCase('Sedang diproses')) {
					colsKycVerif.get(7).findElement(By.xpath('a')).click()
					TestObject kycDetailPage = new TestObject().addProperty('text',ConditionType.CONTAINS,'KYC Customer Detail')
					if (WebUI.verifyElementPresent(kycDetailPage, 5)) {
						WebUI.click(btnBackBucketList)
						WebUI.waitForPageLoad(5)
						TestObject kycBucketList = new TestObject().addProperty('text',ConditionType.CONTAINS,'KYC Verification')
						WebUI.verifyElementPresent(kycBucketList, 5)
					} else {keylogger.markError('Element not present')}
				} else {keylogger.logInfo('Text is not found')}
			} else {keylogger.markError('element not present')}
			
			'We want to access the KYC Verif'
WebUI.setText(txtReqIdKycVerif, reqIdVidCall)
WebUI.sendKeys(txtReqIdKycVerif, Keys.chord(Keys.ENTER))
tblKycVerif = driverKycVerif.findElement(By.xpath('//table/tbody'))
rowsKycVerif = tblKycVerif.findElements(By.tagName('tr'))
colsKycVerif = rowsKycVerif.get(0).findElements(By.tagName('td'))
if (colsKycVerif.get(7).getText().equalsIgnoreCase('Menunggu')) {
colsKycVerif.get(7).findElement(By.xpath('a')).click()
TestObject kycDetailPage = new TestObject().addProperty('text',ConditionType.CONTAINS,'KYC Customer Detail')
if (WebUI.verifyElementPresent(kycDetailPage, 5)) {
		if (WebUI.waitForElementVisible(txtPersentageDukcapil, 5)) {
			WebUI.scrollToElement(btnTerima1, 5)
			WebUI.verifyElementClickable(btnTerima1)
			WebUI.click(btnTerima1)
			WebUI.waitForPageLoad(5)
			WebUI.delay(5)
		} else { keylogger.markError("Element not present")}
		if (WebUI.waitForElementVisible(btnTerima2, 5)) {
			WebUI.scrollToElement(btnTerima2, 5)
		   WebUI.verifyElementClickable(btnTerima2)
		   WebUI.click(btnTerima2)
		   WebUI.waitForPageLoad(5)
		   WebUI.delay(5)
	   } else {keylogger.logInfo("element not present")}
	   WebUI.delay(5)
	   TestObject successProcessKyc = new TestObject().addProperty('text',ConditionType.CONTAINS,'Nasabah berhasil diverifikasi')
	   if (WebUI.verifyElementPresent(successProcessKyc, 5)) {
		   WebUI.click(btnBackToKycManagement)
	   } else {keylogger.logInfo('Element not present')}
	   if (WebUI.waitForElementPresent(txtReqIdKycVerif, 5)) {
		   WebUI.setText(txtReqIdKycVerif, reqIdVidCall)
	   } else {keylogger.logInfo("Element not present")}
} else {keylogger.markError('Element not present')}
} else {keylogger.logInfo('Text is not found')}

'Access to Customer Detail for check the user is activated'
if (WebUI.waitForElementPresent(linkMenuCsrManagement, 5)) {
	WebUI.click(linkMenuCsrManagement)
	if (WebUI.waitForElementPresent(txtAlertNotification, 5)) {
		WebUI.click(abortNotification)
		WebUI.waitForPageLoad(5)
		WebUI.delay(3)
	} else {keylogger.logInfo("We are not have active request")}
} else {keylogger.markError("Element not found")}
WebUI.setText(txtReqIdCsrCheckData, reqIdVidCall)
WebUI.sendKeys(txtReqIdCsrCheckData, Keys.chord(Keys.ENTER))

'Init selected web element CSR Check Data'
WebDriver driverCsrCheck = DriverFactory.getWebDriver()
WebElement tblCsrCheckData = driverCsrCheck.findElement(By.xpath('//table/tbody'))
List<WebElement> rowsCsrCheckData = tblCsrCheckData.findElements(By.tagName('tr'))
List<WebElement> colsCsrCheckData = rowsCsrCheckData.get(0).findElements(By.tagName('td'))
if (colsCsrCheckData.get(5).getText().equalsIgnoreCase("Nasabah Senyumku")) {
	colsCsrCheckData.get(6).findElement(By.xpath('button')).click()
} else {keylogger.markError("We not found the data")}
TestObject custDetailPageCheck = new TestObject().addProperty('text',ConditionType.CONTAINS,'Customer Detail')
if (WebUI.waitForElementPresent(custDetailPageCheck, 5)) {
	TestObject reqIdCustCheck = new TestObject().addProperty('text',ConditionType.CONTAINS,'Selesai')
	WebUI.verifyElementPresent(reqIdCustCheck, 5)
	if (WebUI.waitForElementClickable(dataPhoneNumber, 5)) {
		WebUI.click(dataPhoneNumber)
		WebUI.verifyElementAttributeValue(phoneNumber, 'value', GlobalVariable.phoneNumberWithAreaCode, 5)
	} else {keylogger.markError("Phone number still old data")}
	WebUI.takeScreenshot()
	keylogger.markPassed("We are success to reactivation")
} else {keylogger.markError("We are not in detail page of CSR")}