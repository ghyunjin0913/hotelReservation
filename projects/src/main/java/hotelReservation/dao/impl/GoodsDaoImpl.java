package hotelReservation.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hotelReservation.dao.GoodsDao;
import hotelReservation.dto.goods.Hdetails;
import hotelReservation.dto.goods.Hotel;
import hotelReservation.dto.goods.Room;
import hotelReservation.dto.goods.SearchHotel;
import hotelReservation.dto.goods.SearchResult;
import hotelReservation.dto.goods.Tdetails;
import hotelReservation.dto.goods.Type;
import hotelReservation.dto.goods.UpdateHotelDetail;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Repository
public class GoodsDaoImpl implements GoodsDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	

	@Override
	public Hotel selectHotel(String hid) {
		Hotel hotel = sqlSessionTemplate.selectOne("goods.selectHotel", hid);
		return hotel;
	}

	
	@Override
	public int updateHotel(UpdateHotelDetail updateConditions) {		
		int count = sqlSessionTemplate.update("goods.updateHotel", updateConditions);	
		return count;
	}

	
	@Override
	public String findMaxTcode(String hid) {		
		String findTcode = sqlSessionTemplate.selectOne("goods.findMaxTcode", hid);
		return findTcode;
	}
		
	
	@Override
	public int registerGoods(Type type) {	
		int count = sqlSessionTemplate.insert("goods.registerGoods", type);
		return count;
	}
	
	@Override
	public String findTcode(String hid) {	
		String findTcode = sqlSessionTemplate.selectOne("goods.findTcode", hid);
		return findTcode;
	}
	
	
	@Override
	public int registerGoodsDetails(Tdetails tdetails) {	
		int count = sqlSessionTemplate.insert("goods.registerGoodsDetails", tdetails);
		return count;
	}

	
	@Override
	public List<SearchResult> hotelList() {	
		List<SearchResult> hotelList = sqlSessionTemplate.selectList("goods.hotelList");
		return hotelList;
	}

	
	@Override
	public List<SearchResult> searchList(SearchHotel sh) {
		List<SearchResult> searchList = sqlSessionTemplate.selectList("goods.searchList", sh);
		return searchList;
	}

	@Override
	public List<SearchResult> searchHotel(SearchHotel sh) {
		List<SearchResult> searchList = sqlSessionTemplate.selectList("goods.searchHotel", sh);
		return searchList;
	}

	
	@Override
	public List<Type> hotelDetails(Hdetails hdetails) {
		List<Type> detailList = sqlSessionTemplate.selectList("goods.hotelDetails", hdetails);
		return detailList;
	}
	
	
	@Override
	public Type goodsType(String tcode) {
		Type type = sqlSessionTemplate.selectOne("goods.goodsType", tcode);
		return type;
	}

	
	@Override
	public Tdetails goodsDetails(String tcode) {
		Tdetails tdetails = sqlSessionTemplate.selectOne("goods.goodsDetails", tcode);
		return tdetails;
	}


	@Override
	public List<Room> roomManage(String hid) {
		List<Room> roomlist = sqlSessionTemplate.selectList("goods.roomManage", hid);
		return roomlist;
	}
	
	@Override
	public int deleteGoods(String tcode) {		
		int count = sqlSessionTemplate.delete("goods.deleteGoods", tcode);
		return  count;
	}
	
	@Override
	public int updateGoods(Type type) {		
		int count = sqlSessionTemplate.update("goods.updateGoods", type);	
		return count;
	}
	
	@Override
	public int updateGoodsDetail(Tdetails tdetails) {		
		int count = sqlSessionTemplate.update("goods.updateGoodsDetail", tdetails);	
		return count;
	}
}