package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Semaphore;

import Model.Casella;
import Model.Client_P2;
import Model.Tris;
import View.Finestra_Client;

public class Controller_Client implements ActionListener{

	private Finestra_Client f;
	private Client_P2 c;
	
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
			c.getTris().addSegno(2, casella);
			f.getButton().setText("2");
			c.inviaCasella(casella);
			f.bloccaCaselle();
			c.riceviCasella();
		}
		if(e.getSource()==f.getButton_1()) {
			casella=new Casella(1, 0);
			c.getTris().addSegno(2, casella);
			f.getButton_1().setText("2");
			c.inviaCasella(casella);
			f.bloccaCaselle();
			c.riceviCasella();
		}
		if(e.getSource()==f.getButton_2()) {
			casella=new Casella(2, 0);
			c.getTris().addSegno(2, casella);
			f.getButton_2().setText("2");
			c.inviaCasella(casella);
			f.bloccaCaselle();
			c.riceviCasella();
		}
		if(e.getSource()==f.getButton_3()) {
			casella=new Casella(0, 1);
			c.getTris().addSegno(2, casella);
			f.getButton_3().setText("2");
			c.inviaCasella(casella);
			f.bloccaCaselle();
			c.riceviCasella();
		}
		if(e.getSource()==f.getButton_4()) {
			casella=new Casella(1, 1);
			c.getTris().addSegno(2, casella);
			f.getButton_4().setText("2");
			c.inviaCasella(casella);
			f.bloccaCaselle();
			c.riceviCasella();
		}
		if(e.getSource()==f.getButton_5()) {
			casella=new Casella(2, 1);
			c.getTris().addSegno(2, casella);
			f.getButton_5().setText("2");
			c.inviaCasella(casella);
			f.bloccaCaselle();
			c.riceviCasella();
		}
		if(e.getSource()==f.getButton_6()) {
			casella=new Casella(0, 2);
			c.getTris().addSegno(2, casella);
			f.getButton_6().setText("2");
			c.inviaCasella(casella);
			f.bloccaCaselle();
			c.riceviCasella();
		}
		if(e.getSource()==f.getButton_7()) {
			casella=new Casella(1, 2);
			c.getTris().addSegno(2, casella);
			f.getButton_7().setText("2");
			c.inviaCasella(casella);
			f.bloccaCaselle();
			c.riceviCasella();
		}
		if(e.getSource()==f.getButton_8()) {
			casella=new Casella(2, 2);
			c.getTris().addSegno(2, casella);
			f.getButton_8().setText("2");
			c.inviaCasella(casella);
			f.bloccaCaselle();
			c.riceviCasella();
		}
	}

}
