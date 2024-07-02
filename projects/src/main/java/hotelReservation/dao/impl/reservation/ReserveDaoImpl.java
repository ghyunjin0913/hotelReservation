package hotelReservation.dao.impl.reservation;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hotelReservation.dao.reservation.ReserveDao;
import hotelReservation.dto.CustomerInfo;
import hotelReservation.dto.reservation.CreateRid;
import hotelReservation.dto.reservation.MyReserve;
import hotelReservation.dto.reservation.Reserve;
import hotelReservation.dto.reservation.Rsvno;
import hotelReservation.dto.reservation.Stock;
import lombok.Getter;
import lombok.Setter;

@Repository
@Getter
@Setter
public class ReserveDaoImpl implements ReserveDao {
	
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	// 로그인한 고객 정보 가져오기
	@Override
	public CustomerInfo customerInfo(String cid) {
		CustomerInfo cInfo = sqlSessionTemplate.selectOne("reserve.customerInfo", cid);
		return cInfo;
	}
	
	
	// 예약아이디 생성
	@Override
	public String createRid(CreateRid cr) {
		String rid = sqlSessionTemplate.selectOne("reserve.createRid", cr);
		return rid;
	}


	@Override
	public int reserveInfo(Reserve reserve) {
		int cnt = sqlSessionTemplate.insert("reserve.reserveInfo", reserve);
		return cnt;
	}


	// 예약건수아이디 생성
	@Override
	public String createRsvno(String chargedate) {
		String rsvno = sqlSessionTemplate.selectOne("reserve.createRsvno", chargedate);
		return rsvno;
	}


	@Override
	public int rsvnoInfo(Rsvno rsvno) {
		int cnt = sqlSessionTemplate.insert("reserve.rsvnoInfo", rsvno);
		return cnt;
	}

	// 예약 취소
	@Override
	public int cancel(String rid) {
		int cnt = sqlSessionTemplate.update("reserve.cancel", rid);
		return cnt;
	}

	// 예약건수 삭제
	@Override
	public int deleteRsvno(String rid) {
		int cnt = sqlSessionTemplate.delete("reserve.deleteRsvno", rid);
		return cnt;
	}
	
	// 내 예약정보 조회
	@Override
	public List<MyReserve> myReservation(String cid) {
		List<MyReserve> myReservation = sqlSessionTemplate.selectList("reserve.myReservation", cid);
		return myReservation;
	}


	@Override
	public List<Reserve> bookByCustomer(String cid) {
		List<Reserve> bookList = sqlSessionTemplate.selectList("reserve.bookByCustomer", cid);
		return bookList;
	}

	
	@Override
	public List<Reserve> bookById(String rid) {
		List<Reserve>  bookList = sqlSessionTemplate.selectList("reserve.bookById", rid);
		return bookList;
	}

	
	@Override
	public List<Reserve> bookByDate(String rdate) {
		List<Reserve> bookList = sqlSessionTemplate.selectList("reserve.bookByDate", rdate);
		return bookList;
	}

	
	@Override
	public List<Reserve> bookByMonth(String rdate) {
		List<Reserve> bookList = sqlSessionTemplate.selectList("reserve.bookByMonth", rdate);
		return bookList;
	}


	@Override
	public Stock cancelData(String rid) {
		Stock cancelData = sqlSessionTemplate.selectOne("reserve.cancelData", rid);
		return cancelData;
	}








}

