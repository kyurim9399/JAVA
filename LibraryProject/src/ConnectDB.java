


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USER = "scott";
	private static final String PASSWORD = "tiger";
	
	static Connection conn = null;
	
	private static ConnectDB mc = null; 

	private ConnectDB(){} 

	public static ConnectDB getInstance() {
		if(mc == null) mc = new ConnectDB();
		return mc;
	}

	public static Connection getConnection() {
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DBMS 연결 실패");
		}
		
		return conn;
	}
	
}
