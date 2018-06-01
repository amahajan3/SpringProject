package in.codertechnologies.repository.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import in.coderinfotech.batchschedule.CityMst;
import in.coderinfotech.batchschedule.StateMst;
import in.codertechnologies.batchSchedule.dto.CityMstDTO;
import in.codertechnologies.batchSchedule.dto.PaginationDetailsDTO;
import in.codertechnologies.batchSchedule.dto.StateMstDTO;
import in.codertechnologies.repository.dao.StateMstDAO;

@Repository("stateMstDAO")
@Transactional
@SuppressWarnings("unchecked")
public class StateMstDaoImpl implements StateMstDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean insertState(StateMstDTO stateMstDTO) {
		ModelMapper modelMapper = new ModelMapper();
		StateMst stateMst = modelMapper.map(stateMstDTO, StateMst.class);
		sessionFactory.getCurrentSession().saveOrUpdate(stateMst);
		return true;
	}

	@Override
	public StateMstDTO findStateMstById(StateMstDTO stateMstDTO) {
		ModelMapper modelMapper = new ModelMapper();
		StateMst stateMst = (StateMst) sessionFactory.getCurrentSession().get(StateMst.class, stateMstDTO.getStateId());
		stateMstDTO = modelMapper.map(stateMst, StateMstDTO.class);
		return stateMstDTO;
	}

	@Override
	public int getCountOfRecords() {
		return sessionFactory.getCurrentSession().createCriteria(StateMst.class).list().size();
	}

	@Override
	public List<StateMstDTO> findAllStateMst() {
		List<StateMstDTO> stateMstDTOList = new ArrayList<StateMstDTO>();
		List<StateMst> stateMstDOList = sessionFactory.getCurrentSession().createCriteria(StateMst.class).list();
		ModelMapper modelMapper = new ModelMapper();
		for (StateMst StateMst : stateMstDOList) {
			stateMstDTOList.add(modelMapper.map(StateMst, StateMstDTO.class));
		}
		return stateMstDTOList;
	}

	@Override
	public boolean deleteStateMstById(StateMstDTO stateMstDTO) {
		ModelMapper modelMapper = new ModelMapper();
		StateMst stateMst = modelMapper.map(stateMstDTO, StateMst.class);
		sessionFactory.getCurrentSession().delete(stateMst);
		return true;
	}
	
	@Override
	public List getStateMstCodeList(PaginationDetailsDTO paginationDetailsDTO) {
		List stateMstDTOList = new ArrayList();
		
			List StateMstListDO = sessionFactory.getCurrentSession().createCriteria(StateMst.class)
								.add(Restrictions.or(Restrictions.like("stateName", paginationDetailsDTO.getSearchTerm()+"%"),Restrictions.like("stateCode", "%"+paginationDetailsDTO.getSearchTerm()+"%")))
								.setProjection(Projections.projectionList()
										.add(Projections.property("stateId"))
										.add(Projections.property("stateName"))
										.add(Projections.property("stateCode")))
								.setFirstResult(new Long((paginationDetailsDTO.getPageNo() - 1 )* paginationDetailsDTO.getPageSize()).intValue())
							    .setMaxResults(new Long(paginationDetailsDTO.getPageSize()).intValue())
							    .addOrder(Order.asc("stateCode"))
								.list();
			
			if(StateMstListDO != null){
				if(StateMstListDO.size() == paginationDetailsDTO.getPageSize()){
					paginationDetailsDTO.setMorePages(true);
				}else{
					paginationDetailsDTO.setMorePages(false);
				}
				paginationDetailsDTO.setTotalCount(StateMstListDO.size());	
				
				for(Iterator iterator = StateMstListDO.iterator();iterator.hasNext();) {
					Object[] stateMst = (Object[])iterator.next();
					StateMstDTO stateMstDTO = new StateMstDTO();
					stateMstDTO.setStateId(Long.valueOf(stateMst[0].toString()));
					stateMstDTO.setStateName(stateMst[1].toString());
					stateMstDTO.setStateCode(stateMst[2].toString());
					stateMstDTOList.add(stateMstDTO);
				}
			}else{
				paginationDetailsDTO.setMorePages(false);
			}
			
		return stateMstDTOList;
	}
}
