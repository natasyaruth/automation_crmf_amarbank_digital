<?xml version="1.0" encoding="UTF-8"?>
<TestSuiteEntity>
   <description></description>
   <name>Suite_EditUser</name>
   <tag></tag>
   <isRerun>false</isRerun>
   <mailRecipient></mailRecipient>
   <numberOfRerun>0</numberOfRerun>
   <pageLoadTimeout>30</pageLoadTimeout>
   <pageLoadTimeoutDefault>true</pageLoadTimeoutDefault>
   <rerunFailedTestCasesOnly>false</rerunFailedTestCasesOnly>
   <testSuiteGuid>b7d97660-6eea-4c3c-8f54-f420ea0c1b69</testSuiteGuid>
   <testCaseLink>
      <guid>eac25a39-065a-40f1-8403-a7e3eb9fe441</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/URL/URL_Develop_CRM</testCaseId>
   </testCaseLink>
   <testCaseLink>
      <guid>2cb3a3d4-de23-414e-a1ed-df43fe9249c3</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Website/CRM/CRM_Login/TC_Login</testCaseId>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>4b0ffd51-500e-45a6-a8f4-0dd622996ddc</id>
         <iterationEntity>
            <iterationType>RANGE</iterationType>
            <value>1-1</value>
         </iterationEntity>
         <testDataId>Data Files/Website/DataFiles_CRM/Data_CRM_UserLogin</testDataId>
      </testDataLink>
      <variableLink>
         <testDataLinkId>4b0ffd51-500e-45a6-a8f4-0dd622996ddc</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Name</value>
         <variableId>b6bfffbb-7c23-4e7d-bfe6-d43896cd6931</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>4b0ffd51-500e-45a6-a8f4-0dd622996ddc</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Password</value>
         <variableId>aea27910-c43b-4857-a979-0165ae08cf73</variableId>
      </variableLink>
   </testCaseLink>
   <testCaseLink>
      <guid>5d23bf7a-e30a-4dfb-98e3-1b81cae0be3f</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Website/CRM/TC_IAManagement</testCaseId>
   </testCaseLink>
   <testCaseLink>
      <guid>1fd65cd6-2a35-49bb-86ab-8d0d6bf5e564</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Website/CRM/CRM_UserAccessManagement/TC_EditUser</testCaseId>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>b877939d-650e-4de4-9a74-03a78d93553f</id>
         <iterationEntity>
            <iterationType>RANGE</iterationType>
            <value>2-2</value>
         </iterationEntity>
         <testDataId>Data Files/Website/DataFiles_CRM/Data_UserAccessManagement</testDataId>
      </testDataLink>
      <variableLink>
         <testDataLinkId>b877939d-650e-4de4-9a74-03a78d93553f</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>SearchUsername</value>
         <variableId>bc7e3f47-f2c5-4dba-86a9-337efd90a547</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>b877939d-650e-4de4-9a74-03a78d93553f</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>OfficeEmail</value>
         <variableId>26239c57-2056-4283-a3f8-9ee7aba0ca03</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>b877939d-650e-4de4-9a74-03a78d93553f</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Function</value>
         <variableId>8711bf8d-2e19-40fe-b0f8-dba73e6d29a4</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>b877939d-650e-4de4-9a74-03a78d93553f</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>New Password</value>
         <variableId>c130481a-c3a5-40e2-9525-fe1e361cd3c9</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>b877939d-650e-4de4-9a74-03a78d93553f</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>ConfirmPassword</value>
         <variableId>dbd32167-0f6b-4df6-a62a-0ac8411e00bf</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>b877939d-650e-4de4-9a74-03a78d93553f</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>RoleAccess</value>
         <variableId>7cada8fb-b1ff-41c5-8399-1fdbdede4613</variableId>
      </variableLink>
   </testCaseLink>
</TestSuiteEntity>
