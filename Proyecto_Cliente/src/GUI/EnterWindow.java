package GUI;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import game.GameRun;
import game.PanelSea;
import run.Main;

public class EnterWindow extends JFrame implements ActionListener{
	
	private JButton registerPlayerOne, modoEspectador,registerPlayerTwo,play,registerNew;
	private JButton view;
	ArrayList<String> ganadoresArray = new ArrayList<>();
	private RegisterWindows windowRegister;
	private RegisterPlayer2 windowRegister2;
	private RegisterPlayer3 windowRegister3;
	static String playerRegister="";
	private String ganadores = "";
	public EnterWindow(){
		initComponents();
		setTitle("Init");
		setSize(650,350);
		//setLayout(new FlowLayout());
		setLayout(new GridLayout(3, 2));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                close();
            }
        });
	}
	
	private void close(){
        if (JOptionPane.showConfirmDialog(rootPane, "¿Desea realmente salir del sistema?",
                "Salir del sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
        	try {
				Main.getRemote().writeStatePlayerOne("0");
				Main.getRemote().writeStatePlayerTwo("0");
				Main.getRemote().writeStatePlayerThree("0");
				Main.getRemote().setInitPlayerOne("0");
				Main.getRemote().setInitPlayerTwo("0");
				Main.getRemote().setInitPlayerThree("0");
				Main.getRemote().gano("000");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Error");
			}
        	this.setVisible(false);
        }
    } 

	private void initComponents() {
		beginComponents(); addComponents();
	}

	private void beginComponents() {
		// TODO Auto-generated method stub
		registerNew = new JButton("Nuevo jugador :");
		registerNew.addActionListener(this);
		registerNew.setIcon(new ImageIcon("resource/files/add.png"));
		registerPlayerOne = new JButton("Jugador 1");
		registerPlayerOne.addActionListener(this);
		registerPlayerOne.setIcon(new ImageIcon("resource/files/player.png"));
		registerPlayerTwo = new JButton("Jugador 2");
		registerPlayerTwo.addActionListener(this);
		registerPlayerTwo.setIcon(new ImageIcon("resource/files/calavera.png"));
		windowRegister = new RegisterWindows();
		windowRegister2 = new RegisterPlayer2();
		windowRegister3 = new RegisterPlayer3();
		play = new JButton("¡Jugar!");
		play.setIcon(new ImageIcon("resource/files/play.png"));
		play.addActionListener(this);
		modoEspectador = new JButton("Jugador 3");
		modoEspectador.setIcon(new ImageIcon("resource/files/ojo.png"));
		modoEspectador.addActionListener(this);
		view = new JButton("Ver ganadores");
		view.setIcon(new ImageIcon("resource/files/ver.png"));
		view.addActionListener(this);
	}

	private void addComponents() {
		// TODO Auto-generated method stub
		this.add(registerPlayerOne);
		this.add(registerPlayerTwo);
		this.add(registerNew);
		this.add(modoEspectador);
		this.add(play);
		this.add(view);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==view){
			
			try {
				PanelMiddle panel = new PanelMiddle();
				JFrame ventana = new JFrame("Puntajes");
				ventana.setSize(700,300);
				ganadores = Main.getRemote().getGanadores();
				StringTokenizer token = new StringTokenizer(ganadores, ";");
				while(token.hasMoreTokens()){
					ganadoresArray.add(token.nextToken());
				}
				for(String winners : ganadoresArray){
					String name = winners;
					Object[] row = {name};
					panel.getDtm().addRow(row);
					
				}
				ventana.add(panel);
				ventana.setVisible(true);
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Error.");
				e1.printStackTrace();
			}
		}
		if(e.getSource()==registerPlayerOne){
			if(PanelSea.cuadros!=0){
				PanelSea.cuadros=0;
			}
			try {
				if(!Main.getRemote().loadStatePlayerOne()){
					this.playerRegister = "player 1";
					windowRegister.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null, "JUGADOR YA REGISTRADO");
				}
				
			}catch(Exception e1){
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Ocurrió un error.");
			}
			
			
		}else if(e.getSource()==registerPlayerTwo){
			if(PanelSea.cuadros!=0){
				PanelSea.cuadros=0;
			}
			try {
				if(!Main.getRemote().loadStatePlayerTwo()){
					this.playerRegister = "player 2";
					windowRegister2.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null, "JUGADOR YA REGISTRADO");
				}
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Ocurrió un error.");
			}
			
		}
		if(e.getSource()==play){
			try {
				if(Main.getRemote().loadStatePlayerTwo() && Main.getRemote().loadStatePlayerOne()
						&& Main.getRemote().loadStatePlayerThree()){
					
					
					/*       JUEGO      */
					if(this.playerRegister=="player 1"){
						GameRun game = new GameRun(playerRegister);
						game.setVisible(true);
					}
                    if(this.playerRegister=="player 2"){
                    	GameRun game = new GameRun(playerRegister);
                    	game.setVisible(true);
					}
                    if(this.playerRegister=="player 3"){
                    	GameRun game = new GameRun(playerRegister);
                    	game.setVisible(true);
					}
					
				}else{
					JOptionPane.showMessageDialog(null, "Se necesitan 3 jugadores para jugar");
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Ocurrió un error.");
				e1.printStackTrace();
			}
		}
		
		if(e.getSource()==registerNew){
			RegisterNew register = new RegisterNew();
			register.setVisible(true);
		}
		
		if(e.getSource() == modoEspectador){
			if(PanelSea.cuadros!=0){
				PanelSea.cuadros=0;
			}
			try {
				if(!Main.getRemote().loadStatePlayerThree()){
					this.playerRegister = "player 3";
					windowRegister3.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null, "JUGADOR YA REGISTRADO");
				}
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Ocurrió un error.");
			}
		}
	}
	
	
}
