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

import in.codertechnologies.batchSchedule.dto.CityMstDTO;
import in.codertechnologies.batchSchedule.dto.PaginationDetailsDTO;
import in.codertechnologies.batchSchedule.dto.SelectionDTO;
import in.codertechnologies.repository.service.CityMstService;

@Controller
@RequestMapping("/cityMstController")
public class CityMstController {

	@Autowired
	private CityMstService cityMstService;
	
	@RequestMapping(value="/showAdd",method=RequestMethod.GET)
	public String showAdd(Model model){
		model.addAttribute("cityMst",new CityMstDTO());
		return "createCityMst";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(@Valid @ModelAttribute("batchSchedule") CityMstDTO cityMstDTO ,
			BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			return "createCityMst";
		}
		boolean b = cityMstService.insertCity(cityMstDTO);
		return "redirect:/cityMst/added";	
	}

	@RequestMapping(value="/findById",method=RequestMethod.GET)
	public String findByScheduleById(@RequestParam int id , Model model) {
		CityMstDTO cityMstDTO =  new CityMstDTO();
		cityMstDTO.setCityId(id);

		cityMstDTO = cityMstService.findCityMstById(cityMstDTO);
		model.addAttribute("cityMstDTO", cityMstDTO);
		return "findByIdCityMst";
	}

	@RequestMapping(value="/findAllCityMst",method=RequestMethod.GET)
	public ModelAndView findAllCityMst(){
		Map<String, Object> model = new HashMap<String, Object>();
		List cityMstDTOList = cityMstService.findAllCityMst();
		model.put("cityMstDTOList",cityMstDTOList );
		int totalCount = cityMstService.getCountOfRecords();
		model.put("totalCount",totalCount );
		return new ModelAndView("findAllCityMst",model);
	}

	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(@RequestParam int id){
		CityMstDTO cityMstDTO =  new CityMstDTO();
		cityMstDTO.setCityId(id);
		boolean flag = cityMstService.deleteCityMstById(cityMstDTO);
		return "success";
	}

	@RequestMapping(value="/added",method=RequestMethod.GET)
	public String showAdd() {
		return "cityMst/success";
	}

	@RequestMapping(value="/selectCity",method=RequestMethod.POST)
	@ResponseBody
	public String getSelect2ListFromAjaxForCity(@RequestParam Long pageSize,@RequestParam Long page,@RequestParam String searchTerm){

		PaginationDetailsDTO paginationDetailsDTO = new PaginationDetailsDTO();
		paginationDetailsDTO.setPageSize(pageSize);
		paginationDetailsDTO.setPageNo(page);
		paginationDetailsDTO.setSearchTerm(searchTerm);

		List cityMstDTOList = cityMstService.getCityMstCodeList(paginationDetailsDTO);

		@SuppressWarnings("rawtypes")
		String jsonObj = getJsonDataForSelectTwo(cityMstDTOList,paginationDetailsDTO.isMorePages(),paginationDetailsDTO.getTotalCount(),paginationDetailsDTO.getPageNo());
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
