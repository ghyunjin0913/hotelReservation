package hotelReservation.dto;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpLogIn {
	
	private String eid;
	private String epw;
	
	
	public EmpLogIn() {}
	public EmpLogIn(String eid, String epw) {
		this.eid = eid;
		this.epw = epw;
	}
	
}
