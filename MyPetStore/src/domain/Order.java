package domain;

import java.util.Date;

public class Order {
	
	private long orderid;
	private String useid;
	private Date orderDate;
	private int status;
	private double amount;
	
	
	public void setOrderid(long orderid)
	{
		this.orderid = orderid;
	}
	public long getOrderid()
	{
		return this.orderid;
	}
	public void setUseid(String useid)
	{
		this.useid = useid;
	}
	public String getUseid()
	{
		return this.useid;
	}
	public void setOrderDate(Date orderDate)
	{
		this.orderDate = orderDate;
	}
	public Date getorderDate()
	{
		return this.orderDate;
	}
	public void setStatus(int status)
	{
		this.status = status;
	}
	public int getStatus()
	{
		return this.status;
	}
	public void setAmount(double amount)
	{
		this.amount = amount;
	}
	public double getAmount()
	{
		return this.amount;
	}
}
