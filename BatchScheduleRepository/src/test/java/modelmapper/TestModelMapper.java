package modelmapper;

import java.util.Date;

import org.modelmapper.ModelMapper;

import in.coderinfotech.batchschedule.PersonDetails;
import in.codertechnologies.batchSchedule.dto.AcademicDetailsDTO;
import in.codertechnologies.batchSchedule.dto.CityMstDTO;
import in.codertechnologies.batchSchedule.dto.PersonDetailsDTO;
import in.codertechnologies.batchSchedule.dto.StateMstDTO;

public class TestModelMapper {

	public static void main(String[] args) {
		
		
		PersonDetailsDTO personDetailsDTO = new PersonDetailsDTO();
		personDetailsDTO.setAddressLine1("setAddressLine1");
		personDetailsDTO.setAddressLine2("setAddressLine2");
		personDetailsDTO.setAadhaarCardApplicable('Y');
		personDetailsDTO.setAadhaarCardNo("dadsdan");
		personDetailsDTO.setCreatedDate(new Date());
		personDetailsDTO.setDateOfBirth(new Date());
		personDetailsDTO.setDistrict("district");
		personDetailsDTO.setEmailId("email id");
		personDetailsDTO.setFatherName("FatherName");
		personDetailsDTO.setFirstName("firstname");
		personDetailsDTO.setGender('M');
		personDetailsDTO.setIsActive('N');
		personDetailsDTO.setLastName("lastName");
		personDetailsDTO.setMobileNo("mobile num");
		personDetailsDTO.setModifiedDate(new Date());
		personDetailsDTO.setMotherName("mother Name");
		personDetailsDTO.setPassword("password");
		personDetailsDTO.setPersonDetailsId(1);
		personDetailsDTO.setPinCode(new Long("4154564646"));
		personDetailsDTO.setProfile('S');
		
		StateMstDTO stateMstDTO = new StateMstDTO();
		stateMstDTO.setStateId(1);
		personDetailsDTO.setStateMstDTO(stateMstDTO);
		
		CityMstDTO cityTownDTO = new CityMstDTO();
		cityTownDTO.setCityId(2);
		personDetailsDTO.setCityMstDTO(cityTownDTO);
		
		AcademicDetailsDTO academicDetailsDTO = new AcademicDetailsDTO();
		academicDetailsDTO.setAcademicDetailsId(5);
		personDetailsDTO.setDetailsDTO(academicDetailsDTO);
		
		
		ModelMapper modelMapper = new ModelMapper();
		PersonDetails details = modelMapper.map(personDetailsDTO, PersonDetails.class);
		
		System.out.println(details);
	}
}
