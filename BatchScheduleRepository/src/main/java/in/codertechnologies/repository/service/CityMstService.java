package in.codertechnologies.repository.service;

import java.util.List;

import in.codertechnologies.batchSchedule.dto.CityMstDTO;
import in.codertechnologies.batchSchedule.dto.PaginationDetailsDTO;

public interface CityMstService {

	boolean insertCity(CityMstDTO cityMstDTO);
	
	CityMstDTO findCityMstById(CityMstDTO cityMstDTO);
	
	int getCountOfRecords();
	
	List<CityMstDTO>  findAllCityMst();
	
	boolean deleteCityMstById(CityMstDTO cityMstDTO);

	List getCityMstCodeList(PaginationDetailsDTO paginationDetailsDTO);
}
