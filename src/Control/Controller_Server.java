package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Casella;
import Model.Server_P1;
import Model.Tris;
import View.Finestra_Server;

public class Controller_Server implements ActionListener{

	private Finestra_Server f;
	private Server_P1 s;
	
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
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Casella casella;
		if(e.getSource()==f.getButton()) {
			casella=new Casella(0, 0);
			s.getTris().addSegno(1, casella);
			f.getButton().setText("1");
			s.inviaCasella(casella);
			f.bloccaCaselle();
			s.riceviCasella();
		}
		if(e.getSource()==f.getButton_1()) {
			casella=new Casella(1, 0);
			s.getTris().addSegno(1, casella);
			f.getButton_1().setText("1");
			s.inviaCasella(casella);
			f.bloccaCaselle();
			s.riceviCasella();
		}
		if(e.getSource()==f.getButton_2()) {
			casella=new Casella(2, 0);
			s.getTris().addSegno(1, casella);
			f.getButton_2().setText("1");
			s.inviaCasella(casella);
			f.bloccaCaselle();
			s.riceviCasella();
		}
		if(e.getSource()==f.getButton_3()) {
			casella=new Casella(0, 1);
			s.getTris().addSegno(1, casella);
			f.getButton_3().setText("1");
			s.inviaCasella(casella);
			f.bloccaCaselle();
			s.riceviCasella();
		}
		if(e.getSource()==f.getButton_4()) {
			casella=new Casella(1, 1);
			s.getTris().addSegno(1, casella);
			f.getButton_4().setText("1");
			s.inviaCasella(casella);
			f.bloccaCaselle();
			s.riceviCasella();
		}
		if(e.getSource()==f.getButton_5()) {
			casella=new Casella(2, 1);
			s.getTris().addSegno(1, casella);
			f.getButton_5().setText("1");
			s.inviaCasella(casella);
			f.bloccaCaselle();
			s.riceviCasella();
		}
		if(e.getSource()==f.getButton_6()) {
			casella=new Casella(0, 2);
			s.getTris().addSegno(1, casella);
			f.getButton_6().setText("1");
			s.inviaCasella(casella);
			f.bloccaCaselle();
			s.riceviCasella();
		}
		if(e.getSource()==f.getButton_7()) {
			casella=new Casella(1, 2);
			s.getTris().addSegno(1, casella);
			f.getButton_7().setText("1");
			s.inviaCasella(casella);
			f.bloccaCaselle();
			s.riceviCasella();
		}
		if(e.getSource()==f.getButton_8()) {
			casella=new Casella(2, 2);
			s.getTris().addSegno(1, casella);
			f.getButton_8().setText("1");
			s.inviaCasella(casella);
			f.bloccaCaselle();
			s.riceviCasella();
		}
		
	}
	
	public void AvvioPartita() {
		f.getPanel().setVisible(false);
		f.getPanel_1().setVisible(true);
	}
	
}
