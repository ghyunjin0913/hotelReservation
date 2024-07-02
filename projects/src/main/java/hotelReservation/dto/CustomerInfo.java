package hotelReservation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerInfo {
	
	private String lastname;
	private String firstname;
	private String cmail;
	
	
	public CustomerInfo(String lastname, String firstname, String cmail) {
		this.lastname = lastname;
		this.firstname = firstname;
		this.cmail = cmail;
	}
	
}
