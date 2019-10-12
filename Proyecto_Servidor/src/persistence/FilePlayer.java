package persistence;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class FilePlayer extends FilePlain{
	
	public FilePlayer(){
		
	}
	
	public ArrayList<String> reader() throws IOException{
		ArrayList<String> output = new ArrayList<>();
		StringTokenizer tokens = new StringTokenizer(ReadFile(), "\n");
		while (tokens.hasMoreElements()) {
			output.add(tokens.nextToken());	
		}
		return output;
	}
	
	public void writer(ArrayList<String> file) throws IOException{
		String saved = new String();
		for (String record : file) {
			saved += record+"\n";
		}
		writeFile(saved);
	}
}
