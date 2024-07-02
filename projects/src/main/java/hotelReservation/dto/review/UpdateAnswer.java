package hotelReservation.dto.review;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateAnswer {
	private String answer;
	private String rid;
	
	public UpdateAnswer() {}

	@Override
	public String toString() {
		return "UpdateReview [answer=" + answer + ", rid=" + rid + "]";
	}
	
	
}
