package hotelReservation.svc;

import java.util.List;

import hotelReservation.dto.EmpMyInfo;
import hotelReservation.dto.ReservationCount;
import hotelReservation.dto.Withdraw;
import hotelReservation.dto.goods.Hotel;
import hotelReservation.dto.goods.Type;

public interface ManageSvc {

	List<ReservationCount> checkReservation();
	int updateRank();
	List<EmpMyInfo> checkEmployee();
	EmpMyInfo checkEmpInfo(String eid);
	int updateEmpInfo(EmpMyInfo empMyInfo);
	List<Withdraw> checkWithdraw();
	int updateWithdraw();
	List<Hotel> checkHotel();
	List<Hotel> searchHotel(String type, String keyword);
	List<Type> checkType();
	List<Type> searchType(String type, String keyword);
}
