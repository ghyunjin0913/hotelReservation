package hotelReservation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Insertinquiry {

	private String idtype;
	private String id;
	private String title;
	private String contents;
	
	public Insertinquiry() {
		
	}
	
	public Insertinquiry(String idtype, String id, String title, String contents) {
		this.idtype = idtype;
		this.id = id;
		this.title = title;
		this.contents = contents;
	}
}
