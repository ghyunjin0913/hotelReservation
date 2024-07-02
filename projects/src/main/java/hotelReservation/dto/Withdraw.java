package hotelReservation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Withdraw {
	
	private String cid;
	private String expDate;
	private String reason;
	private String status;

	
	public Withdraw() {
		
	}
	
	public Withdraw(String cid, String reason) {
		this.cid = cid;
		this.reason = reason;
	}
}
