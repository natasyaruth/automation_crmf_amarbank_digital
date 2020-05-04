<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>API_getRole</name>
   <tag></tag>
   <elementGuidId>07a1457b-d4cc-4297-bb6c-8d80bf54c7c1</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
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
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>page</name>
      <type>Main</type>
      <value>${page}</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>size</name>
      <type>Main</type>
      <value>${size}</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>rolename</name>
      <type>Main</type>
      <value>${rolename}</value>
   </httpHeaderProperties>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>${hostnameCRM}iam/roles?page=${page}&amp;size=${size}&amp;rolename=${rolename}</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <variables>
      <defaultValue>GlobalVariable.hostnameCRM</defaultValue>
      <description></description>
      <id>60205d4e-1e6d-4a5f-9fe1-9cf1956320ca</id>
      <masked>false</masked>
      <name>hostnameCRM</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.page</defaultValue>
      <description></description>
      <id>a58cb4eb-5057-4df8-9844-39d31df62ae6</id>
      <masked>false</masked>
      <name>page</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.size</defaultValue>
      <description></description>
      <id>8fe46daa-f9db-4083-a534-73807d4554e9</id>
      <masked>false</masked>
      <name>size</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.rolename</defaultValue>
      <description></description>
      <id>f86099a1-11f1-4a9d-9a7d-d6d52f333a5c</id>
      <masked>false</masked>
      <name>rolename</name>
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
