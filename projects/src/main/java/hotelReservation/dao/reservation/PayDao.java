package hotelReservation.dao.reservation;

import hotelReservation.dto.CustomerLogIn;
import hotelReservation.dto.HotelInfo;
import hotelReservation.dto.reservation.CreatePid;
import hotelReservation.dto.reservation.Pay;

public interface PayDao {
	
	String payCid(String cid);
	
	String payLogIn(CustomerLogIn cl);
	int priceInfo(String tcode);
	
	String createPid(CreatePid cp);
	int payInfo(Pay pay);
	HotelInfo completeInfo(String tcode);

	String cancelPid(String rid);
	int cancel(String pid);
}
