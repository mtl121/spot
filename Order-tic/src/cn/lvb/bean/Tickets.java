package cn.lvb.bean;

public class Tickets {
	private int id;
	private double price;
	private String name;
	private int spotid;
	
	public Tickets() {
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
