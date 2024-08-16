package com.vtiger.genericUtilities;

import java.io.FileInputStream;
import java.util.Properties;

public class propertyFileUtility {	
	/**
	 * This method is used to fetch the data from property file
	 * @param Key
	 * @return
	 * @author Harsh
	 */
		public String readDataFromPf(String key) throws Throwable {
			FileInputStream fis = new FileInputStream(IconstantPaths.propertyFilepath);
			Properties p = new Properties();
			p.load(fis);
			return p.getProperty(key);
}
}
