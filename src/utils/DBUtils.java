package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	
    /**
     * 获取数据库连接
     * @return Connection对象
     */
    public static Connection getConnection(){
    	String dbUserName = "root"; // db username
    	String dbUserPasswd = "19991219"; // db password
    	String dbURL = "jdbc:mysql://localhost:3306/studentinfomanagement?useUnicode=true&characterEncoding=UTF8&zeroDateTimeBehavior=convertToNull&serverTimezone=Asia/Shanghai&useSSL=false";
    	Connection conn = null;
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		conn = (Connection) DriverManager.getConnection(dbURL,dbUserName,dbUserPasswd);
    	} catch (ClassNotFoundException | SQLException e) {
    		e.printStackTrace();
    	} 
    	return conn;
    }
    
    /**
     * 关闭数据库连接
     * @param conn Connection对象
     */
    public static void closeConnection(Connection conn) {
		//判断conn是否为空
    	if(conn != null){
    		try {
				conn.close();//关闭数据库连接
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
    	}
	}
}
