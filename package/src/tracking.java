import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;


public class tracking {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tracking window = new tracking();
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
	public tracking() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 702, 533);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblYourOrderStatus = new JLabel("Your Order Status");
		lblYourOrderStatus.setFont(new Font("Wide Latin", Font.BOLD, 19));
		lblYourOrderStatus.setForeground(SystemColor.textHighlight);
		lblYourOrderStatus.setBackground(Color.WHITE);
		lblYourOrderStatus.setBounds(172, 27, 324, 88);
		frame.getContentPane().add(lblYourOrderStatus);
	}
}
