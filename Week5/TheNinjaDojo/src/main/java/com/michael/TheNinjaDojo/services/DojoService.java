package com.michael.TheNinjaDojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.michael.TheNinjaDojo.models.Dojo;
import com.michael.TheNinjaDojo.repositories.DojoRepository;

@Service
public class DojoService {
	private final DojoRepository dojoRepo;

	public DojoService(DojoRepository dojoRepo) {
		this.dojoRepo = dojoRepo;
	}
	
	public Dojo findById(Long id) {
		Optional<Dojo> d = dojoRepo.findById(id);
		return d.isPresent()?d.get():null;
	}
	public List<Dojo> allDojos(){
		return dojoRepo.findAll();
	}
	
	public Dojo createDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	public Dojo updateDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	public void deleteDojo(Long id) {
		dojoRepo.deleteById(id);
	}
}