package hotelReservation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelSignUp {
	
	private String hid;
	private String hpw;
	private String hname;
	private String grade;
	private String location;
	private String hmail;
	private String hphone;
	
	
	public HotelSignUp() {}
	public HotelSignUp(String hid, String hpw, String hname,
			String grade, String location,String hmail, String hphone) {
		this.hid = hid;
		this.hpw = hpw;
		this.hname = hname;
		this.grade = grade;
		this.location = location;
		this.hmail = hmail;
		this.hphone = hphone;
	}
	
}