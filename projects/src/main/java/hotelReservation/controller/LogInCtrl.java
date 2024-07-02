package hotelReservation.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hotelReservation.dto.CustomerLogIn;
import hotelReservation.dto.CustomerSignUp;
import hotelReservation.dto.EmpLogIn;
import hotelReservation.dto.EmpSignUp;
import hotelReservation.dto.HotelLogIn;
import hotelReservation.dto.HotelSignUp;
import hotelReservation.dto.UpdateCustomer;
import hotelReservation.dto.UpdateEmp;
import hotelReservation.dto.UpdateHotel;
import hotelReservation.dto.Withdraw;
import hotelReservation.login.common.LogInCommon;
import hotelReservation.svc.LogInSvc;

@Controller
public class LogInCtrl extends LogInCommon {

		@Autowired
		private LogInSvc logInSvc;
		
		// 로그인 페이지 이동;
		@RequestMapping(value = "/logIn")
		public String logInPage() {
			return "logIn/logInForm";
		}
		
		// 고객 로그인 컨트롤
		@Override
		@RequestMapping(value = "/cLogInCtrl", method = RequestMethod.POST)
		public String cLoginCtrl(@ModelAttribute CustomerLogIn clogIn, Model model) {
		    String cname = logInSvc.cLogIn(clogIn);
		    if(cname != null) {
		        setSession(clogIn);
		        return "main/main";
		    } else {
		        if(logInSvc.cidCheck(clogIn.getCid()) == 0) {
		            model.addAttribute("result", "no_id");
		            model.addAttribute("type", "customer"); // 추가된 부분
		        } else {
		            model.addAttribute("result", "wrong_pw");
		            model.addAttribute("type", "customer"); // 추가된 부분
		        }
		        return "logIn/logInForm";
		    }
		}

		// 사원 로그인 컨트롤
		@RequestMapping(value = "/eLogInCtrl", method = RequestMethod.POST)
		public String eLogInCtrl(@ModelAttribute EmpLogIn elogIn, Model model) {
		    String ename = logInSvc.eLogIn(elogIn);
		    if(ename != null) {
		        setSession(elogIn);
		        return "main/main";
		    } else {
		        if(logInSvc.eidCheck(elogIn.getEid()) == 0) {
		            model.addAttribute("result", "no_id");
		            model.addAttribute("type", "employee"); // 추가된 부분
		        } else {
		            model.addAttribute("result", "wrong_pw");
		            model.addAttribute("type", "employee"); // 추가된 부분
		        }
		        return "logIn/logInForm";
		    }
		}

		// 호텔 로그인 컨트롤
		@RequestMapping(value = "/hLogInCtrl", method = RequestMethod.POST)
		public String hLogInCtrl(@ModelAttribute HotelLogIn hlogIn, Model model) {
		    String hname = logInSvc.hLogIn(hlogIn);
		    if(hname != null) {
		        setSession(hlogIn);
		        return "main/main";
		    } else {
		        if(logInSvc.hidCheck(hlogIn.getHid()) == 0) {
		            model.addAttribute("result", "no_id");
		            model.addAttribute("type", "hotel"); // 추가된 부분
		        } else {
		            model.addAttribute("result", "wrong_pw");
		            model.addAttribute("type", "hotel"); // 추가된 부분
		        }
		        return "logIn/logInForm";
		    }
		}

