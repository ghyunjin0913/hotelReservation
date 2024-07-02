package hotelReservation.dto.reservation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePid {

	private String cardco;
	private String chargedate;
	
	public CreatePid(String cardco, String chargedate) {
		this.cardco = cardco;
		this.chargedate = chargedate;
	}
	


}
