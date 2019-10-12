package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import run.Main;

public class PanelSea extends JPanel implements ActionListener{
	
	private JButton sea [][];
	private int infoSea[][];
	private String panelDescription;
	public static int cuadros = 0;
	public static boolean state=false;
	public JLabel imagen;
	public ImageIcon image; 
	
	public PanelSea(String panelDescription, int matrizInfo[][]){
		this.image = new ImageIcon("resource/files/backup.jpg");
		imagen = new JLabel(image);
		imagen.setEnabled(false);
		this.panelDescription = panelDescription;
		setLayout(new GridLayout(8, 8));
		sea = new JButton[8][8];
		infoSea = matrizInfo;
		fillin();
		addComponents();
	}
	
	public String getDescription(){ return this.panelDescription;}
	public void setDescription(String desc){ this.panelDescription = desc;}
	
	public void fillin(){
		for(int i=0;i<sea.length;i++){
			for(int j=0;j<sea.length;j++){
				sea[i][j] = new JButton();       
				infoSea[i][j] = 0;
			}
		}
	}
	
	public void addComponents(){
		for(int i=0;i<sea.length;i++){
			for(int j=0;j<sea.length;j++){
				this.add(sea[i][j]);
				sea[i][j].addActionListener(this);
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				if(e.getSource()==sea[i][j]){
					this.cuadros++;
					
					if(cuadros==1){
						infoSea[i][j] = 1;
						sea[i][j].setBackground(Color.cyan); 
					}
					
					if(cuadros==2){	
						try{
							if(infoSea[i-1][j]==1 || infoSea[i+1][j]==1){
								if(infoSea[i][j]==0){
									infoSea[i][j] = 1;
									sea[i][j].setBackground(Color.cyan);
								}else{
									JOptionPane.showMessageDialog(null, "Invalido");
									this.cuadros--;
								}
								 
							}else if(infoSea[i][j-1]==1 || infoSea[i][j+1]==1){
								if(infoSea[i][j]==0){
									infoSea[i][j] = 1;
									sea[i][j].setBackground(Color.cyan);
								}else{
									JOptionPane.showMessageDialog(null, "Invalido");
									this.cuadros--;
								}
							}else{
								JOptionPane.showMessageDialog(null, "Invalido");
								this.cuadros--;
							}
						}catch(Exception exc){
							try{
								if(j<=7){	
									if(infoSea[i][j+1]==1 || infoSea[i][j-1]==1){
										if(infoSea[i][j]==0){
											infoSea[i][j] = 1;
											sea[i][j].setBackground(Color.cyan);
										}else{
											JOptionPane.showMessageDialog(null, "Invalido");
											this.cuadros--;
										}
									}else{
										JOptionPane.showMessageDialog(null, "Invalido");
										this.cuadros--;
									}
								}else if(i<=7){
									if(infoSea[i+1][j]==1 || infoSea[i-1][j]==1){
										if(infoSea[i][j]==0){
											infoSea[i][j] = 1;
											sea[i][j].setBackground(Color.cyan);
										}else{
											JOptionPane.showMessageDialog(null, "Invalido");
											this.cuadros--;
										}
									}
								}
							}catch(Exception e2){
								JOptionPane.showMessageDialog(null, "Invalido");
								this.cuadros--;
							}
						}
					}
					
					if(cuadros==3){
						try{
							if(infoSea[i-1][j]==1 || infoSea[i+1][j]==1){
								if(infoSea[i][j]==0){
									infoSea[i][j] = 1;
									sea[i][j].setBackground(Color.cyan);
								}else{
									JOptionPane.showMessageDialog(null, "Invalido");
									this.cuadros--;
								}
							}else if(infoSea[i][j-1]==1 || infoSea[i][j+1]==1){
								if(infoSea[i][j]==0){
									infoSea[i][j] = 1;
									sea[i][j].setBackground(Color.cyan);
								}else{
									JOptionPane.showMessageDialog(null, "Invalido");
									this.cuadros--;
								}
							}else{
								JOptionPane.showMessageDialog(null, "Invalido");
								this.cuadros--;
							}
						}catch(Exception ex){
							try{
								if(j<=7){
									if(infoSea[i][j+1]==1 || infoSea[i][j-1]==1){
										if(infoSea[i][j]==0){
											infoSea[i][j] = 1;
											sea[i][j].setBackground(Color.cyan);
										}else{
											JOptionPane.showMessageDialog(null, "Invalido");   this.cuadros--;
										} 
									}else{
										JOptionPane.showMessageDialog(null, "Invalido");     this.cuadros--;
									}
								}else if(i<=7){
									if(infoSea[i+1][j]==1 || infoSea[i-1][j]==1){
										if(infoSea[i][j]==0){
											infoSea[i][j] = 1;
											sea[i][j].setBackground(Color.cyan);
										}else{
											JOptionPane.showMessageDialog(null, "Invalido");
											this.cuadros--;
										}
									}
								}
							}catch(Exception e2){
								JOptionPane.showMessageDialog(null, "Invalido");
								this.cuadros--;
							}
						}
					}
					
					if(cuadros==4){
						try{
							if(infoSea[i-1][j]==1 || infoSea[i+1][j]==1){
								if(infoSea[i][j]==0){
									infoSea[i][j] = 1;
									sea[i][j].setBackground(Color.cyan);
								}else{
									JOptionPane.showMessageDialog(null, "Invalido");
									this.cuadros--;
								}
							}else if(infoSea[i][j-1]==1 || infoSea[i][j+1]==1){
								if(infoSea[i][j]==0){
									infoSea[i][j] = 1;
									sea[i][j].setBackground(Color.cyan);
								}else{
									JOptionPane.showMessageDialog(null, "Invalido");
									this.cuadros--;
								}
							}else{
								JOptionPane.showMessageDialog(null, "Invalido");
								this.cuadros--;
							}
						}catch(Exception ex){
							try{
								if(j<=7){
									if(infoSea[i][j+1]==1 || infoSea[i][j-1]==1){
										if(infoSea[i][j]==0){
											infoSea[i][j] = 1;
											sea[i][j].setBackground(Color.cyan);
										}else{
											JOptionPane.showMessageDialog(null, "Invalido");
											this.cuadros--;
										} 
									}else{
										JOptionPane.showMessageDialog(null, "Invalido");
										this.cuadros--;
									}
								}else if(i<=7){
									if(infoSea[i+1][j]==1 || infoSea[i-1][j]==1){
										if(infoSea[i][j]==0){
											infoSea[i][j] = 1;
											sea[i][j].setBackground(Color.cyan);
										}else{
											JOptionPane.showMessageDialog(null, "Invalido");
											this.cuadros--;
										}
									}
								}
							}catch(Exception e2){
								JOptionPane.showMessageDialog(null, "Invalido");
								this.cuadros--;
							}
						}
					}
					
					if(cuadros==5){
						try{
							if(infoSea[i-1][j]==1 || infoSea[i+1][j]==1){
								if(infoSea[i][j]==0){
									infoSea[i][j] = 1;
									sea[i][j].setBackground(Color.cyan);
								}else{
									JOptionPane.showMessageDialog(null, "Invalido");
									this.cuadros--;
								}
							}else if(infoSea[i][j-1]==1 || infoSea[i][j+1]==1){
								if(infoSea[i][j]==0){
									infoSea[i][j] = 1;
									sea[i][j].setBackground(Color.cyan);
								}else{
									JOptionPane.showMessageDialog(null, "Invalido");
									this.cuadros--;
								}
							}else{
								JOptionPane.showMessageDialog(null, "Invalido");
								this.cuadros--;
							}
						}catch(Exception ex){
							
							try{
								if(j<=7){
									if(infoSea[i][j+1]==1 || infoSea[i][j-1]==1){
										if(infoSea[i][j]==0){
											infoSea[i][j] = 1;
											sea[i][j].setBackground(Color.cyan);
										}else{
											JOptionPane.showMessageDialog(null, "Invalido");
											this.cuadros--;
										} 
									}else{
										JOptionPane.showMessageDialog(null, "Invalido");
										this.cuadros--;
									}
								}else if(i<=7){
									if(infoSea[i+1][j]==1 || infoSea[i-1][j]==1){
										if(infoSea[i][j]==0){
											infoSea[i][j] = 1;
											sea[i][j].setBackground(Color.cyan);
										}else{
											JOptionPane.showMessageDialog(null, "Invalido");
											this.cuadros--;
										}
									}
								}
							}catch(Exception e2){
								JOptionPane.showMessageDialog(null, "Invalido");
								this.cuadros--;
							}
						}
					}
					
					if(cuadros==6){
						try{
							if(infoSea[i-1][j]==0 && infoSea[i+1][j]==0 && infoSea[i][j-1]==0 
									&& infoSea[i][j+1]==0){
								if(infoSea[i][j]==0){
									infoSea[i][j] = 1;
									sea[i][j].setBackground(Color.BLACK);
								}else{
									JOptionPane.showMessageDialog(null, "Invalido");
									this.cuadros--;
								}
							}else {
								JOptionPane.showMessageDialog(null,"Invalido");
								cuadros--;
							}
						}catch(Exception exception){
							
							try{
								if(j<=7){
									if(infoSea[i][j]==0 || infoSea[i][j-1]==0){
										if(infoSea[i][j]==0){
											infoSea[i][j] = 1;
											sea[i][j].setBackground(Color.BLACK);
										}else{
											JOptionPane.showMessageDialog(null, "Invalido");
											this.cuadros--;
										}  
									}else{
										JOptionPane.showMessageDialog(null, "Invalido");
										this.cuadros--;
									}
								}else if(i<=7){
									if(infoSea[i+1][j]==0 || infoSea[i-1][j]==0){
										if(infoSea[i][j]==0){
											infoSea[i][j] = 1;
											sea[i][j].setBackground(Color.BLACK);
										}else{
											JOptionPane.showMessageDialog(null, "Invalido");
											this.cuadros--;
										}
									}
								}
							}catch(Exception e2){
								JOptionPane.showMessageDialog(null, "Invalido");
								this.cuadros--;
							}
							
							
						}
					}
					
					if(cuadros==7){
						try{
							if(infoSea[i-1][j]==1 || infoSea[i+1][j]==1){
								if(infoSea[i][j]==0){
									infoSea[i][j] = 1;
									sea[i][j].setBackground(Color.BLACK);
								}else{
									JOptionPane.showMessageDialog(null, "Invalido");
									this.cuadros--;
								}
							}else if(infoSea[i][j-1]==1 || infoSea[i][j+1]==1){
								if(infoSea[i][j]==0){
									infoSea[i][j] = 1;
									sea[i][j].setBackground(Color.BLACK);
								}else{
									JOptionPane.showMessageDialog(null, "Invalido");
									this.cuadros--;
								} 
							}else{
								JOptionPane.showMessageDialog(null, "Invalido");
								this.cuadros--;
							}
						}catch(Exception ex){
							try{
								if(j<=7){
									if(infoSea[i][j+1]==1 || infoSea[i][j-1]==1){
										if(infoSea[i][j]==0){
											infoSea[i][j] = 1;
											sea[i][j].setBackground(Color.BLACK);
										}else{
											JOptionPane.showMessageDialog(null, "Invalido");
											this.cuadros--;
										} 
									}else{
										JOptionPane.showMessageDialog(null, "Invalido");
										this.cuadros--;
									}
								}else if(i<=7){
									if(infoSea[i+1][j]==1 || infoSea[i-1][j]==1){
										if(infoSea[i][j]==0){
											infoSea[i][j] = 1;
											sea[i][j].setBackground(Color.BLACK);
										}else{
											JOptionPane.showMessageDialog(null, "Invalido");
											this.cuadros--;
										}
									}
								}
							}catch(Exception e2){
								JOptionPane.showMessageDialog(null, "Invalido");
								this.cuadros--;
							}
						}
					}
					
					if(cuadros==8){
						try{
							if(infoSea[i-1][j]==1 || infoSea[i+1][j]==1){
								if(infoSea[i][j]==0){
									infoSea[i][j] = 1;
									sea[i][j].setBackground(Color.BLACK);
								}else{
									JOptionPane.showMessageDialog(null, "Invalido");
									this.cuadros--;
								}
							}else if(infoSea[i][j-1]==1 || infoSea[i][j+1]==1){
								if(infoSea[i][j]==0){
									infoSea[i][j] = 1;
									sea[i][j].setBackground(Color.BLACK);
								}else{
									JOptionPane.showMessageDialog(null, "Invalido");
									this.cuadros--;
								}
							}else{
								JOptionPane.showMessageDialog(null, "Invalido");
								this.cuadros--;
							}
						}catch(Exception es){
							
							try{
								if(j<=7){
									if(infoSea[i][j+1]==1 || infoSea[i][j-1]==1){
										if(infoSea[i][j]==0){
											infoSea[i][j] = 1;
											sea[i][j].setBackground(Color.BLACK);
										}else{
											JOptionPane.showMessageDialog(null, "Invalido");
											this.cuadros--;
										} 
									}else{
										JOptionPane.showMessageDialog(null, "Invalido");
										this.cuadros--;
									}
								}else if(i<=7){
									if(infoSea[i+1][j]==1 || infoSea[i-1][j]==1){
										if(infoSea[i][j]==0){
											infoSea[i][j] = 1;
											sea[i][j].setBackground(Color.BLACK);
										}else{
											JOptionPane.showMessageDialog(null, "Invalido");
											this.cuadros--;
										}
									}
								}
							}catch(Exception e2){
								JOptionPane.showMessageDialog(null, "Invalido");
								this.cuadros--;
							}	
						}
					}
					
					if(cuadros==9){
						try{
							if(infoSea[i-1][j]==1 || infoSea[i+1][j]==1){
								if(infoSea[i][j]==0){
									infoSea[i][j] = 1;
									sea[i][j].setBackground(Color.BLACK);
								}else{
									JOptionPane.showMessageDialog(null, "Invalido");
									this.cuadros--;
								} 
							}else if(infoSea[i][j-1]==1 || infoSea[i][j+1]==1){
								if(infoSea[i][j]==0){
									infoSea[i][j] = 1;
									sea[i][j].setBackground(Color.BLACK);
								}else{
									JOptionPane.showMessageDialog(null, "Invalido");
									this.cuadros--;
								}
							}else{
								JOptionPane.showMessageDialog(null, "Invalido");
								this.cuadros--;
							}
						}catch(Exception a){
							try{
								if(j<=7){
									if(infoSea[i][j+1]==1 || infoSea[i][j-1]==1){
										if(infoSea[i][j]==0){
											infoSea[i][j] = 1;
											sea[i][j].setBackground(Color.BLACK);
										}else{
											JOptionPane.showMessageDialog(null, "Invalido");
											this.cuadros--;
										}  
									}else{
										JOptionPane.showMessageDialog(null, "Invalido");
										this.cuadros--;
									}
								}else if(i<=7){
									if(infoSea[i+1][j]==1 || infoSea[i-1][j]==1){
										if(infoSea[i][j]==0){
											infoSea[i][j] = 1;
											sea[i][j].setBackground(Color.BLACK);
										}else{
											JOptionPane.showMessageDialog(null, "Invalido");
											this.cuadros--;
										}
									}
								}
							}catch(Exception e2){
								JOptionPane.showMessageDialog(null, "Invalido");
								this.cuadros--;
							}
						}
					}
					
					if(cuadros==10){
						try{
							if(infoSea[i-1][j]==0 && infoSea[i+1][j]==0 && infoSea[i][j-1]==0 
									&& infoSea[i][j+1]==0){
								if(infoSea[i][j]==0){
									infoSea[i][j] = 1;
									sea[i][j].setBackground(Color.YELLOW);
								}else{
									JOptionPane.showMessageDialog(null, "Invalido");
									this.cuadros--;
								}
							}else {
								JOptionPane.showMessageDialog(null, "Invalido");
								this.cuadros--;
							}
						}catch(Exception ea){
							try{
								if(j<=7){
									if(infoSea[i][j+1]==0 || infoSea[i][j-1]==0){
										if(infoSea[i][j]==0){
											infoSea[i][j] = 1;
											sea[i][j].setBackground(Color.YELLOW);
										}else{
											JOptionPane.showMessageDialog(null, "Invalido");
											this.cuadros--;
										} 
									}else{
										JOptionPane.showMessageDialog(null, "Invalido");
										this.cuadros--;
									}
								}else if(i<=7){
									if(infoSea[i+1][j]==0 && infoSea[i-1][j]==0){
										if(infoSea[i][j]==0){
											infoSea[i][j] = 1;
											sea[i][j].setBackground(Color.YELLOW);
										}else{
											JOptionPane.showMessageDialog(null, "Invalido");
											this.cuadros--;
										} 
									}
								}
							}catch(Exception e2){
								JOptionPane.showMessageDialog(null, "Invalido");
								this.cuadros--;
							}
						}
					}
					
					if(cuadros==11){
						try{
							if(infoSea[i-1][j]==1 || infoSea[i+1][j]==1){
								if(infoSea[i][j]==0){
									infoSea[i][j] = 1;
									sea[i][j].setBackground(Color.YELLOW);
								}else{
									JOptionPane.showMessageDialog(null, "Invalido");
									this.cuadros--;
								} 
							}else if(infoSea[i][j-1]==1 || infoSea[i][j+1]==1){
								if(infoSea[i][j]==0){
									infoSea[i][j] = 1;
									sea[i][j].setBackground(Color.YELLOW);
								}else{
									JOptionPane.showMessageDialog(null, "Invalido");
									this.cuadros--;
								}
							}else{
								JOptionPane.showMessageDialog(null, "Invalido");
								this.cuadros--;
							}
						}catch(Exception ee){
							
							try{
								if(j<=7){
									if(infoSea[i][j+1]==1 || infoSea[i][j-1]==1){
										if(infoSea[i][j]==0){
											infoSea[i][j] = 1;
											sea[i][j].setBackground(Color.YELLOW);
										}else{
											JOptionPane.showMessageDialog(null, "Invalido");
											this.cuadros--;
										} 
									}else{
										JOptionPane.showMessageDialog(null, "Invalido");
										this.cuadros--;
									}
								}else if(i<=7){
									if(infoSea[i+1][j]==1 || infoSea[i-1][j]==1){
										if(infoSea[i][j]==0){
											infoSea[i][j] = 1;
											sea[i][j].setBackground(Color.YELLOW);
										}else{
											JOptionPane.showMessageDialog(null, "Invalido");
											this.cuadros--;
										}
									}
								}
							}catch(Exception e2){
								JOptionPane.showMessageDialog(null, "Invalido");
								this.cuadros--;
							}
						}
					}
					
					if(cuadros==12){
						try{
							if(infoSea[i-1][j]==1 || infoSea[i+1][j]==1){
								if(infoSea[i][j]==0){
									infoSea[i][j] = 1;
									sea[i][j].setBackground(Color.YELLOW);
								}else{
									JOptionPane.showMessageDialog(null, "Invalido");
									this.cuadros--;
								} 
							}else if(infoSea[i][j-1]==1 || infoSea[i][j+1]==1){
								if(infoSea[i][j]==0){
									infoSea[i][j] = 1;
									sea[i][j].setBackground(Color.YELLOW);
								}else{
									JOptionPane.showMessageDialog(null, "Invalido");
									this.cuadros--;
								}
							}else{
								JOptionPane.showMessageDialog(null, "Invalido");
								this.cuadros--;
							}
						}catch(Exception ee){
							try{
								if(j<=7){
									if(infoSea[i][j+1]==1 || infoSea[i][j-1]==1){
										if(infoSea[i][j]==0){
											infoSea[i][j] = 1;
											sea[i][j].setBackground(Color.YELLOW);
										}else{
											JOptionPane.showMessageDialog(null, "Invalido");
											this.cuadros--;
										}  
									}else{
										JOptionPane.showMessageDialog(null, "Invalido");
										this.cuadros--;
									}
								}else if(i<=7){
									if(infoSea[i+1][j]==1 || infoSea[i-1][j]==1){
										if(infoSea[i][j]==0){
											infoSea[i][j] = 1;
											sea[i][j].setBackground(Color.YELLOW);
										}else{
											JOptionPane.showMessageDialog(null, "Invalido");
											this.cuadros--;
										}
									}
								}
							}catch(Exception ee2){
								JOptionPane.showMessageDialog(null, "Invalido");
								this.cuadros--;
							}
						}
					}
					
					if(cuadros==13){
						try{
							if(infoSea[i-1][j]==0 && infoSea[i+1][j]==0 && infoSea[i][j-1]==0 
									&& infoSea[i][j+1]==0){
								if(infoSea[i][j]==0){
									infoSea[i][j] = 1;
									sea[i][j].setBackground(Color.green);
								}else{
									JOptionPane.showMessageDialog(null, "Invalido");
									this.cuadros--;
								}
							}else {
								JOptionPane.showMessageDialog(null,"Invalido");
								this.cuadros--;
							}
						}catch(Exception exception){
							try{
								if(j<=7){
									if(infoSea[i][j+1]==0 || infoSea[i][j-1]==0){
										if(infoSea[i][j]==0){
											infoSea[i][j] = 1;
											sea[i][j].setBackground(Color.green);
										}else{
											JOptionPane.showMessageDialog(null, "Invalido");
											this.cuadros--;
										}  
									}else{
										JOptionPane.showMessageDialog(null, "Invalido");
										this.cuadros--;
									}
								}else if(i<=7){
									if(infoSea[i+1][j]==0 || infoSea[i-1][j]==0){
										if(infoSea[i][j]==0){
											infoSea[i][j] = 1;
											sea[i][j].setBackground(Color.green);
										}else{
											JOptionPane.showMessageDialog(null, "Invalido");
											this.cuadros--;
										}
									}
								}
							}catch(Exception ee2){
								JOptionPane.showMessageDialog(null, "Invalido");
								this.cuadros--;
							}
						}
					}
						if(cuadros==14){
							try{
								if(infoSea[i-1][j]==1 || infoSea[i+1][j]==1){
									if(infoSea[i][j]==0){
										infoSea[i][j] = 1;
										sea[i][j].setBackground(Color.green);
									}else{
										JOptionPane.showMessageDialog(null, "Invalido");
										this.cuadros--;
									}
								}else if(infoSea[i][j-1]==1 || infoSea[i][j+1]==1){
									if(infoSea[i][j]==0){
										infoSea[i][j] = 1;
										sea[i][j].setBackground(Color.green);
									}else{
										JOptionPane.showMessageDialog(null, "Invalido");
										this.cuadros--;
									}
								}else{
									JOptionPane.showMessageDialog(null, "Invalido");
									this.cuadros--;
								}
							}catch(Exception es){
								try{
									if(j<=7){
										if(infoSea[i][j+1]==1 || infoSea[i][j-1]==1){
											if(infoSea[i][j]==0){
												infoSea[i][j] = 1;
												sea[i][j].setBackground(Color.green);
											}else{
												JOptionPane.showMessageDialog(null, "Invalido");
												this.cuadros--;
											} 
										}else{
											JOptionPane.showMessageDialog(null, "Invalido");
											this.cuadros--;
										}
									}else if(i<=7){
										if(infoSea[i+1][j]==1 || infoSea[i-1][j]==1){
											if(infoSea[i][j]==0){
												infoSea[i][j] = 1;
												sea[i][j].setBackground(Color.green);
											}else{
												JOptionPane.showMessageDialog(null, "Invalido");
												this.cuadros--;
											} 
										}
									}
								}catch(Exception e2){
									JOptionPane.showMessageDialog(null, "Invalido");
									this.cuadros--;
								}
							}
						}
						
						if(cuadros==15){
							try{
								if(infoSea[i-1][j]==0 && infoSea[i+1][j]==0 && infoSea[i][j-1]==0 
										&& infoSea[i][j+1]==0){
									if(infoSea[i][j]==0){
										infoSea[i][j] = 1;
										sea[i][j].setBackground(Color.pink);
										JOptionPane.showMessageDialog(null, "Barcos colocados");
										Thread.sleep(1000);
										this.paintComponent();
										this.state = true;
									}else{
										JOptionPane.showMessageDialog(null, "Invalido");
										this.cuadros--;
									}
								}else {
									JOptionPane.showMessageDialog(null,"Invalido");
									cuadros--;
								}
							}catch(Exception exception){
								try{
									if(j<=7){
										if(infoSea[i][j]==0 || infoSea[i][j-1]==0){
											if(infoSea[i][j]==0){
												infoSea[i][j] = 1;
												sea[i][j].setBackground(Color.pink);
												JOptionPane.showMessageDialog(null, "Barcos colocados");
												Thread.sleep(1000);
												this.paintComponent();
												this.state = true;
											}else{
												JOptionPane.showMessageDialog(null, "Invalido");
												this.cuadros--;
											}  
										}else{
											JOptionPane.showMessageDialog(null, "Invalido");
											this.cuadros--;
										}
									}else if(i<=7){
										if(infoSea[i+1][j]==0 || infoSea[i-1][j]==0){
											if(infoSea[i][j]==0){
												infoSea[i][j] = 1;
												sea[i][j].setBackground(Color.pink);
												JOptionPane.showMessageDialog(null, "Barcos colocados");
												Thread.sleep(1000);
												this.paintComponent();
												
												this.state = true;
											}else{
												JOptionPane.showMessageDialog(null, "Invalido");
												this.cuadros--;
											}
										}
									}
								}catch(Exception e2){
									JOptionPane.showMessageDialog(null, "Invalido");
									this.cuadros--;
								}
							}
					} 
						
			}
		}
	}
}	
	
