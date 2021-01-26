package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class Finestra_Menu extends JFrame {

	private JPanel contentPane;
	private JLabel lblTris;
	private JLabel lblScegliereLopzione;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	public Finestra_Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTris = new JLabel("TRIS");
		lblTris.setFont(new Font("Taffy", Font.BOLD, 23));
		lblTris.setBounds(188, 24, 75, 24);
		contentPane.add(lblTris);
		
		lblScegliereLopzione = new JLabel("Scegliere l'opzione");
		lblScegliereLopzione.setBounds(167, 72, 127, 24);
		contentPane.add(lblScegliereLopzione);
		
		btnNewButton = new JButton("CREA GIOCO");
		btnNewButton.setBounds(150, 129, 144, 24);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("UNISCITI AL GIOCO");
		btnNewButton_1.setBounds(150, 186, 144, 24);
		contentPane.add(btnNewButton_1);
	}

	public JButton getBtnNewButton() {
		return btnNewButton;
	}

	public void setBtnNewButton(JButton btnNewButton) {
		this.btnNewButton = btnNewButton;
	}

	public JButton getBtnNewButton_1() {
		return btnNewButton_1;
	}

	public void setBtnNewButton_1(JButton btnNewButton_1) {
		this.btnNewButton_1 = btnNewButton_1;
	}
	
	
}
