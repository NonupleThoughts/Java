package dao;

import java.sql.*;

public class SQLAccess {
	private final static String url  = "jdbc:mysql://localhost:3306/petstore? useUnicode = true & characterEncoding = utf-8&useSSL = false&serverTimezone = GMT";
	private final static String driverClass = "com.mysql.cj.jdbc.Driver";
	private final static String user = "root";
	private final static String password = "1234";
	static Connection conn;
	
//	public SQLAccess()
    static
    {
		System.out.println("加载驱动类...");
		try
		{
			//Class.forName(className)
			Class.forName(driverClass);
			System.out.println("驱动类加载成功...");
		}catch(ClassNotFoundException e)
		{
			System.out.println("驱动类加载成功...");
//			return;
		}
	}
	public static Connection getConncetion()
	{
		System.out.println("连接数据库...");
		try
		{
            conn = DriverManager.getConnection(url,user,password);
            System.out.println("连接数据库成功...");
            return conn;
		}catch(SQLException e)
		{
			System.out.println("连接数据库失败...");
			e.printStackTrace();
			return null;
		}
	}
//	public void closeConnection()
//	{		
//        try
//        {
//            if(conn != null) conn.close();
//        }catch(SQLException e)
//        {
//            e.printStackTrace();
//        }
//	}
//	public static void main(String[] args)
//	{
////		Connection temp = SQLAccess.getConncetion();
////		SQLAccess temp;
//		Connection db = SQLAccess.getConncetion();
////		temp.closeConnection();
//		
//	}
}
