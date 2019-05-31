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
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Window.Type;

public class AjoutCharge extends JFrame {

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
					AjoutCharge frame = new AjoutCharge();
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
	public AjoutCharge() {
		setTitle("Ajout Charge");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		cnx = ConnexionMySql.connexiondb();
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCharge = new JLabel("Charge:");
		lblCharge.setForeground(Color.WHITE);
		lblCharge.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCharge.setBounds(125, 65, 66, 17);
		contentPane.add(lblCharge);
		
		JLabel lblProduit = new JLabel("Montant:");
		lblProduit.setForeground(Color.WHITE);
		lblProduit.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblProduit.setBounds(125, 126, 66, 14);
		contentPane.add(lblProduit);
		
		textField = new JTextField();
		textField.setBounds(201, 64, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(201, 124, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnValider = new JButton("valider");
		btnValider.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * ajout de charge avec montant*/
				String charge = textField.getText().toString();
				String montant = textField_1.getText().toString();
				/**
				 * ajout dans la base de donnée
				 */
				String sql = "insert into comptabilité (charge,montant_charge) values (?,?)";
				try {
					prepared = cnx.prepareStatement(sql);
					prepared.setString(1,charge);
					prepared.setString(2,montant);
					
			        prepared.execute();
					
					
					JOptionPane.showMessageDialog(null,"charge ajouté");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnValider.setBounds(198, 186, 89, 23);
		contentPane.add(btnValider);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(AjoutCharge.class.getResource("/View/image/6284.jpg")));
		label.setBounds(107, 0, 208, 261);
		contentPane.add(label);
	}
}
