import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class user {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					user window = new user();
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
	public user() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 490, 422);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select User");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Stencil", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(150, 51, 432, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("ADMIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 frame.dispose();
				 admin o =new admin();
				 o.main(null);
			}
		});
		btnNewButton.setBounds(73, 277, 97, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CUSTOMER");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			 frame.dispose();
			 
			 cust_index o = new cust_index();
			 o.main(null);
			 
				
				
			}
		});
		btnNewButton_1.setBounds(238, 277, 114, 25);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/admin.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(73, 111, 128, 112);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/customer.png")).getImage();
		label_1.setIcon(new ImageIcon(img1));
		label_1.setBounds(238, 111, 114, 112);
		frame.getContentPane().add(label_1);
	}
}
