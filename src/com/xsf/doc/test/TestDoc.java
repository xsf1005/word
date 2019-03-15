package com.xsf.doc.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.xsf.doc.utils.DocOperation;

public class TestDoc {

	public static void main(String[] args) {
		DocOperation dp = new DocOperation();
		String titles[] = {"ID","NAME","AGE"};
		List<Map<String,Object>> lst = new ArrayList<>();
		for(int i=0;i<10;i++){
			Map<String,Object> map = new HashMap<String, Object>();
			for (String s : titles) {
				map.put(s, s+"_"+i);
			}
			lst.add(map);
		}
		Table t = dp.addBaseTable(titles, lst);
		Image img1 = dp.addImage("pic/IMG_1025.JPG");
		Image img2 = dp.addImage("pic/cpu.PNG");
		Paragraph context = dp.addParagraph("Hello World!",10,10);
		dp.writeDoc("doc/test.doc", t,context,img2,img1);
	}
}
