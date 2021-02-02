package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.concurrent.Semaphore;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;


import Model.Casella;
import Model.Client_P2;
import Model.Tris;
import View.Finestra_Menu;
/**
 * La classe gestisce gli eventi dei pannelli della finestra grafica relativi al Player 2
 */
public class Controller_Client implements ActionListener{

	private Finestra_Menu f;
	private Client_P2 c;
	private ImageIcon imgcroce= new ImageIcon("src/img/croce.png");
	private Controller_Menu ctm;

	public Controller_Client(Finestra_Menu f, Client_P2 c, Controller_Menu ctm) {
		super();
		this.ctm=ctm;
		this.f = f;
		this.c = c;
		f.getBtnGioca().addActionListener(this);
		f.getButtonClient().addActionListener(this);
		f.getButton_1Client().addActionListener(this);
		f.getButton_2Client().addActionListener(this);
		f.getButton_3Client().addActionListener(this);
		f.getButton_4Client().addActionListener(this);
		f.getButton_5Client().addActionListener(this);
		f.getButton_6Client().addActionListener(this);
		f.getButton_7Client().addActionListener(this);
		f.getButton_8Client().addActionListener(this);
		f.getBtnIndietro3().addActionListener(this);
		f.getBtnOkServer().addActionListener(this);
		f.getBtnOkClient().addActionListener(this);
	}

	public Controller_Menu getCtm() {
		return ctm;
	}

	public void setCtm(Controller_Menu ctm) {
		this.ctm = ctm;
	}

	public Client_P2 getC() {
		return c;
	}

	public void setC(Client_P2 c) {
		this.c = c;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Casella casella;
		if(e.getSource()==f.getBtnGioca()) {
			if(f.getTextField_2().getText().compareTo("")==0) {
				JOptionPane.showMessageDialog(null, "nome non inserito", "errore", 3);
				return;
			}else {
				c.setIpServer(f.getTextField_1().getText());
				c.setNome(f.getTextField_2().getText());
				Thread t = new Thread(c);
				t.start();
				f.getPanelMenu().setVisible(false);
				f.getPanelClientJoin().setVisible(false);
				f.getPanelClientPlay().setVisible(true);
				f.bloccaCaselleClient();
				c.riceviCasella();
			}
		}

		if(e.getSource()==f.getButtonClient()) {
			casella=new Casella(0, 0);
			this.avvioCasella(f.getButtonClient(), casella);
		}

		if(e.getSource()==f.getButton_1Client()) {
			casella=new Casella(1, 0);
			this.avvioCasella(f.getButton_1Client(), casella);
		}

		if(e.getSource()==f.getButton_2Client()) {
			casella=new Casella(2, 0);
			this.avvioCasella(f.getButton_2Client(), casella);
		}

		if(e.getSource()==f.getButton_3Client()) {
			casella=new Casella(0, 1);
			this.avvioCasella(f.getButton_3Client(), casella);
		}

		if(e.getSource()==f.getButton_4Client()) {
			casella=new Casella(1, 1);
			this.avvioCasella(f.getButton_4Client(), casella);
		}

		if(e.getSource()==f.getButton_5Client()) {
			casella=new Casella(2, 1);
			this.avvioCasella(f.getButton_5Client(), casella);
		}

		if(e.getSource()==f.getButton_6Client()) {
			casella=new Casella(0, 2);
			this.avvioCasella(f.getButton_6Client(), casella);
		}

		if(e.getSource()==f.getButton_7Client()) {
			casella=new Casella(1, 2);
			this.avvioCasella(f.getButton_7Client(), casella);
		}

		if(e.getSource()==f.getButton_8Client()) {
			casella=new Casella(2, 2);
			this.avvioCasella(f.getButton_8Client(), casella);
		}

		if(e.getSource()==f.getBtnIndietro3()) {
			f.getPanelClientJoin().setVisible(false);
			f.getPanelMenu().setVisible(true);
		}

		if(e.getSource()==f.getBtnOkClient()) {
			f.getPanelResultClient().setVisible(false);
			f.getPanelMenu().setVisible(true);

		}
	}
	/**
	 * Il metodo avvia le operazioni successive alla pressione di una cella del tris
	 * @param b bottone premuto
	 * @param cs casella selezionata
	 */
	public void avvioCasella(JButton b, Casella cs) {
		c.getTris().addSegno(2, cs);
		b.setIcon(imgcroce);
		c.inviaCasella(cs);
		f.bloccaCaselleClient();
		int v=c.getTris().ControllaVincitore();
		if(v==0) {
			c.riceviCasella();
		}else
			terminaPartita(v);
	}
	/**
	 * Il metodo effettua le operazioni successive al termine della partita
	 * @param v probabile vincitore
	 */
	public void terminaPartita(int v) {

		if(v==2) {
			JOptionPane.showMessageDialog(f, "HAI VINTO");
			c.setVittorieP2(c.getVittorieP2()+1);
		}else if(v==1) {
			JOptionPane.showMessageDialog(f, "HAI PERSO");
			c.setVittorieP1(c.getVittorieP1()+1);
		}else if(v==3) {
			JOptionPane.showMessageDialog(f, "HAI PAREGGIATO");
		}
		aggiornaLbl();
		if(c.getTurni()==1) {
			f.getPanelClientPlay().setVisible(false);
			f.getPanelResultClient().setVisible(true);

			if(c.getVittorieP1()>c.getVittorieP2()) {
				f.getLabelResultClient().setText("HAI PERSO!");
			} else if(c.getVittorieP2()>c.getVittorieP1()) {
				f.getLabelResultClient().setText("HAI VINTO!");
			} else if(c.getVittorieP1()==c.getVittorieP2()) {
				f.getLabelResultClient().setText("PAREGGIO!");
			}
			ctm.setCtc(this);
			c.chiudiConnessione();

		}else {
			c.setTurni(c.getTurni()-1);
			f.resettaCelleClient();
			c.getTris().azzera();
			c.riceviCasella();
		}

	}

	/**
	 * Il metodo aggiorna le etichette riguardanti i turni e le vittorie dei Player
	 */
	public void aggiornaLbl() {
		f.getLblTurniRimanentiClient().setText("Turni rimanenti : "+(c.getTurni()-1));
		f.getLblVittorieP2Client().setText("Vittorie "+c.getNome()+" : "+c.getVittorieP2());
		f.getLblVittorieP1Client().setText("Vittorie "+c.getNomeAvversario()+" : "+c.getVittorieP1());
	}

}
