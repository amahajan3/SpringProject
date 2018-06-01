package in.codertechnologies.repository.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import in.coderinfotech.batchschedule.BatchDetails;
import in.coderinfotech.batchschedule.CityMst;
import in.coderinfotech.batchschedule.PersonDetails;
import in.coderinfotech.batchschedule.StateMst;
import in.codertechnologies.batchSchedule.dto.CityMstDTO;
import in.codertechnologies.batchSchedule.dto.PersonDetailsDTO;
import in.codertechnologies.batchSchedule.dto.StateMstDTO;
import in.codertechnologies.repository.dao.PersonDetailsDAO;

@Repository("personDetailsDAO")
@Transactional
@SuppressWarnings("unchecked")
public class PersonDetailsDaoImpl implements PersonDetailsDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean insertPersonDetails(PersonDetailsDTO personDetailsDTO) {
		ModelMapper modelMapper = new ModelMapper();
		PersonDetails personDetails = modelMapper.map(personDetailsDTO, PersonDetails.class);
		setPersonDetailsRelatedFields(personDetails);
		sessionFactory.getCurrentSession().saveOrUpdate(personDetails);
		return true;
	}

	private void setPersonDetailsRelatedFields(PersonDetails personDetails) {
		personDetails.setCreatedDate(new Date());
		CityMst cityMst = new CityMst();
		StateMst stateMst = new StateMst();
		cityMst.setCityId(1);
		stateMst.setStateId(1);
		personDetails.setCityMst(cityMst);
		personDetails.setStateMst(stateMst);
		personDetails.setIsActive('N');
		personDetails.setProfile('S');
	}

	@Override
	public PersonDetailsDTO findPersonDetailById(PersonDetailsDTO personDetailsDTO) {
		ModelMapper modelMapper = new ModelMapper();
		PersonDetails personDetails = (PersonDetails) sessionFactory.getCurrentSession().get(BatchDetails.class, personDetailsDTO.getPersonDetailsId());
		personDetailsDTO = modelMapper.map(personDetails, PersonDetailsDTO.class);
		return personDetailsDTO;
	}

	@Override
	public int getCountOfRecords() {
		return sessionFactory.getCurrentSession().createCriteria(PersonDetails.class).list().size();
	}

	@Override
	public List<PersonDetailsDTO> findAllPersonDetails() {
		List<PersonDetailsDTO> personDetialsDTOList = new ArrayList<PersonDetailsDTO>();
		List<PersonDetails> personDetailsDOList = sessionFactory.getCurrentSession().createCriteria(PersonDetails.class).list();
		ModelMapper modelMapper = new ModelMapper();
		for (PersonDetails personDetails : personDetailsDOList) {
			personDetialsDTOList.add(modelMapper.map(personDetails, PersonDetailsDTO.class));
		}
		return personDetialsDTOList;
	}

	@Override
	public boolean deletePersonDetailById(PersonDetailsDTO personDetailsDTO) {
		ModelMapper modelMapper = new ModelMapper();
		PersonDetails personDetails = modelMapper.map(personDetailsDTO, PersonDetails.class);
		sessionFactory.getCurrentSession().delete(personDetails);
		return true;
	}
	
}
