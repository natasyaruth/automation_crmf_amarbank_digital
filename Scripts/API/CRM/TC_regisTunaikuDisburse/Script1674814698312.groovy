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
import internal.GlobalVariable

import org.apache.commons.lang.RandomStringUtils
import org.openqa.selenium.Keys
import org.openqa.selenium.remote.http.JsonHttpResponseCodec as Keys
import com.tunaiku.keyword.RandomFakerData as DataRandom

'Initial'
KeywordUtil keylogger = new KeywordUtil()
String randomPhoneNumber = "+62857" +RandomStringUtils.randomNumeric(9)
String randomKtp = "3171" +RandomStringUtils.randomNumeric(12)
String randomFirstName = DataRandom.set_faker_first_name()
String randomLastName = DataRandom.set_faker_last_name()
String randomEmail = DataRandom.set_faker_email()

'Prepare http request'
def request = WS.sendRequest(findTestObject('API/CRM/API_regisTunaikuDisburse',[('phoneNumber') : randomPhoneNumber,('pin') : randomKtp,('firstName') : randomFirstName, ('lastName') : randomLastName, ('email') : randomEmail]))

'Get JSON Respons'
String JSONResponse = request.getResponseText()

'Get status code response'
String statusCode = request.getStatusCode()

'Mapping JSON to access'
JsonSlurper SluperOTP = new JsonSlurper()

'Mapping Response'
Map parsedJson = SluperOTP.parseText(JSONResponse)
println(parsedJson)
WebUI.delay(2)

'We want get bank account code'
println('Bank Account: ' +parsedJson.get("Data").get("bankAccount"))
String bankAccountData = parsedJson.get("Data").get("bankAccount")
GlobalVariable.accountBank = bankAccountData
println(GlobalVariable.accountBank)

'We want verify status code'
if (WebUI.verifyEqual(statusCode, "200")) {
	keylogger.markPassed('Status code: ' +statusCode)
} else {
	keylogger.markError('Status code: ' +statusCode)
}