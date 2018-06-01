package modelmapper;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.coderinfotech.batchschedule.StateMst;
import in.codertechnologies.batchSchedule.dto.StateMstDTO;
import in.codertechnologies.repository.service.BatchScheduleService;
import in.codertechnologies.repository.service.StateMstService;

public class DemoClass {
	@Autowired
	private SessionFactory sessionFactory;

	public boolean insertState(StateMst stateMst) {
		try {
		sessionFactory.getCurrentSession().save(stateMst);
		}catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-database.xml");
		StateMstService batchScheduleService = applicationContext.getBean(StateMstService.class);
		DemoClass class1 = new DemoClass();
		StateMstDTO stateMstDTO = new StateMstDTO();
		stateMstDTO.setStateCode("MH");
//		stateMstDTO.setStateId(2);
		stateMstDTO.setStateName("Maharashatra");
		batchScheduleService.insertState(stateMstDTO);
	}
}
