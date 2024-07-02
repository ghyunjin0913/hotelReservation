package hotelReservation.dto.reservation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReserveInfo {

	private String firstname;
	private String lastname;
	private String email;
	private String confirm;
	private String country;
	private String request;

}
