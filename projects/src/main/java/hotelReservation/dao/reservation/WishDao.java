package hotelReservation.dao.reservation;

import java.util.List;

import hotelReservation.dto.goods.Type;
import hotelReservation.dto.reservation.CancelDibs;
import hotelReservation.dto.reservation.CheckReserve;
import hotelReservation.dto.reservation.MyWishList;
import hotelReservation.dto.reservation.WishList;
import hotelReservation.dto.reservation.WishReserve;

public interface WishDao {

	List<MyWishList> myWishList(String cid);
	WishReserve reserve(String tcode);
	
	List<WishList> wishList(String cid);
	Type check(CheckReserve cr);
	
	int cancelDibs(CancelDibs c);
	int addDibs(WishList w);
	
	
	int myWishNo(String cid);
	int wishNo(String tcode);
	
}
