<?xml version="1.0" encoding="UTF-8"?>
<TestSuiteEntity>
   <description></description>
   <name>Suite_ViewRole</name>
   <tag></tag>
   <isRerun>false</isRerun>
   <mailRecipient></mailRecipient>
   <numberOfRerun>0</numberOfRerun>
   <pageLoadTimeout>30</pageLoadTimeout>
   <pageLoadTimeoutDefault>true</pageLoadTimeoutDefault>
   <rerunFailedTestCasesOnly>false</rerunFailedTestCasesOnly>
   <testSuiteGuid>45db0d5e-6091-42a8-8a28-318e03acd6ce</testSuiteGuid>
   <testCaseLink>
      <guid>2d29739c-dcc4-48f0-a62b-24d310500040</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/URL/URL_CRM</testCaseId>
   </testCaseLink>
   <testCaseLink>
      <guid>fea3b3b0-1fb3-4245-b8a2-b5f3aa2217d3</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Website/CRM/CRM_Login/TC_Login</testCaseId>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>c09968fc-2d1e-4ea1-8276-279c57beb71f</id>
         <iterationEntity>
            <iterationType>ALL</iterationType>
            <value>3-3</value>
         </iterationEntity>
         <testDataId>Data Files/Website/DataFiles_CRM/Data_CRM_UserLogin</testDataId>
      </testDataLink>
      <variableLink>
         <testDataLinkId>c09968fc-2d1e-4ea1-8276-279c57beb71f</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Name</value>
         <variableId>b6bfffbb-7c23-4e7d-bfe6-d43896cd6931</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>c09968fc-2d1e-4ea1-8276-279c57beb71f</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Password</value>
         <variableId>aea27910-c43b-4857-a979-0165ae08cf73</variableId>
      </variableLink>
   </testCaseLink>
   <testCaseLink>
      <guid>d2254233-be26-4450-bb09-22adce1c4575</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Website/CRM/TC_IAManagement</testCaseId>
   </testCaseLink>
   <testCaseLink>
      <guid>a4cd6a1b-c5ee-4714-bfb6-eaa432d80075</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Website/CRM/CRM_RoleAccessManagement/ViewRole</testCaseId>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>30ba7af0-1eed-4c4b-b3c1-da4c2b68965d</id>
         <iterationEntity>
            <iterationType>RANGE</iterationType>
            <value>2-2</value>
         </iterationEntity>
         <testDataId>Data Files/Website/DataFiles_CRM/Data_RoleAccessManagement</testDataId>
      </testDataLink>
      <variableLink>
         <testDataLinkId>30ba7af0-1eed-4c4b-b3c1-da4c2b68965d</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>RoleName</value>
         <variableId>2fc8c234-2d9d-42c5-b79e-d4faf7d85444</variableId>
      </variableLink>
   </testCaseLink>
</TestSuiteEntity>
