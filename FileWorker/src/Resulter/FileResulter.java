package Resulter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import executers.DataFile;

public class FileResulter implements IResulter{
	
	private FileWriter fileWriter;
	public FileResulter(FileWriter file) {
		this.fileWriter=file;
	}
	@Override
	public void display(DataFile data) {
		if(data.arrayData.size()==0) {
			write(data.root+ ":");
			printFiles("-",data.dictData);
		}
		else {
			printRoot("", data);
		}
	}
	
	private void printRoot(String prefix,DataFile data) {
		write(prefix+data.root +":");
		printFiles(prefix +"-", data.dictData);
		for(var e:data.arrayData) {
			printRoot(prefix + "-",e);
		}
	}
	
	private void printFiles(String prefix, HashMap<String, Object> dict) {
		for(var e:dict.keySet()) {
			write(prefix + e + " " + dict.get(e));
		}
	}
	
	private void write(String text) {
		try {
			fileWriter.write(text+"\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
