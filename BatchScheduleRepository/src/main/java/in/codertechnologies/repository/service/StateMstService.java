package in.codertechnologies.repository.service;

import java.util.List;

import in.codertechnologies.batchSchedule.dto.PaginationDetailsDTO;
import in.codertechnologies.batchSchedule.dto.StateMstDTO;

public interface StateMstService {

	boolean insertState(StateMstDTO stateMstDTO);
	
	StateMstDTO findStateMstById(StateMstDTO stateMstDTO);
	
	int getCountOfRecords();
	
	List<StateMstDTO>  findAllStateMst();
	
	boolean deleteStateMstById(StateMstDTO stateMstDTO);

	List getStateMstCodeList(PaginationDetailsDTO paginationDetailsDTO);
}
