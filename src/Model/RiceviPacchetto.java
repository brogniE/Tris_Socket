package Model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.concurrent.Semaphore;
/**
 * La classe ha il compito di effettuare la ricezione di un qualunque pacchetto inviato dall'avversario
 */
public class RiceviPacchetto implements Runnable{
	private Object pacchetto;
	private Socket socket;
	private Semaphore s;
	private Player c;
	/**
	 * @param socket socket su cui effettuare la ricezione del pacchetto
	 * @param c il player che vuole ricevere tale pacchetto
	 * @param s	il semaforo per mettere in mutua esclusione il socket e sincronizzare l'invio e la ricezione
	 */
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
			c.erroreConnessione();
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
