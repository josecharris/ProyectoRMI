package persistence;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import logic.Jugador;

public class Management {
	
	private ArrayList<Jugador> jugadores;
	private FilePlayer file;
	
	
	public Management(String path, String name){
		this.jugadores = new ArrayList<>();
		file = new FilePlayer();
		file.setNameFile(name);
		file.setPathFile(path);
		file.openFile();
	}
	
	public void loadPlayersInfo() throws IOException{
		ArrayList<String> records = file.reader();
		for(String row : records){
			StringTokenizer tokens = new StringTokenizer(row, ";");
			while(tokens.hasMoreElements()){
				String name = tokens.nextToken();
				String pass = tokens.nextToken();
				String puntaje = tokens.nextToken();
				jugadores.add(new Jugador(name,pass,puntaje));
			}	
		}	
	}
	
	public boolean writeNewPlayer(String name, String pass,String puntaje) throws IOException{
		file.writePlayer(name+";"+pass+puntaje+"\n");
		return true;
	}
	
	/*
	 * public void dump () throws IOException{
		 ArrayList<String> records = new ArrayList<>();
		 for(Vendedor vendedor : vendedores){
			 String row = vendedor.getName()+";"+vendedor.getPassword();
			 records.add(row);
		 }
		 file.writer(records);
	 }
	 */
	
	
	public ArrayList<Jugador> getPlayers(){
		return (ArrayList<Jugador>) jugadores.clone();
	}
	
}
