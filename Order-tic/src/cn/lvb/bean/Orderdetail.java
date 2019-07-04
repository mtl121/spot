package cn.lvb.bean;


public class Orderdetail {
	private String id;
	private String Ticketid;
	private String num;
	private String Orderid;
	public Orderdetail() {
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
	 * @return the ticketid
	 */
	public String getTicketid() {
		return Ticketid;
	}
	/**
	 * @param ticketid the ticketid to set
	 */
	public void setTicketid(String ticketid) {
		Ticketid = ticketid;
	}
	/**
	 * @return the num
	 */
	public String getNum() {
		return num;
	}
	/**
	 * @param num the num to set
	 */
	public void setNum(String num) {
		this.num = num;
	}
	/**
	 * @return the orderid
	 */
	public String getOrderid() {
		return Orderid;
	}
	/**
	 * @param orderid the orderid to set
	 */
	public void setOrderid(String orderid) {
		Orderid = orderid;
	}
	
}
