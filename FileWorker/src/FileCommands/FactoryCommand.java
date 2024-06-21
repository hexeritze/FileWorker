package FileCommands;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Resulter.ConsoleResulter;
import Resulter.FileResulter;
import executers.FileWorker;
import executers.MD5Executer;

public class FactoryCommand {
	public ICommand DoMD5ToConsole(String path) {
		FileWorker fileworker = new FileWorker(path);
		fileworker.setRecursive(true);
		return new FileCommand(new MD5Executer(), new ConsoleResulter(), fileworker);
	}
	public ICommand DoMD5ToFile(String path,String outpath) {
		FileWorker fileworker = new FileWorker(path);
		fileworker.setRecursive(true);
		
		return new FileCommand(new MD5Executer(), new FileResulter(createFile(outpath)), fileworker);
	}
	
	private FileWriter createFile(String outPath) {
		var file = new File(outPath+"\\out.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		FileWriter file1;
		try {
			file1 = new FileWriter(file);
			return file1;
		} catch (IOException e) {
			e.printStackTrace();
		}
		throw new IllegalStateException("Can't create file by outPath");
	}
}
