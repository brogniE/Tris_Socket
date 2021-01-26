package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import Model.Avvio_Client;
import Model.Avvio_Server;
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
			Avvio_Server m=new Avvio_Server();
			//f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
			f.setVisible(false);
		}
		if(e.getSource()==f.getBtnNewButton_1()) {
			Avvio_Client m=new Avvio_Client();
			//f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
			f.setVisible(false);
		}
		
	}
	
	
}
