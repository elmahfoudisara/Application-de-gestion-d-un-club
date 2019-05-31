package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ConnexionMySql;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextArea;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.Window.Type;

public class Pv extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	Connection cnx = null;
	PreparedStatement prepared = null;
	ResultSet resultat = null;

	/**
	 * Launch the application.
	 */
	/**public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pv frame = new Pv();
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
	public Pv() {
		setType(Type.UTILITY);
		setTitle("Pv");
		setBackground(SystemColor.activeCaption);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		cnx = ConnexionMySql.connexiondb();
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNumroPv = new JLabel("Num\u00E9ro pv:");
		lblNumroPv.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNumroPv.setBounds(91, 24, 96, 23);
		contentPane.add(lblNumroPv);
		
		JLabel lblTitre = new JLabel("AnimReunion");
		lblTitre.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitre.setBounds(91, 67, 110, 14);
		contentPane.add(lblTitre);
		
		JLabel lblOrdreDuJour = new JLabel("Ordre du jour:");
		lblOrdreDuJour.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOrdreDuJour.setBounds(91, 110, 110, 14);
		contentPane.add(lblOrdreDuJour);
		
		JLabel lblHeureLeve = new JLabel("Heure lev\u00E9e:");
		lblHeureLeve.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHeureLeve.setBounds(91, 152, 96, 14);
		contentPane.add(lblHeureLeve);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(173, 206, 542, 89);
		contentPane.add(textArea);
		
		JLabel lblSignature = new JLabel("Signature:");
		lblSignature.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSignature.setBounds(67, 318, 96, 14);
		contentPane.add(lblSignature);
		
		JButton btnValider = new JButton("valider");
		btnValider.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/** 
				 * @param sql ajouter valeur a pv;
				 */
				String sql = "insert into pv (id_pv,ordre_du_jour,heure_levee,resume,signature,AnimReunion) values(?,?,?,?,?,?)";
				try {
					prepared = cnx.prepareStatement(sql);
					prepared.setString(1, textField.getText().toString());
					prepared.setString(6, textField_1.getText().toString());
					prepared.setString(2, textField_2.getText().toString());
					prepared.setString(3, textField_3.getText().toString());
					prepared.setString(5, textField_5.getText().toString());
					prepared.setString(4,textArea.getText().toString());
					
					
					prepared.execute();
					
					JOptionPane.showMessageDialog(null, "Pv ajouté");
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnValider.setBounds(626, 408, 89, 23);
		contentPane.add(btnValider);
		
		textField = new JTextField();
		textField.setBounds(246, 27, 143, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(246, 66, 145, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(246, 109, 145, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(246, 151, 143, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(173, 316, 542, 23);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblRsum = new JLabel("R\u00E9sum\u00E9:");
		lblRsum.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRsum.setBounds(104, 210, 73, 14);
		contentPane.add(lblRsum);
		
		JLabel lblPv = new JLabel("PV");
		lblPv.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblPv.setForeground(Color.WHITE);
		lblPv.setBounds(708, 31, 46, 54);
		contentPane.add(lblPv);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Pv.class.getResource("/View/image/business_table_order_report_history_2332.png")));
		label.setBounds(626, 31, 72, 70);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Pv.class.getResource("/View/image/Club_3D_Grafikcard_Tray_30781.png")));
		label_1.setBounds(10, 11, 64, 70);
		contentPane.add(label_1);
		
		
	}
}
