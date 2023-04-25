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
import groovy.transform.ConditionalInterrupt as ConditionalInterrupt
import org.openqa.selenium.remote.server.handler.RefreshPage as RefreshPage
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils
import com.github.javafaker.Faker as Faker
import com.tunaiku.keyword.Hash256

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
'Akses KYC Video with customer type reactivation'
if (WebUI.waitForElementPresent(menuKYCManagement, 5)) {
    WebUI.click(menuKYCManagement)

    if (WebUI.waitForElementVisible(menuKycVideo, 5)) {
        WebUI.click(menuKycVideo)

        if (WebUI.waitForElementVisible(idleCallsTab, 5)) {
            WebUI.click(idleCallsTab)

            if (WebUI.waitForElementPresent(alertConfirmation, 5)) {
                WebUI.click(btnAbort)
            } else {
                keylogger.logInfo('We not found the element')
            }
            
            WebUI.delay(5)

            WebDriver driver = DriverFactory.getWebDriver()

            WebElement tableBucketList

            List<WebElement> rowBucketList

            List<WebElement> colsBucketList

            checkReqId = false

            loopCheckData:
			 while (checkReqId == false) {
                WebUI.selectOptionByLabel(DrpCustomerType, 'Nasabah Senyumku', false)

                tableBucketList = driver.findElement(By.xpath('//table/tbody'))

                rowBucketList = tableBucketList.findElements(By.tagName('tr'))

                for (int i = 0; i < rowBucketList.size(); i++) {
                    colsBucketList = rowBucketList.get(i).findElements(By.tagName('td'))

                    if (colsBucketList.get(3).getText().equalsIgnoreCase('Reaktivasi') && colsBucketList.get(5).getText().equalsIgnoreCase(
                        'Nasabah Senyumku')) {
                        colsBucketList.get(1).findElement(By.xpath('a')).click()

                        WebUI.waitForPageLoad(5)

                        TestObject inKycVideoReq = new TestObject().addProperty('text', ConditionType.CONTAINS, 'KYC Video Request')

                        if (WebUI.waitForElementVisible(inKycVideoReq, 5)) {
							(WebUI.verifyElementPresent(inKycVideoReq, 5))

                            break loopCheckData
                        }
                    } else {
                        keylogger.logInfo('We want try to check another Request ID')

                        tableBucketList = driver.findElement(By.xpath('//table/tbody'))

                        rowBucketList = tableBucketList.findElements(By.tagName('tr'))
                    }
                }
            }
        } else {
            keylogger.markError('We not found tab Idle Calls')
        }
    } else {
        keylogger.markError('Menu KYC video not present')
    }
} else {
    keylogger.markError('Link menu KYC Video Request Not Available')
}

WebUI.delay(5)
LabelReqid = WebUI.getText(LabelRequestID)
println(LabelReqid)
referenceIdKycVideo = WebUI.getText(refId)
refIdKycVideo = referenceIdKycVideo
String hashRefId = Hash256.hash(refIdKycVideo)
println(hashRefId)
TestObject kycVideoDetail = new TestObject().addProperty('text', ConditionType.CONTAINS, 'KYC Video Request')

