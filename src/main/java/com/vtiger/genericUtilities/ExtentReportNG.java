
	package com.vtiger.genericUtilities;

	import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.reporter.ExtentReporter;
	import com.aventstack.extentreports.reporter.ExtentSparkReporter;
	import com.aventstack.extentreports.reporter.configuration.Theme;

	public class ExtentReportNG {

		public static ExtentReports getReportObject() {
			Date curDate = new Date();
			//System.out.println(curDate);
			String scDate = curDate.toString().replace(" ", "-").replace(":", "-");
			String path = System.getProperty("user.dir") + "//myreports/TestReport"+scDate+".html";
			ExtentSparkReporter reporter = new ExtentSparkReporter(path);
			reporter.config().setTheme(Theme.DARK);
			reporter.config().setReportName("Vtiger Autumation Results");
			reporter.config().setDocumentTitle("Test Results");

			ExtentReports extent = new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("Tester", "Harsh Kumar Sharma");
			return extent;

		}

	}

