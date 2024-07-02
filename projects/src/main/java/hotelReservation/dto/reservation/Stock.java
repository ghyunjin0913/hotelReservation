package hotelReservation.dto.reservation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Stock {

	private String tcode;
	private String checkin;
	private String checkout;
	
	
	public Stock(String tcode, String checkin, String checkout) {
		this.tcode = tcode;
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
}
