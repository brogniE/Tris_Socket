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
	private Finestra_Server f;
	private Socket socket;
	private Tris tris;
	private Semaphore s;
	private ServerSocket serverSocket;
	private Controller_Server ct;
	
	private String nome;
	private String nomeAvversario;
	private int turni;
	
	private int vittorieP1=0;
	private int vittorieP2=0;
	
	public Server_P1(Finestra_Server f, Semaphore s) {
		super();
		this.f=f;
		tris=new Tris();
		this.s=s;
		ct=new Controller_Server(f, this);
		ct.AvvioPartita();
	}
	
	public Tris getTris() {
		return tris;
	}

	public void setTris(Tris tris) {
		this.tris = tris;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeAvversario() {
		return nomeAvversario;
	}

	public void setNomeAvversario(String nomeAvversario) {
		this.nomeAvversario = nomeAvversario;
	}

	public int getTurni() {
		return turni;
	}

	public void setTurni(int turni) {
		this.turni = turni;
	}

	public int getVittorieP1() {
		return vittorieP1;
	}

	public void setVittorieP1(int vittorieP1) {
		this.vittorieP1 = vittorieP1;
	}

	public int getVittorieP2() {
		return vittorieP2;
	}

	public void setVittorieP2(int vittorieP2) {
		this.vittorieP2 = vittorieP2;
	}

	public void run() {
		
		Casella c;
		boolean connesso=true;
		
		try {
			serverSocket= new ServerSocket(9999);
			
			while(connesso) {
				
				this.socket= serverSocket.accept();
				Pacchetto_Avvio pacchetto= new Pacchetto_Avvio(this.nome, this.turni);
				
				try {
					ObjectOutputStream streamPacchettoOut = new ObjectOutputStream(socket.getOutputStream());
					streamPacchettoOut.writeObject(pacchetto);
					ObjectInputStream streamPacchettoIn = new ObjectInputStream(socket.getInputStream());
					pacchetto= (Pacchetto_Avvio)streamPacchettoIn.readObject();
					nomeAvversario=pacchetto.getNome();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				connesso=false;
				
				ct.avviaGioco();
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void chiudiConnessione() {
		try {
			socket.close();
			serverSocket.close();
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
		if(v==0)
			f.attivaCaselle(this.tris);
		else
			terminaPartita(v);
	}

	public void terminaPartita(int v) {
		
		if(v==1) {
			JOptionPane.showMessageDialog(f, "HAI VINTO");
			vittorieP1++;
		}else if(v==2) {
			JOptionPane.showMessageDialog(f, "HAI PERSO");
			vittorieP2++;
		}else if(v==3) {
			JOptionPane.showMessageDialog(f, "HAI PAREGGIATO");
		}
		if(turni==1) {
			f.setVisible(false);
			Avvio_Menu m= new Avvio_Menu();
			chiudiConnessione();
			f.attivaCaselle(this.tris);
		}else {
			turni--;
			f.resettaCelle();
			tris.azzera();
			f.attivaCaselle(this.tris);
		}
		ct.aggiornaLbl();
		
	}
	
}
