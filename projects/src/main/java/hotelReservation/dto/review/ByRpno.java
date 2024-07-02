package hotelReservation.dto.review;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ByRpno {
	
	private String rpno;
	private String answer;
	
	public ByRpno() {
		rpno="";
		answer="N";
	}


}
