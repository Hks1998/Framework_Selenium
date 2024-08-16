package com.vtiger.objectrepos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.genericUtilities.*;

public class HomePage extends WebdriverUtility {
//Declaration
	@FindBy(linkText = "Organizations")
	private WebElement OrganizationsLnk;

	@FindBy(linkText = "Contacts")
	private WebElement ContactsLnk;

	@FindBy(linkText = "Opportunities")
	private WebElement opportunitiesLnk;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;

	@FindBy(linkText = "Sign Out")
	private WebElement SignOutLnk;
//Initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
//Utulization
	public WebElement getOrganizationsLnk() {
		return OrganizationsLnk;
	}
	public WebElement getContactsLnk() {
		return ContactsLnk;
	}
	public WebElement getOpportunitiesLnk() {
		return opportunitiesLnk;
	}
	public WebElement getAdministratorImg() {
		return AdministratorImg;
	}
	public WebElement getSignOutLnk() {
		return SignOutLnk;
	}
	//Business Library
		public void clickOnOrgLink() {
			OrganizationsLnk.click();
		}
		public void clickonContactsLink() {
			ContactsLnk.click();
		}
		public void logoutfromApp(WebDriver driver) {
			moveToElement(driver, AdministratorImg);
			SignOutLnk.click();
		}
	
}