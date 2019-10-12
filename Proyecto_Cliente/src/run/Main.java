package run;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import GUI.EnterWindow;
import GUI.PanelProgress;
import conexion.Conexion;
import remote.RemoteInterface;

public class Main {
	public static String id="";
	static Conexion conexion = new Conexion();
	static WindowPrincipal window;
	
	public static void main(String[] args) throws Exception{
		// ------ BEGIN CICLO 1 -------
		PanelProgress panel = new PanelProgress(new ImageIcon("resource/files/introgot.jpg"));
		panel.setVisible(true);
		panel.velocidadDeCarga();
		
		window = new WindowPrincipal();
		window.setVisible(true);
	}
	
	public static RemoteInterface getRemote(){
		return conexion.searchServer(id);
	}	
}

class WindowPrincipal extends JFrame implements ActionListener{
	//   --- OBJECTS FROM SWIMG ---
	private JRadioButton rbtn1, rbtn2, rbtn3;
	private JButton next;
	private ButtonGroup group;
	private JLabel ip;
	private JTextField text;
	//   ---  OBJECT CONEXION ---
	Conexion conexion;
	
	public WindowPrincipal(){
		conexion = new Conexion();
		setTitle("Seleccionar IP del SERVIDOR");
		setSize(550, 300);
		setLayout(new GridLayout(6, 1));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);		
		define();
		addComponentss();
		//setLayout(new GridLayout(6, 1));
	}
	
	public void define(){
		rbtn1=new JRadioButton("IP Home",false);              rbtn1.addActionListener(this);
		rbtn2=new JRadioButton("IP Universidad",false);       rbtn2.addActionListener(this);
		rbtn3=new JRadioButton("Otra",false);                 rbtn3.addActionListener(this);;
		group = new ButtonGroup();
		ip = new JLabel("Ingrese otra IP : ");                ip.setVisible(false);
		text=new JTextField();   text.setVisible(false);
		next=new JButton("next");   next.setVisible(false);   next.addActionListener(this);
		next.setIcon(new ImageIcon("resource/files/icon.png"));
	}
	
	public void addComponentss(){
		group.add(rbtn1);   group.add(rbtn2);   group.add(rbtn3);
		this.add(rbtn1);    this.add(rbtn2);    this.add(rbtn3);   this.add(ip);   this.add(text);
		this.add(next);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==rbtn3){
			ip.setVisible(true);   text.setVisible(true);   next.setVisible(true);
		}
		if(e.getSource()==rbtn1){
			ip.setVisible(false);  text.setVisible(false);  next.setVisible(true);
		}
		if(e.getSource()==rbtn2){
			ip.setVisible(false);  text.setVisible(false);  next.setVisible(true);
		}
		if(e.getSource()==next){
			if(rbtn1.isSelected()){
				try{
					if(conexion.searchServer("192.168.85.1")!=null){
						Main.id="192.168.85.1";
						
						JOptionPane.showMessageDialog(null, "Conexion exitosa");
						this.setVisible(false);
						EnterWindow choose = new EnterWindow();   choose.setVisible(true);
				        // ------ END CLICLO 1 --------
					}
				}catch(Exception w){
					JOptionPane.showMessageDialog(null, "CONEXION ERRONEA");
				}
			}
			if(rbtn2.isSelected()){
				try{
					if(conexion.searchServer("10.57.5.127")!=null){
						Main.id="10.57.5.127";
						JOptionPane.showMessageDialog(null, "Conexion exitosa");
						this.setVisible(false);
						EnterWindow choose = new EnterWindow();   choose.setVisible(true);
				        // ------ END CLICLO 1 --------
					}
				}catch(Exception e2){
					JOptionPane.showMessageDialog(null, "CONEXION ERRONEA");
				}
				
			}
			if(rbtn3.isSelected()){
				try{
					String ipserver = text.getText();
					if(conexion.searchServer(ipserver)!=null){
						Main.id=ipserver;
						JOptionPane.showMessageDialog(null, "Conexion exitosa");
						this.setVisible(false);
						EnterWindow choose = new EnterWindow();  choose.setVisible(true);
				        // ------ END CLICLO 1 --------
					}
				}catch(Exception w){
					JOptionPane.showMessageDialog(null, "CONEXION ERRONEA");
				}
				
			}
		}
	}
}