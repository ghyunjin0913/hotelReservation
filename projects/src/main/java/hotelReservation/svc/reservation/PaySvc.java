package hotelReservation.svc.reservation;

import hotelReservation.dto.CustomerLogIn;
import hotelReservation.dto.HotelInfo;
import hotelReservation.dto.reservation.Pay;
import hotelReservation.dto.reservation.PayInfo;
import hotelReservation.dto.reservation.Reserve;

public interface PaySvc {

	int payInfo(Pay pay);
	int priceInfo(String tcode);
	HotelInfo completeInfo(String tcode);
	String payLogIn(CustomerLogIn cl, Reserve reserve);
	String payInfo(PayInfo payInfo, Reserve reserve);
}
