package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Tris;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class Finestra_Server extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblIlNostroTris;
	private JLabel lblAttendiIlSecondo;
	private JPanel panel_1;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	private JButton button_7;
	private JButton button_8;
	private JPanel panel_2;
	private JTextField textField;
	private JLabel lblNome;
	private JLabel lblTurni;
	private JComboBox comboBox;
	private JButton btnAvviaTris;
	private JLabel lblTurnoPlayer;
	private JLabel lblVittorieP;
	private JLabel lblTurniTotali;
	private JLabel lblTurniRimanenti;
	private JLabel lblLocalhost;


	/**
	 * Create the frame.
	 */
	public Finestra_Server() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
				panel = new JPanel();
				panel.setBounds(10, 10, 416, 243);
				contentPane.add(panel);
				panel.setLayout(null);
				
						lblIlNostroTris = new JLabel("Indirizzo stanza tris");
						lblIlNostroTris.setBounds(91, 34, 142, 13);
						panel.add(lblIlNostroTris);
						
								lblAttendiIlSecondo = new JLabel("Attendi il giocatore avversario ...");
								lblAttendiIlSecondo.setBounds(91, 156, 252, 13);
								panel.add(lblAttendiIlSecondo);
								
								lblLocalhost = new JLabel("localhost");
								lblLocalhost.setFont(new Font("Tahoma", Font.BOLD, 10));
								lblLocalhost.setBounds(91, 57, 122, 13);
								panel.add(lblLocalhost);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(0, 0, 416, 243);
		contentPane.add(panel_1);
				
		button = new JButton("");
		button.setBounds(61, 43, 56, 56);
		panel_1.add(button);
						
		button_1 = new JButton("");
		button_1.setBounds(117, 43, 56, 56);
		panel_1.add(button_1);
	
		button_2 = new JButton("");
		button_2.setBounds(173, 43, 56, 56);
		panel_1.add(button_2);
										
		button_3 = new JButton("");
		button_3.setBounds(61, 99, 56, 56);
		panel_1.add(button_3);
												
		button_4 = new JButton("");
		button_4.setBounds(117, 99, 56, 56);
		panel_1.add(button_4);
														
		button_5 = new JButton("");
		button_5.setBounds(173, 99, 56, 56);
		panel_1.add(button_5);
																
		button_6 = new JButton("");
		button_6.setBounds(61, 155, 56, 56);
		panel_1.add(button_6);
																		
		button_7 = new JButton("");
		button_7.setBounds(117, 155, 56, 56);
		panel_1.add(button_7);
																				
		button_8 = new JButton("");
		button_8.setBounds(173, 155, 56, 56);
		panel_1.add(button_8);
																										
		panel_1.setVisible(false);
		
		panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 406, 233);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(137, 43, 96, 19);
		panel_2.add(textField);
		textField.setColumns(10);
		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(44, 46, 45, 13);
		panel_2.add(lblNome);
		
		lblTurni = new JLabel("Turni");
		lblTurni.setBounds(44, 103, 45, 13);
		panel_2.add(lblTurni);
		
		lblTurnoPlayer = new JLabel("Vittorie P1");
		lblTurnoPlayer.setBounds(282, 102, 124, 13);
		panel_1.add(lblTurnoPlayer);
																										
		lblVittorieP = new JLabel("Vittorie P2");
		lblVittorieP.setBounds(282, 125, 124, 13);
		panel_1.add(lblVittorieP);
																										
		lblTurniTotali = new JLabel("Turni totali");
		lblTurniTotali.setBounds(282, 25, 124, 13);
		panel_1.add(lblTurniTotali);
																										
		lblTurniRimanenti = new JLabel("Turni rimanenti");
		lblTurniRimanenti.setBounds(282, 43, 124, 13);
		panel_1.add(lblTurniRimanenti);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		comboBox.setBounds(122, 99, 53, 21);
		panel_2.add(comboBox);
		
		btnAvviaTris = new JButton("Avvia Tris");
		btnAvviaTris.setBounds(90, 165, 85, 21);
		panel_2.add(btnAvviaTris);
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JPanel getPanel_1() {
		return panel_1;
	}

	public void setPanel_1(JPanel panel_1) {
		this.panel_1 = panel_1;
	}

	public JButton getButton() {
		return button;
	}

	public void setButton(JButton button) {
		this.button = button;
	}

	public JButton getButton_1() {
		return button_1;
	}

	public void setButton_1(JButton button_1) {
		this.button_1 = button_1;
	}

	public JButton getButton_2() {
		return button_2;
	}

	public void setButton_2(JButton button_2) {
		this.button_2 = button_2;
	}

	public JButton getButton_3() {
		return button_3;
	}

	public void setButton_3(JButton button_3) {
		this.button_3 = button_3;
	}

	public JButton getButton_4() {
		return button_4;
	}

	public void setButton_4(JButton button_4) {
		this.button_4 = button_4;
	}

	public JButton getButton_5() {
		return button_5;
	}

	public void setButton_5(JButton button_5) {
		this.button_5 = button_5;
	}

	public JButton getButton_6() {
		return button_6;
	}

	public void setButton_6(JButton button_6) {
		this.button_6 = button_6;
	}

	public JButton getButton_7() {
		return button_7;
	}

	public void setButton_7(JButton button_7) {
		this.button_7 = button_7;
	}

	public JButton getButton_8() {
		return button_8;
	}

	public void setButton_8(JButton button_8) {
		this.button_8 = button_8;
	}	
	
	public JPanel getPanel_2() {
		return panel_2;
	}

	public void setPanel_2(JPanel panel_2) {
		this.panel_2 = panel_2;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

	public JButton getBtnAvviaTris() {
		return btnAvviaTris;
	}

	public void setBtnAvviaTris(JButton btnAvviaTris) {
		this.btnAvviaTris = btnAvviaTris;
	}

	public JLabel getLblTurnoPlayer() {
		return lblTurnoPlayer;
	}

	public void setLblTurnoPlayer(JLabel lblTurnoPlayer) {
		this.lblTurnoPlayer = lblTurnoPlayer;
	}

	public JLabel getLblVittorieP() {
		return lblVittorieP;
	}

	public void setLblVittorieP(JLabel lblVittorieP) {
		this.lblVittorieP = lblVittorieP;
	}
	
	public JLabel getLblTurniTotali() {
		return lblTurniTotali;
	}

	public void setLblTurniTotali(JLabel lblTurniTotali) {
		this.lblTurniTotali = lblTurniTotali;
	}

	public JLabel getLblTurniRimanenti() {
		return lblTurniRimanenti;
	}

	public void setLblTurniRimanenti(JLabel lblTurniRimanenti) {
		this.lblTurniRimanenti = lblTurniRimanenti;
	}

	public void bloccaCaselle() {
		this.getButton().setEnabled(false);
		this.getButton_1().setEnabled(false);
		this.getButton_2().setEnabled(false);
		this.getButton_3().setEnabled(false);
		this.getButton_4().setEnabled(false);
		this.getButton_5().setEnabled(false);
		this.getButton_6().setEnabled(false);
		this.getButton_7().setEnabled(false);
		this.getButton_8().setEnabled(false);
	}
	
	public void attivaCaselle(Tris tris) {
		ImageIcon imgcerchio= new ImageIcon("src/img/cerchio.png");
		ImageIcon imgcroce= new ImageIcon("src/img/croce.png");
		if(tris.getCella(0, 0)==1) {
			this.getButton().setIcon(imgcerchio);
		}else if(tris.getCella(0, 0)==2) {
			this.getButton().setIcon(imgcroce);
		}
		if(tris.getCella(1, 0)==1) {
			this.getButton_1().setIcon(imgcerchio);
		}else if(tris.getCella(1, 0)==2) {
			this.getButton_1().setIcon(imgcroce);
		}
		if(tris.getCella(2, 0)==1) {
			this.getButton_2().setIcon(imgcerchio);
		}else if(tris.getCella(2, 0)==2) {
			this.getButton_2().setIcon(imgcroce);
		}
		if(tris.getCella(0, 1)==1) {
			this.getButton_3().setIcon(imgcerchio);
		}else if(tris.getCella(0, 1)==2) {
			this.getButton_3().setIcon(imgcroce);
		}
		if(tris.getCella(1, 1)==1) {
			this.getButton_4().setIcon(imgcerchio);
		}else if(tris.getCella(1, 1)==2) {
			this.getButton_4().setIcon(imgcroce);
		}
		if(tris.getCella(2, 1)==1) {
			this.getButton_5().setIcon(imgcerchio);
		}else if(tris.getCella(2, 1)==2) {
			this.getButton_5().setIcon(imgcroce);
		}
		if(tris.getCella(0, 2)==1) {
			this.getButton_6().setIcon(imgcerchio);
		}else if(tris.getCella(0, 2)==2) {
			this.getButton_6().setIcon(imgcroce);
		}
		if(tris.getCella(1, 2)==1) {
			this.getButton_7().setIcon(imgcerchio);
		}else if(tris.getCella(1, 2)==2) {
			this.getButton_7().setIcon(imgcroce);
		}
		if(tris.getCella(2, 2)==1) {
			this.getButton_8().setIcon(imgcerchio);
		}else if(tris.getCella(2, 2)==2) {
			this.getButton_8().setIcon(imgcroce);
		}
		
		if(tris.getCella(0, 0)==0)
			this.getButton().setEnabled(true);
		if(tris.getCella(1, 0)==0)
			this.getButton_1().setEnabled(true);
		if(tris.getCella(2, 0)==0)
			this.getButton_2().setEnabled(true);
		if(tris.getCella(0, 1)==0)
			this.getButton_3().setEnabled(true);
		if(tris.getCella(1, 1)==0)
			this.getButton_4().setEnabled(true);
		if(tris.getCella(2, 1)==0)
			this.getButton_5().setEnabled(true);
		if(tris.getCella(0, 2)==0)
			this.getButton_6().setEnabled(true);
		if(tris.getCella(1, 2)==0)
			this.getButton_7().setEnabled(true);
		if(tris.getCella(2, 2)==0)
			this.getButton_8().setEnabled(true);
	}
	
	public void resettaCelle() {
		this.getButton().setIcon(null);
		this.getButton_1().setIcon(null);
		this.getButton_2().setIcon(null);
		this.getButton_3().setIcon(null);
		this.getButton_4().setIcon(null);
		this.getButton_5().setIcon(null);
		this.getButton_6().setIcon(null);
		this.getButton_7().setIcon(null);
		this.getButton_8().setIcon(null);
	}
}
