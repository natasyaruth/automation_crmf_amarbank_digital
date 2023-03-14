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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Alert as Alert
import org.openqa.selenium.By as By
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor

'Init keylogger'
KeywordUtil keylogger = new KeywordUtil()

/*Scenario Test
 * Precondition:
	User has access to KYC active video calls customer details
	User has take selfie photo
	
	Steps:
	Click "Ambil Foto" button
	
	Expected Result:
	System display eKTP photo result with timestamp in "Foto eKTP Detail Sesi KYC" section
 */

if (WebUI.waitForElementVisible(menuKYCManagement, 5)) {
	
    WebUI.click(menuKYCManagement)

    if (WebUI.waitForElementVisible(menuKycVideo, 5)) {
		
        WebUI.click(menuKycVideo)
		
		TestObject checkActiveCalls = new TestObject().addProperty('text',ConditionType.CONTAINS,'Konfirmasi')
		
		boolean notifActiveCalls = WebUI.waitForElementVisible(checkActiveCalls, 5)
		
		if (notifActiveCalls == true) {
			
			keylogger.logInfo("We process the active calls")
			
			WebUI.click(btnLanjutActiveCalls)
			
			TestObject kycVidReqText = new TestObject().addProperty('text',ConditionType.CONTAINS,'KYC Video Request')
			
			boolean inKycVidReq = WebUI.waitForElementVisible(kycVidReqText, 5)
			
			if (inKycVidReq == true) {
				
				WebUI.click(btnBatalKycVid)
				
			} else {
				
				keylogger.markFailed("Button Batal KYC Not Available")
				
			}
			
		} else {
			
			keylogger.logInfo("We can continue the process")
			
		}

        if (WebUI.waitForElementVisible(idleCallsTab, 5)) {
			
            WebUI.click(idleCallsTab)

            if (WebUI.waitForElementVisible(alertConfirmation, 5)) {
				
                WebUI.click(btnAbort)
				
            } else {
				
                keylogger.logInfo('We not found the element')
				
            }
			
        } else {
			
            keylogger.markError('We not found tab Idle Calls')
			
        }
		
    } else {
		
        keylogger.markError('Menu KYC video not present')
		
    }
	
} else {
	
    keylogger.markError('Menu KYC management not present')
	
}

