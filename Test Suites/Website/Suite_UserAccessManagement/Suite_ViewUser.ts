<?xml version="1.0" encoding="UTF-8"?>
<TestSuiteEntity>
   <description></description>
   <name>Suite_ViewUser</name>
   <tag></tag>
   <isRerun>false</isRerun>
   <mailRecipient></mailRecipient>
   <numberOfRerun>0</numberOfRerun>
   <pageLoadTimeout>30</pageLoadTimeout>
   <pageLoadTimeoutDefault>true</pageLoadTimeoutDefault>
   <rerunFailedTestCasesOnly>false</rerunFailedTestCasesOnly>
   <testSuiteGuid>25222da2-21dc-412f-ae9d-7525bcb7810b</testSuiteGuid>
   <testCaseLink>
      <guid>41875f1a-a296-4144-b6ea-ac92231b7de2</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/URL/URL_Develop_CRM</testCaseId>
   </testCaseLink>
   <testCaseLink>
      <guid>b34c9c85-1b16-46f5-b186-79ce39d93da2</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Website/CRM/CRM_Login/TC_Login</testCaseId>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>76a9aaea-130d-460f-91bf-d7353092cf0d</id>
         <iterationEntity>
            <iterationType>RANGE</iterationType>
            <value>1-1</value>
         </iterationEntity>
         <testDataId>Data Files/Website/DataFiles_CRM/Data_CRM_UserLogin</testDataId>
      </testDataLink>
      <variableLink>
         <testDataLinkId>76a9aaea-130d-460f-91bf-d7353092cf0d</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Name</value>
         <variableId>b6bfffbb-7c23-4e7d-bfe6-d43896cd6931</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>76a9aaea-130d-460f-91bf-d7353092cf0d</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Password</value>
         <variableId>aea27910-c43b-4857-a979-0165ae08cf73</variableId>
      </variableLink>
   </testCaseLink>
   <testCaseLink>
      <guid>76276609-61d2-463c-b918-c172b6b1d31e</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Website/CRM/TC_IAManagement</testCaseId>
   </testCaseLink>
   <testCaseLink>
      <guid>5b6a6529-f452-42b1-b66e-bc61cc2c5fac</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Website/CRM/CRM_UserAccessManagement/TC_ViewUser</testCaseId>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>c5c8f50a-3ef5-4c72-b7de-34cef99fc242</id>
         <iterationEntity>
            <iterationType>ALL</iterationType>
            <value></value>
         </iterationEntity>
         <testDataId>Data Files/Website/DataFiles_CRM/Data_UserAccessManagement</testDataId>
      </testDataLink>
      <variableLink>
         <testDataLinkId>c5c8f50a-3ef5-4c72-b7de-34cef99fc242</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>RoleAccess</value>
         <variableId>c406987c-07cf-4211-a189-7320af62307c</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>c5c8f50a-3ef5-4c72-b7de-34cef99fc242</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Function</value>
         <variableId>27c62f3d-0976-4e73-b775-79647b6c93d1</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>c5c8f50a-3ef5-4c72-b7de-34cef99fc242</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>OfficerName</value>
         <variableId>76e0c67f-f8a9-4d72-9edd-4e6c9ca42c9b</variableId>
      </variableLink>
   </testCaseLink>
</TestSuiteEntity>
