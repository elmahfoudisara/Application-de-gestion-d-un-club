package View;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import controller.ConnexionMySql;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Window.Type;

public class Users extends JFrame {

	private JPanel contentPane;
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
					Users frame = new Users();
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
	public Users() {
		setType(Type.UTILITY);
		setTitle("Membre");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		cnx = ConnexionMySql.connexiondb();
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEvenement = new JButton("");
		btnEvenement.setBackground(Color.BLACK);
		btnEvenement.setIcon(new ImageIcon(Users.class.getResource("/View/image/1486504340-calendar-date-event-month-schedule_81325.png")));
		btnEvenement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}});
		btnEvenement.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 13));
		btnEvenement.setBounds(150, 184, 75, 81);
		contentPane.add(btnEvenement);
		
		JButton btnPv = new JButton("");
		btnPv.setBackground(Color.BLACK);
		btnPv.setIcon(new ImageIcon(Users.class.getResource("/View/image/document_report_16751.png")));
		btnPv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Document doc = new Document();
				/** Parameter sql recuperer valeur pv**/
				String sql ="select*from pv";
				
					
				
				try {
                    prepared = cnx.prepareStatement(sql);
					resultat=prepared.executeQuery();
				/** creation du pdf**/
					PdfWriter.getInstance(doc,new FileOutputStream("C:\\Users\\zaydmami\\Desktop\\PVClub.pdf"));
					doc.open();
					doc.add(new Paragraph("Le PV du Club"));
					doc.add(new Paragraph("---------------"));
					
					Image img = Image.getInstance("C:\\Users\\zaydmami\\Pictures\\ensa.png");
					img.scaleAbsoluteHeight(92);
					img.scaleAbsoluteWidth(400);
					img.setAlignment(Image.ALIGN_CENTER);
					doc.add(img);
					doc.add(new Paragraph("Le PV du Club"));
					doc.add(new Paragraph("---------------"));
					
					PdfPTable table = new PdfPTable(6);
					table.setWidthPercentage(100);
					
					PdfPCell cell;
					cell = new PdfPCell(new Phrase("numero pv",FontFactory.getFont("Comis Sans MS",12)));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setBackgroundColor(BaseColor.GRAY);
					table.addCell(cell);
					
					cell = new PdfPCell(new Phrase("ordre du jour",FontFactory.getFont("Comis Sans MS",12)));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setBackgroundColor(BaseColor.GRAY);
					table.addCell(cell);
					
					cell = new PdfPCell(new Phrase("heure levee",FontFactory.getFont("Comis Sans MS",12)));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setBackgroundColor(BaseColor.GRAY);
					table.addCell(cell);
					
					cell = new PdfPCell(new Phrase("résumé",FontFactory.getFont("Comis Sans MS",12)));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setBackgroundColor(BaseColor.GRAY);
					table.addCell(cell);
					
					cell = new PdfPCell(new Phrase("signature",FontFactory.getFont("Comis Sans MS",12)));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setBackgroundColor(BaseColor.GRAY);
					table.addCell(cell);
					
					cell = new PdfPCell(new Phrase("AnimReunion",FontFactory.getFont("Comis Sans MS",12)));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setBackgroundColor(BaseColor.GRAY);
					table.addCell(cell);
					/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
					//////////////////////////////////////////////////////////////////////////////////////////////
					while(resultat.next()) {
						cell = new PdfPCell(new Phrase(resultat.getString("id_pv").toString(),FontFactory.getFont("Comis Sans MS",12)));
						cell.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell.setBackgroundColor(BaseColor.GRAY);
						table.addCell(cell);
						
						cell = new PdfPCell(new Phrase(resultat.getString("ordre_du_jour").toString(),FontFactory.getFont("Comis Sans MS",12)));
						cell.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell.setBackgroundColor(BaseColor.GRAY);
						table.addCell(cell);
						
						cell = new PdfPCell(new Phrase(resultat.getString("heure_levee").toString(),FontFactory.getFont("Comis Sans MS",12)));
						cell.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell.setBackgroundColor(BaseColor.GRAY);
						table.addCell(cell);
						
						cell = new PdfPCell(new Phrase(resultat.getString("resume").toString(),FontFactory.getFont("Comis Sans MS",12)));
						cell.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell.setBackgroundColor(BaseColor.GRAY);
						table.addCell(cell);
						
						cell = new PdfPCell(new Phrase(resultat.getString("signature").toString(),FontFactory.getFont("Comis Sans MS",12)));
						cell.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell.setBackgroundColor(BaseColor.GRAY);
						table.addCell(cell);
						
						cell = new PdfPCell(new Phrase(resultat.getString("AnimReunion").toString(),FontFactory.getFont("Comis Sans MS",12)));
						cell.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell.setBackgroundColor(BaseColor.GRAY);
						table.addCell(cell);
					}
					
					doc.add(table);
					doc.close();
					Desktop.getDesktop().open(new File("C:\\Users\\zaydmami\\Desktop\\PVClub.pdf"));
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (DocumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				
				
			}
		});
		btnPv.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 13));
		btnPv.setBounds(357, 195, 61, 70);
		contentPane.add(btnPv);
		
		JButton btnComptabilit = new JButton("");
		btnComptabilit.setBackground(Color.BLACK);
		btnComptabilit.setIcon(new ImageIcon(Users.class.getResource("/View/image/business_table_order_report_history_2332.png")));
		btnComptabilit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ConsultAbsence o = new ConsultAbsence();
				o.setVisible(true);
				
			}
		});
		btnComptabilit.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 13));
		btnComptabilit.setBounds(565, 195, 75, 70);
		contentPane.add(btnComptabilit);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Users.class.getResource("/View/image/james-peacock-312818-unsplash.jpg")));
		label.setBounds(0, 104, 784, 346);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Users.class.getResource("/View/image/Club_3D_Grafikcard_Tray_30781.png")));
		label_1.setBounds(216, 29, 80, 64);
		contentPane.add(label_1);
		
		JLabel lblClubEtudiant = new JLabel("Club Etudiant");
		lblClubEtudiant.setForeground(Color.WHITE);
		lblClubEtudiant.setBackground(Color.WHITE);
		lblClubEtudiant.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblClubEtudiant.setBounds(294, 40, 239, 40);
		contentPane.add(lblClubEtudiant);
	}
}
