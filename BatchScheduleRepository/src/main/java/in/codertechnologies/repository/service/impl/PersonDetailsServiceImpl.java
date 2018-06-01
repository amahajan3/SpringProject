package in.codertechnologies.repository.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.codertechnologies.batchSchedule.dto.PersonDetailsDTO;
import in.codertechnologies.repository.dao.PersonDetailsDAO;
import in.codertechnologies.repository.service.PersonDetailsService;

@Service("personDetailsService")
public class PersonDetailsServiceImpl implements PersonDetailsService{

	@Autowired
	private PersonDetailsDAO personDetailsDAO;

	@Override
	public boolean insertPersonDetails(PersonDetailsDTO personDetailsDTO) {
		return personDetailsDAO.insertPersonDetails(personDetailsDTO);
	}

	@Override
	public PersonDetailsDTO findPersonDetailById(PersonDetailsDTO personDetailsDTO)  {
		return personDetailsDAO.findPersonDetailById(personDetailsDTO);
	}

	@Override
	public int getCountOfRecords() {
		return personDetailsDAO.getCountOfRecords();
	}

	@Override
	public List<PersonDetailsDTO> findAllPersonDetails() {
		
		return personDetailsDAO.findAllPersonDetails();
	}

	@Override
	public boolean deletePersonDetailById(PersonDetailsDTO personDetailsDTO) {
		return personDetailsDAO.deletePersonDetailById(personDetailsDTO);
	}

	
	
}
