package com.vtiger.objectrepos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganizationPage {
	//Declaration
		@FindBy(xpath="//input[@name='accountname']")private WebElement orgNameedt;
		@FindBy(xpath="//input[@title='Save [Alt+S]']")private WebElement saveBtn;
	//Initailization
		public CreateNewOrganizationPage(WebDriver driver) {
			PageFactory.initElements(driver,this);
		}
	//Getters
		public WebElement getOrgNameedt() {
			return orgNameedt;
		}
		public WebElement getSaveBtn() {
			return saveBtn;
		}
		//Business Library
		public void createNewOrganization(String ORGNAME)
		{
			orgNameedt.sendKeys(ORGNAME);
			saveBtn.click();
		}
}