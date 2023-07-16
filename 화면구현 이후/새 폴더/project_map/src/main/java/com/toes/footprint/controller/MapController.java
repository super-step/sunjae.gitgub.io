package com.toes.footprint.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.toes.footprint.models.DistrictDto;
import com.toes.footprint.service.DistrictService;

@Controller
public class MapController {
	
	protected final DistrictService districtService;
	
	public MapController(DistrictService districtService) {
		this.districtService = districtService;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String home(Model model) {
		
		return "home";
	}
	
	@RequestMapping(value = "/detail" , method=RequestMethod.GET)
	public String detail_map(Model model, String name) {
		model.addAttribute("NAME", name);
		model.addAttribute("BODY", "DETAIL_MAP");
		return "home";
	}
	@RequestMapping(value = "/map" , method=RequestMethod.GET)
	public String API_map(Model model, String name) {
		model.addAttribute("name", name);
		model.addAttribute("BODY", "API_MAP");
		return "home";
	}
}
