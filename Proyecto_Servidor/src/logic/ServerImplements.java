package logic;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.StringTokenizer;

import persistence.FilePlayer;
import persistence.Management;
import remote.RemoteInterface;

public class ServerImplements extends UnicastRemoteObject implements RemoteInterface{

	private ArrayList<Jugador> jugadores;
	private Management infoplayer;
	//ESTADOS
	private FilePlayer stateplayer1;
	private FilePlayer stateplayer2;
	private FilePlayer stateplayer3;
	private FilePlayer fileInfo;
	private FilePlayer filePlayerWinners;
	private FilePlayer initPlayerOne;
	private FilePlayer initPlayerTwo;
	private FilePlayer initPlayerThree;
	//INFO
	private FilePlayer tableplayer1;
	private FilePlayer tableplayer2;
	private FilePlayer tableplayer3;
	private FilePlayer win;
	
	public ServerImplements() throws IOException {
		super();
		// TODO Auto-generated constructor stub
		stateplayer1 = new FilePlayer();
		stateplayer1.setPathFile("resource/files/");
		stateplayer1.setNameFile("initplayer1.txt");
		stateplayer1.openFile();
		
		stateplayer2 = new FilePlayer();
		stateplayer2.setPathFile("resource/files/");
		stateplayer2.setNameFile("initplayer2.txt");
		stateplayer2.openFile();
		
		stateplayer3 = new FilePlayer();
		stateplayer3.setPathFile("resource/files/");
		stateplayer3.setNameFile("initplayer3.txt");
		stateplayer3.openFile();
		
		tableplayer1 = new FilePlayer();
		tableplayer1.setPathFile("resource/files/");
		tableplayer1.setNameFile("playerone.txt");
		tableplayer1.openFile();
		
		tableplayer2 = new FilePlayer();
		tableplayer2.setPathFile("resource/files/");
		tableplayer2.setNameFile("playertwo.txt");
		tableplayer2.openFile();
		
		tableplayer3 = new FilePlayer();
		tableplayer3.setPathFile("resource/files/");
		tableplayer3.setNameFile("playerthree.txt");
		tableplayer3.openFile();
		
		fileInfo = new FilePlayer();
		fileInfo.setPathFile("resource/files/");
		
		infoplayer = new Management("resource/files/", "infoplayer.txt");
		jugadores = new ArrayList<>();
		infoplayer.loadPlayersInfo();
		jugadores = infoplayer.getPlayers();
		
		initPlayerOne = new FilePlayer();
		initPlayerOne.setPathFile("resource/files/");
		initPlayerOne.setNameFile("startplayer1.txt");
		initPlayerOne.openFile();
		
		initPlayerTwo = new FilePlayer();
		initPlayerTwo.setPathFile("resource/files/");
		initPlayerTwo.setNameFile("startplayer2.txt");
		initPlayerTwo.openFile();
		
		initPlayerThree = new FilePlayer();
		initPlayerThree.setPathFile("resource/files/");
		initPlayerThree.setNameFile("startplayer3.txt");
		initPlayerThree.openFile();
		
		win = new FilePlayer();
		win.setPathFile("resource/files/");
		win.setNameFile("win.txt");
		win.openFile();
		
		filePlayerWinners = new FilePlayer();
		filePlayerWinners.setPathFile("resource/files/");
		filePlayerWinners.setNameFile("ganadores.txt");
		filePlayerWinners.openFile();
	}
	
	public Jugador buscarJugador(String name){
		for(Jugador jugador : jugadores){
			if(jugador.getName().equals(name)){
				return jugador;
			}
		}
		return null;
	}
	
	public ArrayList<Jugador> getJugadores(){
		return (ArrayList<Jugador>) jugadores.clone();
	}
	
	
	@Override
	public boolean loadStatePlayerOne() throws Exception {
		// TODO Auto-generated method stub
		String state = stateplayer1.ReadFile();
		
		if(state.charAt(0)=='1'){
			return true;
		}
		return false;
	}

	@Override
	public boolean loadStatePlayerTwo() throws Exception {
		// TODO Auto-generated method stub
		String state = stateplayer2.ReadFile();
		if(state.charAt(0)=='1'){
			return true;
		}
		return false;
	}

	@Override
	public boolean writeStatePlayerOne(String state) throws Exception {
		// TODO Auto-generated method stub
		stateplayer1.writeFile(state);
		return true;
	}

	@Override
	public boolean writeStatePlayerTwo(String state) throws Exception {
		// TODO Auto-generated method stub
		stateplayer2.writeFile(state);
		return true;
	}
	
	@Override
	public boolean loadStatePlayerThree() throws Exception {
		// TODO Auto-generated method stub
		String state = stateplayer3.ReadFile();
		if(state.charAt(0)=='1'){
			return true;
		}
		return false;
	}

	@Override
	public boolean writeStatePlayerThree(String state) throws Exception {
		// TODO Auto-generated method stub
		stateplayer3.writeFile(state);
		return true;
	}

	@Override
	public boolean verification(String name, String password) throws Exception {
		// TODO Auto-generated method stub
		if(buscarJugador(name) != null && buscarJugador(name).getPassword().equals(password) || buscarJugador(name).getState()==0){
			buscarJugador(name).setState(1);
			return true;
		}
		return false;
	}

