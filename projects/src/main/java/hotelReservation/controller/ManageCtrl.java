package hotelReservation.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hotelReservation.dto.EmpMyInfo;
import hotelReservation.dto.ReservationCount;
import hotelReservation.dto.Withdraw;
import hotelReservation.dto.goods.Hotel;
import hotelReservation.dto.goods.Type;
import hotelReservation.dto.review.ById;
import hotelReservation.dto.review.ByRpno;
import hotelReservation.dto.review.Report;
import hotelReservation.dto.review.ReportManage;
import hotelReservation.dto.review.ReviewProcess;
import hotelReservation.login.common.ManageCommon;
import hotelReservation.svc.ManageSvc;
import hotelReservation.svc.ReviewSvc;

@Controller
public class ManageCtrl extends ManageCommon{

	@Autowired
	ManageSvc manageSvc;
	@Autowired
	ReviewSvc reviewSvc;
	@Autowired
	private HttpSession session;


	// 관리자 페이지로 이동
	@RequestMapping(value = "/admin")
	public String requestManagePage(Model model) {
		String ename = empSession();
		if(ename != null) {
			model.addAttribute("ename", ename);
			return "manage/adminMain";
		}
		return "logIn/logInForm";
	}

	// 회원 등급 관리 페이지
	@RequestMapping(value = "/rankList")
	public String checkReservationCtrl(Model model) {
		String ename = empSession();
		if(ename != null) {
			model.addAttribute("ename", ename);
			List<ReservationCount> countList = new ArrayList<ReservationCount>();
			countList = manageSvc.checkReservation();
			model.addAttribute("countList", countList);
			return "manage/checkRank";
		}
		return "logIn/logInForm";
	}
	
	// 회원 등급 관리 업데이트 버튼
	@RequestMapping(value = "/updateRank")
	public String updateReserveCount() {
		int result = manageSvc.updateRank();
		System.out.println(result);
		return "forward:/rankList";
	}
	
	// 사원 정보 관리 페이지
	@RequestMapping(value = "/empList")
	public String checkEmployeeCtrl(Model model) {
		String ename = empSession();
		if(ename != null) {
			model.addAttribute("ename", ename);
			List<EmpMyInfo> eList = new ArrayList<EmpMyInfo>();
			eList = manageSvc.checkEmployee();
			model.addAttribute("eList", eList);
			return "manage/checkEmp";
		}
		return "logIn/logInForm";
	}
	
	@RequestMapping(value = "/updateEmpInfo")
	public String checkEmpInfoCtrl(@RequestParam("eid") String eid, Model model) {
		model.addAttribute("empInfo", manageSvc.checkEmpInfo(eid));
		return "manage/updateEmpInfoForm";
	}
	
	@RequestMapping(value = "/updateEmpInfoCtrl", method = RequestMethod.POST)
	public String updateEmployeeInfoCtrl(@ModelAttribute EmpMyInfo empMyInfo) {
		manageSvc.updateEmpInfo(empMyInfo);
		return "forward:/empList";
	}
	
	// 회원 탈퇴 요청 관리 페이지
	@RequestMapping(value = "/withdrawList")
	public String checkWithdrawCtrl(Model model) {
		String ename = empSession();
		if(ename != null) {			
			model.addAttribute("ename", ename);
			List<Withdraw> wList = new ArrayList<Withdraw>();
			wList = manageSvc.checkWithdraw();
			model.addAttribute("wList", wList);
			return "manage/checkWithdraw";
		}
		return "logIn/logInForm";
	}
	
	@RequestMapping(value = "/updateWithdraw")
	public String updateWithdrawCtrl() {
		manageSvc.updateWithdraw();
		return "forward:/withdrawList";
	}
	
	// 호텔 관리 페이지
		@RequestMapping(value = "/hotelList")
		public String checkHotel(Model model) {
			String ename = empSession();
			if(ename != null) {
				model.addAttribute("ename", ename);
				List<Hotel> hotels = manageSvc.checkHotel();
				model.addAttribute("hotels", hotels);
				return "manage/checkHotel";
			}
			return "logIn/logInForm";
		}
		
