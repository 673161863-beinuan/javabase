package com.atguigu.io.input;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 使用数组进行复制
 */
public class copyDemo {
	public static void main(String[] args) {

		// 这样虽然可以实现复制 但是效率极低
		FileInputStream fis = null;
		FileOutputStream fos = null;
		int len = 0;
		long s = System.currentTimeMillis();
		try {
			fis = new FileInputStream("G:\\BigData\\software\\VMware-workstation-full-15.0.4.exe");
			fos = new FileOutputStream("C:\\VMware-workstation-full-15.0.4.exe");
			// 使用数组形式复制  可以1024 * 10
			byte[] bytes = new byte[1024];
			// read(bytes) 读取到的内容会放到byte数组中
			while ((len = fis.read(bytes)) != -1) {
				// bytes是复制什么 0是代表从哪开始复制 len代表复制的长度
				fos.write(bytes, 0, len);
			}
			System.out.println("复制完成");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
				if (fis != null) {
					fis.close();
				}
				System.out.println("关闭流");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		long e = System.currentTimeMillis();
		System.out.println(e-s);
	}

}
