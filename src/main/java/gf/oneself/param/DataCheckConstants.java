package gf.oneself.param;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class DataCheckConstants {
	private static final String USERDIR = System.getProperty("user.dir") + File.separator;
	private static final String DATAPATH = USERDIR + "data" + File.separator;
	public static final Map<String, String> DATAFILE = new HashMap<String, String>();
	static {
		DATAFILE.put("csvone", DATAPATH + "csvone.csv");
		DATAFILE.put("csvtwo", DATAPATH + "csvtwo.csv");
		DATAFILE.put("csvthree", DATAPATH + "csvthree.csv");
	}
}
