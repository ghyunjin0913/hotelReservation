package hotelReservation.svc.impl;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hotelReservation.dao.ReviewDao;
import hotelReservation.dto.review.AnswerInfo;
import hotelReservation.dto.review.ById;
import hotelReservation.dto.review.ByRpno;
import hotelReservation.dto.review.MyReport;
import hotelReservation.dto.review.MyReview;
import hotelReservation.dto.review.Prevent;
import hotelReservation.dto.review.Report;
import hotelReservation.dto.review.ReportManage;
import hotelReservation.dto.review.Review;
import hotelReservation.dto.review.ReviewInfo;
import hotelReservation.dto.review.ReviewList;
import hotelReservation.dto.review.ReviewProcess;
import hotelReservation.dto.review.SearchReview;
import hotelReservation.dto.review.UpdateAnswer;
import hotelReservation.dto.review.UpdateReview;
import hotelReservation.svc.ReviewSvc;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service
public class ReviewSvcImpl implements ReviewSvc{

	@Autowired
	@Resource
	private ReviewDao reviewDao;
	
	@Override
	public List<MyReview> reviewList(String cid) {
		List<MyReview> reviewList = reviewDao.reviewList(cid);
		return reviewList;
	}
	
	@Override
	public ReviewInfo reviewInfo(String rid) {
		ReviewInfo reviewInfo = new ReviewInfo();
		reviewInfo.setRid(rid);
		ReviewInfo info = reviewDao.reviewInfo(reviewInfo);
		return info;
	}

	@Override
	public int reviewRegister(Review review) {
		System.out.println(review);
		int count = reviewDao.reviewRegister(review);
		return count;
	}
	

	@Override
	public int reviewUpdate(UpdateReview updateReview) {
		int count = reviewDao.reviewUpdate(updateReview);
		return count;
	}

	@Override
	public int reviewDelete(String rid) {
		int count = reviewDao.reviewDelete(rid);
		return count;
	}


	@Override
	public List<ReviewList> reviewCus(String tcode) {
		List<ReviewList> review = reviewDao.reviewCus(tcode);
		return review;
	}

	@Override
	public List<Review> hReviewList(String hid) {
		List<Review> reviewList = reviewDao.hReviewList(hid);
		return reviewList;
	}

	@Override
	public AnswerInfo answerInfo(String rid) {
		AnswerInfo answerInfo = reviewDao.anwerInfo(rid);
		return answerInfo;
	}

	@Override
	public ReviewList reviewHot(String rid) {
		ReviewList review = reviewDao.reviewHot(rid);
		return review;
	}

	@Override
	public List<Review> searchReview(String answer, String hid, SearchReview searchReview) {
		System.out.println("test"+searchReview.getTcode());
		if (answer.equals("Y") && searchReview.getTcode().isEmpty()) {
			// 미답변만 선택했을 경우
			List<Review> search = reviewDao.nullAnswer(hid); 
			return search;
		} else if(answer.equals("Y") && !(searchReview.getTcode().isEmpty())) {
			// 미답변 선택, 객실번호 입력한 경우
			List<Review> search = reviewDao.nullAndTcode(searchReview);
			return search;
		} else if(answer.equals("N") && !(searchReview.getTcode().isEmpty())) {
			// 객실번호만 입력한 경우
			List<Review> search = reviewDao.searchTcode(searchReview);
			return search;
		} else {
			// 아무것도 입력하지 않은 경우
			List<Review> search = reviewDao.hReviewList(hid);
			return search;
		}
	}

	@Override
	public int answerUpdate(UpdateAnswer updateAnswer) {
		int count = reviewDao.answerUpdate(updateAnswer);
		return count;
	}

	@Override
	public String report(String rid, String type, String id, String reason) {
		
		String result = null;
		// 신고 날짜 
		LocalDate now = LocalDate.now();
		String rpdate = String.valueOf(now);

		// 신고 번호 생성
			 String rpno = reviewDao.createRpno(rpdate);
			 if(rpno!=null) {
				 System.out.println("server> 신고번호 생성완료");
				
				 Report r = new Report();
				 r.setRpno(rpno);
				 r.setRid(rid);
				 r.setType(type);
				 r.setId(id);
				 r.setRpdate(rpdate);
				 r.setReason(reason);
				 
				 // 신고 정보 입력
				 int cnt = reviewDao.report(r);
				 if(cnt==1) {
					System.out.println("server> 신고 내역 입력 완료");
					result = "S";
				} else {System.out.println("server> 신고 내역 입력 실패"); }				
			 } else { System.out.println("sever> 신고번호 생성 실패");} 
			 
			return result;
	}
	
	// 댓글 신고 체크
	@Override
	public String checkReport(String rid, String type, String id) {
		String check= null;
				// 재신고 체크
				Prevent p = new Prevent();
				p.setRid(rid);
				p.setId(id);
				p.setType(type);
				int cnt = reviewDao.prevent(p);
				// 신고 안함
				if(cnt==0) {
					System.out.println("server> 신고 가능");
					check = "Y";
				}// 신고 함 
				else {
					System.out.println("server> 이미 신고함");
					check = "N";
				}
		return check;
	}

	// 내 신고 내역
	@Override
	public List<MyReport> reportList(String type, String id) {
		Prevent p = new Prevent(type, id);
		 List<MyReport> reports=reviewDao.reportList(p);
		return reports;
	}
	
	
	// 관리자 신고 내역 조회
	@Override
	public List<Report> reportManage() {
		List<Report> reportMange = reviewDao.reportMange();
		return reportMange;
	}

	// 신고 내역 검색
	@Override
	public List<Report> reportSearch(ById byId, ByRpno rpno, String search, String answer) {
		
		List<Report> reports = null;
		// 전체 리스트
		if(answer.equals("Y")) {
			// 아이디로 검색
			if(search.equals("1")) {
				reports = reviewDao.reportByAnswerId(byId);
			} //번호로 검색 
			else if(search.equals("2")){
				reports = reviewDao.reportByRpno(rpno);
			} 
		} // 미답변 리스트 
		else if(answer.equals("N")) {
			// 아이디로 검색
			if(search.equals("1")) {
				reports = reviewDao.reportByAnswerId(byId);
			} //번호로 검색 
			else if(search.equals("2")){
				reports = reviewDao.reportByAnswerRpno(rpno);
			}
			else {
				reports = reviewDao.reportByAnswer(answer);
			}
		} 
		
		return reports;
	} 
	
	
	// 관리자 댓글 삭제
	@Override
	public String mReviewDelete(String rid) {
		int cnt = reviewDao.delete(rid);
		String deleteBtn = null;
		if(cnt == 1) {
			System.out.println("server> 댓글 삭제 성공");
			deleteBtn = "S";
		} else {
			System.out.println("server> 댓글 삭제 실패");
		}
		return deleteBtn;
	}

	
	// 댓글 리뷰 처리답변
	@Override
	public String reviewAnswer(ReportManage rm) {
		String process = null;
		int cnt= reviewDao.answer(rm);
		if(cnt == 1) {
			System.out.println("server> 답변 처리 완료");
			process = "S";
		} else {
			System.out.println("server> 답변 처리 실패");
		}
		return process;
	}

	@Override
	public ReviewProcess reviewProcess(String rid) {
		ReviewProcess rp = reviewDao.reviewProcess(rid);
		return rp;
	}


}
