package in.ashokit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.Counsellor;
import in.ashokit.repo.CounsellorRepo;
@Service
public class CounsellorServiceImpl implements CounsellorService {
	@Autowired
	CounsellorRepo counsellorRepo;
	@Override
	public boolean saveCounsellor(Counsellor counsellor) {
		Counsellor findCounsellor=counsellorRepo.findByEmail(counsellor.getEmail());
		if(findCounsellor!=null) {
						return false;
		}else {
		Counsellor savedCounsellor=counsellorRepo.save(counsellor);
		return savedCounsellor.getCounsellorId()!=null;
		}
	
	}
	
//This method is for logged in functionality,Based on email and pwd we have to retrieve record
	
	@Override
	public Counsellor getCounsellor(String email, String pwd) {
		return counsellorRepo.findByEmailAndPassword(email, pwd);
		
	}

}
