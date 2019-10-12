package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import run.Main;

public class GameRun extends JFrame{
	private String posString;
	private String posString2;
	public static PanelRun panel;
	public static String playerA;
	private String pos[][];
	private String pos2[][];
	private JMenuBar barra; private JMenuItem color1, color2, color3,color4;
	
	public static int abatidos=0;
	private PanelLow panelLow;
	
	public GameRun(String player) throws Exception{	
		this.playerA = player;
		panelLow = new PanelLow(playerA);
		setLayout(new BorderLayout());
		setLocation(400, 6);
		setSize(600, 600);
		pos = new String [8][8];
		pos2 = new String [8][8];
		if(playerA=="player 1"){
			this.panel = new PanelRun(playerA,pos,pos2);
			this.posString = Main.getRemote().getTablePlayerTwo();
			this.posString2 = Main.getRemote().getTablePlayerThree();
		}else if(player == "player 2"){
			this.panel = new PanelRun(playerA,pos,pos2);
			this.posString = Main.getRemote().getTablePlayerOne();
			this.posString2 = Main.getRemote().getTablePlayerThree();
		}else if(player == "player 3"){
			this.panel = new PanelRun(playerA,pos,pos2);
			this.posString = Main.getRemote().getTablePlayerOne();
			this.posString2 = Main.getRemote().getTablePlayerTwo();
		}
		llenarVectores();
		this.add(panel,BorderLayout.CENTER);
		this.add(panelLow, BorderLayout.SOUTH);
		
		addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                close();
            }
        });
		barra = new JMenuBar();
		color1 = new JMenuItem("Player 1"); color2 = new JMenuItem("Player 2"); color3 = new JMenuItem("Player 3");
		color4 = new JMenuItem("Dos jugadores");
		color1.setIcon(new ImageIcon("resource/files/azul.png"));
		color2.setIcon(new ImageIcon("resource/files/blanco.png"));
		color3.setIcon(new ImageIcon("resource/files/amarillo.png"));
		color4.setIcon(new ImageIcon("resource/files/rojo.png"));
		
		barra.add(color1); barra.add(color2); barra.add(color3); barra.add(color4);
		this.setJMenuBar(barra);
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
				int mater [][] = new int[8][8];
				String info = "";
				for(int i=0;i<mater.length;i++){
					for(int j=0;j<mater.length;j++){
						info+="0;";
					}
				}
				
				if(playerA=="player 1"){
					Main.getRemote().setTablePlayerOne(info);
				}else if(playerA == "player 2"){
					Main.getRemote().setTablePlayerTwo(info);
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Error");
			}
        	this.setVisible(false);
        }
    }   

	private void llenarVectores() {
		// TODO Auto-generated method stub
		StringTokenizer token = new StringTokenizer(posString, ";");
		StringTokenizer token2 = new StringTokenizer(posString2, ";");
		
		for(int i=0;i<pos.length;i++){
			for(int j=0;j<pos.length;j++){
				pos[i][j] = token.nextToken();
				pos2[i][j] = token2.nextToken();
			}
		}
	}
	
}

//                                    PANEL LOWW
class PanelLow extends JPanel implements ActionListener{
	private JButton init;
	private JButton listo;
	private JLabel time;
	private String playerA;
	static int hora=0,minuto=0,segundo=0;
	static boolean iniciaHilo=true, corriendo=false;
	
	public PanelLow(String player){
		this.playerA = player;
		this.init = new JButton("¡Comenzar!");
		time = new JLabel("00:00:00");
		listo = new JButton("Listo!");
		listo.setIcon(new ImageIcon("resource/files/check.png"));
		listo.addActionListener(this);
		init.setIcon(new ImageIcon("resource/files/juego2.png"));
		init.addActionListener(this);
		this.add(listo);
		this.add(init);
		this.add(time);	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==listo){
			if(playerA == "player 1"){
				try {
					Main.getRemote().setInitPlayerOne("1");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Error.");
				}
			}
			if(playerA == "player 2"){
				try {
					Main.getRemote().setInitPlayerTwo("1");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Error.");
				}
			}
			if(playerA == "player 3"){
				try {
					Main.getRemote().setInitPlayerThree("1");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Error.");
				}
			}
		}
		
		if(e.getSource()==init){
			try {
				if(Main.getRemote().getInitPlayerOne() && Main.getRemote().getInitPlayerTwo() && Main.getRemote().getInitPlayerThree()){
					if(corriendo==false){
						iniciaHilo = true;
						corriendo = true;
						iniciarHiloCronometro(time);
					}
				}else{
					JOptionPane.showMessageDialog(null, "Falta el otro jugador");
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}		
		}
	}
	private void iniciarHiloCronometro(JLabel label) {
		// TODO Auto-generated method stub
		if(iniciaHilo){
			Cronometro cronometro = new Cronometro(label);
			cronometro.start();
		}
	}
}

//                            PANEL

class PanelRun extends JPanel implements ActionListener{
	
