package com.hemant.boot.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.hemant.boot.model.StockInfo;

public class ReportsUtil {
	public static OutputStream getStockReportXLS(List<StockInfo> stocks) throws IOException {
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("STOCK REPORT");
		
		// Column sizes can be manually set using the below format. The are otherwise autoresized using autoSizeColumn
		// sheet.setColumnWidth(0, 16*256)
		Row titleRow = sheet.createRow(0);

		// Setting table headers
		titleRow.createCell(0).setCellValue("SYMBOL");
		titleRow.createCell(1).setCellValue("PRICE");
		titleRow.createCell(2).setCellValue("YEAR HIGH");
		titleRow.createCell(3).setCellValue("YEAR LOW");

		for (int j = 0; j < 4; j++) {
			titleRow.getCell(j).setCellStyle(gettitleCellStyle(workbook));
		}

		// Setting table values
		int rowNumber = 1;
		for (StockInfo info : stocks) {
			Row row = sheet.createRow(rowNumber);
			row.createCell(0).setCellValue(info.getSymbol());
			row.createCell(1).setCellValue(info.getPrice());
			row.createCell(2).setCellValue(info.getYearHigh());
			row.createCell(3).setCellValue(info.getYearLow());
			rowNumber++;
		}

		// Autosizing columns
		for (int i = 0; i < 4; i++) {
			sheet.autoSizeColumn(i);
		}

		OutputStream out = new ByteArrayOutputStream();
		workbook.write(out);
		out.flush();
		out.close();
		return out;
	}
	
	public static CellStyle gettitleCellStyle(Workbook workbook) {
		CellStyle titleStyle = workbook.createCellStyle();
		Font titleFont = workbook.createFont();
		titleFont.setFontHeightInPoints((short) 12);
		titleStyle.setBorderBottom((short) 5);
		titleStyle.setFont(titleFont);
		return titleStyle;
	}

}
