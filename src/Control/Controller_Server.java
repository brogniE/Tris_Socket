package Control;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import Model.Avvio_Menu;
import Model.Casella;
import Model.Server_P1;
import Model.Tris;
import View.Finestra_Server;

public class Controller_Server implements ActionListener{

	private Finestra_Server f;
	private Server_P1 s;
	private ImageIcon imgcerchio= new ImageIcon("src/img/cerchio.png");
	
	public Controller_Server(Finestra_Server f, Server_P1 s) {
		super();
		this.f = f;
		this.s = s;
		f.getButton().addActionListener(this);
		f.getButton_1().addActionListener(this);
		f.getButton_2().addActionListener(this);
		f.getButton_3().addActionListener(this);
		f.getButton_4().addActionListener(this);
		f.getButton_5().addActionListener(this);
		f.getButton_6().addActionListener(this);
		f.getButton_7().addActionListener(this);
		f.getButton_8().addActionListener(this);
		
		f.getBtnAvviaTris().addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Casella casella;
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
		
		if(e.getSource()==f.getBtnAvviaTris()) {
			s.setNome(f.getTextField().getText());
			s.setTurni(Integer.parseInt((String)f.getComboBox().getSelectedItem()));
			f.getPanel().setVisible(true);
			f.getPanel_1().setVisible(false);
			f.getPanel_2().setVisible(false);
			Thread t = new Thread(s);
			t.start();
		}
		
	}
	
	public void AvvioPartita() {
		f.getPanel().setVisible(false);
		f.getPanel_1().setVisible(false);
		f.getPanel_2().setVisible(true);
	}
	
	public void avviaGioco() {
		f.getPanel().setVisible(false);
		f.getPanel_1().setVisible(true);
		f.getPanel_2().setVisible(false);
		f.getLblTurniTotali().setText("Turni totali : "+s.getTurni());
		aggiornaLbl();
	}
	
	
	public void avvioCasella(JButton b, Casella c) {
		s.getTris().addSegno(1, c);
		b.setIcon(imgcerchio);
		s.inviaCasella(c);
		f.bloccaCaselle();
		int v=s.getTris().ControllaVincitore();
		if(v==0) {
			s.riceviCasella();
		}else
			terminaPartita(v);
	}
	
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
			f.setVisible(false);
			Avvio_Menu m= new Avvio_Menu();
			s.chiudiConnessione();
		}else {
			s.setTurni(s.getTurni()-1);
			f.resettaCelle();
			s.getTris().azzera();
			s.riceviCasella();
		}
		aggiornaLbl();
		
	}
	
	public void aggiornaLbl() {
		f.getLblTurniRimanenti().setText("Turni rimanenti : "+(s.getTurni()-1));
		f.getLblTurnoPlayer().setText("Vittorie "+s.getNome()+" : "+s.getVittorieP1());
		f.getLblVittorieP().setText("Vittorie "+s.getNomeAvversario()+" : "+s.getVittorieP2());
	}
}
