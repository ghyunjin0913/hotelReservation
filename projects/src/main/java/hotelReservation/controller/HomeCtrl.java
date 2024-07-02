package hotelReservation.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.Getter;
import lombok.Setter;

@Controller
@Getter
@Setter
public class HomeCtrl {
	
	private HttpSession session;
	
	@RequestMapping(value="/homePage")
	public String home(Model model) {	

		String id = null;
		if(session != null) {
	        if (session.getAttribute("cid") != null) {
	            id = (String) session.getAttribute("cid");
	            System.out.println("cid: " + id);
	        } else if (session.getAttribute("eid") != null) {
	            id = (String) session.getAttribute("eid");
	            System.out.println("eid: " + id);
	        } else if (session.getAttribute("hid") != null) {
	            id = (String) session.getAttribute("hid");
	            System.out.println("hid: " + id);
	        }
	        if (id != null) {
	            session.setAttribute("id", id);
	        }
		}
		model.addAttribute("sessionScope", session);

		return "main/main";
	}
	
	@RequestMapping(value="/myPage")
	public String myPage(Model model) {	

		String id = null;
		if(session != null) {
	        if (session.getAttribute("cid") != null) {
	            id = (String) session.getAttribute("cid");
	            System.out.println("cid: " + id);
	        } else if (session.getAttribute("eid") != null) {
	            id = (String) session.getAttribute("eid");
	            System.out.println("eid: " + id);
	        } else if (session.getAttribute("hid") != null) {
	            id = (String) session.getAttribute("hid");
	            System.out.println("hid: " + id);
	        }
	        if (id != null) {
	            session.setAttribute("id", id);
	        }
		}
		model.addAttribute("sessionScope", session);

		return "main/side";
	}
	
	

}