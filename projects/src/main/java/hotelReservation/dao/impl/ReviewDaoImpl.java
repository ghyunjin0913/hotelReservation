package hotelReservation.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Repository
public class ReviewDaoImpl implements ReviewDao{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<MyReview> reviewList(String cid) {
		List<MyReview> reviewList = sqlSessionTemplate.selectList(
				"review.reviewList", cid);
		return reviewList;
	}
	
	@Override
	public ReviewInfo reviewInfo(ReviewInfo reviewInfo) {
		ReviewInfo info = sqlSessionTemplate.selectOne(
				"review.reviewInfo", reviewInfo);
		return info;
	}

	@Override
	public int reviewRegister(Review review) {
		int count = sqlSessionTemplate.insert(
				"review.reviewRegister", review);
		return count;
	}

	
	@Override
	public int reviewUpdate(UpdateReview updateReview) {
		int count = sqlSessionTemplate.update(
				"review.reviewUpdate", updateReview);
		return count;
	}

	@Override
	public int reviewDelete(String rid) {
		int count = sqlSessionTemplate.delete(
				"review.reviewDelete", rid);
		return count;
	}
	
	
	
	@Override
	public List<ReviewList> reviewCus(String tcode) {
		List<ReviewList> review = sqlSessionTemplate.selectList(
				"review.reviewCus", tcode);
		return review;
	}

	@Override
	public List<Review> hReviewList(String hid) {
		List<Review> reviewList = sqlSessionTemplate.selectList(
				"review.hReviewList", hid);
		return reviewList;
	}

	@Override
	public AnswerInfo anwerInfo(String rid) {
		AnswerInfo answerInfo = sqlSessionTemplate.selectOne(
				"review.answerInfo", rid);
		return answerInfo;
	}

	@Override
	public ReviewList reviewHot(String rid) {
		ReviewList review = sqlSessionTemplate.selectOne(
				"review.reviewHot", rid);
		return review;
	}

	
	@Override
	public List<Review> searchTcode(SearchReview searchReview) {
		List<Review> search = sqlSessionTemplate.selectList(
				"review.searchTcode", searchReview);
		return search;
	}
	
	@Override
	public List<Review> nullAnswer(String hid) {
		List<Review> search = sqlSessionTemplate.selectList(
				"review.nullAnswer", hid);
		return search;
	}
	
	@Override
	public List<Review> nullAndTcode(SearchReview searchReview) {
		List<Review> search = sqlSessionTemplate.selectList(
				"review.nullAndTcode", searchReview);
		return search;
	}

	
	@Override
	public int answerUpdate(UpdateAnswer updateAnswer) {
		int count = sqlSessionTemplate.update(
				"review.answerUpdate", updateAnswer);
		return count;
	}
	
	// 신고 번호 생성
	@Override
	public String createRpno(String rpdate) {
		String rpno = sqlSessionTemplate.selectOne("review.createRpno", rpdate);
		return rpno;
	}

	// 리뷰 신고
	@Override
	public int report(Report r) {
		int cnt = sqlSessionTemplate.insert("review.report", r);
		return cnt;  
	}

	// 동일인 리뷰 재신고 방지
	@Override
	public int prevent(Prevent p) {
		int cnt = sqlSessionTemplate.selectOne("review.prevent", p);
		return cnt;
	}

	// 내 신고 내역
	@Override
	public List<MyReport> reportList(Prevent p) {
		List<MyReport> reportList = sqlSessionTemplate.selectList("review.myReport", p);
		return reportList;
	}
	
	// 관리자 신고 내역 조회
	@Override
	public List<Report> reportMange() {
		List<Report> reportManage = sqlSessionTemplate.selectList("review.reviewManage");
		return reportManage;
	}
	

	@Override
	public List<Report> reportById(ById byId) {
		List<Report> reportManage = sqlSessionTemplate.selectList("review.reviewById", byId);
		return reportManage;
	}

	@Override
	public List<Report> reportByRpno(ByRpno rpno) {
		List<Report> reportManage = sqlSessionTemplate.selectList("review.reviewByRpno", rpno);
		return reportManage;
	}
	
	@Override
	public List<Report> reportByAnswerId(ById byId) {
		List<Report> reportManage = sqlSessionTemplate.selectList("review.reviewByAnswerId", byId);
		return reportManage;
	}

	@Override
	public List<Report> reportByAnswerRpno(ByRpno rpno) {
		List<Report> reportManage = sqlSessionTemplate.selectList("review.reviewByAnswerRpno", rpno);
		return reportManage;
	}
	

	@Override
	public List<Report> reportByAnswer(String answer) {
		List<Report> reportManage = sqlSessionTemplate.selectList("review.reviewByAnswer", answer);
		return reportManage;
	}

	
	// 관리자 리뷰 삭제
	@Override
	public int delete(String rid) {
		int cnt = sqlSessionTemplate.update("review.delete", rid);
		return cnt;
	}

	// 관리자 리뷰 처리 답변
	@Override
	public int answer(ReportManage rm) {
		int cnt = sqlSessionTemplate.update("review.answer", rm);
		return cnt;
	}

	// 관리자 리뷰 처리 댓글 정보
	@Override
	public ReviewProcess reviewProcess(String rid) {
		ReviewProcess rp = sqlSessionTemplate.selectOne("review.reviewProcess", rid);
		return rp;
	}


}
