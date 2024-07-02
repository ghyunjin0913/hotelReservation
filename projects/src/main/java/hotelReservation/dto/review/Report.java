package hotelReservation.dto.review;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Report {
 
	private String rpno;
	private String rid;
	private String type;
	private String id;
	private String status;
	private String rpdate;
	private String reason;
	private String answer;
	
	public Report() {
		rpno = null;
		rid = null;
		type= null;
		id= null;
		status = "신고 처리 중입니다.";
		rpdate=null;
		reason=null;
		answer="N";
	}

	public Report(String rpno, String rid, String type, String id, String status, String rpdate, String reason) {
		this.rpno = rpno;
		this.rid = rid;
		this.type = type;
		this.id = id;
		this.status = status;
		this.rpdate = rpdate;
		this.reason = reason;
		this.answer = "N";
	}

}
