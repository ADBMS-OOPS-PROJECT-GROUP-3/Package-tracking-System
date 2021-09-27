import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class track {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					track window = new track();
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
	public track() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTrackYourOrder = new JLabel("Track Your Order");
		lblTrackYourOrder.setFont(new Font("Courgette", Font.BOLD, 18));
		lblTrackYourOrder.setForeground(new Color(102, 204, 0));
		lblTrackYourOrder.setBounds(131, 26, 161, 34);
		frame.getContentPane().add(lblTrackYourOrder);
		
		JLabel lblEnterYourTracking = new JLabel("Enter your Tracking Id    :");
		lblEnterYourTracking.setBounds(30, 102, 170, 34);
		frame.getContentPane().add(lblEnterYourTracking);
		
		textField = new JTextField();
		textField.setBounds(196, 108, 116, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.dispose();
				tracking t = new tracking();
				t.main(null);
			}
		});
		btnSubmit.setBounds(153, 164, 97, 25);
		frame.getContentPane().add(btnSubmit);
	}

}
