package gf.oneself.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.stereotype.Service;

@Service
public class MyInfomation {
	public void excute(String path) {
		System.out.println("myinfomation start");
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("param.properties");
		Properties properties = new Properties();

		try {
			properties.load(inputStream);
			String id = properties.getProperty("id");
			System.out.println("id =" + id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
