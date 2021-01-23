package Model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Semaphore;

import javax.swing.JOptionPane;

import Control.Controller_Server;
import View.Finestra_Server;

public class Server_P1 implements Runnable, Player{
	private Thread t;
	private Finestra_Server f;
	private Socket socket;
	private Tris tris;
	private Semaphore s;
	
	public Server_P1(Finestra_Server f, Semaphore s) {
		super();
		this.f=f;
		tris=new Tris();
		t = new Thread(this);
		t.start();
		this.s=s;
	}
	
	public Tris getTris() {
		return tris;
	}

	public void setTris(Tris tris) {
		this.tris = tris;
	}

	public void run() {
		
		ServerSocket serverSocket;
		Casella c;
		boolean connesso=true;
		
		try {
			serverSocket= new ServerSocket(9999);
			
			while(connesso) {
				
				this.socket= serverSocket.accept();
				Controller_Server ct=new Controller_Server(f, this);
				connesso=false;
				ct.AvvioPartita();
				
				
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void chiudiConnessione() {
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void inviaCasella(Casella c) {
		InviaPacchetto i= new InviaPacchetto(c, socket, s);
		Thread t= new Thread(i);
		t.start();
	}
	
	public Casella riceviCasella() {
		try {
			s.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("provo a ricevere");
		RiceviPacchetto r=new RiceviPacchetto(socket, this, s);
		Thread t= new Thread(r);
		t.start();
		return (Casella)r.getPacchetto();
	}
	
	public void risposta(Casella c) {
		System.out.println("ho ricevuto");
		this.tris.addSegno(2, c);
		int v=tris.ControllaVincitore();
		if(v==1) {
			JOptionPane.showMessageDialog(f, "HAI VINTO");
		}else if(v==2) {
			JOptionPane.showMessageDialog(f, "HAI PERSO");
		}
		f.attivaCaselle(tris);
	}
}
