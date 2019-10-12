package logic;

public class Jugador {
	
	private String name;
	private String password;
	private int puntaje;
	private int state;
	
	public Jugador(String name, String password,String puntaje){
		this.name = name;
		this.password = password;
		this.puntaje = Integer.parseInt(puntaje);
		state = 0;
	}

	public int getState() {
		return state;
	}




	public void setState(int state) {
		this.state = state;
	}




	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public int getPuntaje(){
		return puntaje;
	}
	
	public void setPuntaje(int puntaje){
		this.puntaje = puntaje;
	}
	
}
