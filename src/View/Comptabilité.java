package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controller.ConnexionMySql;
import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Window.Type;

public class Comptabilité extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JPanel panel_1;
	private JScrollPane scrollPane_1;
	private JTable table_1;
	private JButton btnAjouterCharge;
	private JButton btnAjouterProduit;
	private JButton btnActualiser;
	private JButton btnNewButton;
	Connection cnx = null;
	PreparedStatement prepared = null;
	ResultSet resultat = null;
	private JLabel lblComptabiliteDesCharges;
	private JLabel label;
	private JLabel lblComptabiliteDesProduits;
	private JLabel label_1;
	private JLabel lblComptabiliteGenerale;
	private JLabel label_2;

	/**
	 * Launch the application.
	 */
	/**public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Comptabilité frame = new Comptabilité();
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
	public Comptabilité() {
		setTitle("Comptabilite");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		cnx = ConnexionMySql.connexiondb();
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(10, 118, 365, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 47, 338, 181);
		panel.add(scrollPane);
		//table pour charge
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"charges", "montant"
			}
		));
		scrollPane.setViewportView(table);
		
		lblComptabiliteDesCharges = new JLabel("Comptabilite des charges");
		lblComptabiliteDesCharges.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblComptabiliteDesCharges.setForeground(Color.WHITE);
		lblComptabiliteDesCharges.setBounds(82, 11, 190, 25);
		panel.add(lblComptabiliteDesCharges);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(Comptabilité.class.getResource("/View/image/6284.jpg")));
		label.setBounds(0, 0, 365, 261);
		panel.add(label);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(414, 118, 360, 261);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 42, 340, 182);
		panel_1.add(scrollPane_1);
		/** 
		 * table de produit*/
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Produit", "Montant"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		lblComptabiliteDesProduits = new JLabel("Comptabilite des produits");
		lblComptabiliteDesProduits.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblComptabiliteDesProduits.setForeground(Color.WHITE);
		lblComptabiliteDesProduits.setBounds(90, 11, 172, 20);
		panel_1.add(lblComptabiliteDesProduits);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Comptabilité.class.getResource("/View/image/6284.jpg")));
		label_1.setBounds(0, 0, 360, 261);
		panel_1.add(label_1);
		
		btnAjouterCharge = new JButton("");
		btnAjouterCharge.setBackground(SystemColor.activeCaption);
		btnAjouterCharge.setIcon(new ImageIcon(Comptabilité.class.getResource("/View/image/moreover_insert_append_3929.png")));
		btnAjouterCharge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/** 
				 * page ajout charge*/
				AjoutCharge u = new AjoutCharge();
				u.setVisible(true);
			}
		});
		btnAjouterCharge.setBounds(10, 58, 52, 48);
		contentPane.add(btnAjouterCharge);
		
		btnAjouterProduit = new JButton("");
		btnAjouterProduit.setBackground(SystemColor.activeCaption);
		btnAjouterProduit.setIcon(new ImageIcon(Comptabilité.class.getResource("/View/image/moreover_insert_append_3929.png")));
		btnAjouterProduit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 *  page ajout produit*/
				AjoutProduit y = new AjoutProduit();
				y.setVisible(true);
			}
		});
		btnAjouterProduit.setBounds(414, 58, 52, 49);
		contentPane.add(btnAjouterProduit);
		
		btnActualiser = new JButton("");
		btnActualiser.setBackground(SystemColor.activeCaption);
		btnActualiser.setIcon(new ImageIcon(Comptabilité.class.getResource("/View/image/1491313940-repeat_82991 (1).png")));
		btnActualiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateTable();
			}
		});
		btnActualiser.setBounds(323, 67, 52, 40);
		contentPane.add(btnActualiser);
		
		btnNewButton = new JButton("");
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setIcon(new ImageIcon(Comptabilité.class.getResource("/View/image/1491313940-repeat_82991 (1).png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTable();
			}
		});
		btnNewButton.setBounds(722, 67, 52, 40);
		contentPane.add(btnNewButton);
		
		lblComptabiliteGenerale = new JLabel("Comptabilite Generale");
		lblComptabiliteGenerale.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblComptabiliteGenerale.setForeground(Color.WHITE);
		lblComptabiliteGenerale.setBounds(211, 21, 388, 26);
		contentPane.add(lblComptabiliteGenerale);
		
		label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Comptabilité.class.getResource("/View/image/business_salesreport_salesreport_negocio_2353.png")));
		label_2.setBounds(138, 11, 72, 58);
		contentPane.add(label_2);
	}
	public void UpdateTable() {
		String sql = "select * from comptabilité";
		try {
			prepared = cnx.prepareStatement(sql);
			resultat = prepared.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(resultat));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void updateTable() {
		String sql = "select * from comptaProduit";
		try {
			prepared = cnx.prepareStatement(sql);
			resultat = prepared.executeQuery();
			table_1.setModel(DbUtils.resultSetToTableModel(resultat));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
