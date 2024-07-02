package hotelReservation.dto.goods;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Search {
	
	private String checkIn;
	private String checkOut;
	private int person;
	private String location;
	
	public Search() {}
	public Search( String checkIn, String checkOut, int person, String location) {

		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.person = person;
		this.location = location;
	}
	
}
