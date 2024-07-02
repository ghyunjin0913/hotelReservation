package hotelReservation.dao.reservation;

import java.util.List;

import hotelReservation.dto.CustomerInfo;
import hotelReservation.dto.reservation.CreateRid;
import hotelReservation.dto.reservation.MyReserve;
import hotelReservation.dto.reservation.Reserve;
import hotelReservation.dto.reservation.Rsvno;
import hotelReservation.dto.reservation.Stock;

public interface ReserveDao {

	String createRid(CreateRid cr);
	CustomerInfo customerInfo(String cid);
	int reserveInfo(Reserve reserve);
	
	String createRsvno(String chargedate);
	int rsvnoInfo(Rsvno rsvno);
	
	int cancel(String rid);
	int deleteRsvno(String rid);
	
	List<MyReserve> myReservation(String cid);
	Stock cancelData(String rid);
	List<Reserve> bookByCustomer(String cid);
	List<Reserve> bookById(String rid);
	List<Reserve> bookByDate(String rdate);
	List<Reserve> bookByMonth(String rdate);
	
}
