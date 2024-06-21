package Resulter;

import java.util.HashMap;

import executers.DataFile;

public class ConsoleResulter implements IResulter{
	
	@Override
	public void display(DataFile data) {
		if(data.arrayData.size()==0) {
			System.out.println(data.root+ ":");
			printFiles("-",data.dictData);
		}
		else {
			printRoot("", data);
		}
	}
	
	private void printRoot(String prefix,DataFile data) {
		System.out.println(prefix+data.root +":");
		printFiles(prefix +"-", data.dictData);
		for(var e:data.arrayData) {
			printRoot(prefix + "-",e);
		}
	}
	
	private void printFiles(String prefix, HashMap<String, Object> dict) {
		for(var e:dict.keySet()) {
			System.out.println(prefix + e + " " + dict.get(e));
		}
	}
}
