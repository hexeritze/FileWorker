package executers;

import java.io.File;

public class SizeExecuter implements IExecutable{

	@Override
	public Object proceess(File f) {
		return f.length();
	}

}
