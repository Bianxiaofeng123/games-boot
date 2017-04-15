package com.games.world.util;

import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 * @author wcf
 * 操作Excel表格的功能类
 */
public class ExcelReader {
    /**
     * 获取book
     * @return
     */
    public static Workbook getBook(InputStream is, String tp) {
    	try {
    		Workbook wb = null;
    		try {
    			if(".xlsx".equals(tp)) {
    				wb = new XSSFWorkbook(is);
    			} else if (".xls".equals(tp)) {
//					POIFSFileSystem fs = new POIFSFileSystem(is);
	    			wb = new HSSFWorkbook(is);
    			}
    		} catch (Exception e) {
    			e.printStackTrace();
            	wb = null;
			}
    		is.close();
            return wb;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * 获取sheet
     * @return
     */
    public static Sheet getSheet(Workbook b, int idx) {
        return b.getSheetAt(idx);
    }
    
    /**
     * 获取行数据
     * @return
     */
    public static Row getRow(Sheet s, int idx) {
    	return s.getRow(idx);
    }
    
    /**
     * 获取单元格内容
     * @return
     */
    public static String getCell(Row r, int idx) {
    	Cell c = r.getCell(idx);
    	return c == null ? "" : c.getStringCellValue();
    }
    
}