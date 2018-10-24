package ui;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import dao.*;
import domain.*;

public class ui {
	public static void main(String[] args)
	{
		//嗯，使用命令行作为输入
		AccountDAO accountDao = new AccountDAO();
		Scanner sc = new Scanner(System.in);
		String userid = null;
		String password = null;
		//long，也是用%d
		//long cou231 = 11111;
		//System.out.printf("%ld",cou231);
		while(true)
		{
			System.out.println("请输入用户名");
			userid = sc.nextLine();
			System.out.println("请输入密码");
			password = sc.nextLine();		
			
			if(!accountDao.findByUserId(userid, password))
				System.out.println("用户名或者密码错误，请重新输入");
			else
				break;
		}
		ProductDAO productDao = new ProductDAO();
		ArrayList<Product> allProduct = productDao.getAll();
		System.out.printf("");
		int i = 1;
		for(Product temp : allProduct)
		{
			System.out.print(i);
			System.out.printf("\t%s\t%s\t%s\t%s\t\t%s\t%f\t%f\t\n",temp.getProductid(),temp.getCategory(), temp.getCName(), temp.getDescription(), temp.getEName(), temp.getListPrice(), temp.getUnitCost());
			i += 1;
		}
		ArrayList<Integer> id = new ArrayList<Integer>();
		ArrayList<Integer> num = new ArrayList<Integer>();
		System.out.println("请输入要买的产品");
		id.add(sc.nextInt() - 1);
		System.out.println("请输入要买的产品的数量");
		num.add(sc.nextInt());
		System.out.println("请输入要买的产品");
		id.add(sc.nextInt() - 1);
		System.out.println("请输入要买的产品的数量");
		num.add(sc.nextInt());
		Date now = new Date();
		long orderId = now.getTime();
		ArrayList<Order> data = new ArrayList<Order>();
		Order temp = new Order();
		double amount = 0.0;
		for(int i1 = 0; i1 < num.size(); i1 += 1)
		{
			amount += num.get(i1) * id.get(i1);
		}
		temp.setAmount(amount);
		temp.setOrderDate(now);
		temp.setOrderid(orderId);
		temp.setStatus(1);
		temp.setUseid(userid);
		data.add(temp);
		
		ArrayList<OrderDetail> dataDetail = new ArrayList<OrderDetail>();
		for(int i1 = 0; i1 < num.size(); i1 += 1)
		{
			OrderDetail tmp = new OrderDetail();
			tmp.setOrderid(orderId);
			tmp.setProductid(allProduct.get(id.get(i1)).getProductid());
			tmp.setQuantity(num.get(i1));
			tmp.setUnitCost(allProduct.get(id.get(i1)).getUnitCost());
			dataDetail.add(tmp);
		}
		System.out.println("1231");
		OrderDAO orderDao = new OrderDAO();
		OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
		orderDao.insert(data);
		System.out.println("213");
		orderDetailDAO.insert(dataDetail);
		
		
		ArrayList<Order> getorder = orderDao.getByUserid(userid);
		OrderDetail getdetail = orderDetailDAO.findByOrderid(orderId, allProduct.get(id.get(0)).getProductid());
		for(int i1 = 0; i1 < getorder.size(); i1 += 1)
		{
			System.out.printf("订单信息:\n%f\t%s\t%d\t%d\t%s\n", getorder.get(i1).getAmount(),getorder.get(i1).getorderDate().toString(),getorder.get(i1).getOrderid(),getorder.get(i1).getStatus(),getorder.get(i1).getUseid());	
		}
		System.out.printf("订单详细信息:\n%d\t%s\t%d\t%f\n", getdetail.getOrderid(),getdetail.getProductid(),getdetail.getQuantity(),getdetail.getUnitCost());
		
	}
}
