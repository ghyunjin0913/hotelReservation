package hotelReservation.dto.reservation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PayInfo {

	private String cardco;
	private String cardno;
	private String expiredate;
	private String cvcno;
	private int tprice;
	
	public PayInfo() {}

}
