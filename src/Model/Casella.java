package Model;

import java.io.Serializable;
/**
 * La classe Casellla rappresenta un'oggetto equivalente ad una cella della tabella del gioco tris e viene utilizzata come messaggio che i due Player si scambiano
 * **/
public class Casella implements Serializable{
	private int x;
	private int y;
	/**
	 * @param x indice della colonna selezionata dall'utente
	 * @param y indice della riga selezionata dall'utente
	 */
	public Casella(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Casella [x=" + x + ", y=" + y + "]";
	}

	
	
	
}
