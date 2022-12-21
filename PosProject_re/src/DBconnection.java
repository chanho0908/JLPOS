
import com.mysql.cj.jdbc.Driver;
import java.sql.*;

public class DBconnection {
        private static Connection conn;

        public static Connection getConnection() throws ClassNotFoundException, SQLException {
                if(conn == null) {
                        String dbURL = "jdbc:mysql://localhost:3306/pos?autoReconnect=true&validationQuery=select 1"; // localhost:3306 => 컴퓨터에 설치된 MySql
                        String dbID = "root";
                        String dbPassword = "1234";

                        Class.forName("com.mysql.jdbc.Driver");
                        conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
                        if(conn == null) System.out.println("실패");
                }
                return conn;
        }
	
	
}