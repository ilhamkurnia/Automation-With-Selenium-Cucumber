package com.soal.selenium.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("expected.properties")
public class ConfigurationProperties {

// Login
	@Value("${browser}")
	private String browser;
	
	@Value("${emptyUsernamePassword}")
	private String emptyUsernamePassword;
	
	@Value("${usernameinvalid}")
	private String invalidUsername;
	
	@Value("${passwordinvalid}")
	private String invalidPassword;
	
	@Value("${usernamevalid}")
	private String validUsername;
	
	@Value("${passwordvalid}")
	private String validPassword;
	
	@Value("${validateBerhasilMasuk}")
	private String kalimatProduct;
	
	@Value("${validateToCart}")
	private String angkaDiKeranjang;
	
	@Value("${emptyYourInformation}")
	private String emptyYourInformation;
	
	@Value("${firstName}")
	private String firstName;
	
	@Value("${lastName}")
	private String lastName;
	
	@Value("${postalCode}")
	private String postalCode;
	
	@Value("${hargaBarang}")
	private String hargaBarang;
	
	
	
	
//Login
	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getEmptyUsernamePassword() {
		return emptyUsernamePassword;
	}

	public void setEmptyUsernamePassword(String emptyUsernamePassword) {
		this.emptyUsernamePassword = emptyUsernamePassword;
	}

	public String getInvalidUsername() {
		return invalidUsername;
	}

	public void setInvalidUsername(String invalidUsername) {
		this.invalidUsername = invalidUsername;
	}

	public String getInvalidPassword() {
		return invalidPassword;
	}

	public void setInvalidPassword(String invalidPassword) {
		this.invalidPassword = invalidPassword;
	}

	public String getValidUsername() {
		return validUsername;
	}

	public void setValidUsername(String validUsername) {
		this.validUsername = validUsername;
	}

	public String getValidPassword() {
		return validPassword;
	}

	public void setValidPassword(String validPassword) {
		this.validPassword = validPassword;
	}

	public String getKalimatProduct() {
		return kalimatProduct;
	}

	public void setKalimatProduct(String kalimatProduct) {
		this.kalimatProduct = kalimatProduct;
	}

	public String getAngkaDiKeranjang() {
		return angkaDiKeranjang;
	}

	public void setAngkaDiKeranjang(String angkaDiKeranjang) {
		this.angkaDiKeranjang = angkaDiKeranjang;
	}

	public String getEmptyYourInformation() {
		return emptyYourInformation;
	}

	public void setEmptyYourInformation(String emptyYourInformation) {
		this.emptyYourInformation = emptyYourInformation;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getHargaBarang() {
		return hargaBarang;
	}

	public void setHargaBarang(String hargaBarang) {
		this.hargaBarang = hargaBarang;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
