package in.codertechnologies.repository.dao;

import java.util.List;

import in.codertechnologies.batchSchedule.dto.PaginationDetailsDTO;
import in.codertechnologies.batchSchedule.dto.StateMstDTO;

public interface StateMstDAO {
	boolean insertState(StateMstDTO stateMstDTO);
	
	StateMstDTO findStateMstById(StateMstDTO stateMstDTO);
	
	int getCountOfRecords();
	
	List<StateMstDTO>  findAllStateMst();
	
	boolean deleteStateMstById(StateMstDTO stateMstDTO);

	List<StateMstDTO> getStateMstCodeList(PaginationDetailsDTO paginationDetailsDTO);
}
