package com.soal.selenium.utils;

//import java.util.ArrayList;
//import java.util.List;

public enum TestCases {
	//Login
	T1("Tesing menampilkan halaman login"),
	T2("Testing Login Empty Username"),
	T3("Testing Login Empty Password"),
	T4("Testing Login Invalid Username"),
	T5("Testing Login Invalid Password"),
	T6("Testing Login User Sales Valid"),
	
	T7("Testing Memasukkan Barang ke Keranjang"),
	T8("Testing Checkout Dengan First Name Kosong"),
	T9("Testing Checkout Dengan Last Name Kosong"),
	T10("Testing Checkout Dengan Postal Code Kosong"),
	T11("Testing Checkout Dengan Information Lengkap");
	
	
	private String testName;
	
	TestCases(String testName){
		this.testName = testName;
	}
	
	public String getTestName() {
		return testName;
	}
	
}

