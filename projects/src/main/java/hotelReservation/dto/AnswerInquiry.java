package hotelReservation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerInquiry {

	private int ino;
	private String answer;
	
	public AnswerInquiry() {
		
	}
	
	public AnswerInquiry(int ino, String answer) {
		this.ino = ino;
		this.answer = answer;
	}
}
