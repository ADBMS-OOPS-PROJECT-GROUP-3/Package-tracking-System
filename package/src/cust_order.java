import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import org.json.simple.JSONObject;


public class cust_order {

	private JFrame frame;
	private JTextField s_name;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	String s;
	JLabel lblXnx;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cust_order window = new cust_order();
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
	public cust_order() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 461, 525);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblOrderDetails = new JLabel("Order Details");
		lblOrderDetails.setFont(new Font("Stencil", Font.PLAIN, 17));
		lblOrderDetails.setForeground(Color.RED);
		lblOrderDetails.setBounds(158, 24, 156, 42);
		frame.getContentPane().add(lblOrderDetails);
		
		JLabel lblSenderName = new JLabel("Sender Name   :");
		lblSenderName.setBounds(38, 92, 108, 22);
		frame.getContentPane().add(lblSenderName);
		
		JLabel lblNewLabel = new JLabel("Receiver Name :");
		lblNewLabel.setBounds(38, 129, 108, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Source            :");
		lblNewLabel_1.setBounds(38, 169, 97, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Destination       :");
		lblNewLabel_2.setBounds(38, 208, 97, 16);
		frame.getContentPane().add(lblNewLabel_2);
		

		
		JButton btnNewButton = new JButton("Place Order");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				String sname = s_name.getText();
				String rname = textField_1.getText();
				String source = textField_2.getText();
				String destination = textField_3.getText();
				String status = "order placed";

				try{
					String postEndpoint = "http://127.0.0.1:9900/order";
					JSONObject jo = new JSONObject();
					jo.put("s_name" , sname);
					jo.put("r_name" , rname);
					jo.put("source" , source);
					jo.put("destination" , destination);
					jo.put("Status",status);

					var request = HttpRequest.newBuilder()
							.uri(URI.create(postEndpoint))
							.header("Content-Type","application/json")
							.POST(HttpRequest.BodyPublishers.ofString(String.valueOf(jo)))
							.build();
					var client = HttpClient.newHttpClient();
					var response = client.send(request,HttpResponse.BodyHandlers.ofString());

					s = response.body();
					System.out.println(s);
					lblXnx.setText(s.substring(77,81));

				}
				catch(Exception e)
				{
					e.printStackTrace();
				}

				
			}
		});
		btnNewButton.setBounds(158, 316, 124, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				cust_index o = new cust_index();
				o.main(null);
			}
		});
		btnNewButton_1.setBounds(158, 369, 124, 25);
		frame.getContentPane().add(btnNewButton_1);
		
		
		s_name = new JTextField();
		
		s_name.setBounds(166, 92, 116, 22);
		frame.getContentPane().add(s_name);
		s_name.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(166, 126, 116, 22);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(166, 166, 116, 22);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(166, 205, 116, 22);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblYourTrackingId = new JLabel("Your Tracking Id :");
		lblYourTrackingId.setBounds(38, 265, 108, 22);
		
		
		frame.getContentPane().add(lblYourTrackingId);
		
		 lblXnx = new JLabel("");
		lblXnx.setBounds(166, 268, 150, 16);
		frame.getContentPane().add(lblXnx);
		
		
		

		

	}
}
