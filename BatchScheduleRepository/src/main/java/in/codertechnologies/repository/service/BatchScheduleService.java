package in.codertechnologies.repository.service;

import java.util.List;

import in.codertechnologies.batchSchedule.dto.BatchScheduleDTO;

public interface BatchScheduleService {

	boolean insertBatchSchedule(BatchScheduleDTO batchSchedule);
	
	BatchScheduleDTO findBatchScheduleById(BatchScheduleDTO batchScheduleDto);
	
	int getCountOfRecords();
	
	List<BatchScheduleDTO>  findAllBatchSchedule();
	
	boolean deleteBatchScheduleById(BatchScheduleDTO batchScheduleDto);
}
