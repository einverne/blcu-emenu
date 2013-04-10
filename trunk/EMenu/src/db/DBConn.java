package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import sun.font.TrueTypeFont;

import com.sun.org.apache.regexp.internal.recompile;

/*
 * @version 1.0
 * @date 2013/03/17
 * 
 */
public class DBConn {

	private Connection connection = null; // ���ݿ�����
	private Statement stmtStatement = null; // ���ݿ���ʽ
	private ResultSet rsResultSet = null; // �����

	public DBConn() {
		String CLASSFORNAME = "com.mysql.jdbc.Driver";
		String SERVANDDB = "jdbc:mysql://127.0.0.1:3306/menu";
		String USER = "root";
		String PWD = "einverne";
		try {

			// ע������
			Class.forName(CLASSFORNAME);
			// ��ȡ���ݿ�����
			connection = DriverManager.getConnection(SERVANDDB, USER, PWD);

			// ��ȡ���ʽ
			stmtStatement = connection.createStatement();

			// System.out.print("success");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public boolean insertDish(Dish dish) {
		boolean res = false;
		String name = dish.getName();
		int type = dish.getType();
		int price = dish.getPrice();
		String comment = dish.getComment();
		boolean isNew = dish.getNew();
		boolean isRecommend = dish.getRecommend();

		String insertSQL = "insert into menu.���� values('HHHH','" + name + "',"
				+ Integer.toString(type)
				+ ",'"+comment+"',5.5,1,1,45,'/pic/1.jpg');";

		try {
			res = stmtStatement.execute(insertSQL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print("insert into dish failed");
		}

		return res;

	}

	public void close() {
		try {
			if (connection != null) {
				connection.close();
			}
			if (stmtStatement != null) {
				stmtStatement.close();
			}
			if (rsResultSet != null) {
				rsResultSet.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		DBConn dbConn = new DBConn();

//		dbConn.insertDish();

		dbConn.close();

	}
}
