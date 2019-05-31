package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Window.Type;

/**
 * @author zaydmami
 *
 */
public class startup extends JFrame {

	private JPanel contentPane;
	private JButton btnSeConnecter;
	private JButton btnSinscrire;
	private JButton btnAide;
	private JLabel label;
	private JLabel lblApplication;
	private JLabel lblGestion;
	private JLabel lblClub;
	private JLabel label_1;

	/**
	 * Launch the application.
	 */
	public void fermer() {
		dispose();
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					startup frame = new startup();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	/** Classe inutile, juste <b>pour essayer</b>
    @author 	zayd mami
    @version 	mai 2019
*/
	
	public startup() {
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		setTitle("Application");
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnSeConnecter = new JButton("Se connecter");
		btnSeConnecter.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		btnSeConnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Seconnecter s = new Seconnecter();
				s.setVisible(true);
				fermer();
			}
		});
		btnSeConnecter.setBounds(289, 154, 215, 51);
		contentPane.add(btnSeConnecter);
		
		btnSinscrire = new JButton("S'inscrire");
		btnSinscrire.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		btnSinscrire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/** page d'authentification**/
				Sauthentifier s = new Sauthentifier();
				s.setVisible(true);
			}
		});
		btnSinscrire.setBounds(289, 254, 215, 51);
		contentPane.add(btnSinscrire);
		
		btnAide = new JButton("Aide?");
		btnAide.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 13));
		btnAide.setBounds(507, 21, 215, 51);
		contentPane.add(btnAide);
		
		lblApplication = new JLabel("Application");
		lblApplication.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblApplication.setForeground(Color.WHITE);
		lblApplication.setBounds(23, 148, 178, 48);
		contentPane.add(lblApplication);
		
		lblGestion = new JLabel("Gestion");
		lblGestion.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblGestion.setForeground(Color.WHITE);
		lblGestion.setBounds(54, 208, 134, 51);
		contentPane.add(lblGestion);
		
		lblClub = new JLabel("Club");
		lblClub.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblClub.setForeground(Color.WHITE);
		lblClub.setBounds(77, 285, 82, 41);
		contentPane.add(lblClub);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(startup.class.getResource("/View/image/Club_3D_Grafikcard_Tray_30781.png")));
		label_1.setBounds(10, 21, 71, 64);
		contentPane.add(label_1);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(startup.class.getResource("/View/image/6284.jpg")));
		label.setBounds(0, 0, 215, 461);
		contentPane.add(label);
	}

}