		/*
		 * 회원가입시 생성규칙을 확인하지 않음
		 * */
		// 고객 회원가입 페이지 이동
		@RequestMapping(value = "/cSignUp")
		public String cSignUp() {
			return "logIn/cSignUpForm";
		}
		
		
		// 고객 회원가입 중복체크
		@RequestMapping(value = "/cidCheck", method = RequestMethod.POST)
		@ResponseBody
		public String cidCheck(@RequestParam("cid") String cid) {
			
			int result = logInSvc.cidCheck(cid);
			System.out.println(cid +"\n" + result);
			if(result == 1) { return "duplicate"; } 
			else { return "not_duplicate"; }
			
		}
		
		
		// 사원 회원가입 페이지 이동
		@RequestMapping(value = "/eSignUp")
		public String eSignUp() {
			return "logIn/eSignUpForm";
		}
		
		
		// 사원 회원가입 중복 체크
		@RequestMapping(value = "/eidCheck", method = RequestMethod.POST)
		@ResponseBody
		public String eidCheck(@RequestParam("eid") String eid) {
			
			int result = logInSvc.eidCheck(eid);
			System.out.println(eid +"\n" + result);
			
			if(result == 1) { return "duplicate"; }
			else { return "not_duplicate"; }
			
		}
		
		
		// 호텔 회원가입 페이지 이동
		@RequestMapping(value = "/hSignUp")
		public String hSignUp() {
			return "logIn/hSignUpForm";
		}
		
		
		// 호텔 회원가입 중복체크
		@RequestMapping(value = "/hidCheck", method = RequestMethod.POST)
		@ResponseBody
		public String hidCheck(@RequestParam("hid") String hid) {
			
			int result = logInSvc.hidCheck(hid);
			System.out.println(hid +"\n" + result);
			
			if(result == 1) { return "duplicate"; }
			else { return "not_duplicate";}
			
		}
		
		
		// 고객 회원가입 컨트롤
		@RequestMapping(value = "/cSignUpCtrl", method = RequestMethod.POST)
		public String cSignUpCtrl(@ModelAttribute CustomerSignUp csu) {
			int check = logInSvc.cidCheck(csu.getCid());
			if(check == 1) {
				return "logIn/cSignUpForm";
				
			} 
			else if(check == 0) {
				int result = logInSvc.cSignUp(csu);
				System.out.println(result);
			}
			return "logIn/logInForm";
		}
		
		
		// 사원 회원가입 컨트롤
		@RequestMapping(value = "/eSignUpCtrl", method = RequestMethod.POST)
		public String eSignUpCtrl(@ModelAttribute EmpSignUp esu) {
			int check = logInSvc.eidCheck(esu.getEid());
			if(check == 1) {
				return "logIn/eSignUpForm";
			}
			else if(check == 0) {
				int result = logInSvc.eSignUp(esu);
				System.out.println(result);
			}
			return "logIn/logInForm";
		}
		
		
		// 호텔 회원가입 컨트롤
		@RequestMapping(value = "/hSignUpCtrl", method = RequestMethod.POST)
		public String hSignUpCtrl(@ModelAttribute HotelSignUp hsu) {
			int check = logInSvc.hidCheck(hsu.getHid());
			if(check == 1) {
				return "logIn/hSignUpForm";
			}
			else if(check == 0) {
				int result = logInSvc.hSignUp(hsu);
				System.out.println(result);
			}
			return "logIn/logInForm";
		}
		
		
		// 고객 정보 조회 후 확인 버튼 누르면 나오는 페이지
		@RequestMapping(value = "/success")
		public String successPage() {
			return "main/main";
		}
		
		// 마이페이지 조회
		@RequestMapping(value="/myInfoCtrl")
		public String myInfoCtrl(Model model) {
			HashMap<String, String> sessionMap = getSession();
			if(sessionMap.get("cid") != null) {
				model.addAttribute("cMyInfo", logInSvc.cMyinfo(sessionMap.get("cid")));
				return "logIn/cMyInfoForm";
			}
			else if(sessionMap.get("eid") != null) {
				model.addAttribute("eMyInfo", logInSvc.eMyInfo(sessionMap.get("eid")));
				return "logIn/eMyInfoForm";
			}
			else if(sessionMap.get("hid") != null) {
				model.addAttribute("hMyInfo", logInSvc.hMyInfo(sessionMap.get("hid")));
				return "logIn/hMyInfoForm";
			}
			else {
				return "redirect:/logIn";
			}
		}
		
		// 고객 정보 수정
		@RequestMapping(value="/updateCmyInfoCtrl", method = RequestMethod.POST)
		public String updateCmyInfo(@ModelAttribute UpdateCustomer updateCustomer, Model model) {
			logInSvc.updateCustomer(updateCustomer);
			return "forward:/myInfoCtrl";
		}
		
		// 사원 정보 수정
		@RequestMapping(value="/updateEmyInfoCtrl", method = RequestMethod.POST)
		public String updateCmyInfo(@ModelAttribute UpdateEmp udateEmp, Model model) {
			logInSvc.updateEmployee(udateEmp);
			return "forward:/myInfoCtrl";
		}
		
		// 호텔 정보 수정
		@RequestMapping(value="/updateHmyInfoCtrl", method = RequestMethod.POST)
		public String updateCmyInfo(@ModelAttribute UpdateHotel updateHotel, Model model) {
			logInSvc.updateHotel(updateHotel);
			return "forward:/myInfoCtrl";
		}
		
		@RequestMapping(value = "/customerWithdraw")
		public String requestCustomerWithdraw(Model model) {
			HashMap<String, String> sessionMap = getSession();
			String cid = sessionMap.get("cid");
			String cpw = sessionMap.get("cpw");
			System.out.println(cid);
			System.out.println(cpw);
			CustomerLogIn clogIn = new CustomerLogIn(cid, cpw);
			model.addAttribute("clogIn", clogIn);
			return "logIn/customerWithdraw";
		}
		
		@RequestMapping(value = "/insertCustomerWithdraw")
		public String insertCustomerWithdraw(@ModelAttribute Withdraw withdraw) {
			logInSvc.requestWithdraw(withdraw);
			return "main/main";
		}
		
		// 로그아웃
		@RequestMapping(value="/logOut")
		public String logOutCtrl(Model model) {
			logOut();
			return "redirect:/homePage";
		}		
}