package in.codertechnologies.repository.service;

import java.util.List;

import in.codertechnologies.batchSchedule.dto.PersonDetailsDTO;

public interface PersonDetailsService {

	boolean insertPersonDetails(PersonDetailsDTO personDetailsDTO);
	
	PersonDetailsDTO findPersonDetailById(PersonDetailsDTO personDetailsDTO);
	
	int getCountOfRecords();
	
	List<PersonDetailsDTO>  findAllPersonDetails();
	
	boolean deletePersonDetailById(PersonDetailsDTO personDetailsDTO);
}
