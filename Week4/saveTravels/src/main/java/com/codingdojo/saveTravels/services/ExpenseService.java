package com.codingdojo.saveTravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.saveTravels.models.Expense;
import com.codingdojo.saveTravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	
	private final ExpenseRepository expenseRepository;
	
	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}
	
	public List<Expense> allExpenses() {
		return expenseRepository.findAll();
	}
	
	public Optional<Expense> findById(Long id) {
		return expenseRepository.findById(id);
	}
	
	public Expense createExpense(Expense e) {
		return expenseRepository.save(e);
	}
	
	public Expense updateExpense(Expense e) {
		return expenseRepository.save(e);
	}
	
	public void deleteExpense(Long id) {
		expenseRepository.deleteById(id);
	}
}



