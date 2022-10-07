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
import com.kms.katalon.core.webservice.keyword.builtin.ContainsStringKeyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.text.PDFTextStripper
import java.io.File
import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.testobject.internal.impl.HttpBodyContentReader
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.RestRequestObjectBuilder
import com.kms.katalon.core.testobject.TestObjectProperty as TestObjectProperty
import com.kms.katalon.core.testobject.UrlEncodedBodyParameter
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static org.assertj.core.api.Assertions.*
import com.tunaiku.keyword.SecureUtils as SecureUtils
import com.google.gson.JsonObject as JsonObject
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils
import com.github.javafaker.Faker

/* We want to makesure to access delivery status */
if (WebUI.waitForElementVisible(menuDeliveryStatusElement, 5, FailureHandling.OPTIONAL)) {
	WebUI.click(menuDeliveryStatusElement)
	WebUI.verifyElementText(headerTextPageElement, "Delivery Status")
	WebUI.verifyElementPresent(firstColoumnRequestIdElement, 5)
} else {
	WebUI.waitForElementVisible(menuCardManagementElement, 5)
	WebUI.verifyElementText(menuCardManagementElement, "Card Management")
	WebUI.click(menuCardManagementElement)
	WebUI.waitForElementVisible(menuDeliveryStatusElement, 5)
	WebUI.click(menuDeliveryStatusElement)
	WebUI.verifyElementText(headerTextPageElement, "Delivery Status")
	WebUI.verifyElementPresent(firstColoumnRequestIdElement, 5)
}
/* We want to verify drop down filter delivery status*/
WebUI.waitForElementVisible(drpDwnFilterDeliveryStatusElement, 5)
/* We want to select pickup filter "Pengambilan"*/
WebUI.selectOptionByLabel(drpDwnFilterDeliveryStatusElement, "Penyortiran", false)
/* We want to wait for first row data from pickup selection*/
WebUI.waitForElementVisible(firstColoumnRequestIdElement, 5)
/* We want to set as variable request ID*/
def requestId = WebUI.getText(firstColoumnRequestIdElement)
/* We want to click the data first row*/
WebUI.click(firstColoumnRequestIdElement)
/* We want to verify the header text of detail page*/
WebUI.verifyElementText(headerTextDetailElement, "Delivery Detail")
/* We want check existing name receiver*/
def existNameReceiver = WebUI.getText(valueNameReceiveCardElement)
/* We want check existing phone number receiver*/
def existPhoneNumber = WebUI.getText(valuePhoneNumberReceiveCardElement)
/* We want to check first message of shipping history*/
def existFirstRowHistoryShipping = WebUI.getText(messageFirstRowElement)
/* We want to capture the page*/
WebUI.takeScreenshot()
/*------------------------------------------------------------------------*/
/* We want setup faker for name */
Faker faker = new Faker()
String fullName = faker.name().fullName()
/* We want to generate random value*/
def PhoneNumber = "0812" + RandomStringUtils.randomNumeric(8)
println ("PhoneNumber: " + PhoneNumber)
/* We want to set API testing for enroute route ninja*/
String body = '{"shipper_id":921,"status":"'+ existStatus +'","previous_status": "'+ preStatus +'","shipper_order_ref_no": "8374","timestamp": "2017-04-03T11:50:44+0800","order_id":"3b7327b9-54bf-417f-3104-f4e134ed22308","tracking_id": "AMAR-'+ requestId +'","pod":{"type": "SUBSTITUTE","name": "'+ fullName +'","identity_number": "XX","contact": "'+ PhoneNumber +'","uri": "'+ imageCust +'","left_in_safe_place": false}}'
System.out.println(body)
/* We want to encrypt the body with SHA256*/
hashNinjaVanSuccessfulDelivery = SecureUtils.hmac_sha256("cf47ca4e44844cb987eb0577530a12a0",body.toString())
/* We want to store to global variable*/
GlobalVariable.hashNinjaVanSuccessfulDelivery = hashNinjaVanSuccessfulDelivery
println (GlobalVariable.hashNinjaVanSuccessfulDelivery)
/* We want to prepare the http request*/
def request = ((findTestObject('API/CRM/API_ninjaVanSuccessfulDelivery', [('base_url_crm_otoku') : GlobalVariable.baseUrlRegOtoku, ('username') : GlobalVariable.usernameWebApi, ('password') : GlobalVariable.passwordWebApi, ('X-NINJAVAN-HMAC-SHA256') : hashNinjaVanSuccessfulDelivery])) as RequestObject)
request.setBodyContent(new HttpTextBodyContent(body, 'UTF-8', 'application/json'))
/* We want to send the API process*/
def response = WS.sendRequest(request)
/* We want to get the response*/
def body_content = response.responseBodyContent
def status_code = response.statusCode
/* We want parse response from API process*/
def respDataMap = new JsonSlurper().parseText(body_content)
/* We just check by log*/
println(body_content)
/* We just check by log*/
println(status_code)
/* We want to assert the status code is 200*/
assertThat(response.getStatusCode()).isEqualTo(200)
/*------------------------------------------------------------------------*/
/* We want to give delay after processing api*/
WebUI.delay(10)
/* We want to refresh page to update the detail page*/
WebUI.refresh()
/* We want to verify the header text of detail page*/
WebUI.verifyElementText(headerTextDetailElement, "Delivery Detail")
/* We want capture the update data receiver*/
WebUI.takeScreenshot()
/* We want check existing name receiver*/
def newNameReceiver = WebUI.getText(valueNameReceiveCardElement)
/* We want check existing phone number receiver*/
def newPhoneNumber = WebUI.getText(valuePhoneNumberReceiveCardElement)
/* We want to makesure name of data is not same before*/
WebUI.verifyNotMatch(existNameReceiver, newNameReceiver, false)
/* We want to makesure phone number of data is not same before*/
WebUI.verifyNotMatch(existPhoneNumber, newPhoneNumber, false)
/* We want to verify request ID*/
WebUI.verifyElementPresent(valueOfReqId, 5)
/* We want to verify reference ID*/
WebUI.verifyElementPresent(valueOfRefId, 5)
/* We want to verify text page is "Pengambilan"*/
WebUI.verifyElementText(pickupTextElement, "Terkirim")
/* We want to verify customer name*/
WebUI.verifyElementPresent(customerNameElement, 5)
/* We want to verify card type*/
WebUI.verifyElementPresent(valueCardTypeElement, 5)
/* We want to verify receipt number*/
WebUI.verifyElementPresent(valueReceiptNumber, 5)
/* We want to verify name of receive the card*/
WebUI.verifyElementPresent(valueNameReceiveCardElement, 5)
/* We want to verify phone number of receive the card*/
WebUI.verifyElementPresent(valuePhoneNumberReceiveCardElement, 5)
/* We want to verify photo of receive the card*/
WebUI.verifyElementPresent(imageOfReceiveNumber, 5)
/* We want to get text from info in Riwayat History*/
def textShippingHistory = WebUI.getText(headerTextShippingHistoryElement)
/* We want to verify text shipping history*/
WebUI.verifyElementText(headerTextShippingHistoryElement, textShippingHistory)
/* We want to verify shipping history*/
WebUI.verifyElementPresent(messageFirstRowElement, 5)
/* We want get update after change proses delivery*/
String newFirstRowHistoryShipping = WebUI.getText(messageFirstRowElement)
/* We want to compare before and after message from shipping history*/
WebUI.verifyNotMatch(existFirstRowHistoryShipping, newFirstRowHistoryShipping, false)
/* We want to wait until visible button "kembali"*/
WebUI.verifyElementVisible(btnBackDeliveryStatus)
/* We want verify button back from detail page customer*/
WebUI.verifyElementPresent(btnBackDeliveryStatus, 5)
/* We want capture the detail page*/
WebUI.takeScreenshot()
/* We want to click button back*/
WebUI.click(btnBackDeliveryStatus)
/* We want to wait the element until visible*/
WebUI.waitForElementVisible(menuDeliveryStatusElement, 5)
/* We want to verify we are in delivery status bucket list page*/
WebUI.verifyElementText(headerTextPageElement, "Delivery Status")
/* We want to verify first data loaded in bucket list*/
WebUI.verifyElementPresent(firstColoumnRequestIdElement, 5)
/* We want to refresh the page*/
WebUI.refresh()