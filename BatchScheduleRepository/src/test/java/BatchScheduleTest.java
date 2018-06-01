import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.codertechnologies.repository.service.BatchScheduleService;

public class BatchScheduleTest {

	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-database.xml");
		BatchScheduleService batchScheduleService = applicationContext.getBean(BatchScheduleService.class);
		
		List baatchScheduleDTOList = batchScheduleService.findAllBatchSchedule();
		System.out.println(baatchScheduleDTOList.size());
	}
}
