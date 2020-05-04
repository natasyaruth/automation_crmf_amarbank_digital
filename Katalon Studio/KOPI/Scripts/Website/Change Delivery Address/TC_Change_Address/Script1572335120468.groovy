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

WebUI.setText(findTestObject('Website/Change Delivery Address/TxtAlamatLengkap'), alamatLengkap)

WebUI.setText(findTestObject('Website/Change Delivery Address/TxtRT'), RT)

WebUI.setText(findTestObject('Website/Change Delivery Address/TxtRW'), RW)

WebUI.selectOptionByValue(findTestObject('Website/Change Delivery Address/DrpProvinsi'), Provinsi, false)

WebUI.selectOptionByValue(findTestObject('Website/Change Delivery Address/DrpKabupatenKota'), Kabupaten, false)

WebUI.selectOptionByValue(findTestObject('Website/Change Delivery Address/DrpKecamatan'), Kecamatan, false)

WebUI.selectOptionByValue(findTestObject('Website/Change Delivery Address/DrpKelurahan'), Kelurahan, false)

WebUI.click(findTestObject('Website/Change Delivery Address/BtnSimpan'))

