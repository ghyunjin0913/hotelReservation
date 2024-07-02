package hotelReservation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelInfo {

	private String hname;
	private String location;
	
	
	public HotelInfo(String hname, String location) {
		this.hname = hname;
		this.location = location;
	}
	
}