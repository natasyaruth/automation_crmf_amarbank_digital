<?xml version="1.0" encoding="UTF-8"?>
<TestSuiteEntity>
   <description></description>
   <name>Suite_CRM_KYCVerification</name>
   <tag></tag>
   <isRerun>false</isRerun>
   <mailRecipient></mailRecipient>
   <numberOfRerun>0</numberOfRerun>
   <pageLoadTimeout>30</pageLoadTimeout>
   <pageLoadTimeoutDefault>true</pageLoadTimeoutDefault>
   <rerunFailedTestCasesOnly>false</rerunFailedTestCasesOnly>
   <testSuiteGuid>fa66ccfe-6b24-4770-bdb7-dd48143519fe</testSuiteGuid>
   <testCaseLink>
      <guid>8017dba9-fd58-458c-ac38-b685a26997c4</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/URL/URL_CRM</testCaseId>
   </testCaseLink>
   <testCaseLink>
      <guid>2bfe7390-3cf9-4547-a848-054001d4d513</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Website/CRM/CRM_Login/TC_Login</testCaseId>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>69ddb996-7b89-4d1d-afb6-e5f53b50e0d2</id>
         <iterationEntity>
            <iterationType>ALL</iterationType>
            <value>5-5</value>
         </iterationEntity>
         <testDataId>Data Files/Website/DataFiles_CRM/Data_CRM_UserLogin</testDataId>
      </testDataLink>
      <variableLink>
         <testDataLinkId>69ddb996-7b89-4d1d-afb6-e5f53b50e0d2</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Name</value>
         <variableId>b6bfffbb-7c23-4e7d-bfe6-d43896cd6931</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>69ddb996-7b89-4d1d-afb6-e5f53b50e0d2</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Password</value>
         <variableId>aea27910-c43b-4857-a979-0165ae08cf73</variableId>
      </variableLink>
   </testCaseLink>
   <testCaseLink>
      <guid>330e5900-51d7-4687-b6dc-ce1ca2168716</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Website/CRM/TC_KYCManagement</testCaseId>
   </testCaseLink>
   <testCaseLink>
      <guid>d31c81ca-f1c2-43d2-a183-1a476e44dc41</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Website/CRM/CRM_KYCVerification/TC_KYCVerificationRegist</testCaseId>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>6e85693e-8785-411a-8266-76e4621b5e12</id>
         <iterationEntity>
            <iterationType>RANGE</iterationType>
            <value>5-5</value>
         </iterationEntity>
         <testDataId>Data Files/Website/DataFiles_CRM/Data_CRM_KYCVerification/Data_CRM_Verification</testDataId>
      </testDataLink>
      <variableLink>
         <testDataLinkId>6e85693e-8785-411a-8266-76e4621b5e12</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>SearchKYC</value>
         <variableId>3ebd2d6a-c485-46a8-a229-47e5121f5fb7</variableId>
      </variableLink>
   </testCaseLink>
</TestSuiteEntity>
