package com.ncs.iframe4.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPrintSetup;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.IndexedColors;

import com.ncs.iframe4.ps.po.OrderDetail;

public class GenerateExport {
	public static HSSFWorkbook createReport(String optusPoNum, Float totalAmount, List<OrderDetail> productList) {
		if (totalAmount == null) {
			totalAmount = (float) 0;
		}

		HSSFWorkbook wb = new HSSFWorkbook();
		Map<String, HSSFCellStyle> styles = createStyles(wb);
		HSSFSheet sheet = wb.createSheet("Purchase Order");
		sheet.setPrintGridlines(false);
		sheet.setDisplayGridlines(false);

		HSSFPrintSetup printSetup = sheet.getPrintSetup();
		printSetup.setLandscape(false);
		sheet.setFitToPage(true);
		sheet.setHorizontallyCenter(true);

		sheet.setColumnWidth(0, 3 * 256);
		sheet.setColumnWidth(1, 3 * 256);
		sheet.setColumnWidth(2, 14 * 256);
		sheet.setColumnWidth(3, 14 * 256);
		sheet.setColumnWidth(4, 14 * 256);
		sheet.setColumnWidth(5, 14 * 256);
		sheet.setColumnWidth(6, 14 * 256);
		sheet.setColumnWidth(7, 14 * 256);
		sheet.setColumnWidth(8, 14 * 256);

		// createNames(wb);

		HSSFRow titleRow = sheet.createRow(0);
		titleRow.setHeightInPoints(35);
		for (int i = 1; i <= 7; i++) {
			titleRow.createCell(i).setCellStyle(styles.get("title"));
		}
		HSSFCell titleCell = titleRow.getCell(2);
		titleCell.setCellValue("Purchase Order");

		// sheet.addMergedRegion(CellRangeAddress.valueOf("$C$1:$H$1"));
		// titleCell.setCellStyle(styles.get("item_center"));

		HSSFRow row = sheet.createRow(3);
		HSSFCell cell = row.createCell(4);
		cell.setCellValue("Prices listed are exclusive of GST");
		cell.setCellStyle(styles.get("item_center"));

		row = sheet.createRow(1);
		cell = row.createCell(7);
		cell.setCellValue("Optus PO Num:");
		cell.setCellStyle(styles.get("item_right"));

		cell = row.createCell(8);
		cell.setCellValue(optusPoNum);
		cell.setCellStyle(styles.get("item_right"));

		row = sheet.createRow(2);
		cell = row.createCell(7);
		cell.setCellValue("PO Generate Date:");
		cell.setCellStyle(styles.get("item_right"));

		Timestamp dt = new Timestamp(new Date().getTime());
		String formatedDt = new SimpleDateFormat("MM/dd/yyyy").format(dt);
		cell = row.createCell(8);
		cell.setCellValue(formatedDt);
		cell.setCellStyle(styles.get("item_right"));

		row = sheet.createRow(4);
		cell = row.createCell(2);
		cell.setCellValue("Vendor Part No.");
		cell.setCellStyle(styles.get("item_left"));

		cell = row.createCell(3);
		cell.setCellValue("Delivery Date");
		cell.setCellStyle(styles.get("item_left"));

		cell = row.createCell(4);
		cell.setCellValue("Qty to Deliver");
		cell.setCellStyle(styles.get("item_left"));

		cell = row.createCell(5);
		cell.setCellValue("Unit Type");
		cell.setCellStyle(styles.get("item_left"));

		cell = row.createCell(6);
		cell.setCellValue("Unit Price");
		cell.setCellStyle(styles.get("item_left"));

		cell = row.createCell(7);
		cell.setCellValue("Total Price");
		cell.setCellStyle(styles.get("item_left"));

		cell = row.createCell(8);
		cell.setCellValue("Currency");
		cell.setCellStyle(styles.get("item_left"));

		int j = 0;
		
		for (int i = 0; i < productList.size(); i++) {
			row = sheet.createRow(5 + i);
			OrderDetail orderDetailList = (OrderDetail) productList.get(i);
			// System.out.println("OrderDetail list--"+productList.size());
			// System.out.println("Vendor Part No.--"+orderDetailList.getProduct().getProductNum());
			// System.out.println("Delivery Date--"+orderDetailList.getOrder().getEta());
			// System.out.println("Qty to Deliver--"+orderDetailList.getOrderQuantity());
			// System.out.println("Unit Type--"+orderDetailList.getProduct().getUnit());
			// System.out.println("Unit Price--"+
			// orderDetailList.getOptusPrice());
			String productNum = orderDetailList.getProduct().getProductNum();
			Date eta = orderDetailList.getOrder().getEta();
			Integer orderQuantity = orderDetailList.getOrderQuantity();
			
			BigDecimal orderQuantityBigDecimal = new BigDecimal(Integer.toString(orderQuantity));
			
			String unit = orderDetailList.getProduct().getUnit();
			Float optusPrice = orderDetailList.getOptusPrice();
			BigDecimal displayTotal = new BigDecimal("0");
			BigDecimal ftOptusPrice=new BigDecimal("0");
			if (optusPrice == null) {
				optusPrice = (float)0;
			}else{
				ftOptusPrice = new BigDecimal(Float.toString(optusPrice));
				ftOptusPrice = ftOptusPrice.setScale(2, RoundingMode.HALF_EVEN);
				BigDecimal total = ftOptusPrice.multiply(orderQuantityBigDecimal);
				displayTotal = total.setScale(2, RoundingMode.HALF_EVEN);
			}
			
			cell = row.createCell(2);
			cell.setCellValue(productNum);
			cell.setCellStyle(styles.get("item_left"));
			cell = row.createCell(3);
			if (eta == null) {
				String formatedEta = "";
				cell.setCellValue(formatedEta);
			} else {
				String formatedEta = new SimpleDateFormat("dd/mm/yyyy").format(eta);
				cell.setCellValue(formatedEta);
			}
			cell.setCellStyle(styles.get("item_left"));
			cell = row.createCell(4);
			cell.setCellValue(orderQuantity);
			cell.setCellStyle(styles.get("item_left"));
			
			cell = row.createCell(5);
			cell.setCellValue(unit);
			cell.setCellStyle(styles.get("item_left"));
			
			cell = row.createCell(6);
			cell.setCellValue(ftOptusPrice.toString());
			cell.setCellStyle(styles.get("item_left"));
			
			cell = row.createCell(7);
			cell.setCellValue(displayTotal.toString());
			cell.setCellStyle(styles.get("item_left"));
			
			cell = row.createCell(8);
			cell.setCellValue("AUD");
			cell.setCellStyle(styles.get("item_left"));
			j++;
		}
		row = sheet.createRow(5 + j);
		cell = row.createCell(7);
		cell.setCellValue("Total:");
		cell.setCellStyle(styles.get("item_right"));

		cell = row.createCell(8);
		cell.setCellValue("$" + totalAmount);
		cell.setCellStyle(styles.get("item_right"));

		return wb;

	}

