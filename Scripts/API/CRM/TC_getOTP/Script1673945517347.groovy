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
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys
import org.openqa.selenium.remote.http.JsonHttpResponseCodec as Keys

'Initial'
KeywordUtil keylogger = new KeywordUtil()

'Prepare http request'
def request = WS.sendRequest(findTestObject('API/API_changePhoneNumberOTP'))

'Get JSON Respons'
String JSONResponse = request.getResponseText()

'Get status code response'
String statusCode = request.getStatusCode()

'Mapping JSON to access'
JsonSlurper SluperOTP = new JsonSlurper()

'Mapping Response'
Map parsedJson = SluperOTP.parseText(JSONResponse)

WebUI.delay(2)

'We want get OTP Code'
println('OTP Code: ' +parsedJson.get("Data").get("otp_customer"))
String otpCode = parsedJson.get("Data").get("otp_customer")
GlobalVariable.otpOldPhoneNumber = otpCode

if (WebUI.verifyNotEqual(otpCode, '0', FailureHandling.OPTIONAL)) {
	'Check data OTP'
	String sourceOtp = GlobalVariable.otpOldPhoneNumber
	data1 = sourceOtp[0]
	data2 = sourceOtp[1]
	data3 = sourceOtp[2]
	data4 = sourceOtp[3]
	
	'Storing each otp data'
	GlobalVariable.dataOtp1 = data1
	GlobalVariable.dataOtp2 = data2
	GlobalVariable.dataOtp3 = data3
	GlobalVariable.dataOtp4 = data4
} else {
	keylogger.logInfo('Status OTP: ' +otpCode)
}

'We want verify status code'
if (WebUI.verifyEqual(statusCode, "200")) {
	keylogger.markPassed('Status code: ' +statusCode)
} else {
	keylogger.markError('Status code: ' +statusCode)
}