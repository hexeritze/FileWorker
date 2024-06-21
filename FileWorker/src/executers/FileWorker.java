package executers;

import java.io.File;
public class FileWorker {
	
	private File file;
	private boolean isRecursive;
	public FileWorker(String path) {
		file = new File(path);
		if (!file.exists()) {
			throw new IllegalStateException("Error path");
		}
	}
	
	public void setRecursive(boolean b) {
		isRecursive = b;
	}
	
	public boolean getRecursive() {
		return isRecursive;
	}
	public DataFile execute(IExecutable executer) {
		DataFile data = new DataFile(file.getName());
		if(isRecursive) {
			RecursiveWork(executer,file,data);
		}
		else {
			DefaultWork(executer,file,data);
		}
		return data;
	}
	public void RecursiveWork(IExecutable executer, File file, DataFile data) {
		File fileWork;
		String[] listFile = file.list();
		DataFile dataWork;
		DefaultWork(executer,file,data);
		for(var e : listFile) {
			fileWork = new File(file.getAbsolutePath()+"\\"+e);
			if(fileWork.isDirectory()) {
				dataWork = new DataFile(e);
				data.arrayData.add(dataWork);
				RecursiveWork(executer,fileWork, dataWork);
			}
		}
	}
	public void DefaultWork(IExecutable executer, File file, DataFile data) {
		File fileWork;
		String[] listFile = file.list();
		for (var e : listFile) {
			fileWork = new File(file.getAbsolutePath()+"\\"+e);
			if (fileWork.isFile()) {
				data.dictData.put(fileWork.getName(),executer.proceess(fileWork));
			}
		}
	}
	
}
