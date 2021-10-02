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


public class vieworder {

	private JFrame frame;
	String a[][] = new String[12][7];
	private JTable table;
	private JTable table_1;
	private JTable table_2;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vieworder window = new vieworder();
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
	public vieworder() {


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
				DefaultTableModel tableadd=new DefaultTableModel();
				for (int i = 0; i < arr.size(); i++) {
					JSONObject new_obj = (JSONObject) arr.get(i);
					a[i][0] = (String) new_obj.get("s_name");
					a[i][1] = (String) new_obj.get("r_name");
					a[i][2] = (String) new_obj.get("source");
					a[i][3] = (String) new_obj.get("destination");
					a[i][4] = (String) new_obj.get("tracking_id");
					a[i][5] = (String) new_obj.get("order_id");
					a[i][6] = (String) new_obj.get("Status");




				}




			}
			frame = new JFrame();
			frame.setBounds(100, 100, 701, 533);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);



//			for(int i=0;i<n;i++)
//			{
//				JLabel lblJnkj = new JLabel();
//
//				lblJnkj.setText((a[i][0]));
//				lblJnkj.setBounds(50, 74, 659, 399);
//				frame.getContentPane().add(lblJnkj);
//				JLabel lblJnkj2 = new JLabel();
//				lblJnkj2.setText((a[i][1]));
//				lblJnkj2.setBounds(50, 50, 659, 399);
//				frame.getContentPane().add(lblJnkj2);
//				JLabel lblJnkj3 = new JLabel();
//				lblJnkj3.setText((a[i][2]));
//				lblJnkj3.setBounds(50, 30, 659, 399);
//				frame.getContentPane().add(lblJnkj3);
//
//			}




			JLabel lblOrdersReceived = new JLabel("ORDERS RECEIVED");
			lblOrdersReceived.setFont(new Font("Russo One", Font.BOLD, 17));
			lblOrdersReceived.setForeground(Color.RED);
			lblOrdersReceived.setBounds(230, 27, 254, 72);
			frame.getContentPane().add(lblOrdersReceived);
			
			table_2 = new JTable();
			JScrollPane scrollpane = new JScrollPane(table_2);
			scrollpane.setBounds(101, 136, 495, 213);
			frame.getContentPane().add(scrollpane);
			table_2.setModel(new DefaultTableModel(
				new Object[][] {
						{
								a[0][0],a[0][1],a[0][2],a[0][3],a[0][4],a[0][5],a[0][6]
						},
						{
							a[1][0],a[1][1],a[1][2],a[1][3],a[1][4],a[1][5],a[1][6]
						},
						{
							a[2][0],a[2][1],a[2][2],a[2][3],a[2][4],a[2][5],a[2][6]
						},{
						a[3][0],a[3][1],a[3][2],a[3][3],a[3][4],a[3][5],a[3][6]
				},
						{
								a[4][0],a[4][1],a[4][2],a[4][3],a[4][4],a[4][5],a[4][6]
						},
						{
								a[5][0],a[5][1],a[5][2],a[5][3],a[5][4],a[5][5],a[5][6]
						},
						{
								a[6][0],a[6][1],a[6][2],a[6][3],a[6][4],a[6][5],a[6][6]
						},
						{
								a[7][0],a[7][1],a[7][2],a[7][3],a[7][4],a[7][5],a[7][6]
						},
						{
								a[8][0],a[8][1],a[8][2],a[8][3],a[8][4],a[8][5],a[8][6]
						},
						{
								a[9][0],a[9][1],a[9][2],a[9][3],a[9][4],a[9][5],a[9][6]
						},
						{
								a[10][0],a[10][1],a[10][2],a[10][3],a[10][4],a[10][5],a[10][6]
						},
						{
								a[11][0],a[11][1],a[11][2],a[11][3],a[11][4],a[11][5],a[11][6]
						}



				},
				new String[] {
					"Sender Name ", "Receiver name", "Source", "Destination", "tracking id","Order_Id","Status"
				}
			));
			table_2.setBounds(72, 236, 435, 150);
			
			JButton btnNewButton = new JButton("Update");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnNewButton.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
			btnNewButton.setForeground(Color.BLACK);
			btnNewButton.setBounds(220, 423, 139, 25);
			frame.getContentPane().add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("Back");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					frame.dispose();
					admin a = new admin();
					a.main(null);
				}
			});
			btnNewButton_1.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
			btnNewButton_1.setBounds(387, 423, 97, 25);
			frame.getContentPane().add(btnNewButton_1);
			
			JLabel lblNewLabel = new JLabel("New label");
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\tkm\\Downloads\\pexels-pixabay-264547.jpg"));
			lblNewLabel.setBounds(0, 0, 683, 486);
			frame.getContentPane().add(lblNewLabel);
			
			
	

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}


	}
}
