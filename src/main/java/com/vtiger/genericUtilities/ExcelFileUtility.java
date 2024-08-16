package com.vtiger.genericUtilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	/**
	 * This method is used to fetch the data from Excel 
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws Throwable
	 */

		public String readDataFromExcel(String sheetname,int rownum,int cellnum) throws Throwable {
			FileInputStream fise = new FileInputStream(IconstantPaths.excelFilepath);
			Workbook wb = WorkbookFactory.create(fise);
			return wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
			
		}

	}



