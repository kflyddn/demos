package com.flink.demo.source;

import org.apache.flink.api.common.io.FileInputFormat;
import org.apache.flink.api.java.io.TextInputFormat;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.source.FileProcessingMode;
import org.apache.flink.streaming.api.functions.source.InputFormatSourceFunction;

/**
 * Created by DebugSy on 2018/5/9.
 */
public class FileSource implements Source{

	private StreamExecutionEnvironment env;

	private String path;

	public FileSource(StreamExecutionEnvironment env, String path) {
		this.env = env;
		this.path = path;
	}

	public DataStreamSource read() {
		DataStreamSource<String> dataStreamSource = env.readTextFile(path);
		return dataStreamSource;
	}

	public DataStreamSource read(FileProcessingMode mode){
		FileInputFormat inputFormat = new TextInputFormat(null);
		inputFormat.setNestedFileEnumeration(true);
		DataStreamSource dataStreamSource = env.readFile(inputFormat, path, mode, 3000);
		return dataStreamSource;
	}

}