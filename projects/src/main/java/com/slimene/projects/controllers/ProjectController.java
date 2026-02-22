package com.slimene.projects.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.slimene.projects.entities.Project;
import com.slimene.projects.service.ProjectService;

@Controller
public class ProjectController {
	@Autowired
	ProjectService projectService;
	 @RequestMapping("/listeProjects")
	public String listeProjects(ModelMap modelMap, @RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "3") int size)
	{
		 Page<Project> projs = projectService.getAllProjectsParPage(page, size);
		 modelMap.addAttribute("projects", projs);
		  modelMap.addAttribute("pages", new int[projs.getTotalPages()]);
		 modelMap.addAttribute("currentPage", page);
		 return "listeProjects";
	
	}
	 @RequestMapping("/showCreate")
	public String showCreate()
	{
	return "createProject";
	}
	@RequestMapping("/saveProject")
	public String saveProject(@ModelAttribute("project") Project project,
	@RequestParam("date") String date,
	ModelMap modelMap) throws ParseException
	{
	//conversion de la date
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateDeb = dateformat.parse(String.valueOf(date));
	 project.setDateDeb(dateDeb);

	 Project saveProject = projectService.saveProject(project);
	String msg ="project enregistré avec Id "+saveProject.getIdProject();
	modelMap.addAttribute("msg", msg);
	return "createProduit";
	}
	 @RequestMapping("/supprimerProject")
	public String supprimerProject(@RequestParam("id") Long id,
	 ModelMap modelMap)
	{
	projectService.deleteProjectById(id);
	List<Project> prods = projectService.getAllProjects();
	modelMap.addAttribute("projects", prods);
	return "listeProjects";
	}

	 @RequestMapping("/modifierProject")
	public String editerProject(@RequestParam("id") Long id,
	 ModelMap modelMap)
	{
	Project p= projectService.getProject(id);
	modelMap.addAttribute("project", p);
	return "editerProject";
	}
	@RequestMapping("/updateProject")
	public String updateProject(@ModelAttribute("project") Project
	produit, @RequestParam("date") String date,
	 ModelMap modelMap) throws ParseException
	{
	//conversion de la date
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateDeb = dateformat.parse(String.valueOf(date));
	 produit.setDateDeb(dateDeb);

	 projectService.updateProject(produit);
	 List<Project> projs = projectService.getAllProjects();
	 modelMap.addAttribute("projects",projs);
	 return "listeProjects";
	 }
}
