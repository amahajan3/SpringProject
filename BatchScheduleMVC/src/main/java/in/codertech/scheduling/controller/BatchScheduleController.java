package in.codertech.scheduling.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.codertechnologies.batchSchedule.dto.BatchScheduleDTO;
import in.codertechnologies.repository.service.BatchScheduleService;

@Controller
@RequestMapping("/batchSchedule")
public class BatchScheduleController {

	
	@Autowired
	private BatchScheduleService batchScheduleService;
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(@Valid @ModelAttribute("batchSchedule") BatchScheduleDTO batchScheduleDTO ,
			BindingResult bindingResult)
	{
		System.out.println(batchScheduleDTO.getStartDate() + "   "+ batchScheduleDTO.getEndDate());
		System.out.println("in save" +bindingResult);
		if(bindingResult.hasErrors()) {
//			model.addAttribute("batchSchedule",batchScheduleDTO);
			return "createBatchSchedule";
		}
		boolean b = batchScheduleService.insertBatchSchedule(batchScheduleDTO);
		return "redirect:/batchSchedule/added";	
	}
	
	@RequestMapping(value="/findById",method=RequestMethod.GET)
	public String findByScheduleById(@RequestParam int id , Model model) 
	{
		BatchScheduleDTO batchScheduleDTO =  new BatchScheduleDTO();
		batchScheduleDTO.setId(id);
		
	 batchScheduleDTO = batchScheduleService.findBatchScheduleById(batchScheduleDTO);
		model.addAttribute("batchScheduleDTO", batchScheduleDTO);
		return "findByIdBatchSchedule";
	}
	
	
	@RequestMapping(value="/showAdd",method=RequestMethod.GET)
	public String showAdd(Model model)
	{
		model.addAttribute("batchSchedule",new BatchScheduleDTO());
		return "createBatchSchedule";
		
	}
	
	@RequestMapping(value="/findAllBatchSchedule",method=RequestMethod.GET)
	public ModelAndView findAllBatchSchedule()
	{
		Map<String, Object> model = new HashMap<String, Object>();
		List batchScheduleDTOList = batchScheduleService.findAllBatchSchedule();
		model.put("batchScheduleDTOList",batchScheduleDTOList );
		int totalCount = batchScheduleService.getCountOfRecords();
		model.put("totalCount",totalCount );
		return new ModelAndView("findAllBatchSchedule",model);
		
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(@RequestParam int id)
	{
		BatchScheduleDTO batchScheduleDTO =  new BatchScheduleDTO();
		batchScheduleDTO.setId(id);
		boolean flag = batchScheduleService.deleteBatchScheduleById(batchScheduleDTO);
		return "success";
		
	}
	
	@RequestMapping(value="/added",method=RequestMethod.GET)
	public String showAdd()
	{
//		model.addAttribute("batchSchedule",new BatchScheduleDTO());
		return "batchSchedule/success";
		
	}
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder ) {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dataBinder.registerCustomEditor(Date.class, "startDate", new CustomDateEditor(dateFormat, false));
		dataBinder.registerCustomEditor(Date.class, "endDate", new CustomDateEditor(dateFormat, false));
	}
	
}
