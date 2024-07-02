package hotelReservation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCustomer {

	private String cid;
	private String cmail;
	private String cphone;
	
	public UpdateCustomer() {}
	public UpdateCustomer(String cid, String cmail, String cphone) {
		this.cid = cid;
		this.cmail = cmail;
		this.cphone = cphone;
	}
	
	
}
