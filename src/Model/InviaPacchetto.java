package Model;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.concurrent.Semaphore;

public class InviaPacchetto implements Runnable{
	private Object pacchetto;
	private Socket socket;
	private Semaphore s;
	public InviaPacchetto(Object pacchetto, Socket socket, Semaphore s) {
		super();
		this.pacchetto = pacchetto;
		this.socket = socket;
		this.s=s;
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
			e.printStackTrace();
		}
	}
}
