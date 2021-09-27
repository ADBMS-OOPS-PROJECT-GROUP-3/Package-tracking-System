import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class cust_index {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cust_index window = new cust_index();
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
	public cust_index() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 477, 457);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCustomer = new JLabel("CUSTOMER");
		lblCustomer.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblCustomer.setForeground(Color.RED);
		lblCustomer.setBounds(175, 18, 117, 49);
		frame.getContentPane().add(lblCustomer);
		
		JButton btnNewButton = new JButton("New Order");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				cust_order o = new cust_order();
				o.main(null);
			}
		});
		btnNewButton.setBounds(69, 217, 128, 35);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Track Your Order");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				track t = new track();
				t.main(null);
			}
		});
		btnNewButton_1.setBounds(252, 217, 149, 35);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.dispose();
				user o = new user();
				o.main(null);
			}
		});
		btnNewButton_2.setBounds(175, 294, 97, 25);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel label = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/order.png")).getImage();
		label.setIcon(new ImageIcon(img1));
		label.setBounds(59, 80, 128, 124);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/cart-icon.png")).getImage();
		label_1.setIcon(new ImageIcon(img2));
		label_1.setBounds(260, 80, 128, 124);
		frame.getContentPane().add(label_1);
	}

}
