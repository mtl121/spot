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

public class OrderDAOImpl implements OrderDAO {
	DataSource ds = C3P0Util.getDataSource();	
	QueryRunner qr = new QueryRunner(ds);
	
	//娣诲姞淇℃伅
	@Override
	public boolean add(Order order) {
		String sql = "insert into orders(Order_id,Order_createtime,Order_price, Order_usetime, Order_state,Tou_id,Spot_idi)" + "values(?,?,?,?,?,?,?)";
		try {
			qr.update(sql,order.getId(),order.getCreatetime(),order.getPrice(),order.getUsetime(),order.getState(),order.getTid(),order.getSpotid());

		} catch (Exception e) {
			throw new RuntimeException(e);
		} 

		return false;
	}
	
	//鍒犻櫎淇℃伅
	@Override
	public boolean delete(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "delete from orders where Order_id=? ";

		try {
			System.out.println("*****" + id);
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
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
	
	
	
	//淇敼淇℃伅
	@Override
	public boolean update(Order bean) {
		
		String sql = "update orders set Order_createtime=?,Order_price=?, Order_usetime=?, Order_state=?,Tou_id=?,Spot_idi=? where Order_id=?";

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);

			stmt.setDate(1, bean.getCreatetime());
			stmt.setDouble(2, bean.getPrice());
			stmt.setDate(3, bean.getUsetime());
			stmt.setString(4, bean.getState());			
			stmt.setInt(5, bean.getTid());
			stmt.setInt(6, bean.getSpotid());
			
			stmt.setInt(7, bean.getId());
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
	
	

	//鑾峰彇椤垫暟
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

			// 5锟斤拷锟斤拷锟斤拷锟斤拷锟�
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
	
	
	//鍒楀嚭鎵�鏈変俊鎭�
	@Override
	public List<Order> getAll(Page page) {
		// TODO Auto-generated method stub

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select Order_id,Order_createtime,Order_price, Order_usetime, Order_state,Tou_id,Spot_idi from orders limit ?, ? ";

		try {
			List<Order> list = new ArrayList<Order>();
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, page.getBeginIndex());
			stmt.setInt(2, page.getEveryPage());

			rs = stmt.executeQuery();

			// 5锟斤拷锟斤拷锟斤拷锟斤拷锟�
			while (rs.next()) {
				Order bean = new Order();

				bean.setId(rs.getInt("Order_id"));
				bean.setCreatetime(rs.getDate("Order_createtime"));
				bean.setPrice(rs.getDouble("Order_price"));
				bean.setUsetime(rs.getDate("Order_usetime"));
				bean.setState(rs.getString("Order_state"));
				bean.setTid(rs.getInt("Tou_id"));
				bean.setSpotid(rs.getInt("Spot_idi"));
				
				list.add(bean);
			}
			return list;

		} catch (Exception e) {
			throw new RuntimeException(e);

		} finally {
			JdbcUtil.release(rs, stmt, conn);
		}
	}
	
	public List<Order> getAllorder() {
		// TODO Auto-generated method stub

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select Order_id,Order_createtime,Order_price, Order_usetime, Order_state,Tou_id,Spot_idi from orders ";

		try {
			List<Order> list = new ArrayList<Order>();
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);

			rs = stmt.executeQuery();

			// 5锟斤拷锟斤拷锟斤拷锟斤拷锟�
			while (rs.next()) {
				Order bean = new Order();

				bean.setId(rs.getInt("Order_id"));
				bean.setCreatetime(rs.getDate("Order_createtime"));
				bean.setPrice(rs.getDouble("Order_price"));
				bean.setUsetime(rs.getDate("Order_usetime"));
				bean.setState(rs.getString("Order_state"));
				bean.setTid(rs.getInt("Tou_id"));
				bean.setSpotid(rs.getInt("Spot_idi"));
				
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
