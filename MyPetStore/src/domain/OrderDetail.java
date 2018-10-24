package domain;

public class OrderDetail {
	private long orderid;
	private String productid;
	private int quantity;
	private double unitCost;
	
	
	public void setOrderid(long orderid)
	{
		this.orderid = orderid;
	}
	public long getOrderid()
	{
		return this.orderid;
	}
	public void setProductid(String productid)
	{
		this.productid = productid;
	}
	public String getProductid()
	{
		return this.productid;
	}
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	public int getQuantity()
	{
		return this.quantity;
	}
	public void setUnitCost(double unitCost)
	{
		this.unitCost = unitCost;
	}
	public double getUnitCost()
	{
		return this.unitCost;
	}	
}
