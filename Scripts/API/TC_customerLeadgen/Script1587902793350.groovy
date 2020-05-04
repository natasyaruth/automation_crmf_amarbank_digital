import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import groovy.json.JsonSlurper as JsonSlurper
import internal.GlobalVariable as GlobalVariable
import com.tunaiku.keyword.RandomData as RandomData

mobilePhoneNumber = RandomData.randomDoubleFunc(12)
pin = RandomData.randomDoubleFunc(14)
//body

String body =
'{"mobilePhoneNumber": "+628'+ mobilePhoneNumber +
'","pin": "32'+ pin +
'","firstName": "'+ firstName +
'","lastName": "'+ lastName +
'","emailAddress": "'+ emailAddress +
'","maritalStatusType": "'+ maritalStatusType +
'","religion": "'+ religion +
'","birthCity": "'+ birthCity +
'","dateOfBirth": "'+ dateOfBirth +
'","gender": "'+ gender +
'","educationType": "'+ educationType +
'","motherName": "'+ motherName +
'","income": {"jobType": "'+ jobType +
'","WorkPosition": "'+ WorkPosition +
'","monthlyIncome": '+ monthlyIncome +
',"employerName": "'+ employerName +
'"},"domicile": {"province": "'+ province +
'","city": "'+ city +
'","district": "'+ district +
'","village": "'+ village +
'","postalCode": "'+ postalCode +
'","rt": "'+ rt +
'","rw": "'+ rw +
'","street": "'+ street +
'","flatNumber": "'+ flatNumber +
'","buildingNumber": "'+ buildingNumber +
'","buildingType": "'+ buildingType +
'"},"contactAddress": {"province": "'+ provinceCA +
'","city": "'+ cityCA +
'","district": "'+ districtCA +
'","village": "'+ villageCA +
'","postalCode": "'+ postalCodeCA +
'","rt": "'+ rtCA +
'","rw": "'+ rwCA +
'","street": "'+ streetCA +
'","flatNumber": "'+ flatNumberCA +
'","buildingNumber": "'+ buildingNumberCA +
'","buildingType": "'+ buildingTypeCA +
'"},"personalReference": {"name": "'+ name +
'","mobilePhone": "'+ mobilePhone +
'"},"utm": {"source": "'+ source +
'","medium": "'+ medium +
'","campaign": "'+ campaign +
'","content": "'+ content +
'","terms": "'+ terms +
'"}}'

System.out.println(body)

def request = (RequestObject) findTestObject('Object Repository/API/API_customerLeadgen')
request.setBodyContent(new HttpTextBodyContent(body, "UTF-8", "application/json"))

println (request.getRestUrl())

def response = WS.sendRequest(request)

//get response
def status = response.getResponseText()

String jsonStringRequestID = status
JsonSlurper slurperRequestID = new JsonSlurper()
Object result = slurperRequestID.parseText(jsonStringRequestID) //fungsi Object untuk memisahkan parameter menjadi objek 1 dan 2.

Map jsonResult = ((result) as Map)
Integer json_requestid = ((jsonResult.get('Data').get('requestid')) as Integer)
String requestid = Integer.toString(json_requestid) ////convert dari integer ke string untuk tambah tanda ""

println('requestid:'+ requestid)

GlobalVariable.requestId = requestid