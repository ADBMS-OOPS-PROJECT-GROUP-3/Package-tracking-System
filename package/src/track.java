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

					lblNewLabel.setText(tr);


				}
			});
			btnSubmit.setBounds(130, 198, 97, 25);
			frame.getContentPane().add(btnSubmit);

			JLabel lblStatus = new JLabel("Status             :");
			lblStatus.setBounds(83, 156, 97, 16);
			frame.getContentPane().add(lblStatus);

			lblNewLabel = new JLabel(" ...");
			lblNewLabel.setBounds(196, 156, 100, 16);
			frame.getContentPane().add(lblNewLabel);

			JButton btnNewButton = new JButton("Back");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					frame.dispose();
					cust_index c = new cust_index();
					c.main(null);
				}
			});
			btnNewButton.setBounds(264, 198, 97, 25);
			frame.getContentPane().add(btnNewButton);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	}

