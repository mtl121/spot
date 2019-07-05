package cn.lvb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import cn.lvb.bean.Estimate;
import cn.lvb.bean.Page;
import cn.lvb.dao.EstimateDAO;
import cn.lvb.dbutil.C3P0Util;
import cn.lvb.dbutil.JdbcUtil;

public class EstimateDAOImpl implements EstimateDAO {
	DataSource ds = C3P0Util.getDataSource();	
	QueryRunner qr = new QueryRunner(ds);
	
	//添加信息
	@Override
	public boolean add(Estimate estimate) {
		String sql = "insert into estimate(Esti_id,Esti_content,Esti_star, Spot_id, Tou_id)" + "values(?,?,?,?,?)";
		try {
			qr.update(sql,estimate.getEsti_id(),estimate.getEsti_content(),estimate.getEsti_star(),estimate.getSpot_id(),estimate.getTou_id());

		} catch (Exception e) {
			throw new RuntimeException(e);
		} 

		return false;
	}
	
	//删除信息
	@Override
	public boolean delete(int eid) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "delete from estimate where Esti_id=? ";

		try {
			System.out.println("*****" + eid);
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, eid);
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
	public boolean update(Estimate bean) {
		
		String sql = "update estimate set Esti_content=?," + "Esti_star=?,"+ "Spot_id=?,"  + "Tou_id=? where Esti_id=?";

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, bean.getEsti_content());
			stmt.setString(2, bean.getEsti_star());
			stmt.setInt(3, bean.getSpot_id());
			stmt.setInt(4, bean.getTou_id());			

			stmt.setInt(5, bean.getEsti_id());
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
		String sql = "select count(*) as idcount from estimate  ";

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
	public List<Estimate> getAll(Page page) {
		// TODO Auto-generated method stub

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select Esti_id, Esti_content, Esti_star, Spot_id,Tou_id from estimate limit ?, ? ";

		try {
			List<Estimate> list = new ArrayList<Estimate>();
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, page.getBeginIndex());
			stmt.setInt(2, page.getEveryPage());

			rs = stmt.executeQuery();

			// 5���������
			while (rs.next()) {
				Estimate bean = new Estimate();

				bean.setEsti_id(rs.getInt("Esti_id"));
				bean.setEsti_content(rs.getString("Esti_content"));
				bean.setEsti_star(rs.getString("Esti_star"));
				bean.setSpot_id(rs.getInt("Spot_id"));
				bean.setTou_id(rs.getInt("Tou_id"));
				
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
