<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>API_NinjaVanPickupFailed</name>
   <tag></tag>
   <elementGuidId>12f23dfe-d21f-4762-b35a-53857fcc16fa</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent></httpBodyContent>
   <httpBodyType></httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
      <webElementGuid>5c8f4f1d-36f3-4e4e-93f8-3901843b9071</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>X-NINJAVAN-HMAC-SHA256</name>
      <type>Main</type>
      <value>${hashNinjaVanPickupFailed}</value>
      <webElementGuid>256fae0b-9bef-4739-894e-ecc48b167366</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Basic JHt1c2VybmFtZV93ZWJfYXBpfToke3Bhc3N3b3JkX3dlYl9hcGl9</value>
      <webElementGuid>517ed267-a532-4632-83ba-d0dbb566fb6c</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.3.5</katalonVersion>
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
      <defaultValue>GlobalVariable.baseUrlRegOtoku</defaultValue>
      <description></description>
      <id>13ae1d63-c440-4d1f-8f25-e5647b010709</id>
      <masked>false</masked>
      <name>base_url_crm_otoku</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.hashNinjaVanPickupFailed</defaultValue>
      <description></description>
      <id>2717853b-57db-4e9d-860e-ab3efbcb356c</id>
      <masked>false</masked>
      <name>hashNinjaVanPickupFailed</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.usernameWebApi</defaultValue>
      <description></description>
      <id>4527d68b-48c1-4b32-af8d-ec6d40bad4a7</id>
      <masked>false</masked>
      <name>username_web_api</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.passwordWebApi</defaultValue>
      <description></description>
      <id>448d9307-de1c-4fcd-9546-f6632836e7b2</id>
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

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
