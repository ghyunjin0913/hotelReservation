package hotelReservation.svc.reservation;

import java.util.List;
import java.util.Map;

import hotelReservation.dto.goods.Type;
import hotelReservation.dto.reservation.CheckReserve;
import hotelReservation.dto.reservation.MyWishList;
import hotelReservation.dto.reservation.Reserve;
import hotelReservation.dto.reservation.WishReserve;

public interface WishSvc {
	
	List<MyWishList> myWishList(String cid);
	WishReserve reserve(String tcode);
	Reserve check(CheckReserve cr);
	
	Map<String, String> hWishList(String cid, List<Type> rooms);
	String gWishList(String cid, String tcode);

	String cancelDibs(String cid, String tcode);
	String addDibs(String cid, String tcode);
	
	String myWishNo(String cid);
	String gWishNo(String tcode);
}
