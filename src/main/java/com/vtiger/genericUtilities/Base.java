package com.vtiger.genericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.vtiger.objectrepos.*;

public class Base {
	public propertyFileUtility putil = new propertyFileUtility();
	public ExcelFileUtility eutil = new ExcelFileUtility();
	public JavaUtility jutil = new JavaUtility();
	public WebdriverUtility wutil = new WebdriverUtility();
	public WebDriver driver = null;
	@BeforeSuite
	public void bsconfig() {
		Reporter.log("===DB CONNECTION===",true);
		
	}
	@AfterSuite
	public void asconfig() {
		Reporter.log("===DB DISCONNECTION===",true);
	}
@BeforeClass
public void bcconfig() throws Throwable {
	String BROWSER = putil.readDataFromPf("browser");
	String URL = putil.readDataFromPf("url");
	if(BROWSER.equals("chrome")) {
		driver = new ChromeDriver();
		Reporter.log("Chrome browser has Launched",true);
	}
	else if(BROWSER.equals("edge")) {
		driver = new EdgeDriver();
		Reporter.log("Edge browser has Launched",true);
	}
	else if(BROWSER.equals("firefox")) {
		driver = new FirefoxDriver();
		Reporter.log("Firefox browser has Launched",true);
	}
	else {
		System.out.println("Invalid browser name provided in Propertyfile");
	}
	driver.get(URL);
	wutil.maximizeWindow(driver);
	wutil.waitForPageLoad(driver);
	Reporter.log("Launch Browser",true);
}
@AfterClass
public void tearDown() {
	driver.quit();
	Reporter.log("Close Browser",true);
}
@BeforeMethod
public void loginToApp() throws Throwable {
	String UN = putil.readDataFromPf("un");
	String PWD = putil.readDataFromPf("pwd");
	LoginPage lp = new LoginPage(driver);
	lp.loginToApp(UN, PWD);
	Reporter.log("User has successfully logged in to app",true);
}
@AfterMethod
public void logoutFromApp() {
	HomePage hp = new HomePage(driver);
	hp.logoutfromApp(driver);
	Reporter.log("User has logged out from application successfully",true);
}
}
