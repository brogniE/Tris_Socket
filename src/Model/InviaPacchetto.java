package Model;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.concurrent.Semaphore;
/**
 * La classe ha il compito di effettuare l'invio di un qualunque pacchetto all'avversario
 */
public class InviaPacchetto implements Runnable{
	private Object pacchetto;
	private Socket socket;
	private Semaphore s;
	private Player c;
	/**
	 * @param pacchetto oggetto da inviare
	 * @param socket socket su cui effettuare l'invio del pacchetto
	 * @param c il player che vuole inviare tale pacchetto
	 * @param s	il semaforo per mettere in mutua esclusione il socket e sincronizzare l'invio e la ricezione
	 */
	public InviaPacchetto(Object pacchetto, Socket socket, Semaphore s, Player c) {
		super();
		this.pacchetto = pacchetto;
		this.socket = socket;
		this.s=s;
		this.c=c;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		ObjectOutputStream streamPacchettoOut;
		try {
			streamPacchettoOut = new ObjectOutputStream(socket.getOutputStream());
			streamPacchettoOut.writeObject(pacchetto);
			System.out.println("ho invito"+pacchetto);
			s.release();
			//streamPacchettoOut.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			c.erroreConnessione();
			e.printStackTrace();
		}
	}
}
