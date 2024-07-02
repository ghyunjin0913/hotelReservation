package hotelReservation.dto.goods;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Hotel {
	
	private String hid;
	private String hpw;
	private String hname;
	private String location;
	private String hmail;
	private String hphone;
	private int grade;
	private String hdate;
	
	
	public Hotel() {}
}
