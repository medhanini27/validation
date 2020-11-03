package tn.esprit.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.IEntrepriseService;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;


@SpringBootTest
public class EntrepriseTest {
	@Autowired 
	IEntrepriseService us; 
	@Test
	public void testajouterEntreprise() throws ParseException {
		Entreprise c=new Entreprise("google","informatique");
		Entreprise EntrepriseAdded = us.ajouterEntreprise(c); 
		assertEquals(c.getRaisonSocial(), EntrepriseAdded.getRaisonSocial());
	}
	
	@Test
	public void testdeleteEntrepriseById() throws ParseException   {
		Entreprise E=new Entreprise("facebook","informatique");
		int x =E.getId();
		Entreprise E1= us.ajouterEntreprise(E);
		
		 us.deleteEntrepriseById(E1.getId());   
		 assertEquals(null, us.getEntrepriseById(E1.getId()));
	}
	
	@Test
	public void testgetEntrepriseById() throws ParseException   {
		Entreprise e=new Entreprise ("instagram","media");
		Entreprise EntrepriseAdded = us.ajouterEntreprise(e);
		Entreprise EntrepriseRetrived = us.getEntrepriseById(EntrepriseAdded.getId());
		assertEquals(EntrepriseAdded.getName(), EntrepriseRetrived.getName());
	}
}