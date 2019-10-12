package game;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import run.Main;

public class Cronometro extends Thread{
	private JLabel etiqueta;
	public Cronometro(JLabel label){
		this.etiqueta = label;
	}
	
	public void run(){
		try{
			//int x=0;
			while(PanelLow.iniciaHilo){
				Thread.sleep(1000);
				ejecutarHiloCronometro();
			}
			
			
		}catch(Exception e){
			e.getMessage();
		}
	}

	private void ejecutarHiloCronometro() {
		// TODO Auto-generated method stub
		PanelLow.segundo++;
		if(PanelLow.segundo>59){
			PanelLow.segundo=0;
			PanelLow.minuto++;
		}
		
		if(PanelLow.minuto>59){
			PanelLow.minuto=0;
			PanelLow.hora++;
		}
		
		String textoSegundo="", textoMinuto="", textoHora="";
		
		if(PanelLow.segundo<10){
			textoSegundo="0"+PanelLow.segundo;
		}else{
			textoSegundo=""+PanelLow.segundo;
		}
		
		if(PanelLow.minuto<10){
			textoMinuto="0"+PanelLow.minuto;
		}else{
			textoMinuto=""+PanelLow.minuto;
		}
		
		if(PanelLow.hora<10){
			textoHora="0"+PanelLow.hora;
		}else{
			textoHora=""+PanelLow.hora;
		}
		
		String relog = textoHora+":"+textoMinuto+":"+textoSegundo;
		etiqueta.setText(relog);
		
		if(PanelLow.segundo%1==0){
			try {
				if(Main.getRemote().win().equals("000")){
					
				}else if(Main.getRemote().win().charAt(0)=='1'){
					JOptionPane.showMessageDialog(null, "Ganador : Player 1");
					GameRun.panel.ocultarMar();
					this.stop();
				}else if(Main.getRemote().win().charAt(1)=='1'){
					JOptionPane.showMessageDialog(null, "Ganador : Player 2");
					GameRun.panel.ocultarMar();
					this.stop();
				}else if(Main.getRemote().win().charAt(2)=='1'){
					JOptionPane.showMessageDialog(null, "Ganador : Player 3");
					GameRun.panel.ocultarMar();
					this.stop();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Error.");
			}
		}
		if(PanelLow.corriendo){
			GameRun.panel.mostrarMar();
		}
		
	}
}
