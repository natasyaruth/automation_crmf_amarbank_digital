<?xml version="1.0" encoding="UTF-8"?>
<TestSuiteEntity>
   <description></description>
   <name>Suite_CRM_HaveNotVerifiedEmail</name>
   <tag></tag>
   <isRerun>false</isRerun>
   <mailRecipient></mailRecipient>
   <numberOfRerun>0</numberOfRerun>
   <pageLoadTimeout>30</pageLoadTimeout>
   <pageLoadTimeoutDefault>true</pageLoadTimeoutDefault>
   <rerunFailedTestCasesOnly>false</rerunFailedTestCasesOnly>
   <testSuiteGuid>bf6613ba-c182-4fac-b75b-93e28a2b15c6</testSuiteGuid>
   <testCaseLink>
      <guid>27898ec2-7b71-46df-ac44-d3c9bfe8e8c9</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/URL/URL_CRM</testCaseId>
   </testCaseLink>
   <testCaseLink>
      <guid>fde31a7f-8945-4bcb-9eda-116ae5796f25</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Website/CRM/CRM_Login/TC_Login</testCaseId>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>f6edee0a-4cce-4f46-804c-3c2bd7609ddc</id>
         <iterationEntity>
            <iterationType>ALL</iterationType>
            <value></value>
         </iterationEntity>
         <testDataId>Data Files/Website/DataFiles_CRM/Data_CRM_UserLogin</testDataId>
      </testDataLink>
      <variableLink>
         <testDataLinkId>f6edee0a-4cce-4f46-804c-3c2bd7609ddc</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Name</value>
         <variableId>b6bfffbb-7c23-4e7d-bfe6-d43896cd6931</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>f6edee0a-4cce-4f46-804c-3c2bd7609ddc</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Password</value>
         <variableId>aea27910-c43b-4857-a979-0165ae08cf73</variableId>
      </variableLink>
   </testCaseLink>
   <testCaseLink>
      <guid>fca99305-3b84-4c45-9abb-84a5717507d5</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Website/CRM/TC_KYCManagement</testCaseId>
   </testCaseLink>
   <testCaseLink>
      <guid>5482334a-e45e-4b08-b3c2-71144e2fe22a</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Website/CRM/CRM_KYCVerification/TC_KYCVerificationHaveNotVerifiedEmail</testCaseId>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>640e9dcc-9024-4133-b12e-093da29b24d6</id>
         <iterationEntity>
            <iterationType>RANGE</iterationType>
            <value>5-5</value>
         </iterationEntity>
         <testDataId>Data Files/Website/DataFiles_CRM/Data_CRM_KYCVerification/Data_CRM_Verification</testDataId>
      </testDataLink>
      <variableLink>
         <testDataLinkId>640e9dcc-9024-4133-b12e-093da29b24d6</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>SearchKYC</value>
         <variableId>375423aa-5c00-4dd3-8b55-2f3dadfafc0e</variableId>
      </variableLink>
   </testCaseLink>
</TestSuiteEntity>
