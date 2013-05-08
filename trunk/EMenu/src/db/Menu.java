package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Menu {
	
	
	private int menuNo;
	private int tableNo;
	private int totalPrice;
	private int state;
	
	public Menu(){};
	
	public Menu(int menuNo,int tableNo,int totalPrice,int state)
	{
		this.menuNo=menuNo;
		this.tableNo=tableNo;
		this.totalPrice=totalPrice;
		this.state=state;
	}
	
	public boolean createMenu(int tableNo)//����һ���˵�
	{
		boolean res = false;
		DBConn dbConn = new DBConn();
		String sql="call menu.insert_dish('"+tableNo+"')";
		try {
			res =dbConn.stmtStatement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print("insert into dish failed");
		}
		dbConn.close();
		return res;
	}
	
	public boolean countPrice(int menuNo)//����˵��ܼ�
	{
		boolean total = false;
		DBConn dbConn = new DBConn();
		String sql="call menu.count_price('"+menuNo+"')";
		try {
			total =dbConn.stmtStatement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print("update failed");
		}
		dbConn.close();
		return total;
	}
	
	public void viewTotalPrice(int menuNo)//��ѯ�˵��ܼ�
	{
		DBConn dbConn = new DBConn();
		String sql="select totalPrice from emenu.menu where id="+menuNo;
		ResultSet res;
		int n;
		try {
			res=dbConn.stmtStatement.executeQuery(sql);
			while(res.next()){
			n=res.getInt("totalPrice");
			System.out.print(n);
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
			System.out.print("select failed");
		}
	}
	
	public void selectMenu(int menuNo)//���ݲ˵����кŲ�ѯ��һ���˵�
	{
		DBConn dbConn = new DBConn();
		String sql="select * from emenu.menu where id="+menuNo;
		ResultSet res;
		Menu m;
		try {
			res=dbConn.stmtStatement.executeQuery(sql);
			while(res.next()){
				m=new Menu(res.getInt("id"),res.getInt("tableNo"),res.getInt("totalPrice"),res.getInt("state"));
				m.printMenu();
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
			System.out.print("select failed");
		}
	}
	
	public void printMenu(Menu m)//��Ҫ�����������ӡ���˵������ݣ�����ʱʹ��
	{
		System.out.print("id:"+m.menuNo);
		System.out.print("table:"+m.tableNo);
		System.out.print("totalPrice:"+m.totalPrice);
		System.out.print("state:"+m.state);
	}
	
	
	public void printMenu()//��ӡ���˵������ݣ�����ʱʹ��
	{
		System.out.print("id: "+this.menuNo+'\n');
		System.out.print("table:"+this.tableNo+'\n');
		System.out.print("totalPrice:"+this.totalPrice+'\n');
		System.out.print("state:"+this.state+'\n');
	}
}



