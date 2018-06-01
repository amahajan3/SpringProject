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

import in.codertechnologies.batchSchedule.dto.PersonDetailsDTO;
import in.codertechnologies.repository.service.PersonDetailsService;

@Controller
@RequestMapping("/personDetails")
@SuppressWarnings("unused")
public class PersonDetailsController {

	
	@Autowired
	private PersonDetailsService personDetailsService;
	
	@RequestMapping(value="/showAdd",method=RequestMethod.GET)
	public String showAdd(Model model){
		model.addAttribute("personDetailsDTO",new PersonDetailsDTO());
		return "createPersonDetails";
		
	}
	
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(@Valid @ModelAttribute("personDetailsDTO") PersonDetailsDTO personDetailsDTO ,
			BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			return "createPersonDetails";
		}
		
		boolean b = personDetailsService.insertPersonDetails(personDetailsDTO);
		b=b;
		System.out.println(b);
		return "redirect:/personInfo/added";	
	}
	
	@RequestMapping(value="/added",method=RequestMethod.GET)
	public String showAdd(){
		return "success";
	}
	
	@RequestMapping(value="/findById",method=RequestMethod.GET)
	public String findPersonDetailById(@RequestParam int id , Model model) {
		PersonDetailsDTO personDetailsDTO  =  new PersonDetailsDTO();
		personDetailsDTO.setPersonDetailsId(id);
		
		personDetailsDTO = personDetailsService.findPersonDetailById(personDetailsDTO);
		model.addAttribute("personDetailsDTO", personDetailsDTO);
		return "findByIdPersonDetails";
	}
	
	
	@RequestMapping(value="/findAllPersonDetails",method=RequestMethod.GET)
	public ModelAndView findAllPersonDetails(){
		Map<String, Object> model = new HashMap<String, Object>();
		List personDetailDTOList = personDetailsService.findAllPersonDetails();
		model.put("personDetailDTOList",personDetailDTOList );
		int totalCount = personDetailsService.getCountOfRecords();
		model.put("totalCount",totalCount );
		return new ModelAndView("findAllPersonDetails",model);
		
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(@RequestParam int id){
		PersonDetailsDTO personDetailsDTO  =  new PersonDetailsDTO();
		personDetailsDTO.setPersonDetailsId(id);
		boolean flag = personDetailsService.deletePersonDetailById(personDetailsDTO);
		return "success";
		
	}
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder ) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dataBinder.registerCustomEditor(Date.class, "dateOfBirth", new CustomDateEditor(dateFormat, false));
//		dataBinder.registerCustomEditor(Date.class, "endDate", new CustomDateEditor(dateFormat, false));
	}
	
}
