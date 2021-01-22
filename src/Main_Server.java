import java.util.concurrent.Semaphore;

import Control.Controller_Server;
import Model.Server_P1;
import View.Finestra_Server;

public class Main_Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Finestra_Server f= new Finestra_Server();
		f.setVisible(true);
		Semaphore s= new Semaphore(0);
		Server_P1 c = new Server_P1(f,s);
	}

}
