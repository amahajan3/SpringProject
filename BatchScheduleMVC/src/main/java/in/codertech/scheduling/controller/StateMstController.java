package in.codertech.scheduling.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import in.codertechnologies.batchSchedule.dto.PaginationDetailsDTO;
import in.codertechnologies.batchSchedule.dto.SelectionDTO;
import in.codertechnologies.batchSchedule.dto.StateMstDTO;
import in.codertechnologies.repository.service.StateMstService;

@Controller
@RequestMapping("/stateMstController")
public class StateMstController {

	@Autowired
	private StateMstService stateMstService;
	
	@RequestMapping(value="/showAdd",method=RequestMethod.GET)
	public String showAdd(Model model){
		model.addAttribute("stateMst",new StateMstDTO());
		return "createStateMst";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(@Valid @ModelAttribute("batchSchedule") StateMstDTO stateMstDTO ,
			BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			return "createStateMst";
		}
		boolean b = stateMstService.insertState(stateMstDTO);
		return "redirect:/stateMst/added";	
	}

	@RequestMapping(value="/findById",method=RequestMethod.GET)
	public String findStateMstById(@RequestParam int id , Model model) {
		StateMstDTO stateMstDTO =  new StateMstDTO();
		stateMstDTO.setStateId(id);

		stateMstDTO = stateMstService.findStateMstById(stateMstDTO);
		model.addAttribute("stateMstDTO", stateMstDTO);
		return "findByIdStateMst";
	}

	@RequestMapping(value="/findAllStateMst",method=RequestMethod.GET)
	public ModelAndView findAllStateMst(){
		Map<String, Object> model = new HashMap<String, Object>();
		List stateMstDTOList = stateMstService.findAllStateMst();
		model.put("stateMstDTOList",stateMstDTOList );
		int totalCount = stateMstService.getCountOfRecords();
		model.put("totalCount",totalCount );
		return new ModelAndView("findAllStateMst",model);
	}

	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(@RequestParam int id){
		StateMstDTO stateMstDTO =  new StateMstDTO();
		stateMstDTO.setStateId(id);
		boolean flag = stateMstService.deleteStateMstById(stateMstDTO);
		return "success";
	}

	@RequestMapping(value="/added",method=RequestMethod.GET)
	public String showAdd() {
		return "success";
	}

	@RequestMapping(value="/selectState",method=RequestMethod.POST)
	@ResponseBody
	public String getSelect2ListFromAjaxForState(@RequestParam Long pageSize,@RequestParam Long page,@RequestParam String searchTerm){

		PaginationDetailsDTO paginationDetailsDTO = new PaginationDetailsDTO();
		paginationDetailsDTO.setPageSize(pageSize);
		paginationDetailsDTO.setPageNo(page);
		paginationDetailsDTO.setSearchTerm(searchTerm);

		List stateMstDTOList = stateMstService.getStateMstCodeList(paginationDetailsDTO);

		@SuppressWarnings("rawtypes")
		String jsonObj = getJsonDataForSelectTwo(stateMstDTOList,paginationDetailsDTO.isMorePages(),paginationDetailsDTO.getTotalCount(),paginationDetailsDTO.getPageNo());
		return jsonObj;
	}
	
	public static String getJsonDataForSelectTwo(@SuppressWarnings("rawtypes") List list,boolean more,long totalCount,long pageNo) {
		String jsonStartDetail = "{\"result\":[";
		String returnString = "";
		int j = list.size() - 1;
		for (int i = 0; i < list.size(); i++) {
			returnString = returnString + "{\"id\":\"" +((SelectionDTO) list.get(i)).getValue() + "\", \"text\":\""
			+ ((SelectionDTO) list.get(i)).getLabel()+ "\"}";
			if (i!=j){
				returnString = returnString + ",";
			}
		}
		String jsonEndDetail = "],\"more\":"+more+", \"totalCount\":"+totalCount+", \"pageNo\":"+pageNo+"}";
		return jsonStartDetail+returnString+jsonEndDetail;
	}
}
