package cn.lvb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import cn.lvb.bean.Order;
import cn.lvb.bean.Page;
import cn.lvb.dao.OrderDAO;
import cn.lvb.dbutil.C3P0Util;
import cn.lvb.dbutil.JdbcUtil;

public class OrderdetailDAOImpl implements OrderDAO {
	DataSource ds = C3P0Util.getDataSource();	
	QueryRunner qr = new QueryRunner(ds);
	
	//添加信息
	@Override
	public boolean add(Order order) {
		String sql = "insert into orders(Order_id,Order_createtime,Order_price, Order_usetime, Order_state,Tou_ph,Spot_idi)" + "values(?,?,?,?,?,?,?)";
		try {
			qr.update(sql,order.getId(),order.getCreatetime(),order.getPrice(),order.getUsetime(),order.getState(),order.getPhone(),order.getSpotid());

		} catch (Exception e) {
			throw new RuntimeException(e);
		} 

		return false;
	}
	
	//删除信息
	@Override
	public boolean delete(String id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "delete from orders where Order_id=? ";

		try {
			System.out.println("*****" + id);
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			int rows = stmt.executeUpdate();

			if (rows > 0)
				return true;
			else
				return false;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.release(rs, stmt, conn);
		}
	}
	
	
	
	//修改信息
	@Override
	public boolean update(Order bean) {
		
		String sql = "update orders set Order_createtime=?,Order_price=?, Order_usetime=?, Order_state=?,Tou_ph=?,Spot_idi=? where Order_id=?";

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);

			stmt.setDate(1, bean.getCreatetime());
			stmt.setString(2, bean.getPrice());
			stmt.setDate(3, bean.getUsetime());
			stmt.setString(4, bean.getState());			
			stmt.setString(5, bean.getPhone());
			stmt.setString(6, bean.getSpotid());
			
			stmt.setString(7, bean.getId());
			int rows = stmt.executeUpdate();

			if (rows > 0)
				return true;

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.release(rs, stmt, conn);
		}
		return false;
	}
	
	

	//获取页数
	@Override
	public int getCount() {
		// TODO Auto-generated method stub

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		int count = 0;
		String sql = "select count(*) as idcount from orders  ";

		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);

			rs = stmt.executeQuery();

			// 5���������
			while (rs.next()) {
				count = rs.getInt("idcount");
			}
			return count;

		} catch (Exception e) {
			throw new RuntimeException(e);

		} finally {
			JdbcUtil.release(rs, stmt, conn);

		}

	}
	
	
	//列出所有信息
	@Override
	public List<Order> getAll(Page page) {
		// TODO Auto-generated method stub

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select Order_id,Order_createtime,Order_price, Order_usetime, Order_state,Tou_ph,Spot_idi from orders limit ?, ? ";

		try {
			List<Order> list = new ArrayList<Order>();
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, page.getBeginIndex());
			stmt.setInt(2, page.getEveryPage());

			rs = stmt.executeQuery();

			// 5���������
			while (rs.next()) {
				Order bean = new Order();

				bean.setId(rs.getString("Order_id"));
				bean.setCreatetime(rs.getDate("Order_createtime"));
				bean.setPrice(rs.getString("Order_price"));
				bean.setUsetime(rs.getDate("Order_usetime"));
				bean.setState(rs.getString("Order_state"));
				bean.setPhone(rs.getString("Tou_ph"));
				bean.setSpotid(rs.getString("Spot_idi"));
				
				list.add(bean);
			}
			return list;

		} catch (Exception e) {
			throw new RuntimeException(e);

		} finally {
			JdbcUtil.release(rs, stmt, conn);
		}
	}

}
