package Model;

import java.io.Serializable;

public class Pacchetto_Avvio implements Serializable{
	private String nome;
	private int turni;
	
	public Pacchetto_Avvio(String nome, int turni) {
		super();
		this.nome = nome;
		this.turni = turni;
	}
	
	public Pacchetto_Avvio(String nome) {
		super();
		this.nome = nome;
		this.turni = 0;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTurni() {
		return turni;
	}

	public void setTurni(int turni) {
		this.turni = turni;
	}
	
	
}
