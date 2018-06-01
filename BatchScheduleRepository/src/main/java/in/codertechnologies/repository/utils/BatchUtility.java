package in.codertechnologies.repository.utils;

import in.coderinfotech.batchschedule.BatchDetails;
import in.coderinfotech.batchschedule.TrainerDetails;
import in.codertechnologies.batchSchedule.dto.BatchScheduleDTO;
import in.codertechnologies.batchSchedule.dto.TrainerDetailsDTO;

public class BatchUtility {

	public static BatchDetails convertBatchScheduleDTOToDO(BatchScheduleDTO batchScheduleDto) {
		
		BatchDetails batchDetails = new BatchDetails();
		if (CommonUtils.validateForZero(batchScheduleDto.getId())) {
			batchDetails.setBatchId(batchScheduleDto.getId());
		}
		if(CommonUtils.validateStringForNullSize(batchScheduleDto.getBatchCode())) {
			batchDetails.setBatchName(batchScheduleDto.getBatchCode());
		}
		if(CommonUtils.validateStringForNullSize(batchScheduleDto.getCenter())) {
			batchDetails.setCenter(batchScheduleDto.getCenter());
		}
		if(CommonUtils.validateStringForNullSize(batchScheduleDto.getLab())) {
			batchDetails.setLab(batchScheduleDto.getLab());
		}
		if(CommonUtils.validateStringForNullSize(batchScheduleDto.getTiming())) {
			batchDetails.setTiming(batchScheduleDto.getTiming());
		}
		if(CommonUtils.validateStringForNullSize(batchScheduleDto.getDuration())) {
			batchDetails.setDuration(batchScheduleDto.getDuration());
		}
		if(CommonUtils.validateForNullObject(batchScheduleDto.getStartDate())) {
			batchDetails.setStartDate(batchScheduleDto.getStartDate());
		}
		if(CommonUtils.validateForNullObject(batchScheduleDto.getEndDate())) {
			batchDetails.setEndDate(batchScheduleDto.getEndDate());
		}
		if(CommonUtils.validateForBlankChar(batchScheduleDto.getCompleted())) {
			batchDetails.setIsCompleted(batchScheduleDto.getCompleted());
		}
		if(CommonUtils.validateForNullObject(batchScheduleDto.getTrainerDetailsDTO())
				&& CommonUtils.validateForZero(batchScheduleDto.getTrainerDetailsDTO().getTrainerDetailsId())) {
			TrainerDetails  trainerDetails = new TrainerDetails();
			trainerDetails.setTrainerDetailsId(batchScheduleDto.getTrainerDetailsDTO().getTrainerDetailsId());
			batchDetails.setTrainerDetails(trainerDetails);
		}
		return batchDetails;
	}

	public static BatchScheduleDTO convertBatchScheduleDOToDTO(BatchDetails batchDetails) {

		BatchScheduleDTO batchScheduleDto = new BatchScheduleDTO();
		if (CommonUtils.validateForZero(batchDetails.getBatchId())) {
			batchScheduleDto.setId(batchDetails.getBatchId());
		}
		if(CommonUtils.validateStringForNullSize(batchDetails.getCenter())) {
			batchScheduleDto.setCenter(batchDetails.getCenter());
		}
		if(CommonUtils.validateStringForNullSize(batchDetails.getLab())) {
			batchScheduleDto.setLab(batchDetails.getLab());
		}
		if(CommonUtils.validateStringForNullSize(batchDetails.getTiming())) {
			batchScheduleDto.setTiming(batchDetails.getTiming());
		}
		if(CommonUtils.validateStringForNullSize(batchDetails.getDuration())) {
			batchScheduleDto.setDuration(batchDetails.getDuration());
		}
		if(CommonUtils.validateForNullObject(batchDetails.getStartDate())) {
			batchScheduleDto.setStartDate(batchDetails.getStartDate());
		}
		if(CommonUtils.validateForNullObject(batchDetails.getEndDate())) {
			batchScheduleDto.setEndDate(batchDetails.getEndDate());
		}
		if(CommonUtils.validateForBlankChar(batchDetails.getIsCompleted())) {
			batchScheduleDto.setCompleted(batchDetails.getIsCompleted());
		}
		if(CommonUtils.validateForNullObject(batchDetails.getTrainerDetails())
				&& CommonUtils.validateForZero(batchDetails.getTrainerDetails().getTrainerDetailsId())) {
			TrainerDetailsDTO  trainerDetailsDTO = new TrainerDetailsDTO();
			trainerDetailsDTO.setTrainerDetailsId(batchDetails.getTrainerDetails().getTrainerDetailsId());
			batchScheduleDto.setTrainerDetailsDTO(trainerDetailsDTO);
		}
		return batchScheduleDto;
	}
}
