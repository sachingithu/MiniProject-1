package in.ashokit.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Enquiry {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer equiry_id;
private String studentName;
private String phoneNo;
private String courseName;
private String classMode;
private String status;
@CreationTimestamp
private LocalDate createdDate;
@UpdateTimestamp
private LocalDate updatedDate;
@ManyToOne
@JoinColumn(name ="counsellorId")
private Counsellor counsellor;
public Integer getEquiry_id() {
	return equiry_id;
}
public void setEquiry_id(Integer equiry_id) {
	this.equiry_id = equiry_id;
}
public String getStudentName() {
	return studentName;
}
public void setStudentName(String studentName) {
	this.studentName = studentName;
}
public String getPhoneNo() {
	return phoneNo;
}
public void setPhoneNo(String phoneNo) {
	this.phoneNo = phoneNo;
}
public String getCourseName() {
	return courseName;
}
public void setCourseName(String courseName) {
	this.courseName = courseName;
}
public String getClassMode() {
	return classMode;
}
public void setClassMode(String classMode) {
	this.classMode = classMode;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public LocalDate getCreatedDate() {
	return createdDate;
}
public void setCreatedDate(LocalDate createdDate) {
	this.createdDate = createdDate;
}
public LocalDate getUpdatedDate() {
	return updatedDate;
}
public void setUpdatedDate(LocalDate updatedDate) {
	this.updatedDate = updatedDate;
}
public Counsellor getCounsellor() {
	return counsellor;
}
public void setCounsellor(Counsellor counsellor) {
	this.counsellor = counsellor;
}


}
