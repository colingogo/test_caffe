/**
 * 
 */
package com.nova.utils;

/**
 * @author zhaoxy
 * 
 */
public class RuntimeResponse {
	private static final int EXIT_VALUE_SUCCESS = 0;
	int exitValue;
	StringBuffer errorBuffer = new StringBuffer();
	StringBuffer outputBuffer = new StringBuffer();

	public boolean isSuccess() {
		return exitValue == EXIT_VALUE_SUCCESS;
	}

	public int getExitValue() {
		return exitValue;
	}

	public void setExitValue(int exitValue) {
		this.exitValue = exitValue;
	}

	public StringBuffer getErrorBuffer() {
		return errorBuffer;
	}

	public String getError() {
		return errorBuffer.toString();
	}

	public String getOutput() {
		return outputBuffer.toString();
	}

	public StringBuffer getOutputBuffer() {
		return outputBuffer;
	}
}
