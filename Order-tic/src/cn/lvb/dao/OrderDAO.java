package cn.lvb.dao;

import java.util.List;

import cn.lvb.bean.*;

public interface OrderDAO {
	
	public int getCount();//鑾峰彇闇�瑕佹樉绀虹殑鎵�鏈夎褰�
	public boolean add( Order bean  );
	public boolean delete(int  id);
	public boolean update(   Order bean );
	public List<Order> getAll(Page page);
	public List<Order> getAllorder();
}
