package db;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Dish {
	private int id;
	private String name;
	private String type;
	private int price;
	private String intro;
	private String pic;
	private int isNew;
	private int isRecommend;
	
	public Dish() {
		// TODO Auto-generated constructor stub
	}
	
	public Dish(int id,String name,String type,String intro,int price,int isNew,int isRecommend,String pic) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.name = name;
		this.type = type;
		this.price = price;
		this.intro = intro;
		this.isNew = isNew;
		this.isRecommend = isRecommend;
		this.pic = pic;
	}
	
	public void selectDish(int id)
	{
		DBConn dbConn = new DBConn();
		String sql="select * from emenu.dish where id="+id;
		ResultSet res;
		Dish d;
		try {
			res=dbConn.stmtStatement.executeQuery(sql);
			while(res.next()){
				d=new Dish(res.getInt("id"),res.getString("name"),res.getString("type"),res.getString("intro"),res.getInt("price"),res.getInt("new"),res.getInt("rcmd"),res.getString("pic"));
				d.printDish();
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
			System.out.print("select failed");
		}
	}
	
	public void selectAll()
	{
		DBConn dbConn = new DBConn();
		String sql="select * from emenu.dish";
		ResultSet res;
		Dish d;
		try {
			res=dbConn.stmtStatement.executeQuery(sql);
			while(res.next()){
				d=new Dish(res.getInt("id"),res.getString("name"),res.getString("type"),res.getString("intro"),res.getInt("price"),res.getInt("new"),res.getInt("rcmd"),res.getString("pic"));
				d.printDish();
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
			System.out.print("select failed");
		}
	}
	
	public void printDish()
	{
		System.out.print("id: "+this.id+'\n');
		System.out.print("name:"+this.name+'\n');
		System.out.print("type:"+this.type+'\n');
		System.out.print("intro:"+this.intro+'\n');
		System.out.print("price:"+this.price+'\n');
		System.out.print("isNew:"+this.isNew+'\n');
		System.out.print("isRecommend:"+this.isRecommend+'\n');
		System.out.print("pic:"+this.pic+'\n');
	}
	
//	public boolean insertDish()
//	{
//		boolean res=false;
//		
//		return res;
//		
//	}
//	
//	public void setName(String name) {
//		this.name = name;
//	}
//	
//	public void setType(String type) {
//		this.type = type;
//	}
//	
//	public void setPrice(int price) {
//		this.price = price;
//	}
//	
//	public void setComment(String comment) {
//		this.intro = comment;
//	}
//	
//	public void setPic(String pic) {
//		this.pic = pic;
//	}
//	
//	public void setNew(int isNew) {
//		this.isNew = isNew;
//	}
//	
//	public void setRecommend(int isRecommend) {
//		this.isRecommend = isRecommend;
//	}
//	
//	public String getName() {
//		return this.name;
//	}
//	
//	public String getType() {
//		return this.type;
//	}
//	
//	public int getPrice() {
//		return this.price;
//	}
//	
//	public String getComment() {
//		return this.intro;
//	}
//	
//	public String getPic() {
//		return this.pic;
//	}
//	
//	public int getNew() {
//		return this.isNew;
//	}
//	
//	public int getRecommend() {
//		return this.isRecommend;
//	}
}
