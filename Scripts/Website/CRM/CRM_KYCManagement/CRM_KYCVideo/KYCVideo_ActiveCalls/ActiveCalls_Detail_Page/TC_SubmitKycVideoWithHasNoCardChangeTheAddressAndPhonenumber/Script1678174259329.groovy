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
import org.openqa.selenium.WebDriver as Keys
import org.openqa.selenium.WebElement
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils

KeywordUtil keylogger = new KeywordUtil()

int optionListLength = 3

Random rand = new Random()

String index = rand.nextInt(optionListLength + 1)

String newPhoneNumber = "+628"+RandomStringUtils.randomNumeric(10)

String oldPhoneNumber, idNumber, accountNumber

int countDataFailed

boolean checkData = true

LoopData:

for(int a=0;a<listNameTest.size();a++) {
	
	WebUI.setText(txtName, listNameTest.get(a))
	
	WebUI.click(btnSearch)
	
	WebUI.delay(2)
	
	if (WebUI.waitForElementPresent(btnReqIdCSR, 5)) {
		
		WebUI.click(btnReqIdCSR)
		
		WebUI.waitForPageLoad(10)
		
		if(WebUI.waitForElementPresent(sectionNoHandphone, 10)) {
			
			String actStatus = WebUI.getText(txtStatus)
			
			println actStatus
			
			if(actStatus.equals(statusDone)) {
				
				WebUI.click(sectionNoHandphone)
				
				WebUI.delay(2)
				
				oldPhoneNumber = WebUI.getAttribute(txtPhoneNumber, 'value')
				
				WebUI.click(sectionDataKTP)
				
				WebUI.delay(2)
				
				idNumber = WebUI.getAttribute(txtKTPNumber, 'value')
				
				WebUI.click(sectionAccInfo)
				
				WebUI.delay(2)
				
				accountNumber = WebUI.getAttribute(txtAccountNumber, 'value')
				
				break LoopData
				
			} else {
				
				WebUI.click(btnBack)
				
				WebUI.waitForElementPresent(headerCSRManagementElement, 10)
				
				WebUI.delay(2)
				
				countDataFailed++
				
			}
			
		} else {
			
			WebUI.takeScreenshot()
			keylogger.logInfo("Something went wrong when open CSR Detail")
			countDataFailed++
			
		}
		
	} else {
		
		WebUI.takeScreenshot()
		keylogger.logInfo("No such data with name "+listNameTest.get(a))
		countDataFailed++
		
	}
	
}

WebDriver driver = DriverFactory.getWebDriver()

boolean checkReactivate = true

if(countDataFailed != 3) {
	
	String currentPage = WebUI.getUrl()
	
	int currentTab = WebUI.getWindowIndex()
	
	JavascriptExecutor js = ((driver) as JavascriptExecutor)
	
	js.executeScript('window.open();')
	
	WebUI.switchToWindowIndex(currentTab + 1)
	
	WebUI.navigateToUrl((((('https://' + GlobalVariable.authUsername) + ':') + GlobalVariable.authPassword) + '@') + pathBlock.substring(
		8))
	
	if(WebUI.waitForElementPresent(txtPhoneNumberSenyumku, 10)) {
		
		WebUI.setText(txtPhoneNumberSenyumku, "0"+oldPhoneNumber.substring(3))
		
		WebUI.setText(txtIdNumber, idNumber)
		
		WebUI.click(rbAccountNumber)
		
		WebUI.waitForElementPresent(txtAccountNumber, 5)
		
		WebUI.setText(txtAccountNumber, accountNumber)
		
		WebUI.setText(txtReason, reasonText)
		
		WebUI.delay(2)
		
		WebUI.click(btnFormSubmit)
		
		WebUI.waitForElementPresent(btnBlockAccount, 5)
		
		WebUI.delay(2)
		
		WebUI.click(btnBlockAccount)
		
		if(WebUI.waitForElementPresent(linkReactivation, 10) == false) {
			
			checkReactivate == false
			
			WebUI.takeScreenshot()
			keylogger.markError("Blocking account process is failed!")
			
		}
		
	} else {
		
		checkReactivate == false
		
		WebUI.takeScreenshot()
		keylogger.markError("Cannot connect to page block account!")
		
	}
	
}

