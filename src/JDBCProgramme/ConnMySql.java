package JDBCProgramme;

import java.sql.*;

public class ConnMySql {
    public static void main(String[] args) throws Exception {

        //加载数据库驱动，使用反射
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (
                //获取数据库的链接
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:3306/papersystem"
                        , "root", "password");
                //建立Statement对象
                Statement stmt = conn.createStatement();
                //执行SQL语句
                ResultSet rs = stmt.executeQuery("select * from paper")) {

            while (rs.next()) {
                System.out.println(rs.getInt(1) + "\t"
                        + rs.getString(2));
            }
        }
    }
}
