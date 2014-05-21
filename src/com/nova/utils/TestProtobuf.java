package com.nova.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import com.google.protobuf.CodedInputStream;
import com.nova.utils.caffe.Caffe;
import com.nova.utils.caffe.Caffe.LayerConnection;

public class TestProtobuf {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		Caffe.NetParameter netParameter =	Caffe.NetParameter.parseFrom(CodedInputStream.newInstance(new FileInputStream("lenet/lenet_iter_1000")));
		int i=0;
		for (LayerConnection layerConnection : netParameter.getLayersList()) {
			i++;
			FileWriter writer =new FileWriter("output"+i+".txt");
			writer.write(layerConnection.toString());
			writer.close();
		}
		
	}

}
