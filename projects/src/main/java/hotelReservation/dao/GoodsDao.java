package hotelReservation.dao;

import java.util.List;

import hotelReservation.dto.goods.Hdetails;
import hotelReservation.dto.goods.Hotel;
import hotelReservation.dto.goods.Room;
import hotelReservation.dto.goods.SearchHotel;
import hotelReservation.dto.goods.SearchResult;
import hotelReservation.dto.goods.Tdetails;
import hotelReservation.dto.goods.Type;
import hotelReservation.dto.goods.UpdateHotelDetail;

public interface GoodsDao {
	
	Hotel selectHotel(String hid);
	int updateHotel(UpdateHotelDetail updateConditions);
	String findMaxTcode(String hid);
	int registerGoods(Type type);
	String findTcode(String hid);
	int registerGoodsDetails(Tdetails tdetails);
	List<SearchResult> hotelList();
	List<SearchResult> searchList(SearchHotel sh);
	List<SearchResult> searchHotel(SearchHotel sh);
	List<Type> hotelDetails(Hdetails hdetails);
	Type goodsType(String tcode);
	Tdetails goodsDetails(String tcode);
	List<Room> roomManage(String hid);
	int deleteGoods(String tcode);
	int updateGoods(Type type);
	int updateGoodsDetail(Tdetails tdetails);
	
}