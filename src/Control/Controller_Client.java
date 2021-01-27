package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.concurrent.Semaphore;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import Model.Avvio_Menu;
import Model.Casella;
import Model.Client_P2;
import Model.Tris;
import View.Finestra_Client;

public class Controller_Client implements ActionListener{

	private Finestra_Client f;
	private Client_P2 c;
	private ImageIcon imgcroce= new ImageIcon("src/img/croce.png");
	
	public Controller_Client(Finestra_Client f, Client_P2 c) {
		super();
		this.f = f;
		this.c = c;
		f.getBtnGioca().addActionListener(this);
		f.getButton().addActionListener(this);
		f.getButton_1().addActionListener(this);
		f.getButton_2().addActionListener(this);
		f.getButton_3().addActionListener(this);
		f.getButton_4().addActionListener(this);
		f.getButton_5().addActionListener(this);
		f.getButton_6().addActionListener(this);
		f.getButton_7().addActionListener(this);
		f.getButton_8().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Casella casella;
		if(e.getSource()==f.getBtnGioca()) {
			c.setIpServer(f.getTextField().getText());
			c.setNome(f.getTextField_1().getText());
			Thread t = new Thread(c);
			t.start();
			f.getPanel().setVisible(false);
			f.getPanel_1().setVisible(true);
			f.bloccaCaselle();
			c.riceviCasella();
		}
				
		if(e.getSource()==f.getButton()) {
			casella=new Casella(0, 0);
			this.avvioCasella(f.getButton(), casella);
		}
		if(e.getSource()==f.getButton_1()) {
			casella=new Casella(1, 0);
			this.avvioCasella(f.getButton_1(), casella);
		}
		if(e.getSource()==f.getButton_2()) {
			casella=new Casella(2, 0);
			this.avvioCasella(f.getButton_2(), casella);
		}
		if(e.getSource()==f.getButton_3()) {
			casella=new Casella(0, 1);
			this.avvioCasella(f.getButton_3(), casella);
		}
		if(e.getSource()==f.getButton_4()) {
			casella=new Casella(1, 1);
			this.avvioCasella(f.getButton_4(), casella);
		}
		if(e.getSource()==f.getButton_5()) {
			casella=new Casella(2, 1);
			this.avvioCasella(f.getButton_5(), casella);
		}
		if(e.getSource()==f.getButton_6()) {
			casella=new Casella(0, 2);
			this.avvioCasella(f.getButton_6(), casella);
		}
		if(e.getSource()==f.getButton_7()) {
			casella=new Casella(1, 2);
			this.avvioCasella(f.getButton_7(), casella);
		}
		if(e.getSource()==f.getButton_8()) {
			casella=new Casella(2, 2);
			this.avvioCasella(f.getButton_8(), casella);
		}
	}
	
	public void avvioCasella(JButton b, Casella cs) {
		c.getTris().addSegno(2, cs);
		b.setIcon(imgcroce);
		c.inviaCasella(cs);
		f.bloccaCaselle();
		int v=c.getTris().ControllaVincitore();
		if(v==0) {
			c.riceviCasella();
		}else
			terminaPartita(v);
	}
	
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
			f.setVisible(false);
			Avvio_Menu m= new Avvio_Menu();
			c.chiudiConnessione();
		}else {
			c.setTurni(c.getTurni()-1);
			f.resettaCelle();
			c.getTris().azzera();
			c.riceviCasella();
		}
		
	}

	public void aggiornaLbl() {
		f.getLblTurniRimanenti().setText("Turni rimanenti : "+(c.getTurni()-1));
		f.getLblTurnoPlayer().setText("Vittorie "+c.getNome()+" : "+c.getVittorieP1());
		f.getLblVittorieP().setText("Vittorie "+c.getNomeAvversario()+" : "+c.getVittorieP2());
	}

}
