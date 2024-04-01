package in.ashokit.service;

import java.util.List;

import in.ashokit.dto.Dashboard;
import in.ashokit.entity.Enquiry;

public interface EnquiryService {
	//for getting dashboard page
public Dashboard getDashboardInfo(Integer counsellorId);
//save enquires
public boolean addEnquiry(Enquiry enquiry,Integer counsellorId);
//view enquiries+filter
public List<Enquiry> getEnquiries(Enquiry enquiry,Integer counsellorId);
//For edit
public Enquiry getEnquiry(Integer enqId);
}
