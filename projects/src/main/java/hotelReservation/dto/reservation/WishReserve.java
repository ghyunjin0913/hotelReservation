package hotelReservation.dto.reservation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WishReserve {

	private String hname;
	private String tname;
	private int tprice;
	private int max;
}
