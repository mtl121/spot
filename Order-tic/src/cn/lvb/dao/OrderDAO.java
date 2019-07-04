package cn.lvb.dao;

import java.util.List;

import cn.lvb.bean.*;

public interface OrderDAO {
	
	public int getCount();//获取需要显示的所有记录
	public boolean add( Order bean  );
	public boolean delete(String  id);
	public boolean update(   Order bean );
	public List<Order> getAll(Page page);
	
}
