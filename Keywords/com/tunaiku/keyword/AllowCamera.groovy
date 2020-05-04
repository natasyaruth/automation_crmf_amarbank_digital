package com.tunaiku.keyword

import java.awt.Robot
import java.awt.event.KeyEvent
import org.openqa.selenium.Alert
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.driver.DriverFactory

public class AllowCamera {
	@Keyword
	def allowing_camera(){
		Robot robot = new Robot();
		// Creates the delay of 5 sec so that you can open notepad before
		// Robot start writting
		robot.delay(5000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);


	}
}

