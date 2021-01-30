import java.util.concurrent.Semaphore;

import Control.Controller_Client;
import Model.Client_P2;
import View.Finestra_Client;

public class Main_Client {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Finestra_Client f= new Finestra_Client();
		f.setVisible(true);
		Semaphore s= new Semaphore(0);
		Client_P2 c = new Client_P2(f, s);
	}
}
