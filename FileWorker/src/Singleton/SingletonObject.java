package Singleton;

import java.util.LinkedList;

import FileCommands.ICommand;

public class SingletonObject {
	private static SingletonObject object;
	private static LinkedList<ICommand> queue;
	private SingletonObject() {
		queue = new LinkedList<ICommand>();
	}
	public static SingletonObject create() {
		if(object==null) {
			object = new SingletonObject();
		}
		return object;
	}
	public void addCommand(ICommand command) {
		queue.add(command);
	}

	public void doCommands() {
		if(queue.isEmpty()) throw new IllegalStateException("queue is emty!");
		queue.pollFirst().doCommand();
	}
	public boolean isEmpty() {
		return queue.isEmpty();
	}
}