GlobalVariable.oldPhoneNumber = "0"+oldPhoneNumber.substring(3)

String requestIdKycVideo

boolean checkVideoCall = true

if(checkReactivate) {
	
	WebUI.navigateToUrl((((('https://' + GlobalVariable.authUsername) + ':') + GlobalVariable.authPassword) + '@') + pathReactivation.substring(
		8))
	
	if(WebUI.waitForElementPresent(txtPhoneNumberSenyumku, 10)) {
		
		WebUI.setText(txtPhoneNumberSenyumku, "0"+oldPhoneNumber.substring(3))
		
		WebUI.setText(txtIdNumber, idNumber)
		
		WebUI.click(rbAccountNumber)
		
		WebUI.waitForElementPresent(txtAccountNumber, 5)
		
		WebUI.setText(txtAccountNumber, accountNumber)
		
		WebUI.delay(2)
		
		WebUI.click(btnNext)
		
		if(WebUI.waitForElementPresent(btnSubmit, 5)) {
			
			WebUI.click(rbHasCardNo)
			
			WebUI.waitForElementPresent(btnChgDelliveryAddress, 5)
			
			WebUI.click(btnChgDelliveryAddress)
			
			if(WebUI.waitForElementPresent(lbHeaderChangeAddressReactivation, 10)) {
				
				WebUI.selectOptionByValue(drpAddressType, optionAddressType, false)
				
				WebUI.setText(txtFullAddress, fullAddress)
				
				WebUI.setText(txtNeighbourhood, rt)
				
				WebUI.setText(txtHamlet, rw)
				
				WebUI.selectOptionByValue(drpProvince, optionProvince, false)
				
				WebUI.delay(1)
				
				WebUI.selectOptionByValue(drpDistrict, optionCity, false)
				
				WebUI.delay(1)
				
				WebUI.selectOptionByValue(drpSubdistrict, optionSubDistrict, false)
				
				WebUI.delay(1)
				
				WebUI.selectOptionByValue(drpVillage, optionVillage, false)
				
				WebUI.delay(1)
				
				WebUI.click(btnSave)
				
				if(WebUI.waitForElementPresent(btnChgDelliveryAddress, 10)) {
					
					WebUI.click(rbChgPhoneYes)
					
					WebUI.waitForElementPresent(txtNewPhoneNumber, 5)
					  
					WebUI.setText(txtNewPhoneNumber, "0"+newPhoneNumber.substring(3)) 
					
					WebUI.delay(2)
					
					WebUI.click(btnSubmit)
					
					if(WebUI.waitForElementPresent(btnVerify, 10)) {
						
						WebUI.callTestCase(findTestCase('API/CRM/TC_getOTP'), [:], FailureHandling.STOP_ON_FAILURE)
						
						WebUI.delay(5)
						
						WebUI.setText(txtOTP1, GlobalVariable.dataOtp1)
						
						WebUI.setText(txtOTP2, GlobalVariable.dataOtp2)
						
						WebUI.setText(txtOTP3, GlobalVariable.dataOtp3)
						
						WebUI.setText(txtOTP4, GlobalVariable.dataOtp4)
						
						WebUI.delay(1)
						
						WebUI.click(btnVerify)
						
					} else {
						
						checkVideoCall == false
						
						WebUI.takeScreenshot()
						keylogger.markError("Didn't direct to page reactivate-account/otp!")
						
					}
						
				} else {
					
					checkVideoCall == false
					
					WebUI.takeScreenshot()
					keylogger.markError("Didn't direct to page reactivate-account/request after change the address!")
					
				}
				
			} else {
				
				checkVideoCall == false
				
				WebUI.takeScreenshot()
				keylogger.markError("Didn't direct to page reactivate-account/change-address!")
				
			}
			
			
		} else {
			
			checkVideoCall == false
			
			WebUI.takeScreenshot()
			keylogger.markError("Didn't direct to page reactivate-account/request!")
			
		}
		
	} else {
		
		checkVideoCall == false
		
		WebUI.takeScreenshot()
		keylogger.markError("Cannot connect to page reactivate account!")
		
	}
	
}

boolean checkKYCVerif = true

