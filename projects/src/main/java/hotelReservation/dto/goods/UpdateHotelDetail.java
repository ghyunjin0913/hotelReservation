package hotelReservation.dto.goods;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateHotelDetail {
	
	private String hid;
	private String location;
	private int grade;
	
	public UpdateHotelDetail() {}
	public UpdateHotelDetail(String hid, String location, int grade) {
		this.hid = hid;
		this.location = location;
		this.grade = grade;
	}
	
}
