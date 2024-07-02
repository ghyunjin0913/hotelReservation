package hotelReservation.svc.impl.reservation;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hotelReservation.dao.reservation.PayDao;
import hotelReservation.dao.reservation.ReserveDao;
import hotelReservation.dao.reservation.StockDao;
import hotelReservation.dto.CustomerInfo;
import hotelReservation.dto.reservation.CreateRid;
import hotelReservation.dto.reservation.CstReserve;
import hotelReservation.dto.reservation.MyReserve;
import hotelReservation.dto.reservation.Reserve;
import hotelReservation.dto.reservation.ReserveInfo;
import hotelReservation.dto.reservation.Stock;
import hotelReservation.svc.reservation.ReserveSvc;
import lombok.Getter;
import lombok.Setter;


@Service
@Getter
@Setter
public class ReserveSvcImpl implements ReserveSvc {

	@Autowired
	private ReserveDao reserveDao;
	@Autowired
	private PayDao payDao;
	@Autowired
	private StockDao stockDao;
	

	// 로그인 고객 정보 가져오기
	@Override
	public CustomerInfo customerInfo(String cid) {
		
		CustomerInfo cInfo = reserveDao.customerInfo(cid);
		return cInfo;
	}
	
	
	// 내 예약정보 조회
	@Override
	public List<MyReserve> myReservation(String cid) {
		
		List<MyReserve> myReservation = reserveDao.myReservation(cid);
		return myReservation;
	}
	
	
	// 로그인 예약자 정보 처리
	@Override
	public Reserve mReserveInfo(ReserveInfo reserveInfo, Reserve reserve) {
		
		String country = reserveInfo.getCountry();
		String request = reserveInfo.getRequest();
		reserve.setCountry(country);
		reserve.setRequest(request);
		
		// 예약 날짜 
		LocalDate now = LocalDate.now();
		String rdate = String.valueOf(now);
		reserve.setRdate(rdate);
		
		/* 예약번호 생성
		 * 중대 오류 발생 - 누군가 예약하는데 예약이 안끝났는데 
		 *                  다른 사람이 예약하려고 시도하면
		 *                  같은 번호로로 예약번호가 생성됨.
		 */                 
		CreateRid cr = new CreateRid(reserve.getCountry(), rdate);
		String rid = reserveDao.createRid(cr);
		reserve.setRid(rid);
		System.out.println("server> 예약번호 생성완료");
		
		// SERVER - 예약 정보 값 확인
		System.out.println("server> 로그인 예약 3차 정보값");
		System.out.println("server> 예약번호, 예약날짜, 거주국가, 요청사항");
		System.out.println(reserve);	
	
		return reserve;
	}

	
	//로그인 안한 예약자 정보 처리
	@Override
	public Reserve nReserveInfo(ReserveInfo reserveInfo, Reserve reserve) {
		
		String firstname = reserveInfo.getFirstname();
		String lastname = reserveInfo.getLastname();
		String email = reserveInfo.getEmail();
		String country = reserveInfo.getCountry();
		String request = reserveInfo.getRequest();
		reserve.setFirstname(firstname);
		reserve.setLastname(lastname);
		reserve.setEmail(email);
		reserve.setCountry(country);
		reserve.setRequest(request);
		// 예약 날짜 
		LocalDate now = LocalDate.now();
		String rdate = String.valueOf(now);
		reserve.setRdate(rdate);

		/* 예약번호 생성
		 * 중대 오류 발생 - 누군가 예약하는데 예약이 안끝났는데 
		 *                  다른 사람이 예약하려고 시도하면
		 *                  같은 번호로로 예약번호가 생성됨.
		 */
		CreateRid cr = new CreateRid(reserve.getCountry(), rdate);
		String rid = reserveDao.createRid(cr);
		reserve.setRid(rid);
		System.out.println("server> 예약번호 생성완료");	
		System.out.println("server> 비회원 로그인 2차 정보값");	
		System.out.println("server> 예약번호, 예약날짜, 성, 이름, 메일, 거주국가, 요청사항");
		
		// SERVER - 예약 정보 값 확인
		System.out.println(reserve);

		return reserve;
	}

	
	// 고객 예약 취소 처리
	@Override
	public void cancelReserve(String rid) {
		
		if(rid!=null) {
			System.out.println("server> 예약취소번호:"+rid);
			
			//결제 번호 가져오기
			String pid = payDao.cancelPid(rid);
			System.out.println("server> 결제취소번호:"+pid);
			
			// 예약 내역, 결제 내역 동시 취소
			int bookCancel = reserveDao.cancel(rid);
			
			//결제 취소
			int payCancel = payDao.cancel(pid);
			
			if(payCancel==1) {
				System.out.println("server> 결제취소 완료");
				
				if(bookCancel==1) {
					System.out.println("server> 예약취소 완료");
					
					// 객실 수량 변동 처리
					Stock cd = reserveDao.cancelData(rid);
					String tcode = cd.getTcode();
					String checkin = cd.getCheckin();
					String checkout = cd.getCheckout();
					System.out.println(tcode+":"+checkin+":"+checkout);
					Stock stock = new Stock(tcode, checkin.substring(0, 10), checkout.substring(0, 10));
					int changeStock = stockDao.addStock(stock);
					
					if(changeStock==0) {
						System.out.println("server> 객실 수량 변동 실패");
					} else {
						System.out.println("server> 객실 수량 변동 완료");
					}
					
					// 예약 건수 삭제
					int deleteRsvno = reserveDao.deleteRsvno(rid);
					if(deleteRsvno==1) {
						System.out.println("server> 예약건수 삭제 성공");
					} else {
						System.out.println("server> 예약건수 삭제 실패");
					}
				
				} else {
					System.out.println("server> 예약취소 오류");
				}
			} else {
				System.out.println("server> 결제취소 오류");
			}
		}	
	}
	
	
	//호텔 고객 예약 조회
	@Override
	public List<Reserve> cReservation(CstReserve cstReserve) {
		
		List<Reserve> bookList;
		String search = cstReserve.getSearch();
		String cid = cstReserve.getCid();
		String rid = cstReserve.getRid();
		String mdate = cstReserve.getMdate();
		String rdate = cstReserve.getRdate();
		
		//라디오 값 체크
		System.out.println("server> 검색방법"+search);
		
		// 고객아이디 검색
		if(search.equals("1")) {
			System.out.println("server> 고객아이디:"+cid);
			bookList = reserveDao.bookByCustomer(cid);
			return bookList;
		
		}  
		// 예약아이디 검색
		else if (search.equals("2")) {
			System.out.println("server> 예약번호:"+rid);
			bookList = reserveDao.bookById(rid);
			return bookList;
		} 
		// 년월 검색
		else if (search.equals("3")) {
			System.out.println("server> 날짜:"+mdate);
			mdate= mdate+"-01";
			bookList = reserveDao.bookByMonth(mdate);
			return bookList;
		} 
		// 년월일 검색
		else if (search.equals("4")) {
			System.out.println("server> 날짜:"+rdate);
			bookList = reserveDao.bookByDate(rdate);
			return bookList;
		}
		
		return null;
	}

}