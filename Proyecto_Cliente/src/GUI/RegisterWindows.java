package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import game.GameInit;
import game.PanelSea;
import run.Main;

public class RegisterWindows extends JFrame  implements ActionListener{
	
	private JLabel name;
	private JTextField jtxName;
	private JLabel password;
	private JPasswordField jtxPassword;
	private JButton accept;
	
	public RegisterWindows(){
		setTitle("Registrar Jugador");
		setSize(460,250);
		setLayout(new GridLayout(3, 2));
		setLocationRelativeTo(null);
		beginComponents();
		addComponents();
	}

	private void addComponents() {
		// TODO Auto-generated method stub
		this.add(name);
		this.add(jtxName);
		this.add(password);
		this.add(jtxPassword);
		this.add(accept);
		
	}

	private void beginComponents() {
		// TODO Auto-generated method stub
		name = new JLabel("Nombre : ");
		jtxName = new JTextField();
		password = new JLabel("Contraseña : ");
		jtxPassword = new JPasswordField();
		accept = new JButton("Aceptar");
		accept.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==accept){
			String namePlayer = jtxName.getText();
			String passwordPlayer = jtxPassword.getText();
			try {
				if(Main.getRemote().verification(namePlayer, passwordPlayer)){
					if(Main.getRemote().infoPlayerActivate()==null){
						Main.getRemote().writeStatePlayerOne("1;"+namePlayer+";");
						int matriz [][] = new int[8][8];
						GameInit select = new GameInit("player 1", new PanelSea("left", matriz));
						select.setVisible(true);
						this.clean();
					}else if(Main.getRemote().infoPlayerActivate().equals(namePlayer)){
						JOptionPane.showMessageDialog(null, "Usuario registrado");
						clean();
					}else{
						Main.getRemote().writeStatePlayerOne("1;"+namePlayer+";");
						int matriz [][] = new int[8][8];
						GameInit select = new GameInit("player 1", new PanelSea("left", matriz));
						select.setVisible(true);
						this.clean();
					}
				}else{
					JOptionPane.showMessageDialog(null, "Usuario no registrado");
					clean();
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Error de conexion");
			}
		}
	}
	
	public void clean(){
		jtxName.setText("");
		jtxPassword.setText("");
		this.setVisible(false);
	}
}