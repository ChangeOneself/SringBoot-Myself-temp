package gf.oneself.param;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csvreader.CsvReader;

import gf.oneself.controller.Controller;

public class DataFormat {
	private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);
	private static final int ArrayList = 0;
	public List<String> columns;
	public List<List<Object>> rows;

	public DataFormat() {
		this.columns = new ArrayList<>();
		this.rows = new ArrayList<>();
	}

	public DataFormat(String path) throws IOException {
		LOGGER.info("path :" + path);
		LOGGER.info("init start.");
		List<List<Object>> rowsFromCsv = new ArrayList<>();
		LOGGER.info("reading csv start.");
		CsvReader csvReader = new CsvReader(path, ',', Charset.forName("GBK"));
		LOGGER.info("reading csv end.");
		csvReader.readHeaders();
		String[] tempTitle =  csvReader.getHeaders();
		List<String> columnsTemp = new ArrayList<>();
		for (String string : tempTitle) {
			columnsTemp.add(string);
		}
		this.columns = columnsTemp;
		LOGGER.info("columnsTemp :"+columnsTemp.toString());
		
		while(csvReader.readRecord()) {
			List<Object> rowFromCsv = new ArrayList<>();
			String row = csvReader.getRawRecord();
			String[] rowList = row.split(",");
			for (String string : rowList) {
				rowFromCsv.add(string);
				rowsFromCsv.add(rowFromCsv);
			}
		}
		this.rows = rowsFromCsv;
		LOGGER.info("rows = "+rowsFromCsv.size());
		LOGGER.info("init  end.");
	}

	public void showCsvData() {
		LOGGER.info("csv title : " + this.columns.toString());
		List<List<Object>> rowsFromCsv = this.rows;
		for (List<Object> list : rowsFromCsv) {
			LOGGER.info("show csv data.");
			LOGGER.info(list.toString());
		}
	}
	
	public Map<List<String>, DataFormat> groupByData(List<String> groupByStandr) {
		Map<List<String>, DataFormat> group = new HashMap<>(); 
		List<String> title = this.columns;
		List<List<Object>> rowsFromCsv = this.rows;
		List<Integer> standerIndexOfList = new ArrayList<>();
		for (String index:groupByStandr) {
			standerIndexOfList.add(title.indexOf(index));
		}
		for (List<Object> row : rowsFromCsv) {
			List<String> temp = new ArrayList<>();
			for (Integer integer : standerIndexOfList) {
				temp.add(row.get(integer.intValue()).toString());
			}
			if(group.get(temp) == null) {
				DataFormat dataFormat = new DataFormat();
				dataFormat.rows.add(row);
				group.put(temp, dataFormat);
			}else {
				DataFormat  tempData = group.get(temp);
				tempData.rows.add(row);
			}
			
		}
		
		return group;
	}
	
	public DataFormat formatDataByDate(String date) {
		DataFormat dataByData = new DataFormat();
		List<String> col =  this.columns;
		dataByData.columns = col;
		int idex = col.indexOf("日期");
		List<List<Object>> rowsList = this.rows;
		List<List<Object>> needrowsList = new ArrayList<>();
		if("day".equalsIgnoreCase(date)) {
			for (List<Object> list : rowsList) {
				List<Object> needrow = new ArrayList<>();
				String string = list.get(idex).toString();
				String needString = string.substring(0, string.lastIndexOf("-"));
//				LOGGER.info("needString : "+needString);
				for (int i = 0;i<list.size();i++) {
					if( i == idex) {
						needrow.add(needString);
					}else {
						needrow.add(list.get(i));
					}
				}
//				LOGGER.info("needrow : "+needrow.toString());
				needrowsList.add(needrow);
			}
		}else if("month".equalsIgnoreCase(date)) {
			
		}
		LOGGER.info("dataByData size : "+needrowsList.size());
		dataByData.rows = needrowsList;
		return dataByData;
	}

}
