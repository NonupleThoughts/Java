package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import domain.Order;

public class OrderDAO {
	
	public boolean insert(ArrayList<Order> data)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		//ResultSet rst = null;
		try
		{
			conn = SQLAccess.getConncetion();
			pstmt = conn.prepareStatement("INSERT INTO ORDERS (ORDERID, USERID, ORDERDATE, STATUS, AMOUNT) "
			+ "VALUES"
			+ " (?,?,?,?,?)");
			for(int i = 0; i < data.size(); i += 1)
			{
				pstmt.setLong(1, data.get(i).getOrderid());
				pstmt.setString(2, data.get(i).getUseid());
				Date date = data.get(i).getorderDate();
				pstmt.setTimestamp(3, new java.sql.Timestamp(date.getTime()));
				pstmt.setInt(4, data.get(i).getStatus());
				pstmt.setDouble(5, data.get(i).getAmount());
				pstmt.executeUpdate();
				System.out.printf("插入第%d条数据\n", i + 1);
			}

			System.out.println("数据插入完毕");
			return true;
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				conn.close();
			}catch(SQLException e) {}
			try
			{
				pstmt.close();
			}catch(SQLException e) {}			
			
		}
		return false;
	}
	public ArrayList<Order> getByUserid(String userid)
	{
		//Order data = new Order();
		ArrayList<Order> data = new ArrayList<Order>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		try
		{
			conn = SQLAccess.getConncetion();
			pstmt = conn.prepareStatement("SELECT * FROM ORDERS WHERE USERID = ?");
			pstmt.setString(1, userid);
			rst = pstmt.executeQuery();
			while(rst.next())
			{
				Order temp = new Order();
				temp.setOrderid(rst.getLong("orderid"));
				temp.setUseid(rst.getString("userid"));
				temp.setOrderDate(rst.getDate("orderDate"));
				temp.setStatus(rst.getInt("status"));
				temp.setAmount(rst.getDouble("amount"));
				data.add(temp);
			}
			return data;
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				conn.close();
			}catch(SQLException e) {}
			try
			{
				pstmt.close();
			}catch(SQLException e) {}
			try
			{
				rst.close();
			}catch(SQLException e) {}
		}
		return null;
	}

//	public static void main(String args[])
//	{
//		OrderDAO temp = new OrderDAO();
//		Order temp1 = new Order();
//		temp1.setOrderid(1234);
//		temp1.setUseid("dasdas");
//		Date time = new Date();
//		temp1.setOrderDate(time);
//		temp1.setStatus(0);
//		temp1.setAmount(103213.3);
//		ArrayList<Order> temp2 = new ArrayList<Order>();
//		temp2.add(temp1);
//		Order temp3 = new Order();
//		temp3.setOrderid(5678);
//		temp3.setUseid("dasda2s");
//		temp3.setOrderDate(time);
//		temp3.setStatus(1);
//		temp3.setAmount(203213.3);
//		temp2.add(temp3);
//		temp.insert(temp2);
///*
//		System.out.println(temp2.get(0).getOrderid());
//		System.out.println(temp2.get(1).getOrderid());
//		
//		System.out.print(temp2.size());
//		*/
//	}
}