WebUI.selectOptionByValue(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/DrpCustomerType'), '0', true)

WebUI.waitForPageLoad(5)

WebUI.delay(3)

checkDataLoop = false

loopData:

while (checkDataLoop == false) {
	
	WebDriver driverKycVideo = DriverFactory.getWebDriver()
	
	WebElement tblKycVideo = driverKycVideo.findElement(By.xpath('//table/tbody'))
	
	List<WebElement> rawKycVideo = tblKycVideo.findElements(By.tagName('tr'))
	
	
	for (i = 0;i < rawKycVideo.size();i++) {
		
		List<WebElement> colsKycVideo = rawKycVideo.get(0).findElements(By.tagName('td'))
		
		if (colsKycVideo.get(3).getText().equalsIgnoreCase('Ganti Nomor HP') && colsKycVideo.get(5).getText().equalsIgnoreCase('Nasabah Senyumku')) {
			
				colsKycVideo.get(1).findElement(By.xpath('a')).click()
				
				WebUI.waitForPageLoad(5)
				
				WebUI.delay(3)
				
				break loopData
				
			} else {
				
				keylogger.logInfo('We not found the Data please check again')
				
				boolean totalData = WebUI.verifyEqual(rawKycVideo.size(), 9)
				
				if (totalData == true) {
					
					keylogger.logInfo("We check anoter page")
					
					WebUI.click(btnNextPageKycVid)
					
					WebUI.waitForPageLoad(5)
					
					tblKycVideo = driverKycVideo.findElement(By.xpath('//table/tbody'))
					
					rawKycVideo = tblKycVideo.findElements(By.tagName('tr'))
					
				} else {
					
					keylogger.logInfo(" We continue the process")
					
					tblKycVideo = driverKycVideo.findElement(By.xpath('//table/tbody'))
					
					rawKycVideo = tblKycVideo.findElements(By.tagName('tr'))
					
				}
		}
	}
	
}


reqIdCsr = WebUI.getText(txtReqIdKycVideoActiveCall)

TestObject kycVideoDetail = new TestObject().addProperty('text', ConditionType.CONTAINS, 'KYC Video Request')

if (WebUI.waitForElementVisible(kycVideoDetail, 5)) {
	
    String currentPage = WebUI.getUrl()

    int currentTab = WebUI.getWindowIndex()

    WebDriver driver = DriverFactory.getWebDriver()

    JavascriptExecutor js = ((driver) as JavascriptExecutor)

    js.executeScript('window.open();')

    WebUI.switchToWindowIndex(currentTab + 1)

    String requestIdProcess = path + reqIdCsr

    WebUI.navigateToUrl((((('https://' + GlobalVariable.authUsername) + ':') + GlobalVariable.authPassword) + '@') + requestIdProcess.substring(
            8))

    TestObject videoCallValidation = new TestObject().addProperty('text', ConditionType.CONTAINS, 'Verifikasi datamu lewat video call!')

    if (WebUI.waitForElementVisible(videoCallValidation, 5)) {
		
        if (WebUI.verifyElementClickable(btnCallSenyumku)) {
			
            WebUI.delay(5)

            WebUI.click(btnCallSenyumku)

            TestObject txtVerifConnect = new TestObject().addProperty('text', ConditionType.CONTAINS, 'Kamu akan terhubung dengan tim Senyumku')

            if (WebUI.waitForElementVisible(txtVerifConnect, 5)) {
				
                WebUI.switchToWindowIndex(0)

                TestObject backToKycVideo = new TestObject().addProperty('text', ConditionType.CONTAINS, 'KYC Video Request')

                WebUI.waitForElementVisible(backToKycVideo, 5)

                WebUI.click(linkDashboard)

                'We want to check notification'
                if (WebUI.waitForElementVisible(pendingRequest, 5)) {
					
                    WebUI.click(pendingRequest)
					
                } else {
					
                    keylogger.markError('Notification didnt shown')
					
                }
                
                WebUI.delay(5)

                WebUI.switchToWindowIndex(1)

                WebUI.delay(5)

                WebUI.switchToWindowIndex(0)

                WebUI.scrollToElement(btnSelfie, 5)

                WebUI.delay(10)
				
            } else {
				
                keylogger.logInfo('Element not present')
				
            }
			
        } else {
			
            keylogger.markError('button cannot click able')
			
        }
		
    } else {
		
        keylogger.markError('We are not in verification data')
		
    }
	
} else {
	
    keylogger.markError('We aren\'t in KYC video detail')
	
}

'We want to confirmation process'
TestObject checkConfProcess = new TestObject().addProperty('text', ConditionType.CONTAINS, 'Hal-hal yang perlu dikonfirmasi')

if (WebUI.waitForElementVisible(checkConfProcess, 5)) {
	
	WebUI.click(chkNamaKtp)
	
	WebUI.click(chkKtpNumber)
	
	WebUI.click(chkBirtDate)
	
	WebUI.click(chkMotherName)
	
	WebUI.click(chkChangePhoneNumber)
	
	WebUI.click(chkEmail)
	
	WebUI.click(chkReasonChangePhoneNumber)
	
	WebUI.click(chkCaptureFace)

    WebUI.scrollToElement(btnSelfie, 5)

    if (WebUI.verifyElementClickable(btnSelfie)) {
		
        WebUI.click(btnSelfie)
		
        if (WebUI.verifyElementVisible(imgSelfPhoto)) {
					
            keylogger.markPassed('Photo is enable')

            WebUI.click(btnSaveSelfPhoto)

            TestObject saveConfirmation = new TestObject().addProperty('text', ConditionType.CONTAINS, 'Konfirmasi')

            if (WebUI.waitForElementVisible(saveConfirmation, 5)) {
				
                WebUI.click(btnSaveKyc)

                TestObject saveSelfPhoto = new TestObject().addProperty('text', ConditionType.CONTAINS, 'Foto berhasil disimpan')

                WebUI.verifyElementPresent(saveSelfPhoto, 5)
				
            } else {
				
                keylogger.markError('element not present')
				
            }
			
        } else {
			
            keylogger.markError('Photo not enable')
			
        }
        
        WebUI.click(btnSelfie)

        if (WebUI.verifyElementVisible(imgKtpPhoto)) {
			
			WebUI.takeScreenshot()
			
			WebUI.scrollToElement(BtnCancel, 5)
			
			WebUI.click(BtnCancel)
		
        } else {
			
            keylogger.markError('Photo not enable')
			
        }
		
    } else {
		
        keylogger.markError('Button selfie belum dapat di lakukan')
		
    }
	
} else {
	
    keylogger.markError('Element not present')
	
}
