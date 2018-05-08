package io1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		File[] roots = File.listRoots();
		System.out.println(Arrays.toString(roots));
		File dirWorkspaceBootcamp = new File("D:\\BC1_1018\\BC16");
		System.out.println("BC1_1018 exists:" + dirWorkspaceBootcamp.exists());
		System.out.println("BC1_1018 is file:" + dirWorkspaceBootcamp.isFile());
		System.out.println("BC1_1018 is dir:" + dirWorkspaceBootcamp.isDirectory());
		File[] files = dirWorkspaceBootcamp.listFiles();
		System.out.println(Arrays.toString(files));
		System.out.println(calcJavaFileSizeSum(dirWorkspaceBootcamp));

		File newDir = new File("pufi");
		newDir.mkdirs();
		File newFile = new File(newDir, "fifi.zip");
		newFile.createNewFile();

		File tmpFile = File.createTempFile("pufi", ".txt");
		tmpFile.deleteOnExit();
		System.out.println(tmpFile.getAbsolutePath());
		
		OutputStream os = new FileOutputStream(newFile);
		os.write(65);
		os.write(66);
		os.write(67);
		os.close();

	}

	static int calcJavaFileSizeSum(File pStartDir) {
		int result = 0;
		File[] files = pStartDir.listFiles();
		for (File f : files) {
			if (f.isDirectory()) {
				result = result + calcJavaFileSizeSum(f);
			} else if (f.isFile()) {
				if (f.getName().endsWith(".java")) { // abraca.java
					result += f.length();
				}
			}
		}
		return result;
	}

}
