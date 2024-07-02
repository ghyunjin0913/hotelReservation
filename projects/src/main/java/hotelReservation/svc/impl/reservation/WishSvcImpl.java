package hotelReservation.svc.impl.reservation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hotelReservation.dao.reservation.PayDao;
import hotelReservation.dao.reservation.WishDao;
import hotelReservation.dto.goods.Type;
import hotelReservation.dto.reservation.CancelDibs;
import hotelReservation.dto.reservation.CheckReserve;
import hotelReservation.dto.reservation.MyWishList;
import hotelReservation.dto.reservation.Reserve;
import hotelReservation.dto.reservation.WishList;
import hotelReservation.dto.reservation.WishReserve;
import hotelReservation.svc.reservation.WishSvc;
import lombok.Getter;
import lombok.Setter;

@Service
@Getter
@Setter
public class WishSvcImpl implements WishSvc {

	@Autowired
	private WishDao wishDao;
	@Autowired
	private PayDao payDao;
	@Override
	public List<MyWishList> myWishList(String cid) {
		List<MyWishList> wishList = wishDao.myWishList(cid);
		return wishList;
	}

	@Override
	public Map<String, String> hWishList(String cid, List<Type> rooms) {
		String dibs="N";
		Map<String, String> wishMap = new HashMap<String, String>();
		List<WishList> wishList = wishDao.wishList(cid);
		for(Type t : rooms) {
			// tcode 하나씩 꺼내기  
			for(WishList w : wishList) {
				//내 리스트에서 tcode 대입
				if(w.getTcode().equals(t.getTcode())){
					dibs="Y";
					break;
				}
			dibs="N";
			}
			wishMap.put(t.getTcode(), dibs);
		}
		return wishMap;
	}
	
	
	@Override
	public String gWishList(String cid, String tcode) {
		String dibs ="N";
		List<WishList> wishList = wishDao.wishList(cid);
		for(WishList w : wishList) {
			if(w.getTcode().equals(tcode)) {
				dibs = "Y";
				break;
			}
		}
		return dibs;
	}

	
	// 찜 개수 제한
	@Override
	public String myWishNo(String cid) {
		String ok = "Y";
		int myWishNo = wishDao.myWishNo(cid);
		if(myWishNo>=5) {
			ok = "N";
			System.out.println("server> 찜 목록이 다 차서 더이상 찜하기가 불가능합니다.");
		} else {
			System.out.println("server> 찜 하기가 가능합니다.");
		}
		return ok;
	}
	
	
	// 특정상품 찜 개수
	@Override
	public String gWishNo(String tcode) {
		int wishNo = wishDao.wishNo(tcode);
		String num = String.valueOf(wishNo);
		//찜 개수 999넘어가면 오버표시
		if(wishNo>=99) {
			num = "+99";
		}
		return num;
	}

	// 찜 취소하기
	@Override
	public String cancelDibs(String cid, String tcode) {
		CancelDibs c = new CancelDibs(cid, tcode);
		int cnt = wishDao.cancelDibs(c);
		String success="N";
		// 상품이 취소됨.
		if(cnt==1) {
			// 찜 취소 성공
			System.out.println("server> 찜 취소가 완료되었습니다.");
			success="Y";
		} else {
			System.out.println("server> 찜 취소가 실패하였습니다.");
		}
		return success;
	}

	// 찜 추가하기
	@Override
	public String addDibs(String cid, String tcode) {
		String hid = tcode.substring(0, 7);
		int tprice = payDao.priceInfo(tcode);
		WishList w = new WishList(cid, hid, tcode, tprice);
		int cnt = wishDao.addDibs(w);
		String success="N";
		// 찜 추가됨
		if(cnt==1) {
			System.out.println("server> 찜이 완료되었습니다.");
			success="Y";
		} else {
			System.out.println("server> 찜하기가 실패하였습니다.");
		}
		return success;
	}

	// 찜 예약 정보 가져오기 
	@Override
	public WishReserve reserve(String tcode) {
		System.out.println("server> tcode값 확인:" + tcode);
		WishReserve reserve = wishDao.reserve(tcode);
		return reserve;
	}

	// 찜 가능 여부 확인
	@Override
	public Reserve check(CheckReserve cr) {
		System.out.println("server> 찜 가능 여부 확인");
		Type check = wishDao.check(cr);
		int amounts = check.getAmounts();
		// 예약 가능
		if(amounts>0) {
			System.out.println("server> 예약이 가능합니다.");
			//1차 예약 정보 넘기기
			Reserve reserve = new Reserve();
			reserve.setCheckin(cr.getCheckIn());
			reserve.setCheckout(cr.getCheckOut());
			reserve.setPerson(cr.getMax());
			System.out.println("server> 예약 1차 정보값");
			System.out.println("server> 체크인, 체크아웃, 인원수 추가");
			
			return reserve;
		} else {
			System.out.println("server> 예약이 불가능합니다.");
			return null;
		}
	}

}
