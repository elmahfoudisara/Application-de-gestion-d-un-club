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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Window.Type;
import java.awt.SystemColor;

public class Suppression extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	Connection cnx = null;
	PreparedStatement prepared = null;
	ResultSet resultat = null;
	private JButton btnActualiser;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel label;
	private JLabel lblGestion;
	private JLabel lblMembre;

	/**
	 * Launch the application.
	 */
	/**public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Suppression frame = new Suppression();
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
	public Suppression() {
		setTitle("Suppression");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		cnx = ConnexionMySql.connexiondb();
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCne = new JLabel("Abscence:");
		lblCne.setForeground(Color.WHITE);
		lblCne.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCne.setBounds(10, 278, 76, 14);
		contentPane.add(lblCne);
		
		textField = new JTextField();
		textField.setBounds(94, 162, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(94, 218, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(96, 277, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnValider = new JButton("");
		btnValider.setBackground(SystemColor.windowBorder);
		btnValider.setIcon(new ImageIcon(Suppression.class.getResource("/View/image/delete_delete_deleteusers_delete_male_user_maleclient_2348 (1).png")));
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/** Pour faire un essai
				@param 		sql suppression du membre;re**/
				String sql = "delete *from membre where id_membre=? and nom=?";
				try {
					prepared = cnx.prepareStatement(sql);
					prepared.setString(1, textField.getText().toString());
					prepared.setString(2, textField_1.getText().toString());
					prepared.execute();
					JOptionPane.showMessageDialog(null, "user supprimé");
					textField.setText("");
					textField_1.setText("");
	
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnValider.setBounds(94, 337, 56, 47);
		contentPane.add(btnValider);
		
		JLabel lblLogin = new JLabel("CNE:");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLogin.setBounds(25, 163, 46, 14);
		contentPane.add(lblLogin);
		
		JLabel lblPassword = new JLabel("Nom:");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(25, 219, 46, 14);
		contentPane.add(lblPassword);
		
		btnActualiser = new JButton("");
		btnActualiser.setBackground(SystemColor.activeCaption);
		btnActualiser.setIcon(new ImageIcon(Suppression.class.getResource("/View/image/1491313940-repeat_82991 (1).png")));
		btnActualiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateTable();
			}
		});
		
		lblGestion = new JLabel("Gestion");
		lblGestion.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblGestion.setForeground(Color.WHITE);
		lblGestion.setBounds(37, 56, 100, 30);
		contentPane.add(lblGestion);
		
		lblMembre = new JLabel("Membre");
		lblMembre.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblMembre.setForeground(Color.WHITE);
		lblMembre.setBounds(75, 97, 105, 38);
		contentPane.add(lblMembre);
		btnActualiser.setBounds(718, 47, 56, 38);
		contentPane.add(btnActualiser);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(248, 96, 526, 317);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(Suppression.class.getResource("/View/image/6284.jpg")));
		label.setBounds(0, 0, 228, 461);
		contentPane.add(label);
	}
	public void UpdateTable() {
		/** Parameter sql recuperer valeurs membre**/
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
