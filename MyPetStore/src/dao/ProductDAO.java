package dao;

import java.util.ArrayList;
import java.sql.*;
import domain.Product;

public class ProductDAO {
	//ArrayList<Product> allProduct;
	
	public ArrayList<Product> getAll()
	{
		ArrayList<Product> allProduct = new ArrayList<Product>();
		try(
				Connection conn = SQLAccess.getConncetion();
				Statement stmt = conn.createStatement();
				ResultSet rst = stmt.executeQuery("SELECT * FROM PRODUCT");
			)
		{
			while(rst.next())
			{
				Product temp = new Product();
				temp.setProductid(rst.getString("productid"));
				temp.setCategory(rst.getString("category"));
				temp.setCName(rst.getString("cName"));
				temp.setDescription(rst.getString("descn"));
				temp.setEName(rst.getString("eName"));
				temp.setListPrice(rst.getFloat("listPrice"));
				temp.setUnitCost(rst.getFloat("unitCost"));
				allProduct.add(temp);
			}
			return allProduct;
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
		return allProduct;
		
	}
}
