package com.vtiger.objectrepos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {
	@FindBy(xpath = "//input[@name='firstname']")private WebElement fname;
	@FindBy(xpath = "//input[@name='lastname']")private WebElement lname;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")private WebElement saveBtn;
	
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getFname() {
		return fname;
	}

	public WebElement getLname() {
		return lname;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	//Business Library
	public void createNewContact(String Fname,String Lname)
	{
		fname.sendKeys(Fname);
		lname.sendKeys(Lname);
		saveBtn.click();
	}

}
