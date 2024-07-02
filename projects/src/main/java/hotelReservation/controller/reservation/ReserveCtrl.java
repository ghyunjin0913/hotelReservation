package hotelReservation.controller.reservation;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hotelReservation.dto.CustomerInfo;
import hotelReservation.dto.reservation.CstReserve;
import hotelReservation.dto.reservation.MyReserve;
import hotelReservation.dto.reservation.Reserve;
import hotelReservation.dto.reservation.ReserveInfo;
import hotelReservation.svc.reservation.PaySvc;
import hotelReservation.svc.reservation.ReserveSvc;



@Controller
public class ReserveCtrl {
 
	@Autowired
	private ReserveSvc reserveSvc; 
	@Autowired
	private PaySvc paySvc;
	@Autowired
	private HttpSession session;
	

	// 로그인 예약자 정보 작성값 가져오기(view->ctrl)
	@RequestMapping(value="/mReserveInfo", method= RequestMethod.POST)
	public String mReserveInfo(ModelMap model,
			@ModelAttribute ReserveInfo reserveInfo) {
		
		String confirm = reserveInfo.getConfirm();
		Reserve reserve = (Reserve)session.getAttribute("reserve");

		// 이메일 재확인 일치
		if(confirm.equals(reserveInfo.getEmail())) {
			
			System.out.println("server> 이메일 재확인");
			Reserve retReserve = reserveSvc.mReserveInfo(reserveInfo, reserve);
			// 예약 정보 객체 세션에 다시 주기 
			session.setAttribute("reserve", retReserve);
			
			// 객체에 저장된 상품코드 값 가져오기
			String tcode = retReserve.getTcode();
			int tprice = paySvc.priceInfo(tcode);
			
			// 가격정보 뷰로 보내기
			model.addAttribute("tprice", tprice);
			
			// 결제 페이지로 바로 넘어감
			System.out.println("<결제 화면>");
			return "reservation/payInfo";
		} 
		// 이메일 재확인 불일치
		else {
			System.out.println("server> 이메일 재확인 불일치");
			String cid = (String) session.getAttribute("cid");
			CustomerInfo cInfo = reserveSvc.customerInfo(cid);
			model.addAttribute("cInfo", cInfo);
			model.addAttribute("check", "N");
			
			return "reservation/mReserveInfo";
		}
	}

	
	// 로그인 안한 예약자 정보 작성값 가져오기(view->ctrl)
	@RequestMapping(value="/nReserveInfo", method= RequestMethod.POST)
	public String nReserveInfo( ModelMap model,
			@ModelAttribute ReserveInfo reserveInfo) {
		
			String confirm = reserveInfo.getConfirm();
			Reserve reserve = (Reserve)session.getAttribute("reserve");
			
		if(confirm.equals(reserveInfo.getEmail())) {
			System.out.println("server> 이메일 재확인");
			Reserve retReserve = reserveSvc.nReserveInfo(reserveInfo, reserve);
			
			// 예약 정보 객체 세션에 다시 주기 
			session.setAttribute("reserve", retReserve);
			
			// 결제 전 로그인 페이지로 가기
			return "reservation/payLogIn";	
		}
		// 이메일이 일치하지 않을 경우 안넘어감.
		else {
			System.out.println("server> 이메일 재확인 불일치");
			model.addAttribute("cInfo", reserveInfo);
			model.addAttribute("check", "N");
			
			return "reservation/nReserveInfo";
		}
	}
	
	
	// 호텔 고객 예약 페이지
	@RequestMapping(value="/hotelBook")
	public String hotelBook() {
		
		return "reservation/cReservation";
	}


	// 고객 내 예약 조회(ctrl->view)
	@RequestMapping(value="/myBook")
	public String myReservationPage(ModelMap model) {
	
		// 세션에 저장된 고객아이디 가져오기
		String cid = (String) session.getAttribute("cid");
		System.out.println("server> 나의 예약 정보 출력");
		//로그인 예약조회 가능
			List<MyReserve> myReservation = reserveSvc.myReservation(cid);
			model.addAttribute("List", myReservation);
		
			return "reservation/myReservation";
	}
	
	
	// 고객 예약 취소 (view->ctrl)
	@RequestMapping(value="/myReservation", method= RequestMethod.POST)
	public String cancelReserve(@RequestParam("cancel") String rid, 
			ModelMap model) {
		
		// 예약취소여부 확인
		model.addAttribute("check", "check");
		reserveSvc.cancelReserve(rid);
		 
		// 취소완료된 예약내역 재전송
		String cid = (String) session.getAttribute("cid");
		List<MyReserve> myReservation = reserveSvc.myReservation(cid);
		model.addAttribute("List", myReservation);
		
		return "reservation/myReservation";
	}
	
	
	// 호텔 고객 예약 조회 (view->ctrl)
	@RequestMapping(value="/cReservation", method= RequestMethod.POST)
	public String cReservation(@ModelAttribute CstReserve cstReserve,
		 ModelMap model) {
		
		System.out.println("<고객 예약 내역 화면>");
		List<Reserve> bookList = reserveSvc.cReservation(cstReserve);
		model.addAttribute("bookList", bookList);
		return "reservation/cReservation";
	}
	
}