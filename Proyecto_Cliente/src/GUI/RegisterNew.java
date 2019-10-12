package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import run.Main;

public class RegisterNew extends JFrame implements ActionListener{

	private JLabel name;
	private JTextField jtxName;
	private JLabel password;
	private JTextField jtxPassword;
	private JButton accept;
	
	public RegisterNew(){
		setTitle("Registrar Jugador");
		setSize(550,250);
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
		jtxPassword = new JTextField();
		accept = new JButton("Aceptar");
		accept.addActionListener(this);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==accept){
			try {
				String nameNew = jtxName.getText();
				String passNew = jtxPassword.getText();
				if(Main.getRemote().writeNewPlayer(nameNew, passNew,"0")){
					JOptionPane.showMessageDialog(null, "Se agregó correctamente");
					clean();
					this.setVisible(false);
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Error de loggeo");
			}
		}
	}
	
	public void clean(){
		jtxName.setText("");
		jtxPassword.setText("");
		this.setVisible(false);
	}

}
