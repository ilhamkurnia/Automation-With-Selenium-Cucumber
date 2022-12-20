package com.soal.selenium.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome implements DriverStrategy {

	public WebDriver setStrategy() {
		String path = System.getProperty("user.dir");
		System.out.println(path);
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ilham_118299\\Documents\\webdriver\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", path+"\\src\\test\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}
}
	
