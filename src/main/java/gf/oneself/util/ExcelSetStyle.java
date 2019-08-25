package gf.oneself.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSetStyle {
	public static final List<String> TITLE_LIST = new ArrayList<>();
	static {
		TITLE_LIST.add("ONE");
		TITLE_LIST.add("TWO");
		TITLE_LIST.add("THREE");
		TITLE_LIST.add("FOUR");
		TITLE_LIST.add("FIVE");
		TITLE_LIST.add("SIX");
		TITLE_LIST.add("SEVEN");
		TITLE_LIST.add("EIGHT");
		TITLE_LIST.add("NINE");
		TITLE_LIST.add("TEN");
	}
	
	
	
	private static void setFontStyle() {
		
	}
	
	public static XSSFCellStyle setTitleStyle(XSSFWorkbook workbook) {
		 XSSFCellStyle style = workbook.createCellStyle();
		 style.setFillBackgroundColor((short)123 );
		 style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		 style.setFillBackgroundColor(new XSSFColor(java.awt.Color.BLUE));
		 style.setFillBackgroundColor(IndexedColors.BLUE.getIndex());
		 style.setBorderBottom(BorderStyle.MEDIUM);
		 style.setBorderLeft(BorderStyle.MEDIUM);
		 style.setBorderRight(BorderStyle.MEDIUM);
		 style.setAlignment(HorizontalAlignment.CENTER);
		 XSSFFont font = workbook.createFont();
		 font.setFontHeightInPoints((short) 12);
		 style.setFont(font);
		 return style;
	}

}
