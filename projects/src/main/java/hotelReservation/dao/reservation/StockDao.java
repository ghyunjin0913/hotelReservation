package hotelReservation.dao.reservation;

import hotelReservation.dto.reservation.Stock;

public interface StockDao {

	int addStock(Stock stock);
	int subtractStock(Stock stock);
	
}
