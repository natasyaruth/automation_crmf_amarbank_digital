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
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

'Init Logging'
KeywordUtil keylogger = new KeywordUtil()

'Scenario Test'
/*
 Precondition
	- Has roles upload photo in Keycloak
	- Already login to CRMF
	- Already search request id with Customer type: Nasabah Senyumku, Origin: Tunaiku Reject, and Status: Selesai
	- Both photo Selfie and eKTP of customer are blank

 Steps
 	- Click button choose file in section photo eKTP
	- Choose photo
	- Click OK
	- Click button choose file in section photo Selfie
	- Choose photo
	- Click OK
	- Click button 'Upload Foto'

 Expected Result
	- Button 'Upload Foto' will enable
	- Show message success 'Foto berhasil diupload'
	- Show file name of images selfie and eKTP
	- Message success can be closed
	- Buton "Choose file" still enable
	- In DB log agent who uploaded the photo will recorded
	- In DB photo eKTP will convert into link to GCS photo
	- In GCS photo will uploaded with format name image [app_id]-ktp and [app-id]-selfie without the extension file
	- Both photo will updated in CSR Detail
	- Both photo will updated in KYC Verification (if the customer do request like changephone or reactivation)

 * */

