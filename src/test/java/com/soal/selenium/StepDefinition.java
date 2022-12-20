package com.soal.selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.soal.selenium.config.AutomationFrameworkConfig;
import com.soal.selenium.driver.DriverSingleton;
import com.soal.selenium.pages.KeranjangPages;
import com.soal.selenium.pages.LoginPages;
//import com.soal.selenium.pages.FormReturn;
//import com.soal.selenium.pages.InputPage;
//import com.soal.selenium.pages.loginpages;
//import com.soal.selenium.pages.TtdDigitalPage;
//import com.soal.selenium.pages.UploadDocumentPage;
import com.soal.selenium.utils.ConfigurationProperties;
import com.soal.selenium.utils.Constants;
import com.soal.selenium.utils.TestCases;
import com.soal.selenium.utils.Utils;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = AutomationFrameworkConfig.class)
public class StepDefinition {
	
	private static WebDriver driver;
	private LoginPages loginPages;
	private KeranjangPages keranjangPages;
//	private InputPage inputPage;
//	private UploadDocumentPage uploadDocument;
//	private TtdDigitalPage ttdDigital;
//	private FormReturn formReturn;
	
	static ExtentTest extentTest;
	static ExtentReports reports = new ExtentReports("src/main/resources/ReportTest.html");
	
	@Autowired
	ConfigurationProperties configurationProperties;
	
