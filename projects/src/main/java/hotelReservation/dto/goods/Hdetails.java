package hotelReservation.dto.goods;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Hdetails {
	private String hid;
	private int max;
	private String checkIn;
	private String checkOut;
	
	public Hdetails() {}
	public Hdetails(String checkIn, String checkOut, String hid, int max) {
		this.hid = hid;
		this.max = max;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	
}
