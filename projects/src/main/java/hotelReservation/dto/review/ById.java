package hotelReservation.dto.review;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ById {

	private String type;
	private String id;
	private String answer;

	public ById() {
		
		type="";
		id="";
		answer="N";
	}
}
