package hotelReservation.svc.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hotelReservation.dao.ManageDao;
import hotelReservation.dto.EmpMyInfo;
import hotelReservation.dto.ReservationCount;
import hotelReservation.dto.Withdraw;
import hotelReservation.dto.goods.Hotel;
import hotelReservation.dto.goods.Type;
import hotelReservation.svc.ManageSvc;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service
public class ManageSvcImpl implements ManageSvc {
	
	@Autowired
	ManageDao manageDao;

	@Override
	public List<ReservationCount> checkReservation() {
		List<ReservationCount> countList = manageDao.checkReservation();
		return countList;
	}

	@Transactional
	@Override
	public int updateRank() {
		// TODO Auto-generated method stub
		return manageDao.updateRank();
	}

	@Override
	public List<EmpMyInfo> checkEmployee() {
		List<EmpMyInfo> eList = manageDao.checkEmployee();
		return eList;
	}
	
	@Override
	public EmpMyInfo checkEmpInfo(String eid) {
		return manageDao.checkEmpInfo(eid);
	}

	@Transactional
	@Override
	public int updateEmpInfo(EmpMyInfo empMyInfo) {
		
		return manageDao.updateEmpInfo(empMyInfo);
	}

	@Override
	public List<Withdraw> checkWithdraw() {
		List<Withdraw> wList = manageDao.checkWithdraw();
		return wList;
	}

	@Override
	public int updateWithdraw() {
		
		return manageDao.updateWithdraw();
	}
	@Override
	public List<Hotel> checkHotel() {
		List<Hotel> hotelList = manageDao.checkHotel();
		return hotelList;
	}

	@Override
	public List<Hotel> searchHotel(String type, String keyword) {
		if(type.equals("hid")) {
			List<Hotel> searchList = manageDao.searchHid(keyword);
			return searchList;
		} else if(type.equals("hname")) {
			List<Hotel> searchList = manageDao.searchHotel(keyword);
			return searchList;
		}
		return null;
	}
	
	@Override
	public List<Type> checkType() {
		List<Type> typeList = manageDao.checkType();
		return typeList;
	}

	@Override
	public List<Type> searchType(String type, String keyword) {
		if(type.equals("hid")) {
			List<Type> searchList = manageDao.searchTypeHid(keyword);
			return searchList;
		} else if(type.equals("hname")) {
			List<Type> searchList = manageDao.searchTypeHotel(keyword);
			return searchList;
		}
		return null;
	}
	

}
