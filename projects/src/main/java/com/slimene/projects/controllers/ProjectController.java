package com.slimene.projects.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.slimene.projects.entities.Departement;
import com.slimene.projects.entities.Project;
import com.slimene.projects.service.ProjectService;

import jakarta.validation.Valid;

@Controller
public class ProjectController {
	@Autowired
	ProjectService projectService;

	@RequestMapping("/listeProjects")
	public String listeProjects(ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "3") int size) {
		Page<Project> projs = projectService.getAllProjectsParPage(page, size);
		modelMap.addAttribute("projects", projs);
		modelMap.addAttribute("pages", new int[projs.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeProjects";

	}

	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap) {
		List<Departement> deps = projectService.getAllDepartements();
		modelMap.addAttribute("project", new Project());
		modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("departements", deps);
		return "formProject";
	}

	@RequestMapping("/saveProject")
	public String saveProduit(@Valid Project project, BindingResult bindingResult,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "3") int size) {
		if (bindingResult.hasErrors())
			return "formProject";
		int currentPage;
		boolean isNew = false;
		if (project.getIdProject() == null) // ajout
			isNew = true;

		projectService.saveProject(project);
		if (isNew) // ajout
		{
			Page<Project> prods = projectService.getAllProjectsParPage(page, size);
			currentPage = prods.getTotalPages() - 1;
		} else // modif
			currentPage = page;
		return ("redirect:/listeProjects?page=" + currentPage + "&size=" + size);
	}

	@RequestMapping("/supprimerProject")
	public String supprimerProject(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "3") int size) {
		projectService.deleteProjectById(id);
		Page<Project> projs = projectService.getAllProjectsParPage(page, size);
		modelMap.addAttribute("projects", projs);
		modelMap.addAttribute("pages", new int[projs.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeProjects";
	}

	@RequestMapping("/modifierProject")
	public String editerProject(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "3") int size) {
		List<Departement> deps = projectService.getAllDepartements();
		modelMap.addAttribute("mode", "edit");
		Project p = projectService.getProject(id);
		modelMap.addAttribute("project", p);
		modelMap.addAttribute("departements", deps);
		modelMap.addAttribute("page", page);
		modelMap.addAttribute("size", size);
		return "formProject";
	}

	@RequestMapping("/updateProject")
	public String updateProject(@ModelAttribute("project") Project produit, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {
		// conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateDeb = dateformat.parse(String.valueOf(date));
		produit.setDateDeb(dateDeb);

		projectService.updateProject(produit);
		List<Project> projs = projectService.getAllProjects();
		modelMap.addAttribute("projects", projs);
		return "listeProjects";
	}
}