	@Override
	public String getTablePlayerOne() throws Exception {
		// TODO Auto-generated method stub
		return tableplayer1.ReadFile();
	}

	@Override
	public String getTablePlayerTwo() throws Exception {
		// TODO Auto-generated method stub
		return tableplayer2.ReadFile();
	}

	@Override
	public void setTablePlayerOne(String table) throws Exception {
		// TODO Auto-generated method stub
		tableplayer1.writeFile(table);
	}

	@Override
	public void setTablePlayerTwo(String table) throws Exception {
		// TODO Auto-generated method stub
		tableplayer2.writeFile(table);
	}
	
	@Override
	public boolean writeNewPlayer(String name, String pass, String puntaje) throws Exception {
		// TODO Auto-generated method stub
		if(infoplayer.writeNewPlayer(name, pass,puntaje)){
			return true;
		}
		return false;
	}

	@Override
	public String infoPlayerActivate() throws Exception {
		// TODO Auto-generated method stub
		String chainReturn = "";
		if(loadStatePlayerOne()){
			fileInfo.setNameFile("initplayer1.txt");
			fileInfo.openFile();
			String info = fileInfo.ReadFile();
			StringTokenizer token = new StringTokenizer(info, ";");
			String state = token.nextToken();
			chainReturn = token.nextToken();
			return chainReturn;
			
		}if(loadStatePlayerTwo()){
			fileInfo.setNameFile("initplayer2.txt");
			fileInfo.openFile();
			String info = fileInfo.ReadFile();
			StringTokenizer token = new StringTokenizer(info, ";");
			String state = token.nextToken();
			chainReturn = token.nextToken();
			return chainReturn;
			
		} if(loadStatePlayerThree()){
			fileInfo.setNameFile("initplayer3.txt");
			fileInfo.openFile();
			String info = fileInfo.ReadFile();
			StringTokenizer token = new StringTokenizer(info, ";");
			String state = token.nextToken();
			chainReturn = token.nextToken();
			return chainReturn;
		}
		
		
		return null;
	}

	@Override
	public void setInitPlayerOne(String state) throws Exception {
		// TODO Auto-generated method stub
		initPlayerOne.writeFile(state);
	}

	@Override
	public void setInitPlayerTwo(String state) throws Exception {
		// TODO Auto-generated method stub
		initPlayerTwo.writeFile(state);
	}

	@Override
	public boolean getInitPlayerOne() throws Exception {
		// TODO Auto-generated method stub
		String state = initPlayerOne.ReadFile();
		if(state.charAt(0)=='1'){
			return true;
		}
		return false;
	}

	@Override
	public boolean getInitPlayerTwo() throws Exception {
		// TODO Auto-generated method stub
		String state = initPlayerTwo.ReadFile();
		if(state.charAt(0)=='1'){
			return true;
		}
		return false;
	}

	

	@Override
	public void setInitPlayerThree(String state) throws Exception {
		// TODO Auto-generated method stub
		initPlayerThree.writeFile(state);
	}

	@Override
	public boolean getInitPlayerThree() throws Exception {
		// TODO Auto-generated method stub
		String state = initPlayerThree.ReadFile();
		if(state.charAt(0)=='1'){
			return true;
		}
		return false;
	}

	@Override
	public String getTablePlayerThree() throws Exception {
		// TODO Auto-generated method stub
		return tableplayer3.ReadFile();
	}

	@Override
	public void setTablePlayerThree(String table) throws Exception {
		// TODO Auto-generated method stub
		tableplayer3.writeFile(table);
	}

	@Override
	public String win() throws Exception {
		// TODO Auto-generated method stub
		return win.ReadFile();
	}

	@Override
	public String gano(String data) throws Exception {
		// TODO Auto-generated method stub
		if(data.equals("player 1")){
			String dates = "100";
			win.writeFile(dates);
			return "100";
		}
        if(data.equals("player 2")){
        	String dates = "010";
        	win.writeFile(dates);
        	return dates;
		}
        if(data.equals("player 3")){
        	String dates = "001";
        	win.writeFile(dates);
        	return dates;
         }
        if(data.equals("000")){
        	win.writeFile(data);
        	return data;
        }
		return "";
	}

	@Override
	public String setGanador(String ganador) throws Exception {
		// TODO Auto-generated method stub
		String statePlayer="",namePlayer="";
		if(ganador.equals("player 1")){
			String state = stateplayer1.ReadFile();
			StringTokenizer token = new StringTokenizer(state, ";");
			statePlayer = token.nextToken();
			namePlayer = token.nextToken();
		}
        if(ganador.equals("player 2")){
        	String state = stateplayer2.ReadFile();
			StringTokenizer token = new StringTokenizer(state, ";");
			statePlayer = token.nextToken();
			namePlayer = token.nextToken();
		}
       if(ganador.equals("player 3")){
    	   String state = stateplayer3.ReadFile();
			StringTokenizer token = new StringTokenizer(state, ";");
			statePlayer = token.nextToken();
			namePlayer = token.nextToken();
        }
       filePlayerWinners.writePlayer(namePlayer+";");
       
		return "";
	}

	@Override
	public String getGanadores() throws Exception {
		// TODO Auto-generated method stub
		return filePlayerWinners.ReadFile();
	}

}
