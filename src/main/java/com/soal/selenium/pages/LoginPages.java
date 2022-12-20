package com.soal.selenium.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.soal.selenium.driver.DriverSingleton;

public class LoginPages {

	private WebDriver driver;
	
	public LoginPages() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "user-name")
	private WebElement inputUsername;
	
	@FindBy(id = "password")
	private WebElement inputPassword;
	
	@FindBy(id = "login-button")
	private WebElement buttonLogin;
	
	@FindBy(className =  "title")
	private WebElement kataProduct;
	
	
	
	public void loginForm(String username, String password) {
		inputUsername.clear();
		inputUsername.sendKeys(username);
		inputPassword.sendKeys(password);
		buttonLogin.click();
	}
	
	// Get Validasi Username
	public String getAlert() {
		return inputUsername.getAttribute("required");
	}
	
	public String getBerhasilMasuk() {
		return kataProduct.getText();
	}
}

