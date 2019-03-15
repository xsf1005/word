package com.xsf.doc.utils;

import java.io.FileOutputStream;
import java.io.OutputStream;

import sun.misc.BASE64Decoder;

public class ImageOperation {

	/**
	 * @Description: ��base64�����ַ���ת��ΪͼƬ
	 * @Author: 
	 * @CreateTime: 
	 * @param imgStr base64�����ַ���
	 * @param path ͼƬ·��-���嵽�ļ�
	 * @return
	*/
	public static boolean generateImage(String imgStr, String path) {
		if (imgStr == null)
			return false;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			byte[] b = decoder.decodeBuffer(imgStr);
			// ��������
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {
					b[i] += 256;
				}
			}
			OutputStream out = new FileOutputStream(path);
	        out.write(b);
	        out.flush();
	        out.close();
			return true;
		} catch (Exception e) {
				e.printStackTrace();
		}
			return false;
	}
}
