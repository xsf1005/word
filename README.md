
	创建操作类：
	DocOperation dp = new DocOperation();
	
	创建表格：
	Table t = dp.addBaseTable(titles, lst);
	
	创建图片：
	Image img1 = dp.addImage("pic/IMG_1025.JPG");
	
	创建段落
	Paragraph context = dp.addParagraph("Hello World!",10,10);
	
	写入文档
	dp.writeDoc("doc/test.doc", t,context,img1,img2);