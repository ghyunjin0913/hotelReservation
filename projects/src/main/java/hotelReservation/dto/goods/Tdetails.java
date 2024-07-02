package hotelReservation.dto.goods;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tdetails {
	
	private String tcode;
	private String exp;
	private String bedtype;
	private int bedno;
	private String tview;
	private String smoke;
	private int tsize;
	private String bathtype;
	private String breakfast;
	
	public Tdetails() {}
	public Tdetails(String tcode, String exp, String bedtype, 
			int bedno, String tview, String smoke, int tsize,
			String bathtype, String breakfast) {
		this.tcode = tcode;
		this.exp = exp;
		this.bedtype = bedtype;
		this.bedno = bedno;
		this.tview = tview;
		this.smoke = smoke;
		this.tsize = tsize;
		this.bathtype = bathtype;
		this.breakfast = breakfast;
	}
	
}
