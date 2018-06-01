package in.codertechnologies.repository.dao;

import java.util.List;

import in.coderinfotech.batchschedule.BatchDetails;
import in.codertechnologies.batchSchedule.dto.BatchScheduleDTO;
import in.codertechnologies.batchSchedule.dto.CityMstDTO;
import in.codertechnologies.batchSchedule.dto.PaginationDetailsDTO;

public interface CityMstDAO {
	boolean insertCity(CityMstDTO cityMstDTO);
	
	CityMstDTO findCityMstById(CityMstDTO cityMstDTO);
	
	int getCountOfRecords();
	
	List<CityMstDTO>  findAllCityMst();
	
	boolean deleteCityMstById(CityMstDTO cityMstDTO);

	List getCityMstCodeList(PaginationDetailsDTO paginationDetailsDTO);
}
