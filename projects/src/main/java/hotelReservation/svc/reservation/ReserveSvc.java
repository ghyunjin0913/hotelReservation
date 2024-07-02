package hotelReservation.svc.reservation;

import java.util.List;

import hotelReservation.dto.CustomerInfo;
import hotelReservation.dto.reservation.CstReserve;
import hotelReservation.dto.reservation.MyReserve;
import hotelReservation.dto.reservation.Reserve;
import hotelReservation.dto.reservation.ReserveInfo;

public interface ReserveSvc {

	CustomerInfo  customerInfo(String cid);
	List<MyReserve> myReservation(String cid);

	Reserve mReserveInfo(ReserveInfo reserveInfo,Reserve reserve);
	Reserve nReserveInfo(ReserveInfo reserveInfo, Reserve reserve);
	void cancelReserve(String rid);
	List<Reserve> cReservation(CstReserve cstReserve);
	
}
