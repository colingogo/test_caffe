/**
 * 
 */
package com.nova.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author zhaoxy
 * 
 */
public class RuntimeHelper {

	final static Runtime runtime = Runtime.getRuntime();

	public static RuntimeResponse execute(String command) {
		
		return execute(new String[] { command });
	}

	public static RuntimeResponse execute(String... cmdarray) {
		RuntimeResponse runtimeReponse = new RuntimeResponse();
		Process process = null;
		try {
			process = runtime.exec(cmdarray,null,null);
			process.waitFor();
			InputStream inputStream = process.getInputStream();
			if (inputStream != null) {
				BufferedReader bufferReader = new BufferedReader(
						new InputStreamReader(inputStream));
				if (bufferReader != null) {
					String line;
					while ((line = bufferReader.readLine()) != null) {
						runtimeReponse.getOutputBuffer().append(line);
					}
					bufferReader.close();
					inputStream.close();
				}
			}
			InputStream errorStream = process.getErrorStream();
			if (errorStream != null) {
				BufferedReader bufferReader = new BufferedReader(
						new InputStreamReader(errorStream));
				if (bufferReader != null) {
					String line;
					while ((line = bufferReader.readLine()) != null) {
						runtimeReponse.getErrorBuffer().append(line);
					}
					bufferReader.close();
					errorStream.close();
				}
			}

			runtimeReponse.setExitValue(process.exitValue());
			process.destroy();
			return runtimeReponse;
		} catch (Exception e) {
			if (process != null) {
				runtimeReponse.setExitValue(process.exitValue());
				process.destroy();
			}
			runtimeReponse.getErrorBuffer().append(e.getMessage());
		}
		return runtimeReponse;
	}

}
