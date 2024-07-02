package hotelReservation.dto.goods;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Room {
	private String tcode;
	private String tname;
	private int max;
	private int tprice;
	private int amounts;
	//private String tpicture;
	private String hid;
	private String exp;
	private String bedtype;
	private int bedno;
	private String tview;
	private String smoke;
	private int tsize;
	private String bathtype;
	private String breakfast;
	
	public Room() {}
	
	@Override
	public String toString() {
		return "Room [tcode=" + tcode + ", tname=" + tname + ", max=" + max + ", tprice=" + tprice + ", amounts="
				+ amounts + ", hid=" + hid + ", exp=" + exp + ", bedtype=" + bedtype + ", bedno=" + bedno + ", tview="
				+ tview + ", smoke=" + smoke + ", tsize=" + tsize + ", bathtype=" + bathtype + ", breakfast="
				+ breakfast + "]";
	}
	
	
	
}
