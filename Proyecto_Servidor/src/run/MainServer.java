package run;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import conexion.Conexion;

public class MainServer {
	public static void main(String[] args) {
		Ventana ventana = new Ventana();
		ventana.setVisible(true);
	}
}

class PanelImagen extends JPanel{
	public PanelImagen(){
		setSize(600,600);
	}
	@Override
	public void paint(Graphics g){
	      Dimension tamanio = getSize();
	      setLayout(new BorderLayout());
	      ImageIcon imagenFondo = new ImageIcon("resource/files/fondo3.jpg");
	      g.drawImage(imagenFondo.getImage(),0,0,tamanio.width, tamanio.height, null);
	      setOpaque(false);
	      super.paintComponent(g);
	} 
}

class PanelLow extends JPanel implements ActionListener{
	private JLabel estado;
	private JLabel ip;
	private JButton boton;
	
	public PanelLow(){
		estado = new JLabel("                                Servidor : (DESACTIVADO)");
		ip = new JLabel("                                               IP: ");
		boton = new JButton("CORRER SERVIDOR");
		boton.setIcon(new ImageIcon("resource/files/run.png"));
		boton.addActionListener(this);
		setLayout(new GridLayout(2, 1));
		add(boton);
		add(estado);
		add(ip);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==boton){
			try {
				String ipServer = InetAddress.getLocalHost().getHostAddress();
				Conexion conexion = new Conexion(); 
				conexion.createServer();
				estado.setText("                      Estado : (RUNNING)");
				ip.setText("                                          IP  -------------- "+ipServer);
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}

class Ventana extends JFrame {
	private PanelImagen panel;
	private PanelLow panelButtons;
	
	
	public Ventana(){
		setSize(700,700);
		panel = new PanelImagen();
		panelButtons = new PanelLow();
		setLocationRelativeTo(null);
		
		add(panel,BorderLayout.CENTER);
		panel.repaint();
		add(panelButtons, BorderLayout.SOUTH);
		addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                close();
            }
        });
	}
	
	private void close(){
        if (JOptionPane.showConfirmDialog(rootPane, "¿Desea cerrar el servidor?",
                "Salir del sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
        	try {
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Error");
			}
            System.exit(0);
        	this.setVisible(false);
        }
    } 

	
	
}
