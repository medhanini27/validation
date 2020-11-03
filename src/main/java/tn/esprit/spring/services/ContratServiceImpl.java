package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@Service
public class ContratServiceImpl implements IContratService {

	private static final Logger l = LogManager.getLogger(ContratServiceImpl.class);

	
	
	@Autowired
	ContratRepository contratRepository;


	public List<Contrat> getAllContrats() {
		return (List<Contrat>) contratRepository.findAll();
	}
	
	
	@Override
	public Contrat addContract(Contrat c) {
		l.info("In  add contract : " + c); 
		Contrat ContractSaved = null ;
		try {
			 ContractSaved = contratRepository.save(c);

		}
		catch (Exception e) {
			l.error("erreur in adding contrat "+e);
		}
		l.info("Out of  add contract. "); 
		return ContractSaved; 
	}
	
	
	@Override 
	public Contrat updateContrat(Contrat c) {
		return contratRepository.save(c);
	}

	@Override
	public void deleteContrat(int id) {
		contratRepository.deleteById(id);
	}

	@Override
	public Contrat retrieveContrat(int id) {
		l.info("in  retrieve Contrat id = " + id);
		Contrat c =  contratRepository.findById(id).orElse(null);
		l.info("Contrat returned : " + c);
		return c; 
	}
	
	

}
