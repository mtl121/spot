package cn.lvb.dao;

import java.util.List;

import cn.lvb.bean.*;

public interface OrderdetailDAO {
	
	public int getCount();//获取需要显示的所有记录
	public List<Orderdetail> getAll(Page page);
	
}
