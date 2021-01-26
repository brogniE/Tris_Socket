package Model;

import Control.Controller_Menu;
import View.Finestra_Menu;

public class Avvio_Menu {
	
	public Avvio_Menu(){
		Finestra_Menu f = new Finestra_Menu();
		f.setVisible(true);	
		Controller_Menu m=new Controller_Menu(f);
	}
}
