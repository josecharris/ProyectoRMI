package game;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import run.Main;

public class GameInit extends JFrame implements ActionListener{
	private String player;
	private PanelSea panel;
	private JButton botonAcept;
	private JLabel titulo;
	
	public GameInit(String player, PanelSea panel){
		this.panel = panel;
		this.player = player;
		setLayout(new BorderLayout());
		setLocation(400, 6);
		setSize(600, 600);
		titulo = new JLabel("                                                                 "
				+ "                   Selecciona tu Armada");
		botonAcept = new JButton("¡Jugar!");
		botonAcept.setIcon(new ImageIcon("resource/files/juego2.png"));
		botonAcept.addActionListener(this);
		
		add(titulo, BorderLayout.NORTH);
		add(this.panel, BorderLayout.CENTER);
		add(botonAcept, BorderLayout.SOUTH);
		setResizable(false);
		
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
				int mater [][] = new int[8][8];
				String info = "";
				for(int i=0;i<mater.length;i++){
					for(int j=0;j<mater.length;j++){
						info+="0;";
					}
				}
				if(player=="player 1"){
					Main.getRemote().setTablePlayerOne(info);
				}else if(player == "player 2"){
					Main.getRemote().setTablePlayerTwo(info);
				}else if(player == "player 3"){
					Main.getRemote().setTablePlayerThree(info);
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Error");
			}
        	this.setVisible(false);
        }
    }   
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==botonAcept){
			if(panel.state){
				if(player == "player 1"){
					try {
						if(panel.cuadros>=15){
							panel.dump("left");
							this.setVisible(false);
						}else{
							JOptionPane.showMessageDialog(null, "Faltan barcos");
						}
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Error.");
					}
				}
				
				if(player == "player 2"){
					try {
						if(panel.cuadros>=15){
							panel.dump("right");
							this.setVisible(false);
						}else{
							JOptionPane.showMessageDialog(null, "Faltan Barcos");
						}
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(player == "player 3"){
					try {
						if(panel.cuadros>=15){
							panel.dump("player 3");
							this.setVisible(false);
						}else{
							JOptionPane.showMessageDialog(null, "Faltan barcos");
						}
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}else{
				JOptionPane.showMessageDialog(null, "Faltan barcos");
			}	
		}
	}
}
