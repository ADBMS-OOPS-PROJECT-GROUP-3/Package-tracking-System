import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import javax.swing.table.DefaultTableModel;


public class track {

	private JFrame frame;
	private JTextField textField;
	String a[][] = new String[10][7];
	String tr ;
	JLabel lblNewLabel;


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
		int n;
		try {
			URL url = new URL("http://127.0.0.1:9900/vieworder");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();

			int responsecode = conn.getResponseCode();

			String inline;
			if (responsecode != 200) {
				throw new RuntimeException("HttpResponseCode:" + responsecode);
			} else {
				inline = "";
				Scanner sc = new Scanner(url.openStream());


				while (sc.hasNext()) {
					inline += sc.nextLine();
				}
				sc.close();

				JSONParser parse = new JSONParser();
				JSONObject data_obj = (JSONObject) parse.parse(inline);

				JSONArray arr = (JSONArray) data_obj.get("data");
				n = arr.size();
				DefaultTableModel tableadd = new DefaultTableModel();
				for (int i = 0; i < arr.size(); i++) {
					JSONObject new_obj = (JSONObject) arr.get(i);
					a[i][0] = (String) new_obj.get("Status");


				}
				tr = a[0][0];


			}


			frame = new JFrame();
			frame.getContentPane().setBackground(Color.WHITE);
			frame.setBounds(100, 100, 705, 544);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);

			JLabel lblTrackYourOrder = new JLabel("Track Your Order");
			lblTrackYourOrder.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 38));
			lblTrackYourOrder.setForeground(new Color(255, 200, 0));
			lblTrackYourOrder.setBounds(149, 58, 455, 57);
			frame.getContentPane().add(lblTrackYourOrder);

			JLabel lblEnterYourTracking = new JLabel("Enter your Tracking Id    :");
			lblEnterYourTracking.setFont(new Font("Segoe UI Symbol", Font.BOLD, 14));
			lblEnterYourTracking.setForeground(Color.BLACK);
			lblEnterYourTracking.setBounds(112, 162, 224, 34);
			frame.getContentPane().add(lblEnterYourTracking);

			textField = new JTextField();
			textField.setBounds(347, 169, 116, 22);
			frame.getContentPane().add(textField);
			textField.setColumns(10);

			JButton btnSubmit = new JButton("Submit");
			btnSubmit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					lblNewLabel.setText(tr);


				}
			});
			btnSubmit.setBounds(232, 258, 97, 25);
			frame.getContentPane().add(btnSubmit);

			JLabel lblStatus = new JLabel("Status                :");
			lblStatus.setFont(new Font("Segoe UI Symbol", Font.BOLD, 14));
			lblStatus.setForeground(Color.RED);
			lblStatus.setBounds(194, 211, 171, 16);
			frame.getContentPane().add(lblStatus);

			lblNewLabel = new JLabel(" ...");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel.setForeground(Color.RED);
			lblNewLabel.setBounds(357, 212, 100, 16);
			frame.getContentPane().add(lblNewLabel);

			JButton btnNewButton = new JButton("Back");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					frame.dispose();
					cust_index c = new cust_index();
					c.main(null);
				}
			});
			btnNewButton.setBounds(357, 258, 97, 25);
			frame.getContentPane().add(btnNewButton);
			
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\tkm\\Downloads\\pexels-karolina-grabowska-4498128.jpg"));
			lblNewLabel_1.setBounds(12, 13, 663, 471);
			frame.getContentPane().add(lblNewLabel_1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	}

