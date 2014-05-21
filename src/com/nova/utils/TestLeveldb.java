package com.nova.utils;

import org.iq80.leveldb.*;
import static org.fusesource.leveldbjni.JniDBFactory.*;

import java.awt.Image;
import java.io.*;

public class TestLeveldb {
	public static final String CAFFE_ROOT="/home/zxy/Downloads/caffe-master/";

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Options options = new Options();
		options.createIfMissing(true);
		DB db = null;
		try {
			db = factory.open(new File("mnist-test-leveldb"), options);
			DBIterator iterator = db.iterator();
			int i = 0;
			try {
				for (iterator.seekToFirst(); iterator.hasNext(); iterator.next()) {
					String key = asString(iterator.peekNext().getKey());
					byte[] value = iterator.peekNext().getValue();
					if (i < 10) {
						FileOutputStream fout = new FileOutputStream(key);
						//将字节写入文件
						fout.write(value);
						fout.close();
					}
					i++;
					System.out.println(i + ":" + key);
				}
			} finally {
				// Make sure you close the iterator to avoid resource leaks.
				iterator.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// Make sure you close the db to shutdown the 
			// database and avoid resource leaks.
			db.close();
		}

	}
	

}