		@RequestMapping(value = "/hotelSearch", method=RequestMethod.POST)
		public String searchHotel(@RequestParam String type, 
				@RequestParam String keyword, Model model) {
			String ename = empSession();
			if(ename != null) {
				model.addAttribute("ename", ename);
				List<Hotel> hotels = manageSvc.searchHotel(type, keyword);
				model.addAttribute("hotels", hotels);
				return "manage/checkHotel";
			}
			return "logIn/logInForm";
		}
		
		// 객실 관리 페이지
		@RequestMapping(value = "/typeList")
		public String checkType(Model model) {
			String ename = empSession();
			if(ename != null) {
				model.addAttribute("ename", ename);
				List<Type> types = manageSvc.checkType();
				model.addAttribute("types", types);
				return "manage/checkType";
			}
			return "logIn/logInForm";
		}
		
		@RequestMapping(value = "/typeSearch", method=RequestMethod.POST)
		public String searchType(@RequestParam String type, 
				@RequestParam String keyword, Model model) {
			String ename = empSession();
			if(ename != null) {
				model.addAttribute("ename", ename);
				List<Type> types = manageSvc.searchType(type, keyword);
				model.addAttribute("types", types);
				return "manage/checkType";
			}
			return "logIn/logInForm";
		}
		
		
		
		
		// 관리자 댓글 신고 화면
		@RequestMapping(value="/reviewManagePage")
		public String reportManagePage(Model model) {
			String ename = empSession();
			model.addAttribute("ename", ename);
			List<Report> reports = reviewSvc.reportManage();
			model.addAttribute("reports", reports);
			return "manage/reviewManage";
		}
		
		// 관리자 댓글 신고 검색
		@RequestMapping(value="/mSearchReview")
		public String mSearchReview(Model model,
				@RequestParam(defaultValue="3") String search,
				@ModelAttribute ById byId, 
				@ModelAttribute ByRpno rpno,
				@RequestParam String answer
				) {
			System.out.println(answer);
			System.out.println(search);
			List<Report> reports = reviewSvc.reportSearch(byId, rpno, search, answer);
			model.addAttribute("reports", reports);
			return "manage/reviewManage";
		}
		
		
		// 관리자 댓글 관리 화면
		@RequestMapping(value="/reviewManage")
		public String reportManage(Model model,
				@ModelAttribute ReportManage rm) {
			String rid = rm.getRid();
			ReviewProcess rp = reviewSvc.reviewProcess(rid);
			model.addAttribute("rp", rp);
			model.addAttribute("rm", rm);
			session.setAttribute("rp", rp);
			session.setAttribute("rm", rm);
			return "manage/reviewProcess";
		}
		
		
		// 관리자 리뷰 삭제 
			@RequestMapping(value="/reviewDelete")
			public String reviewDelete(Model model,
					@RequestParam("rid") String rid) {
				String deleteBtn = reviewSvc.mReviewDelete(rid);
				model.addAttribute("deleteBtn", deleteBtn);
				ReportManage rm = (ReportManage)session.getAttribute("rm");
				ReviewProcess rp = (ReviewProcess)session.getAttribute("rp");
				model.addAttribute("rp", rp);
				model.addAttribute("rm", rm);
				session.removeAttribute("rp");
				session.removeAttribute("rm");
				return "manage/reviewProcess";
			}
			
			
			// 관리자 신고 답변
			@RequestMapping(value="/reviewAnswer")
			public String reviewAnswer(Model model,
					@ModelAttribute ReportManage rm) {
				
				System.out.println(rm.getRid());
				System.out.println(rm.getType());
				System.out.println(rm.getId());
				System.out.println(rm.getStatus());
				
				
				String process = reviewSvc.reviewAnswer(rm); 
				model.addAttribute("process", process);
				return "forward:/reviewManagePage";
			}
	
}
