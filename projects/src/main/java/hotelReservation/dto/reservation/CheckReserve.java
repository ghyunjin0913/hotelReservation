package hotelReservation.dto.reservation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CheckReserve {
	private int max;
	private String checkIn;
	private String checkOut;
	private String tcode;
	
}
