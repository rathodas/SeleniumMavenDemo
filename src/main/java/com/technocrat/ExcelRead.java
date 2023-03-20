package com.technocrat;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	public static void main(String[] args) throws Exception {
		
		ArrayList list = new ArrayList();
		
		XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream("D:\\TestData\\NewTestData.xlsx"));
		
		XSSFSheet sheet = workbook.getSheet("CustomerDetails");
		
				
		Iterator rowIterator = sheet.iterator();
		
		while(rowIterator.hasNext()) {
			Row row = (Row) rowIterator.next();
			Iterator cellIterator = row.cellIterator();
			
			while(cellIterator.hasNext()) {
				
				Cell cell = (Cell) cellIterator.next();
			
				switch (cell.getCellType()) {
				
				case BOOLEAN:
					list.add(cell.getBooleanCellValue());
					break;
				case STRING:
					list.add(cell.getRichStringCellValue().getString());
					break;
				case NUMERIC:
					if (DateUtil.isCellDateFormatted(cell)) {
						list.add(cell.getDateCellValue());
					} else {
						list.add(cell.getNumericCellValue());
					}
					break;
				case FORMULA:
					list.add(cell.getRichStringCellValue());
					break;
				case BLANK:
					list.add("");
					break;
				default:
					System.out.print("");
				}

			}
		}

		System.out.println(list);

	}

}
