package in.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.ashokit.dto.Dashboard;
import in.ashokit.entity.Counsellor;
import in.ashokit.entity.Enquiry;
import in.ashokit.repo.CounsellorRepo;
import in.ashokit.repo.EnquiryRepo;
@Service
public class EnquiryServiceImpl implements EnquiryService {
	@Autowired
	EnquiryRepo enqRepo;
	@Autowired
	CounsellorRepo counsellorRepo;
	@Override
	public Dashboard getDashboardInfo(Integer counsellorId) {
		Long totalEnquiry=enqRepo.getEnquiries(counsellorId);
		Long openEnq=enqRepo.openEnquiries(counsellorId, "open");
		Long lostEnq=enqRepo.openEnquiries(counsellorId, "lost");
		Long enrolledEnq=enqRepo.openEnquiries(counsellorId, "enrolled");
		Dashboard ds=new Dashboard();
		ds.setTotalEnquiry(totalEnquiry);
		ds.setOpenEnquiry(openEnq);
		ds.setLostEnuiry(lostEnq);
		ds.setEnrolledEnquiry(enrolledEnq);
		return ds;
	}

	@Override
	public boolean addEnquiry(Enquiry enquiry,Integer counsellorId) {
		Counsellor counsellor=counsellorRepo.findById(counsellorId).orElseThrow();
		enquiry.setCounsellor(counsellor);//association for foreign key
		Enquiry savedEnquiry=enqRepo.save(enquiry);
		return savedEnquiry.getEquiry_id()!=null;
	}
	
/*  -This method is used to retrieve data for table,When we click on ViewEnquiry all data should come
	Here we have to get data based on which person is logged in,So we can achieve this based on
	counsellorId.
	-Here we need to retrieve data based on counsellorId and filter also, for that we are using 
	 query by example concept i.e. Example.of()
	*/
	@Override
	public List<Enquiry> getEnquiries(Enquiry enquiry, Integer counsellorId) {
		//Here we are retrieving counsellor based on counsellorId and we will set it to enquiry
		Counsellor counsellor = counsellorRepo.findById(counsellorId).orElseThrow();
		enquiry.setCounsellor(counsellor);
		
		/*Dynamic query creation i.e. whatever data available in object according to that 
		query will be generated*/
		Example<Enquiry> of=Example.of(enquiry);
		return  enqRepo.findAll(of);
		
	}

	//This method is used for edit
	@Override
	public Enquiry getEnquiry(Integer enqId) {
		
		return enqRepo.findById(enqId).orElseThrow();
	}

}
