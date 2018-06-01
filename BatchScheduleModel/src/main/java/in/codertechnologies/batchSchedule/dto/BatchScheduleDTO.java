package in.codertechnologies.batchSchedule.dto;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;



public class BatchScheduleDTO {

	
	private long id;
	
	private TrainerDetailsDTO trainerDetailsDTO;
	
	@NotBlank @Size(min=1 , max= 4)
	@Pattern(regexp = "[A-Z]{2}[0-9]{2}")
	private String batchCode;
	
	@NotBlank @Size(min=1 , max= 40)
	private String center;
	
	@NotBlank @Size(min=1 , max= 40)
	private String lab;
	
	@NotBlank @Size(min=1 , max= 40)
	private String timing;
	
	 @Future
	private Date startDate;
	
	@Future
	private Date endDate;	
	
	private char completed;
	
	@NotBlank @Min(2) @Max(8)
	private String duration;	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public TrainerDetailsDTO getTrainerDetailsDTO() {
		return trainerDetailsDTO;
	}
	public void setTrainerDetailsDTO(TrainerDetailsDTO trainerDetailsDTO) {
		this.trainerDetailsDTO = trainerDetailsDTO;
	}
	public String getCenter() {
		return center;
	}
	public void setCenter(String center) {
		this.center = center;
	}
	public String getLab() {
		return lab;
	}
	public void setLab(String lab) {
		this.lab = lab;
	}
	public String getTiming() {
		return timing;
	}
	public void setTiming(String timing) {
		this.timing = timing;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public char getCompleted() {
		return completed;
	}
	public void setCompleted(char completed) {
		this.completed = completed;
	}
	@Override
	public String toString() {
		return "BatchScheduleDTO [id=" + id + ", trainerFirstName=" + "" + ", trainerLastName="
				+ "" + ", center=" + center + ", lab=" + lab + ", timing=" + timing + ", startDate="
				+ startDate + ", endDate=" + endDate + ", completed=" + completed + "]";
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getBatchCode() {
		return batchCode;
	}
	public void setBatchCode(String batchCode) {
		this.batchCode = batchCode;
	}
	
	
	
	
	
}