if (WebUI.verifyElementPresent(kycVideoDetail, 5)) {
    String currentPage = WebUI.getUrl()

    int currentTab = WebUI.getWindowIndex()

    WebDriver driver = DriverFactory.getWebDriver()

    JavascriptExecutor js = ((driver) as JavascriptExecutor)

    js.executeScript('window.open();')

    WebUI.switchToWindowIndex(currentTab + 1)

    String requestIdProcess = path +"?reqid=" +LabelReqid+ "&customer=" +hashRefId

    WebUI.navigateToUrl((((('https://' + GlobalVariable.authUsername) + ':') + GlobalVariable.authPassword) + '@') + requestIdProcess.substring(8))
    WebUI.waitForPageLoad(5)
    WebUI.delay(3)

    TestObject videoCallValidation = new TestObject().addProperty('text', ConditionType.CONTAINS, 'Verifikasi datamu lewat video call!')

    if (WebUI.verifyElementPresent(videoCallValidation, 5)) {
        if (WebUI.verifyElementClickable(btnCallSenyumku)) {
            WebUI.delay(5)

            WebUI.click(btnCallSenyumku)

            TestObject txtVerifConnect = new TestObject().addProperty('text',ConditionType.CONTAINS,'Kamu akan terhubung dengan tim Amar Bank')

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
LabelReqid2 = WebUI.getText(LabelRequestID)
println(LabelReqid2)
TestObject checkConfProcess = new TestObject().addProperty('text', ConditionType.CONTAINS, 'Hal-hal yang perlu dikonfirmasi')

if (WebUI.verifyElementPresent(checkConfProcess, 5)) {
    WebUI.click(chkNamaKtp)

    WebUI.click(chkKtpNumber)

    WebUI.click(chkBirtDate)

    WebUI.click(chkMotherName)

    WebUI.click(chkReasonBlock)

    WebUI.click(chkEmail)

    WebUI.click(chkCaptureFace)

    WebUI.scrollToElement(btnSelfie, 5)

    if (WebUI.verifyElementClickable(btnSelfie)) {
        WebUI.click(btnSelfie)

        if (WebUI.verifyElementVisible(imgSelfPhoto)) {
            keylogger.markPassed('Photo is enable')

            WebUI.click(btnSaveSelfPhoto)

            TestObject saveConfirmation = new TestObject().addProperty('text', ConditionType.CONTAINS, 'Konfirmasi')

            if (WebUI.verifyElementPresent(saveConfirmation, 5)) {
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
            keylogger.markPassed('Photo is enable')

            WebUI.click(btnSaveKtpPhoto)

            TestObject saveConfirmation = new TestObject().addProperty('text', ConditionType.CONTAINS, 'Konfirmasi')

            if (WebUI.verifyElementPresent(saveConfirmation, 5)) {
                WebUI.click(btnSaveKyc)

                TestObject saveKtpPhoto = new TestObject().addProperty('text', ConditionType.CONTAINS, 'Foto berhasil disimpan')

                WebUI.verifyElementPresent(saveKtpPhoto, 5)
            } else {
                keylogger.markError('element not present')
            }
        } else {
            keylogger.markError('Photo not enable')
        }
    } else {
        keylogger.markError('Button selfie belum dapat di lakukan')
    }
} else {
    keylogger.markError('Element not present')
}

'We want ended the video call'
if (WebUI.verifyElementClickable(btnEndVideoCall)) {
    WebUI.click(btnEndVideoCall)

    WebUI.takeScreenshot()
} else {
    keylogger.markError('button is disable')
}

'We want to cancel KYC Video'
WebUI.scrollToElement(BtnCancelKYC, 5)

if (WebUI.verifyElementVisible(BtnCancelKYC)) {
    WebUI.click(BtnCancelKYC)

    WebUI.delay(5)

    WebUI.waitForPageLoad(20)

    WebUI.click(btnRequestID)

    WebUI.delay(3)

    WebUI.click(btnBackDashboard)
} else {
    keylogger.markError('button not visible')
}

WebUI.delay(5)

'We want validate changes phone number'
WebUI.click(linkMenuCsrManagement)

TestObject notifProcessCsrDetail = new TestObject().addProperty('text', ConditionType.CONTAINS, 'Konfirmasi')

if (WebUI.verifyElementPresent(notifProcessCsrDetail, 5, FailureHandling.OPTIONAL)) {
    WebUI.click(btnAbort)
} else {
    keylogger.logInfo('We continue the process')
}

TestObject csrManagementDetailCsrManagement = new TestObject().addProperty('text', ConditionType.CONTAINS, 'CSR Management')

if (WebUI.verifyElementPresent(csrManagementDetailCsrManagement, 5, FailureHandling.OPTIONAL)) {
    WebUI.delay(3)

    WebUI.setText(txtRequestId, LabelReqid2)

    WebUI.sendKeys(txtRequestId, Keys.chord(Keys.ENTER))
} else {
    keylogger.markError('We are not in CSR Management')
}

WebUI.delay(5)

'We want access the reactivate account'
WebDriver driverCsrCheck = DriverFactory.getWebDriver()

WebElement tblCsrCheck = driverCsrCheck.findElement(By.xpath('//table/tbody'))

List<WebElement> rawCsrCheck = tblCsrCheck.findElements(By.tagName('tr'))

List<WebElement> colsCsrCheck = rawCsrCheck.get(0).findElements(By.tagName('td'))

if (colsCsrCheck.get(5).getText().equalsIgnoreCase('Nasabah Senyumku')) {
    colsCsrCheck.get(6).findElement(By.xpath('button')).click()
} else {
    keylogger.markError('We not found the ')
}

TestObject csrManagementDetailCheck = new TestObject().addProperty('text', ConditionType.CONTAINS, 'Customer Detail')

if (WebUI.verifyElementPresent(csrManagementDetailCheck, 5)) {
    WebUI.click(linkDataPhoneNumber)
} else {
    keylogger.markError('We not in detail request Id')
}

WebUI.delay(5)

/* We will define new test object with spesific condition */
'We want check the changelog'
WebUI.scrollToElement(SectionChangelog, 5)

WebUI.click(SectionChangelog)

TestObject SectionChangelogCheck = new TestObject().addProperty('text', ConditionType.CONTAINS, 'Batal')

if (WebUI.waitForElementVisible(SectionChangelogCheck, 5)) {
    WebUI.verifyElementVisible(SectionChangelogCheck)

    WebUI.verifyElementPresent(SectionChangelogCheck, 5)
} else {
    keylogger.markFailed('Error Process')
}

WebUI.delay(5)

WebUI.takeScreenshot()

WebUI.scrollToElement(btnBackToBucketList, 5)

WebUI.waitForElementVisible(btnBackToBucketList, 5)

WebUI.click(btnBackToBucketList)

WebUI.delay(5)

WebUI.refresh()

WebUI.waitForPageLoad(50)

