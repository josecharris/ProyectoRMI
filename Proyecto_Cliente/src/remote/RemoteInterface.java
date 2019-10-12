package remote;
import java.rmi.Remote;

public interface RemoteInterface extends Remote {
	public boolean loadStatePlayerOne() throws Exception;
	public boolean loadStatePlayerTwo() throws Exception;
	public boolean loadStatePlayerThree() throws Exception;
	
	public boolean writeStatePlayerOne(String state) throws Exception;
	public boolean writeStatePlayerTwo(String state) throws Exception;
	public boolean writeStatePlayerThree(String state) throws Exception;
	
	public boolean writeNewPlayer(String name, String pass, String puntaje) throws Exception;
	public boolean verification(String name, String password) throws Exception;
	public String infoPlayerActivate() throws Exception;
	
	public String getTablePlayerOne() throws Exception;
	public String getTablePlayerTwo() throws Exception;
	public String getTablePlayerThree() throws Exception;
	public void setTablePlayerOne(String table) throws Exception;
	public void setTablePlayerTwo(String table) throws Exception;
	public void setTablePlayerThree(String table) throws Exception;
	
	public void setInitPlayerOne(String state) throws Exception;
	public void setInitPlayerTwo(String state) throws Exception;
	public void setInitPlayerThree(String state) throws Exception;
	
	public boolean getInitPlayerOne() throws Exception;
	public boolean getInitPlayerTwo() throws Exception;
	public boolean getInitPlayerThree() throws Exception;
	
	public String win() throws Exception;
	public String gano(String datos) throws Exception;
	public String setGanador(String ganador) throws Exception;
	public String getGanadores() throws Exception;
}