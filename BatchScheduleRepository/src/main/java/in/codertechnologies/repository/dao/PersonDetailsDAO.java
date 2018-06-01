package in.codertechnologies.repository.dao;

import java.util.List;

import in.coderinfotech.batchschedule.BatchDetails;
import in.codertechnologies.batchSchedule.dto.BatchScheduleDTO;
import in.codertechnologies.batchSchedule.dto.PersonDetailsDTO;

public interface PersonDetailsDAO {
	boolean insertPersonDetails(PersonDetailsDTO personDetailsDTO);
	
	PersonDetailsDTO findPersonDetailById(PersonDetailsDTO personDetailsDTO);
	
	int getCountOfRecords();
	
	List<PersonDetailsDTO>  findAllPersonDetails();
	
	boolean deletePersonDetailById(PersonDetailsDTO personDetailsDTO);
}
