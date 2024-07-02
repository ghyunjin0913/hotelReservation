package hotelReservation.svc.impl.reservation;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hotelReservation.dao.reservation.PayDao;
import hotelReservation.dao.reservation.ReserveDao;
import hotelReservation.dao.reservation.StockDao;
import hotelReservation.dto.CustomerLogIn;
import hotelReservation.dto.HotelInfo;
import hotelReservation.dto.reservation.CreatePid;
import hotelReservation.dto.reservation.Pay;
import hotelReservation.dto.reservation.PayInfo;
import hotelReservation.dto.reservation.Reserve;
import hotelReservation.dto.reservation.Rsvno;
import hotelReservation.dto.reservation.Stock;
import hotelReservation.svc.reservation.PaySvc;
import lombok.Getter;
import lombok.Setter;

@Service
@Getter
@Setter
public class PaySvcImpl implements PaySvc {

	@Autowired
	private PayDao payDao;
	@Autowired
	private ReserveDao reserveDao;
	@Autowired
	private StockDao stockDao;
	
	
	@Override
	public int payInfo(Pay pay) {
		int cnt = payDao.payInfo(pay);
		return cnt;
	}


	@Override
	public int priceInfo(String tcode) {
		int cnt = payDao.priceInfo(tcode);
		return cnt;
	}
	

	@Override
	public HotelInfo completeInfo(String tcode) {
		HotelInfo hInfo = payDao.completeInfo(tcode);
		return hInfo;
	}


	@Override
	public String payLogIn(CustomerLogIn cl, Reserve reserve) {
		
		String cid = cl.getCid();
		
			// 아이디 없음
			if(payDao.payCid(cid)==null) {
				System.out.println("server> 해당 고객 ID 없음");
				return "no_id";
			} 
			// 아이디 있음
			else {
				
				System.out.println("server> 고객 ID 확인 완료");
					
				// 비밀번호 불일치
				if(payDao.payLogIn(cl)==null) {
					System.out.println("server> 고객 Password 불일치");
					return "wrong_pw";
				} 
				//비밀번호 일치
				else {
					System.out.println("server> 고객 Password 확인 완료");	
						
					// 객체에 cid값 넣기
					reserve.setCid(cid);
						
					// 객체에 저장된 상품코드 값 가져오기
					String tcode = reserve.getTcode();
					int price = payDao.priceInfo(tcode);
					String tprice = String.valueOf(price);
					return tprice;
				}
			}
	}


	@Override
	public String payInfo(PayInfo payInfo, Reserve reserve) {
		// 타입변환
		long cardno = Long.parseLong(payInfo.getCardno());
		int cvcno = Integer.parseInt(payInfo.getCvcno());
		int price = payInfo.getTprice();
		String expiredate = payInfo.getExpiredate();
		String cardco = payInfo.getCardco();
				
		// 예약 날짜 
		LocalDate now = LocalDate.now();
		String chargedate = String.valueOf(now);
		System.out.println("server> 결제날짜:"+chargedate);
				expiredate = expiredate+"-01";
				System.out.println("server> 카드만료일:"+expiredate);
				
				// 결제번호 생성
				// 중대 오류 발생 - 누군가 결제하는데 결제가 안끝났는데 
				//                  다른 사람이 결제하려고 시도하면
				//                  같은 번호로로 결제번호가 생성됨.
				CreatePid cp = new CreatePid(cardco, chargedate);
				String pid = payDao.createPid(cp);
				System.out.println("server> 결제번호 생성 완료");
				System.out.println("server> 결제번호:" +pid);

				// 결제 정보 채워넣기
				Pay pay = new Pay(pid, cardco, chargedate, expiredate, cardno, cvcno, price, 'N');
				
				// 결제 정보 DB에 넣기
				int pcnt = payDao.payInfo(pay);
				System.out.println("server> 결제정보 입력 완료");

				reserve.setPid(pid);
				
				if(pcnt==1) {
					System.out.println("server> 결제 완료");
					
					// 예약번호 이때 생성하기!!        
					/*
					 * 수정필요
					 */
					
					// 완료 예약정보 DB에 집어넣기
					int rcnt = reserveDao.reserveInfo(reserve);
					System.out.println(rcnt);
					
					if(rcnt==1) {
						System.out.println("server> 예약정보 입력완료");
						
						//예약건수 아이디 생성
						String rsvno = reserveDao.createRsvno(chargedate);
						System.out.println("server> 예약건수 아이디:"+rsvno);
						
					    //예약건수 입력
						String cid = reserve.getCid();
						String rid = reserve.getRid();
						Rsvno r = new Rsvno(rsvno, cid, rid, chargedate);
						int rsvnocnt = reserveDao.rsvnoInfo(r);
						
						if(rsvnocnt==1) {
							System.out.println("server> 예약건수 입력완료");
						} else {
							System.out.println("server> 예약건수 입력실패");
						}
						
						// 객실 재고 변동
						// 객실 수량 변동 처리
						String tcode = reserve.getTcode();
						String checkin = reserve.getCheckin();
						String checkout = reserve.getCheckout();
						Stock stock = new Stock(tcode, checkin, checkout);
						int changeStock = stockDao.subtractStock(stock);
						
						if(changeStock==0) {
							System.out.println("server> 객실 수량 변동 실패");
							System.out.println("server> 예약 시스템 정상 작동 실패");
						} else {
							System.out.println("server> 객실 수량 변동 완료");
							System.out.println("server> 예약 시스템 정상 작동 완료");
						}
						System.out.println("server> 화면에 예약완료 페이지 출력");
						
						// tcode값 넘기기
						return tcode;
					} else {
						System.out.println("server> 예약정보 입력실패");
						return "rInputFail";
					}
				} else {
					System.out.println("server> 결제 처리 중 오류 발생");
					return "pInputFail";
				}
	}


}