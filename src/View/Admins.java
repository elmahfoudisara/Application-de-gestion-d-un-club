package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;



import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Window.Type;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.SystemColor;

public class Admins extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admins frame = new Admins();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Admins() {
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		setTitle("Page Admin");
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAjouterPersonne = new JButton("");
		btnAjouterPersonne.setBackground(Color.BLACK);
		btnAjouterPersonne.setIcon(new ImageIcon(Admins.class.getResource("/View/image/business_application_addmale_useradd_insert_add_user_client_2312 (2).png")));
		btnAjouterPersonne.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		btnAjouterPersonne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 *  page ajout*/
				Ajout D = new Ajout();
				D.setVisible(true);
				
			
		}});
		btnAjouterPersonne.setBounds(169, 126, 97, 87);
		contentPane.add(btnAjouterPersonne);
		
		JButton btnModifierPersonne = new JButton("");
		btnModifierPersonne.setBackground(Color.BLACK);
		btnModifierPersonne.setIcon(new ImageIcon(Admins.class.getResource("/View/image/businessapplication_edit_male_user_thepencil_theclient_negocio_2321.png")));
		btnModifierPersonne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/** 
				 * page modification*/
				Modifier e = new Modifier();
				e.setVisible(true);
			}
		});
		btnModifierPersonne.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		btnModifierPersonne.setBounds(347, 127, 97, 86);
		contentPane.add(btnModifierPersonne);
		
		JButton btnSupprimerPersonne = new JButton("");
		btnSupprimerPersonne.setBackground(Color.BLACK);
		btnSupprimerPersonne.setIcon(new ImageIcon(Admins.class.getResource("/View/image/delete_delete_deleteusers_delete_male_user_maleclient_2348.png")));
		btnSupprimerPersonne.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		btnSupprimerPersonne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/**
				 *  afficher fenetre de suppression*/
				Suppression a = new Suppression();
				a.setVisible(true);
			}
		});
		btnSupprimerPersonne.setBounds(522, 127, 97, 87);
		contentPane.add(btnSupprimerPersonne);
		
		JButton btnEvenement = new JButton("");
		btnEvenement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/** 
				 * page gestio evenement*/
				GestionEvenement h = new GestionEvenement();
				h.setVisible(true);
			}
		});
		btnEvenement.setBackground(Color.BLACK);
		btnEvenement.setIcon(new ImageIcon(Admins.class.getResource("/View/image/1486504340-calendar-date-event-month-schedule_81325.png")));
		btnEvenement.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		btnEvenement.setBounds(347, 363, 97, 87);
		contentPane.add(btnEvenement);
		
		JButton btnPv = new JButton("");
		btnPv.setBackground(Color.BLACK);
		btnPv.setIcon(new ImageIcon(Admins.class.getResource("/View/image/document_report_16751.png")));
		btnPv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pv r = new Pv();
				r.setVisible(true);
			}
		});
		btnPv.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		btnPv.setBounds(347, 245, 97, 86);
		contentPane.add(btnPv);
		
		JButton btnComptabilit = new JButton("");
		btnComptabilit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/** 
				 * page comptabilité*/
				Comptabilité o = new Comptabilité();
				o.setVisible(true);
			}
		});
		btnComptabilit.setBackground(Color.BLACK);
		btnComptabilit.setIcon(new ImageIcon(Admins.class.getResource("/View/image/business_salesreport_salesreport_negocio_2353.png")));
		btnComptabilit.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		btnComptabilit.setBounds(171, 245, 95, 86);
		contentPane.add(btnComptabilit);
		
		JButton btnAbsence = new JButton("");
		btnAbsence.setBackground(Color.BLACK);
		btnAbsence.setIcon(new ImageIcon(Admins.class.getResource("/View/image/business_table_order_report_history_2332.png")));
		btnAbsence.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/** 
				 * page absence*/
				Abscence z = new Abscence();
				z.setVisible(true);
			}
		});
		btnAbsence.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		btnAbsence.setBounds(524, 245, 95, 86);
		contentPane.add(btnAbsence);
		
		JLabel lblGestionDuClub = new JLabel("Gestion du Club");
		lblGestionDuClub.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblGestionDuClub.setBounds(264, 29, 274, 37);
		contentPane.add(lblGestionDuClub);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Admins.class.getResource("/View/image/Administrator_27017.png")));
		label_1.setBounds(168, 11, 73, 62);
		contentPane.add(label_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Admins.class.getResource("/View/image/james-peacock-312818-unsplash.jpg")));
		label.setBounds(0, 84, 784, 377);
		contentPane.add(label);
	}

}
