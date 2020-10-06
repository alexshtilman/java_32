package telran.performance;

import java.io.File;
import java.io.IOException;

import telran.tests.StandartFileCopyTest;
import telran.tests.StreamFileCopyTest;

public class FileUtilsPerformanceAppl {

	public static void main(String[] args) throws IOException {
		final int N_runs = 1;
		final int N_runsSmall = 200;	
		
		final File sourceSmall = new File("src/telran/tests/10m.pdf");
		final File destSmall = new File("src/telran/tests/10m_copy.pdf");
		StandartFileCopyTest standartFileCopySmall = new StandartFileCopyTest(sourceSmall, destSmall, "StandartFileCopyTest", N_runsSmall);	
		StreamFileCopyTest streamFileCopy100bSmall = new StreamFileCopyTest(sourceSmall, destSmall,100, "StreamFileCopyTest (buffer 100b)", N_runsSmall);
		StreamFileCopyTest streamFileCopy100mSmall = new StreamFileCopyTest(sourceSmall, destSmall, 1024 * 1024 * 100, "StreamFileCopyTest (buffer 100m)", N_runsSmall);
		StreamFileCopyTest streamFileCopymaxSmall = new StreamFileCopyTest(sourceSmall, destSmall,(int) Runtime.getRuntime().freeMemory(), "StreamFileCopyTest (buffer max)", N_runsSmall);
		
		
		//file size = 2874878322
		final File source = new File("src/telran/tests/Raised.by.Wolves.S01E10.1080p.rus.LostFilm.TV.mkv");
		final File dest = new File("src/telran/tests/Raised.by.Wolves.S01E10.1080p.rus.LostFilm.TV_copy.mkv");
		StandartFileCopyTest standartFileCopy = new StandartFileCopyTest(source, dest, "StandartFileCopyTest", N_runs);	
		StreamFileCopyTest streamFileCopy100b = new StreamFileCopyTest(source, dest,100, "StreamFileCopyTest (buffer 100b)", N_runs);
		StreamFileCopyTest streamFileCopy100m = new StreamFileCopyTest(source, dest, 1024 * 1024 * 100, "StreamFileCopyTest (buffer 100m)", N_runs);
		StreamFileCopyTest streamFileCopymax = new StreamFileCopyTest(source, dest,(int) Runtime.getRuntime().freeMemory(), "StreamFileCopyTest (buffer max)", N_runs);
		
		System.out.printf("file size = %s\n", sourceSmall.length());
		//file size = 9621283
		//Test: StandartFileCopyTest, complete after 1921, count of runs - 200
		//Test: StreamFileCopyTest (buffer 100b), complete after 51632, count of runs - 200
		//Test: StreamFileCopyTest (buffer 100m), complete after 5091, count of runs - 200
		//Test: StreamFileCopyTest (buffer max), complete after 26026, count of runs - 200
		
		standartFileCopySmall.run();
		streamFileCopy100bSmall.run();
		streamFileCopy100mSmall.run();
		streamFileCopymaxSmall.run();
		
		System.out.printf("file size = %s\n", source.length());
		//file size = 2874878322
		//Test: StandartFileCopyTest, complete after 2398, count of runs - 1
		//Test: StreamFileCopyTest (buffer 100b), complete after 77947, count of runs - 1
		//Test: StreamFileCopyTest (buffer 100m), complete after 4660, count of runs - 1
		//Test: StreamFileCopyTest (buffer max), complete after 6228, count of runs - 1
				
		standartFileCopy.run();
		streamFileCopy100b.run();
		streamFileCopy100m.run();
		streamFileCopymax.run();
	}

}
