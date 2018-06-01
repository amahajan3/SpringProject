package in.codertechnologies.batchSchedule.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class PersonDetailsDTO {

	private long personDetailsId;
	private AcademicDetailsDTO detailsDTO;
	@NotNull
	private CityMstDTO cityMstDTO;
	@NotNull
	private StateMstDTO stateMstDTO;
	@NotBlank
	@Size(min=1 , max= 40)
	private String firstName;
	@NotBlank
	@Size(min=1 , max= 40)
	private String lastName;
	@NotBlank
	@Size(min=1 , max= 40)
	private String fatherName;
	private String motherName;
	@NotBlank
	@Past
	private Date dateOfBirth;
	/*@NotBlank
	@Pattern(regexp = "^[M|F]{1}$")*/
	private Character gender;
	@NotBlank
	@Email
	@Size(min=1 , max= 40)
	private String emailId;
	@NotBlank
	/*@Pattern(regexp = "/^\\d{10}$/")*/
	@Size(min=1 , max= 10)
	private String mobileNo;
	@NotBlank
	@Size(min=1 , max= 10)
	private String password;
	@NotBlank
	@Size(min=1 , max= 100)
	private String addressLine1;
	@NotBlank
	@Size(min=1 , max= 100)
	private String addressLine2;
	@NotBlank
	/*@Pattern(regexp = "/^\\d{6}$/")*/
	/*@Size(min=1 , max= 6)*/
	private Long pinCode;
	@NotBlank
	@Size(min=1 , max= 40)
	private String district;
	/*@NotBlank
	@Pattern(regexp = "^[Y|N]{1}$")*/
	private Character aadhaarCardApplicable;
	@NotBlank
	/*@Pattern(regexp = "/^\\d{12}$/")*/
	@Size(min=1 , max= 40)
	private String aadhaarCardNo;
	private Date createdDate;
	private Date modifiedDate;
	private Character profile;
	private Character isActive;
	public long getPersonDetailsId() {
		return personDetailsId;
	}
	public void setPersonDetailsId(long personDetailsId) {
		this.personDetailsId = personDetailsId;
	}
	public AcademicDetailsDTO getDetailsDTO() {
		return detailsDTO;
	}
	public void setDetailsDTO(AcademicDetailsDTO detailsDTO) {
		this.detailsDTO = detailsDTO;
	}
	public StateMstDTO getStateMstDTO() {
		return stateMstDTO;
	}
	public void setStateMstDTO(StateMstDTO stateMstDTO) {
		this.stateMstDTO = stateMstDTO;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Character getGender() {
		return gender;
	}
	public void setGender(Character gender) {
		this.gender = gender;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public Long getPinCode() {
		return pinCode;
	}
	public void setPinCode(Long pinCode) {
		this.pinCode = pinCode;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public Character getAadhaarCardApplicable() {
		return aadhaarCardApplicable;
	}
	public void setAadhaarCardApplicable(Character aadhaarCardApplicable) {
		this.aadhaarCardApplicable = aadhaarCardApplicable;
	}
	public String getAadhaarCardNo() {
		return aadhaarCardNo;
	}
	public void setAadhaarCardNo(String aadhaarCardNo) {
		this.aadhaarCardNo = aadhaarCardNo;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public Character getProfile() {
		return profile;
	}
	public void setProfile(Character profile) {
		this.profile = profile;
	}
	public Character getIsActive() {
		return isActive;
	}
	public void setIsActive(Character isActive) {
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "PersonDetailsDTO [personDetailsId=" + personDetailsId + ", detailsDTO=" + detailsDTO + ", cityTownDTO="
				+ cityMstDTO + ", stateMstDTO=" + stateMstDTO + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", fatherName=" + fatherName + ", motherName=" + motherName + ", dateOfBirth=" + dateOfBirth
				+ ", gender=" + gender + ", emailId=" + emailId + ", mobileNo=" + mobileNo + ", password=" + password
				+ ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", pinCode=" + pinCode
				+ ", district=" + district + ", aadhaarCardApplicable=" + aadhaarCardApplicable + ", aadhaarCardNo="
				+ aadhaarCardNo + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + ", profile="
				+ profile + ", isActive=" + isActive + "]";
	}
	public CityMstDTO getCityMstDTO() {
		return cityMstDTO;
	}
	public void setCityMstDTO(CityMstDTO cityMstDTO) {
		this.cityMstDTO = cityMstDTO;
	}


}