if(checkVideoCall) {
	
	WebUI.switchToWindowIndex(0)
			
	WebUI.refresh()
			
	WebUI.delay(5)
	
	if(WebUI.waitForElementPresent(sectionNoHandphone, 10)) {
		
		requestIdKycVideo = WebUI.getText(txtReqIdCSR)
		
		println "Request id that will be processed: "+requestIdKycVideo
		
		WebUI.click(btnBack)
		
		WebUI.waitForElementPresent(headerCSRManagementElement, 10)
		
		WebUI.callTestCase(findTestCase(testCaseNameKYC), [('menuKYCManagement'):menuKYCManagement, ('menuKYCVideo'):menuKYCVideo, ('blockBylockedUserElement'):blockBylockedUserElement,
			('alertConfirmationPopUpElement'):alertConfirmationPopUpElement, ('alertConfirmationPopUpText'):alertConfirmationPopUpText,
			('btnCancelPopUpElement'):btnCancelPopUpElement, ('headerKYCVideoRequestElement'):headerKYCVideoRequestElement,
			('headerCSRManagementText'):headerKYCVideoRequestText, ('btnResumeKycVideo'):btnResumeKycVideo, ('btnCancelKycVideoActiveCalls'):btnCancelKycVideoActiveCalls,
			('tabIddleCalls'):tabIddleCalls])
		
		WebUI.switchToWindowIndex(1)
		
		String pathProcessVidCall = pathVidCall+requestIdKycVideo
		
		WebUI.navigateToUrl((((('https://' + GlobalVariable.authUsername) + ':') + GlobalVariable.authPassword) + '@') + pathProcessVidCall.substring(
			8))
		
		if (WebUI.waitForElementPresent(btnCallSenyumku, 10)) {
			
			if (WebUI.waitForElementClickable(btnCallSenyumku, 10)) {
				
				WebUI.delay(5)
				
				WebUI.click(btnCallSenyumku)
				
			} else {
				
				checkKYCVerif == false
				
				WebUI.takeScreenshot()
				keylogger.markError('button call Senyumku is not clickable')
				
			}
			
		} else if (WebUI.waitForElementPresent(btnRepeatCallSenyumku, 5)) {
			
			if (WebUI.waitForElementClickable(btnRepeatCallSenyumku, 5)) {
				
				WebUI.delay(5)
				
				WebUI.click(btnRepeatCallSenyumku)
				
			} else {
				
				checkKYCVerif == false
				
				WebUI.takeScreenshot()
				keylogger.markError('button repeat call Senyumku is not clickable')
				
			}
			
		} else {
			
			checkKYCVerif == false
			
			WebUI.takeScreenshot()
			keylogger.markError("Didn't direct to page connect to video call!")
				
		}
		
	} else {
		
		checkKYCVerif == false
		
		WebUI.takeScreenshot()
		keylogger.markError("Something went wrong in CSR, can't open the detail of this request id: "+requestIdKycVideo)
	}
	
	if(checkKYCVerif) {
		
		TestObject txtVerifConnect = new TestObject().addProperty('text',ConditionType.CONTAINS,'Kamu akan terhubung dengan tim Senyumku')
	
		if (WebUI.verifyElementPresent(txtVerifConnect, 0)) {
			
			WebUI.switchToWindowIndex(0)
			
			TestObject backToKycVideo = new TestObject().addProperty('text',ConditionType.CONTAINS,'KYC Video Request')
			
			WebUI.verifyElementPresent(backToKycVideo, 5)
			
			WebUI.delay(5)
			
			WebUI.click(tabActiveCalls)
			
			WebUI.waitForPageLoad(5)
	
			WebUI.setText(fieldTxtReqId, requestIdKycVideo)
			
			WebUI.click(btnSearch)
			
			WebUI.delay(5)
			
			WebUI.click(btnReqIdKYCVideo)
			
			WebUI.waitForElementPresent(backToKycVideo, 10)
			
			WebUI.delay(5)
			
			WebUI.switchToWindowIndex(1)
			
			WebUI.delay(5)
			
			WebUI.switchToWindowIndex(0)
			
			WebUI.delay(2)
			
			WebUI.scrollToElement(btnSelfie, 5)
			
			WebUI.click(chkNamaKtp)
			
			WebUI.click(chkKtpNumber)
			
			WebUI.click(chkBirtDate)
			
			WebUI.click(chkMotherName)
			
			WebUI.click(chkBlockedReason)
			
			WebUI.click(chkNewPhoneNumber)
			
			WebUI.click(chkEmail)
			
			WebUI.click(chkCardDeliveryAddress)
			
			WebUI.click(chkPhotoCapture)
			
			if(WebUI.waitForElementPresent(alertErrorStartVideoCall, 5)) {
				
				WebUI.scrollToElement(btnCancel, 0)
				
				WebUI.click(btnCancel)
				
				WebUI.waitForElementPresent(tabActiveCalls, 10)
				
				keylogger.markFailed("Cannot connect KYC Video for this request id: "+requestIdKycVideo)
				
				checkKYCVerif == false
				
			} else {
				
				WebUI.click(btnSelfie)
				
				if(WebUI.waitForElementPresent(imgSelfiePhoto, 5)) {
					
					keylogger.markPassed("Success take capture of selfie!")
					
					WebUI.waitForElementPresent(btnSaveSelfPhoto, 5)
					
					WebUI.click(btnSaveSelfPhoto)
					
					WebUI.waitForElementPresent(btnSaveKycImage, 5)
				
					WebUI.delay(2)
				
					WebUI.click(btnSaveKycImage)
					
					if(WebUI.waitForElementPresent(txtMsgSuccessSaveSelfie, 5)) {
						
						String actMsgAlertSelfie = WebUI.getText(txtMsgSuccessSaveSelfie)
						
						if(actMsgAlertSelfie.equals(msgSuccessSave)) {
							
							keylogger.markPassed("Success save capture selfie photo!")
							
							WebUI.delay(2)
							
							WebUI.click(btnSelfie)
							
							if(WebUI.waitForElementPresent(imgKtpPhoto, 5)) {
								
								keylogger.markPassed("Success take capture of KTP image!")
								
								WebUI.waitForElementPresent(btnSaveKtpPhoto, 5)
								
								WebUI.click(btnSaveKtpPhoto)
								
								WebUI.waitForElementPresent(btnSaveKycImage, 5)
							
								WebUI.delay(2)
							
								WebUI.click(btnSaveKycImage)
								
								if(WebUI.waitForElementPresent(txtMsgSuccessSaveKtp, 5)) {
									
									String actMsgAlertKtp = WebUI.getText(txtMsgSuccessSaveKtp)
									
									if(actMsgAlertKtp.equals(msgSuccessSave)) {
										
										keylogger.markPassed("Success save capture KTP photo!")
										
										WebUI.scrollToElement(btnEndVideoCall, 0)
										
										WebUI.delay(2)
										
										WebUI.click(btnEndVideoCall)
										
										WebUI.delay(2)
										
										TestObject txtEndKYCVideo = new TestObject().addProperty('text',ConditionType.CONTAINS, msgEndKycVideo)
										
										WebUI.scrollToElement(btnKycFinished, 0)
										
										WebUI.delay(2)
										
										WebUI.click(btnKycFinished)
										
										WebUI.waitForElementPresent(btnSendKycVideo, 5)
										
										WebUI.delay(2)
										
										WebUI.click(chkOther)
										
										WebUI.waitForElementPresent(txtHistoryCall, 5)
										
										WebUI.setText(txtHistoryCall, kycVideoReason)
										
										WebUI.delay(2)
										
										WebUI.click(btnSendKycVideo)
										
										if (WebUI.waitForElementPresent(btnCloseModal, 20)) {
											
											WebUI.click(btnCloseModal)
											
											if(WebUI.waitForElementPresent(tabActiveCalls, 10)) {
												
												keylogger.markPassed("Successfully submit the KYC Video. Now we will check to KYC Verification")
												
											} else {
												
												WebUI.takeScreenshot()
												keylogger.markFailed("User is not in KYC Video Tab Active Calls "+requestIdKycVideo)
												
												checkKYCVerif == false
												
											}
											
										} else {
											
											WebUI.takeScreenshot()
											keylogger.markFailed("Pop up successfully submitted is not appear! Please check this request id "+requestIdKycVideo)
											
											WebUI.scrollToElement(btnKycFinished, 0)
											
											WebUI.delay(2)
											
											WebUI.click(btnCancel)
											
											WebUI.waitForElementPresent(tabActiveCalls, 10)
											
											checkKYCVerif == false
											
										}
										
									} else {
										
										WebUI.takeScreenshot()
										keylogger.markFailed("Failed to save capture of KTP! Please check this request id "+requestIdKycVideo)
										
										WebUI.scrollToElement(btnKycFinished, 0)
										
										WebUI.delay(2)
										
										WebUI.click(btnCancel)
										
										WebUI.waitForElementPresent(tabActiveCalls, 10)
										
										checkKYCVerif == false
									}
									
								} else {
									
									WebUI.takeScreenshot()
									keylogger.markFailed("Alert is not appear after save photo KTP. Please check this request id "+requestIdKycVideo)
									
									WebUI.scrollToElement(btnKycFinished, 0)
									
									WebUI.delay(2)
									
									WebUI.click(btnCancel)
									
									WebUI.waitForElementPresent(tabActiveCalls, 10)
									
									checkKYCVerif == false
								}
								
							} else {
								
								WebUI.takeScreenshot()
								keylogger.markFailed("Failed to take capture of KTP! Please check this request id "+requestIdKycVideo)
								
								WebUI.scrollToElement(btnKycFinished, 0)
								
								WebUI.delay(2)
								
								WebUI.click(btnCancel)
								
								WebUI.waitForElementPresent(tabActiveCalls, 10)
								
								checkKYCVerif == false
								
							}
							
						} else {
							
							WebUI.takeScreenshot()
							keylogger.markFailed("Failed to save capture of selfie! Please check this request id "+requestIdKycVideo)
							
							WebUI.scrollToElement(btnKycFinished, 0)
							
							WebUI.delay(2)
							
							WebUI.click(btnCancel)
							
							WebUI.waitForElementPresent(tabActiveCalls, 10)
							
							checkKYCVerif == false
						}
						
					} else {
						
						WebUI.takeScreenshot()
						keylogger.markFailed("Alert is not appear after save photo selfie. Please check this request id "+requestIdKycVideo)
						
						WebUI.scrollToElement(btnKycFinished, 0)
						
						WebUI.delay(2)
						
						WebUI.click(btnCancel)
						
						WebUI.waitForElementPresent(tabActiveCalls, 10)
						
						checkKYCVerif == false
					}
					
				} else {
					
					WebUI.takeScreenshot()
					keylogger.markFailed("Failed to take capture of selfie! Please check this request id "+requestIdKycVideo)
					
					WebUI.scrollToElement(btnKycFinished, 0)
					
					WebUI.delay(2)
					
					WebUI.click(btnCancel)
					
					WebUI.waitForElementPresent(tabActiveCalls, 10)
					
					checkKYCVerif == false
					
				}
				
			}
			
		} else {
			
			keylogger.logInfo('Element not present')
			
			checkKYCVerif == false
			
		}
		
	}
		
}

