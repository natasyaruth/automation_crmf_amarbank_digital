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

KeywordUtil keylogger = new KeywordUtil()

WebUI.click(tabIdleCalls)

WebUI.waitForPageLoad(5)

WebUI.delay(3)

WebDriver driver = DriverFactory.getWebDriver()

WebElement tableBucketList

List<WebElement> rowBucketList, colsBucketList

checkReqId = false

String requestIdKycVideo

loopCheckData:
while (checkReqId == false) {
	
	WebUI.selectOptionByValue(drpCustType, indexOptionCustType, false)
	
	WebUI.delay(3)
	
	tableBucketList = driver.findElement(By.xpath('//table/tbody'))
	
	rowBucketList = tableBucketList.findElements(By.tagName('tr'))
	
	for (int i=0;i < rowBucketList.size();i++) {
		
		colsBucketList = rowBucketList.get(i).findElements(By.tagName('td'))
		
		if (colsBucketList.get(3).getText().equalsIgnoreCase('Ganti Nomor HP')) {
			
			requestIdKycVideo = colsBucketList.get(1).findElement(By.xpath('a')).getText()
			
			break loopCheckData
			
		} else {
			
			keylogger.logInfo('We want try to check another Request ID')
			
			tableBucketList = driver.findElement(By.xpath('//table/tbody'))
			
			rowBucketList = tableBucketList.findElements(By.tagName('tr'))
		}
	}
}

println "Request id that will be processed: "+requestIdKycVideo

TestObject kycVideoDetail = new TestObject().addProperty('text',ConditionType.CONTAINS,'KYC Video Request')

