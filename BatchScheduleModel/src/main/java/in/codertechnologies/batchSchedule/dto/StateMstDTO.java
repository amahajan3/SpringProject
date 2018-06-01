package in.codertechnologies.batchSchedule.dto;

public class StateMstDTO {

	private long stateId;
	private String stateCode;
	private String stateName;
	
	public long getStateId() {
		return stateId;
	}
	public void setStateId(long stateId) {
		this.stateId = stateId;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	@Override
	public String toString() {
		return "StateMstDTO [stateId=" + stateId + ", stateCode=" + stateCode + ", stateName=" + stateName + "]";
	}
	
	
}