boolean checkCSR = true

if(checkKYCVerif) {
	
	boolean checkMenuKYC = WebUI.verifyElementVisible(menuKYCVerification, FailureHandling.OPTIONAL)
	
	if (checkMenuKYC == true) {
		
		WebUI.click(menuKYCVerification)
		
	} else {
		
		keylogger.markFailed("Something happen with menu KYC Management")
	
	}
	
	String actStatusButton = WebUI.getText(btnReqIdKYCVerification)
	
	/*'We want to check blocked notification and check for text blocked
	 * if alert confirmation pop up enable is true'*/
	if (actStatusButton.equals(statusButton)) {
		
		WebUI.click(btnReqIdKYCVerification)
		
		WebUI.waitForElementVisible(headerKYCVerificationDetailRequestElement, 5)
		
		WebUI.verifyElementText(headerKYCVerificationDetailRequestElement, headerKYCVerificationDetailRequestText)
		
		WebUI.waitForElementVisible(btnBack, 5)
		
		WebUI.click(btnBack)
		
		WebUI.waitForPageLoad(5)
		
	} else {
		
		WebUI.verifyElementText(headerKYCVerificationDetailRequestElement, headerKYCVerificationText)
		
	}
	
	WebUI.setText(fieldTxtReqId, requestIdKycVideo)
	
	WebUI.click(btnSearch)
	
	if (WebUI.waitForElementPresent(btnReqIdKYCVerification, 10)) {
		
		WebUI.click(btnReqIdKYCVerification)
		
		WebUI.waitForPageLoad(5)

		if(WebUI.waitForElementPresent(btnBack, 10)) {

			WebUI.scrollToElement(btnTerima1, 3)
			
			WebUI.delay(1)
			
			WebUI.click(btnTerima1)
			
			WebUI.waitForElementPresent(btnTerima2, 5)
			
			WebUI.scrollToElement(btnTerima2, 3)
			
			WebUI.delay(1)
			
			WebUI.click(btnTerima2)
			
			if(WebUI.waitForElementPresent(btnCloseModal, 20)){
				
				WebUI.delay(2)
				
				WebUI.click(btnCloseModal)
				
				WebUI.waitForElementPresent(headerKYCVerificationDetailRequestElement, 10)
				
				WebUI.delay(1)
				
			} else {
				
				checkCSR == false
				
				WebUI.takeScreenshot()
				keylogger.markFailed("Process KYC Verification accept is failed for this request id "+requestIdKycVideo+" in KYC Verification. Please check manually.")
				
			}

		} else {
			
			checkCSR == false
			
			WebUI.takeScreenshot()
			keylogger.markFailed("Can't open request id detail "+requestIdKycVideo+" in KYC Verification. Please check manually.")

		}
		
	} else {
		
		checkCSR == false
		
		WebUI.takeScreenshot()
		keylogger.markFailed("Can't find the request id detail "+requestIdKycVideo+" in KYC Verification Bucketlist. Please check manually.")
		
	}
	
}

