package cn.lvb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import cn.lvb.bean.Orderdetail;
import cn.lvb.bean.Page;
import cn.lvb.dao.OrderdetailDAO;
import cn.lvb.dbutil.C3P0Util;
import cn.lvb.dbutil.JdbcUtil;

public class OrderDAOImpl implements OrderdetailDAO {
	DataSource ds = C3P0Util.getDataSource();	
	QueryRunner qr = new QueryRunner(ds);
	
	//获取页数
	@Override
	public int getCount() {
		// TODO Auto-generated method stub

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		int count = 0;
		String sql = "select count(*) as idcount from orderdetail  ";

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
	public List<Orderdetail> getAll(Page page) {
		// TODO Auto-generated method stub

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select Detail_id,Ticket_id,Ticket_num, Order_id from orderdetail limit ?, ? ";

		try {
			List<Orderdetail> list = new ArrayList<Orderdetail>();
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, page.getBeginIndex());
			stmt.setInt(2, page.getEveryPage());

			rs = stmt.executeQuery();

			// 5���������
			while (rs.next()) {
				Orderdetail bean = new Orderdetail();

				bean.setId(rs.getString("Detail_id"));
				bean.setTicketid(rs.getString("Ticket_id"));
				bean.setTicketid(rs.getString("Ticket_num"));
				bean.setOrderid(rs.getString("Order_id"));
				
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
