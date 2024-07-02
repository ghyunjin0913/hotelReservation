package hotelReservation.dto.goods;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchHotel {
	
	private String hname;
	private String checkIn;
	private String checkOut;
	private int person;
	private String location;
	
	
	public SearchHotel() {
		hname=null;
	}
	
}
