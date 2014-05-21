package com.nova.utils;

public class TestCNN {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		runTrain();

	}
	/**
	 * train cnn
	 * @return true if trained success 
	 */
	static boolean runTrain() {
		RuntimeResponse response = RuntimeHelper.execute(TestLeveldb.CAFFE_ROOT+"/examples/lenet/train_lenet.sh");
		if (response.isSuccess()) {
			System.out.println(response.getOutput());
			return true;
		} else {
			System.err.println(response.getError());
			System.out.println(response.getOutput());
			return false;
		}
	}
	/**
	 * test cnn
	 * @return true if test success 
	 */
	static boolean runTest() {
		RuntimeResponse response = RuntimeHelper.execute(TestLeveldb.CAFFE_ROOT+"/examples/lenet/test_lenet.sh");
		if (response.isSuccess()) {
			System.out.println(response.getOutput());
			return true;
		} else {
			System.err.println(response.getError());
			System.out.println(response.getOutput());
			return false;
		}
	}
}
