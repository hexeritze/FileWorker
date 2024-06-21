package FileCommands;

import Resulter.IResulter;
import executers.FileWorker;
import executers.IExecutable;

public class FileCommand implements ICommand {
	
	IExecutable executer;
	IResulter resulter;
	FileWorker fileworker;
	
	public FileCommand(IExecutable executer,IResulter resulter,FileWorker fileworker ) {
		this.executer = executer;
		this.resulter = resulter;
		this.fileworker = fileworker;
	}
	
	@Override
	public void doCommand() {
		resulter.display(fileworker.execute(executer));
	}
}
