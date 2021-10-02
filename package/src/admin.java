import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;


public class admin {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin window = new admin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public admin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 714, 551);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAdmin = new JLabel("ADMIN");
		lblAdmin.setFont(new Font("Teko SemiBold", Font.BOLD, 61));
		lblAdmin.setForeground(Color.RED);
		lblAdmin.setBounds(272, 13, 221, 107);
		frame.getContentPane().add(lblAdmin);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				user o = new user();
				o.main(null);
			}
		});
		btnBack.setBounds(319, 308, 75, 25);
		frame.getContentPane().add(btnBack);
		
		JButton btnNewButton = new JButton("VIew Orders");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.dispose();
				vieworder v = new vieworder();
				v.main(null);
			}
		});
		btnNewButton.setBounds(297, 251, 120, 36);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\tkm\\Downloads\\tyler-franta-iusJ25iYu1c-unsplash.jpg"));
		lblNewLabel.setBounds(0, 0, 696, 504);
		frame.getContentPane().add(lblNewLabel);
	}

}
