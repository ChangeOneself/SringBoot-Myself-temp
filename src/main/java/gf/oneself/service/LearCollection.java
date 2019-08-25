package gf.oneself.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LearCollection {
	
	public static void test() {
		List<String> list = new ArrayList<>();
		list.add("123");
		list.add("456");
		list.add("789");
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()) {
			String temp = iterator.next();
			System.out.println(temp);
		}
		System.out.println("456µÄÎ»ÖÃ £º"+list.indexOf("456"));
	}
	
	public static void main(String[] args) {
		test();
	}
}
