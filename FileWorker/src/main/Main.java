package main;

import FileCommands.FactoryCommand;
import Singleton.SingletonObject;

public class Main {
	

	public static void main(String[] args) {
		SingletonObject singleton = SingletonObject.create();
		FactoryCommand factory = new FactoryCommand();
		
		String path = "..\\..";
		String outpath = "..\\..";
		singleton.addCommand(factory.DoMD5ToConsole(path));
		singleton.addCommand(factory.DoMD5ToFile(path,outpath));
		while(!singleton.isEmpty()) {
			singleton.doCommands();
		}
	}

}
