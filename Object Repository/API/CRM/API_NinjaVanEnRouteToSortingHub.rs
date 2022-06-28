<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>API_NinjaVanEnRouteToSortingHub</name>
   <tag></tag>
   <elementGuidId>8471de1b-cc44-4685-b744-0337ee18a230</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\&quot;shipper_id\&quot;: 921,\&quot;status\&quot;: \&quot;On Vehicle for Delivery\&quot;,\&quot;shipper_ref_no\&quot;: \&quot;14943\&quot;,\&quot;tracking_ref_no\&quot;: \&quot;149431\&quot;,\&quot;shipper_order_ref_no\&quot;: \&quot;8374\&quot;,\&quot;timestamp\&quot;: \&quot;2017-04-03T11:50:44+0800\&quot;,\&quot;id\&quot;: \&quot;3b7327b9-54bf-417f-3104-f4e155a22308\&quot;,\&quot;previous_status\&quot;: \&quot;Van En-route to Pickup\&quot;,\&quot;tracking_id\&quot;: \&quot;AMAR-10000562\&quot;,\&quot;comments\&quot;: \&quot;SG-Singapore-Ninja Van Sorting Facility\&quot;}&quot;,
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
      <webElementGuid>18a3d563-b8ba-4fd2-b41a-44188c6b7d15</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>X-NINJAVAN-HMAC-SHA256</name>
      <type>Main</type>
      <value>${hmacSHA256}</value>
      <webElementGuid>59e32e36-01f9-4511-afb4-e7e8c3c562a9</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Basic JHt1c2VybmFtZV93ZWJfYXBpfToke3Bhc3N3b3JkX3dlYl9hcGl9</value>
      <webElementGuid>1e9283b9-bf9b-49ef-bf77-cc6dd5694c61</webElementGuid>
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
      <defaultValue>GlobalVariable.baseUrlRegOtoku</defaultValue>
      <description></description>
      <id>611973a4-8159-4170-bf1d-95dc313b4afa</id>
      <masked>false</masked>
      <name>base_url_crm_otoku</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.usernameWebApi</defaultValue>
      <description></description>
      <id>31d16e9d-40b4-44cf-948a-c1249d3b0c0c</id>
      <masked>false</masked>
      <name>username</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.passwordWebApi</defaultValue>
      <description></description>
      <id>42d34aef-ebb8-4e30-af8d-8278aea6aaad</id>
      <masked>false</masked>
      <name>password</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.hashNinjaVanEnRouteToSortingHub</defaultValue>
      <description></description>
      <id>cc78b496-30a5-4924-bcdb-bb38822b35a4</id>
      <masked>false</masked>
      <name>hmacSHA256</name>
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



assertThat(response.getStatusCode()).isIn(Arrays.asList(200, 201, 202))


ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()


assertThat(response.getResponseText()).isEqualTo(&quot;Katalon Test Project&quot;)


def variables = request.getVariables()
def variable = variables.get('yourVariableName')


assertThat(response.getResponseText()).contains('Katalon Test Project')</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
