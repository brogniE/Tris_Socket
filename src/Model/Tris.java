package Model;

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
	
	public int ControllaVincitore() {
		int vincitore = 0;
		int flag = 0;
		int x = 0;
		int y = 0;

		while(y<3 && flag==0) {
			if(tris[0][y]==tris[1][y] && tris[1][y]==tris[2][y]) {
				vincitore = tris[0][y];
				flag = 1;
			}
			else {
				y++;
			}
		}

		while(x<3 && flag==0) {
			if(tris[x][0]==tris[x][1] && tris[x][1]==tris[x][2]) {
				vincitore = tris[x][0];
				flag = 1;
			}
			else {
				x++;
			}
		}

		if(tris[0][0]==tris[1][1] && tris[1][1]==tris[2][2] && flag==0) {
			vincitore = tris[0][0];
		}

		if(tris[0][2]==tris[1][1] && tris[1][1]==tris[2][0] && flag==0) {
			vincitore = tris[0][2];
		}

		return vincitore;
	}
	public int getCella(int x, int y) {
		return tris[x][y];
	}
	
	public void addSegno(int player, Casella c) {
		tris[c.getX()][c.getY()]=player;
		for(int i=0; i<3;i++) {
			for(int j=0;j<3;j++)
				System.out.println(tris[i][j]);
		}
	
	}
}
