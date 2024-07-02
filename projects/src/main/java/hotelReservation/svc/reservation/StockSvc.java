package hotelReservation.svc.reservation;

import hotelReservation.dto.reservation.Stock;

public interface StockSvc {
	
	int addStock(Stock stock);
	int subtractStock(Stock stock);
	
}
