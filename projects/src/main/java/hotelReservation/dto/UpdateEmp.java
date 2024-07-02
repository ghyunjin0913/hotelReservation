package hotelReservation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateEmp {

	private String eid;
	private String email;
	private String ephone;
	
	public UpdateEmp() {}
	public UpdateEmp(String eid, String email, String ephone) {
		this.eid = eid;
		this.email = email;
		this.ephone = ephone;
	}
	
}