if(checkCSR) {
	
	WebUI.callTestCase(findTestCase(testCaseNameCSR), [('menuCSRManagement'):menuCSRManagement, ('blockBylockedUserElement'):blockBylockedUserElement,
		('alertConfirmationPopUpElement'):alertConfirmationPopUpElement, ('alertConfirmationPopUpText'):alertConfirmationPopUpText,
		('btnCancelPopUpElement'):btnCancelPopUpElement, ('headerCSRManagementElement'):headerCSRManagementElement,
		('headerCSRManagementText'):headerCSRManagementText])

	WebUI.setText(fieldTxtReqIdCSR, requestIdKycVideo)

	WebUI.click(btnSearch)
	
	WebUI.delay(2)

	if (WebUI.waitForElementPresent(btnReqIdCSR, 5)) {

		WebUI.click(btnReqIdCSR)
		
		WebUI.waitForPageLoad(10)

		if(WebUI.waitForElementPresent(btnBack, 10)) {
			
			WebUI.click(sectionNoHandphone)
			
			WebUI.waitForElementPresent(btnSaveNoHP, 5)
			
			WebUI.delay(2)
			
			String actNoHP = WebUI.getAttribute(txtPhoneNumber, 'value')
			
			if(actNoHP.equals(newPhoneNumber)) {
				
				WebUI.click(sectionDeliveryAddress)
				
				WebUI.waitForElementPresent(txtFullAddress, 5)
				
				WebUI.delay(2)
				
				String actAddress = WebUI.getText(txtFullAddress)
				
				if(actAddress.equals(fullAddress)) {
					
					keylogger.markPassed("Phonenumber and address successfully updated. Case PASSED!")
					
					WebUI.click(btnBack)
					
					WebUI.waitForPageLoad(5)
					
				} else {
					
					WebUI.takeScreenshot()
					keylogger.markFailed("Address is not updated. Act address: "+actAddress+"/n"
										 +"Expected address: "+fullAddress)
					
					WebUI.click(btnBack)
					
					WebUI.waitForPageLoad(5)
					
				}
				
			} else {
				
				WebUI.takeScreenshot()
				keylogger.markFailed("Phonenumber is not updated. Act phonenumber: "+actNoHP+"/n"
									 +"Expected phonenumber: "+newPhoneNumber)
				
				WebUI.click(btnBack)
				
				WebUI.waitForPageLoad(5)
				
			}

		} else {

			WebUI.takeScreenshot()
			keylogger.markFailed("Can't open request id detail "+requestIdKycVideo+" in CSR Management. Please check manually.")

		}


	} else {

		WebUI.takeScreenshot()
		keylogger.markFailed("Can't find the request id detail "+requestIdKycVideo+" in CSR Bucketlist. Please check manually.")

	}
	
}
