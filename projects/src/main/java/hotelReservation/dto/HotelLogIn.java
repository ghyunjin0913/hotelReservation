package hotelReservation.dto;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class HotelLogIn {
	
	private String hid;
	private String hpw;
	
	
	public HotelLogIn() {}
	public HotelLogIn(String hid, String hpw) {
		this.hid = hid;
		this.hpw = hpw;
	}
	
}
