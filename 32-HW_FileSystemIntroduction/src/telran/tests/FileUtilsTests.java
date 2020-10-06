package telran.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import static telran.io.FileUtils.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileUtilsTests {
	final File dest = new File("src/telran/tests/Raised.by.Wolves.S01E10.1080p.rus.LostFilm.TV_copy.mkv");
	final File source = new File("src/telran/tests/Raised.by.Wolves.S01E10.1080p.rus.LostFilm.TV.mkv"); 
	
	@BeforeEach
	void setup() {
		try {
			cleanFile(dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testDisplayDirectoryContent() throws IOException {
		FileSystem fs = FileSystems.getDefault();
		Path currentDir = fs.getPath(".");
		try {
			displayDirectoryContent(currentDir, 0);
		} catch (Exception e) {
			fail();
		}
		try {
			displayDirectoryContent(currentDir, 2);
		} catch (Exception e) {
			fail();
		}
		try {
			displayDirectoryContent(currentDir, 9999);
		} catch (Exception e) {
			fail();
		}
		try {
			displayDirectoryContent(currentDir, -2333);
			fail();
		} catch (IllegalArgumentException e) {
			// expected exception
		} catch (IOException e) {
			fail();
		}

	}

	@Test
	void testStreamFileCopy() throws IOException {
		// vm arguments -ea -Xms8048m -Xmx16000m
		cleanFile(dest);
		try {
			streamFileCopy(source, dest, 100);
		} catch (Exception e) {
			// unexpected
			fail();
		}
		cleanFile(dest);
		try {
			streamFileCopy(source, dest, 1024 * 1024 * 100);
		} catch (Exception e) {
			// unexpected
			fail();
		}
		cleanFile(dest);
		try {
			streamFileCopy(source, dest, (int) Runtime.getRuntime().freeMemory());
		} catch (Exception e) {
			// unexpected
			fail();
		}

	}

	@Test
	void testStandartFileCopy() throws IOException {
		cleanFile(dest);
		try {
			standartFileCopy(source, dest);
		} catch (Exception e) {
			// unexpected
			fail();
		}

	}
}
