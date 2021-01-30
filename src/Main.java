import Control.Controller_Menu;
import View.Finestra_Menu;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Finestra_Menu f = new Finestra_Menu(0);
		f.setVisible(true);
		Controller_Menu m=new Controller_Menu(f);
	}

}
