package hotelReservation.login.common;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import hotelReservation.dto.EmpLogIn;
import hotelReservation.svc.LogInSvc;
import lombok.Getter;

@Getter
public abstract class ManageCommon {

	@Autowired
	private LogInSvc loginSvc;
	@Autowired
	private HttpSession session;
	
	
	public abstract String requestManagePage(Model model);
	public abstract String checkReservationCtrl(Model model);
	public abstract String updateReserveCount();
	public abstract String checkEmployeeCtrl(Model model);
	public abstract String checkWithdrawCtrl(Model model);
	
	public String empSession() {
		if(session != null) {
			String eid = (String) session.getAttribute("eid");
			String epw = (String) session.getAttribute("epw");
			EmpLogIn emplogin = new EmpLogIn(eid, epw);
			String ename = loginSvc.eLogIn(emplogin);
			return ename;
		}
		return null;
	}
	
	
		
	
}
