import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

String Card = hasCard

if (Card == 'No') {
    WebUI.click(findTestObject('Object Repository/Website/Reactivate_Account_2/RbTidakKartu'))

    WebUI.click(findTestObject('Object Repository/Website/Reactivate_Account_2/BtnUbahAlamat'))

    WebUI.setText(findTestObject('Website/Change Delivery Address/TxtAlamatLengkap'), alamatLengkap)

    WebUI.setText(findTestObject('Website/Change Delivery Address/TxtRT'), RT)

    WebUI.setText(findTestObject('Website/Change Delivery Address/TxtRW'), RW)

    WebUI.selectOptionByLabel(findTestObject('Website/Change Delivery Address/DrpProvinsi'), Provinsi, false)

    WebUI.selectOptionByLabel(findTestObject('Website/Change Delivery Address/DrpKabupatenKota'), Kabupaten, false)

    WebUI.selectOptionByLabel(findTestObject('Website/Change Delivery Address/DrpKecamatan'), Kecamatan, false)

    WebUI.selectOptionByLabel(findTestObject('Website/Change Delivery Address/DrpKelurahan'), Kelurahan, false)

    WebUI.click(findTestObject('Website/Change Delivery Address/BtnSimpan'))
} 

else {
    WebUI.click(findTestObject('Website/Reactivate_Account_2/RbYaKartu'))
}

String ChangePhone = changePhone

if (ChangePhone == 'Yes') {
    WebUI.click(findTestObject('Website/Reactivate_Account_2/RbYaUbahHp'))

    WebUI.setText(findTestObject('Object Repository/Website/Reactivate_Account_2/TxtNoHpBaru'), noHPBaru)
} else {
    WebUI.click(findTestObject('Object Repository/Website/Reactivate_Account_2/RbTidakUbahHp'))
}

CustomKeywords.'com.tunaiku.customkeyword.ClickUsingJS.clickUsingJS'(findTestObject('Object Repository/Website/Reactivate_Account_2/BtnKirim'), 
    5)

