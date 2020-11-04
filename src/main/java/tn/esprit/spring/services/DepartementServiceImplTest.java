package tn.esprit.spring.services;

import java.util.List;
import org.junit.Test;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.junit.Assert;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.repository.DepartementRepository;

@Service
public class DepartementServiceImplTest implements IDepartementService {


	@Autowired
	DepartementRepository deptRepoistory;
	private static final Logger logger = Logger.getLogger(EntrepriseServiceImpl.class);


	public List<Departement> getAllDepartements() {
		return (List<Departement>) deptRepoistory.findAll();
	}
	@Test
	public int ajouterDeptarment(Departement dept) {
		try {
			if(dept != null) {
				deptRepoistory.save(dept);
				logger.debug("departement saved");
				return dept.getId();
			}else {
				logger.error("null entreprise");
				return -1;
			}
		} catch (Exception e) 
		{
			logger.error("Erreur : " + e);
	    }
		logger.fatal("OUT FATAL");
		Assert.assertEquals(-1, this.ajouterDeptarment(dept));
		return -1;
	}
	//delete
	@Test
	public void deleteEntrepriseById(int deptId) {
		if(deptId != 0) {
			logger.info("deleted successfully");
			deptRepoistory.delete(deptRepoistory.findById(deptId).get());			
		}else {
			logger.error("error delete");
		}
	}
	
	@Test
	public void updateDeptById(int deptId) {
		if(deptId != 0) {
			logger.info("updated successfully");
			deptRepoistory.save(deptRepoistory.findById(deptId).get());			
		}else {
			logger.error("error update");
		}
	}
	



}
