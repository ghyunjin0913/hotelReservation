package hotelReservation.dto.reservation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rsvno {

	private String rsvno;
	private String cid;
	private String rid;
	private String chargedate;
	
	
	public Rsvno(String rsvno, String cid, String rid, String chargedate) {
		this.rsvno = rsvno;
		this.cid = cid;
		this.rid = rid;
		this.chargedate = chargedate;
	}
	
}
