package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.ConnexionMySql;

import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Window.Type;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;

public class GestionEvenement extends JFrame {

	private JPanel contentPane;
	private String s;
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
					GestionEvenement frame = new GestionEvenement();
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
	public GestionEvenement() {
		setTitle("Gestion Evenement");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		cnx = ConnexionMySql.connexiondb();
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(27, 62, 723, 172);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(1,1));
		
		JLabel lblNewLabel = new JLabel("");
		panel_1.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(27, 259, 723, 135);
		contentPane.add(textArea);
		
		JButton btnParccourir = new JButton("");
		btnParccourir.setBackground(SystemColor.activeCaption);
		btnParccourir.setIcon(new ImageIcon(GestionEvenement.class.getResource("/View/image/imageup_imagen_12892.png")));
		btnParccourir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/** 
				 * @param sql ajouter a evenement*/
				String sql = "insert into evenement (image,a_propos) values(?,?)";
				
				
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(""));
				FileNameExtensionFilter filter = new FileNameExtensionFilter(".*event","jpg","png","gif");
				fileChooser.addChoosableFileFilter(filter);
				int result = fileChooser.showSaveDialog(null);
				
				if(result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					
					String path = selectedFile.getAbsolutePath();
					ImageIcon myImage = new ImageIcon(path);
					Image img = myImage.getImage();
					Image newImage = img.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(),java.awt.Image.SCALE_SMOOTH);
					ImageIcon finalimg = new ImageIcon(newImage);
					lblNewLabel.setIcon(finalimg);
					s = path;
					
				}}
		});
		btnParccourir.setBounds(29, 11, 49, 52);
		contentPane.add(btnParccourir);
		
		JButton btnValider = new JButton("valider");
		btnValider.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "insert into evenement (image,a_propos) values(?,?)";
				
				try {
					prepared = cnx.prepareStatement(sql);
						InputStream imgg = new FileInputStream(new File(s));
						
						prepared.setString(2,textArea.getText().toString());
						
						prepared.setBlob(1, imgg);
						prepared.execute();
						
						JOptionPane.showMessageDialog(null, "evenement ajouté");
					
					
				} catch (SQLException | FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				
				
			
				}}
			
		});
		btnValider.setBounds(587, 405, 89, 23);
		contentPane.add(btnValider);
		
		JLabel lblEvenement = new JLabel("Evenement");
		lblEvenement.setForeground(Color.WHITE);
		lblEvenement.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblEvenement.setBounds(321, 26, 162, 25);
		contentPane.add(lblEvenement);
		
		JLabel lblAPropos = new JLabel("A Propos");
		lblAPropos.setForeground(Color.WHITE);
		lblAPropos.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblAPropos.setBackground(Color.WHITE);
		lblAPropos.setBounds(27, 245, 46, 14);
		contentPane.add(lblAPropos);
	}

}
