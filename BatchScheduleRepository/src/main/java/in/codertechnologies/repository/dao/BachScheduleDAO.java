package in.codertechnologies.repository.dao;

import java.util.List;

import in.coderinfotech.batchschedule.BatchDetails;
import in.codertechnologies.batchSchedule.dto.BatchScheduleDTO;

public interface BachScheduleDAO {
boolean insertBatchSchedule(BatchScheduleDTO batchSchedule);
	
	BatchScheduleDTO findBatchScheduleById(BatchScheduleDTO batchScheduleDto);
	
	int getCountOfRecords();
	
	List<BatchScheduleDTO>  findAllBatchSchedule();
	
	boolean deleteBatchScheduleById(BatchScheduleDTO batchScheduleDto);
}
