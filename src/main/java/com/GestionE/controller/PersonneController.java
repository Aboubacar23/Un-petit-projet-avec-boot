package com.GestionE.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;

import com.GestionE.dao.PersonneJpaRepo;
import com.GestionE.entites.Personne;

@Controller
@RequestMapping(value="/personne")
public class PersonneController {
	
	@Autowired
	private PersonneJpaRepo personneJpaRepo;
	
	/*
	 *  la methode index pour envoyer la liste de toutes les personne
	 *  en envoyant la pagination 
	 *  et la recherche d'une personne
	 */
	
	@RequestMapping(value="index")
	public String index(Model model,
			@RequestParam(name="page",defaultValue = "0") int p,
			@RequestParam(name="motCle",defaultValue = "")String mc) 
	{
		
		Page<Personne> personnes = personneJpaRepo.chercherPersonnes("%"+mc+"%", PageRequest.of(p, 5));
		
		//chercher le nombre de page
		
		int pageCount = personnes.getTotalPages();
		
		//creer un tableau des pages à afficher
		
		int [] pages = new int[pageCount];
		
		for (int i=0;i<pageCount;i++ )
		{
			pages[i] =i;
		}
		
		//envoyer les attributs dans la view
		
		model.addAttribute("pages",pages);
		model.addAttribute("pageCourante", p);
		model.addAttribute("pagePersonnes", personnes);
		model.addAttribute("motCle", mc);
		
		return "index";
	}
	
	/*
	 * envoyer le contenu du formulaire d'ajout
	 */
	
	@RequestMapping(value="/ajouter", method = RequestMethod.GET)
	public String Ajouter(Model model)
	{
		model.addAttribute("personne", new Personne());
		return "add";
	}
	
	/*
	 * ajouter une personne dans la base de donnée
	 */
	
	@RequestMapping(value="savePersonne", method = RequestMethod.POST)
	public String save(@Validated Personne personne,BindingResult bindingResult)
	{
		if(bindingResult.hasErrors())
		{
			return "index";
		}
		personneJpaRepo.save(personne);
		return "redirect:index";
		
		
	}
	
	/*
	 * modifer une personne
	 * chercher la personne
	 * et envoyer ces données pour la modification
	 */
	
	@RequestMapping(value="/modifier")
	public String modifier(long id, Model model)
	{
		
		Personne pers=personneJpaRepo.getOne(id);
		model.addAttribute("personne",pers);
		return "edit";
	}
	
	/*
	 * modifer une personne
	 * envoyer les champs modifier
	 */
	
	@RequestMapping(value="/editPersonne", method=RequestMethod.POST)
	public String edit(@Validated Personne personne, BindingResult bind) {
		
		if(bind.hasErrors())
		{
			return "edit";
		}
		personneJpaRepo.save(personne);
	
		return "redirect:index";
	}
	
	/*
	 * supprimer un personne
	 */
	@RequestMapping(value="/supprimer")
	public String supprimer(long id)
	{
		personneJpaRepo.deleteById(id);
		
		return "redirect:index";
	}
	

}
