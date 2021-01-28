package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.concurrent.Semaphore;

import Model.Client_P2;
import Model.Server_P1;
import View.Finestra_Menu;

public class Controller_Menu implements ActionListener{
	private Finestra_Menu f;

	public Controller_Menu(Finestra_Menu f) {
		super();
		this.f = f;
		f.getBtnNewButton().addActionListener(this);
		f.getBtnNewButton_1().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==f.getBtnNewButton()) {
			Semaphore semaforoServer = new Semaphore(0);
			Server_P1 server = new Server_P1(f, semaforoServer);
		}
		if(e.getSource()==f.getBtnNewButton_1()) {
			f.getPanelMenu().setVisible(false);
			f.getPanelClientJoin().setVisible(true);

			Semaphore semaforoClient = new Semaphore(0);
			Client_P2 client = new Client_P2(f, semaforoClient);

		}

	}


}
