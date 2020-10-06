package telran.tests;

import java.io.File;
import java.io.IOException;

import telran.performance.PerformanceTest;

import static telran.io.FileUtils.*;

public class StandartFileCopyTest extends PerformanceTest{

	File inputFileName;
	File outputFileName;
	
	public StandartFileCopyTest(File inputFileName ,File outputFileName,String testName, int nRuns) throws IOException {
		super(testName, nRuns);
		this.inputFileName = inputFileName;
		this.outputFileName = outputFileName;
		cleanFile(this.outputFileName);
	}

	@Override
	protected void runTest() {
		try {
			cleanFile(this.outputFileName);
			standartFileCopy(inputFileName,outputFileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
