package hotelReservation.svc.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hotelReservation.dao.LogInDao;
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
import hotelReservation.svc.LogInSvc;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service
public class LogInSvcImpl implements LogInSvc {

	@Autowired
	LogInDao loginDao;
	
	
	@Override
	public String cLogIn(CustomerLogIn clogin) {
//		String cid = clogin.getCid();
//		String cpw = clogin.getCpw();
//		String result = loginDao.cLogIn(clogin);
//		if(loginDao.cidCheck(cid) == 0) {
//			return "no_id";
//		}
//		else {
//			if(loginDao.cpwCheck(cpw) == 0) {
//				return "wrong_pw";
//			}
//			return result;
//		}
		return loginDao.cLogIn(clogin);
	}

	
	@Override
	public CustomerMyInfo cMyinfo(String cid) {
		return loginDao.cMyInfo(cid);
	}

	
	@Transactional
	@Override
	public int cSignUp(CustomerSignUp csu) {
		int count = loginDao.cSignUp(csu);
		return count;
	}
	
	
	@Override
	public int cidCheck(String cid) {
		int result = loginDao.cidCheck(cid);
		return result;
	}
	
	public int cpwCheck(String cpw) {
		int result = loginDao.cpwCheck(cpw);
		return result;
	}
	
	public int epwCheck(String epw) {
		int result = loginDao.epwCheck(epw);
		return result;
	}
	
	public int hpwCheck(String hpw) {
		int result = loginDao.hpwCheck(hpw);
		return result;
	}
	
	
	@Override
	public int eidCheck(String eid) {
		int result = loginDao.eidCheck(eid);
		return result;
	}
	
	
	@Override
	public int hidCheck(String hid) {
		int result = loginDao.hidCheck(hid);
		return result;
	}

	
	@Override
	public String hLogIn(HotelLogIn hlogin) {
		return loginDao.hLogIn(hlogin);
	}

	
	@Override
	public HotelMyInfo hMyInfo(String hid) {
		return loginDao.hMyInfo(hid);
	}
	

	@Transactional
	@Override
	public int hSignUp(HotelSignUp hsu) {
		int count = loginDao.hSignUp(hsu);
		return count;
	}

	
	@Override
	public String eLogIn(EmpLogIn elogin) {
		return loginDao.eLogIn(elogin);
	}

	
	@Override
	public EmpMyInfo eMyInfo(String eid) {
		
		return loginDao.eMyInfo(eid);
	}

	
	@Transactional
	@Override
	public int eSignUp(EmpSignUp esu) {
		int count = loginDao.eSignUp(esu);
		return count;
	}
	
	
	@Transactional
	@Override
	public int updateCustomer(UpdateCustomer updateCustomer) {
		return loginDao.updateCustomer(updateCustomer);
	}
	
	
	@Transactional
	@Override
	public int updateEmployee(UpdateEmp updateEmp) {
		return loginDao.updateEmployee(updateEmp);
	}
	
	
	@Transactional
	@Override
	public int updateHotel(UpdateHotel updateHotel) {
		return loginDao.updateHotel(updateHotel);
	}
	
	@Override
	public int requestWithdraw(Withdraw withdraw) {
		return loginDao.requestWithdraw(withdraw);
	}
	

}