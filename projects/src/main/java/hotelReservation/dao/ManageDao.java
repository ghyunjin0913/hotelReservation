package hotelReservation.dao;

import java.util.List;

import hotelReservation.dto.EmpMyInfo;
import hotelReservation.dto.ReservationCount;
import hotelReservation.dto.Withdraw;
import hotelReservation.dto.goods.Hotel;
import hotelReservation.dto.goods.Type;

public interface ManageDao {
	
	List<ReservationCount> checkReservation();
	int updateRank();
	List<EmpMyInfo> checkEmployee();
	EmpMyInfo checkEmpInfo(String eid);
	int updateEmpInfo(EmpMyInfo empMyInfo);
	List<Withdraw> checkWithdraw();
	int updateWithdraw();
	List<Hotel> checkHotel();
	List<Hotel> searchHid(String hid);
	List<Hotel> searchHotel(String hname);
	List<Type> checkType();
	List<Type> searchTypeHid(String hid);
	List<Type> searchTypeHotel(String hname);
	
	
}
