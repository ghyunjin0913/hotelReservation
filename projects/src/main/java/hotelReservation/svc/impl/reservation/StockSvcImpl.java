package hotelReservation.svc.impl.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hotelReservation.dao.reservation.StockDao;
import hotelReservation.dto.reservation.Stock;
import hotelReservation.svc.reservation.StockSvc;
import lombok.Getter;
import lombok.Setter;

@Service
@Getter
@Setter
public class StockSvcImpl implements StockSvc {
	
	@Autowired
	private StockDao stockDao;

	
	@Override
	public int addStock(Stock stock) {
		
		int cnt = stockDao.addStock(stock);
		return cnt;
	}

	
	@Override
	public int subtractStock(Stock stock) {
		
		int cnt = stockDao.subtractStock(stock);
		return cnt;
	}
	
}
