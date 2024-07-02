package hotelReservation.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hotelReservation.dao.InquiryDao;
import hotelReservation.dto.AnswerInquiry;
import hotelReservation.dto.Inquiry;
import hotelReservation.dto.Insertinquiry;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Repository
public class InquiryDaoImpl implements InquiryDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<Inquiry> boardSelectById(String id) {
		
		return sqlSessionTemplate.selectList("inquiry.boardSelectById", id);
	}

	@Override
	public List<Inquiry> boardList() {
		return sqlSessionTemplate.selectList("inquiry.boardList");
	}

	@Override
	public Inquiry readBoard(int ino) {
		return sqlSessionTemplate.selectOne("inquiry.readBoard", ino);
	}

	@Override
	public int updateBoard(Inquiry inquiry) {
		return sqlSessionTemplate.update("inquiry.updateBoard", inquiry);
	}

	@Override
	public int deleteBoard(int ino) {
		return sqlSessionTemplate.delete("inquiry.deleteBoard", ino);
	}

	@Override
	public int insertBoard(Insertinquiry insertInquiry) {
		return sqlSessionTemplate.insert("inquiry.insertBoard", insertInquiry);
	}

	@Override
	public int answerBoard(AnswerInquiry answer) {
		return sqlSessionTemplate.update("inquiry.answerBoard", answer);
	}

}
