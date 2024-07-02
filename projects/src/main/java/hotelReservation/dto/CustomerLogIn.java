package hotelReservation.dto;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class CustomerLogIn {
	
	private String cid;
	private String cpw;
	
	public CustomerLogIn() {
		
	}
	public CustomerLogIn(String cid, String cpw) {
		this.cid = cid;
		this.cpw = cpw;
	}
}
