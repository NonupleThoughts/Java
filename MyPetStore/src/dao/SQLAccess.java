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
		System.out.println("����������...");
		try
		{
			//Class.forName(className)
			Class.forName(driverClass);
			System.out.println("��������سɹ�...");
		}catch(ClassNotFoundException e)
		{
			System.out.println("��������سɹ�...");
//			return;
		}
	}
	public static Connection getConncetion()
	{
		System.out.println("�������ݿ�...");
		try
		{
            conn = DriverManager.getConnection(url,user,password);
            System.out.println("�������ݿ�ɹ�...");
            return conn;
		}catch(SQLException e)
		{
			System.out.println("�������ݿ�ʧ��...");
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
