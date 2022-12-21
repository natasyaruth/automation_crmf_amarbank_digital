import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.github.javafaker.Faker
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
import com.kms.katalon.entity.global.GlobalVariableEntity

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.tunaiku.keyword.RandomFakerData as dummyData
import groovy.json.JsonSlurper

'init function'
KeywordUtil keylogger = new KeywordUtil()
Faker faker = new Faker()

String randomFirstEmail = dummyData.set_faker_first_name()
println(randomFirstEmail)

whiteList_email = WS.sendRequest(findTestObject('API/CRM/API_WhiteListEmail', [('RandomFirstName'): randomFirstEmail]))

'Get JSON Response'
String JSONResponse = whiteList_email.getResponseText()
println('Response : ' +JSONResponse)

String statusCode = whiteList_email.getStatusCode()

String waitingTime = whiteList_email.getWaitingTime()

'Convert Text'
JsonSlurper SlurperLoan = new JsonSlurper()

'Object Mapping'
Object result = SlurperLoan.parseText(JSONResponse)

WebUI.delay(1)

println('Status Code: ' + statusCode)

println('Waiting Time: ' + waitingTime)

if (WS.verifyEqual(statusCode, '200')) {
	GlobalVariable.randomFirstNameWhitelist = "senyumku_" +randomFirstEmail+ "@maildrop.cc"
	println(GlobalVariable.randomFirstNameWhitelist)
} else {keylogger.markError('Status Code is not equal 200')}