package com.xg.hadoop.wordcount;

import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Intellij IDEA
 * Author: xionggao
 * Desc:
 * Date: 2017/8/13
 * Email: xionggao@terminus.io
 */
public class TestHdfs {
	
	
	public static void readFile() throws Exception{
		URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory()); //注册url流 处理器工厂
		
		URL url = new URL("hdfs://localhost:8020/User/hadoop/1.txt");
		URLConnection connection = url.openConnection();
		InputStream inputStream = connection.getInputStream();
		byte[] buf = new byte[inputStream.available()];
		inputStream.read(buf);
		inputStream.close();
		System.out.println(new String(buf));
		
	}
	
	public static void main(String[] args) throws Exception{
		readFile();
	}
	
}
