package Utilities;


import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelUtility {
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static FileInputStream f;
	
	public static String getString(int i, int j, String filepath, String sheetname ) throws IOException {
		System.out.println(System.getProperty("user.dir")+filepath);
		f=new FileInputStream(System.getProperty("user.dir")+filepath);
		wb=new XSSFWorkbook(f);
		sh=wb.getSheet(sheetname);
		XSSFRow r=sh.getRow(i);
		org.apache.poi.ss.usermodel.Cell c=r.getCell(j);
		String value=c.getStringCellValue();
		return value;
	}
	public static String getNumeric(int i, int j, String filepath, String sheetname ) throws IOException {
		f=new FileInputStream(System.getProperty("user.dir")+filepath);
		wb=new XSSFWorkbook(f);
		sh=wb.getSheet(sheetname);
		XSSFRow r=sh.getRow(i);
		org.apache.poi.ss.usermodel.Cell c=r.getCell(j);
		int value=(int)c.getNumericCellValue();
		return String.valueOf(value);
	}
	

}
