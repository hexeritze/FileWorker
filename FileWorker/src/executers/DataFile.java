package executers;

import java.util.ArrayList;
import java.util.HashMap;

public class DataFile {
	
	public final String root;
	public ArrayList<DataFile> arrayData;
	public HashMap<String, Object> dictData;
	
	public DataFile(String name) {
		root = name;
		arrayData = new ArrayList<DataFile>();
		dictData = new HashMap<String, Object>();
	}
}
