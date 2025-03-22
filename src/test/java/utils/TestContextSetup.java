package utils;

import java.io.IOException;

import pages.PageObjectManager;

public class TestContextSetup {

	public PageObjectManager pageObjectManager;
	public TestBase testBase;
	
	public TestContextSetup() throws IOException {
		testBase = new TestBase();
		pageObjectManager= new PageObjectManager(testBase.WebDriverManager());
		
	}
}
