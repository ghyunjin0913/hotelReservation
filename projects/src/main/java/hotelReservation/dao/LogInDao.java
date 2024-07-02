package hotelReservation.dao;

import hotelReservation.dto.CustomerLogIn;
import hotelReservation.dto.CustomerMyInfo;
import hotelReservation.dto.CustomerSignUp;
import hotelReservation.dto.EmpLogIn;
import hotelReservation.dto.EmpMyInfo;
import hotelReservation.dto.EmpSignUp;
import hotelReservation.dto.HotelLogIn;
import hotelReservation.dto.HotelMyInfo;
import hotelReservation.dto.HotelSignUp;
import hotelReservation.dto.UpdateCustomer;
import hotelReservation.dto.UpdateEmp;
import hotelReservation.dto.UpdateHotel;
import hotelReservation.dto.Withdraw;

public interface LogInDao {
	
	String cLogIn(CustomerLogIn cl);
	CustomerMyInfo cMyInfo(String cid);
	int cSignUp(CustomerSignUp csu);
	int cidCheck(String cid);
	int eidCheck(String eid);
	int hidCheck(String hid);
	int cpwCheck(String cpw);
	int epwCheck(String epw);
	int hpwCheck(String hpw);
	String hLogIn(HotelLogIn hl);
	HotelMyInfo hMyInfo(String hid);
	int hSignUp(HotelSignUp hsu);
	String eLogIn(EmpLogIn el);
	EmpMyInfo eMyInfo(String eid);
	int eSignUp(EmpSignUp esu);
	int updateCustomer(UpdateCustomer updateCustomer);
	int updateEmployee(UpdateEmp updateEmp);
	int updateHotel(UpdateHotel uupdateHotel);
	int requestWithdraw(Withdraw withdraw);
	
}
