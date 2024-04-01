package in.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ashokit.entity.Enquiry;
import in.ashokit.service.EnquiryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class EnquiryController {
	@Autowired
	private EnquiryService enquiryService;
	@GetMapping("/enquiry")
	public String addEnquiry(Model model) {
	model.addAttribute("enq",new Enquiry());
		return "addEnquiry";
	}
	//save enquiry
		@PostMapping("/enquiry")	
		public String saveEnquiry(Enquiry enquiry,Model model,HttpServletRequest req) {
			HttpSession session = req.getSession(false);//We are putting falls,since dont create new object give existing session
			Integer cid = (Integer)session.getAttribute("cid");
			boolean status = enquiryService.addEnquiry(enquiry, cid);
			if(status) {
				model.addAttribute("sMsg", "Enquiry Saved");
			}else {
				model.addAttribute("errMsg", "Enquiry Not Saved...");
			}
			return "addEnquiry";
		}
		//Veiw Enquiry
		@GetMapping("/enquiries")
		public String getEnquiries(HttpServletRequest req,Model model) {
			HttpSession session = req.getSession(false);
			Integer cid = (Integer)session.getAttribute("cid");
			List<Enquiry> list = enquiryService.getEnquiries(new Enquiry(), cid);
			model.addAttribute("enq", list);
			model.addAttribute("enq", new Enquiry());
			return "viewEnquiry";
		}
		
		//Filter Enquiries
		@PostMapping("/filter-enqs")
		public String filterEnquiries(Enquiry enquiry,HttpServletRequest req,Model model) {
			HttpSession session = req.getSession(false);
			Integer cid = (Integer)session.getAttribute("cid");
			List<Enquiry> list = enquiryService.getEnquiries(enquiry, cid);
			model.addAttribute("enq", list);
			return "viewEnquiry";
			
		}
		//edit & update enquiries
		@GetMapping("/edit")
		public String editEnquiry(@RequestParam("enqId") Integer enqId,Model model) {
			Enquiry enquiry = enquiryService.getEnquiry(enqId);
			model.addAttribute("enq", enquiry);
			return "addEnquiry";
		}
}
