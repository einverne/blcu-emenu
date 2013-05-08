package db;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Course {
	private int courseNo;
	private int menuNo;
	private int dishNo;
	private int state;
	
	private int amount;
	private String name;
	private int price;
	
	public Course(){};
	
	public Course(int cn,int mn,int dn,int s)
	{
		this.courseNo=cn;
		this.menuNo=mn;
		this.dishNo=dn;
		this.state=s;
	}
	
	public Course(int cn,int mn,int dn,String n,int a,int p)
	{
		this.courseNo=cn;
		this.menuNo=mn;
		this.dishNo=dn;
		this.amount=a;
		this.name=n;
		this.price=p;
	}
	
	public boolean OrderACourse(int mn,int dn)//点一道菜，传入参数为菜单号和这道菜的编码
	{
		boolean res = false;
		DBConn dbConn = new DBConn();
		String sql="call emenu.insert_course("+mn+","+dn+")";
		try {
			res =dbConn.stmtStatement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print("insert into course failed");
		}
		dbConn.close();
		return res;
	}
	
	public void ListCourseByMenu(int mn)//利用菜单号列出这个菜单所有的菜
	{
		ResultSet res;
		DBConn dbConn = new DBConn();
		Course c;
		String sql="call emenu.View_Course("+mn+")";
		try {
			res =dbConn.stmtStatement.executeQuery(sql);
			while(res.next())
			{
				c=new Course(res.getInt("id"),res.getInt("idmenu"),res.getInt("iddish"),res.getString("name"),res.getInt("price"),res.getInt("num"));
				c.PrintCourseInDetail(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print("insert into course failed");
		}
		dbConn.close();
		
	}
	
	public void PrintCourse(Course c)
	{
		System.out.println("courseNo: "+c.courseNo);
		System.out.println("menuNo: "+c.menuNo);
		System.out.println("dishNo: "+c.dishNo);
		System.out.println("state: "+c.state);
	}
	
	public void PrintCourseInDetail(Course c)
	{
		System.out.println("courseNo: "+c.courseNo);
		System.out.println("menuNo: "+c.menuNo);
		System.out.println("dishNo: "+c.dishNo);
		System.out.println("amount: "+c.amount);
		System.out.println("name: "+c.name);
		System.out.println("price: "+c.price);
	}
	
	
	
	
}
	
