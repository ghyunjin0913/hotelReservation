package hotelReservation.dao.impl.reservation;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hotelReservation.dao.reservation.PayDao;
import hotelReservation.dto.CustomerLogIn;
import hotelReservation.dto.HotelInfo;
import hotelReservation.dto.reservation.CreatePid;
import hotelReservation.dto.reservation.Pay;
import lombok.Getter;
import lombok.Setter;

@Repository
@Getter
@Setter
public class PayDaoImpl implements PayDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	@Override
	public String payCid(String cid) {
		String rCid = sqlSessionTemplate.selectOne("pay.payCid", cid);
		return rCid;
	}

	@Override
	public String payLogIn(CustomerLogIn cl) {
		String cpw = sqlSessionTemplate.selectOne("pay.payLogIn", cl);
		return cpw;
	}

	
	@Override
	public int priceInfo(String tcode) {	
		int price = sqlSessionTemplate.selectOne("pay.priceInfo", tcode);
		return price;
	}

	
	@Override
	public String createPid(CreatePid cp) {	
		String pid = sqlSessionTemplate.selectOne("pay.createPid", cp);
		return pid;
	}
	
	
	@Override
	public int payInfo(Pay pay) {
		int cnt = sqlSessionTemplate.insert("pay.payInfo", pay);
		return cnt;
	}

	



	@Override
	public HotelInfo completeInfo(String tcode) {	
		HotelInfo hInfo = sqlSessionTemplate.selectOne("pay.complete", tcode); 
		return hInfo;
	}
	
	
	@Override
	public String cancelPid(String rid) {	
		String pid = sqlSessionTemplate.selectOne("pay.cancelPid", rid);
		return pid;
	}
	
	
	@Override
	public int cancel(String pid) {		
		int cnt = sqlSessionTemplate.delete("pay.cancel", pid);
		return cnt;
	}

}
