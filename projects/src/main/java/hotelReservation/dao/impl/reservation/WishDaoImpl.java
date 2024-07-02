package hotelReservation.dao.impl.reservation;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hotelReservation.dao.reservation.WishDao;
import hotelReservation.dto.goods.Type;
import hotelReservation.dto.reservation.CancelDibs;
import hotelReservation.dto.reservation.CheckReserve;
import hotelReservation.dto.reservation.MyWishList;
import hotelReservation.dto.reservation.WishList;
import hotelReservation.dto.reservation.WishReserve;
import lombok.Getter;
import lombok.Setter;

@Repository
@Getter
@Setter
public class WishDaoImpl implements WishDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	// 내 찜 목록 조회 
	@Override
	public List<MyWishList> myWishList(String cid) {
		List<MyWishList> wishList = sqlSessionTemplate.selectList("wishList.myWishList", cid);
		return wishList;
	}
	
	// 찜 예약(예약자 정보)

	@Override
	public WishReserve reserve(String tcode) {
		WishReserve wr = sqlSessionTemplate.selectOne("wishList.reserve", tcode);
		return wr;
	}

	// 찜 가능여부 확인
	@Override
	public Type check(CheckReserve cr) {
		Type check = sqlSessionTemplate.selectOne("wishList.check", cr);
		return check;
	}

	
	// 특정 상품 찜한 상태
	@Override
	public List<WishList> wishList(String cid) {
		List<WishList> wishList = sqlSessionTemplate.selectList("wishList.wishList", cid);
		return wishList;
	}
	
	
	// 고객 찜 개수 제한
	@Override
	public int myWishNo(String cid) {
		int myWishNo = sqlSessionTemplate.selectOne("wishList.myWishNo", cid);
		return myWishNo;
	}


	//상품 찜 개수 
	@Override
	public int wishNo(String tcode) {
		int wishNo = sqlSessionTemplate.selectOne("wishList.wishNo", tcode);
		return wishNo;
	}

	
	// 상품 찜 취소 
	@Override
	public int cancelDibs(CancelDibs c) {
		int cnt = sqlSessionTemplate.delete("wishList.cancelDibs", c);
		return cnt;
	}
	

	//상품 찜 추가
	@Override
	public int addDibs(WishList w) {
		int cnt = sqlSessionTemplate.insert("wishList.addDibs", w);
		return cnt;
	}


}
