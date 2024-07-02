package hotelReservation.login.common;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import hotelReservation.dto.CustomerLogIn;
import hotelReservation.dto.CustomerSignUp;
import hotelReservation.dto.EmpLogIn;
import hotelReservation.dto.EmpSignUp;
import hotelReservation.dto.HotelLogIn;
import hotelReservation.dto.HotelSignUp;
import lombok.Getter;

@Getter
public abstract class LogInCommon {
	
	@Autowired
	private HttpSession session;

	public abstract String logInPage();
	public abstract String cLoginCtrl(@ModelAttribute CustomerLogIn clogIn, Model model);
	public abstract String eLogInCtrl(@ModelAttribute EmpLogIn elogIn, Model model);
	public abstract String hLogInCtrl(@ModelAttribute HotelLogIn hlogIn, Model model);
	public abstract String cSignUp();
	public abstract String cidCheck(@RequestParam("cid") String cid);
	public abstract String eSignUp();
	public abstract String eidCheck(@RequestParam("eid") String eid);
	public abstract String hSignUp();
	public abstract String hidCheck(@RequestParam("hid") String hid);
	public abstract String cSignUpCtrl(@ModelAttribute CustomerSignUp csu);
	public abstract String eSignUpCtrl(@ModelAttribute EmpSignUp esu);
	public abstract String hSignUpCtrl(@ModelAttribute HotelSignUp hsu);
	public abstract String successPage();
	public abstract String myInfoCtrl(Model model);	
	public abstract String logOutCtrl(Model model);
	
	public void setSession(CustomerLogIn clogIn) {
		session.setAttribute("id", clogIn.getCid());
		session.setAttribute("cid", clogIn.getCid());
		session.setAttribute("cpw", clogIn.getCpw());
	}
	
	public void setSession(EmpLogIn elogIn) {
		session.setAttribute("id", elogIn.getEid());
		session.setAttribute("eid", elogIn.getEid());
		session.setAttribute("epw", elogIn.getEpw());
	}
	
	public void setSession(HotelLogIn hlogIn) {
		session.setAttribute("id", hlogIn.getHid());
		session.setAttribute("hid", hlogIn.getHid());
		session.setAttribute("hpw", hlogIn.getHpw());
	}
	
	public HashMap<String, String> getSession() {
		String cid = (String)session.getAttribute("cid");
		String eid = (String)session.getAttribute("eid");
		String hid = (String)session.getAttribute("hid");
		String cpw = (String)session.getAttribute("cpw");
		HashMap<String, String> sessionMap = new HashMap<String, String>();
		sessionMap.put("cid", cid);
		sessionMap.put("eid", eid);
		sessionMap.put("hid", hid);
		sessionMap.put("cpw", cpw);
		return sessionMap;
	}
	
	public void logOut() {
		session.invalidate();
	}	
}

