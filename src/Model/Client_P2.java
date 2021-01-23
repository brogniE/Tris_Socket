package Model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.Semaphore;

import javax.swing.JOptionPane;

import Control.Controller_Client;
import View.Finestra_Client;

public class Client_P2 implements Runnable, Player{
	private String ipServer;
	private Socket socket;
	private Finestra_Client f;
	private Tris tris;
	private Semaphore s;
	
	public Client_P2(Finestra_Client f, Semaphore s) {
		super();
		this.f=f;
		Controller_Client ct = new Controller_Client(f, this);
		tris=new Tris();
		this.s=s;
	}

	public String getIpServer() {
		return ipServer;
	}

	public void setIpServer(String ipServer) {
		this.ipServer = ipServer;
	}

	public Tris getTris() {
		return tris;
	}

	public void setTris(Tris tris) {
		this.tris = tris;
	}

	public Semaphore getS() {
		return s;
	}

	public void setS(Semaphore s) {
		this.s = s;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub 
		Casella c;
		try {
			socket =new Socket(ipServer, 9999);
				s.release();
	
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}
	}
	
	public void inviaCasella(Casella c) {
		InviaPacchetto i= new InviaPacchetto(c, socket, s);
		Thread t= new Thread(i);
		t.start();
	}
	
	public void riceviCasella() {
		try {
			s.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RiceviPacchetto r=new RiceviPacchetto(socket, this, s);
		Thread t= new Thread(r);
		t.start();
	}
	
	public void chiudiConnessione() {
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void risposta(Casella c) {
		this.tris.addSegno(1, c);
		int v=tris.ControllaVincitore();
		if(v==2) {
			JOptionPane.showMessageDialog(f, "HAI VINTO");
		}else if(v==1) {
			JOptionPane.showMessageDialog(f, "HAI PERSO");
		}
		f.attivaCaselle(this.tris);
	}

}
