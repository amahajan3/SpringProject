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
import in.codertechnologies.batchSchedule.dto.CityMstDTO;
import in.codertechnologies.batchSchedule.dto.PaginationDetailsDTO;
import in.codertechnologies.repository.dao.CityMstDAO;

@Repository("cityMstDAO")
@Transactional
@SuppressWarnings("unchecked")
public class CityMstDaoImpl implements CityMstDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean insertCity(CityMstDTO cityMstDTO) {
		ModelMapper modelMapper = new ModelMapper();
		CityMst cityMst = modelMapper.map(cityMstDTO, CityMst.class);
		sessionFactory.getCurrentSession().saveOrUpdate(cityMst);
		return true;
	}

	@Override
	public CityMstDTO findCityMstById(CityMstDTO cityMstDTO) {
		ModelMapper modelMapper = new ModelMapper();
		CityMst cityMst = (CityMst) sessionFactory.getCurrentSession().get(CityMst.class, cityMstDTO.getCityId());
		cityMstDTO = modelMapper.map(cityMst, CityMstDTO.class);
		return cityMstDTO;
	}

	@Override
	public int getCountOfRecords() {
		return sessionFactory.getCurrentSession().createCriteria(CityMst.class).list().size();
	}

	@Override
	public List<CityMstDTO> findAllCityMst() {
		List<CityMstDTO> cityMstDTOList = new ArrayList<CityMstDTO>();
		List<CityMst> cityMstDOList = sessionFactory.getCurrentSession().createCriteria(CityMst.class).list();
		ModelMapper modelMapper = new ModelMapper();
		for (CityMst cityMst : cityMstDOList) {
			cityMstDTOList.add(modelMapper.map(cityMst, CityMstDTO.class));
		}
		return cityMstDTOList;
	}

	@Override
	public boolean deleteCityMstById(CityMstDTO cityMstDTO) {
		ModelMapper modelMapper = new ModelMapper();
		CityMst cityMst = modelMapper.map(cityMstDTO, CityMst.class);
		sessionFactory.getCurrentSession().delete(cityMst);
		return true;
	}

	@Override
	public List getCityMstCodeList(PaginationDetailsDTO paginationDetailsDTO) {
		List cityMasterDTOList = new ArrayList();
		
			List cityMasterListDO = sessionFactory.getCurrentSession().createCriteria(CityMst.class)
								.add(Restrictions.or(Restrictions.like("cityName", paginationDetailsDTO.getSearchTerm()+"%"),Restrictions.like("cityCode", "%"+paginationDetailsDTO.getSearchTerm()+"%")))
								.setProjection(Projections.projectionList()
										.add(Projections.property("cityId"))
										.add(Projections.property("cityName"))
										.add(Projections.property("cityCode")))
								.setFirstResult(new Long((paginationDetailsDTO.getPageNo() - 1 )* paginationDetailsDTO.getPageSize()).intValue())
							    .setMaxResults(new Long(paginationDetailsDTO.getPageSize()).intValue())
							    .addOrder(Order.asc("cityCode"))
								.list();
			
			if(cityMasterListDO != null){
				if(cityMasterListDO.size() == paginationDetailsDTO.getPageSize()){
					paginationDetailsDTO.setMorePages(true);
				}else{
					paginationDetailsDTO.setMorePages(false);
				}
				paginationDetailsDTO.setTotalCount(cityMasterListDO.size());	
				
				for(Iterator iterator = cityMasterListDO.iterator();iterator.hasNext();) {
					Object[] cityMst = (Object[])iterator.next();
					CityMstDTO cityMstDTO = new CityMstDTO();
					cityMstDTO.setCityId(Long.valueOf(cityMst[0].toString()));
					cityMstDTO.setCityCode(cityMst[1].toString());
					cityMstDTO.setCityName(cityMst[2].toString());
					cityMasterDTOList.add(cityMstDTO);
				}
			}else{
				paginationDetailsDTO.setMorePages(false);
			}
			
		return cityMasterDTOList;
	}
	
	
	
}
