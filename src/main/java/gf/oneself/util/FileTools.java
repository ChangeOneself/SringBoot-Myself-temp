package gf.oneself.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import gf.oneself.controller.Controller;

public class FileTools {
	private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);
	public static File createFile(String path) throws IOException {
		File file = new File(path);
		if (file.exists()) {
			LOGGER.info("file exists. Don't build file.");
			return file;
		}
		if (!file.isDirectory()) {
			LOGGER.info("This is a file.");
			file.createNewFile();
			return file;
		} else {
//			LOGGER.info("This is a directory.");
			file.mkdirs();
			return file;
		}

	}
	
	public static boolean zip(String sourceFilePath,String zipFilePath) throws FileNotFoundException 
	{
		File sourceFile = new File(sourceFilePath);
		File zipFile = new File(zipFilePath);
		BufferedReader bufferedReader = new BufferedReader(new FileReader(sourceFile));
		InputStream inputStream;
		return false;
	}
	
}
