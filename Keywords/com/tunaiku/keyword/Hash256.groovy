package com.tunaiku.keyword

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import internal.GlobalVariable

public class Hash256 {
	static String hash(String originalString) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256")
			md.update(originalString.getBytes())
			byte[] digest = md.digest()
			StringBuffer hexString = new StringBuffer()
			for (int i = 0; i < digest.length; i++) {
				String hex = Integer.toHexString(0xff & digest[i])
				if(hex.length() == 1) hexString.append('0')
				hexString.append(hex)
			}
			return hexString.toString()
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace()
			return null
		}
	}
}