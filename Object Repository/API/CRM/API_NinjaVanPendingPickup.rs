<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>API_NinjaVanPendingPickup</name>
   <tag></tag>
   <elementGuidId>18641eeb-1537-46c3-a356-1cfcc3034b33</elementGuidId>
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
      <name>Authorization</name>
      <type>Main</type>
      <value>Basic JHt1c2VybmFtZV93ZWJfYXBpfToke3Bhc3N3b3JkX3dlYl9hcGl9</value>
      <webElementGuid>b4da7da5-dc23-4881-aa51-5e8126a2f810</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
      <webElementGuid>9e316593-0190-483b-b7f8-50a43ae5ec98</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>X-NINJAVAN-HMAC-SHA256</name>
      <type>Main</type>
      <value>${hashNinjaVanPendingPickup}</value>
      <webElementGuid>f787ad65-7afd-4c35-b828-8644069aeb95</webElementGuid>
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
      <defaultValue>GlobalVariable.hostnameCRM</defaultValue>
      <description></description>
      <id>3991c4e2-b9d2-4561-972d-e01701aacbcb</id>
      <masked>false</masked>
      <name>base_url_crm_otoku</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.hashNinjaVanPendingPickup</defaultValue>
      <description></description>
      <id>ad250c20-4836-4379-b1cf-72d75a5b0fa1</id>
      <masked>false</masked>
      <name>hashNinjaVanPendingPickup</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.usernameWebApi</defaultValue>
      <description></description>
      <id>3ab18f9e-74d8-479e-b406-3c12d7732224</id>
      <masked>false</masked>
      <name>username_web_api</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.passwordWebApi</defaultValue>
      <description></description>
      <id>c3d41509-39e2-4822-9695-7188942b6210</id>
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
