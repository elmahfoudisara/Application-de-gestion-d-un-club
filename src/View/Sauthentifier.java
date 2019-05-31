package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ConnexionMySql;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Window.Type;

public class Sauthentifier extends JFrame {

	private JPanel contentPane;
	private JTextField textField_4;
	
	Connection cnx = null;
	PreparedStatement prepared = null;
	ResultSet resultat = null;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;


	/**
	 * Launch the application.
	 */
	/**public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sauthentifier frame = new Sauthentifier();
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
	public Sauthentifier() {
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		cnx = ConnexionMySql.connexiondb();
		setTitle("Inscription");
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCne = new JLabel("prenom:");
		lblCne.setForeground(Color.WHITE);
		lblCne.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCne.setBounds(222, 228, 72, 14);
		contentPane.add(lblCne);
		
		textField_4 = new JTextField();
		textField_4.setBounds(329, 227, 130, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblAddresse = new JLabel("nom:");
		lblAddresse.setForeground(Color.WHITE);
		lblAddresse.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAddresse.setBounds(222, 179, 72, 14);
		contentPane.add(lblAddresse);
		
		JButton btnValider = new JButton("");
		btnValider.setBackground(Color.GRAY);
		btnValider.setIcon(new ImageIcon(Sauthentifier.class.getResource("/View/image/Add_User-80_icon-icons.com_57380.png")));
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/** @param sql ajouter valeurs a membre;
				 * @param prepared connexion avec base donée;
				 */
				String sql="insert into membre (id_membre,password,nom,prenom,email,login) values (?,?,?,?,?,?)";
				try {
					prepared = cnx.prepareStatement(sql);
					prepared.setString(1, textField.getText().toString());
					prepared.setString(2, textField_1.getText().toString());
					prepared.setString(3, textField_2.getText().toString());
					prepared.setString(4, textField_4.getText().toString());
					prepared.setString(6, textField_3.getText().toString());
					prepared.setString(5, textField_5.getText().toString());
					prepared.execute();
					
					JOptionPane.showMessageDialog(null, "bienvenue");
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnValider.setBounds(364, 391, 55, 47);
		contentPane.add(btnValider);
		
		JLabel lblLogin = new JLabel("CNE:");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLogin.setBounds(222, 78, 46, 14);
		contentPane.add(lblLogin);
		
		textField = new JTextField();
		textField.setBounds(329, 77, 130, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("password:");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(222, 127, 86, 14);
		contentPane.add(lblPassword);
		
		JLabel label = new JLabel("");
		label.setBounds(181, 77, 46, 14);
		contentPane.add(label);
		
		textField_1 = new JTextField();
		textField_1.setBounds(329, 126, 130, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(329, 178, 130, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblLogin_1 = new JLabel("login:");
		lblLogin_1.setForeground(Color.WHITE);
		lblLogin_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLogin_1.setBounds(222, 279, 46, 14);
		contentPane.add(lblLogin_1);
		
		JLabel lblEmail = new JLabel("email:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmail.setBounds(222, 336, 46, 14);
		contentPane.add(lblEmail);
		
		textField_3 = new JTextField();
		textField_3.setBounds(329, 278, 130, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(329, 335, 130, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Inscription");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(309, 11, 149, 31);
		contentPane.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Sauthentifier.class.getResource("/View/image/6284.jpg")));
		label_1.setBounds(181, 0, 388, 476);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Sauthentifier.class.getResource("/View/image/Club_3D_Grafikcard_Tray_30781.png")));
		label_2.setBounds(10, 11, 72, 69);
		contentPane.add(label_2);
	}
}
