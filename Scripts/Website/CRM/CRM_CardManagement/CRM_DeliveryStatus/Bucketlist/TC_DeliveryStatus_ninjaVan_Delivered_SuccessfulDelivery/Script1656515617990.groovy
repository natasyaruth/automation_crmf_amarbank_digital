import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import com.kms.katalon.core.testobject.TestObjectProperty as TestObjectProperty
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent as HttpTextBodyContent
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.google.gson.JsonObject as JsonObject
import groovy.json.JsonSlurper as JsonSlurper
import com.tunaiku.keyword.SecureUtils as SecureUtils
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import static org.assertj.core.api.Assertions.*
import com.kms.katalon.core.testobject.RequestObject

/* We want to get request id name from the first data*/
def tracking_id = WebUI.getText(RequestID, FailureHandling.STOP_ON_FAILURE)

WebUI.delay(10)

/* We want to set API testing for enroute route ninja*/
String body = '{"shipper_id":921,"status":"'+ status_success +'","previous_status": "'+ previous_status_success +'","shipper_order_ref_no": "8374","timestamp": "2017-04-03T11:50:44+0800","order_id":"3b7327b9-54bf-417f-3104-f4e134ed22308","tracking_id": "AMAR-'+ tracking_id +'","pod":{"type": "SUBSTITUTE","name": "'+ name +'","identity_number": "XX","contact": "'+ contact +'","uri": "'+ imagedelivered +'","left_in_safe_place": false}}'
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
println(body_content)
def status_code = response.statusCode

/* We want parse response from API process*/
def respDataMap = new JsonSlurper().parseText(body_content)

/* We just check by log*/
println(body_content)

/* We just check by log*/
println(status_code)

/* We want to assert the status code is 200*/
assertThat(response.getStatusCode()).isEqualTo(200)

WebUI.delay(10)