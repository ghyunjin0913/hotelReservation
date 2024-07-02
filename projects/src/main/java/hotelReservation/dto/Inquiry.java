package hotelReservation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Inquiry {

	private int ino;
	private String idtype;
	private String id;
	private String title;
	private String contents;
	private String status;
	private String registerDate;
	private String answer;
	
	public Inquiry() {
		
	}
	
	public Inquiry(int ino, String title, String contents) {
		this.ino = ino;
		this.title = title;
		this.contents = contents;
	}
}
