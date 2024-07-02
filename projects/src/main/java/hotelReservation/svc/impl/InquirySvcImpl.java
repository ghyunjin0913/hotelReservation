package hotelReservation.svc.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hotelReservation.dao.InquiryDao;
import hotelReservation.dto.AnswerInquiry;
import hotelReservation.dto.Inquiry;
import hotelReservation.dto.Insertinquiry;
import hotelReservation.svc.InquirySvc;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service
public class InquirySvcImpl implements InquirySvc {

	@Autowired
	private InquiryDao inquirydao;
	
	@Override
	public List<Inquiry> boardSelectById(String id) {
		return inquirydao.boardSelectById(id);
	}

	@Override
	public List<Inquiry> boardList() {
		return inquirydao.boardList();
	}

	@Override
	public Inquiry readBoard(int ino) {
		return inquirydao.readBoard(ino);
	}

	@Transactional
	@Override
	public int updateBoard(Inquiry inquiry) {
		return inquirydao.updateBoard(inquiry);
	}

	@Transactional
	@Override
	public int deleteBoard(int ino) {
		return inquirydao.deleteBoard(ino);
	}

	@Transactional
	@Override
	public int insertBoard(Insertinquiry insertInquiry) {
		return inquirydao.insertBoard(insertInquiry);
	}

	@Transactional
	@Override
	public int answerBoard(AnswerInquiry answer) {
		return inquirydao.answerBoard(answer);
	}

}
