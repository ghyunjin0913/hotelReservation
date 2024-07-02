package hotelReservation.dto.reservation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CancelDibs {

	private String cid;
	private String tcode;
	
	public CancelDibs(String cid, String tcode) {
		super();
		this.cid = cid;
		this.tcode = tcode;
	}
	
}
