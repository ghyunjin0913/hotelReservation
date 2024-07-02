package hotelReservation.dto.review;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReportManage {

	private String status;
	private String type;
	private String id;
	private String rid;
	private String answer;
	
	ReportManage(){
		answer="Y";
	}
	
}
