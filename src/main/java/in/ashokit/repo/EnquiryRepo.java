package in.ashokit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.ashokit.entity.Enquiry;

public interface EnquiryRepo extends JpaRepository<Enquiry, Integer> {
	@Query(value ="SELECT COUNT(*) FROM enquiry WHERE counsellor_id=:Id",nativeQuery = true)
	public Long getEnquiries(Integer Id);
	@Query(value ="SELECT COUNT(*) FROM enquiry WHERE counsellor_id=:counsellorId AND status=:status",nativeQuery = true)
	public Long openEnquiries(Integer counsellorId,String status);
}
