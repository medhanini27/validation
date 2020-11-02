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
	public void testAddUser() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-23");
		Contrat c=new Contrat(d,"temporaire",200);
		Contrat ContratAdded = us.addContract(c); 
		assertEquals(c.getTypeContrat(), ContratAdded.getTypeContrat());
	}
	@Test
	public void testupdateUser() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-23");
		Contrat c=new Contrat(d,"temporaire",200);
		Contrat ContratAdded = us.addContract(c); 
		assertEquals(c.getTypeContrat(), ContratAdded.getTypeContrat());
	}
	
	
}
