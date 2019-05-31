package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import controller.ConnexionMySql;
import net.proteanit.sql.DbUtils;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Window.Type;

public class Abscence extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	Connection cnx = null;
	PreparedStatement prepared = null;
	ResultSet resultat = null;
	private JTable table;

	/**
	 * Launch the application.
	 */
	/**public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Abscence frame = new Abscence();
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
	public Abscence() {
		setType(Type.UTILITY);
		setTitle("Gestion Absence");
		setBackground(SystemColor.activeCaption);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		cnx = ConnexionMySql.connexiondb();
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNom = new JLabel("Nom:");
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNom.setForeground(Color.WHITE);
		lblNom.setBounds(27, 124, 46, 14);
		contentPane.add(lblNom);
		
	    comboBox = new JComboBox();
		comboBox.setBounds(89, 122, 133, 20);
		contentPane.add(comboBox);
		remplirCombBox();
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("d-MM-yyyy");
		dateChooser.setBounds(89, 181, 133, 20);
		contentPane.add(dateChooser);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDate.setForeground(Color.WHITE);
		lblDate.setBounds(27, 187, 46, 14);
		contentPane.add(lblDate);
		
		JLabel lblRaison = new JLabel("Raison:");
		lblRaison.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRaison.setForeground(Color.WHITE);
		lblRaison.setBounds(27, 252, 52, 18);
		contentPane.add(lblRaison);
		
	    comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Malade", "Retard"}));
		comboBox_1.setBounds(89, 252, 133, 20);
		contentPane.add(comboBox_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/**connexion avec base de donnée**/
				String nom = comboBox.getSelectedItem().toString();
				String date =((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
				String raison = comboBox_1.getSelectedItem().toString();
				
				
				/** ajout d'absence*/
				String sql = "insert into abscence (nom,dateAbscence,raison) values(?,?,?) ";
				try {
					prepared = cnx.prepareStatement(sql);
					prepared.setString(1,nom);
					prepared.setString(2,date);
					prepared.setString(3,raison);
					prepared.execute();
					
					comboBox.setSelectedItem("selectioner");
					comboBox_1.setSelectedItem("selectioner");
					dateChooser.setDateFormatString("");
					
					
					JOptionPane.showMessageDialog(null,"absence ajouté");
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(Abscence.class.getResource("/View/image/icons8-add-48.png")));
		btnNewButton.setBounds(27, 331, 46, 41);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(Abscence.class.getResource("/View/image/edit-validated_40458.png")));
		btnNewButton_1.setBounds(107, 325, 46, 47);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(Abscence.class.getResource("/View/image/icons8-cancel-48.png")));
		btnNewButton_2.setBounds(186, 331, 46, 41);
		contentPane.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(310, 91, 464, 302);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnActualiser = new JButton("");
		btnActualiser.setBackground(SystemColor.activeCaption);
		btnActualiser.setIcon(new ImageIcon(Abscence.class.getResource("/View/image/1491313940-repeat_82991 (1).png")));
		btnActualiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updateTable();
			}
		});
		btnActualiser.setBounds(722, 49, 52, 41);
		contentPane.add(btnActualiser);
		
		JLabel lblGestion = new JLabel("Gestion ");
		lblGestion.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblGestion.setForeground(Color.WHITE);
		lblGestion.setBounds(62, 49, 109, 26);
		contentPane.add(lblGestion);
		
		JLabel lblAbsence = new JLabel("Absence");
		lblAbsence.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblAbsence.setForeground(Color.WHITE);
		lblAbsence.setBounds(119, 86, 103, 25);
		contentPane.add(lblAbsence);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Abscence.class.getResource("/View/image/6284.jpg")));
		label.setBounds(0, 0, 264, 450);
		contentPane.add(label);
	}
	/**
	 * methode pour remplir le combox*/
	public void remplirCombBox() {
		String sql = "select * from membre";
		try {
			prepared = cnx.prepareStatement(sql);
			resultat = prepared.executeQuery();
			
			while(resultat.next()) {
				String nom = resultat.getString("nom").toString();
				comboBox.addItem(nom);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * methode pour afffichage de la table*/
	public void updateTable() {
		
			String sql = "select * from abscence";
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
