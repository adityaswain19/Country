package tech.csm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tech.csm.model.Block;
import tech.csm.model.Citizen;
import tech.csm.model.Panchayat;
import tech.csm.model.State;
import tech.csm.model.Village;
import tech.csm.service.BlockService;
import tech.csm.service.CitizenService;
import tech.csm.service.PanchayatService;
import tech.csm.service.StateService;
import tech.csm.service.VillageService;

@Controller
public class MainController {

	@Autowired
	private StateService stateService;
	
	@Autowired
	private BlockService blockService;
	
	@Autowired
	private PanchayatService panchayatService;
	
	@Autowired
	private VillageService villageService;
	
	@Autowired
	private CitizenService citizenService;
	
	
	@GetMapping("/get-country-form")
	public String getCountryForm(Model model) {

		model.addAttribute("states",stateService.getAllStates());
		model.addAttribute("citizens", citizenService.getAllCitizens());
		
		return "info";
	}
	
//	@GetMapping("/get-country-form")
//	public String getCountryForm(Model model) {
//
//	    model.addAttribute("states", stateService.getAllStates());
//	    model.addAttribute("citizens", citizenService.getAllCitizens());
//	    model.addAttribute("citizen", new Citizen());  // big fix
//
//	    return "info";
//	}

	
	@GetMapping("/block-by-state-id")
	@ResponseBody
	public List<Block> BlockByStateId(@RequestParam ("sId") Integer stateId){
		 List<Block> b=blockService.getBlockByStateId(stateId);
		return b;
	}
	
	@GetMapping("/panchayat-by-block-id")
	@ResponseBody
	public List<Panchayat> PanchayatByBlockId(@RequestParam ("bId") Integer blockId){
		
		return  panchayatService.getPanchayatByBlockId(blockId);
	}
	
	
	@GetMapping("/village-by-panchayat-id")
	@ResponseBody
	public List<Village> villageByPanchayatId(@RequestParam ("pId") Integer panchayatId){
		
		return  villageService.getVillageByPanchayatId(panchayatId);
	}
	
	@PostMapping("/save-citizen")
	public String saveCitizen(@ModelAttribute Citizen citizen, RedirectAttributes rd) {
		
		
		Citizen c=citizenService.saveCitizen(citizen);
		
		String msg="Citizen saved with id : "+c.getId();
		rd.addFlashAttribute("msg", msg);
		
		return "redirect:./get-country-form";
	}
	
	@GetMapping("/delete-citizen")
	public String deleteCitizenById(@RequestParam("cId") Integer citizenId, RedirectAttributes rd) {
		String msg= citizenService.deleteCitizenById(citizenId);
		rd.addFlashAttribute("msg", msg);
		return "redirect:./get-country-form";
	}
	
	@GetMapping("/update-citizen")
	public String updateCitizenById(@RequestParam("cId") Integer citizenId, Model model) {
		
		Citizen c=citizenService.getCitizenById(citizenId);
		model.addAttribute("citizen", c);

		model.addAttribute("blocks", blockService.getBlockByStateId(c.getVillage().getPanchayat().getBlock().getState().getId()));
		model.addAttribute("panchayats", panchayatService.getPanchayatByBlockId(c.getVillage().getPanchayat().getBlock().getId()));
		model.addAttribute("villages", villageService.getVillageByPanchayatId(c.getVillage().getPanchayat().getId()));
		
		return "forward:get-country-form";
	}
	
//	@GetMapping("/update-citizen")
//	public String updateCitizenById(@RequestParam("cId") Integer citizenId, Model model) {
//
//	    Citizen c = citizenService.getCitizenById(citizenId);
//	    model.addAttribute("citizen", c);
//	    model.addAttribute("states", stateService.getAllStates());
//
//	    model.addAttribute("blocks",
//	        blockService.getBlockByStateId(c.getVillage().getPanchayat().getBlock().getState().getId()));
//
//	    model.addAttribute("panchayats",
//	        panchayatService.getPanchayatByBlockId(c.getVillage().getPanchayat().getBlock().getId()));
//
//	    model.addAttribute("villages",
//	        villageService.getVillageByPanchayatId(c.getVillage().getPanchayat().getId()));
//
//	    return "forward:get-country-form";
//	}

	
}