	private static JButton sea [][];
	private static String infoSea[][];
	private String infoSea2[][];
	private String panelDescription;
	public static boolean state=false;
	
	public PanelRun(String desc,String matrizInfo[][], String matrizInfo2[][]){
		this.panelDescription = desc;
		setLayout(new GridLayout(8, 8));
		sea = new JButton[8][8];
		infoSea = matrizInfo;
		this.infoSea2 = matrizInfo2;
		addComponents();
	}
	
	
	public String getDescription(){ return this.panelDescription;}
	public void setDescription(String desc){ this.panelDescription = desc;}
	
	
	public void addComponents(){
		for(int i=0;i<sea.length;i++){
			for(int j=0;j<sea.length;j++){
				sea[i][j] = new JButton();
				sea[i][j].addActionListener(this);
				sea[i][j].setEnabled(false);
				this.add(sea[i][j]);
			}
		}
	}
	
	public static void mostrarMar(){
		for(int i=0;i<sea.length;i++){
			for(int j=0;j<sea.length;j++){
				if(infoSea[i][j].equals("2")){
					sea[i][j].setEnabled(false);
				}else{
					sea[i][j].setEnabled(true);
				}	
			}
		}
	}
	
	public static void ocultarMar(){
		for(int i=0;i<sea.length;i++){
			for(int j=0;j<sea.length;j++){
				sea[i][j].setEnabled(false);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		for(int i=0;i<infoSea.length;i++){
			for(int j=0;j<infoSea.length;j++){
				if(arg0.getSource()==sea[i][j]){
					if(panelDescription=="player 1"){
						if(infoSea[i][j].equals("1") && infoSea2[i][j].equals("1")){
							this.sea[i][j].setEnabled(false);
							sea[i][j].setBackground(Color.RED);
							sea[i][j].setIcon(new ImageIcon("resource/files/barco.png"));
						    infoSea[i][j]="2";
							GameRun.abatidos++;GameRun.abatidos++;
						}else if(infoSea[i][j].equals("1")){
							this.sea[i][j].setEnabled(false);
							sea[i][j].setIcon(new ImageIcon("resource/files/barco.png"));
							sea[i][j].setBackground(Color.white);
							infoSea[i][j]="2";
							GameRun.abatidos++;
						}else if(infoSea2[i][j].equals("1")){
							this.sea[i][j].setEnabled(false);
							sea[i][j].setIcon(new ImageIcon("resource/files/barco.png"));
							sea[i][j].setBackground(Color.YELLOW);
							infoSea[i][j]="2";
							GameRun.abatidos++;
						}
					}
					
					if(panelDescription=="player 2"){
						if(infoSea[i][j].equals("1") && infoSea2[i][j].equals("1")){
							this.sea[i][j].setEnabled(false);
							sea[i][j].setBackground(Color.RED);
							sea[i][j].setIcon(new ImageIcon("resource/files/barco.png"));
							sea[i][j].setIcon(new ImageIcon("resource/files/barco.png"));
							infoSea[i][j]="2";
							GameRun.abatidos++;GameRun.abatidos++;
						}else if(infoSea[i][j].equals("1")){
							infoSea[i][j]="2";
							this.sea[i][j].setEnabled(false);
							sea[i][j].setIcon(new ImageIcon("resource/files/barco.png"));
							sea[i][j].setBackground(Color.BLUE);
							GameRun.abatidos++;
						}else if(infoSea2[i][j].equals("1")){
							infoSea[i][j]="2";
							this.sea[i][j].setEnabled(false);
							sea[i][j].setIcon(new ImageIcon("resource/files/barco.png"));
							sea[i][j].setBackground(Color.YELLOW);
							GameRun.abatidos++;
						}
					}
					if(panelDescription=="player 3"){
						if(infoSea[i][j].equals("1") && infoSea2[i][j].equals("1")){
							infoSea[i][j]="2";
							sea[i][j].setBackground(Color.RED);
							sea[i][j].setIcon(new ImageIcon("resource/files/barco.png"));
							this.sea[i][j].setEnabled(false);
							GameRun.abatidos++;GameRun.abatidos++;
						}else if(infoSea[i][j].equals("1")){
							infoSea[i][j]="2";
							this.sea[i][j].setEnabled(false);
							sea[i][j].setIcon(new ImageIcon("resource/files/barco.png"));
							sea[i][j].setBackground(Color.BLUE);
							GameRun.abatidos++;
						}else if(infoSea2[i][j].equals("1")){
							infoSea[i][j]="2";
							this.sea[i][j].setEnabled(false);
							sea[i][j].setIcon(new ImageIcon("resource/files/barco.png"));
							sea[i][j].setBackground(Color.white);
							GameRun.abatidos++;
						}
					}
					
					if(GameRun.abatidos==30){
						try {
							JOptionPane.showMessageDialog(null, "Ganaste");
							Main.getRemote().gano(panelDescription);
							Main.getRemote().setGanador(panelDescription);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, "Error.");
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
		
}
