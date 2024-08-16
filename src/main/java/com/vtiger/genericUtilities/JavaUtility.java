package com.vtiger.genericUtilities;

import java.util.Random;

public class JavaUtility {
	public int getRandomNum() {
		Random ran = new Random();
		return ran.nextInt(100);
	}

}