	public void paintComponent(){
		for(int i=0;i<sea.length;i++){
			for(int j=0;j<sea.length;j++){
				sea[i][j].setEnabled(false);
			}
		}
	}
	
	public void dumpSeaLeft() throws Exception{
		String cadena="";
		for(int i=0;i<infoSea.length;i++){
			for(int j=0;j<infoSea.length;j++){
				cadena+= infoSea[i][j]+";";
			}
		}
		Main.getRemote().setTablePlayerOne(cadena);
	}
	
	
	public void dumpSeaRight() throws Exception{
		String cadena="";
		for(int i=0;i<infoSea.length;i++){
			for(int j=0;j<infoSea.length;j++){
				cadena+= infoSea[i][j]+";";
			}
		}
		Main.getRemote().setTablePlayerTwo(cadena);
	}
	
	public void loadSea1() throws Exception{
		String seaPlayer1 = Main.getRemote().getTablePlayerOne();
		StringTokenizer line = new StringTokenizer(seaPlayer1, ";");
		
		for(int i=0;i<infoSea.length;i++){
			for(int j=0;j<infoSea.length;j++){
				String aux = line.nextToken();
				
				infoSea[i][j] = Integer.parseInt(aux);
			}
		}
	}
	
	public void loadSea(String desc) throws Exception{
		if(desc=="right"){
			loadSea2();
		}else if(desc=="left"){
			loadSea1();
		}else if(desc=="player 3"){
			loadSea3();
		}
		
		for(int i=0;i<infoSea.length;i++){
			for(int j=0;j<infoSea.length;j++){
				if(infoSea[i][j]==1){
					this.sea[i][j].setEnabled(false);
				}
			}
		}
	}
	
