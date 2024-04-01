package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.dto.Dashboard;
import in.ashokit.entity.Counsellor;
import in.ashokit.service.CounsellorService;
import in.ashokit.service.EnquiryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller

public class CounsellorController {
	@Autowired
	private CounsellorService counsellorService;
	
	@Autowired
	private EnquiryService enquiryService;
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest req,Model model) {
		HttpSession session=req.getSession(false);
		session.invalidate();
		return "redirect:/";
	}
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("counsellor", new Counsellor());
		return "registerView";
	}
	@PostMapping("/register")
	public String handleRegister(Counsellor c,Model model) {
		boolean status = counsellorService.saveCounsellor(c);
		if(status) {
			model.addAttribute("smsg", "Counsellor Saved");
		}else {
			model.addAttribute("errMsg","Failed to save");
		}
		return "registerView";
	}
	@GetMapping("/")
	public String login(Model model) {
		model.addAttribute("counsellor", new Counsellor());
		return "index";
	}
	//Method to handle the login
	@PostMapping("/login")
	public String handleLogin(Counsellor counsellor,HttpServletRequest req,Model model) {
		Counsellor c = counsellorService.getCounsellor(counsellor.getEmail(), counsellor.getPassword());
		if(c==null) {
			model.addAttribute("errMsg", "Invalid Credentials");
		return "index";
		}else {
			
			//To identify which user is logged in we need to set counsellorId to session 
			HttpSession session = req.getSession(true);//true- it means for every user new session will be created
			session.setAttribute("cid",counsellor.getCounsellorId());
			Dashboard dashboardInfo = enquiryService.getDashboardInfo(c.getCounsellorId());
			model.addAttribute("dashboard", dashboardInfo);
			return "dashboard";
		}
	}
}
