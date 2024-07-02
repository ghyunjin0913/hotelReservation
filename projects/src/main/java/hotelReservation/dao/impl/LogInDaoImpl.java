package hotelReservation.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Repository
public class LogInDaoImpl implements LogInDao {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	
	@Override
	public String cLogIn(CustomerLogIn cl) {
		return sqlSessionTemplate.selectOne("logIn.cLogIn", cl);
	}

	
	@Override
	public CustomerMyInfo cMyInfo(String cid) {
		return sqlSessionTemplate.selectOne("logIn.cMyInfo", cid);
	}

	
	@Override
	public int cSignUp(CustomerSignUp csu) {
		int cnt = sqlSessionTemplate.insert("logIn.cSignUp", csu);
		return cnt;
	}
	
	
	@Override
	public int cidCheck(String cid) {
		return sqlSessionTemplate.selectOne("logIn.cidCheck", cid);
	}
	
	
	@Override
	public int eidCheck(String eid) {
		return sqlSessionTemplate.selectOne("logIn.eidCheck", eid);
	}
	
	
	@Override
	public int hidCheck(String hid) {
		return sqlSessionTemplate.selectOne("logIn.hidCheck", hid);
	}
	
	@Override
	public int cpwCheck(String cpw) {
		return sqlSessionTemplate.selectOne("logIn.cpwCheck", cpw);
	}
	
	@Override
	public int epwCheck(String epw) {
		return sqlSessionTemplate.selectOne("logIn.epwCheck", epw);
	}
	
	@Override
	public int hpwCheck(String hpw) {
		return sqlSessionTemplate.selectOne("logIn.hpwCheck", hpw);
	}


	@Override
	public String hLogIn(HotelLogIn hl) {
		return sqlSessionTemplate.selectOne("logIn.hLogIn", hl);
	}

	
	@Override
	public HotelMyInfo hMyInfo(String hid) {
		return sqlSessionTemplate.selectOne("logIn.hMyInfo", hid);
	}

	
	@Override
	public int hSignUp(HotelSignUp hsu) {
		int cnt = sqlSessionTemplate.insert("logIn.hSignUp", hsu);
		return cnt;
	}

	
	@Override
	public String eLogIn(EmpLogIn el) {
		return sqlSessionTemplate.selectOne("logIn.eLogIn", el);
	}

	
	@Override
	public EmpMyInfo eMyInfo(String eid) {
		return sqlSessionTemplate.selectOne("logIn.eMyInfo", eid);
	}

	
	@Override
	public int eSignUp(EmpSignUp esu) {
		int cnt = sqlSessionTemplate.insert("logIn.eSignUp", esu);
		return cnt;
	}
	
	
	@Override
	public int updateCustomer(UpdateCustomer updateCustomer) {
		return sqlSessionTemplate.update("logIn.updateCustomer", updateCustomer);
	}
	
	
	@Override
	public int updateEmployee(UpdateEmp updateEmp) {
		return sqlSessionTemplate.update("logIn.updateEmployee", updateEmp);
	}
	
	
	@Override
	public int updateHotel(UpdateHotel updateHotel) {	
		return sqlSessionTemplate.update("logIn.updateHotel", updateHotel);
	}
	
	@Override
	public int requestWithdraw(Withdraw withdraw) {
		
		return sqlSessionTemplate.insert("logIn.requestWithdraw", withdraw);
	}

}
