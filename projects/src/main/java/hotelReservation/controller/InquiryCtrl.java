package hotelReservation.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hotelReservation.dto.Inquiry;
import hotelReservation.dto.Insertinquiry;
import hotelReservation.svc.InquirySvc;

@Controller
public class InquiryCtrl {

	@Autowired
	private InquirySvc inquirySvc;
	
	// 회원별 문의 목록 보기
	@RequestMapping(value = "/requestInquiry")
	public String InquiryList(Model model, HttpSession session) {
		String cid = (String)session.getAttribute("cid");
		String hid = (String)session.getAttribute("hid");
		if(cid != null) {
			List<Inquiry> iList = new ArrayList<Inquiry>();
			iList = inquirySvc.boardSelectById(cid);
			model.addAttribute("iList", iList);
			return "inquiry/clientInquiry";
		}
		else if(hid != null) {
			List<Inquiry> iList = new ArrayList<Inquiry>();
			iList = inquirySvc.boardSelectById(hid);
			model.addAttribute("iList", iList);
			return "inquiry/clientInquiry";
		}
		return "logIn/logInForm";
	}
	
	// 글쓰기로 이동
	@RequestMapping(value = "/writeBoard")
	public String requestWritePage(Model model, HttpSession session) {
		String cid = (String)session.getAttribute("cid");
		String hid = (String)session.getAttribute("hid");
		if(cid != null) {
			model.addAttribute("id", cid);
			return "inquiry/writeInquiry";
		}
		else if(hid != null) {
			model.addAttribute("id", hid);
			return "inquiry/writeInquiry";
		}
		return "main/main";
	}
	// 문의 넣기
	@RequestMapping(value = "/writeBoardCtrl", method = RequestMethod.POST)
	public String insertInquiry(@ModelAttribute Insertinquiry insertInquiry, Model model) {
		inquirySvc.insertBoard(insertInquiry);
		return "forward:/requestInquiry";
	}
	
	// 문의 내용 보기
	@RequestMapping(value = "/showInquiry")
	public String showBoard(@RequestParam("ino") int ino, Model model) {
		model.addAttribute("inquiryInfo", inquirySvc.readBoard(ino));
		return "inquiry/watchInquiry";
	}
	
	// 문의 수정
	@RequestMapping(value = "/updateInquiry")
	public String updateInquiry(@ModelAttribute Inquiry inquiry, Model model) {
		inquirySvc.updateBoard(inquiry);
		return "forward:/requestInquiry";
	}
	
	// 문의 삭제
	@RequestMapping(value = "/deleteInquiry")
	public String deleteInquiry(@RequestParam("ino") int ino) {
		inquirySvc.deleteBoard(ino);
		return "forward:/requestInquiry";
	}
	
}
