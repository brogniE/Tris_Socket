package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class finestra_prova extends JFrame {

	private JPanel contentPane;
	private JPanel panelResult;
	private JLabel labelResult;
	private JButton btnOk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					finestra_prova frame = new finestra_prova();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public finestra_prova() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelResult = new JPanel();
		panelResult.setBounds(10, 10, 416, 243);
		contentPane.add(panelResult);
		panelResult.setLayout(null);
		
		labelResult = new JLabel("");
		labelResult.setFont(new Font("Tahoma", Font.BOLD, 26));
		labelResult.setBounds(97, 55, 217, 50);
		panelResult.add(labelResult);
		
		btnOk = new JButton("OK");
		btnOk.setBounds(158, 177, 85, 21);
		panelResult.add(btnOk);
	}
}
