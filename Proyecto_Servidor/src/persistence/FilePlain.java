package persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FilePlain {
	private Path path;
	private String pathFile;
	private String nameFile;
	private String separator;
	
	public FilePlain(){
		
	}
	public void openFile(){
		path = Paths.get(getPathFile()+getNameFile());
	}
	
	public String ReadFile() throws IOException {
			BufferedReader input = Files.newBufferedReader(path,Charset.defaultCharset());
			StringBuilder output = new StringBuilder();
			String line = null;
			while((line = input.readLine()) != null){
				output.append(line+"\n");
			}
			input.close();
			return output.toString();
	}
	
	public void writeFile(String dates) throws IOException{
		BufferedWriter saved = Files.newBufferedWriter(path, Charset.defaultCharset(),StandardOpenOption.CREATE,
				StandardOpenOption.WRITE,StandardOpenOption.TRUNCATE_EXISTING);
		
		saved.write(dates,0,dates.length());
		saved.close();
	}
	
	public void writePlayer(String dates) throws IOException{
		BufferedWriter saved = Files.newBufferedWriter(path, Charset.defaultCharset(),StandardOpenOption.CREATE,
				StandardOpenOption.WRITE,StandardOpenOption.APPEND);
		
		saved.write(dates,0,dates.length());
		saved.close();
	}
	
	public String getPathFile() {
		return pathFile;
	}
	public void setPathFile(String pathFile) {
		this.pathFile = pathFile;
	}
	public String getNameFile() {
		return nameFile;
	}
	public void setNameFile(String nameFile) {
		this.nameFile = nameFile;
	}
	public String getSeparator() {
		return separator;
	}
	public void setSeparator(String separator) {
		this.separator = separator;
	}
	
	
}
