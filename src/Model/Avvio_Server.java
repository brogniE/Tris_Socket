package Model;
import java.util.concurrent.Semaphore;

import Model.Server_P1;
import View.Finestra_Server;

public class Avvio_Server {
	
	public Avvio_Server() {
		Finestra_Server f= new Finestra_Server();
		f.setVisible(true);
		Semaphore s= new Semaphore(0);
		Server_P1 c = new Server_P1(f,s);
	}
}
