package cn.lvb.bean;

public class Estimate {
	private int Esti_id;
	private String Esti_content;
	private String Esti_star;
	private int Tou_id;
	private int Spot_id;
	public Estimate() {
		super();
	}
	/**
	 * @return the esti_id
	 */
	public int getEsti_id() {
		return Esti_id;
	}
	/**
	 * @param esti_id the esti_id to set
	 */
	public void setEsti_id(int esti_id) {
		Esti_id = esti_id;
	}
	/**
	 * @return the esti_content
	 */
	public String getEsti_content() {
		return Esti_content;
	}
	/**
	 * @param esti_content the esti_content to set
	 */
	public void setEsti_content(String esti_content) {
		Esti_content = esti_content;
	}
	/**
	 * @return the esti_star
	 */
	public String getEsti_star() {
		return Esti_star;
	}
	/**
	 * @param esti_star the esti_star to set
	 */
	public void setEsti_star(String esti_star) {
		Esti_star = esti_star;
	}
	/**
	 * @return the tou_id
	 */
	public int getTou_id() {
		return Tou_id;
	}
	/**
	 * @param tou_id the tou_id to set
	 */
	public void setTou_id(int tou_id) {
		Tou_id = tou_id;
	}
	/**
	 * @return the spot_id
	 */
	public int getSpot_id() {
		return Spot_id;
	}
	/**
	 * @param spot_id the spot_id to set
	 */
	public void setSpot_id(int spot_id) {
		Spot_id = spot_id;
	}
	
}
