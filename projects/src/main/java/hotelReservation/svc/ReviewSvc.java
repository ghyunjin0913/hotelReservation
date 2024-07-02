package hotelReservation.svc;

import java.util.List;

import hotelReservation.dto.review.AnswerInfo;
import hotelReservation.dto.review.ById;
import hotelReservation.dto.review.ByRpno;
import hotelReservation.dto.review.MyReport;
import hotelReservation.dto.review.MyReview;
import hotelReservation.dto.review.Report;
import hotelReservation.dto.review.ReportManage;
import hotelReservation.dto.review.Review;
import hotelReservation.dto.review.ReviewInfo;
import hotelReservation.dto.review.ReviewList;
import hotelReservation.dto.review.ReviewProcess;
import hotelReservation.dto.review.SearchReview;
import hotelReservation.dto.review.UpdateAnswer;
import hotelReservation.dto.review.UpdateReview;

public interface ReviewSvc {
	List<MyReview> reviewList(String cid);
	ReviewInfo reviewInfo(String rid);
	int reviewRegister(Review review);
	int reviewUpdate(UpdateReview updateReview);
	int reviewDelete(String rid);
	List<ReviewList> reviewCus(String tcode);
	List<Review> hReviewList(String hid);
	AnswerInfo answerInfo(String rid);
	ReviewList reviewHot(String rid);
	List<Review> searchReview(String answer, String hid, SearchReview searchReview);
	int answerUpdate(UpdateAnswer updateAnswer);
	
	
	String checkReport(String rid, String type, String id);
	String report(String rid, String type, String id, String reason);
	
	List<MyReport> reportList(String type, String id);
	
	
	List<Report> reportManage();
	List<Report> reportSearch(ById byId, ByRpno rpno, String search, String answer);
	String mReviewDelete(String rid);
	String reviewAnswer(ReportManage rm);
	
	ReviewProcess reviewProcess(String rid);
}
