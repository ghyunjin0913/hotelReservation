package hotelReservation.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hotelReservation.dao.ManageDao;
import hotelReservation.dto.EmpMyInfo;
import hotelReservation.dto.ReservationCount;
import hotelReservation.dto.Withdraw;
import hotelReservation.dto.goods.Hotel;
import hotelReservation.dto.goods.Type;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Repository
public class ManageDaoImpl implements ManageDao {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<ReservationCount> checkReservation() {
		
		return sqlSessionTemplate.selectList("manage.checkReservation");
	}

	@Override
	public int updateRank() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update("manage.updateRank");
	}

	@Override
	public List<EmpMyInfo> checkEmployee() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("manage.checkEmployee");
	}
	
	@Override
	public EmpMyInfo checkEmpInfo(String eid) {
		return sqlSessionTemplate.selectOne("manage.checkEmpInfo", eid);
	}

	@Override
	public int updateEmpInfo(EmpMyInfo empMyInfo) {
		
		return sqlSessionTemplate.update("manage.updateEmpInfo", empMyInfo);
	}

	@Override
	public List<Withdraw> checkWithdraw() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("manage.checkWithdraw");
	}

	@Override
	public int updateWithdraw() {
		
		return sqlSessionTemplate.update("manage.updateWithdraw");
	}
	
	@Override
	public List<Hotel> checkHotel() {
		List<Hotel> hotelList = sqlSessionTemplate.selectList(
				"manage.checkHotel");
				
		return hotelList;
	}

	@Override
	public List<Hotel> searchHid(String hid) {
		List<Hotel> search =  sqlSessionTemplate.selectList(
				"manage.searchHid", hid);
		return search;
	}

	@Override
	public List<Hotel> searchHotel(String hname) {
		List<Hotel> searchList = sqlSessionTemplate.selectList(
				"manage.searchHotel", hname);
		return searchList;
	}

	@Override
	public List<Type> checkType() {
		List<Type> typeList = sqlSessionTemplate.selectList(
				"manage.checkType");
				
		return typeList;
	}

	@Override
	public List<Type> searchTypeHid(String hid) {
		List<Type> search =  sqlSessionTemplate.selectList(
				"manage.searchTypeHid", hid);
		return search;
	}

	@Override
	public List<Type> searchTypeHotel(String hname) {
		List<Type> searchList = sqlSessionTemplate.selectList(
				"manage.searchTypeHotel", hname);
		return searchList;
	}
}
