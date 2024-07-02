package hotelReservation.dao.impl.reservation;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hotelReservation.dao.reservation.StockDao;
import hotelReservation.dto.reservation.Stock;
import lombok.Getter;
import lombok.Setter;

@Repository
@Getter
@Setter
public class StockDaoImpl implements StockDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	@Override
	public int addStock(Stock stock) {
		int cnt = sqlSessionTemplate.update("stock.add", stock);
		return cnt;
	}

	@Override
	public int subtractStock(Stock stock) {
		int cnt = sqlSessionTemplate.update("stock.subtract", stock);
		return cnt;
	}

}
