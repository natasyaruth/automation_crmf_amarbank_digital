<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>API_NinjaVanVanEnrouteToPickup</name>
   <tag></tag>
   <elementGuidId>a7f05440-850f-45df-9116-51a6800a3f17</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
      <webElementGuid>9844cbef-6a88-463d-8901-56738c7a0830</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>X-NINJAVAN-HMAC-SHA256</name>
      <type>Main</type>
      <value>${hashNinjaVanVanEnrouteToPickup}</value>
      <webElementGuid>b9b39e0d-bbc2-4293-9e37-f3d232998426</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Basic JHt1c2VybmFtZV93ZWJfYXBpfToke3Bhc3N3b3JkX3dlYl9hcGl9</value>
      <webElementGuid>8712b05e-1c28-4cd5-96af-8e781780986f</webElementGuid>
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
      <id>611973a4-8159-4170-bf1d-95dc313b4afa</id>
      <masked>false</masked>
      <name>base_url_crm_otoku</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.hashNinjaVanVanEnrouteToPickup</defaultValue>
      <description></description>
      <id>abb412d3-eb29-4e8a-bebd-ecfd9b601172</id>
      <masked>false</masked>
      <name>hashNinjaVanVanEnrouteToPickup</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.usernameWebApi</defaultValue>
      <description></description>
      <id>761b1303-97f0-4380-8e32-7531fb18bbfc</id>
      <masked>false</masked>
      <name>username_web_api</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.passwordWebApi</defaultValue>
      <description></description>
      <id>9deb435c-2c23-4499-b476-039690cf58de</id>
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
