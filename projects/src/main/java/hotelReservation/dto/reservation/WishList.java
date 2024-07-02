package hotelReservation.dto.reservation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WishList {

	private String cid;
	private String hid;
	private String tcode;
	private int tprice;
	
	public WishList() {	}
	public WishList(String cid, String hid, String tcode, int tprice) {
		super();
		this.cid = cid;
		this.hid = hid;
		this.tcode = tcode;
		this.tprice = tprice;
	}
	
	
}
