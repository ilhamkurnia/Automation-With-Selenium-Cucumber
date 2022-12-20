package com.soal.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.soal.selenium.driver.DriverSingleton;

public class KeranjangPages {
	
private WebDriver driver;
	
	public KeranjangPages() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#inventory_container > div > div:nth-child(1) > div.inventory_item_description > div.pricebar > div")
	private WebElement getElementHargaBarang;
	
	@FindBy(id = "add-to-cart-sauce-labs-backpack")
	private WebElement buttonAddToCart;
	
	@FindBy(className = "shopping_cart_badge")
	private WebElement validateToCart;
	
	@FindBy(className = "shopping_cart_link")
	private WebElement buttonToCart;
	
	@FindBy(id = "checkout")
	private WebElement buttonCheckout;
	
	@FindBy(id = "first-name")
	private WebElement inputFirstName;
	
	@FindBy(id = "last-name")
	private WebElement inputLastName;
	
	@FindBy(id = "postal-code")
	private WebElement inputPostalCode;
	
	@FindBy(id = "continue")
	private WebElement buttonContinue;
	
	@FindBy(css = "#checkout_summary_container > div > div.summary_info > div.summary_subtotal_label")
	private WebElement getHargaBarangInOverview;
	
	@FindBy(id = "finish")
	private WebElement buttonFinish;
	
	
	
	public void addCart() {
		buttonAddToCart.click();
		buttonToCart.click();
	}
	
	public void checkout() {
		buttonCheckout.click();
	}
	
	public void checkoutYourInfomation(String firstName, String lastName, String postalCode) {
		inputFirstName.clear();
		inputFirstName.sendKeys(firstName);
		inputLastName.clear();
		inputLastName.sendKeys(lastName);
		inputPostalCode.clear();
		inputPostalCode.sendKeys(postalCode);
		buttonContinue.click();
	}
	
	public void finishCheckout() {
		buttonFinish.click();
	
	}
	
	public String getHargaBarang() {
		return getElementHargaBarang.getText();
	}
	
	public String saveValue() {
		return getHargaBarang();
	}
	
	
	

	public String validateToCart() {
		return validateToCart.getText();
	}
	
	public String getAlert() {
		return buttonContinue.getAttribute("required");
	}
	
	public String getHargaBarangInOverview() {
		return getHargaBarangInOverview.getText();
	}

}
