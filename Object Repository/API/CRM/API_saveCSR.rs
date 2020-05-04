<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>API_saveCSR</name>
   <tag></tag>
   <elementGuidId>d698e869-41c0-4fcc-a30a-41c09199af9e</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
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
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>sectionType</name>
      <type>Main</type>
      <value>${sectionType}</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>customerType</name>
      <type>Main</type>
      <value>${customerType}</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>customerId</name>
      <type>Main</type>
      <value>${customerId}</value>
   </httpHeaderProperties>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${hostnameCRM}csr/save/${sectionType}/${customerType}/${customerId}</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <variables>
      <defaultValue>GlobalVariable.hostnameCRM</defaultValue>
      <description></description>
      <id>e4858d34-b2ba-4e85-aa46-e4b7297e1954</id>
      <masked>false</masked>
      <name>hostnameCRM</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.sectionType</defaultValue>
      <description></description>
      <id>62849d58-af47-40f3-870a-2842ec527197</id>
      <masked>false</masked>
      <name>sectionType</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.customerType</defaultValue>
      <description></description>
      <id>6e71b4e6-73a7-4fb9-8eab-5c2e7e0dafb6</id>
      <masked>false</masked>
      <name>customerType</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.customerId</defaultValue>
      <description></description>
      <id>183fefca-e499-49e7-b5c7-d4c4d35004c8</id>
      <masked>false</masked>
      <name>customerId</name>
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
