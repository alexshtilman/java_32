package telran.io;

import java.io.*;
import java.nio.file.*;

public class FileUtils {
	/**
	 * prints directory structure of the given path directory and depth if depth
	 * equals 0 it prints all directory structure from the given start
	 * 
	 * @param path
	 * @param depth
	 * @throws IOException
	 */
	public static void displayDirectoryContent(Path path, int depth) throws IOException {
		if (depth < 0) {
			throw new IllegalArgumentException("Path deep can't be negative!");
		}
		displayDirContent(path, 0, depth);
	}

	public static void cleanFile(File file) throws IOException {
		if (Files.exists(file.toPath())) {
			Files.delete(file.toPath());
		} else {
			// file does not exit!
		}
	}

	private static void displayDirContent(Path path, int init, int max) throws IOException {
		if (init > max && max != 0)
			return;
		if (Files.isDirectory(path)) {
			System.out.printf("  ".repeat(init) + "%s\n", path.getFileName());
			Files.list(path).forEach(p -> {
				try {
					displayDirContent(p, init + 1, max);
				} catch (IOException e) {
					e.printStackTrace();
				}
			});

		} else {
			System.out.printf("  ".repeat(init) + "%s\n", path.getFileName());
		}

	}

	public static void standartFileCopy(File inputFileName, File outputFileName) throws IOException {
		Files.copy(inputFileName.toPath(), outputFileName.toPath());
	}

	public static void streamFileCopy(File inputFileName, File outputFileName, int bufferSize) throws IOException {

		if (Files.notExists(inputFileName.toPath())) {
			throw new IllegalArgumentException("input file does'n exist!");
		}
		if (Files.exists(outputFileName.toPath())) {
			throw new IllegalArgumentException("output file already exist!");
		}
		if (bufferSize == 0) {
			throw new IllegalArgumentException("bufferSize can't be zero!");
		}
		try {
			InputStream is = new FileInputStream(inputFileName);
			OutputStream os = new FileOutputStream(outputFileName);
			if (bufferSize > Integer.MAX_VALUE - 4 || bufferSize < 0) {
				bufferSize = Integer.MAX_VALUE - 4;
			}
			byte[] buffer = new byte[bufferSize];
			int length;
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
			is.close();
			os.close();
		} catch (Exception e) {
			throw new IOException();
		}
	}
}
