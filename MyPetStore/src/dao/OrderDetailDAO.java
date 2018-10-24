package dao;

import java.sql.*;
import java.util.ArrayList;
import domain.OrderDetail;

public class OrderDetailDAO {
	
	public boolean insert(ArrayList<OrderDetail> data)
	{
		System.out.println("helloworld");
		Connection conn = null;
		PreparedStatement pstmt = null;
		try
		{
			conn = SQLAccess.getConncetion();
			pstmt = conn.prepareStatement("INSERT INTO ORDERSDETAIL (ORDERID, PRODUCTID, QUANTITY, UNITCOST) "
					+ "VALUES"
					+ " (?,?,?,?)");
			for(int i = 0; i < data.size(); i += 1)
			{
				pstmt.setLong(1, data.get(i).getOrderid());
				pstmt.setString(2, data.get(i).getProductid());
				pstmt.setInt(3, data.get(i).getQuantity());
				pstmt.setDouble(4, data.get(i).getUnitCost());
				pstmt.executeUpdate();
				System.out.printf("插入第%d条数据\n", i + 1);
			}
			System.out.println("数据插入完毕");
			return true;
		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally
		{
			try
			{
				conn.close();
			}catch(SQLException e){}
			try
			{
				pstmt.close();
			}catch(SQLException e) {}
		}
		return false;
	}
	public OrderDetail findByOrderid(long orderid, String productid)
	{
		OrderDetail data = new OrderDetail();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		try
		{
			conn = SQLAccess.getConncetion();
			pstmt = conn.prepareStatement("SELECT * FROM ORDERSDETAIL "
					+ "WHERE ORDERID = ? AND PRODUCTID = ?");
			pstmt.setLong(1, orderid);
			pstmt.setString(2, productid);
			rst = pstmt.executeQuery();
			
			while(rst.next())
			{
				data.setOrderid(rst.getLong("orderid"));
				data.setProductid(rst.getString("productid"));
				data.setQuantity(rst.getInt("quantity"));
				data.setUnitCost(rst.getDouble("unitcost"));
				return data;
			}
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally
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
}
