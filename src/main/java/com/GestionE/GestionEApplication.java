package com.GestionE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.GestionE.dao.PersonneJpaRepo;
import com.GestionE.entites.Personne;

@SpringBootApplication
public class GestionEApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(GestionEApplication.class, args);
		
		PersonneJpaRepo personneInterface = ctx.getBean(PersonneJpaRepo.class);
		
		personneInterface.save(new Personne(202030,"conde","Aboubacar",23));
		personneInterface.save(new Personne(310010,"Camara","Saran",40));
		personneInterface.save(new Personne(210010,"Sylla","Fanta",23));
		personneInterface.save(new Personne(310010,"Camara22","Saran22",30));
		personneInterface.save(new Personne(210010,"conde","Mamadi",25));
		personneInterface.save(new Personne(310010,"kante","nouhan",25));
		personneInterface.save(new Personne(310010,"xxx","yyy",25));
		personneInterface.save(new Personne(210014,"Doumbouya","Mohamed",25));
		personneInterface.save(new Personne(310013,"Camara","Nouhan",26));
		personneInterface.save(new Personne(210022,"Sylla","Mamadi",21));
		personneInterface.save(new Personne(310032,"Traoré","Ousmane",23));
		personneInterface.save(new Personne(210042,"Mabe","Mamadi",25));
		personneInterface.save(new Personne(310050,"kante","Balla",30));
		personneInterface.save(new Personne(310060,"QQqq","PPPpp",25));
	}

}
