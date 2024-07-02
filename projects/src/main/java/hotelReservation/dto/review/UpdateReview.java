package hotelReservation.dto.review;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateReview {
	private int rating;
	private String rcomment;
	private String rid;
	
	public UpdateReview() {}
}
