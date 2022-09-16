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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

/*Declare keyword util*/
KeywordUtil keyLogger = new KeywordUtil()

WebUI.click(findTestObject('Website/CRM/CSR_Management/CSRManagement/CSRManagementLink'))

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
        keyLogger.markFailed('We don\'t find alert confirmation')
    }
    
    WebUI.waitForElementVisible(headerCSRManagementElement, 5)

    WebUI.verifyElementText(headerCSRManagementElement, headerCSRManagementText)
} else {
    WebUI.verifyElementText(headerCSRManagementElement, headerCSRManagementText)
}

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Bucketlist/CSRManagementBucketListTxtName'), InputName)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Bucketlist/CSRManagementBucketListBtnSearch'))

WebUI.click(findTestObject('Website/CRM/CSR_Management/Bucketlist/CSRManagementBucketListBtnDetail'))

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/SectionTitleTransactionPin'))

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnUnblockPINTransaksi'))

WebUI.takeScreenshot()

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnCancelUnblockPINTransaksi'))

WebUI.takeScreenshot()

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnUnblockPINTransaksi'))

WebUI.takeScreenshot()

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnCancelUnblockPINTransaksi'))

WebUI.takeScreenshot()

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnBack'))

