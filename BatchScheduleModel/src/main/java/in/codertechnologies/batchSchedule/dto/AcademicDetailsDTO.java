package in.codertechnologies.batchSchedule.dto;

public class AcademicDetailsDTO {

	private long academicDetailsId;
	private String graduation;
	private String graduationPercentage;
	private String graduationYear;
	private String graduationDuration;
	private String masterDegree;
	private String masterPercentage;
	private String masterYear;
	private String masterDuration;
	private String diploma;
	
	public long getAcademicDetailsId() {
		return academicDetailsId;
	}
	public void setAcademicDetailsId(long academicDetailsId) {
		this.academicDetailsId = academicDetailsId;
	}
	public String getGraduation() {
		return graduation;
	}
	public void setGraduation(String graduation) {
		this.graduation = graduation;
	}
	public String getGraduationPercentage() {
		return graduationPercentage;
	}
	public void setGraduationPercentage(String graduationPercentage) {
		this.graduationPercentage = graduationPercentage;
	}
	public String getGraduationYear() {
		return graduationYear;
	}
	public void setGraduationYear(String graduationYear) {
		this.graduationYear = graduationYear;
	}
	public String getGraduationDuration() {
		return graduationDuration;
	}
	public void setGraduationDuration(String graduationDuration) {
		this.graduationDuration = graduationDuration;
	}
	public String getMasterDegree() {
		return masterDegree;
	}
	public void setMasterDegree(String masterDegree) {
		this.masterDegree = masterDegree;
	}
	public String getMasterPercentage() {
		return masterPercentage;
	}
	public void setMasterPercentage(String masterPercentage) {
		this.masterPercentage = masterPercentage;
	}
	public String getMasterYear() {
		return masterYear;
	}
	public void setMasterYear(String masterYear) {
		this.masterYear = masterYear;
	}
	public String getMasterDuration() {
		return masterDuration;
	}
	public void setMasterDuration(String masterDuration) {
		this.masterDuration = masterDuration;
	}
	public String getDiploma() {
		return diploma;
	}
	public void setDiploma(String diploma) {
		this.diploma = diploma;
	}
	@Override
	public String toString() {
		return "AcademicDetailsDTO [academicDetailsId=" + academicDetailsId + ", graduation=" + graduation
				+ ", graduationPercentage=" + graduationPercentage + ", graduationYear=" + graduationYear
				+ ", graduationDuration=" + graduationDuration + ", masterDegree=" + masterDegree
				+ ", masterPercentage=" + masterPercentage + ", masterYear=" + masterYear + ", masterDuration="
				+ masterDuration + ", diploma=" + diploma + "]";
	}
	
	
	
}
