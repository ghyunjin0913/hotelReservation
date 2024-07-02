package hotelReservation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpMyInfo {

	private String eid;
	private String ename;
	private String email;
	private String ephone;
	private int dno;
	private String position;
	private String status;
	private String joinDate;
	private String retireDate;
	
	public EmpMyInfo() {
		
	}
	
	public EmpMyInfo(String email, int dno, String position, String status, String retireDate) {
		this.email = email;
		this.dno = dno;
		this.position = position;
		this.status = status;
		this.retireDate = retireDate;
	}

}