package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ConnexionMySql;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import java.awt.Window.Type;

public class Indication extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	Connection cnx = null;
	PreparedStatement prepared = null;
	ResultSet resultat = null;
	private JLabel lblPassword;
	private JLabel lblIndication;

	/**
	 * Launch the application.
	 */
	/**public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Indication frame = new Indication();
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
	public Indication() {
		setTitle("Indication");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 414, 231);
		cnx = ConnexionMySql.connexiondb();
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setForeground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("login:");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLogin.setBounds(51, 58, 46, 14);
		contentPane.add(lblLogin);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				/**
				 *  pour mot de passe oubliée
				   */
				String login = textField.getText().toString();
				String sql = "select password from membre where login=?";
				try {
					prepared = cnx.prepareStatement(sql);
					prepared.setString(1,login);
					resultat = prepared.executeQuery();		
					if(resultat.next()) {
					String pass = resultat.getString("password");
					
					String pass1 = pass.substring(0,3);
					textField_2.setText("les 3 premiere lettre du mot de passe sont:"+pass1+"****");}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		textField.setBounds(142, 55, 141, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
		});
		textField_1.setBounds(142, 111, 141, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCne = new JLabel("CNE:");
		lblCne.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCne.setBounds(51, 114, 46, 14);
		contentPane.add(lblCne);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setEditable(false);
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
			}
		});
		textField_2.setBounds(138, 165, 250, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setBounds(51, 168, 63, 14);
		contentPane.add(lblPassword);
		
		lblIndication = new JLabel("Indication");
		lblIndication.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIndication.setForeground(Color.WHITE);
		lblIndication.setBounds(174, 11, 90, 20);
		contentPane.add(lblIndication);
	}

}
