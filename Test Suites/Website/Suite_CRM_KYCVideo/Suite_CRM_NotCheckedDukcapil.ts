<?xml version="1.0" encoding="UTF-8"?>
<TestSuiteEntity>
   <description></description>
   <name>Suite_CRM_NotCheckedDukcapil</name>
   <tag></tag>
   <isRerun>false</isRerun>
   <mailRecipient></mailRecipient>
   <numberOfRerun>0</numberOfRerun>
   <pageLoadTimeout>30</pageLoadTimeout>
   <pageLoadTimeoutDefault>true</pageLoadTimeoutDefault>
   <rerunFailedTestCasesOnly>false</rerunFailedTestCasesOnly>
   <testSuiteGuid>6558a006-e064-4dbe-bf1e-79efcd2fb84b</testSuiteGuid>
   <testCaseLink>
      <guid>09be625d-c273-4209-9147-98c22121057d</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/URL/URL_Develop_CRM</testCaseId>
   </testCaseLink>
   <testCaseLink>
      <guid>4369a539-23b0-483c-8bf4-1e8c5921a7dc</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Website/CRM/CRM_Login/TC_Login</testCaseId>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>11ea5d30-67e2-4efd-b3d2-e30d13db743b</id>
         <iterationEntity>
            <iterationType>ALL</iterationType>
            <value></value>
         </iterationEntity>
         <testDataId>Data Files/Website/DataFiles_CRM/Data_CRM_UserLogin</testDataId>
      </testDataLink>
      <variableLink>
         <testDataLinkId>11ea5d30-67e2-4efd-b3d2-e30d13db743b</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Name</value>
         <variableId>b6bfffbb-7c23-4e7d-bfe6-d43896cd6931</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>11ea5d30-67e2-4efd-b3d2-e30d13db743b</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Password</value>
         <variableId>aea27910-c43b-4857-a979-0165ae08cf73</variableId>
      </variableLink>
   </testCaseLink>
   <testCaseLink>
      <guid>fea048fd-040e-4a18-9e7c-dc4aa1a3a836</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Website/CRM/TC_KYCManagement</testCaseId>
   </testCaseLink>
   <testCaseLink>
      <guid>164e421f-ea8c-4d09-9018-9f24c461f895</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Website/CRM/CRM_KYCVideo/TC_KYCVideoNotChecked</testCaseId>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>52266e84-e033-42de-b05b-df32b47c708e</id>
         <iterationEntity>
            <iterationType>RANGE</iterationType>
            <value>2-2</value>
         </iterationEntity>
         <testDataId>Data Files/Website/DataFiles_CRM/Data_CRM_KYCVideo/Data_CRM_HasNotBeenValidated</testDataId>
      </testDataLink>
      <variableLink>
         <testDataLinkId>52266e84-e033-42de-b05b-df32b47c708e</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>SearchKYC</value>
         <variableId>bb669d47-14e3-4cc3-8fad-ef4fad4f7d95</variableId>
      </variableLink>
   </testCaseLink>
</TestSuiteEntity>
