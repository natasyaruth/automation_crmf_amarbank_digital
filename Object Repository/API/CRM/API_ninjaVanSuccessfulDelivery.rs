<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>API_ninjaVanSuccessfulDelivery</name>
   <tag></tag>
   <elementGuidId>62bdbb15-5952-4236-b8dc-9a037f5a9713</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;&quot;,
  &quot;contentType&quot;: &quot;text/plain&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
      <webElementGuid>388523fc-36c4-4e45-bc12-b95c0e84d2fb</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>X-NINJAVAN-HMAC-SHA256</name>
      <type>Main</type>
      <value>${hashNinjaVanSuccessfulDelivery}</value>
      <webElementGuid>f5f447f0-c16f-464f-bdd5-f2de9f07fdc6</webElementGuid>
   </httpHeaderProperties>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${base_url_crm_otoku}/card/webhook</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>GlobalVariable.hostnameCRM</defaultValue>
      <description></description>
      <id>04264be9-85fe-4b88-8de1-0096ec2caab2</id>
      <masked>false</masked>
      <name>base_url_crm_otoku</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.hashNinjaVanSuccessfulDelivery</defaultValue>
      <description></description>
      <id>1878892c-cf6f-4fbc-ba91-ac9e4d14c932</id>
      <masked>false</masked>
      <name>hashNinjaVanSuccessfulDelivery</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.usernameWebApi</defaultValue>
      <description></description>
      <id>02f1bf11-08c2-46cf-9c0b-f626daa004d3</id>
      <masked>false</masked>
      <name>username_web_api</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.passwordWebApi</defaultValue>
      <description></description>
      <id>7c012826-0ff6-4281-b188-5b3e5baec24c</id>
      <masked>false</masked>
      <name>password_web_api</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
