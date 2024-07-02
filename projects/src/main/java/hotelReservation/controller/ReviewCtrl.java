package hotelReservation.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hotelReservation.dto.reservation.Reserve;
import hotelReservation.dto.review.MyReport;
import hotelReservation.dto.review.Review;
import hotelReservation.dto.review.SearchReview;
import hotelReservation.dto.review.UpdateAnswer;
import hotelReservation.dto.review.UpdateReview;
import hotelReservation.svc.ReviewSvc;
import lombok.Getter;
import lombok.Setter;

@Controller
@Getter
@Setter
public class ReviewCtrl {
	
	@Autowired
	private ReviewSvc reviewSvc;
	
	@Autowired
	private HttpSession session;

	// 리뷰 작성할 상품 목록- 고객
		@RequestMapping(value="/reviewListPage")
		public String reviewList(Model model) {
			String cid = (String) session.getAttribute("cid");
			model.addAttribute("List", reviewSvc.reviewList(cid));
			
			return "review/reviewList";
		}
		
		// 리뷰작성 페이지 - 고객
		@RequestMapping(value="/rRegisterPage")
		public String reviewInfo(@RequestParam("rid") String rid,
				@ModelAttribute Review review, Model model) {
			System.out.println(rid);
			model.addAttribute("data", reviewSvc.reviewInfo(rid));
			model.addAttribute("review", review);
			return "review/rRegister";
		}
		
		// 리뷰작성 - 고객
		@RequestMapping(value="/rRegister", method=RequestMethod.POST)
		public String rRegister(@ModelAttribute Review review, Model model) {
			model.addAttribute("review", reviewSvc.reviewRegister(review));
			
			return "forward:/reviewListPage";
		}

		
		// 리뷰조회 - 고객
		@RequestMapping(value="/rViewPage")
		public String rView(@RequestParam("rid") String rid, Model model) {
			System.out.println("rid:"+rid);
			model.addAttribute("review", reviewSvc.reviewHot(rid));
			return "review/rView";
		}
		
		// 리뷰수정 - 고객
		@RequestMapping(value="/rUpdatePage")
		public String reviewUpdate(@RequestParam("rid") String rid, 
				@ModelAttribute UpdateReview updateReview, Model model) {
			System.out.println("rid:"+rid);
			model.addAttribute("review", reviewSvc.reviewHot(rid));
			model.addAttribute("updateReview", updateReview);
			return "review/rUpdate";
		}
		@RequestMapping(value="/rUpdate", method=RequestMethod.POST)
		public String rUpdate(@ModelAttribute UpdateReview updateReview, Model model) {
			model.addAttribute("updateReview", reviewSvc.reviewUpdate(updateReview));
			
			return "forward:/rViewPage";
		}
		
		// 리뷰삭제 - 고객
		@RequestMapping(value="/rDelete")
		public String rDelete(@RequestParam("rid") String rid, Model model) {
			System.out.println("delete:"+rid);
			model.addAttribute(reviewSvc.reviewDelete(rid));
			
			return "forward:/reviewListPage";
		}
		
		// 리뷰 조회 - 업체
		@RequestMapping(value="/hReviewList")
		public String hReviewList(@ModelAttribute SearchReview searchReview, Model model) {
			String hid = (String) session.getAttribute("hid");
			model.addAttribute("List", reviewSvc.hReviewList(hid));
			searchReview.setHid(hid);
			model.addAttribute("searchReview", searchReview);
			
			return "review/hReviewList";
		}
		// 리뷰 검색
		@RequestMapping(value="/reviewsearch", method=RequestMethod.POST)
		public String reviewSearch(@ModelAttribute SearchReview searchReview, 
				@RequestParam("answer") String answer, Model model) {
			String hid = (String) session.getAttribute("hid");
			List<Review> searchList = reviewSvc.searchReview(answer, hid, searchReview);
			model.addAttribute("List", searchList);
			
			return "review/hReviewList";
		}
		
