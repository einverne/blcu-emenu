package db;

public class Dish {
	private String name;
	private int type;
	private int price;
	private String comment;
	private String pic;
	
	private boolean isNew;
	private boolean isRecommend;
	
	public Dish() {
		// TODO Auto-generated constructor stub
	}
	
	public Dish(String name,int type,int price,String commment,String pic,boolean isNew,boolean isRecommend) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.type = type;
		this.price = price;
		this.comment = commment;
		this.pic = pic;
		this.isNew = isNew;
		this.isRecommend = isRecommend;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setType(int type) {
		this.type = type;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public void setPic(String pic) {
		this.pic = pic;
	}
	
	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}
	
	public void setRecommend(boolean isRecommend) {
		this.isRecommend = isRecommend;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getType() {
		return this.type;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public String getComment() {
		return this.comment;
	}
	
	public String getPic() {
		return this.pic;
	}
	
	public boolean getNew() {
		return this.isNew;
	}
	
	public boolean getRecommend() {
		return this.isRecommend;
	}
}
