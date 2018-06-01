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
import in.codertechnologies.batchSchedule.dto.StateMstDTO;
import in.codertechnologies.repository.dao.StateMstDAO;
import in.codertechnologies.repository.service.StateMstService;

@Service("stateMstService")
public class StateMstServiceImpl implements StateMstService{

	@Autowired
	private StateMstDAO stateMstDAO;

	@Override
	public boolean insertState(StateMstDTO StateMstDTO) {
		return stateMstDAO.insertState(StateMstDTO);
	}

	@Override
	public StateMstDTO findStateMstById(StateMstDTO StateMstDTO)  {
		return stateMstDAO.findStateMstById(StateMstDTO);
	}

	@Override
	public int getCountOfRecords() {
		return stateMstDAO.getCountOfRecords();
	}

	@Override
	public List<StateMstDTO> findAllStateMst() {
		
		return stateMstDAO.findAllStateMst();
	}

	@Override
	public boolean deleteStateMstById(StateMstDTO StateMstDTO) {
		return stateMstDAO.deleteStateMstById(StateMstDTO);
	}

	@Override
	public List getStateMstCodeList(PaginationDetailsDTO paginationDetailsDTO) {
		List popUpDataArrayList= new ArrayList();;
		List<StateMstDTO> stateMstDTOList = stateMstDAO.getStateMstCodeList(paginationDetailsDTO);
		if((stateMstDTOList) != null){

			for (StateMstDTO stateMstDTO : stateMstDTOList) {
				SelectionDTO selectionDTO = new SelectionDTO();
				selectionDTO.setLabel(stateMstDTO.getStateCode()+" -- "+stateMstDTO.getStateName());
				selectionDTO.setValue(""+(stateMstDTO.getStateId()));
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