	public void loadSea3() throws Exception{
		String seaPlayer1 = Main.getRemote().getTablePlayerThree();
		StringTokenizer line = new StringTokenizer(seaPlayer1, ";");
		
		for(int i=0;i<infoSea.length;i++){
			for(int j=0;j<infoSea.length;j++){
				String aux = line.nextToken();
				
				infoSea[i][j] = Integer.parseInt(aux);
			}
		}
	}
	
	public void loadSea2() throws Exception{
		String seaPlayer1 = Main.getRemote().getTablePlayerTwo();
		StringTokenizer line = new StringTokenizer(seaPlayer1, ";");
		
		for(int i=0;i<infoSea.length;i++){
			for(int j=0;j<infoSea.length;j++){
				String aux = line.nextToken();
				
				infoSea[i][j] = Integer.parseInt(aux);
			}
		}
	}
	
	public void load(String description) throws Exception{
		if(description == "right"){
			loadSea2();
		}else if(description=="left"){
			loadSea1();
		}else if(description=="player 3"){
			loadSea3();
		}
		
	}
	
	
	public void dump(String description) throws Exception{
		if(description=="right"){
			dumpSeaRight();
		}else if(description=="left"){
			dumpSeaLeft();
		}else if(description=="player 3"){
			dumpSea3();
		}
		
	}

	private void dumpSea3() throws Exception {
		// TODO Auto-generated method stub
		String cadena="";
		for(int i=0;i<infoSea.length;i++){
			for(int j=0;j<infoSea.length;j++){
				cadena+= infoSea[i][j]+";";
			}
		}
		Main.getRemote().setTablePlayerThree(cadena);	
	}
	
	
}
