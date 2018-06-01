package in.codertechnologies.batchSchedule.dto;

public class CityMstDTO {

	private long cityId;
	private StateMstDTO stateMstDTO;
	private String cityCode;
	private String cityName;
	public long getCityId() {
		return cityId;
	}
	public void setCityId(long cityId) {
		this.cityId = cityId;
	}
	public StateMstDTO getStateMstDTO() {
		return stateMstDTO;
	}
	public void setStateMstDTO(StateMstDTO stateMstDTO) {
		this.stateMstDTO = stateMstDTO;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	@Override
	public String toString() {
		return "CityDTO [cityId=" + cityId + ", stateMstDTO=" + stateMstDTO + ", cityCode=" + cityCode + ", cityName="
				+ cityName + "]";
	}
	
	
}
