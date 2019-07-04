package cn.lvb.bean;


public class Orderdetail {
	private int id;
	private int Ticketid;
	private int num;
	private int Orderid;
	public Orderdetail() {
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
	 * @return the ticketid
	 */
	public int getTicketid() {
		return Ticketid;
	}
	/**
	 * @param ticketid the ticketid to set
	 */
	public void setTicketid(int ticketid) {
		Ticketid = ticketid;
	}
	/**
	 * @return the num
	 */
	public int getNum() {
		return num;
	}
	/**
	 * @param num the num to set
	 */
	public void setNum(int num) {
		this.num = num;
	}
	/**
	 * @return the orderid
	 */
	public int getOrderid() {
		return Orderid;
	}
	/**
	 * @param orderid the orderid to set
	 */
	public void setOrderid(int orderid) {
		Orderid = orderid;
	}
	
	
}
