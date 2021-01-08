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
<<<<<<< HEAD:Scripts/Website/CRM/CRM_KYCVerification/TC_KYCVerificationBucketlist/Script1605082113273.groovy

WebUI.waitForElementPresent(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/LinkVerification'), 3)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/LinkVerification'))

WebUI.waitForPageLoad(10, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent(Verify_Bucketlist, false)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/BtnNextPage'))

WebUI.waitForElementPresent(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/BtnFirstPage'), 4)

=======

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/LinkVerification'))

WebUI.delay(3)

WebUI.verifyTextPresent(Verify_Bucketlist, false)

WebUI.delay(3)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/BtnNextPage'))

WebUI.delay(2)

>>>>>>> 1b9eec7791de5d020e96a84c3dda72e2b2d0e4f8:Scripts/Website/CRM/CRM_KYCVerification/TC_KYCVerificationRegist/Script1588672087347.groovy
WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/BtnLastPage'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/BtnPreviousPage'))

<<<<<<< HEAD:Scripts/Website/CRM/CRM_KYCVerification/TC_KYCVerificationBucketlist/Script1605082113273.groovy
WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/BtnFirstPage'))
=======
WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/BtnPreviousPage'))
>>>>>>> 1b9eec7791de5d020e96a84c3dda72e2b2d0e4f8:Scripts/Website/CRM/CRM_KYCVerification/TC_KYCVerificationRegist/Script1588672087347.groovy

WebUI.selectOptionByLabel(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/DrpEmailType'), Email_Type, 
    false)

<<<<<<< HEAD:Scripts/Website/CRM/CRM_KYCVerification/TC_KYCVerificationBucketlist/Script1605082113273.groovy
WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/DtpStartFilterDate'), StartFilterDate)

WebUI.delay(2)

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/DtpEndFilterDate'), EndFilterDate)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/BtnShow'))

WebUI.delay(1)

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/TxtSearchRequestID'), RequestID)

WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/BtnSearch'))

WebUI.verifyTextPresent(RequestIDName, false)

WebUI.delay(1)
=======
WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/BtnFirstPage'))

WebUI.delay(2)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/DrpEmailType'), Email_Type, 
    false)

WebUI.delay(3)

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/DtpStartFilterDate'), StartFilterDate)

WebUI.delay(5)

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/DtpEndFilterDate'), EndFilterDate)

WebUI.delay(5)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/BtnShow'))

WebUI.delay(5)

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/TxtSearchRequestID'), RequestID)

WebUI.delay(5)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/BtnSearch'))

WebUI.delay(5)

WebUI.verifyTextPresent(RequestIDName, false)
>>>>>>> 1b9eec7791de5d020e96a84c3dda72e2b2d0e4f8:Scripts/Website/CRM/CRM_KYCVerification/TC_KYCVerificationRegist/Script1588672087347.groovy

