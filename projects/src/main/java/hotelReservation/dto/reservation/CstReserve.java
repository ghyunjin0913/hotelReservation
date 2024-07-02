package hotelReservation.dto.reservation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CstReserve {
	
	private String search; 
	private String cid;
	private String rid;
	private String mdate;
	private String rdate;
	
	public CstReserve() {}
	
}
