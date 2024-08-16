package com.vtiger.genericUtilities;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;
	/**
	 * This method is used to maximize the window size
	 * @param driver
	 * @author Harsh
	 */
public class WebdriverUtility {
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 *  This method is used to minimize the window
	 * @param driver
	 * @author Harsh
	 */
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}
	/**
	 * This method is used to wait till entire web page is loaded
	 * @param driver
	 * @author Harsh
	 */
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	/**
	 * This method is used to handle the dropdown with the help of index value
	 * @param ele
	 * @param index
	 * @author Harsh
	 */
	public void handleDropDown(WebElement ele,int index) {
		Select s = new Select(ele);
		s.selectByIndex(index);
		
	}
	/**
	 * Rhis element is used to handle dropdown with the help of value
	 * @param ele
	 * @param value
	 * @author Harsh
	 */
	
	public void handleDropDown(WebElement ele,String value) {
		Select s = new Select(ele);
		s.selectByValue(value);
		
	}
	/**
	 * This method is used to handle web element using visible text
	 * @param text
	 * @param ele
	 * @author Harsh
	 */
	
	public void handleDropDown(String text,WebElement ele) {
		Select s = new Select(ele);
		s.selectByVisibleText(text);
		
	}
	/**
	 * This method is used to move the cursor
	 * @param driver
	 * @param element
	 * @author Harsh
	 */
	public void moveToElement(WebDriver driver,WebElement element) {
		Actions a  = new Actions(driver);
		a.moveToElement(element).perform();
	}
	/**
	 * It is used to perform right click
	 * @param driver
	 * @param element
	 * @author Harsh
	 */
	public void rightClickonElement(WebDriver driver,WebElement element) {
		Actions a  = new Actions(driver);
		a.contextClick(element).perform();
	}
	/**
	 * This method is used to perform double click
	 * @param driver
	 * @param element
	 * @author Harsh
	 */
	public void doubleClickonElement(WebDriver driver,WebElement element) {
		Actions a = new Actions(driver);
		a.click(element).perform();
	}
	/**
	 * This method is used to perform drag and drop operation
	 * @param driver
	 * @param srcele
	 * @param destele
	 * @author Harsh
	 */
	public void dragandDrop(WebDriver driver,WebElement srcele,WebElement destele) {
		Actions a = new Actions(driver);
		a.dragAndDrop(srcele, destele).perform();
	}
	/**
	 * This method is used to take screenshots
	 * @param driver
	 */
	public void getscreenShot(WebDriver driver){
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		Date curDate = new Date();
		//System.out.println(curDate);
		String scDate = curDate.toString().replace(" ", "-").replace(":", "-");
		File dest = new File("./"+"/Screenshots/"+scDate+".png");
		try {
			Files.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
