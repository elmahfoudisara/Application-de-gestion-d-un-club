package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ConnexionMySql;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Window.Type;
import java.awt.Toolkit;

public class Ajout extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTable table;
	
	Connection cnx = null;
	PreparedStatement prepared = null;
	ResultSet resultat = null;
	private JButton btnActualiser;
	private JTextField textField;
	private JLabel label;
	private JLabel lblGestion;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	/**public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ajout frame = new Ajout();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Ajout() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\zaydmami\\Pictures\\Camera Roll\\Club_3D_Grafikcard_Tray_30781 (1).png"));
		setTitle("Application Gestion Club");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		cnx = ConnexionMySql.connexiondb();
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNom = new JLabel("Nom:");
		lblNom.setForeground(SystemColor.text);
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNom.setBounds(20, 190, 46, 14);
		contentPane.add(lblNom);
		
		JLabel lblRole = new JLabel("Role:");
		lblRole.setForeground(SystemColor.text);
		lblRole.setBackground(SystemColor.menu);
		lblRole.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRole.setBounds(20, 246, 73, 14);
		contentPane.add(lblRole);
		
		lblGestion = new JLabel("Gestion ");
		lblGestion.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblGestion.setForeground(SystemColor.text);
		lblGestion.setBounds(38, 75, 133, 41);
		contentPane.add(lblGestion);
		
		lblNewLabel = new JLabel("Membre");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setBounds(95, 108, 120, 41);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(79, 245, 110, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(128, 128, 128));
		btnNewButton.setIcon(new ImageIcon(Ajout.class.getResource("/View/image/business_application_addmale_useradd_insert_add_user_client_2312.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				/**
				 * ajout de role*/
				String nom = textField.getText().toString();
				String role = textField_1.getText().toString();
				
				
				
				String sql = "update membre set role=? where nom=?";
				try {
					prepared = cnx.prepareStatement(sql);
					prepared.setString(1,textField_1.getText().toString());
					prepared.setString(2,nom);
					
			        prepared.execute();
					
					
					JOptionPane.showMessageDialog(null,"membre ajouté");
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});
		btnNewButton.setBounds(93, 340, 59, 46);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(300, 102, 474, 332);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnActualiser = new JButton("");
		btnActualiser.setBackground(SystemColor.activeCaption);
		btnActualiser.setIcon(new ImageIcon(Ajout.class.getResource("/View/image/1491313940-repeat_82991 (1).png")));
		btnActualiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateTable();
			}
		});
		btnActualiser.setBounds(703, 34, 53, 57);
		contentPane.add(btnActualiser);
		
		textField = new JTextField();
		textField.setBounds(79, 189, 110, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(Ajout.class.getResource("/View/image/6284.jpg")));
		label.setBounds(0, 0, 249, 461);
		contentPane.add(label);
		
	}
	/**
	 * affichage de table*/
	public void UpdateTable() {
		String sql = "select * from membre";
		try {
			prepared = cnx.prepareStatement(sql);
			resultat = prepared.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(resultat));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
