package hotelReservation.dto.reservation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pay {

	private String pid;
	private String cardco;
	private String chargedate;
	private String expiredate;
	private long cardno;
	private int cvcno;
	private int price;
	private char cancel;
	
	
	public Pay() {}
	public Pay(String pid, String cardco, String chargedate, 
			String expiredate, long cardno, int cvcno, 
			int price, char cancel) {
		this.pid = pid;
		this.cardco = cardco;
		this.chargedate = chargedate;
		this.expiredate = expiredate;
		this.cardno = cardno;
		this.cvcno = cvcno;
		this.price = price;
		this.cancel = cancel;
	}

}