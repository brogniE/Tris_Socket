package Model;
import java.util.concurrent.Semaphore;

import Model.Client_P2;
import View.Finestra_Client;

public class Avvio_Client {

	public Avvio_Client() {
		Finestra_Client f= new Finestra_Client();
		f.setVisible(true);
		Semaphore s= new Semaphore(0);
		Client_P2 c = new Client_P2(f, s);
	}
}
