import java.sql.*;


import org.junit.Assert;
import org.junit.Test;

public class FrameTest {
	Connection conn = null;
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;
	static final String DB_URL = "jdbc:mysql://localhost/club";
	static final String USER = "root";
	static final String PASS = "";

	@Test
	public void test() throws SQLException {

		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		PreparedStatement ps = conn.prepareStatement(
				"insert into membre (id_membre,password,nom,prenom,email,login)"
						+ "VALUES(1, 'Test', 'junit', 'btrbtrbtrbtr', 'brb', 'btr', 'jki');\r\n" + 
						"");
		ps.executeUpdate();
	
		
		
		try {
			String sql = "select nom from membre where id_membre='1' ";
			pstm = con.prepareStatement(sql);
			
			rs = pstm.executeQuery();
			
			rs.close();
			pstm.close();
			while (rs.next()) {
				  String chaine = rs.getString("123");
				  System.out.println(chaine);
				  Assert.assertEquals("junit", rs.getString("1"));
				 
					
			}
		} catch (Exception e) {

		} finally {

			try {
				
				
				rs.close();
				pstm.close();

			} catch (Exception e) {

			}
		}
	

	}

}
