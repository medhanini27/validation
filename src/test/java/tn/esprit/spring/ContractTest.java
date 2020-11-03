package tn.esprit.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.services.IContratService;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

@SpringBootTest
public class ContractTest {

	@Autowired 
	IContratService us; 

	@Test
	public void testAddContrat() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-23");
		Contrat c=new Contrat(d,"temporaire",200);
		Contrat ContratAdded = us.addContract(c); 
		assertEquals(c.getTypeContrat(), ContratAdded.getTypeContrat());
	}

	
	
	@Test
	public void testretriveContrat() throws ParseException   {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-23");
		Contrat c=new Contrat(d,"temporaire",200);
		Contrat ContratAdded = us.addContract(c);
		Contrat ContratRetrived = us.retrieveContrat(c.getReference());
		assertEquals(ContratAdded.getTypeContrat(), ContratRetrived.getTypeContrat());
	}
	

	@Test
	public void testModifyContrat() throws ParseException   {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-23");
		Contrat c=new Contrat(d,"temporaire",200);
		us.addContract(c);
		Contrat ContratRetrived = us.retrieveContrat(c.getReference());
		float salaire=123;
		ContratRetrived.setSalaire(salaire);
		Contrat ContratUpdated  = us.updateContrat(c); 
		assertEquals(salaire, ContratUpdated.getSalaire());
	}
	
	@Test
	public void testDeleteContrat() throws ParseException   {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-23");
		Contrat c=new Contrat(d,"temporaire",200);
		us.addContract(c);
		
		 us.deleteContrat(c.getReference());   
		assertEquals(null, us.retrieveContrat(c.getReference()));
	}
	
	
	
	
}
