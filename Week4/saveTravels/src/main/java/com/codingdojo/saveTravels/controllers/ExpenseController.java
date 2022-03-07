package com.codingdojo.saveTravels.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.saveTravels.models.Expense;
import com.codingdojo.saveTravels.services.ExpenseService;

@Controller
public class ExpenseController {
	
	private final ExpenseService expenseService;
		
	public ExpenseController(ExpenseService expenseService) {
	this.expenseService = expenseService;
	}
	
	@GetMapping("/expenses")
	
public String index(Model model ) {
		List<Expense> items = expenseService.allExpenses();
		model.addAttribute("items", items);
		
		if (model.getAttribute("expense") == null) {
			model.addAttribute("expense", new Expense());
		}
		return "travel/index.jsp";
	}
	
	@PostMapping("/process/create")
	public String create(@Valid @ModelAttribute ("expense") Expense e, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Expense> items = expenseService.allExpenses();
			model.addAttribute("items", items);
			return"/travel/index.jsp";
		} else {
			expenseService.createExpense(e);
			return "redirect:/expenses";
		}
	}
	
 	@GetMapping("/expenses/edit/{id}")
 	public String edit(@PathVariable Long id, Model model) {
 		
 		Optional<Expense> e = expenseService.findById(id);
 		
 		if(e.isPresent()) {
 			model.addAttribute("expense", e.get());
 			return "/travel/edit/jsp";
 		} else {
 			System.out.println("error");
 			return "redirect:/expenses";
 		}
 	}
 	
 	@PutMapping("process/update/{id}")
 	public String update (@Valid @ModelAttribute("expense") Expense e, BindingResult result) {
 		if(result.hasErrors()) {
 			return "/travel/edit.jsp";
 		} else {
 			 expenseService.updateExpense(e);
 			 return "redirect:/expenses";
 		}
 	}
 		
 	@DeleteMapping("/expenses/delete/{id}")
 	public String deleteExpense(@PathVariable Long id) {
 		expenseService.deleteExpense(id);
 		return "redirect:/expenses";
 	}
 	
 	@GetMapping("/expenses/{id}")
    public String show(@PathVariable Long id, Model model) {
        Optional<Expense> e = expenseService.findById(id);
        
        if(e.isPresent()) {
        	model.addAttribute("item", e.get());
        	return "/travel/show.jsp";
        } else {
        	System.out.println("error");
        	
        	return "redirect:/expenses";
        }	
 	}
}
