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
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Window.Type;

public class AjoutProduit extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	Connection cnx = null;
	PreparedStatement prepared = null;
	ResultSet resultat = null;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	/**public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjoutProduit frame = new AjoutProduit();
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
	public AjoutProduit() {
		setTitle("Ajout Produit");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		//cnx avec base donnée
		cnx = ConnexionMySql.connexiondb();
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProduit = new JLabel("Produit:");
		lblProduit.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblProduit.setForeground(Color.WHITE);
		lblProduit.setBounds(114, 74, 70, 14);
		contentPane.add(lblProduit);
		
		JLabel lblMontant = new JLabel("Montant:");
		lblMontant.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMontant.setForeground(Color.WHITE);
		lblMontant.setBounds(114, 124, 70, 14);
		contentPane.add(lblMontant);
		
		textField = new JTextField();
		textField.setBounds(194, 72, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(194, 122, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnValider = new JButton("valider");
		btnValider.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/** @param produit valeur de produit
				 * @param montant valeur montant
				 * @param ajout a comptaProduit
				 */
				String produit = textField.getText().toString();
				String montant = textField_1.getText().toString();
				
				String sql = "insert into comptaProduit (produit,montant) values (?,?)";
				try {
					prepared = cnx.prepareStatement(sql);
					prepared.setString(1,produit);
					prepared.setString(2,montant);
					
			        prepared.execute();
					
					
					JOptionPane.showMessageDialog(null,"produit ajouté");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnValider.setBounds(180, 200, 89, 23);
		contentPane.add(btnValider);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(AjoutProduit.class.getResource("/View/image/6284.jpg")));
		label.setBounds(104, 0, 206, 261);
		contentPane.add(label);
	}

}