	@Before
	public void setUp() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		loginPages = new LoginPages();
		keranjangPages = new KeranjangPages();
		
//		inputPage = new InputPage();
//		uploadDocument = new UploadDocumentPage();
//		ttdDigital = new TtdDigitalPage();
//		formReturn = new FormReturn();
		TestCases[] tests = TestCases.values();
		extentTest = reports.startTest(tests[Utils.testCount].getTestName());
		Utils.testCount++;
	}
	
	@AfterStep
	public void getResultScreenshot(Scenario scenario) throws Exception {
		if(scenario.isFailed()) {
			String screenshotPath = Utils.getScreenshot(driver, scenario.getName().replace(" ","_"));
			extentTest.log(LogStatus.FAIL, "Screenshot:\n"+
					extentTest.addScreenCapture(screenshotPath));
		}
	}
	
	@After
	public static void endTestStep() {
		reports.endTest(extentTest);
		reports.flush();
	}
	
	@AfterAll
	public static void quitDriver() {
		tunggu(5);
		driver.quit();
	}
	
	
	
	// Modul Login
	@Given("User mengakses url")
	public void user_mengakses_url() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
		extentTest.log(LogStatus.PASS, "User mengakses url "+Constants.URL);
	}
	
	@Then("User menampillkan halaman login")
	public void user_menampillkan_halaman_login() {
		tunggu(3);
		extentTest.log(LogStatus.PASS, "User berhasil menampilkan halaman login");
	}
	
	@When("User login dengan username kosong")
	public void user_login_dengan_username_kosong() {
		loginPages.loginForm(configurationProperties.getEmptyUsernamePassword(), configurationProperties.getEmptyUsernamePassword());
		extentTest.log(LogStatus.PASS, "User login dengan username kosong");
	}
	
	@Then("User gagal login dengan username kosong")
	public void user_gagal_login_dengan_username_kosong() {
		tunggu(3);
		assertTrue(loginPages.getAlert(), true);
		extentTest.log(LogStatus.PASS, "Validasi User gagal login dengan username kosong");
	}
	
	@When("User login dengan password kosong")
	public void user_login_dengan_password_kosong() {
		loginPages.loginForm(configurationProperties.getInvalidUsername(), configurationProperties.getEmptyUsernamePassword());
		extentTest.log(LogStatus.PASS, "User login dengan password kosong");
	}
	
	@Then("User gagal login dengan password kosong")
	public void user_gagal_login_dengan_password_kosong() {
		tunggu(3);
		assertTrue(loginPages.getAlert(), true);
		extentTest.log(LogStatus.PASS, "Validasi User gagal login dengan password kosong");
	}
	
	@When("User login dengan invalid username")
	public void user_login_dengan_username_salah() {
		loginPages.loginForm(configurationProperties.getInvalidUsername(), configurationProperties.getValidPassword());
		extentTest.log(LogStatus.PASS, "User login dengan username salah");
	}
	
	@Then("User gagal login dengan invalid username")
	public void user_gagal_login_dengan_username_salah() {
		tunggu(3);
		assertTrue(loginPages.getAlert(), true);
		extentTest.log(LogStatus.PASS, "Validasi User gagal login dengan username salah");
	}
	
	@When("User login dengan invalid password")
	public void user_login_dengan_password_salah() {
		loginPages.loginForm(configurationProperties.getValidUsername(), configurationProperties.getInvalidPassword());
		extentTest.log(LogStatus.PASS, "User login dengan password salah");
	}
	
	@Then("User gagal login dengan invalid password")
	public void user_gagal_login_dengan_password_salah() {
		tunggu(3);
		assertTrue(loginPages.getAlert(), true);
		extentTest.log(LogStatus.PASS, "Validasi User gagal login dengan password salah");
	}
	
	@When("User login dengan username dan password")
	public void user_login_dengan_username_password() {
		tunggu(3);
		loginPages.loginForm(configurationProperties.getValidUsername(), configurationProperties.getValidPassword());
		extentTest.log(LogStatus.PASS, "User Berhasil login");
	}
	
	@Then("User berhasil login")
	public void user_berhasil_login() {
		driver.navigate().refresh();
		tunggu(2);
		assertEquals(configurationProperties.getKalimatProduct(), loginPages.getBerhasilMasuk());
		extentTest.log(LogStatus.PASS, "Validasi User berhasil login");
	}
	
	@When("User memasukkan ke keranjang")
	public void user_memasukkan_ke_keranjang() {
		assertEquals("$29.99",keranjangPages.getHargaBarang());
		tunggu(2);
		keranjangPages.addCart();
		extentTest.log(LogStatus.PASS, "User Berhasil Memasukkan ke Keranjang");
	}
	
	@Then("User berhasil memasukkan ke keranjang")
	public void user_berhasil_memasukkan_ke_keranjang() {
		tunggu(3);
		assertEquals(configurationProperties.getAngkaDiKeranjang(), keranjangPages.validateToCart());
		extentTest.log(LogStatus.PASS, "Validasi User berhasil login");
	}
	
	@When("User memasukkan first name kosong")
	public void user_memasukkan_first_name_kosong() {
		keranjangPages.checkout();
		keranjangPages.checkoutYourInfomation(configurationProperties.getEmptyYourInformation(), "", "");
		extentTest.log(LogStatus.PASS, "User memasukkan first name kosong");
	}
	
	@Then("User gagal checkout dengan first name kosong")
	public void user_gagal_checkout_dengan_first_name_kosong() {
		tunggu(3);
		assertTrue(keranjangPages.getAlert(), true);
		extentTest.log(LogStatus.PASS, "User gagal checkout dengan first name kosong");
	}
	
	@When("User memasukkan last name kosong")
	public void user_memasukkan_last_name_kosong() {
		keranjangPages.checkoutYourInfomation(configurationProperties.getFirstName(), configurationProperties.getEmptyYourInformation(), "");
		extentTest.log(LogStatus.PASS, "User memasukkan last name kosong");
	}
	
	@Then("User gagal checkout dengan last name kosong")
	public void user_gagal_checkout_dengan_last_name_kosong() {
		tunggu(3);
		assertTrue(keranjangPages.getAlert(), true);
		extentTest.log(LogStatus.PASS, "User gagal checkout dengan last name kosong");
	}
	
	@When("User memasukkan postal code kosong")
	public void user_memasukkan_postal_code_kosong() {
		keranjangPages.checkoutYourInfomation(configurationProperties.getFirstName(), configurationProperties.getLastName(), configurationProperties.getEmptyYourInformation());
		extentTest.log(LogStatus.PASS, "User memasukkan postal code kosong");
	}
	
	@Then("User gagal checkout dengan postal code kosong")
	public void user_gagal_checkout_dengan_postal_code_kosong() {
		tunggu(3);
		assertTrue(keranjangPages.getAlert(), true);
		extentTest.log(LogStatus.PASS, "User gagal checkout dengan postal code kosong");
	}
	
	@When("User memasukkan informasi dengan lengkap")
	public void user_memasukkan_informasi_dengan_lengkap() {
		keranjangPages.checkoutYourInfomation(configurationProperties.getFirstName(), configurationProperties.getLastName(), configurationProperties.getPostalCode());
		assertEquals(configurationProperties.getHargaBarang(), keranjangPages.getHargaBarangInOverview());
		extentTest.log(LogStatus.PASS, "User memasukkan informasi dengan lengkap");
	}
	
	@Then("User berhasil checkout")
	public void user_berhasil_checkout() {
		tunggu(3);
		keranjangPages.finishCheckout();
//		assertTrue(keranjangPages.getAlert(), true);
		extentTest.log(LogStatus.PASS, "User berhasil checkout");
	}
	

	public static void tunggu(int detik) {
		try {
			Thread.sleep(1000*detik);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void scrollDown(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("scrollBy(0, 300)");
	}
	
	
	
	

}
