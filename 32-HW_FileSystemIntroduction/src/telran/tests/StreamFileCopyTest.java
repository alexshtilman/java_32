package telran.tests;

import java.io.File;
import java.io.IOException;

import telran.performance.PerformanceTest;

import static telran.io.FileUtils.*;

public class StreamFileCopyTest extends PerformanceTest{

	File inputFileName;
	File outputFileName;
	int bufferSize;
	
	public StreamFileCopyTest(File inputFileName ,File outputFileName,int bufferSize,String testName, int nRuns) throws IOException {
		super(testName, nRuns);
		this.inputFileName = inputFileName;
		this.outputFileName = outputFileName;
		this.bufferSize = bufferSize;
		cleanFile(this.outputFileName);
	}

	@Override
	protected void runTest() {
		try {
			cleanFile(this.outputFileName);
			streamFileCopy(inputFileName,outputFileName, bufferSize);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
