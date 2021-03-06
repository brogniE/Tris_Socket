package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatDarkPurpleIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatGrayIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatNordIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkContrastIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneLightIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatDraculaContrastIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubIJTheme;
import com.formdev.flatlaf.ui.FlatColorChooserUI;
import com.formdev.flatlaf.ui.FlatDesktopIconUI;

import Model.Tris;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * La classe rappresenta la finestra grafica tramite la quale l'utente si interfacia con il programma
 */
public class Finestra_Menu extends JFrame {

	private JPanel contentPaneMenu;
	private JLabel lblTris;
	private JLabel lblScegliereLopzione;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JPanel panelStartServer;
	private JTextField textField;
	private JLabel lblNome;
	private JLabel lblTurni;
	private JComboBox comboBox;
	private JButton btnAvviaTris;
	private JPanel panelServerWait;
	private JLabel lblIlNostroTris;
	private JLabel lblAttendiIlSecondo;
	private JLabel lblLocalhost;
	private JPanel panelServerPlay;
	private JButton buttonServer;
	private JButton button_1Server;
	private JButton button_2Server;
	private JButton button_3Server;
	private JButton button_4Server;
	private JButton button_5Server;
	private JButton button_6Server;
	private JButton button_7Server;
	private JButton button_8Server;
	private JButton buttonClient;
	private JButton button_1Client;
	private JButton button_2Client;
	private JButton button_3Client;
	private JButton button_4Client;
	private JButton button_5Client;
	private JButton button_6Client;
	private JButton button_7Client;
	private JButton button_8Client;
	private JLabel lblVittorieP1Server;
	private JLabel lblVittorieP2Server;
	private JLabel lblVittorieP1Client;
	private JLabel lblVittorieP2Client;
	private JLabel lblTurniTotaliServer;
	private JLabel lblTurniTotaliClient;
	private JLabel lblTurniRimanentiServer;
	private JLabel lblTurniRimanentiClient;
	private JPanel panelMenu;
	private JPanel panelClientJoin;
	private JTextField textField_1;
	private JLabel lblIpConcorrente;
	private JButton btnGioca;
	private JLabel lblNome_1;
	private JTextField textField_2;
	private JPanel panelClientPlay;
	private JButton btnIndietro1;
	private JButton btnIndietro3;
	private JButton btnImpostazioni;
	private JPanel panelResultServer;
	private JLabel labelResultServer;
	private JButton btnOkServer;
	private JPanel panelResultClient;
	private JLabel labelResultClient;
	private JButton btnOkClient;
/**
 * @param n indica lo stile grafico con cui avviarla
 */
	public Finestra_Menu(int n) {
		if(n==0) {
			try {
				UIManager.setLookAndFeel(new FlatLightLaf());
			} catch (UnsupportedLookAndFeelException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(n==1) {
			try {
				UIManager.setLookAndFeel(new FlatDarkLaf());
			} catch (UnsupportedLookAndFeelException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPaneMenu = new JPanel();
		contentPaneMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneMenu);
		contentPaneMenu.setLayout(null);

		panelMenu = new JPanel();
		panelMenu.setBounds(0, 0, 434, 260);
		contentPaneMenu.add(panelMenu);
		panelMenu.setLayout(null);

		lblTris = new JLabel("TRIS");
		lblTris.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblTris.setBounds(176, 37, 68, 28);
		panelMenu.add(lblTris);

		lblScegliereLopzione = new JLabel("Scegliere l'opzione");
		lblScegliereLopzione.setBounds(151, 103, 129, 14);
		panelMenu.add(lblScegliereLopzione);

		btnNewButton = new JButton("CREA GIOCO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(127, 139, 153, 28);
		panelMenu.add(btnNewButton);

		btnNewButton_1 = new JButton("UNISCITI AL GIOCO");
		btnNewButton_1.setBounds(127, 183, 153, 28);
		panelMenu.add(btnNewButton_1);

		btnImpostazioni = new JButton("");
		btnImpostazioni.setIcon(new ImageIcon(Finestra_Menu.class.getResource("/img/luna.png")));
		btnImpostazioni.setBounds(404, 0, 30, 30);
		panelMenu.add(btnImpostazioni);

		panelMenu.setVisible(true);

		panelServerWait = new JPanel();
		panelServerWait.setLayout(null);
		panelServerWait.setBounds(0, 0, 416, 243);
		contentPaneMenu.add(panelServerWait);

		lblIlNostroTris = new JLabel("Indirizzo stanza tris");
		lblIlNostroTris.setBounds(91, 34, 142, 13);
		panelServerWait.add(lblIlNostroTris);

		lblAttendiIlSecondo = new JLabel("Attendi il giocatore avversario ...");
		lblAttendiIlSecondo.setBounds(91, 156, 252, 13);
		panelServerWait.add(lblAttendiIlSecondo);

		lblLocalhost = new JLabel("");
		lblLocalhost.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblLocalhost.setBounds(91, 57, 122, 13);
		panelServerWait.add(lblLocalhost);

		panelServerWait.setVisible(false);

		panelClientJoin = new JPanel();
		panelClientJoin.setLayout(null);
		panelClientJoin.setBounds(0, 0, 412, 253);
		contentPaneMenu.add(panelClientJoin);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(149, 80, 96, 25);
		panelClientJoin.add(textField_1);

		lblIpConcorrente = new JLabel("Indirizzo stanza");
		lblIpConcorrente.setBounds(23, 90, 96, 13);
		panelClientJoin.add(lblIpConcorrente);

		btnGioca = new JButton("Gioca");
		btnGioca.setBounds(127, 149, 103, 59);
		panelClientJoin.add(btnGioca);

		lblNome_1 = new JLabel("Nome ");
		lblNome_1.setBounds(23, 55, 112, 13);
		panelClientJoin.add(lblNome_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(149, 49, 96, 25);
		panelClientJoin.add(textField_2);

		btnIndietro3 = new JButton("");
		btnIndietro3.setIcon(new ImageIcon(Finestra_Menu.class.getResource("/img/indietro.png")));
		btnIndietro3.setBounds(0, 0, 39, 32);
		panelClientJoin.add(btnIndietro3);

		panelClientJoin.setVisible(false);

		panelStartServer = new JPanel();
		panelStartServer.setLayout(null);
		panelStartServer.setBounds(0, 0, 416, 253);
		contentPaneMenu.add(panelStartServer);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(137, 43, 96, 25);
		panelStartServer.add(textField);

		lblNome = new JLabel("Nome");
		lblNome.setBounds(44, 46, 45, 13);
		panelStartServer.add(lblNome);

		lblTurni = new JLabel("Turni");
		lblTurni.setBounds(44, 103, 45, 13);
		panelStartServer.add(lblTurni);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		comboBox.setBounds(122, 99, 53, 21);
		panelStartServer.add(comboBox);

		btnAvviaTris = new JButton("Avvia Tris");
		btnAvviaTris.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAvviaTris.setBounds(90, 165, 113, 32);
		panelStartServer.add(btnAvviaTris);

		btnIndietro1 = new JButton("");
		btnIndietro1.setIcon(new ImageIcon(Finestra_Menu.class.getResource("/img/indietro.png")));
		btnIndietro1.setBounds(0, 0, 39, 32);
		panelStartServer.add(btnIndietro1);

		panelStartServer.setVisible(false);

		panelServerPlay = new JPanel();
		panelServerPlay.setLayout(null);
		panelServerPlay.setBounds(0, 0, 416, 243);
		contentPaneMenu.add(panelServerPlay);

		buttonServer = new JButton("");
		buttonServer.setBounds(61, 43, 56, 56);
		panelServerPlay.add(buttonServer);

		button_1Server = new JButton("");
		button_1Server.setBounds(117, 43, 56, 56);
		panelServerPlay.add(button_1Server);

		button_2Server = new JButton("");
		button_2Server.setBounds(173, 43, 56, 56);
		panelServerPlay.add(button_2Server);

		button_3Server = new JButton("");
		button_3Server.setBounds(61, 99, 56, 56);
		panelServerPlay.add(button_3Server);

		button_4Server = new JButton("");
		button_4Server.setBounds(117, 99, 56, 56);
		panelServerPlay.add(button_4Server);

		button_5Server = new JButton("");
		button_5Server.setBounds(173, 99, 56, 56);
		panelServerPlay.add(button_5Server);

		button_6Server = new JButton("");
		button_6Server.setBounds(61, 155, 56, 56);
		panelServerPlay.add(button_6Server);

		button_7Server = new JButton("");
		button_7Server.setBounds(117, 155, 56, 56);
		panelServerPlay.add(button_7Server);

		button_8Server = new JButton("");
		button_8Server.setBounds(173, 155, 56, 56);
		panelServerPlay.add(button_8Server);

		lblVittorieP1Server = new JLabel("");
		lblVittorieP1Server.setBounds(282, 102, 124, 13);
		panelServerPlay.add(lblVittorieP1Server);

		lblVittorieP2Server = new JLabel("");
		lblVittorieP2Server.setBounds(282, 125, 124, 13);
		panelServerPlay.add(lblVittorieP2Server);

		lblTurniTotaliServer = new JLabel("");
		lblTurniTotaliServer.setBounds(282, 25, 124, 13);
		panelServerPlay.add(lblTurniTotaliServer);

		lblTurniRimanentiServer = new JLabel("");
		lblTurniRimanentiServer.setBounds(282, 43, 124, 13);
		panelServerPlay.add(lblTurniRimanentiServer);

		panelServerPlay.setVisible(false);

		panelClientPlay = new JPanel();
		panelClientPlay.setBounds(0, 0, 434, 260);
		contentPaneMenu.add(panelClientPlay);
		panelClientPlay.setLayout(null);

		buttonClient = new JButton("");
		buttonClient.setBounds(61, 43, 56, 56);
		panelClientPlay.add(buttonClient);

		button_1Client = new JButton("");
		button_1Client.setBounds(117, 43, 56, 56);
		panelClientPlay.add(button_1Client);

		button_2Client = new JButton("");
		button_2Client.setBounds(173, 43, 56, 56);
		panelClientPlay.add(button_2Client);

		button_3Client = new JButton("");
		button_3Client.setBounds(61, 99, 56, 56);
		panelClientPlay.add(button_3Client);

		button_4Client = new JButton("");
		button_4Client.setBounds(117, 99, 56, 56);
		panelClientPlay.add(button_4Client);

		button_5Client = new JButton("");
		button_5Client.setBounds(173, 99, 56, 56);
		panelClientPlay.add(button_5Client);

		button_6Client = new JButton("");
		button_6Client.setBounds(61, 155, 56, 56);
		panelClientPlay.add(button_6Client);

		button_7Client = new JButton("");
		button_7Client.setBounds(117, 155, 56, 56);
		panelClientPlay.add(button_7Client);

		button_8Client = new JButton("");
		button_8Client.setBounds(173, 155, 56, 56);
		panelClientPlay.add(button_8Client);

		lblVittorieP1Client = new JLabel("");
		lblVittorieP1Client.setBounds(282, 102, 134, 13);
		panelClientPlay.add(lblVittorieP1Client);

		lblVittorieP2Client = new JLabel("");
		lblVittorieP2Client.setBounds(282, 125, 134, 13);
		panelClientPlay.add(lblVittorieP2Client);

		lblTurniTotaliClient = new JLabel("Turni totali");
		lblTurniTotaliClient.setBounds(282, 25, 134, 13);
		panelClientPlay.add(lblTurniTotaliClient);

		lblTurniRimanentiClient = new JLabel("Turni rimanenti");
		lblTurniRimanentiClient.setBounds(282, 43, 134, 13);
		panelClientPlay.add(lblTurniRimanentiClient);

		panelClientPlay.setVisible(false);

		panelResultServer = new JPanel();
		panelResultServer.setLayout(null);
		panelResultServer.setBounds(0, 0, 416, 243);
		contentPaneMenu.add(panelResultServer);

		labelResultServer = new JLabel("");
		labelResultServer.setFont(new Font("Tahoma", Font.BOLD, 26));
		labelResultServer.setBounds(125, 55, 217, 50);
		panelResultServer.add(labelResultServer);

		btnOkServer = new JButton("OK");
		btnOkServer.setBounds(165, 177, 85, 21);
		panelResultServer.add(btnOkServer);

		panelResultServer.setVisible(false);

		panelResultClient = new JPanel();
		panelResultClient.setLayout(null);
		panelResultClient.setBounds(0, 0, 416, 243);
		contentPaneMenu.add(panelResultClient);

		labelResultClient = new JLabel("");
		labelResultClient.setFont(new Font("Tahoma", Font.BOLD, 26));
		labelResultClient.setBounds(125, 55, 217, 50);
		panelResultClient.add(labelResultClient);

		btnOkClient = new JButton("OK");
		btnOkClient.setBounds(165, 177, 85, 21);
		panelResultClient.add(btnOkClient);

		panelResultClient.setVisible(false);

	}



	public JButton getBtnNewButton() {
		return btnNewButton;
	}

	public void setBtnNewButton(JButton btnNewButton) {
		this.btnNewButton = btnNewButton;
	}

	public JButton getBtnNewButton_1() {
		return btnNewButton_1;
	}

	public void setBtnNewButton_1(JButton btnNewButton_1) {
		this.btnNewButton_1 = btnNewButton_1;
	}

	public JPanel getPanelStartServer() {
		return panelStartServer;
	}

	public void setPanelStartServer(JPanel panelStartServer) {
		this.panelStartServer = panelStartServer;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JLabel getLblTurni() {
		return lblTurni;
	}

	public void setLblTurni(JLabel lblTurni) {
		this.lblTurni = lblTurni;
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

	public JPanel getPanelServerWait() {
		return panelServerWait;
	}

	public void setPanelServerWait(JPanel panelServerWait) {
		this.panelServerWait = panelServerWait;
	}

	public JLabel getLblLocalhost() {
		return lblLocalhost;
	}

	public void setLblLocalhost(JLabel lblLocalhost) {
		this.lblLocalhost = lblLocalhost;
	}

	public JPanel getPanelServerPlay() {
		return panelServerPlay;
	}

	public void setPanelServerPlay(JPanel panelServerPlay) {
		this.panelServerPlay = panelServerPlay;
	}

	public JButton getButtonServer() {
		return buttonServer;
	}

	public void setButtonServer(JButton buttonServer) {
		this.buttonServer = buttonServer;
	}

	public JButton getButton_1Server() {
		return button_1Server;
	}

	public void setButton_1Server(JButton button_1Server) {
		this.button_1Server = button_1Server;
	}

	public JButton getButton_2Server() {
		return button_2Server;
	}

	public void setButton_2Server(JButton button_2Server) {
		this.button_2Server = button_2Server;
	}

	public JButton getButton_3Server() {
		return button_3Server;
	}

	public void setButton_3Server(JButton button_3Server) {
		this.button_3Server = button_3Server;
	}

	public JButton getButton_4Server() {
		return button_4Server;
	}

	public void setButton_4Server(JButton button_4Server) {
		this.button_4Server = button_4Server;
	}

	public JButton getButton_5Server() {
		return button_5Server;
	}

	public void setButton_5Server(JButton button_5Server) {
		this.button_5Server = button_5Server;
	}

	public JButton getButton_6Server() {
		return button_6Server;
	}

	public void setButton_6Server(JButton button_6Server) {
		this.button_6Server = button_6Server;
	}

	public JButton getButton_7Server() {
		return button_7Server;
	}

	public void setButton_7Server(JButton button_7Server) {
		this.button_7Server = button_7Server;
	}

	public JButton getButton_8Server() {
		return button_8Server;
	}

	public void setButton_8Server(JButton button_8Server) {
		this.button_8Server = button_8Server;
	}

	public JButton getButtonClient() {
		return buttonClient;
	}

	public void setButtonClient(JButton buttonClient) {
		this.buttonClient = buttonClient;
	}

	public JButton getButton_1Client() {
		return button_1Client;
	}

	public void setButton_1Client(JButton button_1Client) {
		this.button_1Client = button_1Client;
	}

	public JButton getButton_2Client() {
		return button_2Client;
	}

	public void setButton_2Client(JButton button_2Client) {
		this.button_2Client = button_2Client;
	}

	public JButton getButton_3Client() {
		return button_3Client;
	}

	public void setButton_3Client(JButton button_3Client) {
		this.button_3Client = button_3Client;
	}

	public JButton getButton_4Client() {
		return button_4Client;
	}

	public void setButton_4Client(JButton button_4Client) {
		this.button_4Client = button_4Client;
	}

	public JButton getButton_5Client() {
		return button_5Client;
	}

	public void setButton_5Client(JButton button_5Client) {
		this.button_5Client = button_5Client;
	}

	public JButton getButton_6Client() {
		return button_6Client;
	}

	public void setButton_6Client(JButton button_6Client) {
		this.button_6Client = button_6Client;
	}

	public JButton getButton_7Client() {
		return button_7Client;
	}

	public void setButton_7Client(JButton button_7Client) {
		this.button_7Client = button_7Client;
	}

	public JButton getButton_8Client() {
		return button_8Client;
	}

	public void setButton_8Client(JButton button_8Client) {
		this.button_8Client = button_8Client;
	}

	public JLabel getLblTurniTotaliServer() {
		return lblTurniTotaliServer;
	}

	public void setLblTurniTotaliServer(JLabel lblTurniTotaliServer) {
		this.lblTurniTotaliServer = lblTurniTotaliServer;
	}

	public JLabel getLblTurniRimanentiServer() {
		return lblTurniRimanentiServer;
	}

	public void setLblTurniRimanentiServer(JLabel lblTurniRimanentiServer) {
		this.lblTurniRimanentiServer = lblTurniRimanentiServer;
	}

	public JPanel getPanelMenu() {
		return panelMenu;
	}

	public void setPanelMenu(JPanel panelMenu) {
		this.panelMenu = panelMenu;
	}

	public JPanel getPanelClientJoin() {
		return panelClientJoin;
	}

	public void setPanelClientJoin(JPanel panelClientJoin) {
		this.panelClientJoin = panelClientJoin;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}

	public JButton getBtnGioca() {
		return btnGioca;
	}

	public void setBtnGioca(JButton btnGioca) {
		this.btnGioca = btnGioca;
	}

	public JTextField getTextField_2() {
		return textField_2;
	}

	public void setTextField_2(JTextField textField_2) {
		this.textField_2 = textField_2;
	}

	public JPanel getPanelClientPlay() {
		return panelClientPlay;
	}

	public void setPanelClientPlay(JPanel panelClientPlay) {
		this.panelClientPlay = panelClientPlay;
	}

	public JLabel getLblVittorieP1Server() {
		return lblVittorieP1Server;
	}

	public void setLblVittorieP1Server(JLabel lblVittorieP1Server) {
		this.lblVittorieP1Server = lblVittorieP1Server;
	}

	public JLabel getLblVittorieP2Server() {
		return lblVittorieP2Server;
	}

	public void setLblVittorieP2Server(JLabel lblVittorieP2Server) {
		this.lblVittorieP2Server = lblVittorieP2Server;
	}

	public JLabel getLblVittorieP1Client() {
		return lblVittorieP1Client;
	}

	public void setLblVittorieP1Client(JLabel lblVittorieP1Client) {
		this.lblVittorieP1Client = lblVittorieP1Client;
	}

	public JLabel getLblVittorieP2Client() {
		return lblVittorieP2Client;
	}

	public void setLblVittorieP2Client(JLabel lblVittorieP2Client) {
		this.lblVittorieP2Client = lblVittorieP2Client;
	}


	public JLabel getLblTurniTotaliClient() {
		return lblTurniTotaliClient;
	}

	public void setLblTurniTotaliClient(JLabel lblTurniTotaliClient) {
		this.lblTurniTotaliClient = lblTurniTotaliClient;
	}

	public JLabel getLblTurniRimanentiClient() {
		return lblTurniRimanentiClient;
	}

	public void setLblTurniRimanentiClient(JLabel lblTurniRimanentiClient) {
		this.lblTurniRimanentiClient = lblTurniRimanentiClient;
	}

	public JButton getBtnIndietro1() {
		return btnIndietro1;
	}

	public void setBtnIndietro1(JButton btnIndietro1) {
		this.btnIndietro1 = btnIndietro1;
	}

	public JButton getBtnIndietro3() {
		return btnIndietro3;
	}

	public void setBtnIndietro3(JButton btnIndietro3) {
		this.btnIndietro3 = btnIndietro3;
	}

	public JButton getBtnImpostazioni() {
		return btnImpostazioni;
	}


	public void setBtnImpostazioni(JButton btnImpostazioni) {
		this.btnImpostazioni = btnImpostazioni;
	}

	public JPanel getPanelResultServer() {
		return panelResultServer;
	}

	public void setPanelResultServer(JPanel panelResultServer) {
		this.panelResultServer = panelResultServer;
	}

	public JLabel getLabelResultServer() {
		return labelResultServer;
	}

	public void setLabelResultServer(JLabel labelResultServer) {
		this.labelResultServer = labelResultServer;
	}

	public JButton getBtnOkServer() {
		return btnOkServer;
	}

	public void setBtnOkServer(JButton btnOkServer) {
		this.btnOkServer = btnOkServer;
	}

	public JPanel getPanelResultClient() {
		return panelResultClient;
	}

	public void setPanelResultClient(JPanel panelResultClient) {
		this.panelResultClient = panelResultClient;
	}

	public JLabel getLabelResultClient() {
		return labelResultClient;
	}

	public void setLabelResultClient(JLabel labelResultClient) {
		this.labelResultClient = labelResultClient;
	}

	public JButton getBtnOkClient() {
		return btnOkClient;
	}

	public void setBtnOkClient(JButton btnOkClient) {
		this.btnOkClient = btnOkClient;
	}


	/**
	 * Il metodo rende non cliccabili le celle che compongono il tris del Player 1 
	 */
	public void bloccaCaselleServer() {
		this.getButtonServer().setEnabled(false);
		this.getButton_1Server().setEnabled(false);
		this.getButton_2Server().setEnabled(false);
		this.getButton_3Server().setEnabled(false);
		this.getButton_4Server().setEnabled(false);
		this.getButton_5Server().setEnabled(false);
		this.getButton_6Server().setEnabled(false);
		this.getButton_7Server().setEnabled(false);
		this.getButton_8Server().setEnabled(false);
	}

	/**
	 * Il metodo rende cliccabili le celle che compongono il tris del Player 1 
	 */
	public void attivaCaselleServer(Tris tris) {
		ImageIcon imgcerchio= new ImageIcon("src/img/cerchio.png");
		ImageIcon imgcroce= new ImageIcon("src/img/croce.png");
		if(tris.getCella(0, 0)==1) {
			this.getButtonServer().setIcon(imgcerchio);
		}else if(tris.getCella(0, 0)==2) {
			this.getButtonServer().setIcon(imgcroce);
		}
		if(tris.getCella(1, 0)==1) {
			this.getButton_1Server().setIcon(imgcerchio);
		}else if(tris.getCella(1, 0)==2) {
			this.getButton_1Server().setIcon(imgcroce);
		}
		if(tris.getCella(2, 0)==1) {
			this.getButton_2Server().setIcon(imgcerchio);
		}else if(tris.getCella(2, 0)==2) {
			this.getButton_2Server().setIcon(imgcroce);
		}
		if(tris.getCella(0, 1)==1) {
			this.getButton_3Server().setIcon(imgcerchio);
		}else if(tris.getCella(0, 1)==2) {
			this.getButton_3Server().setIcon(imgcroce);
		}
		if(tris.getCella(1, 1)==1) {
			this.getButton_4Server().setIcon(imgcerchio);
		}else if(tris.getCella(1, 1)==2) {
			this.getButton_4Server().setIcon(imgcroce);
		}
		if(tris.getCella(2, 1)==1) {
			this.getButton_5Server().setIcon(imgcerchio);
		}else if(tris.getCella(2, 1)==2) {
			this.getButton_5Server().setIcon(imgcroce);
		}
		if(tris.getCella(0, 2)==1) {
			this.getButton_6Server().setIcon(imgcerchio);
		}else if(tris.getCella(0, 2)==2) {
			this.getButton_6Server().setIcon(imgcroce);
		}
		if(tris.getCella(1, 2)==1) {
			this.getButton_7Server().setIcon(imgcerchio);
		}else if(tris.getCella(1, 2)==2) {
			this.getButton_7Server().setIcon(imgcroce);
		}
		if(tris.getCella(2, 2)==1) {
			this.getButton_8Server().setIcon(imgcerchio);
		}else if(tris.getCella(2, 2)==2) {
			this.getButton_8Server().setIcon(imgcroce);
		}

		if(tris.getCella(0, 0)==0)
			this.getButtonServer().setEnabled(true);
		if(tris.getCella(1, 0)==0)
			this.getButton_1Server().setEnabled(true);
		if(tris.getCella(2, 0)==0)
			this.getButton_2Server().setEnabled(true);
		if(tris.getCella(0, 1)==0)
			this.getButton_3Server().setEnabled(true);
		if(tris.getCella(1, 1)==0)
			this.getButton_4Server().setEnabled(true);
		if(tris.getCella(2, 1)==0)
			this.getButton_5Server().setEnabled(true);
		if(tris.getCella(0, 2)==0)
			this.getButton_6Server().setEnabled(true);
		if(tris.getCella(1, 2)==0)
			this.getButton_7Server().setEnabled(true);
		if(tris.getCella(2, 2)==0)
			this.getButton_8Server().setEnabled(true);
	}

	/**
	 * Il metodo reimposta le celle del tris del Player 1
	 */
	public void resettaCelleServer() {
		this.getButtonServer().setIcon(null);
		this.getButton_1Server().setIcon(null);
		this.getButton_2Server().setIcon(null);
		this.getButton_3Server().setIcon(null);
		this.getButton_4Server().setIcon(null);
		this.getButton_5Server().setIcon(null);
		this.getButton_6Server().setIcon(null);
		this.getButton_7Server().setIcon(null);
		this.getButton_8Server().setIcon(null);
	}

	/**
	 * Il metodo rende non cliccabili le celle che compongono il tris del Player 2 
	 */
	public void bloccaCaselleClient() {
		this.getButtonClient().setEnabled(false);
		this.getButton_1Client().setEnabled(false);
		this.getButton_2Client().setEnabled(false);
		this.getButton_3Client().setEnabled(false);
		this.getButton_4Client().setEnabled(false);
		this.getButton_5Client().setEnabled(false);
		this.getButton_6Client().setEnabled(false);
		this.getButton_7Client().setEnabled(false);
		this.getButton_8Client().setEnabled(false);
	}
	
	/**
	 * Il metodo rende cliccabili le celle che compongono il tris del Player 2
	 */
	public void attivaCaselleClient(Tris tris) {
		ImageIcon imgcerchio= new ImageIcon("src/img/cerchio.png");
		ImageIcon imgcroce= new ImageIcon("src/img/croce.png");

		if(tris.getCella(0, 0)==1) {
			this.getButtonClient().setIcon(imgcerchio);
		}else if(tris.getCella(0, 0)==2) {
			this.getButtonClient().setIcon(imgcroce);
		}
		if(tris.getCella(1, 0)==1) {
			this.getButton_1Client().setIcon(imgcerchio);
		}else if(tris.getCella(1, 0)==2) {
			this.getButton_1Client().setIcon(imgcroce);
		}
		if(tris.getCella(2, 0)==1) {
			this.getButton_2Client().setIcon(imgcerchio);
		}else if(tris.getCella(2, 0)==2) {
			this.getButton_2Client().setIcon(imgcroce);
		}
		if(tris.getCella(0, 1)==1) {
			this.getButton_3Client().setIcon(imgcerchio);
		}else if(tris.getCella(0, 1)==2) {
			this.getButton_3Client().setIcon(imgcroce);
		}
		if(tris.getCella(1, 1)==1) {
			this.getButton_4Client().setIcon(imgcerchio);
		}else if(tris.getCella(1, 1)==2) {
			this.getButton_4Client().setIcon(imgcroce);
		}
		if(tris.getCella(2, 1)==1) {
			this.getButton_5Client().setIcon(imgcerchio);
		}else if(tris.getCella(2, 1)==2) {
			this.getButton_5Client().setIcon(imgcroce);
		}
		if(tris.getCella(0, 2)==1) {
			this.getButton_6Client().setIcon(imgcerchio);
		}else if(tris.getCella(0, 2)==2) {
			this.getButton_6Client().setIcon(imgcroce);
		}
		if(tris.getCella(1, 2)==1) {
			this.getButton_7Client().setIcon(imgcerchio);
		}else if(tris.getCella(1, 2)==2) {
			this.getButton_7Client().setIcon(imgcroce);
		}
		if(tris.getCella(2, 2)==1) {
			this.getButton_8Client().setIcon(imgcerchio);
		}else if(tris.getCella(2, 2)==2) {
			this.getButton_8Client().setIcon(imgcroce);
		}

		if(tris.getCella(0, 0)==0)
			this.getButtonClient().setEnabled(true);
		if(tris.getCella(1, 0)==0)
			this.getButton_1Client().setEnabled(true);
		if(tris.getCella(2, 0)==0)
			this.getButton_2Client().setEnabled(true);
		if(tris.getCella(0, 1)==0)
			this.getButton_3Client().setEnabled(true);
		if(tris.getCella(1, 1)==0)
			this.getButton_4Client().setEnabled(true);
		if(tris.getCella(2, 1)==0)
			this.getButton_5Client().setEnabled(true);
		if(tris.getCella(0, 2)==0)
			this.getButton_6Client().setEnabled(true);
		if(tris.getCella(1, 2)==0)
			this.getButton_7Client().setEnabled(true);
		if(tris.getCella(2, 2)==0)
			this.getButton_8Client().setEnabled(true);
	}

	/**
	 * Il metodo reimposta le celle del tris del Player 2
	 */
	public void resettaCelleClient() {
		this.getButtonClient().setIcon(null);
		this.getButton_1Client().setIcon(null);
		this.getButton_2Client().setIcon(null);
		this.getButton_3Client().setIcon(null);
		this.getButton_4Client().setIcon(null);
		this.getButton_5Client().setIcon(null);
		this.getButton_6Client().setIcon(null);
		this.getButton_7Client().setIcon(null);
		this.getButton_8Client().setIcon(null);
	}
}
