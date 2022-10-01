package Pages.Trello;

import java.io.IOException;
import java.lang.Process;


public class scratchpad {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		String cmdString = "cmd wget -p";
		Process sProcess = Runtime.getRuntime().exec(cmdString);
		int exitsStatus = sProcess.waitFor();
		String currentWorkingDirectoryString = System.getProperty("user.dir");
		System.out.println(exitsStatus);
		System.out.println(currentWorkingDirectoryString);
	}
}
