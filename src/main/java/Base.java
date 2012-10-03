//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//bbb
//public class Base {
//	{
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	private Connection con;
//	private Statement stmt;
//	
//	
//
//	public Base(String user, String pass) {
//		try {
//			con = DriverManager.getConnection(
//					"jdbc:mysql://localhost:3306/test", user, pass);
//			stmt = con.createStatement();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	public void createTable(){
//		try {
//			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS user (id INTEGER AUTO_INCREMENT primary key, Name VARCHAR(30), Pass VARCHAR(30))");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	public void updateTable(String name){
//		try {
//			stmt.executeUpdate("INSERT INTO user (Name, Pass) VALUES('paul', '1234')");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	public void getTable(){
//		try {
//			ResultSet rs = stmt.executeQuery("SELECT * FROM user");
//			while (rs.next()) {
//		        System.out.println(rs.getString("Name"));
//		    }
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	public void close(){
//		try {
//			stmt.close();
//			con.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	public static void main(String[] args) {
//		Base base = new Base("Base","1234");
////		base.createTable();
////		base.updateTable("NAMEEEE");
//		base.getTable();
//		base.close();
//	}
//}
