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
	String a[][] = new String[5][7];
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
				}


			}
			frame = new JFrame();
			frame.setBounds(100, 100, 701, 533);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);



			for(int i=0;i<n;i++)
			{
				JLabel lblJnkj = new JLabel();

				lblJnkj.setText((a[i][0]));
				lblJnkj.setBounds(50, 74, 659, 399);
				frame.getContentPane().add(lblJnkj);
				JLabel lblJnkj2 = new JLabel();
				lblJnkj2.setText((a[i][1]));
				lblJnkj2.setBounds(50, 50, 659, 399);
				frame.getContentPane().add(lblJnkj2);
				JLabel lblJnkj3 = new JLabel();
				lblJnkj3.setText((a[i][2]));
				lblJnkj3.setBounds(50, 30, 659, 399);
				frame.getContentPane().add(lblJnkj3);

			}




			JLabel lblOrdersReceived = new JLabel("ORDERS RECEIVED");
			lblOrdersReceived.setFont(new Font("Russo One", Font.BOLD, 17));
			lblOrdersReceived.setForeground(Color.RED);
			lblOrdersReceived.setBounds(230, 27, 254, 72);
			frame.getContentPane().add(lblOrdersReceived);
			
			table_2 = new JTable();
			JScrollPane scrollpane = new JScrollPane(table_2);
			scrollpane.setBounds(72, 236, 435, 213);
			frame.add(scrollpane);
			table_2.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Source ", "New column", "New column", "New column", "New column"
				}
			));
			table_2.setBounds(72, 236, 435, 213);
			
			
	

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}


	}
}
