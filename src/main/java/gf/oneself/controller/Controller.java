package gf.oneself.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gf.oneself.param.ResultResponse;
import gf.oneself.service.DataCheck;
import gf.oneself.service.MyInfomation;

@RestController
public class Controller {
	private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);
	@Autowired
	MyInfomation info;
	@Autowired
	DataCheck dataCheck;

	@RequestMapping("/controller")
	public String controllerStart() {
		return "this is a test from controllerclass.";
	}

	@RequestMapping("/loadinfo")
	public String getInfo() {
		info.excute("123");
		return "info";
	}

	@RequestMapping("/dealCsvFile")
	public  ResultResponse dealCsvFile() {
		LOGGER.info("/dealCsvFile starting");
		return dataCheck.excute();
	}
}
