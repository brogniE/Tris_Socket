package Model;

import java.io.Serializable;
/**
 * La classe rappresenta il pacchetto di avvio con il quale i Player si scambiano le informazioni riguardanti le informazioni sul nome e il numero di turni
 */
public class Pacchetto_Avvio implements Serializable{
	private String nome;
	private int turni;
	/**
	 * @param nome nome del giocatore che ha inviato il pacchetto
	 * @param turni numero di turni totali
	 */
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
