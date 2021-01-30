package Model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.concurrent.Semaphore;

public class RiceviPacchetto implements Runnable{
	private Object pacchetto;
	private Socket socket;
	private Semaphore s;
	private Player c;
	
	public RiceviPacchetto(Socket socket, Player c, Semaphore s) {
		super();
		this.socket = socket;
		this.c=c;
		this.pacchetto=new Casella(-1, -1);
		this.s=s;
	}
	
	
	
	public Object getPacchetto() {
		return pacchetto;
	}



	public void setPacchetto(Object pacchetto) {
		this.pacchetto = pacchetto;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		ObjectInputStream streamPacchettoIn;
		try {
			streamPacchettoIn = new ObjectInputStream(socket.getInputStream());
			pacchetto= streamPacchettoIn.readObject();
			System.out.println("ho ricevuto "+pacchetto);
			c.risposta((Casella)pacchetto);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
