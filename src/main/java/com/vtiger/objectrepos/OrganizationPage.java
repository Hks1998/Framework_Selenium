package com.vtiger.objectrepos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	//Declaration
		@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")private WebElement orgLookUpImg;
	//Initialization
		public OrganizationPage(WebDriver driver) {
			PageFactory.initElements(driver,this);
		//Getters
			
	}
		public WebElement getOrgLookUpImg() {
			return orgLookUpImg;
		}
		//Business Library
		public void clickOnOrgLookUpImg()
		{
			orgLookUpImg.click();
		}
}