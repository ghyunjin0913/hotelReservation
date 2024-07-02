package hotelReservation.dto.reservation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateRid {

	private String country;
	private String rdate;


	public CreateRid(String country, String rdate) {
		this.country = country;
		this.rdate = rdate;
	}
	
}
