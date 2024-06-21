package executers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MD5Executer implements IExecutable{
	@Override
	public Object proceess(File file) {
		StringBuilder sb = new StringBuilder();
		if(!file.canRead()) throw new IllegalStateException("Can't read file");
		MessageDigest md;
		byte[] digest = new byte[0];
		try {
			md = MessageDigest.getInstance("MD5");
            md.update(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
            digest = md.digest();
            for(byte b : digest) {
            	sb.append(String.format("%02x", b));
            }
            
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
}
