import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable
import com.tunaiku.keyword.RandomData as RandomData

contact_address = RandomData.randomDoubleFunc(12)

//body

String body =
'{"contact_address": "+628'+ contact_address +
'"}'

System.out.println(body)

//prepare the http request
def request = (RequestObject) findTestObject('API/API_phoneNumberWhiteList')
request.setBodyContent(new HttpTextBodyContent(body, "UTF-8", "application/json"))

def response = WS.sendRequest(request)

//get response
def body_content = response.responseBodyContent
def status_code = response.statusCode

println (body_content)
println (status_code)

def respDataMap = new JsonSlurper().parseText(body_content)

GlobalVariable.phoneNumber = "08"+contact_address
GlobalVariable.deleteApplicant = "+628"+contact_address