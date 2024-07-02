package hotelReservation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateHotel {
	
	private String hid;
	private String hmail;
	private String hphone;
	
	public UpdateHotel() {}
	public UpdateHotel(String hid, String hmail, String hphone) {
		this.hid = hid;
		this.hmail = hmail;
		this.hphone = hphone;
	}

}