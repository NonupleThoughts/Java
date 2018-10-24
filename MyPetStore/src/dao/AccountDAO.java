package dao;

import java.sql.*;
//import java.util.Scanner;

import domain.Account;

public class AccountDAO {
	//Account account = null;
	public boolean findByUserId(String userid, String password)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		try
		{
			conn = SQLAccess.getConncetion();
			//Statement stmt = conn.createStatement();
			//ResultSet rst = stmt.executeQuery("SELECT * FROM ACCOUNT WHERE USERID = ?");
			pstmt = conn.prepareStatement("SELECT * FROM ACCOUNT WHERE USERID = ?");			
			pstmt.setString(1, userid);
			//rst = pstmt.executeUpdate();
			rst = pstmt.executeQuery();
			
			Account account = new Account();
			while(rst.next())
			{
				account.setUserid(rst.getString("userid"));
				account.setPassword(rst.getString("password"));
				account.setAddr(rst.getString("addr"));
				account.setCity(rst.getString("city"));
				account.setCountry(rst.getString("country"));
				account.setEmail(rst.getString("email"));
				account.setName(rst.getString("name"));
				account.setPhone(rst.getString("phone"));
			}
			//System.out.println("second");
			return true;
		}catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}finally
		{
			//System.out.println("first");
			try
			{
				conn.close();
			}catch(SQLException e){}
			try
			{
				pstmt.close();
			}catch(SQLException e){}
			try
			{
				rst.close();
			}catch(SQLException e){}
		}
	}
	public static void main(String[] args)
	{
		AccountDAO temp = new AccountDAO();
		System.out.println(temp.findByUserId("j2ee", "j2ee"));
	}
//	public static void main(String[] args)
//	{
//		AccountDAO temp = new AccountDAO();
//		Account account = new Account();
//		Scanner sc = new Scanner(System.in);
//		System.out.println("请输入用户名");
//		String userid = sc.nextLine();
//		System.out.println("请输入密码");
//		String password = sc.nextLine();		
//		
//		
//		account = temp.findByUserId(userid);
//
//		if(account == null)
//			System.out.println("no user");
//		else if(!account.getPassword().equals(password))
//		{
//			//System.out.println(account.getPassword());
//			System.out.println("wrong password");
//		}
//		else
//			System.out.println("get in");
//	}
}
