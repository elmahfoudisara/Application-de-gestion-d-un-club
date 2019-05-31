package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ConnexionMySql;
import net.proteanit.sql.DbUtils;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Font;
import java.awt.Window.Type;

public class ConsultEvene extends JFrame {

	private JPanel contentPane;
	Connection cnx = null;
	PreparedStatement prepared = null;
	PreparedStatement prepared1 = null;
	ResultSet resultat = null;
	private JPanel panel;
	private JLabel label;
	private JLabel lblEvenement;
	private JLabel label_1;


	/**
	 * Launch the application.
	 */
	/**public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultEvene frame = new ConsultEvene();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}**/

	/**
	 * Create the frame.
	 */
	public ConsultEvene() {
		setType(Type.UTILITY);
		setTitle("Consulter Evenement");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		cnx = ConnexionMySql.connexiondb();
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnConsulter = new JButton("");
		btnConsulter.setIcon(new ImageIcon(ConsultEvene.class.getResource("/View/image/one-finger-click-black-hand-symbol_icon-icons.com_64350.png")));
		btnConsulter.setBounds(10, 39, 50, 52);
		contentPane.add(btnConsulter);
		
		panel = new JPanel();
		panel.setBounds(10, 102, 764, 321);
		contentPane.add(panel);
		panel.setLayout(null);
		
		label = new JLabel("");
		label.setBounds(-12, 68, 786, 321);
		contentPane.add(label);
		
		lblEvenement = new JLabel("Evenement");
		lblEvenement.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblEvenement.setForeground(Color.WHITE);
		lblEvenement.setBounds(607, 43, 134, 29);
		contentPane.add(lblEvenement);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(ConsultEvene.class.getResource("/View/image/1486504340-calendar-date-event-month-schedule_81325.png")));
		label_1.setBounds(519, 18, 78, 73);
		contentPane.add(label_1);
	
		btnConsulter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/** 
				 * @param sql recuperer depuis evenement*/
				String sql ="select*from evenement";
				try {
					prepared = cnx.prepareStatement(sql);
					
					resultat=prepared.executeQuery();
					/** consultation**/
					while(resultat.next()) {
						
						
						byte[] img = resultat.getBytes("image");
						ImageIcon image = new ImageIcon(img);
						Image im = image.getImage();
						Image myImage = im.getScaledInstance(label.getWidth(),label.getHeight(), java.awt.Image.SCALE_SMOOTH);
						ImageIcon finalimg = new ImageIcon(myImage);
						label.setIcon(finalimg);
						
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		

	}
}
