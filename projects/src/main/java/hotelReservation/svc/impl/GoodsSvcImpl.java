package hotelReservation.svc.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hotelReservation.dao.GoodsDao;
import hotelReservation.dto.goods.Hdetails;
import hotelReservation.dto.goods.Hotel;
import hotelReservation.dto.goods.Room;
import hotelReservation.dto.goods.SearchHotel;
import hotelReservation.dto.goods.SearchResult;
import hotelReservation.dto.goods.Tdetails;
import hotelReservation.dto.goods.Type;
import hotelReservation.dto.goods.UpdateHotelDetail;
import hotelReservation.dto.reservation.Reserve;
import hotelReservation.svc.GoodsSvc;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service
public class GoodsSvcImpl implements GoodsSvc {
	
	@Autowired
	private GoodsDao goodsDao;

	
	@Override
	public Hotel selectHotel(String hid) {
		if(hid != null) {
			Hotel hotel = goodsDao.selectHotel(hid);
			return hotel;
		}
		return null;
	}

	@Override
	public int updateHotel(String hid, UpdateHotelDetail updateConditions) {
		updateConditions.setHid(hid);
		int count = goodsDao.updateHotel(updateConditions);
		return count;
	}
	
	@Override
	public String findMaxTcode(String hid) {
		String findTcode = goodsDao.findMaxTcode(hid);
		return findTcode;
	}
	
	@Override
	public int registerGoods(String tcode, Type type, String hid) {
		type.setTcode(tcode);
		type.setHid(hid);
		
		int count = goodsDao.registerGoods(type);
		return count;
	}
	
		
	@Override
	public String findTcode(String hid) {
		String findTcode = goodsDao.findTcode(hid);
		return findTcode;
	}
	
	@Override
	public int registerGoodsDetails(Tdetails tdetails) {
		String exp = tdetails.getExp();
		exp = exp.replace("\r\n","<br>");
		tdetails.setExp(exp);
		
		int count = goodsDao.registerGoodsDetails(tdetails);
		return count;
	}
	
	@Override
	public List<SearchResult> hotelList() {
		List<SearchResult> hotelList = goodsDao.hotelList();
		return hotelList;
	}
	
	@Override
	public List<SearchResult> searchList(SearchHotel sh) {
		
		Reserve reserve = new Reserve();
		reserve.setCheckin(sh.getCheckIn());
		reserve.setCheckout(sh.getCheckOut());
		reserve.setPerson(sh.getPerson());
		List<SearchResult> searchList = goodsDao.searchList(sh);
		return searchList;
	}
	

	@Override
	public List<SearchResult> searchHotel(SearchHotel sh) {
		
		Reserve reserve = new Reserve();
		reserve.setCheckin(sh.getCheckIn());
		reserve.setCheckout(sh.getCheckOut());
		reserve.setPerson(sh.getPerson());
		List<SearchResult> searchList = goodsDao.searchHotel(sh);
		return searchList;
	}
	
	@Override
	public List<Type> hotelDetails(Hdetails hdetails) {
		List<Type> detailList = goodsDao.hotelDetails(hdetails);
		return detailList;
	}
	
	@Override
	public Type goodsType(String tcode) {
		Type type = goodsDao.goodsType(tcode);
		return type;
	}

	@Override
	public Tdetails goodsDetails(String tcode) {
		Tdetails tdetails = goodsDao.goodsDetails(tcode);
		return tdetails;
	}

	@Override
	public List<Room> roomManage(String hid) {
		List<Room> roomList = goodsDao.roomManage(hid);
		
		return roomList;
	}
	
	@Override
	public int deleteGoods(String tcode) {
		int count = goodsDao.deleteGoods(tcode);
		
		return count;
	}
	@Override
	public int updateGoods(Type type) {	
		int count = goodsDao.updateGoods(type);
		return count;
	}
	
	@Override
	public int updateGoodsDetail(Tdetails tdetails) {
		int count = goodsDao.updateGoodsDetail(tdetails);
		return count;
	}
}


