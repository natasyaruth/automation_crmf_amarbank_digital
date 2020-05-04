<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>API_getUser</name>
   <tag></tag>
   <elementGuidId>4c3bba94-c38d-4a06-a0da-e0f63f39b78d</elementGuidId>
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
      <name>functionId</name>
      <type>Main</type>
      <value>${functionId}</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>roleId</name>
      <type>Main</type>
      <value>${roleId}</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>searchParam</name>
      <type>Main</type>
      <value>${searchParam}</value>
   </httpHeaderProperties>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>${hostnameCRM}iam/users?page=${page}&amp;size=${size}&amp;functionId=${functionId}&amp;roleId=${roleId}&amp;searchParam=${searchParam}</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <variables>
      <defaultValue>GlobalVariable.hostnameCRM</defaultValue>
      <description></description>
      <id>2876bc41-18ff-41db-9952-47cd8341e9e1</id>
      <masked>false</masked>
      <name>hostnameCRM</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.page</defaultValue>
      <description></description>
      <id>4d52a340-7ff4-4ec6-8d3e-eaa3147d4f59</id>
      <masked>false</masked>
      <name>page</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.size</defaultValue>
      <description></description>
      <id>12b1b1e6-a698-461d-be43-372b204295b3</id>
      <masked>false</masked>
      <name>size</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.functionId</defaultValue>
      <description></description>
      <id>6d22dbb8-f21f-4130-8b52-6b617cd33611</id>
      <masked>false</masked>
      <name>functionId</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.roleId</defaultValue>
      <description></description>
      <id>a4eef72c-e3f0-4e5d-ab0f-bb986b74388a</id>
      <masked>false</masked>
      <name>roleId</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.searchParam</defaultValue>
      <description></description>
      <id>5bccd1e2-e933-4077-a70c-f90e67b0de9e</id>
      <masked>false</masked>
      <name>searchParam</name>
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
