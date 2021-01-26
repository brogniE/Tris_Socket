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
		System.out.println("si");
		if(v==1) {
			System.out.println("hai perso");
			JOptionPane.showMessageDialog(f, "HAI PERSO");
			//f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
			f.setVisible(false);
			System.out.println("chiudo finestra");
			Avvio_Menu m= new Avvio_Menu();
			c.chiudiConnessione();
		}else if(v==2) {
			System.out.println("hai vinto");
			JOptionPane.showMessageDialog(f, "HAI VINTO");
			//f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
			f.setVisible(false);
			System.out.println("chiudo finestra");
			Avvio_Menu m= new Avvio_Menu();
			c.chiudiConnessione();
		}else if(v==3) {
			System.out.println("pareggioa");
			JOptionPane.showMessageDialog(f, "HAI PAREGGIATO");
			//f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
			f.setVisible(false);
			System.out.println("chiudo finestra");
			Avvio_Menu m= new Avvio_Menu();
			c.chiudiConnessione();
		}else if(v==0) {
			c.riceviCasella();
		}
	}

}
