package hotelReservation.dto.review;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Prevent {
	
	String rid;
	String type;
	String id;
	
	public Prevent(){}
	public Prevent(String type, String id){
		this.type=type;
		this.id = id;
		this.rid= null;
	}

}