		// 리뷰 답변 - 업체
		@RequestMapping(value="/hAnswerPage")
		public String hReviewAnswer(@RequestParam("rid") String rid, 
				@ModelAttribute UpdateAnswer updateAnswer, Model model) {
			model.addAttribute("review", reviewSvc.reviewHot(rid));
			model.addAttribute("hReview", reviewSvc.answerInfo(rid));
			model.addAttribute("updateAnswer", updateAnswer);
			
			String hid = (String) session.getAttribute("hid");
			String check = reviewSvc.checkReport(rid, "H", hid);
			model.addAttribute("check",check);
			return "review/hReview";
		}
		
		// 업체 답변 등록 
		@RequestMapping(value="/answerRegister", method=RequestMethod.POST)
		public String answerRegister(@ModelAttribute UpdateAnswer updateAnswer, Model model) {
			model.addAttribute("updateReview", reviewSvc.answerUpdate(updateAnswer));
			System.out.println("!!"+updateAnswer);
			
			return "forward:/hReviewList";
		}
		
	
	
	//업체 신고창 이동
	@RequestMapping(value="/hReport", method=RequestMethod.POST)
	public String hReport(@RequestParam("rid") String rid, Model model) {
		System.out.println("hReport이동");
		System.out.println("rid:"+rid);
		model.addAttribute("rid", rid);
		model.addAttribute("type", "H");
		return "review/report";
	}
	
	// 고객 리뷰 신고 체크
	@RequestMapping(value="/cReportCheck", method=RequestMethod.POST)
	public String cReportCheck(@RequestParam("rid") String rid, Model model) {
	
		String cid = (String)session.getAttribute("cid");
		String check = reviewSvc.checkReport(rid, "C", cid);

		//신고 가능
		if(check.equals("Y")) {
			model.addAttribute("rid", rid);
			model.addAttribute("type", "C");
			Reserve reserve=(Reserve)session.getAttribute("reserve");
			String tcode = reserve.getTcode();
			model.addAttribute("tcode", tcode);
			return "review/report";
		} //신고 불가능
		else {
		model.addAttribute("check", check);
		model.addAttribute("tab","reveiw");
		Reserve reserve=(Reserve)session.getAttribute("reserve");
		String tcode = reserve.getTcode();
		model.addAttribute("tcode", tcode);
		return "forward:/gDetails"; 
		}
	}
	
	
	// 고객/업체 리뷰 신고
	@RequestMapping(value="/report")
	public String report(Model model,
			@RequestParam("rid") String rid, 
			@RequestParam("type") String type,
			@RequestParam("reason") String reason,
			@RequestParam(value="details", required= false) String details) {
		
		System.out.println("신고 이동 완료");
		String result = null;
		String id = null;
		// 고객
		if(type.equals("C")) {
			id = (String)session.getAttribute("cid");
			if(!reason.equals("8")) {
				result = reviewSvc.report(rid, type, id, reason);
			} else if(type.equals("8")){
				details="기타:"+details;
				result = reviewSvc.report(rid, type, id, details);
			}
			model.addAttribute("result", result);
			model.addAttribute("tab","reveiw");
			Reserve reserve=(Reserve)session.getAttribute("reserve");
			String tcode = reserve.getTcode();
			model.addAttribute("tcode", tcode);
			return "forward:/gDetails";
		} //업체
		else {
			id = (String) session.getAttribute("hid");
			System.out.println("report이동");
			if(!reason.equals("8")) {
				result = reviewSvc.report(rid, type, id, reason);
			} else if(type.equals("8")){
				details="기타:"+details;
				result = reviewSvc.report(rid, type, id, details);
			}
			model.addAttribute("result", result);
			return "review/hReview";
		}
	
	}
	
	
	// 고객/업체 신고 내역 조회
	@RequestMapping(value="/myReport")
	public String myReport(Model model, 
			@RequestParam("type") String type) {
		String id=null;
		List<MyReport> reports= null;
		if(type.equals("C")) {
			id = (String)session.getAttribute("cid");
			reports = reviewSvc.reportList(type,id);
		} else if(type.equals("H")){
			id = (String) session.getAttribute("hid");
			reports = reviewSvc.reportList(type,id);
		}
		model.addAttribute("reports", reports);
		return "review/myReport";
	}
	
	

	
	
}
