package hotelReservation.dao;

import java.util.List;


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

public interface ReviewDao {
	List<MyReview> reviewList(String cid);
	ReviewInfo reviewInfo(ReviewInfo reviewInfo);
	int reviewRegister(Review review);
	int reviewUpdate(UpdateReview updateReview);
	int reviewDelete(String rid);	
	List<ReviewList> reviewCus(String tcode);
	List<Review> hReviewList(String hid);
	AnswerInfo anwerInfo(String rid);
	ReviewList reviewHot(String rid);
	List<Review> searchTcode(SearchReview searchReview);
	List<Review> nullAnswer(String hid);
	List<Review> nullAndTcode(SearchReview searchReview);
	int answerUpdate(UpdateAnswer updateAnswer);
	
	int report(Report r);
	int prevent(Prevent p);
	String createRpno(String rpdate);
	List<MyReport> reportList(Prevent p);
	
	List<Report> reportMange();
	List<Report> reportById(ById byId);
	List<Report> reportByRpno(ByRpno rpno);
	List<Report> reportByAnswer(String answer);
	List<Report> reportByAnswerId(ById byId);
	List<Report> reportByAnswerRpno(ByRpno rpno);
	
	
	int delete(String rid);
	int answer(ReportManage rm);
	
	ReviewProcess reviewProcess(String rid);
}
