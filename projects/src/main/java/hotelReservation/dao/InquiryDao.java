package hotelReservation.dao;

import java.util.List;

import hotelReservation.dto.AnswerInquiry;
import hotelReservation.dto.Inquiry;
import hotelReservation.dto.Insertinquiry;

public interface InquiryDao {

	List<Inquiry> boardSelectById(String id);
	List<Inquiry> boardList();
	Inquiry readBoard(int ino);
	int updateBoard(Inquiry inquiry);
	int deleteBoard(int ino);
	int insertBoard(Insertinquiry insertInquiry);
	int answerBoard(AnswerInquiry answer);
	
	
}
