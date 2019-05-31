package controller;

import java.sql.*;
import javax.swing.*;

public class ConnexionMySql {
	Connection conn =null;
	public static Connection connexiondb() {
		try {
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/club","root","");
			return conn;
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
	}

}
