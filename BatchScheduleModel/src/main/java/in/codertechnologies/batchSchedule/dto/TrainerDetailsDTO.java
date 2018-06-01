package in.codertechnologies.batchSchedule.dto;

public class TrainerDetailsDTO {
	private long trainerDetailsId;
	private PersonDetailsDTO personDetailsDTO;
	private String trainerCode;
	private String title;
	private String areasOfSpecialization;
	private String department;
	private String officeLocation;
	private String officeTelephone;
	private String experience;
	private String researchInterests;
	private String projects;
	
	public long getTrainerDetailsId() {
		return trainerDetailsId;
	}
	public void setTrainerDetailsId(long trainerDetailsId) {
		this.trainerDetailsId = trainerDetailsId;
	}
	public PersonDetailsDTO getPersonDetailsDTO() {
		return personDetailsDTO;
	}
	public void setPersonDetailsDTO(PersonDetailsDTO personDetailsDTO) {
		this.personDetailsDTO = personDetailsDTO;
	}
	public String getTrainerCode() {
		return trainerCode;
	}
	public void setTrainerCode(String trainerCode) {
		this.trainerCode = trainerCode;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAreasOfSpecialization() {
		return areasOfSpecialization;
	}
	public void setAreasOfSpecialization(String areasOfSpecialization) {
		this.areasOfSpecialization = areasOfSpecialization;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getOfficeLocation() {
		return officeLocation;
	}
	public void setOfficeLocation(String officeLocation) {
		this.officeLocation = officeLocation;
	}
	public String getOfficeTelephone() {
		return officeTelephone;
	}
	public void setOfficeTelephone(String officeTelephone) {
		this.officeTelephone = officeTelephone;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getResearchInterests() {
		return researchInterests;
	}
	public void setResearchInterests(String researchInterests) {
		this.researchInterests = researchInterests;
	}
	public String getProjects() {
		return projects;
	}
	public void setProjects(String projects) {
		this.projects = projects;
	}
	@Override
	public String toString() {
		return "TrainerDetailsDTO [trainerDetailsId=" + trainerDetailsId + ", personDetailsDTO=" + personDetailsDTO
				+ ", trainerCode=" + trainerCode + ", title=" + title + ", areasOfSpecialization="
				+ areasOfSpecialization + ", department=" + department + ", officeLocation=" + officeLocation
				+ ", officeTelephone=" + officeTelephone + ", experience=" + experience + ", researchInterests="
				+ researchInterests + ", projects=" + projects + "]";
	}
	
}
