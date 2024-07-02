package hotelReservation.dto.review;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewList {
	private String cname;
	private String rdate;
	private int rating;
	private String rcomment;
	private String answer;
	private String rid;
	
	public ReviewList() {}

	@Override
	public String toString() {
		return "ReviewList [cname=" + cname + ", rdate=" + rdate + ", rating=" + rating + ", rcomment=" + rcomment
				+ ", answer=" + answer + "]";
	}
	
	
}
