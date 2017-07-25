package casper.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ExecuteCommand {
	String cmd="";
	
	public ExecuteCommand() {
		cmd="ping localhost";
	}
	
	public ExecuteCommand(String cmd) {
		this.cmd=cmd;
	}
	
	public String run() {
		StringBuffer output = new StringBuffer();
		Process p;
		try {
			p = Runtime.getRuntime().exec(this.cmd);
			/*p.waitFor();*/
				BufferedReader reader =new BufferedReader(new InputStreamReader(p.getInputStream()));
	            String line = "";
	   			while ((line = reader.readLine())!= null) {
					output.append(line + "\n");
				}	

		} catch (Exception  e) {
			e.printStackTrace();
			return e.getMessage();
			
		}

		return output.toString();

	}
}
