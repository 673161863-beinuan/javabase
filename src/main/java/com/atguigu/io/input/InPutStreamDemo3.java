package com.atguigu.io.input;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 删除文件
 * 
 * @author Administrator
 * 
 *
 *
 */
public class InPutStreamDemo3 {

	public static void main(String[] args) throws IOException {

		delDir(new File("G:\\Tencent"));
	}

	public static void delDir(File file) {
		if (file.isDirectory()) {
			File zFiles[] = file.listFiles();
			for (File file2 : zFiles) {
				delDir(file2);
			}
			boolean delete = file.delete();
			System.out.println(delete);
		} else {
			boolean b = file.delete();
			System.out.println(b);
		}
	}
}
