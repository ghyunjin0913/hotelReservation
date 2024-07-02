package hotelReservation.dto.review;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Review {
	private String tcode;
	private String cid;
	private String rdate;
	private int rating;
	private String rcomment;
	private String answer;
	private String rid;
	private String display;
	public Review() {
		this.display = "Y";
	}

	@Override
	public String toString() {
		return "Review [tcode=" + tcode + ", cid=" + cid + ", rdate=" + rdate + ", rating=" + rating + ", rcomment="
				+ rcomment + ", answer=" + answer + ", rid=" + rid + "]";
	}

	
	
}
