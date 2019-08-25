package gf.oneself.param;

import java.io.File;
 
public class Constants {
	public static final String USER_DIR = System.getProperty("user.dir")+File.separator; 
	public static final String DATA_DIR = USER_DIR +"data"+File.separator;
	
	public static final String CSV_ONE_PATH = DATA_DIR + "csvone.csv";
	public static final String CSV_TWO_PATH = DATA_DIR + "csvtwo.csv";
	public static final String CSV_THREE_PATH = DATA_DIR + "csvthree.csv";
	public static final String RESULT_EXCEL_PATH = DATA_DIR + "result.xlsx";

}
