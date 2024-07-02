package hotelReservation.dto.goods;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Type {
	private String tcode;
	private String tname;
	private int max;
	private int tprice;
	private int amounts;
	//private String tpicture;
	private String hid;
	
	
	public Type() {}
	public Type(String tcode, String tname, int max, 
			int tprice, int amounts, String hid) {
		this.tcode = tcode;
		this.tname = tname;
		this.max = max;
		this.tprice = tprice;
		this.amounts = amounts;
		this.hid = hid;
	}
	
	@Override
	public String toString() {
		return "Type [tcode=" + tcode + ", tname=" + tname + ", max=" + max + ", tprice=" + tprice + ", amounts="
				+ amounts + ", hid=" + hid + "]";
	}
	
	
}