package cn.lvb.dao;

import java.util.List;

import cn.lvb.bean.*;

public interface EstimateDAO {
	
	public int getCount();//获取需要显示的所有记录
	public boolean add( Estimate bean  );
	public boolean delete(String  tid);
	public boolean update(   Estimate bean );
	public List<Estimate> getAll(Page page);
	
}
