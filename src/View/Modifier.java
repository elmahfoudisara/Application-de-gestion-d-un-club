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
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Window.Type;
import java.awt.SystemColor;

public class Modifier extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	
	Connection cnx = null;
	PreparedStatement prepared = null;
	ResultSet resultat = null;
	private JTable table;
	private JTextField textField_3;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	/**public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modifier frame = new Modifier();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}**/

	/**
	 * Create the frame.
	 */
	public Modifier() {
		setTitle("modification");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 804, 450);
		cnx = ConnexionMySql.connexiondb();
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("CNE:");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLogin.setBounds(21, 128, 46, 14);
		contentPane.add(lblLogin);
		
		textField = new JTextField();
		textField.setBounds(70, 127, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnValider = new JButton("");
		btnValider.setBackground(SystemColor.windowBorder);
		btnValider.setIcon(new ImageIcon(Modifier.class.getResource("/View/image/businessapplication_edit_male_user_thepencil_theclient_negocio_2321 (1).png")));
		btnValider.setBounds(83, 298, 59, 48);
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/** @param nom recuperer valeur de nom;
				 * @param password recuperer valeur de password;
				 * @param sql 
				 */
				String nom = textField.getText().toString();
				
				
				
				String sql = "update membre set role=? where nom =? and id_membre=?";
				try {
					prepared = cnx.prepareStatement(sql);
					prepared.setString(3,textField.getText().toString());
					prepared.setString(2,textField_1.getText().toString());
					prepared.setString(1,textField_3.getText().toString());
					
					prepared.execute();
					JOptionPane.showMessageDialog(null,"user modifié");
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		contentPane.add(btnValider);
		
		JButton btnActualiser = new JButton("");
		btnActualiser.setBackground(SystemColor.activeCaption);
		btnActualiser.setIcon(new ImageIcon(Modifier.class.getResource("/View/image/1491313940-repeat_82991 (1).png")));
		btnActualiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UpdateTable();
			}
		});
		btnActualiser.setBounds(700, 60, 53, 42);
		contentPane.add(btnActualiser);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int ligne = table.getSelectedRow();
				String CNE = table.getModel().getValueAt(ligne, 0).toString();
				String role = table.getModel().getValueAt(ligne, 1).toString();
				String nom = table.getModel().getValueAt(ligne, 2).toString();
				
				
			
				textField.setText(CNE);
				textField_3.setText(role);
				textField_1.setText(nom);
				
				
				
			}
		});
		scrollPane.setViewportView(table);
		scrollPane.setBounds(247, 113, 513, 271);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("Role:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(21, 174, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(70, 173, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNom = new JLabel("Nom:");
		lblNom.setForeground(Color.WHITE);
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNom.setBounds(21, 236, 46, 14);
		contentPane.add(lblNom);
		
		textField_1 = new JTextField();
		textField_1.setBounds(70, 233, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblGestion = new JLabel("Gestion ");
		lblGestion.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblGestion.setForeground(Color.WHITE);
		lblGestion.setBounds(70, 46, 103, 28);
		contentPane.add(lblGestion);
		
		JLabel lblMembre = new JLabel("Membre");
		lblMembre.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblMembre.setForeground(Color.WHITE);
		lblMembre.setBounds(110, 85, 97, 20);
		contentPane.add(lblMembre);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Modifier.class.getResource("/View/image/6284.jpg")));
		label.setBounds(0, 0, 213, 411);
		contentPane.add(label);
	}
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
