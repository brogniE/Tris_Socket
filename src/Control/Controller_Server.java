package Control;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import Model.Casella;
import Model.Server_P1;
import Model.Tris;
import View.Finestra_Menu;
/**
 * La classe gestisce gli eventi dei pannelli della finestra grafica relativi al Player 1
 */
public class Controller_Server implements ActionListener{

	private Finestra_Menu f;
	private Server_P1 s;
	private ImageIcon imgcerchio= new ImageIcon("src/img/cerchio.png");
	private Controller_Menu ctm;

	public Controller_Server(Finestra_Menu f, Server_P1 s, Controller_Menu ctm) {
		super();
		this.ctm=ctm;
		this.f = f;
		this.s = s;
		f.getButtonServer().addActionListener(this);
		f.getButton_1Server().addActionListener(this);
		f.getButton_2Server().addActionListener(this);
		f.getButton_3Server().addActionListener(this);
		f.getButton_4Server().addActionListener(this);
		f.getButton_5Server().addActionListener(this);
		f.getButton_6Server().addActionListener(this);
		f.getButton_7Server().addActionListener(this);
		f.getButton_8Server().addActionListener(this);
		f.getBtnAvviaTris().addActionListener(this);
		f.getBtnIndietro1().addActionListener(this);
		f.getBtnOkServer().addActionListener(this);
		f.getBtnOkClient().addActionListener(this);
	}


	public Controller_Menu getCtm() {
		return ctm;
	}

	public void setCtm(Controller_Menu ctm) {
		this.ctm = ctm;
	}

	public Server_P1 getS() {
		return s;
	}

	public void setS(Server_P1 s) {
		this.s = s;
	}


	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Casella casella;
		if(e.getSource()==f.getButtonServer()) {
			casella=new Casella(0, 0);
			this.avvioCasella(f.getButtonServer(), casella);
		}

		if(e.getSource()==f.getButton_1Server()) {
			casella=new Casella(1, 0);
			this.avvioCasella(f.getButton_1Server(), casella);
		}

		if(e.getSource()==f.getButton_2Server()) {
			casella=new Casella(2, 0);
			this.avvioCasella(f.getButton_2Server(), casella);
		}

		if(e.getSource()==f.getButton_3Server()) {
			casella=new Casella(0, 1);
			this.avvioCasella(f.getButton_3Server(), casella);
		}

		if(e.getSource()==f.getButton_4Server()) {
			casella=new Casella(1, 1);
			this.avvioCasella(f.getButton_4Server(), casella);
		}

		if(e.getSource()==f.getButton_5Server()) {
			casella=new Casella(2, 1);
			this.avvioCasella(f.getButton_5Server(), casella);
		}

		if(e.getSource()==f.getButton_6Server()) {
			casella=new Casella(0, 2);
			this.avvioCasella(f.getButton_6Server(), casella);
		}

		if(e.getSource()==f.getButton_7Server()) {
			casella=new Casella(1, 2);
			this.avvioCasella(f.getButton_7Server(), casella);
		}

		if(e.getSource()==f.getButton_8Server()) {
			casella=new Casella(2, 2);
			this.avvioCasella(f.getButton_8Server(), casella);
		}

		if(e.getSource()==f.getBtnIndietro1()) {
			f.getPanelStartServer().setVisible(false);
			f.getPanelMenu().setVisible(true);
		}

		if(e.getSource()==f.getBtnAvviaTris()) {
			if(f.getTextField().getText().compareTo("")==0) {
				JOptionPane.showMessageDialog(null, "nome non inserito", "errore", 3);
				return;
			}else {
				s.setNome(f.getTextField().getText());
				try {
					f.getLblLocalhost().setText(InetAddress.getLocalHost().getHostAddress());
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				s.setTurni(Integer.parseInt((String)f.getComboBox().getSelectedItem()));
				f.getPanelMenu().setVisible(false);
				f.getPanelServerWait().setVisible(true);
				f.getPanelServerPlay().setVisible(false);
				f.getPanelStartServer().setVisible(false);
				Thread t = new Thread(s);
				t.start();
			}
		}

		if(e.getSource()==f.getBtnOkServer()) {
			f.getPanelResultServer().setVisible(false);
			f.getPanelMenu().setVisible(true);
			ctm.setCts(this);
			s.chiudiConnessione();
		}

	}
	/**
	 * Il metodo effettua il cambio dei pannelli successivo alla corretta conessione dei giocatori
	 */
	public void AvvioPartita() {
		f.getPanelMenu().setVisible(false);
		f.getPanelServerWait().setVisible(false);
		f.getPanelServerPlay().setVisible(false);
		f.getPanelStartServer().setVisible(true);
	}
	/**
	 * Il metodo effettua il cambio dei pannelli successivi allo scambio del pacchetto di avvio tra i due giocatori
	 */
	public void avviaGioco() {
		f.getPanelMenu().setVisible(false);
		f.getPanelServerWait().setVisible(false);
		f.getPanelServerPlay().setVisible(true);
		f.getPanelStartServer().setVisible(false);
		f.getLblTurniTotaliServer().setText("Turni totali : "+s.getTurni());
		aggiornaLbl();
		f.resettaCelleServer();
		f.attivaCaselleServer(s.getTris());
	}
	/**
	 * Il metodo avvia le operazioni successive alla pressione di una cella del tris
	 * @param b bottone premuto
	 * @param c casella selezionata
	 */
	public void avvioCasella(JButton b, Casella c) {
		s.getTris().addSegno(1, c);
		b.setIcon(imgcerchio);
		s.inviaCasella(c);
		f.bloccaCaselleServer();
		int v=s.getTris().ControllaVincitore();
		if(v==0) {
			s.riceviCasella();
		}else
			terminaPartita(v);
	}
	/**
	 * Il metodo effettu le operazioni successive al termine della partita
	 * @param v probabili vincitore
	 */
	public void terminaPartita(int v) {

		if(v==1) {
			JOptionPane.showMessageDialog(f, "HAI VINTO");
			s.setVittorieP1(s.getVittorieP1()+1);
		}else if(v==2) {
			JOptionPane.showMessageDialog(f, "HAI PERSO");
			s.setVittorieP2(s.getVittorieP2()+1);

		}else if(v==3) {
			JOptionPane.showMessageDialog(f, "HAI PAREGGIATO");
		}
		if(s.getTurni()==1) {
			f.getPanelServerPlay().setVisible(false);
			f.getPanelResultServer().setVisible(true);

			if(s.getVittorieP1()>s.getVittorieP2()) {
				f.getLabelResultServer().setText("HAI VINTO!");
			} else if(s.getVittorieP2()>s.getVittorieP1()) {
				f.getLabelResultServer().setText("HAI PERSO!");
			} else if(s.getVittorieP1()==s.getVittorieP2()) {
				f.getLabelResultServer().setText("PAREGGIO!");
			}

		}else {
			s.setTurni(s.getTurni()-1);
			f.resettaCelleServer();
			s.getTris().azzera();
			s.riceviCasella();
		}
		aggiornaLbl();

	}

	/**
	 * Il metodo aggiorna le etichette riguardanti i turni e le vittorie dei Player
	 */
	public void aggiornaLbl() {
		f.getLblTurniRimanentiServer().setText("Turni rimanenti : "+(s.getTurni()-1));
		f.getLblVittorieP1Server().setText("Vittorie "+s.getNome()+" : "+s.getVittorieP1());
		f.getLblVittorieP2Server().setText("Vittorie "+s.getNomeAvversario()+" : "+s.getVittorieP2());
	}

}