if (WebUI.verifyElementPresent(kycVideoDetail, 5)) {
	
	String currentPage = WebUI.getUrl()
	
	int currentTab = WebUI.getWindowIndex()
	
	JavascriptExecutor js = ((driver) as JavascriptExecutor)
	
	js.executeScript('window.open();')
	
	WebUI.switchToWindowIndex(currentTab + 1)
	
	String requestIdProcess = path+requestIdKycVideo
	
	WebUI.navigateToUrl((((('https://' + GlobalVariable.authUsername) + ':') + GlobalVariable.authPassword) + '@') + requestIdProcess.substring(
		8))
	
	boolean checkVideoCall = true
	boolean checkCSR = true
	
	if (WebUI.waitForElementPresent(btnCallSenyumku, 5)) {
		
		if (WebUI.waitForElementClickable(btnCallSenyumku, 5)) {
			
			WebUI.delay(5)
			
			WebUI.click(btnCallSenyumku)
			
		} else {
			
			keylogger.markError('button cannot clickable')
			
			checkVideoCall == false
			checkCSR == false
		}
		
	} else if (WebUI.waitForElementPresent(btnRepeatCallSenyumku, 5)) {
		
		if (WebUI.waitForElementClickable(btnRepeatCallSenyumku, 5)) {
			
			WebUI.delay(5)
			
			WebUI.click(btnRepeatCallSenyumku)
			
		} else {
			
			keylogger.markError('button cannot clickable')
			
			checkVideoCall == false
			checkCSR == false
			
		}
		
	} else {
		
		keylogger.markError('We are not in verification data')
		
		checkVideoCall == false
		checkCSR == false
		
	}
	
	if(checkVideoCall) {
		
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
			
			WebUI.click(btnReqId)
			
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
			
			WebUI.click(chkNewPhoneNumber)
			
			WebUI.click(chkEmail)
			
			WebUI.click(chkChangePhoneReason)
			
			WebUI.click(chkPhotoCapture)
			
			if(WebUI.waitForElementPresent(alertErrorStartVideoCall, 5)) {
				
				WebUI.scrollToElement(btnCancel, 0)
				
				WebUI.click(btnCancel)
				
				WebUI.waitForElementPresent(tabActiveCalls, 10)
				
				keylogger.markFailed("Cannot connect KYC Video for this request id: "+requestIdKycVideo)
				
				checkCSR == false
				
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
										
										WebUI.scrollToElement(btnRejectKycVideo, 0)
										
										WebUI.delay(2)
										
										WebUI.click(btnRejectKycVideo)
										
										WebUI.waitForElementPresent(btnSendKycVideo, 5)
										
										WebUI.delay(2)
										
										WebUI.click(chkNotPassVerification)
										
										WebUI.click(chkDeviceNotCompatible)
										
										WebUI.click(chkErrorWavecell)
										
										WebUI.click(chkNetworkIssues)
										
										WebUI.click(chkRecordingIsNotClear)
										
										WebUI.click(chkPhotoIsNotSame)
										
										WebUI.click(chkOther)
										
										WebUI.waitForElementPresent(txtHistoryCall, 5)
										
										WebUI.setText(txtHistoryCall, rejectReason)
										
										WebUI.delay(2)
										
										WebUI.click(btnSendKycVideo)
										
										if (WebUI.waitForElementPresent(BtnCloseModal, 5)) {
											
											WebUI.click(BtnCloseModal)
											
											if(WebUI.waitForElementPresent(tabActiveCalls, 5)) {
												
												keylogger.markPassed("Successfully reject the KYC Video. Now we will check to CSR Detail")
												
											} else {
												
												WebUI.takeScreenshot()
												keylogger.markFailed("User is not in KYC Video Tab Active Calls"+requestIdKycVideo)
												
												checkCSR == false
												
											}
											
										} else {
											
											WebUI.takeScreenshot()
											keylogger.markFailed("Pop successfully rejected is not appear! Please check this request id "+requestIdKycVideo)
											
											WebUI.scrollToElement(btnKycFinished, 0)
											
											WebUI.delay(2)
											
											WebUI.click(btnCancel)
											
											WebUI.waitForElementPresent(tabActiveCalls, 10)
											
											checkCSR == false
											
										}
										
									} else {
										
										WebUI.takeScreenshot()
										keylogger.markFailed("Failed to save capture of KTP! Please check this request id "+requestIdKycVideo)
										
										WebUI.scrollToElement(btnKycFinished, 0)
										
										WebUI.delay(2)
										
										WebUI.click(btnCancel)
										
										WebUI.waitForElementPresent(tabActiveCalls, 10)
										
										checkCSR == false
									}
									
								} else {
									
									WebUI.takeScreenshot()
									keylogger.markFailed("Alert is not appear after save photo KTP. Please check this request id "+requestIdKycVideo)
									
									WebUI.scrollToElement(btnKycFinished, 0)
									
									WebUI.delay(2)
									
									WebUI.click(btnCancel)
									
									WebUI.waitForElementPresent(tabActiveCalls, 10)
									
									checkCSR == false
								}
								
							} else {
								
								WebUI.takeScreenshot()
								keylogger.markFailed("Failed to take capture of KTP! Please check this request id "+requestIdKycVideo)
								
								WebUI.scrollToElement(btnKycFinished, 0)
								
								WebUI.delay(2)
								
								WebUI.click(btnCancel)
								
								WebUI.waitForElementPresent(tabActiveCalls, 10)
								
								checkCSR == false
								
							}
							
						} else {
							
							WebUI.takeScreenshot()
							keylogger.markFailed("Failed to save capture of selfie! Please check this request id "+requestIdKycVideo)
							
							WebUI.scrollToElement(btnKycFinished, 0)
							
							WebUI.delay(2)
							
							WebUI.click(btnCancel)
							
							WebUI.waitForElementPresent(tabActiveCalls, 10)
							
							checkCSR == false
						}
						
					} else {
						
						WebUI.takeScreenshot()
						keylogger.markFailed("Alert is not appear after save photo selfie. Please check this request id "+requestIdKycVideo)
						
						WebUI.scrollToElement(btnKycFinished, 0)
						
						WebUI.delay(2)
						
						WebUI.click(btnCancel)
						
						WebUI.waitForElementPresent(tabActiveCalls, 10)
						
						checkCSR == false
					}
					
				} else {
					
					WebUI.takeScreenshot()
					keylogger.markFailed("Failed to take capture of selfie! Please check this request id "+requestIdKycVideo)
					
					WebUI.scrollToElement(btnKycFinished, 0)
					
					WebUI.delay(2)
					
					WebUI.click(btnCancel)
					
					WebUI.waitForElementPresent(tabActiveCalls, 10)
					
					checkCSR == false
					
				}
				
			}
			
		} else {
			
			keylogger.logInfo('Element not present')
			
			checkCSR == false
			
		}
		
	} 
	
	if(checkCSR) {
		
		WebUI.callTestCase(findTestCase(testCaseName), [('menuCSRManagement'):menuCSRManagement, ('blockBylockedUserElement'):blockBylockedUserElement,
			('alertConfirmationPopUpElement'):alertConfirmationPopUpElement, ('alertConfirmationPopUpText'):alertConfirmationPopUpText,
			('btnCancelPopUpElement'):btnCancelPopUpElement, ('headerCSRManagementElement'):headerCSRManagementElement,
			('headerCSRManagementText'):headerCSRManagementText])

		WebUI.setText(txtReqIdCSR, requestIdKycVideo)

		WebUI.click(btnSearch)

		if (WebUI.waitForElementPresent(btnReqIdCSR, 5)) {

			WebUI.click(btnReqIdCSR)
			
			WebUI.waitForPageLoad(5)

			if(WebUI.waitForElementPresent(btnBack, 10)) {
  
				if (WebUI.waitForElementPresent(txtHeaderRejectReason, 5)) {
					
					String actHeaderRejectReason = WebUI.getText(txtHeaderRejectReason)
					
					 if (actHeaderRejectReason.equals(headerRejectReason)) {
						 
						 for(int j=0;j<listRejectReason.size();j++) {
							 
							 int k = j+1
							 
							 WebElement elementReason = driver.findElement(By.xpath(pathElement+'['+k+']'))
							 String actReason = elementReason.getText()
							 
							 if(j==6) {
								 
								 if(actReason.equals(rejectReason)) {
									 
									 keylogger.markPassed("Reason "+rejectReason+" is exist")
								 
								 } else {
								
									 keylogger.markFailed("Reason "+rejectReason+" is not exist")
								 
								 }
								 
							 } else {
								 
								 if(actReason.equals(listRejectReason.get(j))) {
									 
									 keylogger.markPassed("Reason "+listRejectReason.get(j)+" is exist")
								 
								 } else {
								
									 keylogger.markFailed("Reason "+listRejectReason.get(j)+" is not exist")
								 
								 }
								 
							 }
							 
						 }
						 
					 } else {
						 
						 WebUI.takeScreenshot()
						 keylogger.markFailed("Header text of Alasan Penolakan is not correct. Actual text: "+actHeaderRejectReason)
						 
					 }
					 
				} else {
					
					WebUI.takeScreenshot()
					keylogger.markFailed("Reject reason is not exists in CSR Detail. Please check manually for this request id: "+requestIdKycVideo)
					
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
	
} else {
	
	keylogger.markError("We aren't in KYC video detail")
	
}