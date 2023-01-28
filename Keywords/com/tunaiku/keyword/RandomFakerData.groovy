package com.tunaiku.keyword

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.apache.commons.lang.RandomStringUtils

import com.github.javafaker.Faker
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

import internal.GlobalVariable

public class RandomFakerData {

	@Keyword
	public static String set_faker_full_name(){
		/**
		 * This Part for set custom keyword for Random Data Full Name
		 */
		Faker faker = new Faker()
		String randomFullName = faker.name().fullName()
		return randomFullName
	}

	@Keyword
	public static String set_faker_email(){
		/**
		 * This Part for set custom keyword for Random Data Email
		 */
		Faker faker = new Faker()
		String randomEmail = faker.name().fullName() +"@yopmail.com"
		return randomEmail
	}

	@Keyword
	public static String set_faker_last_name(){
		/**
		 * This Part for set custom keyword for Random Data last name
		 */
		Faker faker = new Faker()
		String randomLastName = faker.name().lastName()
		return randomLastName
	}

	@Keyword
	public static String set_faker_phone_number() {
		/**
		 * This Part for set custom keyword for Random Data phone number
		 */
		Faker faker = new Faker()
		String randomPhoneNumber = "0812" +RandomStringUtils.randomNumeric(8)
		return randomPhoneNumber
	}

	@Keyword
	public static String set_faker_first_name(){
		/**
		 * This Part for set custom keyword for Random Data first name
		 */
		Faker faker = new Faker()
		String randomFirstName = faker.name().firstName()
		return randomFirstName
	}

	@Keyword
	public static String set_faker_full_address() {
		/**
		 * This Part for set custom keyword for Random Data first name
		 */
		Faker fake = new Faker()
		String randomFakeAddress = fake.address().fullAddress()
		return randomFakeAddress
	}
}
