package gf.oneself.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.classmate.util.ResolvedTypeCache.Key;

import gf.oneself.controller.Controller;
import gf.oneself.param.DataCheckConstants;
import gf.oneself.param.DataFormat;
import gf.oneself.param.ResultResponse;
import gf.oneself.util.ExcelSetStyle;

@Service
public class DataCheck {
	private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);
	private static final String RESULTPATH = System.getProperty("user.dir")+File.separator+"data"+File.separator+"csvone.xlsx";
	private ResultResponse response = new ResultResponse();
	public ResultResponse excute() {
		try {
			initParams();
			dealCsvData();
			response.setStatu("OK");
			response.setResultCode("20000");
			response.setDecript("success");
			response.setInfo("no problem");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setStatu("NOK");
			response.setResultCode("40001");
			response.setDecript("failure");
			response.setInfo(e.getMessage());
		}
		return response;
	}




	private void dealCsvData() throws IOException {
		LOGGER.info(DataCheckConstants.DATAFILE.get("csvone"));
		DataFormat dataFormatOne = new DataFormat(DataCheckConstants.DATAFILE.get("csvone"));
//		dataFormatOne.showCsvData();
		DataFormat dataByDate =  dataFormatOne.formatDataByDate("day");
		
		createExcelResult(dataFormatOne);
		List<String> groupByStandr = new ArrayList<>();
		groupByStandr.add("日期");
		Map<List<String>, DataFormat> map = dataFormatOne.groupByData(groupByStandr);
//		for (List<String> key:map.keySet()) {
//			LOGGER.info("key : " + key.toString()+"  "+map.get(key).rows);
//		}
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheeh = workbook.createSheet();
		XSSFRow rowOne = sheeh.createRow(0);
		for(int i = 0;i<10;i++) {
			XSSFCell cell = rowOne.createCell(i);
			cell.setCellValue(ExcelSetStyle.TITLE_LIST.get(i));
			cell.setCellStyle(ExcelSetStyle.setTitleStyle(workbook));
		}
		int r = 1;
		for(int j= 0;j < 1000;j++) {
			List<Object> row = dataByDate.rows.get(j);
//			LOGGER.info("第 "+(j+1)+" 行");
			XSSFRow rowNext = sheeh.createRow(r);
			r++;
			for(int k = 0;k < 10;k++) {
				XSSFCell cellNext = rowNext.createCell(k);
				cellNext.setCellValue(row.get(k).toString());
			}
		}
		LOGGER.info(RESULTPATH);
		FileOutputStream outputStream = new FileOutputStream(new File(RESULTPATH));
		workbook.write(outputStream);
		outputStream.close();
		workbook.close();
	}

	private void initParams()  {
		
	}

	private void createExcelResult(DataFormat dataFormatOne) {
		// TODO Auto-generated method stub
		
	}
}
 