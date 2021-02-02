package Model;

/**
 * La classe Tris rappresenta la tabella che compone il gioco del tris
 * **/

public class Tris {
	private int tris[][];

	public Tris() {
		super();
		this.tris = new int [3][3];
		for(int i=0; i<3;i++) {
			for(int j=0;j<3;j++)
				tris[i][j]=0;
		}
	}
	/**
	 * Il metodo effettua un controllo sulla tabella
	 * @return:
	 * 		0 nel caso in cui il gioco non sia ancora finito e nessuno abbia vinto,
	 * 		1 se il giocatore vincente è il Player 1,
	 * 		2 se il giocatore vincente è il Player 2,
	 * 		3 se il gioco � terminato ed è avvenutto un pareggio
	 * **/
	public int ControllaVincitore() {
		int vincitore = 0;
		int x = 0;
		int y = 0;

		while(y<3 && vincitore==0) {
			if(tris[0][y]==tris[1][y] && tris[1][y]==tris[2][y] && tris[0][y]!=0) {
				vincitore = tris[0][y];
			}
			else {
				y++;
			}
		}

		while(x<3 && vincitore==0) {
			if(tris[x][0]==tris[x][1] && tris[x][1]==tris[x][2] && tris[x][0]!=0) {
				vincitore = tris[x][0];
			}
			else {
				x++;
			}
		}

		if(tris[0][0]==tris[1][1] && tris[1][1]==tris[2][2] && vincitore==0 && tris[0][0]!=0) {
			vincitore = tris[0][0];
		}

		if(tris[0][2]==tris[1][1] && tris[1][1]==tris[2][0] && vincitore==0 && tris[2][0]!=0) {
			vincitore = tris[0][2];
		}
		if(vincitore==0) {
			vincitore = this.pareggio();
		}

		return vincitore;
	}

	public int getCella(int x, int y) {
		return tris[x][y];
	}
	/**
	 * Il metodo controlla se è avvenuto il pareggio
	 * @return 3 se è pareggio, 0 se non è pareggio
	 */
	public int pareggio() {
		int i = 0;
		int j = 0;
		int vincitore = 3;

		while(vincitore==3 && i<3) {
			j=0;
			while(vincitore==3 && j<3) {
				if(tris[i][j]==0) {
					vincitore = 0;
				}
				j++;
			}
			i++;
		}

		return vincitore;
	}


	public void addSegno(int player, Casella c) {
		tris[c.getX()][c.getY()]=player;
	}

	/**
	 * Il metodo riporta tutte le celle del tris a valore 0
	 */
	public void azzera() {
		for(int i=0; i<3;i++) {
			for(int j=0;j<3;j++)
				tris[i][j]=0;
		}

	}
}
