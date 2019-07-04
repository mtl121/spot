package cn.lvb.bean;

import java.sql.Date;

public class Order {
	private String id;
	private Date createtime;
	private Date usetime;
	private String price;
	private String state;
	private String phone;
	private String spotid;
	public Order() {
		super();
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
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
	public String getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
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
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the spotid
	 */
	public String getSpotid() {
		return spotid;
	}
	/**
	 * @param spotid the spotid to set
	 */
	public void setSpotid(String spotid) {
		this.spotid = spotid;
	}
	
	
}
