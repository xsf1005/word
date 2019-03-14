package com.xsf.doc.utils;

import java.awt.Color;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.rtf.RtfWriter2;


/**
 * word 插入表格与图片
 * @author xsf
 * @link xsf1005@163.com
 */
public class DocOperation {

	/**
	 * 
	 * @param titles  表头
	 * @param lst   数据内容
	 * @return table  返回对象
	 */
	public Table addBaseTable(String[] titles,List<Map<String,Object>> lst){
		try{
			Table table = new Table(titles.length);
			table.setBorderWidth(1);
			table.setBorderColor(Color.BLACK);
			table.setPadding(0);
			table.setSpacing(0);
			for(String title : titles){
				Cell cell = new Cell(title);
				cell.setHeader(true);
				table.addCell(cell);
			}
			table.endHeaders();
			
			for (Map<String, Object> map : lst) {
				for(String title : titles){
					Cell cell = new Cell(""+map.get(title));
					table.addCell(cell);
				}
			}
			return table;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 图片路径
	 * @param picPath
	 * @return
	 */
	public Image addImage(String picPath){	
		try {
			Image img = Image.getInstance(picPath);
			img.setAlignment(Image.ALIGN_CENTER);
			 float imageWidth = img.getScaledWidth();
	         float pageMargin = 36 * 2;
	         float maxWidth = PageSize.A4.getWidth() - pageMargin;
	         float maxHeight = PageSize.A4.getHeight() - pageMargin;
	         if (imageWidth * 0.75 > maxWidth) {
	            img.scaleToFit(maxWidth / 0.85f, maxHeight / 0.85f);
	         }
	        return img;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 单位：磅，默认10磅
	 * @param context
	 * @return
	 */
	public Paragraph addParagraph(String context){	
		return addParagraph(context, 10, 10);
	}
	
	/**
	 * 
	 * @param context 段落内容
	 * @param before  开始的距离
	 * @param after   结束的距离  
	 * @return
	 */
	public Paragraph addParagraph(String context,int before,int after){
		Paragraph para = new Paragraph(context);
		para.setSpacingBefore(before);
		para.setSpacingAfter(after);
		return para;
	}
	
	/**
	 * 
	 * @param filepath  文档路径
	 * @param ele  Table、Image、Paragraph
	 */
	public void writeDoc(String filepath,Element ...ele){
		Document doc = null;
		try{
			doc = new Document(PageSize.A4);
			RtfWriter2.getInstance(doc, new FileOutputStream(filepath));
			doc.open();
			for (Element element : ele) {
				doc.add(element);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(doc !=null && doc.isOpen()){
				doc.close();
			}
		}
	}
	
}
