import java.io.*;
import java.nio.file.*;
public class FilesystemsTestAppl {

	public static void main(String[] args)throws Exception {
		FileSystem fs = FileSystems.getDefault();
		System.out.println("Total space of each store and root directories");
		fs.getFileStores()
		.forEach(store -> {
			try {
				System.out.println(store.getTotalSpace());
			} catch (IOException e) {
				
			}
		});
		fs.getRootDirectories().forEach(System.out::println);
		System.out.println("*".repeat(50));
		System.out.println("Path - Absolute path - file name - normalize");
		Path current = fs.getPath("src");
		System.out.printf("current directory name: %s, absolute path to current directory: %s,\n"
				+ " path with normalization: %s\n", current.getFileName(),
				current.toAbsolutePath(), current.toAbsolutePath().normalize());
		System.out.println("*".repeat(50));
		System.out.println("Usage Files utils");
		if(Files.exists(current)) {
			if (Files.isDirectory(current)) {
			System.out.printf("%s is directory and its content see below\n",current.toAbsolutePath()
					.normalize() );
			Files.list(current).forEach(System.out::println);
		} else {
			System.out.printf("%s is file\n", current);
		}
		} else {
			System.out.printf("%s doesn't exist\n", current);
		}
		System.out.println("*".repeat(50));
		InputStream input = Files.newInputStream(fs.getPath("src/FilesystemsTestAppl.java"));
		OutputStream output = Files.newOutputStream(fs.getPath("src/FilesystemsTestApplCopy"));
		byte[] buffer = new byte[input.available()];
		input.read(buffer);
		output.write(buffer);
		
		
		
		

	}

}
