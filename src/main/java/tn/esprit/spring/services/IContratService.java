package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Contrat;


public interface IContratService {
	
	
	public List<Contrat> getAllContrats();
	public Contrat addContrat(Contrat c);
	public Contrat retrieveContrat(int id);
	public void deleteContrat(int id);
	public Contrat updateContrat(Contrat c);
	
	

	
}