	/**
	 * cell styles used for formatting calendar sheets
	 */
	private static Map<String, HSSFCellStyle> createStyles(HSSFWorkbook wb) {
		Map<String, HSSFCellStyle> styles = new HashMap<String, HSSFCellStyle>();

		HSSFCellStyle style;
		HSSFFont titleFont = wb.createFont();
		titleFont.setFontHeightInPoints((short) 14);
		titleFont.setFontName("Trebuchet MS");
		style = wb.createCellStyle();
		style.setFont(titleFont);
		style.setBorderBottom(HSSFCellStyle.BORDER_DOTTED);
		style.setBottomBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
		styles.put("title", style);

		HSSFFont itemFont = wb.createFont();
		itemFont.setFontHeightInPoints((short) 9);
		itemFont.setFontName("Trebuchet MS");
		style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		style.setFont(itemFont);
		styles.put("item_left", style);

		style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
		style.setFont(itemFont);
		styles.put("item_right", style);

		style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setFont(itemFont);
		styles.put("item_center", style);

		style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
		style.setFont(itemFont);
		style.setBorderRight(HSSFCellStyle.BORDER_DOTTED);
		style.setRightBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
		style.setBorderBottom(HSSFCellStyle.BORDER_DOTTED);
		style.setBottomBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
		style.setBorderLeft(HSSFCellStyle.BORDER_DOTTED);
		style.setLeftBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
		style.setBorderTop(HSSFCellStyle.BORDER_DOTTED);
		style.setTopBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
		style.setDataFormat(wb.createDataFormat().getFormat(
				"_($* #,##0.00_);_($* (#,##0.00);_($* \"-\"??_);_(@_)"));
		styles.put("input_$", style);

		style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
		style.setFont(itemFont);
		style.setBorderRight(HSSFCellStyle.BORDER_DOTTED);
		style.setRightBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
		style.setBorderBottom(HSSFCellStyle.BORDER_DOTTED);
		style.setBottomBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
		style.setBorderLeft(HSSFCellStyle.BORDER_DOTTED);
		style.setLeftBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
		style.setBorderTop(HSSFCellStyle.BORDER_DOTTED);
		style.setTopBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
		style.setDataFormat(wb.createDataFormat().getFormat("0.000%"));
		styles.put("input_%", style);

		style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
		style.setFont(itemFont);
		style.setBorderRight(HSSFCellStyle.BORDER_DOTTED);
		style.setRightBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
		style.setBorderBottom(HSSFCellStyle.BORDER_DOTTED);
		style.setBottomBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
		style.setBorderLeft(HSSFCellStyle.BORDER_DOTTED);
		style.setLeftBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
		style.setBorderTop(HSSFCellStyle.BORDER_DOTTED);
		style.setTopBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
		style.setDataFormat(wb.createDataFormat().getFormat("0"));
		styles.put("input_i", style);

		style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setFont(itemFont);
		style.setDataFormat(wb.createDataFormat().getFormat("m/d/yy"));
		styles.put("input_d", style);

		style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
		style.setFont(itemFont);
		style.setBorderRight(HSSFCellStyle.BORDER_DOTTED);
		style.setRightBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
		style.setBorderBottom(HSSFCellStyle.BORDER_DOTTED);
		style.setBottomBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
		style.setBorderLeft(HSSFCellStyle.BORDER_DOTTED);
		style.setLeftBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
		style.setBorderTop(HSSFCellStyle.BORDER_DOTTED);
		style.setTopBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
		style.setDataFormat(wb.createDataFormat().getFormat("$##,##0.00"));
		style.setBorderBottom(HSSFCellStyle.BORDER_DOTTED);
		style.setBottomBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		styles.put("formula_$", style);

		style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
		style.setFont(itemFont);
		style.setBorderRight(HSSFCellStyle.BORDER_DOTTED);
		style.setRightBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
		style.setBorderBottom(HSSFCellStyle.BORDER_DOTTED);
		style.setBottomBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
		style.setBorderLeft(HSSFCellStyle.BORDER_DOTTED);
		style.setLeftBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
		style.setBorderTop(HSSFCellStyle.BORDER_DOTTED);
		style.setTopBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
		style.setDataFormat(wb.createDataFormat().getFormat("0"));
		style.setBorderBottom(HSSFCellStyle.BORDER_DOTTED);
		style.setBottomBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		styles.put("formula_i", style);

		return styles;
	}
}
