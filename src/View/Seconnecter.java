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
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Window.Type;

public class Seconnecter extends JFrame {

	private JPanel contentPane;
	private JTextField loginfield;
	private JPasswordField passwordField;
	
	Connection cnx = null;
	PreparedStatement prepared = null;
	ResultSet resultat = null;
	ResultSet resultat1 = null;

	/**
	 * Launch the application.
	 */
	/**public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Seconnecter frame = new Seconnecter();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}**/

	public void fermer()
	{
		dispose();
	}
	/**
	 * Create the frame.
	 */
	public Seconnecter() {
		setType(Type.UTILITY);
		setBackground(SystemColor.activeCaption);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 488);
		cnx = ConnexionMySql.connexiondb();
		setTitle("Connexion");
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLogin.setBounds(259, 168, 46, 17);
		contentPane.add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(259, 214, 85, 14);
		contentPane.add(lblPassword);
		
		loginfield = new JTextField();
		loginfield.setBounds(354, 168, 164, 20);
		contentPane.add(loginfield);
		loginfield.setColumns(10);
		
		JButton btnValider = new JButton("");
		btnValider.setBackground(Color.DARK_GRAY);
		btnValider.setIcon(new ImageIcon(Seconnecter.class.getResource("/View/image/internet_102151.png")));
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/** @param login recuperer la valeur du login;
				 * @param password recuperer la valeur du password;
				 * @param sql recuperer valeur login et password de base donnée;
				 */
				String login = loginfield.getText().toString();
				String password = passwordField.getText().toString();
				
				String sql = "select login, password from membre";
				if(login.equals("zayd") && password.equals("12345678")) {
					Admins s = new Admins();
					s.setVisible(true);
				}else {
			
				try {
					prepared = cnx.prepareStatement(sql);
					resultat = prepared.executeQuery();
					
					int i = 0;
					
					if(login.equals("")&& password.equals("")) {
						JOptionPane.showMessageDialog(null,"remplissez les champs vides");
					}
					else {
						while(resultat.next()) {
							String login1 = resultat.getString("login");
							String password1 = resultat.getString("password");
							
							
								if(login1.equals(login)&& password1.equals(password))
								{
									JOptionPane.showMessageDialog(null,"connexion reussie");
									i=1;
									Users t = new Users();
									t.setVisible(true);
								
								}
								
								}
						if (i==0)
							JOptionPane.showMessageDialog(null, "connexion echouée , Informations Incorrecte");;
					}
					
						
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}}
				fermer();				
		
			}});
		btnValider.setBounds(367, 311, 54, 50);
		contentPane.add(btnValider);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(354, 213, 164, 20);
		contentPane.add(passwordField);
		
		JLabel lblMotDePasse = new JLabel("mot de passe oubli\u00E9?");
		lblMotDePasse.setForeground(Color.WHITE);
		lblMotDePasse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Indication d = new Indication();
				d.setVisible(true);
				d.setLocationRelativeTo(null);
			}
		});
		lblMotDePasse.setFont(new Font("Source Sans Pro Light", Font.PLAIN, 8));
		lblMotDePasse.setBounds(438, 244, 80, 14);
		contentPane.add(lblMotDePasse);
		
		JLabel lblConnexion = new JLabel("Connexion");
		lblConnexion.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblConnexion.setForeground(Color.WHITE);
		lblConnexion.setBounds(302, 53, 200, 37);
		contentPane.add(lblConnexion);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Seconnecter.class.getResource("/View/image/6284.jpg")));
		label.setBounds(235, 0, 304, 449);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Seconnecter.class.getResource("/View/image/Club_3D_Grafikcard_Tray_30781.png")));
		label_1.setBounds(10, 11, 85, 79);
		contentPane.add(label_1);
	}
}
