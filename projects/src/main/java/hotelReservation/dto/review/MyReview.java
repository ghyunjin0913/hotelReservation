package hotelReservation.dto.review;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyReview {
	private String rid;
	private String hname;
	private String tname;
	private int person;
	private String checkin;
	private String checkout;
	private int tprice;
	private String cid;
	private String tcode;
	
	public MyReview() {}
}
