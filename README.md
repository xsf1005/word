
	���������ࣺ
	DocOperation dp = new DocOperation();
	
	�������
	Table t = dp.addBaseTable(titles, lst);
	
	����ͼƬ��
	Image img1 = dp.addImage("pic/IMG_1025.JPG");
	
	��������
	Paragraph context = dp.addParagraph("Hello World!",10,10);
	
	д���ĵ�
	dp.writeDoc("doc/test.doc", t,context,img1,img2);