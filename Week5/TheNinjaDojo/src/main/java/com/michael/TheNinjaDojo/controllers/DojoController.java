package com.michael.TheNinjaDojo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.michael.TheNinjaDojo.models.Dojo;
import com.michael.TheNinjaDojo.models.Ninja;
import com.michael.TheNinjaDojo.services.DojoService;
import com.michael.TheNinjaDojo.services.NinjaService;

@Controller
public class DojoController {
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	
	public DojoController(DojoService dojoService, NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}
	
	@GetMapping("/")
	public String index(Model model) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		return "index.jsp";
	}
	@GetMapping("/dojos/new")
	public String newDojo(Model model) {
		model.addAttribute("dojo", new Dojo());
		return "newDojo.jsp";
	}
	@PostMapping("/dojos/create")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result){
		if(result.hasErrors()) {
			return "redirect:/dojos/new";
		} else {
			dojoService.createDojo(dojo);
			return "redirect:/";
		}
		
	}
	@GetMapping("/dojos/{id}")
	public String showDojo(@PathVariable Long id, Model model) {
		Dojo dojo = dojoService.findById(id);
		model.addAttribute("dojo", dojo);
		return "show.jsp";
	}
	
	@DeleteMapping("/dojos/delete/{id}")
	public String deleteDojo(@PathVariable Long id) {
		//relational
		Dojo dojo =dojoService.findById(id);
		ninjaService.deleteNinjas(dojo.getNinjas());
		dojoService.deleteDojo(id);
		return "redirect:/";
	}
	@GetMapping("/ninjas/new")
	public String newNinja(Model model) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("ninja", new Ninja());
		model.addAttribute("dojos", dojos);
		return "newNinja.jsp";
	}
	
	@PostMapping("/ninjas/create")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/ninjas/new";
		} else {
			ninjaService.createNinja(ninja);
			return "redirect:/"; //todo : return to that dojo?
		}
	}
	@DeleteMapping("ninjas/delete/{id}")
	public String deleteNinja(@PathVariable Long id) {
		Ninja ninja = ninjaService.findById(id);
		if (ninja !=null) {
			Dojo dojo = ninja.getDojo();
			ninjaService.deleteNinja(id);
			return "redirect:/dojos/"+dojo.getId();
		} else {
			return "redirect:/";
		}
		
	}
	
}
