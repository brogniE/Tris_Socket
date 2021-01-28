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
import View.Finestra_Menu;

public class Client_P2 implements Runnable, Player{
	private String ipServer;
	private Socket socket;
	private Finestra_Menu f;
	private Tris tris;
	private Semaphore s;
	private Controller_Client ct;

	private String nome;
	private String nomeAvversario;
	private int turni;

	private int vittorieP1=0;
	private int vittorieP2=0;

	public Client_P2(Finestra_Menu f, Semaphore s) {
		super();
		this.f=f;
		ct = new Controller_Client(f, this);
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

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Casella c;
		try {
			socket =new Socket(ipServer, 9999);

			Pacchetto_Avvio pacchetto= new Pacchetto_Avvio(this.nome);

			try {
				ObjectInputStream streamPacchettoIn = new ObjectInputStream(socket.getInputStream());
				pacchetto= (Pacchetto_Avvio)streamPacchettoIn.readObject();
				this.nomeAvversario=pacchetto.getNome();
				this.turni=pacchetto.getTurni();

				pacchetto=new Pacchetto_Avvio(nome);
				ObjectOutputStream streamPacchettoOut = new ObjectOutputStream(socket.getOutputStream());
				streamPacchettoOut.writeObject(pacchetto);

				f.getLblTurniTotaliClient().setText("Turni totali : "+turni);
				ct.aggiornaLbl();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

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
		if(v==0)
			f.attivaCaselleClient(this.tris);
		else
			terminaPartita(v);
	}

	public void terminaPartita(int v) {

		if(v==2) {
			JOptionPane.showMessageDialog(f, "HAI VINTO");
			vittorieP2++;
		}else if(v==1) {
			JOptionPane.showMessageDialog(f, "HAI PERSO");
			vittorieP1++;
		}else if(v==3) {
			JOptionPane.showMessageDialog(f, "HAI PAREGGIATO");
		}
		if(turni==1) {
			f.getPanelClientPlay().setVisible(false);
			f.getPanelMenu().setVisible(true);
			chiudiConnessione();
			f.attivaCaselleClient(this.tris);
		}else {
			turni--;
			f.resettaCelleClient();
			tris.azzera();
			f.attivaCaselleClient(this.tris);
		}
		ct.aggiornaLbl();

	}

}
