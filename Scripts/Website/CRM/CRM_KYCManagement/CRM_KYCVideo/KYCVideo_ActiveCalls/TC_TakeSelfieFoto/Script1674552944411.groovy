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
	-User has access to KYC video request active calls
	-Active incoming call for "Ganti Nomor Hp Nasabah Senyumku"
	
	Steps:
	- Click incoming call "Ganti Nomor Hp Nasabah Senyumku" request id
	
	Expected Result:
	-System display detail customer "Ganti Nomor Hp Nasabah Senyumku" with active KYC video call page
	-System display new phone number in "Nomor HP Baru" section
 */
/*csrReqId = WebUI.getText(txtReqIdKycVideo)*/
//reqIdCsr = csrReqId

if (WebUI.waitForElementPresent(menuKYCManagement, 5)) {
    WebUI.click(menuKYCManagement)

    if (WebUI.waitForElementPresent(menuKycVideo, 5)) {
        WebUI.click(menuKycVideo)

        if (WebUI.verifyElementPresent(idleCallsTab, 5)) {
            WebUI.click(idleCallsTab)

            if (WebUI.waitForElementPresent(alertConfirmation, 5)) {
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

WebUI.selectOptionByValue(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/DrpCustomerType'), '1', true)

//WebUI.setText(txtReqIdKycVideo, reqIdCsr)
//WebUI.sendKeys(txtReqIdKycVideo, Keys.chord(Keys.ENTER))
WebDriver driverKycVideo = DriverFactory.getWebDriver()

WebElement tblKycVideo = driverKycVideo.findElement(By.xpath('//table/tbody'))

List<WebElement> rawKycVideo = tblKycVideo.findElements(By.tagName('tr'))

List<WebElement> colsKycVideo = rawKycVideo.get(0).findElements(By.tagName('td'))

if (colsKycVideo.get(3).getText().equalsIgnoreCase('Registrasi Baru')) {
    colsKycVideo.get(5).getText().equalsIgnoreCase('Nasabah Baru')

    colsKycVideo.get(1).findElement(By.xpath('a')).click()
} else {
    keylogger.markError('We not found the ')
}


reqIdCsr = WebUI.getText(txtReqIdKycVideoActiveCall)
TestObject kycVideoDetail = new TestObject().addProperty('text', ConditionType.CONTAINS, 'KYC Video Request')

if (WebUI.verifyElementPresent(kycVideoDetail, 5)) {
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

    if (WebUI.verifyElementPresent(videoCallValidation, 5)) {
        if (WebUI.verifyElementClickable(btnCallSenyumku)) {
            WebUI.delay(5)

            WebUI.click(btnCallSenyumku)

            TestObject txtVerifConnect = new TestObject().addProperty('text', ConditionType.CONTAINS, 'Kamu akan terhubung dengan tim Senyumku')

            if (WebUI.verifyElementPresent(txtVerifConnect, 0)) {
                WebUI.switchToWindowIndex(0)

                TestObject backToKycVideo = new TestObject().addProperty('text', ConditionType.CONTAINS, 'KYC Video Request')

                WebUI.verifyElementPresent(backToKycVideo, 5)

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

if (WebUI.verifyElementPresent(checkConfProcess, 5)) {
    WebUI.click(chkNamaKtp)

    WebUI.click(chkKtpNumber)

    WebUI.click(chkBirtDate)

    WebUI.click(chkMotherName)

    WebUI.click(ChkCardDeliveryAddress)

    WebUI.click(ChkKtpImage)

    WebUI.click(ChkKtpFace)

    WebUI.click(ChkPhotoCapture)

    WebUI.scrollToElement(btnSelfie, 5)

    if (WebUI.verifyElementClickable(btnSelfie)) {
        WebUI.click(btnSelfie)
		
        if (WebUI.verifyElementVisible(imgSelfPhoto)) {
			WebUI.takeScreenshot()
			WebUI.scrollToElement(BtnCancel, 5)
			WebUI.click(BtnCancel)
		}
		else {
			            keylogger.markError('Photo not enable')
			        }
//            keylogger.markPassed('Photo is enable')
//
//            WebUI.click(btnSaveSelfPhoto)
//
//            TestObject saveConfirmation = new TestObject().addProperty('text', ConditionType.CONTAINS, 'Konfirmasi')
//
//            if (WebUI.verifyElementPresent(saveConfirmation, 5)) {
//                WebUI.click(btnSaveKyc)
//
//                TestObject saveSelfPhoto = new TestObject().addProperty('text', ConditionType.CONTAINS, 'Foto berhasil disimpan')
//
//                WebUI.verifyElementPresent(saveSelfPhoto, 5)
//            } else {
//                keylogger.markError('element not present')
//            }
//        } else {
//            keylogger.markError('Photo not enable')
//        }
//        
//        WebUI.click(btnSelfie)
//
//        if (WebUI.verifyElementVisible(imgKtpPhoto)) {
//            keylogger.markPassed('Photo is enable')
//
//            WebUI.click(btnSaveKtpPhoto)
//
//            TestObject saveConfirmation = new TestObject().addProperty('text', ConditionType.CONTAINS, 'Konfirmasi')
//
//            if (WebUI.verifyElementPresent(saveConfirmation, 5)) {
//                WebUI.click(btnSaveKyc)
//
//                TestObject saveKtpPhoto = new TestObject().addProperty('text', ConditionType.CONTAINS, 'Foto berhasil disimpan')
//
//                WebUI.verifyElementPresent(saveKtpPhoto, 5)
//            } else {
//                keylogger.markError('element not present')
//            }
//        } else {
//            keylogger.markError('Photo not enable')
//        }
    } else {
        keylogger.markError('Button selfie belum dapat di lakukan')
    }
} else {
    keylogger.markError('Element not present')
}

'We want ended the video call'
//if (WebUI.verifyElementClickable(btnEndVideoCall)) {
//    WebUI.click(btnEndVideoCall)
//
//    WebUI.takeScreenshot()
//} else {
//    keylogger.markError('button is disable')
//}
//
//WebUI.scrollToElement(btnKycFinished, 5)
//
//if (WebUI.verifyElementVisible(btnKycFinished)) {
//    WebUI.click(btnKycFinished)
//
//    WebUI.delay(5)
//
//    'We try to fill the history call'
//    TestObject historyCallCheck = new TestObject().addProperty('text', ConditionType.CONTAINS, 'Keterangan History Call')
//
//    if (WebUI.verifyElementPresent(historyCallCheck, 5)) {
//        WebUI.click(chkCustNotSame)
//
//        WebUI.delay(5)
//
//        if (WebUI.verifyElementClickable(btnSentKycVideo)) {
//            WebUI.click(btnSentKycVideo)
//
//            WebUI.delay(10)
//
//            TestObject successSendKyc = new TestObject().addProperty('text', ConditionType.CONTAINS, 'KYC Video berhasil dikirim')
//
//            if (WebUI.verifyElementPresent(successSendKyc, 5)) {
//                WebUI.takeScreenshot()
//
//                WebUI.click(btnCloseKyc)
//
//                WebUI.delay(5)
//
//                WebUI.click(linkDashboard)
//
//                WebUI.waitForPageLoad(5)
//
//                if (WebUI.waitForElementNotPresent(pendingRequest, 5)) {
//                    WebUI.takeScreenshot()
//
//                    keylogger.markPassed('Notification dissapear')
//                } else {
//                    keylogger.markError('Pending request still visible')
//                }
//            } else {
//                keylogger.markError('Element not present')
//            }
//        } else {
//            keylogger.markError('Button send KYC video not click able')
//        }
//    } else {
//        keylogger.markError('We cannot in check history')
//    }
//} else {
//    keylogger.markError('button not visible')
//}

