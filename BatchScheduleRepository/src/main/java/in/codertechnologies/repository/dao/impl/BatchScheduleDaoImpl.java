package in.codertechnologies.repository.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import in.coderinfotech.batchschedule.BatchDetails;
import in.codertechnologies.batchSchedule.dto.BatchScheduleDTO;
import in.codertechnologies.repository.dao.BachScheduleDAO;
import in.codertechnologies.repository.utils.BatchUtility;

@Repository("bachScheduleDAO")
@Transactional
public class BatchScheduleDaoImpl implements BachScheduleDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean insertBatchSchedule(BatchScheduleDTO batchScheduleDto) {
		BatchDetails batchDetails = BatchUtility.convertBatchScheduleDTOToDO(batchScheduleDto);
		sessionFactory.getCurrentSession().saveOrUpdate(batchDetails);
		return false;
	}

	@Override
	public BatchScheduleDTO findBatchScheduleById(BatchScheduleDTO batchScheduleDto) {
		BatchDetails batchDetails = (BatchDetails) sessionFactory.getCurrentSession().get(BatchDetails.class, batchScheduleDto.getId());
		return null;
	}

	@Override
	public int getCountOfRecords() {
		return sessionFactory.getCurrentSession().createCriteria(BatchDetails.class).list().size();
	}

	@Override
	public List<BatchScheduleDTO> findAllBatchSchedule() {
		List<BatchScheduleDTO> batchScheduleDTOList = new ArrayList<BatchScheduleDTO>();
		List<BatchDetails> batchDetailsDOList = sessionFactory.getCurrentSession().createCriteria(BatchDetails.class).list();
		for (BatchDetails batchDetails : batchDetailsDOList) {
			batchScheduleDTOList.add(BatchUtility.convertBatchScheduleDOToDTO(batchDetails));
		}
		return batchScheduleDTOList;
	}

	@Override
	public boolean deleteBatchScheduleById(BatchScheduleDTO batchScheduleDto) {
		BatchDetails batchDetails = BatchUtility.convertBatchScheduleDTOToDO(batchScheduleDto);
		 sessionFactory.getCurrentSession().delete(batchDetails);
		return false;
	}
	
	
	
}
