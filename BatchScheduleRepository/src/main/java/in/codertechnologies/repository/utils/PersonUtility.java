package in.codertechnologies.repository.utils;

import in.coderinfotech.batchschedule.PersonDetails;
import in.coderinfotech.batchschedule.TrainerDetails;
import in.codertechnologies.batchSchedule.dto.PersonDetailsDTO;
import in.codertechnologies.batchSchedule.dto.TrainerDetailsDTO;

public class PersonUtility {

	public static PersonDetails convertPersonDetailsDTOToDO(PersonDetailsDTO personDetailsDTO) {
		
		PersonDetails personDetails = new PersonDetails();
		/*if (CommonUtils.validateForZero(personDetailsDTO.getPersonDetailsId())) {
			personDetails.setPersonDetailsId(personDetailsDTO.getPersonDetailsId());
		}
		if(CommonUtils.validateStringForNullSize(personDetailsDTO.getAadhaarCardNo())) {
			personDetails.setAadhaarCardNo(personDetailsDTO.getAadhaarCardNo());
		}
		if(CommonUtils.validateStringForNullSize(personDetailsDTO.getAddressLine1())) {
			personDetails.setAddressLine1(personDetailsDTO.getAddressLine1());
		}
		if(CommonUtils.validateStringForNullSize(personDetailsDTO.getAddressLine2())) {
			personDetails.setAddressLine2(personDetailsDTO.getAddressLine2());
		}
		if(CommonUtils.validateStringForNullSize(personDetailsDTO.getDistrict())) {
			personDetails.setDistrict(personDetailsDTO.getDistrict());
		}
		if(CommonUtils.validateForNullObject(personDetailsDTO.get)) {
			personDetails.setStartDate(personDetailsDTO.getStartDate());
		}
		if(CommonUtils.validateForNullObject(personDetailsDTO.getEndDate())) {
			personDetails.setEndDate(personDetailsDTO.getEndDate());
		}
		if(CommonUtils.validateForBlankChar(personDetailsDTO.getCompleted())) {
			personDetails.setIsCompleted(personDetailsDTO.getCompleted());
		}
		if(CommonUtils.validateForNullObject(personDetailsDTO.getTrainerDetailsDTO())
				&& CommonUtils.validateForZero(personDetailsDTO.getTrainerDetailsDTO().getTrainerDetailsId())) {
			TrainerDetails  trainerDetails = new TrainerDetails();
			trainerDetails.setTrainerDetailsId(personDetailsDTO.getTrainerDetailsDTO().getTrainerDetailsId());
			personDetails.setTrainerDetails(trainerDetails);
		}*/
		return personDetails;
	}

	public static PersonDetailsDTO convertPersonDetailsDOToDTO(PersonDetails personDetails) {

		PersonDetailsDTO personDetailsDTO = new PersonDetailsDTO();
		/*if (CommonUtils.validateForZero(personDetails.getBatchId())) {
			personDetailsDTO.setId(personDetails.getBatchId());
		}
		if(CommonUtils.validateStringForNullSize(personDetails.getCenter())) {
			personDetailsDTO.setCenter(personDetails.getCenter());
		}
		if(CommonUtils.validateStringForNullSize(personDetails.getLab())) {
			personDetailsDTO.setLab(personDetails.getLab());
		}
		if(CommonUtils.validateStringForNullSize(personDetails.getTiming())) {
			personDetailsDTO.setTiming(personDetails.getTiming());
		}
		if(CommonUtils.validateStringForNullSize(personDetails.getDuration())) {
			personDetailsDTO.setDuration(personDetails.getDuration());
		}
		if(CommonUtils.validateForNullObject(personDetails.getStartDate())) {
			personDetailsDTO.setStartDate(personDetails.getStartDate());
		}
		if(CommonUtils.validateForNullObject(personDetails.getEndDate())) {
			personDetailsDTO.setEndDate(personDetails.getEndDate());
		}
		if(CommonUtils.validateForBlankChar(personDetails.getIsCompleted())) {
			personDetailsDTO.setCompleted(personDetails.getIsCompleted());
		}
		if(CommonUtils.validateForNullObject(personDetails.getTrainerDetails())
				&& CommonUtils.validateForZero(personDetails.getTrainerDetails().getTrainerDetailsId())) {
			TrainerDetailsDTO  trainerDetailsDTO = new TrainerDetailsDTO();
			trainerDetailsDTO.setTrainerDetailsId(personDetails.getTrainerDetails().getTrainerDetailsId());
			personDetailsDTO.setTrainerDetailsDTO(trainerDetailsDTO);
		}*/
		return personDetailsDTO;
	}
}
