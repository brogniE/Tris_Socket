package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.concurrent.Semaphore;

import javax.swing.JFrame;

import Model.Client_P2;
import Model.Server_P1;
import View.Finestra_Menu;
/**
 * La classe gestisce gli eventi dei pannelli della finestra grafica relativi al menù
 */
public class Controller_Menu implements ActionListener{
	private Finestra_Menu f;
	private int colore;
	private Controller_Server cts;
	private Controller_Client ctc;

	public Controller_Menu(Finestra_Menu f) {
		super();
		this.f = f;
		colore=0;
		f.getBtnNewButton().addActionListener(this);
		f.getBtnNewButton_1().addActionListener(this);
		f.getBtnImpostazioni().addActionListener(this);
		cts=null;
		ctc=null;
	}

	public Controller_Server getCts() {
		return cts;
	}

	public void setCts(Controller_Server cts) {
		this.cts = cts;
	}

	public Controller_Client getCtc() {
		return ctc;
	}

	public void setCtc(Controller_Client ctc) {
		this.ctc = ctc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==f.getBtnNewButton()) {
			Semaphore semaforoServer = new Semaphore(0);
			Server_P1 server;
			if(cts==null)
				server = new Server_P1(f, semaforoServer, this);
			else
				server = new Server_P1(f, semaforoServer, cts);
		}
		if(e.getSource()==f.getBtnNewButton_1()) {
			f.getPanelMenu().setVisible(false);
			f.getPanelClientJoin().setVisible(true);

			Semaphore semaforoClient = new Semaphore(0);
			Client_P2 client;
			if(ctc==null)
				client = new Client_P2(f, semaforoClient, this);
			else
				client = new  Client_P2(f, semaforoClient, ctc);

		}

		if(e.getSource()==f.getBtnImpostazioni()) {
			f.dispose();
			colore=(colore+1)%2;
			f=new Finestra_Menu(colore);
			f.setVisible(true);
			f.getBtnNewButton().addActionListener(this);
			f.getBtnNewButton_1().addActionListener(this);
			f.getBtnImpostazioni().addActionListener(this);
		}

	}


}
