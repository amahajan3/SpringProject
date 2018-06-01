package in.codertechnologies.repository.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.coderinfotech.batchschedule.BatchDetails;
import in.codertechnologies.batchSchedule.dto.BatchScheduleDTO;
import in.codertechnologies.repository.dao.BachScheduleDAO;
import in.codertechnologies.repository.service.BatchScheduleService;

@Service("batchScheduleService")
public class BatchScheduleServiceImpl implements BatchScheduleService{

	@Autowired
	private BachScheduleDAO bachScheduleDAO;

	@Override
	public boolean insertBatchSchedule(BatchScheduleDTO batchSchedule) {
		return bachScheduleDAO.insertBatchSchedule(batchSchedule);
	}

	@Override
	public BatchScheduleDTO findBatchScheduleById(BatchScheduleDTO batchScheduleDTO)  {
		return bachScheduleDAO.findBatchScheduleById(batchScheduleDTO);
	}

	@Override
	public int getCountOfRecords() {
		return bachScheduleDAO.getCountOfRecords();
	}

	@Override
	public List<BatchScheduleDTO> findAllBatchSchedule() {
		
		return bachScheduleDAO.findAllBatchSchedule();
	}

	@Override
	public boolean deleteBatchScheduleById(BatchScheduleDTO batchScheduleDTO) {
		return bachScheduleDAO.deleteBatchScheduleById(batchScheduleDTO);
	} 
	
	
}
