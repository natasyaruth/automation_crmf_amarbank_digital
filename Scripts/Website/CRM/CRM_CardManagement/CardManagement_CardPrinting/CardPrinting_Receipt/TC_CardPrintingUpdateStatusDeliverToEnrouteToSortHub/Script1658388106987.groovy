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

/* We want to makesure we can identify element assign card*/
if (WebUI.verifyElementVisible(menuCardPrintingElement, FailureHandling.OPTIONAL)) {
	/* We want to wait the element visible*/
	WebUI.waitForElementVisible(menuCardPrintingElement, 5)	
	/* We want to click menu assign card element*/
	WebUI.click(menuCardPrintingElement)
	/* We want to wait until text is present*/
	WebUI.waitForElementVisible(headerCardPrintingPage, 5)
	/* We want verify header page of card printing*/
	WebUI.verifyElementText(headerCardPrintingPage, "Card Printing")
} else {
	/* We want to wait for element is visible*/
	WebUI.waitForElementVisible(menuCardManagementElement, 5)	
	/* We want to verify menu card management element*/
	WebUI.verifyElementPresent(menuCardManagementElement, 5)
	/* We want to click menu card management to exand sub menu*/
	WebUI.click(menuCardManagementElement)
	/* We want to wait the element is visible*/
	WebUI.waitForElementVisible(menuCardPrintingElement, 5)	
	/* We want to verify menu assign card element*/
	WebUI.verifyElementPresent(menuCardPrintingElement, 5)
	/* We want to click menu assign card element*/
	WebUI.click(menuCardPrintingElement)
	/* We want to wait until text is present*/
	WebUI.waitForElementVisible(headerCardPrintingPage, 5)
	/* We want verify header page of card printing*/
	WebUI.verifyElementText(headerCardPrintingPage, "Card Printing")
}
/* We want to wait until tab "Resi" visible*/
WebUI.waitForElementVisible(tabReprint, 5)
/* We want to verify element "Resi"*/
WebUI.waitForElementPresent(tabReprint, 5)
/* We want to click the element "Resi"*/
WebUI.click(tabReprint)
/* We want to wait for visible element first "request id"*/
WebUI.waitForElementVisible(firstReqIdElement, 5)
/* We want to get text from first request ID*/
String requestId = WebUI.getText(firstReqIdElement)
println(requestId)
/*--------------------------------------------------------------------------------------*/
/* We want to process from Page cetak ulang to delivery status*/
for (int i=0;i<2;i++) {
/* We want to set API testing for enroute route ninja*/
String body = '{"shipper_id": 921,"status": "'+listStatus.get(i)+'","shipper_ref_no": "10001253","tracking_ref_no": "10001253","shipper_order_ref_no": "8374","timestamp": "2017-04-03T11:50:44+0800","id": "3b7327b9-54bf-417f-3104-f4e155a22308","previous_status": "Pending Pickup","tracking_id": "AMAR-'+requestId+'","comments": "SG-Singapore-Ninja Van Sorting Facility"}'
/* We want to encrypt the body with SHA256*/
hashNinjaVanEnRouteToSortingHub = SecureUtils.hmac_sha256("cf47ca4e44844cb987eb0577530a12a0",body.toString())
/* We want to store to global variable*/
GlobalVariable.hashNinjaVanEnRouteToSortingHub = hashNinjaVanEnRouteToSortingHub
/* We want to prepare the http request*/
def request = ((findTestObject('API/CRM/API_NinjaVanEnRouteToSortingHub', [('base_url_crm_otoku') : GlobalVariable.baseUrlRegOtoku, ('username') : GlobalVariable.usernameWebApi, ('password') : GlobalVariable.passwordWebApi, ('X-NINJAVAN-HMAC-SHA256') : hashNinjaVanEnRouteToSortingHub])) as RequestObject)
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
}
/*--------------------------------------------------------------------------------------*/
/* We want to set delay for waiting the process API Service*/
WebUI.delay(10)
/* We want to refresh page*/
WebUI.refresh()
/* We want to makesure we on delivery status*/
if (WebUI.waitForElementVisible(menuDeliveryStatus, 5,  FailureHandling.OPTIONAL)) {
	/* We want to click menu delivery status*/	
	WebUI.click(menuDeliveryStatus)
	/* We want makesure we are on the delivery status page*/	
	WebUI.verifyElementText(headerDeliveryStatus, "Delivery Status")
} else {
	/* We want to wait for element is visible*/
	WebUI.waitForElementVisible(menuCardManagementElement, 5)
	/* We want to verify menu card management element*/
	WebUI.verifyElementPresent(menuCardManagementElement, 5)
	/* We want to click menu card management to exand sub menu*/
	WebUI.click(menuCardManagementElement)
	/* We want to wait until visible menu delivery status*/
	WebUI.verifyElementVisible(menuDeliveryStatus, 5)
	/* We want to click menu delivery status*/
	WebUI.click(menuDeliveryStatus)
	/* We want makesure we are on the delivery status page*/
	WebUI.verifyElementText(headerDeliveryStatus, "Delivery Status")
}
/* We want to wait until visible input field request ID*/
WebUI.waitForElementVisible(fieldFindReqId, 5)
/* We want to input field request ID*/
WebUI.setText(fieldFindReqId, requestId)
/* We want to click the button search*/
WebUI.click(btnSearchReqId)
/* We want to wait for element visible for the first row*/
WebUI.waitForElementVisible(firstRowReqId, 5)
/* We want to verify the same request ID*/
WebUI.verifyElementText(firstRowReqId, requestId)
/* We want capture*/
WebUI.takeScreenshot()
/* We want to click the first row*/
WebUI.click(firstRowReqId)
/* We want to makesure we are in delivery detail*/
WebUI.waitForElementVisible(headerDeliveryDetail, 5)
/* We want to check the page by text*/
WebUI.verifyElementText(headerDeliveryDetail, "Delivery Detail")
/* We want to check the coloumn history tracking*/
WebUI.verifyElementText(headerHistoryTracking, "Riwayat Kiriman")
/* We want to check first row shipping history*/
WebUI.verifyElementText(firstRowShippingHistory, "Dalam perjalanan ke gudang Penyortiran")
/* We want to capture*/
WebUI.takeScreenshot()
/* We want click back to bucket list delivery status page*/
WebUI.click(btnBackToDelveryPage)
/* We want makesure we are on the delivery status page*/
WebUI.verifyElementText(headerDeliveryStatus, "Delivery Status")
/* We want refresh page*/
WebUI.refresh()
