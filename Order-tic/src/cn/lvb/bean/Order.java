package cn.lvb.bean;

import java.sql.Date;

public class Order {
	private int id;
	private Date createtime;
	private Date usetime;
	private double price;
	private String state;
	private int tid;
	private int spotid;
	public Order() {
		super();
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the createtime
	 */
	public Date getCreatetime() {
		return createtime;
	}
	/**
	 * @param createtime the createtime to set
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	/**
	 * @return the usetime
	 */
	public Date getUsetime() {
		return usetime;
	}
	/**
	 * @param usetime the usetime to set
	 */
	public void setUsetime(Date usetime) {
		this.usetime = usetime;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the tid
	 */
	public int getTid() {
		return tid;
	}
	/**
	 * @param tid the tid to set
	 */
	public void setTid(int tid) {
		this.tid = tid;
	}
	/**
	 * @return the spotid
	 */
	public int getSpotid() {
		return spotid;
	}
	/**
	 * @param spotid the spotid to set
	 */
	public void setSpotid(int spotid) {
		this.spotid = spotid;
	}
	
	
	
}
