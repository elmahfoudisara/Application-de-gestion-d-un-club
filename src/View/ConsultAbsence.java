package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ConnexionMySql;
import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Window.Type;

public class ConsultAbsence extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Connection cnx = null;
	PreparedStatement prepared = null;
	ResultSet resultat = null;
	private JLabel lblAbsence;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	/**public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultAbsence frame = new ConsultAbsence();
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
	public ConsultAbsence() {
		setType(Type.UTILITY);
		setTitle("Consulter Absence");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		cnx = ConnexionMySql.connexiondb();
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 117, 731, 333);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnActualiser = new JButton("");
		btnActualiser.setBackground(SystemColor.activeCaption);
		btnActualiser.setIcon(new ImageIcon(ConsultAbsence.class.getResource("/View/image/one-finger-click-black-hand-symbol_icon-icons.com_64350.png")));
		btnActualiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * @param sql recuperer depuis absence*/
				String sql ="select*from abscence";
				try {
					prepared = cnx.prepareStatement(sql);
					resultat = prepared.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(resultat));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		btnActualiser.setBounds(28, 60, 49, 51);
		contentPane.add(btnActualiser);
		
		lblAbsence = new JLabel("Absence");
		lblAbsence.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblAbsence.setForeground(Color.WHITE);
		lblAbsence.setBounds(630, 36, 106, 29);
		contentPane.add(lblAbsence);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(ConsultAbsence.class.getResource("/View/image/business_table_order_report_history_2332.png")));
		label.setBounds(555, 25, 65, 61);
		contentPane.add(label);
	}

}
