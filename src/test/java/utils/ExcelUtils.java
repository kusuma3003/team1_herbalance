package utils;

	
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

	public class ExcelUtils {
		private static final String STRING = null;
		public static String filePath = "src/test/resources/TestData.xlsx";

	    public static List<String> getAllSheetNames(String filePath) throws IOException {
	        List<String> sheetNames = new ArrayList<>();
	        try (FileInputStream fis = new FileInputStream(filePath);
	             Workbook workbook = new XSSFWorkbook(fis)) {
	            int sheetsCount = workbook.getNumberOfSheets();
	            for (int i = 0; i < sheetsCount; i++) {
	                sheetNames.add(workbook.getSheetName(i));
	            }
	        }
	        return sheetNames;
	    }

	    public static Map<String, String> readExcelRow(String scenarioName,String sheetName) {
		       
	        Map<String, String> testData = new HashMap<>();

	        try (FileInputStream fis = new FileInputStream(filePath);
	        		Workbook workbook = new XSSFWorkbook(fis)) {
	            Sheet sheet = workbook.getSheet(sheetName);
	            Row header = sheet.getRow(0); // row 1 has the headers (0-based index)

	            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
	                Row row = sheet.getRow(i);
	                if (row.getCell(0).getStringCellValue().equalsIgnoreCase(scenarioName)) {
	                    for (int j = 1; j < row.getLastCellNum(); j++) {
	                        String key = header.getCell(j).getStringCellValue();
	                        String value = row.getCell(j).getStringCellValue();
	                        testData.put(key, value);
	                    }
	                
	            }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return testData;
	    }
	    public static List<Map<String, String>> readExcelSheet(String sheetName) {
	        List<Map<String, String>> allTestData = new ArrayList<>();

	        try (FileInputStream fis = new FileInputStream(filePath);
	             Workbook workbook = new XSSFWorkbook(fis)) {

	            Sheet sheet = workbook.getSheet(sheetName);
	            Row header = sheet.getRow(0); // header row

	            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
	                Row row = sheet.getRow(i);
	                if (row == null) continue;

	                Map<String, String> rowData = new HashMap<>();

	                for (int j = 0; j < row.getLastCellNum(); j++) {
	                    String key = header.getCell(j).getStringCellValue();

	                    Cell cell = row.getCell(j);
	                    String value = "";

	                    if (cell != null) {
	                        switch (cell.getCellType()) {
	                            case STRING:
	                                value = cell.getStringCellValue();
	                                break;
	                            case NUMERIC:
	                                value = String.valueOf(cell.getNumericCellValue());
	                                break;
	                            case BOOLEAN:
	                                value = String.valueOf(cell.getBooleanCellValue());
	                                break;
	                            case BLANK:
	                            default:
	                                value = "";
	                        }
	                    }

	                    rowData.put(key, value.trim());
	                }

	                allTestData.add(rowData);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return allTestData;
	    }

	}


