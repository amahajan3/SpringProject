package in.codertechnologies.repository.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.codertechnologies.batchSchedule.dto.CityMstDTO;
import in.codertechnologies.batchSchedule.dto.PaginationDetailsDTO;
import in.codertechnologies.batchSchedule.dto.SelectionDTO;
import in.codertechnologies.repository.dao.CityMstDAO;
import in.codertechnologies.repository.service.CityMstService;

@Service("cityMstService")
public class CityMstServiceImpl implements CityMstService{

	@Autowired
	private CityMstDAO cityMstDAO;

	@Override
	public boolean insertCity(CityMstDTO cityMstDTO) {
		return cityMstDAO.insertCity(cityMstDTO);
	}

	@Override
	public CityMstDTO findCityMstById(CityMstDTO cityMstDTO)  {
		return cityMstDAO.findCityMstById(cityMstDTO);
	}

	@Override
	public int getCountOfRecords() {
		return cityMstDAO.getCountOfRecords();
	}

	@Override
	public List<CityMstDTO> findAllCityMst() {

		return cityMstDAO.findAllCityMst();
	}

	@Override
	public boolean deleteCityMstById(CityMstDTO cityMstDTO) {
		return cityMstDAO.deleteCityMstById(cityMstDTO);
	}

	@Override
	public List getCityMstCodeList(PaginationDetailsDTO paginationDetailsDTO) {
		List popUpDataArrayList= new ArrayList();;
		List<CityMstDTO> cityMstList = cityMstDAO.getCityMstCodeList(paginationDetailsDTO);
		if((cityMstList) != null){

			for (CityMstDTO cityMstDTO : cityMstList) {
				SelectionDTO selectionDTO = new SelectionDTO();
				selectionDTO.setLabel(cityMstDTO.getCityCode()+" -- "+cityMstDTO.getCityName());
				selectionDTO.setValue(""+(cityMstDTO.getCityId()));
				popUpDataArrayList.add(selectionDTO);
			}

			Collections.sort(popUpDataArrayList,OPTION_DTO);
		}
		return popUpDataArrayList;
	}

	public Comparator OPTION_DTO = new Comparator() {
		public int compare(Object optDTO1,Object optDTO2) {
			return ((SelectionDTO)optDTO1).getLabel().compareTo(((SelectionDTO)optDTO2).getLabel());

		}
	};


}
