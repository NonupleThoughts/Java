package domain;

public class Product {
	
	private String productid;
	private String category;
	private String cName;
	private String eName;
	private String description;
	private float listPrice;
	private float unitCost;
	
	
	public void setProductid(String productid)
	{
		this.productid = productid;
	}
	public String getProductid()
	{
		return this.productid;
	}
	public void setCategory(String category)
	{
		this.category = category;
	}
	public String getCategory()
	{
		return this.category;
	}	
	public void setCName(String cName)
	{
		this.cName = cName;
	}
	public String getCName()
	{
		return this.cName;
	}
	public void setEName(String eName)
	{
		this.eName = eName;
	}
	public String getEName()
	{
		return this.eName;
	}	
	public void setDescription(String description)
	{
		this.description = description;
	}
	public String getDescription()
	{
		return this.description;
	}
	public void setListPrice(float listPrice)
	{
		this.listPrice = listPrice;
	}
	public float getListPrice()
	{
		return this.listPrice;
	}	
	public void setUnitCost(float unitCost)
	{
		this.unitCost = unitCost;
	}
	public float getUnitCost()
	{
		return this.unitCost;
	}
}
